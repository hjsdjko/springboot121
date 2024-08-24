package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FangwuhuxingDao;
import com.cl.entity.FangwuhuxingEntity;
import com.cl.service.FangwuhuxingService;
import com.cl.entity.view.FangwuhuxingView;

@Service("fangwuhuxingService")
public class FangwuhuxingServiceImpl extends ServiceImpl<FangwuhuxingDao, FangwuhuxingEntity> implements FangwuhuxingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwuhuxingEntity> page = this.selectPage(
                new Query<FangwuhuxingEntity>(params).getPage(),
                new EntityWrapper<FangwuhuxingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangwuhuxingEntity> wrapper) {
		  Page<FangwuhuxingView> page =new Query<FangwuhuxingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FangwuhuxingView> selectListView(Wrapper<FangwuhuxingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwuhuxingView selectView(Wrapper<FangwuhuxingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
