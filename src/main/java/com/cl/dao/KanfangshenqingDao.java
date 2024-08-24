package com.cl.dao;

import com.cl.entity.KanfangshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KanfangshenqingView;


/**
 * 看房申请
 * 
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
public interface KanfangshenqingDao extends BaseMapper<KanfangshenqingEntity> {
	
	List<KanfangshenqingView> selectListView(@Param("ew") Wrapper<KanfangshenqingEntity> wrapper);

	List<KanfangshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<KanfangshenqingEntity> wrapper);
	
	KanfangshenqingView selectView(@Param("ew") Wrapper<KanfangshenqingEntity> wrapper);
	

}
