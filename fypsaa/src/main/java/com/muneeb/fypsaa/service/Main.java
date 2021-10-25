package com.muneeb.fypsaa.service;

import java.util.ArrayList;

import com.muneeb.fypsaa.client.MobilityClient;
import com.muneeb.fypsaa.model.Location;
import com.muneeb.fypsaa.model.RootAmbient;
import com.muneeb.fypsaa.model.Service;
/**
 * Will hold instances of Ambients to be used everywhere
 * @author Muneeb
 *
 */
public class Main {
	
	static TestCinema cinestar;
	static RootAmbient root;
	static Location screeningroom;
	
	ArrayList<String>ParamFriends = new ArrayList<String>();
	ArrayList<String> ParamFriendsType = new ArrayList<String>();
	Service Friends = new Service("Friends Service",ParamFriends,ParamFriendsType,null,null);
	

	public Main() {
		try {
			cinestar = new TestCinema("cinestar");
			cinestar.AddService(Friends);
			//screeningroom = new Location("screeningroom");
			root = new RootAmbient();
			root.Enter(cinestar);
			root.Enter(screeningroom);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
