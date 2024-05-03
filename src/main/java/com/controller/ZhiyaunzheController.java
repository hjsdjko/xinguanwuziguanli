
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 自愿者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiyaunzhe")
public class ZhiyaunzheController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiyaunzheController.class);

    private static final String TABLE_NAME = "zhiyaunzhe";

    @Autowired
    private ZhiyaunzheService zhiyaunzheService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private LingyongguihuanService lingyongguihuanService;//物资领用归还
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private WuziService wuziService;//物资
    @Autowired
    private WuzicaigouService wuzicaigouService;//物资采购
    @Autowired
    private WuzidiaopeiService wuzidiaopeiService;//物资调配
    @Autowired
    private WuzijuanzengService wuzijuanzengService;//物资捐赠
    @Autowired
    private WuzipaifaService wuzipaifaService;//物资派发
    @Autowired
    private XiaoquguanliService xiaoquguanliService;//小区管理员
    @Autowired
    private XuqiutongjiService xuqiutongjiService;//需求收集
    @Autowired
    private YonghuService yonghuService;//采购员
    @Autowired
    private ZhiyuanzhepaiqianService zhiyuanzhepaiqianService;//志愿者调派
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("采购员".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("小区管理员".equals(role))
            params.put("xiaoquguanliId",request.getSession().getAttribute("userId"));
        params.put("zhiyaunzheDeleteStart",1);params.put("zhiyaunzheDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zhiyaunzheService.queryPage(params);

        //字典表数据转换
        List<ZhiyaunzheView> list =(List<ZhiyaunzheView>)page.getList();
        for(ZhiyaunzheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhiyaunzheEntity zhiyaunzhe = zhiyaunzheService.selectById(id);
        if(zhiyaunzhe !=null){
            //entity转view
            ZhiyaunzheView view = new ZhiyaunzheView();
            BeanUtils.copyProperties( zhiyaunzhe , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyaunzheEntity zhiyaunzhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiyaunzhe:{}",this.getClass().getName(),zhiyaunzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhiyaunzheEntity> queryWrapper = new EntityWrapper<ZhiyaunzheEntity>()
            .eq("zhiyaunzhe_name", zhiyaunzhe.getZhiyaunzheName())
            .eq("zhiyaunzhe_phone", zhiyaunzhe.getZhiyaunzhePhone())
            .eq("zhiyaunzhe_id_number", zhiyaunzhe.getZhiyaunzheIdNumber())
            .eq("zhiyaunzhe_email", zhiyaunzhe.getZhiyaunzheEmail())
            .eq("zhiyaunzhe_address", zhiyaunzhe.getZhiyaunzheAddress())
            .eq("sex_types", zhiyaunzhe.getSexTypes())
            .eq("zhiyaunzhe_delete", zhiyaunzhe.getZhiyaunzheDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiyaunzheEntity zhiyaunzheEntity = zhiyaunzheService.selectOne(queryWrapper);
        if(zhiyaunzheEntity==null){
            zhiyaunzhe.setZhiyaunzheDelete(1);
            zhiyaunzhe.setCreateTime(new Date());
            zhiyaunzheService.insert(zhiyaunzhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiyaunzheEntity zhiyaunzhe, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhiyaunzhe:{}",this.getClass().getName(),zhiyaunzhe.toString());
        ZhiyaunzheEntity oldZhiyaunzheEntity = zhiyaunzheService.selectById(zhiyaunzhe.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhiyaunzhe.getZhiyaunzhePhoto()) || "null".equals(zhiyaunzhe.getZhiyaunzhePhoto())){
                zhiyaunzhe.setZhiyaunzhePhoto(null);
        }

            zhiyaunzheService.updateById(zhiyaunzhe);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhiyaunzheEntity> oldZhiyaunzheList =zhiyaunzheService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZhiyaunzheEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZhiyaunzheEntity zhiyaunzheEntity = new ZhiyaunzheEntity();
            zhiyaunzheEntity.setId(id);
            zhiyaunzheEntity.setZhiyaunzheDelete(2);
            list.add(zhiyaunzheEntity);
        }
        if(list != null && list.size() >0){
            zhiyaunzheService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ZhiyaunzheEntity> zhiyaunzheList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhiyaunzheEntity zhiyaunzheEntity = new ZhiyaunzheEntity();
//                            zhiyaunzheEntity.setZhiyaunzheName(data.get(0));                    //自愿者姓名 要改的
//                            zhiyaunzheEntity.setZhiyaunzhePhoto("");//详情和图片
//                            zhiyaunzheEntity.setZhiyaunzhePhone(data.get(0));                    //自愿者联系方式 要改的
//                            zhiyaunzheEntity.setZhiyaunzheIdNumber(data.get(0));                    //自愿者身份证号 要改的
//                            zhiyaunzheEntity.setZhiyaunzheEmail(data.get(0));                    //邮箱 要改的
//                            zhiyaunzheEntity.setZhiyaunzheAddress(data.get(0));                    //住址 要改的
//                            zhiyaunzheEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zhiyaunzheEntity.setZhiyaunzheContent("");//详情和图片
//                            zhiyaunzheEntity.setZhiyaunzheDelete(1);//逻辑删除字段
//                            zhiyaunzheEntity.setCreateTime(date);//时间
                            zhiyaunzheList.add(zhiyaunzheEntity);


                            //把要查询是否重复的字段放入map中
                                //自愿者联系方式
                                if(seachFields.containsKey("zhiyaunzhePhone")){
                                    List<String> zhiyaunzhePhone = seachFields.get("zhiyaunzhePhone");
                                    zhiyaunzhePhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiyaunzhePhone = new ArrayList<>();
                                    zhiyaunzhePhone.add(data.get(0));//要改的
                                    seachFields.put("zhiyaunzhePhone",zhiyaunzhePhone);
                                }
                                //自愿者身份证号
                                if(seachFields.containsKey("zhiyaunzheIdNumber")){
                                    List<String> zhiyaunzheIdNumber = seachFields.get("zhiyaunzheIdNumber");
                                    zhiyaunzheIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiyaunzheIdNumber = new ArrayList<>();
                                    zhiyaunzheIdNumber.add(data.get(0));//要改的
                                    seachFields.put("zhiyaunzheIdNumber",zhiyaunzheIdNumber);
                                }
                        }

                        //查询是否重复
                         //自愿者联系方式
                        List<ZhiyaunzheEntity> zhiyaunzheEntities_zhiyaunzhePhone = zhiyaunzheService.selectList(new EntityWrapper<ZhiyaunzheEntity>().in("zhiyaunzhe_phone", seachFields.get("zhiyaunzhePhone")).eq("zhiyaunzhe_delete", 1));
                        if(zhiyaunzheEntities_zhiyaunzhePhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyaunzheEntity s:zhiyaunzheEntities_zhiyaunzhePhone){
                                repeatFields.add(s.getZhiyaunzhePhone());
                            }
                            return R.error(511,"数据库的该表中的 [自愿者联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //自愿者身份证号
                        List<ZhiyaunzheEntity> zhiyaunzheEntities_zhiyaunzheIdNumber = zhiyaunzheService.selectList(new EntityWrapper<ZhiyaunzheEntity>().in("zhiyaunzhe_id_number", seachFields.get("zhiyaunzheIdNumber")).eq("zhiyaunzhe_delete", 1));
                        if(zhiyaunzheEntities_zhiyaunzheIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyaunzheEntity s:zhiyaunzheEntities_zhiyaunzheIdNumber){
                                repeatFields.add(s.getZhiyaunzheIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [自愿者身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhiyaunzheService.insertBatch(zhiyaunzheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

