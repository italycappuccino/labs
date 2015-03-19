/**
 * @Project: labs
 * @Author: Peter
 * @Date: Mar 19, 2015
 * www.italycappuccino.com 
 * italycappuccino@gmail.com
 * @Copyright: 3Stock Inc. All rights reserved.
 */
package com.stone.labs.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.stone.labs.cglib.Entity;
import com.stone.labs.cglib.ModelReflector;

/**
 * @author Peter
 * @create Mar 19, 2015
 */
public class ExcelUtils {
	/**
	 * Entity property number
	 */
	private static final int PN = 40;
	private static final int LINE = 1000;
	private static final String column = "column";
	private static final String PREFIX = "420582198609020658";
	private static final String address = "阿里巴巴集团服务有限公司香港铜锣湾勿地臣街1号时代广场1座26楼";
	Gson gson = new Gson();

	public static void main(String[] args) {
		new ExcelUtils().testMap();
	}

	private void testMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < LINE; i++) {
			Entity t = this.bindModel(Entity.class);
			System.out.println("object " + i + "=" + gson.toJson(t));
			map.put(PREFIX + i, t);
		}
		System.out.println("size=" + map.size());
		byte[] b = this.ObjectToByte(map);
		System.out.println("byte=" + b.length);
	}

	public static <T> T bindModel(Class<T> cls) {
		try {
			JSONObject json = new JSONObject();
			for (int i = 0; i < PN; i++) {
				json.put(column + i, address + i);
			}
			T instance = cls.newInstance();
			Iterator<String> it = json.keys();
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

	/**
	 * ObjectToByte
	 * 
	 * @param obj
	 * @return
	 */
	private byte[] ObjectToByte(Object obj) {
		byte[] bytes = new byte[0];
		try {
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(bs);
			os.writeObject(obj);
			bytes = bs.toByteArray();
			bs.close();
			os.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bytes;
	}

	/**
	 * ByteToObject
	 * 
	 * @param bytes
	 * @return
	 */
	private Object ByteToObject(byte[] bytes) {
		Object obj = null;
		try {
			ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
			ObjectInputStream os = new ObjectInputStream(bs);
			obj = os.readObject();
			bs.close();
			os.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return obj;
	}
}
