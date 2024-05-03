
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
 * 物资调配
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuzidiaopei")
public class WuzidiaopeiController {
    private static final Logger logger = LoggerFactory.getLogger(WuzidiaopeiController.class);

    private static final String TABLE_NAME = "wuzidiaopei";

    @Autowired
    private WuzidiaopeiService wuzidiaopeiService;


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
        CommonUtil.checkMap(params);
        PageUtils page = wuzidiaopeiService.queryPage(params);

        //字典表数据转换
        List<WuzidiaopeiView> list =(List<WuzidiaopeiView>)page.getList();
        for(WuzidiaopeiView c:list){
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
        WuzidiaopeiEntity wuzidiaopei = wuzidiaopeiService.selectById(id);
        if(wuzidiaopei !=null){
            //entity转view
            WuzidiaopeiView view = new WuzidiaopeiView();
            BeanUtils.copyProperties( wuzidiaopei , view );//把实体数据重构到view中
            //级联表 小区管理员
            //级联表
            XiaoquguanliEntity xiaoquguanli = xiaoquguanliService.selectById(wuzidiaopei.getXiaoquguanliId());
            if(xiaoquguanli != null){
            BeanUtils.copyProperties( xiaoquguanli , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xiaoquguanliId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXiaoquguanliId(xiaoquguanli.getId());
            }
            //级联表 物资
            //级联表
            WuziEntity wuzi = wuziService.selectById(wuzidiaopei.getWuziId());
            if(wuzi != null){
            BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xiaoquguanliId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWuziId(wuzi.getId());
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
    public R save(@RequestBody WuzidiaopeiEntity wuzidiaopei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuzidiaopei:{}",this.getClass().getName(),wuzidiaopei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("小区管理员".equals(role))
            wuzidiaopei.setXiaoquguanliId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WuzidiaopeiEntity> queryWrapper = new EntityWrapper<WuzidiaopeiEntity>()
            .eq("wuzi_id", wuzidiaopei.getWuziId())
            .eq("xiaoquguanli_id", wuzidiaopei.getXiaoquguanliId())
            .eq("wuzidiaopei_number", wuzidiaopei.getWuzidiaopeiNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuzidiaopeiEntity wuzidiaopeiEntity = wuzidiaopeiService.selectOne(queryWrapper);
        if(wuzidiaopeiEntity==null){
            wuzidiaopei.setInsertTime(new Date());
            wuzidiaopei.setCreateTime(new Date());
            wuzidiaopeiService.insert(wuzidiaopei);

            WuziEntity wuziEntity = wuziService.selectById(wuzidiaopei.getWuziId());
            wuziEntity.setWuziKucunNumber(wuziEntity.getWuziKucunNumber() - wuzidiaopei.getWuzidiaopeiNumber());
            wuziService.updateById(wuziEntity);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuzidiaopeiEntity wuzidiaopei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wuzidiaopei:{}",this.getClass().getName(),wuzidiaopei.toString());
        WuzidiaopeiEntity oldWuzidiaopeiEntity = wuzidiaopeiService.selectById(wuzidiaopei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("小区管理员".equals(role))
//            wuzidiaopei.setXiaoquguanliId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wuzidiaopeiService.updateById(wuzidiaopei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WuzidiaopeiEntity> oldWuzidiaopeiList =wuzidiaopeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wuzidiaopeiService.deleteBatchIds(Arrays.asList(ids));

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
            List<WuzidiaopeiEntity> wuzidiaopeiList = new ArrayList<>();//上传的东西
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
                            WuzidiaopeiEntity wuzidiaopeiEntity = new WuzidiaopeiEntity();
//                            wuzidiaopeiEntity.setWuziId(Integer.valueOf(data.get(0)));   //物资 要改的
//                            wuzidiaopeiEntity.setXiaoquguanliId(Integer.valueOf(data.get(0)));   //小区管理员 要改的
//                            wuzidiaopeiEntity.setWuzidiaopeiNumber(Integer.valueOf(data.get(0)));   //调用数量 要改的
//                            wuzidiaopeiEntity.setWuzidiaopeiContent("");//详情和图片
//                            wuzidiaopeiEntity.setInsertTime(date);//时间
//                            wuzidiaopeiEntity.setCreateTime(date);//时间
                            wuzidiaopeiList.add(wuzidiaopeiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wuzidiaopeiService.insertBatch(wuzidiaopeiList);
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

