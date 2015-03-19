/**
 * @Project: labs
 * @Author: Peter
 * @Date: Mar 20, 2015 12:29:18 AM
 * @Website: www.italycappuccino.com 
 * @Email: italycappuccino@gmail.com
 * @WangWang: italypeter
 * @QQ: 21563860
 * @Copyright: 3Stock Inc. All rights reserved.
 */
package com.stone.labs.memory;

/**
 * @author Peter
 * @create Mar 20, 2015
 */
public class CalcMem {
	public static void main(String[] args) {
		System.gc();
		long a = Runtime.getRuntime().totalMemory();
		long b = Runtime.getRuntime().freeMemory();
		System.out.println(a);
		System.out.println(b);
		System.out.println(a - b);
	}
}
