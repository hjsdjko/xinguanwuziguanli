package com.dao;

import com.entity.ZhiyaunzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiyaunzheView;

/**
 * 自愿者 Dao 接口
 *
 * @author 
 */
public interface ZhiyaunzheDao extends BaseMapper<ZhiyaunzheEntity> {

   List<ZhiyaunzheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
