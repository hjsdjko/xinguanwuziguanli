package com.dao;

import com.entity.ZhiyuanzhepaiqianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiyuanzhepaiqianView;

/**
 * 志愿者调派 Dao 接口
 *
 * @author 
 */
public interface ZhiyuanzhepaiqianDao extends BaseMapper<ZhiyuanzhepaiqianEntity> {

   List<ZhiyuanzhepaiqianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
