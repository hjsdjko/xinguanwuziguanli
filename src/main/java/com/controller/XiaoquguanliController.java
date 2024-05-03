
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
 * 小区管理员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiaoquguanli")
public class XiaoquguanliController {
    private static final Logger logger = LoggerFactory.getLogger(XiaoquguanliController.class);

    private static final String TABLE_NAME = "xiaoquguanli";

    @Autowired
    private XiaoquguanliService xiaoquguanliService;


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
        params.put("xiaoquguanliDeleteStart",1);params.put("xiaoquguanliDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xiaoquguanliService.queryPage(params);

        //字典表数据转换
        List<XiaoquguanliView> list =(List<XiaoquguanliView>)page.getList();
        for(XiaoquguanliView c:list){
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
        XiaoquguanliEntity xiaoquguanli = xiaoquguanliService.selectById(id);
        if(xiaoquguanli !=null){
            //entity转view
            XiaoquguanliView view = new XiaoquguanliView();
            BeanUtils.copyProperties( xiaoquguanli , view );//把实体数据重构到view中
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
    public R save(@RequestBody XiaoquguanliEntity xiaoquguanli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaoquguanli:{}",this.getClass().getName(),xiaoquguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XiaoquguanliEntity> queryWrapper = new EntityWrapper<XiaoquguanliEntity>()
            .eq("username", xiaoquguanli.getUsername())
            .or()
            .eq("xiaoquguanli_phone", xiaoquguanli.getXiaoquguanliPhone())
            .or()
            .eq("xiaoquguanli_id_number", xiaoquguanli.getXiaoquguanliIdNumber())
            .andNew()
            .eq("xiaoquguanli_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoquguanliEntity xiaoquguanliEntity = xiaoquguanliService.selectOne(queryWrapper);
        if(xiaoquguanliEntity==null){
            xiaoquguanli.setXiaoquguanliDelete(1);
            xiaoquguanli.setCreateTime(new Date());
            xiaoquguanli.setPassword("123456");
            xiaoquguanliService.insert(xiaoquguanli);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式或者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoquguanliEntity xiaoquguanli, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xiaoquguanli:{}",this.getClass().getName(),xiaoquguanli.toString());
        XiaoquguanliEntity oldXiaoquguanliEntity = xiaoquguanliService.selectById(xiaoquguanli.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xiaoquguanli.getXiaoquguanliPhoto()) || "null".equals(xiaoquguanli.getXiaoquguanliPhoto())){
                xiaoquguanli.setXiaoquguanliPhoto(null);
        }

            xiaoquguanliService.updateById(xiaoquguanli);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XiaoquguanliEntity> oldXiaoquguanliList =xiaoquguanliService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XiaoquguanliEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XiaoquguanliEntity xiaoquguanliEntity = new XiaoquguanliEntity();
            xiaoquguanliEntity.setId(id);
            xiaoquguanliEntity.setXiaoquguanliDelete(2);
            list.add(xiaoquguanliEntity);
        }
        if(list != null && list.size() >0){
            xiaoquguanliService.updateBatchById(list);
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
            List<XiaoquguanliEntity> xiaoquguanliList = new ArrayList<>();//上传的东西
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
                            XiaoquguanliEntity xiaoquguanliEntity = new XiaoquguanliEntity();
//                            xiaoquguanliEntity.setUsername(data.get(0));                    //账户 要改的
//                            //xiaoquguanliEntity.setPassword("123456");//密码
//                            xiaoquguanliEntity.setXiaoquguanliName(data.get(0));                    //小区管理员姓名 要改的
//                            xiaoquguanliEntity.setXiaoquguanliPhoto("");//详情和图片
//                            xiaoquguanliEntity.setXiaoquguanliPhone(data.get(0));                    //联系方式 要改的
//                            xiaoquguanliEntity.setXiaoquguanliIdNumber(data.get(0));                    //身份证号 要改的
//                            xiaoquguanliEntity.setXiaoquguanliEmail(data.get(0));                    //邮箱 要改的
//                            xiaoquguanliEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xiaoquguanliEntity.setXiaoquguanliDelete(1);//逻辑删除字段
//                            xiaoquguanliEntity.setCreateTime(date);//时间
                            xiaoquguanliList.add(xiaoquguanliEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("xiaoquguanliPhone")){
                                    List<String> xiaoquguanliPhone = seachFields.get("xiaoquguanliPhone");
                                    xiaoquguanliPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoquguanliPhone = new ArrayList<>();
                                    xiaoquguanliPhone.add(data.get(0));//要改的
                                    seachFields.put("xiaoquguanliPhone",xiaoquguanliPhone);
                                }
                                //身份证号
                                if(seachFields.containsKey("xiaoquguanliIdNumber")){
                                    List<String> xiaoquguanliIdNumber = seachFields.get("xiaoquguanliIdNumber");
                                    xiaoquguanliIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoquguanliIdNumber = new ArrayList<>();
                                    xiaoquguanliIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xiaoquguanliIdNumber",xiaoquguanliIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XiaoquguanliEntity> xiaoquguanliEntities_username = xiaoquguanliService.selectList(new EntityWrapper<XiaoquguanliEntity>().in("username", seachFields.get("username")).eq("xiaoquguanli_delete", 1));
                        if(xiaoquguanliEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoquguanliEntity s:xiaoquguanliEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<XiaoquguanliEntity> xiaoquguanliEntities_xiaoquguanliPhone = xiaoquguanliService.selectList(new EntityWrapper<XiaoquguanliEntity>().in("xiaoquguanli_phone", seachFields.get("xiaoquguanliPhone")).eq("xiaoquguanli_delete", 1));
                        if(xiaoquguanliEntities_xiaoquguanliPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoquguanliEntity s:xiaoquguanliEntities_xiaoquguanliPhone){
                                repeatFields.add(s.getXiaoquguanliPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //身份证号
                        List<XiaoquguanliEntity> xiaoquguanliEntities_xiaoquguanliIdNumber = xiaoquguanliService.selectList(new EntityWrapper<XiaoquguanliEntity>().in("xiaoquguanli_id_number", seachFields.get("xiaoquguanliIdNumber")).eq("xiaoquguanli_delete", 1));
                        if(xiaoquguanliEntities_xiaoquguanliIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoquguanliEntity s:xiaoquguanliEntities_xiaoquguanliIdNumber){
                                repeatFields.add(s.getXiaoquguanliIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiaoquguanliService.insertBatch(xiaoquguanliList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XiaoquguanliEntity xiaoquguanli = xiaoquguanliService.selectOne(new EntityWrapper<XiaoquguanliEntity>().eq("username", username));
        if(xiaoquguanli==null || !xiaoquguanli.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(xiaoquguanli.getXiaoquguanliDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(xiaoquguanli.getId(),username, "xiaoquguanli", "小区管理员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","小区管理员");
        r.put("username",xiaoquguanli.getXiaoquguanliName());
        r.put("tableName","xiaoquguanli");
        r.put("userId",xiaoquguanli.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XiaoquguanliEntity xiaoquguanli, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XiaoquguanliEntity> queryWrapper = new EntityWrapper<XiaoquguanliEntity>()
            .eq("username", xiaoquguanli.getUsername())
            .or()
            .eq("xiaoquguanli_phone", xiaoquguanli.getXiaoquguanliPhone())
            .or()
            .eq("xiaoquguanli_id_number", xiaoquguanli.getXiaoquguanliIdNumber())
            .andNew()
            .eq("xiaoquguanli_delete", 1)
            ;
        XiaoquguanliEntity xiaoquguanliEntity = xiaoquguanliService.selectOne(queryWrapper);
        if(xiaoquguanliEntity != null)
            return R.error("账户或者联系方式或者身份证号已经被使用");
        xiaoquguanli.setXiaoquguanliDelete(1);
        xiaoquguanli.setCreateTime(new Date());
        xiaoquguanliService.insert(xiaoquguanli);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        XiaoquguanliEntity xiaoquguanli = xiaoquguanliService.selectById(id);
        xiaoquguanli.setPassword("123456");
        xiaoquguanliService.updateById(xiaoquguanli);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XiaoquguanliEntity xiaoquguanli = xiaoquguanliService.selectOne(new EntityWrapper<XiaoquguanliEntity>().eq("username", username));
        if(xiaoquguanli!=null){
            xiaoquguanli.setPassword("123456");
            xiaoquguanliService.updateById(xiaoquguanli);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXiaoquguanli(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XiaoquguanliEntity xiaoquguanli = xiaoquguanliService.selectById(id);
        if(xiaoquguanli !=null){
            //entity转view
            XiaoquguanliView view = new XiaoquguanliView();
            BeanUtils.copyProperties( xiaoquguanli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



}

