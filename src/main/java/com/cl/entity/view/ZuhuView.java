package com.cl.entity.view;

import com.cl.entity.ZuhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 租户
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@TableName("zuhu")
public class ZuhuView  extends ZuhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuhuView(){
	}
 
 	public ZuhuView(ZuhuEntity zuhuEntity){
 	try {
			BeanUtils.copyProperties(this, zuhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
