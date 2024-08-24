package com.cl.entity.view;

import com.cl.entity.KanfangshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 看房申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@TableName("kanfangshenqing")
public class KanfangshenqingView  extends KanfangshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KanfangshenqingView(){
	}
 
 	public KanfangshenqingView(KanfangshenqingEntity kanfangshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, kanfangshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
