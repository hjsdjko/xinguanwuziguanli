package com.dao;

import com.entity.XuqiutongjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuqiutongjiView;

/**
 * 需求收集 Dao 接口
 *
 * @author 
 */
public interface XuqiutongjiDao extends BaseMapper<XuqiutongjiEntity> {

   List<XuqiutongjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
