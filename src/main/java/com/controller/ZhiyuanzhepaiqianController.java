
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
 * 志愿者调派
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiyuanzhepaiqian")
public class ZhiyuanzhepaiqianController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiyuanzhepaiqianController.class);

    private static final String TABLE_NAME = "zhiyuanzhepaiqian";

    @Autowired
    private ZhiyuanzhepaiqianService zhiyuanzhepaiqianService;


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
    private ZhiyaunzheService zhiyaunzheService;//自愿者
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
        CommonUtil.checkMap(params);
        PageUtils page = zhiyuanzhepaiqianService.queryPage(params);

        //字典表数据转换
        List<ZhiyuanzhepaiqianView> list =(List<ZhiyuanzhepaiqianView>)page.getList();
        for(ZhiyuanzhepaiqianView c:list){
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
        ZhiyuanzhepaiqianEntity zhiyuanzhepaiqian = zhiyuanzhepaiqianService.selectById(id);
        if(zhiyuanzhepaiqian !=null){
            //entity转view
            ZhiyuanzhepaiqianView view = new ZhiyuanzhepaiqianView();
            BeanUtils.copyProperties( zhiyuanzhepaiqian , view );//把实体数据重构到view中
            //级联表 自愿者
            //级联表
            ZhiyaunzheEntity zhiyaunzhe = zhiyaunzheService.selectById(zhiyuanzhepaiqian.getZhiyaunzheId());
            if(zhiyaunzhe != null){
            BeanUtils.copyProperties( zhiyaunzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhiyaunzheId(zhiyaunzhe.getId());
            }
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
    public R save(@RequestBody ZhiyuanzhepaiqianEntity zhiyuanzhepaiqian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiyuanzhepaiqian:{}",this.getClass().getName(),zhiyuanzhepaiqian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhiyuanzhepaiqianEntity> queryWrapper = new EntityWrapper<ZhiyuanzhepaiqianEntity>()
            .eq("zhiyuanzhepaiqian_name", zhiyuanzhepaiqian.getZhiyuanzhepaiqianName())
            .eq("zhiyuanzhepaiqian_types", zhiyuanzhepaiqian.getZhiyuanzhepaiqianTypes())
            .eq("zhiyaunzhe_id", zhiyuanzhepaiqian.getZhiyaunzheId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiyuanzhepaiqianEntity zhiyuanzhepaiqianEntity = zhiyuanzhepaiqianService.selectOne(queryWrapper);
        if(zhiyuanzhepaiqianEntity==null){
            zhiyuanzhepaiqian.setInsertTime(new Date());
            zhiyuanzhepaiqian.setCreateTime(new Date());
            zhiyuanzhepaiqianService.insert(zhiyuanzhepaiqian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiyuanzhepaiqianEntity zhiyuanzhepaiqian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhiyuanzhepaiqian:{}",this.getClass().getName(),zhiyuanzhepaiqian.toString());
        ZhiyuanzhepaiqianEntity oldZhiyuanzhepaiqianEntity = zhiyuanzhepaiqianService.selectById(zhiyuanzhepaiqian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhiyuanzhepaiqian.getZhiyuanzhepaiqianPhoto()) || "null".equals(zhiyuanzhepaiqian.getZhiyuanzhepaiqianPhoto())){
                zhiyuanzhepaiqian.setZhiyuanzhepaiqianPhoto(null);
        }

            zhiyuanzhepaiqianService.updateById(zhiyuanzhepaiqian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhiyuanzhepaiqianEntity> oldZhiyuanzhepaiqianList =zhiyuanzhepaiqianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhiyuanzhepaiqianService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZhiyuanzhepaiqianEntity> zhiyuanzhepaiqianList = new ArrayList<>();//上传的东西
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
                            ZhiyuanzhepaiqianEntity zhiyuanzhepaiqianEntity = new ZhiyuanzhepaiqianEntity();
//                            zhiyuanzhepaiqianEntity.setZhiyuanzhepaiqianName(data.get(0));                    //派遣标题 要改的
//                            zhiyuanzhepaiqianEntity.setZhiyuanzhepaiqianTypes(Integer.valueOf(data.get(0)));   //派遣类型 要改的
//                            zhiyuanzhepaiqianEntity.setZhiyuanzhepaiqianPhoto("");//详情和图片
//                            zhiyuanzhepaiqianEntity.setZhiyuanzhepaiqianTime(sdf.parse(data.get(0)));          //派遣时间 要改的
//                            zhiyuanzhepaiqianEntity.setZhiyaunzheId(Integer.valueOf(data.get(0)));   //自愿者 要改的
//                            zhiyuanzhepaiqianEntity.setZhiyuanzhepaiqianContent("");//详情和图片
//                            zhiyuanzhepaiqianEntity.setInsertTime(date);//时间
//                            zhiyuanzhepaiqianEntity.setCreateTime(date);//时间
                            zhiyuanzhepaiqianList.add(zhiyuanzhepaiqianEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhiyuanzhepaiqianService.insertBatch(zhiyuanzhepaiqianList);
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

