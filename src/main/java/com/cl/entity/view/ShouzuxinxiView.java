package com.cl.entity.view;

import com.cl.entity.ShouzuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 收租信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@TableName("shouzuxinxi")
public class ShouzuxinxiView  extends ShouzuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShouzuxinxiView(){
	}
 
 	public ShouzuxinxiView(ShouzuxinxiEntity shouzuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, shouzuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
