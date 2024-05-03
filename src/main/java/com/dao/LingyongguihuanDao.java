package com.dao;

import com.entity.LingyongguihuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LingyongguihuanView;

/**
 * 物资领用归还 Dao 接口
 *
 * @author 
 */
public interface LingyongguihuanDao extends BaseMapper<LingyongguihuanEntity> {

   List<LingyongguihuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
