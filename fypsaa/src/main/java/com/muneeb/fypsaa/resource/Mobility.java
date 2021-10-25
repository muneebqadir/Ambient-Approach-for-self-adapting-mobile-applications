package com.muneeb.fypsaa.resource;
import com.muneeb.fypsaa.service.*;

import java.util.ArrayList;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.muneeb.fypsaa.model.Ambient;
import com.muneeb.fypsaa.model.EnterReturn;

import jakarta.json.JsonWriter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
/**
 * Holds all Mobility Endpoints 
 * @author Muneeb
 *
 */
@Path("/mobility")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Mobility {
	
	@Path("/enter")
	@POST
	public EnterReturn Enter(Ambient ambenter) {
		return ServiceManager.Enter(ambenter);		
	}
	
	@Path("/exit")
	@POST
	public boolean Exit(Ambient ambexit) {
		return ServiceManager.Exit(ambexit);
	}
	
	@GET()
	public ArrayList<String> getSiblings() {
		
		return ServiceManager.getSiblings();
	}
	
}
