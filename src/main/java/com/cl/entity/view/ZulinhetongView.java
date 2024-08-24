package com.cl.entity.view;

import com.cl.entity.ZulinhetongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 租赁合同
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-23 17:09:49
 */
@TableName("zulinhetong")
public class ZulinhetongView  extends ZulinhetongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZulinhetongView(){
	}
 
 	public ZulinhetongView(ZulinhetongEntity zulinhetongEntity){
 	try {
			BeanUtils.copyProperties(this, zulinhetongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
