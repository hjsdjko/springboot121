package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZuhuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuhuView;


/**
 * 租户
 *
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
public interface ZuhuService extends IService<ZuhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuhuView> selectListView(Wrapper<ZuhuEntity> wrapper);
   	
   	ZuhuView selectView(@Param("ew") Wrapper<ZuhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuhuEntity> wrapper);
   	

}

