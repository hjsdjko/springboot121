package com.cl.dao;

import com.cl.entity.ZulinhetongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZulinhetongView;


/**
 * 租赁合同
 * 
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
public interface ZulinhetongDao extends BaseMapper<ZulinhetongEntity> {
	
	List<ZulinhetongView> selectListView(@Param("ew") Wrapper<ZulinhetongEntity> wrapper);

	List<ZulinhetongView> selectListView(Pagination page,@Param("ew") Wrapper<ZulinhetongEntity> wrapper);
	
	ZulinhetongView selectView(@Param("ew") Wrapper<ZulinhetongEntity> wrapper);
	

}
