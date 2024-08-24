package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 收租信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@TableName("shouzuxinxi")
public class ShouzuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShouzuxinxiEntity() {
		
	}
	
	public ShouzuxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 账单号
	 */
					
	private String zhangdanhao;
	
	/**
	 * 计费区间
	 */
					
	private String jifeiqujian;
	
	/**
	 * 租金
	 */
					
	private Double zujin;
	
	/**
	 * 电费
	 */
					
	private Double dianfei;
	
	/**
	 * 水费
	 */
					
	private Double shuifei;
	
	/**
	 * 管理费
	 */
					
	private Double guanlifei;
	
	/**
	 * 应付金额
	 */
					
	private String yingfujine;
	
	/**
	 * 租户账号
	 */
					
	private String zuhuzhanghao;
	
	/**
	 * 租户姓名
	 */
					
	private String zuhuxingming;
	
	/**
	 * 电话号码
	 */
					
	private String dianhuahaoma;
	
	/**
	 * 房东账号
	 */
					
	private String fangdongzhanghao;
	
	/**
	 * 房东姓名
	 */
					
	private String fangdongxingming;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：账单号
	 */
	public void setZhangdanhao(String zhangdanhao) {
		this.zhangdanhao = zhangdanhao;
	}
	/**
	 * 获取：账单号
	 */
	public String getZhangdanhao() {
		return zhangdanhao;
	}
	/**
	 * 设置：计费区间
	 */
	public void setJifeiqujian(String jifeiqujian) {
		this.jifeiqujian = jifeiqujian;
	}
	/**
	 * 获取：计费区间
	 */
	public String getJifeiqujian() {
		return jifeiqujian;
	}
	/**
	 * 设置：租金
	 */
	public void setZujin(Double zujin) {
		this.zujin = zujin;
	}
	/**
	 * 获取：租金
	 */
	public Double getZujin() {
		return zujin;
	}
	/**
	 * 设置：电费
	 */
	public void setDianfei(Double dianfei) {
		this.dianfei = dianfei;
	}
	/**
	 * 获取：电费
	 */
	public Double getDianfei() {
		return dianfei;
	}
	/**
	 * 设置：水费
	 */
	public void setShuifei(Double shuifei) {
		this.shuifei = shuifei;
	}
	/**
	 * 获取：水费
	 */
	public Double getShuifei() {
		return shuifei;
	}
	/**
	 * 设置：管理费
	 */
	public void setGuanlifei(Double guanlifei) {
		this.guanlifei = guanlifei;
	}
	/**
	 * 获取：管理费
	 */
	public Double getGuanlifei() {
		return guanlifei;
	}
	/**
	 * 设置：应付金额
	 */
	public void setYingfujine(String yingfujine) {
		this.yingfujine = yingfujine;
	}
	/**
	 * 获取：应付金额
	 */
	public String getYingfujine() {
		return yingfujine;
	}
	/**
	 * 设置：租户账号
	 */
	public void setZuhuzhanghao(String zuhuzhanghao) {
		this.zuhuzhanghao = zuhuzhanghao;
	}
	/**
	 * 获取：租户账号
	 */
	public String getZuhuzhanghao() {
		return zuhuzhanghao;
	}
	/**
	 * 设置：租户姓名
	 */
	public void setZuhuxingming(String zuhuxingming) {
		this.zuhuxingming = zuhuxingming;
	}
	/**
	 * 获取：租户姓名
	 */
	public String getZuhuxingming() {
		return zuhuxingming;
	}
	/**
	 * 设置：电话号码
	 */
	public void setDianhuahaoma(String dianhuahaoma) {
		this.dianhuahaoma = dianhuahaoma;
	}
	/**
	 * 获取：电话号码
	 */
	public String getDianhuahaoma() {
		return dianhuahaoma;
	}
	/**
	 * 设置：房东账号
	 */
	public void setFangdongzhanghao(String fangdongzhanghao) {
		this.fangdongzhanghao = fangdongzhanghao;
	}
	/**
	 * 获取：房东账号
	 */
	public String getFangdongzhanghao() {
		return fangdongzhanghao;
	}
	/**
	 * 设置：房东姓名
	 */
	public void setFangdongxingming(String fangdongxingming) {
		this.fangdongxingming = fangdongxingming;
	}
	/**
	 * 获取：房东姓名
	 */
	public String getFangdongxingming() {
		return fangdongxingming;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
