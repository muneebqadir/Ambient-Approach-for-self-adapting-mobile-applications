package com.muneeb.fypsaa.resource;
import java.util.ArrayList;

import com.muneeb.fypsaa.model.Service;
import com.muneeb.fypsaa.service.ServiceManager;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Services {

	@GET()
	public ArrayList<Service> getServices() {
		return ServiceManager.getServices();
	}
	
	@Path("/friendservice")
	@GET()
	public String getFriends() {
		return "Test";
	}
	
	
	
}
