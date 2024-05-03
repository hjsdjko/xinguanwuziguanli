
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
 * 物资采购
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuzicaigou")
public class WuzicaigouController {
    private static final Logger logger = LoggerFactory.getLogger(WuzicaigouController.class);

    private static final String TABLE_NAME = "wuzicaigou";

    @Autowired
    private WuzicaigouService wuzicaigouService;


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
        PageUtils page = wuzicaigouService.queryPage(params);

        //字典表数据转换
        List<WuzicaigouView> list =(List<WuzicaigouView>)page.getList();
        for(WuzicaigouView c:list){
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
        WuzicaigouEntity wuzicaigou = wuzicaigouService.selectById(id);
        if(wuzicaigou !=null){
            //entity转view
            WuzicaigouView view = new WuzicaigouView();
            BeanUtils.copyProperties( wuzicaigou , view );//把实体数据重构到view中
            //级联表 采购员
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wuzicaigou.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 物资
            //级联表
            WuziEntity wuzi = wuziService.selectById(wuzicaigou.getWuziId());
            if(wuzi != null){
            BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody WuzicaigouEntity wuzicaigou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuzicaigou:{}",this.getClass().getName(),wuzicaigou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("采购员".equals(role))
            wuzicaigou.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WuzicaigouEntity> queryWrapper = new EntityWrapper<WuzicaigouEntity>()
            .eq("wuzi_id", wuzicaigou.getWuziId())
            .eq("yonghu_id", wuzicaigou.getYonghuId())
            .eq("wuzicaigou_number", wuzicaigou.getWuzicaigouNumber())
            .eq("wuzicaigou_time", new SimpleDateFormat("yyyy-MM-dd").format(wuzicaigou.getWuzicaigouTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuzicaigouEntity wuzicaigouEntity = wuzicaigouService.selectOne(queryWrapper);
        if(wuzicaigouEntity==null){
            wuzicaigou.setWuzicaigouYesnoTypes(1);
            wuzicaigou.setInsertTime(new Date());
            wuzicaigou.setCreateTime(new Date());
            wuzicaigouService.insert(wuzicaigou);
            return R.ok();
        }else {
            if(wuzicaigouEntity.getWuzicaigouYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(wuzicaigouEntity.getWuzicaigouYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuzicaigouEntity wuzicaigou, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wuzicaigou:{}",this.getClass().getName(),wuzicaigou.toString());
        WuzicaigouEntity oldWuzicaigouEntity = wuzicaigouService.selectById(wuzicaigou.getId());//查询原先数据
        WuziEntity wuziEntity = wuziService.selectById(oldWuzicaigouEntity.getWuziId());
        wuziEntity.setWuziKucunNumber(wuziEntity.getWuziKucunNumber()+oldWuzicaigouEntity.getWuzicaigouNumber());
        wuziService.updateById(wuziEntity);

        wuzicaigouService.updateById(wuzicaigou);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WuzicaigouEntity wuzicaigouEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,wuzicaigouEntity:{}",this.getClass().getName(),wuzicaigouEntity.toString());

        WuzicaigouEntity oldWuzicaigou = wuzicaigouService.selectById(wuzicaigouEntity.getId());//查询原先数据

//        if(wuzicaigouEntity.getWuzicaigouYesnoTypes() == 2){//通过
//            wuzicaigouEntity.setWuzicaigouTypes();
//        }else if(wuzicaigouEntity.getWuzicaigouYesnoTypes() == 3){//拒绝
//            wuzicaigouEntity.setWuzicaigouTypes();
//        }
        wuzicaigouService.updateById(wuzicaigouEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WuzicaigouEntity> oldWuzicaigouList =wuzicaigouService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wuzicaigouService.deleteBatchIds(Arrays.asList(ids));

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
            List<WuzicaigouEntity> wuzicaigouList = new ArrayList<>();//上传的东西
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
                            WuzicaigouEntity wuzicaigouEntity = new WuzicaigouEntity();
//                            wuzicaigouEntity.setWuziId(Integer.valueOf(data.get(0)));   //物资 要改的
//                            wuzicaigouEntity.setYonghuId(Integer.valueOf(data.get(0)));   //采购员 要改的
//                            wuzicaigouEntity.setWuzicaigouNumber(Integer.valueOf(data.get(0)));   //采购数量 要改的
//                            wuzicaigouEntity.setWuzicaigouTime(sdf.parse(data.get(0)));          //登记时间 要改的
//                            wuzicaigouEntity.setWuzicaigouText(data.get(0));                    //备注 要改的
//                            wuzicaigouEntity.setWuzicaigouYesnoTypes(Integer.valueOf(data.get(0)));   //采购审核 要改的
//                            wuzicaigouEntity.setWuzicaigouYesnoText(data.get(0));                    //审核结果 要改的
//                            wuzicaigouEntity.setInsertTime(date);//时间
//                            wuzicaigouEntity.setCreateTime(date);//时间
                            wuzicaigouList.add(wuzicaigouEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wuzicaigouService.insertBatch(wuzicaigouList);
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

