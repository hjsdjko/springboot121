package com.cl.dao;

import com.cl.entity.ShouzuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShouzuxinxiView;


/**
 * 收租信息
 * 
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
public interface ShouzuxinxiDao extends BaseMapper<ShouzuxinxiEntity> {
	
	List<ShouzuxinxiView> selectListView(@Param("ew") Wrapper<ShouzuxinxiEntity> wrapper);

	List<ShouzuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShouzuxinxiEntity> wrapper);
	
	ShouzuxinxiView selectView(@Param("ew") Wrapper<ShouzuxinxiEntity> wrapper);
	

}
