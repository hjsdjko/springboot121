package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShouzuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShouzuxinxiView;


/**
 * 收租信息
 *
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
public interface ShouzuxinxiService extends IService<ShouzuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShouzuxinxiView> selectListView(Wrapper<ShouzuxinxiEntity> wrapper);
   	
   	ShouzuxinxiView selectView(@Param("ew") Wrapper<ShouzuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShouzuxinxiEntity> wrapper);
   	

}

