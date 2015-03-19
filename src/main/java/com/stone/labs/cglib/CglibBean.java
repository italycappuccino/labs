/**
 * @Project: labs
 * @Author: Peter
 * @Date: Mar 20, 2015 1:37:16 AM
 * @Website: www.italycappuccino.com 
 * @Email: italycappuccino@gmail.com
 * @WangWang: italypeter
 * @QQ: 21563860
 * @Copyright: 3Stock Inc. All rights reserved.
 */
package com.stone.labs.cglib;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Peter
 * @create Mar 20, 2015
 */
public class CglibBean {

	public static <T> T bindModel(String content, Class<T> cls) {
		try {
			JSONObject json = new JSONObject(content);
			T instance = cls.newInstance();
			Iterator it = json.keys();
			while (it.hasNext()) {
				String next = it.next().toString();
				ModelReflector.setProperty(instance, next, json.get(next)
						.toString());
			}
			return instance;
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
