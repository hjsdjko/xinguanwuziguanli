package com.dao;

import com.entity.XiaoquguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoquguanliView;

/**
 * 小区管理员 Dao 接口
 *
 * @author 
 */
public interface XiaoquguanliDao extends BaseMapper<XiaoquguanliEntity> {

   List<XiaoquguanliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
