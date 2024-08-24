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

import com.cl.entity.ShouzuxinxiEntity;
import com.cl.entity.view.ShouzuxinxiView;

import com.cl.service.ShouzuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 收租信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@RestController
@RequestMapping("/shouzuxinxi")
public class ShouzuxinxiController {
    @Autowired
    private ShouzuxinxiService shouzuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShouzuxinxiEntity shouzuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuhu")) {
			shouzuxinxi.setZuhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangdong")) {
			shouzuxinxi.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShouzuxinxiEntity> ew = new EntityWrapper<ShouzuxinxiEntity>();

		PageUtils page = shouzuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shouzuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShouzuxinxiEntity shouzuxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShouzuxinxiEntity> ew = new EntityWrapper<ShouzuxinxiEntity>();

		PageUtils page = shouzuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shouzuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShouzuxinxiEntity shouzuxinxi){
       	EntityWrapper<ShouzuxinxiEntity> ew = new EntityWrapper<ShouzuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shouzuxinxi, "shouzuxinxi")); 
        return R.ok().put("data", shouzuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShouzuxinxiEntity shouzuxinxi){
        EntityWrapper< ShouzuxinxiEntity> ew = new EntityWrapper< ShouzuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shouzuxinxi, "shouzuxinxi")); 
		ShouzuxinxiView shouzuxinxiView =  shouzuxinxiService.selectView(ew);
		return R.ok("查询收租信息成功").put("data", shouzuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShouzuxinxiEntity shouzuxinxi = shouzuxinxiService.selectById(id);
		shouzuxinxi = shouzuxinxiService.selectView(new EntityWrapper<ShouzuxinxiEntity>().eq("id", id));
        return R.ok().put("data", shouzuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShouzuxinxiEntity shouzuxinxi = shouzuxinxiService.selectById(id);
		shouzuxinxi = shouzuxinxiService.selectView(new EntityWrapper<ShouzuxinxiEntity>().eq("id", id));
        return R.ok().put("data", shouzuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShouzuxinxiEntity shouzuxinxi, HttpServletRequest request){
    	shouzuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shouzuxinxi);
        shouzuxinxiService.insert(shouzuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShouzuxinxiEntity shouzuxinxi, HttpServletRequest request){
    	shouzuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shouzuxinxi);
        shouzuxinxiService.insert(shouzuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShouzuxinxiEntity shouzuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shouzuxinxi);
        shouzuxinxiService.updateById(shouzuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shouzuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
