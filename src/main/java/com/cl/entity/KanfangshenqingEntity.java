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
 * 看房申请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@TableName("kanfangshenqing")
public class KanfangshenqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KanfangshenqingEntity() {
		
	}
	
	public KanfangshenqingEntity(T t) {
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
	 * 房屋名称
	 */
					
	private String fangwumingcheng;
	
	/**
	 * 房屋户型
	 */
					
	private String fangwuhuxing;
	
	/**
	 * 房屋地址
	 */
					
	private String fangwudizhi;
	
	/**
	 * 租赁价格
	 */
					
	private String zulinjiage;
	
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
	 * 看房时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date kanfangshijian;
	
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
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	
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
	 * 设置：房屋名称
	 */
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
	/**
	 * 设置：房屋户型
	 */
	public void setFangwuhuxing(String fangwuhuxing) {
		this.fangwuhuxing = fangwuhuxing;
	}
	/**
	 * 获取：房屋户型
	 */
	public String getFangwuhuxing() {
		return fangwuhuxing;
	}
	/**
	 * 设置：房屋地址
	 */
	public void setFangwudizhi(String fangwudizhi) {
		this.fangwudizhi = fangwudizhi;
	}
	/**
	 * 获取：房屋地址
	 */
	public String getFangwudizhi() {
		return fangwudizhi;
	}
	/**
	 * 设置：租赁价格
	 */
	public void setZulinjiage(String zulinjiage) {
		this.zulinjiage = zulinjiage;
	}
	/**
	 * 获取：租赁价格
	 */
	public String getZulinjiage() {
		return zulinjiage;
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
	 * 设置：看房时间
	 */
	public void setKanfangshijian(Date kanfangshijian) {
		this.kanfangshijian = kanfangshijian;
	}
	/**
	 * 获取：看房时间
	 */
	public Date getKanfangshijian() {
		return kanfangshijian;
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
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}

}
