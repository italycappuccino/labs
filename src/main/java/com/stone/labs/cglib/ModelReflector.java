/**
 * @Project: labs
 * @Author: Peter
 * @Date: Mar 20, 2015 1:37:26 AM
 * @Website: www.italycappuccino.com 
 * @Email: italycappuccino@gmail.com
 * @WangWang: italypeter
 * @QQ: 21563860
 * @Copyright: 3Stock Inc. All rights reserved.
 */
package com.stone.labs.cglib;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Peter
 * @create Mar 20, 2015
 */
public class ModelReflector {

	public static Object setProperty(Object bean, String propertyName,
			Object value) {
		Class clazz = bean.getClass();
		try {
			Field field = clazz.getDeclaredField(propertyName);
			Method method = clazz.getDeclaredMethod(
					getSetterName(field.getName()),
					new Class[] { field.getType() });
			return method.invoke(bean, new Object[] { value });
		} catch (Exception e) {
		}
		return null;
	}

	public static String getGetterName(String propertyName) {
		String method = "get" + propertyName.substring(0, 1).toUpperCase()
				+ propertyName.substring(1);
		return method;
	}

	public static String getSetterName(String propertyName) {
		String method = "set" + propertyName.substring(0, 1).toUpperCase()
				+ propertyName.substring(1);
		return method;
	}
}
