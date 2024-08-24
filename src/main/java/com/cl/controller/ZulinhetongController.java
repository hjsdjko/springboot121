package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZulinhetongEntity;
import com.cl.entity.view.ZulinhetongView;

import com.cl.service.ZulinhetongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 租赁合同
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@RestController
@RequestMapping("/zulinhetong")
public class ZulinhetongController {
    @Autowired
    private ZulinhetongService zulinhetongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZulinhetongEntity zulinhetong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuhu")) {
			zulinhetong.setZuhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangdong")) {
			zulinhetong.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZulinhetongEntity> ew = new EntityWrapper<ZulinhetongEntity>();

		PageUtils page = zulinhetongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zulinhetong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZulinhetongEntity zulinhetong, 
		HttpServletRequest request){
        EntityWrapper<ZulinhetongEntity> ew = new EntityWrapper<ZulinhetongEntity>();

		PageUtils page = zulinhetongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zulinhetong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZulinhetongEntity zulinhetong){
       	EntityWrapper<ZulinhetongEntity> ew = new EntityWrapper<ZulinhetongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zulinhetong, "zulinhetong")); 
        return R.ok().put("data", zulinhetongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZulinhetongEntity zulinhetong){
        EntityWrapper< ZulinhetongEntity> ew = new EntityWrapper< ZulinhetongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zulinhetong, "zulinhetong")); 
		ZulinhetongView zulinhetongView =  zulinhetongService.selectView(ew);
		return R.ok("查询租赁合同成功").put("data", zulinhetongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZulinhetongEntity zulinhetong = zulinhetongService.selectById(id);
		zulinhetong = zulinhetongService.selectView(new EntityWrapper<ZulinhetongEntity>().eq("id", id));
        return R.ok().put("data", zulinhetong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZulinhetongEntity zulinhetong = zulinhetongService.selectById(id);
		zulinhetong = zulinhetongService.selectView(new EntityWrapper<ZulinhetongEntity>().eq("id", id));
        return R.ok().put("data", zulinhetong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
    	zulinhetong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zulinhetong);
        zulinhetongService.insert(zulinhetong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
    	zulinhetong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zulinhetong);
        zulinhetongService.insert(zulinhetong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZulinhetongEntity zulinhetong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zulinhetong);
        zulinhetongService.updateById(zulinhetong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zulinhetongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
