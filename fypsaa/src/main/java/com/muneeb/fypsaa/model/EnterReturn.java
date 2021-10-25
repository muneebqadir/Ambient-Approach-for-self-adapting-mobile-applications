package com.muneeb.fypsaa.model;

import java.util.ArrayList;
/**
 * POJO returned when an Ambient enters through REST Apis
 * @author Muneeb
 *
 */
public class EnterReturn {
	
	public boolean result;
	public Ambient ParentInstance;
	
	/**
	 * 
	 * @param res Result(boolean)
	 * @param parent Instance of Parent
	 */
	public EnterReturn(boolean res,Ambient parent) {
		result =res;
		ParentInstance = parent;
		
	}
	

}
