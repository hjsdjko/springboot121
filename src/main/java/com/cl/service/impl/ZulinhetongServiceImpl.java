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


import com.cl.dao.ZulinhetongDao;
import com.cl.entity.ZulinhetongEntity;
import com.cl.service.ZulinhetongService;
import com.cl.entity.view.ZulinhetongView;

@Service("zulinhetongService")
public class ZulinhetongServiceImpl extends ServiceImpl<ZulinhetongDao, ZulinhetongEntity> implements ZulinhetongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZulinhetongEntity> page = this.selectPage(
                new Query<ZulinhetongEntity>(params).getPage(),
                new EntityWrapper<ZulinhetongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZulinhetongEntity> wrapper) {
		  Page<ZulinhetongView> page =new Query<ZulinhetongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZulinhetongView> selectListView(Wrapper<ZulinhetongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZulinhetongView selectView(Wrapper<ZulinhetongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
