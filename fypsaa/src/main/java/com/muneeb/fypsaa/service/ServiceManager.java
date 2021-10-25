package com.muneeb.fypsaa.service;
/**
 * Manages all REST Requests Mobility+Services
 */

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.muneeb.fypsaa.model.Ambient;
import com.muneeb.fypsaa.model.EnterReturn;
import com.muneeb.fypsaa.model.RootAmbient;
import com.muneeb.fypsaa.model.Service;
import com.muneeb.fypsaa.resource.Services;

public class ServiceManager {
	
	public static Main main = new Main();

	/**
	 * Processes REST Enter request
	 * @param ambenter instance of Ambient
	 * @return EnterReturn Object {@link com.muneeb.fypsaa.model.EnterReturn EnterReturn}
	 * 
	 */
	public static EnterReturn Enter(Ambient ambenter) {
		EnterReturn ret;
	    if(main.cinestar.Enter(ambenter)) {
	    	ret = new EnterReturn(true, main.cinestar);
		}
		else {
			ret = new EnterReturn(false,null);
		}
	    return ret;
	}
	
	/**
	 * Processes REST Exit Request
	 * @param ambexit Instance of Object
	 * @return True or False depending on ambient was able to exit
	 */
	public static boolean Exit(Ambient ambexit) {
		System.out.println("Request recieved service exit ");
		return main.cinestar.Exit(ambexit);
	}
	
	/**
	 * All children of requested Ambient 
	 * @return ArrayList children of Ambient
	 */
	public static ArrayList<String> getSiblings(){
		return main.cinestar.children;
	} 
	
	/**
	 * All Services of requested Ambient 
	 * @return ArrayList Services of Ambient
	 */
	public static ArrayList<Service> getServices(){
		return main.cinestar.services;
	}
	
}
