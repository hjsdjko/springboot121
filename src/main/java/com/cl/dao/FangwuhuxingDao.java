package com.cl.dao;

import com.cl.entity.FangwuhuxingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FangwuhuxingView;


/**
 * 房屋户型
 * 
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
public interface FangwuhuxingDao extends BaseMapper<FangwuhuxingEntity> {
	
	List<FangwuhuxingView> selectListView(@Param("ew") Wrapper<FangwuhuxingEntity> wrapper);

	List<FangwuhuxingView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuhuxingEntity> wrapper);
	
	FangwuhuxingView selectView(@Param("ew") Wrapper<FangwuhuxingEntity> wrapper);
	

}
