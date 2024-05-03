package com.dao;

import com.entity.WuzipaifaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuzipaifaView;

/**
 * 物资派发 Dao 接口
 *
 * @author 
 */
public interface WuzipaifaDao extends BaseMapper<WuzipaifaEntity> {

   List<WuzipaifaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
