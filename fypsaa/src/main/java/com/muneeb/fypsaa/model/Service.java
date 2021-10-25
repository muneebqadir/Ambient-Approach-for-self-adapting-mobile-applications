package com.muneeb.fypsaa.model;

import java.util.ArrayList;
/**
 * Holds Service name,parameter,type
 * @author Muneeb
 *
 */

public class Service {
	public String ServiceName;
	public ArrayList<String> ParamList;
	public ArrayList<String> ParamType;
	public String ReturnType;
	public ServiceCost serviceCost;
	
	/**
	 * Create a Service
	 * @param sn Service
	 * @param pl Parameters 
	 * @param pt Parameter Types
	 */
	public Service(String sn,ArrayList<String> pl,ArrayList<String> pt,String rt,ServiceCost sc) {
		ServiceName = sn;
		ParamList = pl;
		ParamType = pt;
		this.ReturnType=rt;
		this.serviceCost=sc;
	}

}

