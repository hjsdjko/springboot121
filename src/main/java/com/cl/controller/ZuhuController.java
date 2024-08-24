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

import com.cl.entity.ZuhuEntity;
import com.cl.entity.view.ZuhuView;

import com.cl.service.ZuhuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 租户
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@RestController
@RequestMapping("/zuhu")
public class ZuhuController {
    @Autowired
    private ZuhuService zuhuService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		ZuhuEntity u = zuhuService.selectOne(new EntityWrapper<ZuhuEntity>().eq("zuhuzhanghao", username));
        if(u==null || !u.getZuhumima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"zuhu",  "租户" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ZuhuEntity zuhu){
    	//ValidatorUtils.validateEntity(zuhu);
    	ZuhuEntity u = zuhuService.selectOne(new EntityWrapper<ZuhuEntity>().eq("zuhuzhanghao", zuhu.getZuhuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		zuhu.setId(uId);
        zuhuService.insert(zuhu);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        ZuhuEntity u = zuhuService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	ZuhuEntity u = zuhuService.selectOne(new EntityWrapper<ZuhuEntity>().eq("zuhuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setZuhumima("123456");
        zuhuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuhuEntity zuhu,
		HttpServletRequest request){
        EntityWrapper<ZuhuEntity> ew = new EntityWrapper<ZuhuEntity>();

		PageUtils page = zuhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuhuEntity zuhu, 
		HttpServletRequest request){
        EntityWrapper<ZuhuEntity> ew = new EntityWrapper<ZuhuEntity>();

		PageUtils page = zuhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuhu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuhuEntity zuhu){
       	EntityWrapper<ZuhuEntity> ew = new EntityWrapper<ZuhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuhu, "zuhu")); 
        return R.ok().put("data", zuhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuhuEntity zuhu){
        EntityWrapper< ZuhuEntity> ew = new EntityWrapper< ZuhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuhu, "zuhu")); 
		ZuhuView zuhuView =  zuhuService.selectView(ew);
		return R.ok("查询租户成功").put("data", zuhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuhuEntity zuhu = zuhuService.selectById(id);
		zuhu = zuhuService.selectView(new EntityWrapper<ZuhuEntity>().eq("id", id));
        return R.ok().put("data", zuhu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuhuEntity zuhu = zuhuService.selectById(id);
		zuhu = zuhuService.selectView(new EntityWrapper<ZuhuEntity>().eq("id", id));
        return R.ok().put("data", zuhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuhuEntity zuhu, HttpServletRequest request){
    	zuhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuhu);
    	ZuhuEntity u = zuhuService.selectOne(new EntityWrapper<ZuhuEntity>().eq("zuhuzhanghao", zuhu.getZuhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		zuhu.setId(new Date().getTime());
        zuhuService.insert(zuhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuhuEntity zuhu, HttpServletRequest request){
    	zuhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuhu);
    	ZuhuEntity u = zuhuService.selectOne(new EntityWrapper<ZuhuEntity>().eq("zuhuzhanghao", zuhu.getZuhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		zuhu.setId(new Date().getTime());
        zuhuService.insert(zuhu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuhuEntity zuhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuhu);
        zuhuService.updateById(zuhu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
