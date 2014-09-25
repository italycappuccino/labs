/**
 * @Project: edu
 * @Author: Peter
 * @Date: 2014年8月30日
 * www.italycappuccino.com italycappuccino@gmail.com
 * 
 * @Copyright: 3Stock Inc. All rights reserved.
 */
package com.stone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @author Peter
 * @create 2014年8月30日
 */
@Component
public class MessagePrinter {
	
	final private MessageService service;
	
	@Autowired
	public MessagePrinter(MessageService service){
		this.service = service;
	}
	
	public void printMessage(){
		System.out.println(this.service.getMessage());
	}

}
