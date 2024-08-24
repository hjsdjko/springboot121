package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KanfangshenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KanfangshenqingView;


/**
 * 看房申请
 *
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
public interface KanfangshenqingService extends IService<KanfangshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KanfangshenqingView> selectListView(Wrapper<KanfangshenqingEntity> wrapper);
   	
   	KanfangshenqingView selectView(@Param("ew") Wrapper<KanfangshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KanfangshenqingEntity> wrapper);
   	

}

