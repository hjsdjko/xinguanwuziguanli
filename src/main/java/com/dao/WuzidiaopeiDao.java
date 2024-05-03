package com.dao;

import com.entity.WuzidiaopeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuzidiaopeiView;

/**
 * 物资调配 Dao 接口
 *
 * @author 
 */
public interface WuzidiaopeiDao extends BaseMapper<WuzidiaopeiEntity> {

   List<WuzidiaopeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
