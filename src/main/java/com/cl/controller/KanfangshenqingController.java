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

import com.cl.entity.KanfangshenqingEntity;
import com.cl.entity.view.KanfangshenqingView;

import com.cl.service.KanfangshenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 看房申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@RestController
@RequestMapping("/kanfangshenqing")
public class KanfangshenqingController {
    @Autowired
    private KanfangshenqingService kanfangshenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KanfangshenqingEntity kanfangshenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangdong")) {
			kanfangshenqing.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zuhu")) {
			kanfangshenqing.setZuhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KanfangshenqingEntity> ew = new EntityWrapper<KanfangshenqingEntity>();

		PageUtils page = kanfangshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kanfangshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KanfangshenqingEntity kanfangshenqing, 
		HttpServletRequest request){
        EntityWrapper<KanfangshenqingEntity> ew = new EntityWrapper<KanfangshenqingEntity>();

		PageUtils page = kanfangshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kanfangshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KanfangshenqingEntity kanfangshenqing){
       	EntityWrapper<KanfangshenqingEntity> ew = new EntityWrapper<KanfangshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kanfangshenqing, "kanfangshenqing")); 
        return R.ok().put("data", kanfangshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KanfangshenqingEntity kanfangshenqing){
        EntityWrapper< KanfangshenqingEntity> ew = new EntityWrapper< KanfangshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kanfangshenqing, "kanfangshenqing")); 
		KanfangshenqingView kanfangshenqingView =  kanfangshenqingService.selectView(ew);
		return R.ok("查询看房申请成功").put("data", kanfangshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KanfangshenqingEntity kanfangshenqing = kanfangshenqingService.selectById(id);
		kanfangshenqing = kanfangshenqingService.selectView(new EntityWrapper<KanfangshenqingEntity>().eq("id", id));
        return R.ok().put("data", kanfangshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KanfangshenqingEntity kanfangshenqing = kanfangshenqingService.selectById(id);
		kanfangshenqing = kanfangshenqingService.selectView(new EntityWrapper<KanfangshenqingEntity>().eq("id", id));
        return R.ok().put("data", kanfangshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KanfangshenqingEntity kanfangshenqing, HttpServletRequest request){
    	kanfangshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kanfangshenqing);
        kanfangshenqingService.insert(kanfangshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KanfangshenqingEntity kanfangshenqing, HttpServletRequest request){
    	kanfangshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kanfangshenqing);
        kanfangshenqingService.insert(kanfangshenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KanfangshenqingEntity kanfangshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kanfangshenqing);
        kanfangshenqingService.updateById(kanfangshenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<KanfangshenqingEntity> list = new ArrayList<KanfangshenqingEntity>();
        for(Long id : ids) {
            KanfangshenqingEntity kanfangshenqing = kanfangshenqingService.selectById(id);
            kanfangshenqing.setSfsh(sfsh);
            kanfangshenqing.setShhf(shhf);
            list.add(kanfangshenqing);
        }
        kanfangshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kanfangshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
