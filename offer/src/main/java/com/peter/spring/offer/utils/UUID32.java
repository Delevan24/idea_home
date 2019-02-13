package com.peter.spring.offer.utils;

import java.util.UUID;

/**
 * 
 * 
 * 此类描述的是：UUID 主键的生成
 * 
 * @author: vshao1991@gmail.com
 */
public final class UUID32 {
	/**
	 * 
	 * 此方法描述的是：
	 * 
	 * @author: vshao E-mail:vshao1991@gmail.com
	 * @return:String
	 */
	public synchronized static String createUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
