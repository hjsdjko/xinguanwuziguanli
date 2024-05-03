package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.WuzidiaopeiDao;
import com.entity.WuzidiaopeiEntity;
import com.service.WuzidiaopeiService;
import com.entity.view.WuzidiaopeiView;

/**
 * 物资调配 服务实现类
 */
@Service("wuzidiaopeiService")
@Transactional
public class WuzidiaopeiServiceImpl extends ServiceImpl<WuzidiaopeiDao, WuzidiaopeiEntity> implements WuzidiaopeiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<WuzidiaopeiView> page =new Query<WuzidiaopeiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
