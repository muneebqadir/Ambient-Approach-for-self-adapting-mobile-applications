package com.muneeb.fypsaa.client;

import java.io.IOException;

import org.glassfish.jersey.client.ClientResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.muneeb.fypsaa.model.Ambient;
import com.muneeb.fypsaa.model.EnterReturn;
import com.muneeb.fypsaa.model.Group;
import com.muneeb.fypsaa.model.Location;
import com.muneeb.fypsaa.model.RootAmbient;
import com.muneeb.fypsaa.service.ServiceManager;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class MobilityClient {
	
	public static EnterReturn Enter(Ambient amb) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080").path("fypsaa/webapi/mobility/enter");
		String jsonObject = ambientToJsonString(amb);
		Response response = target.request().header("Content-type", MediaType.APPLICATION_JSON).post(Entity.json(jsonObject));
		String resbody = response.readEntity(String.class);
		EnterReturn ret = JSONtoEnterReturn(resbody);
		return ret;
	}
	
	public static String Exit(Ambient amb) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080").path("fypsaa/webapi/mobility/exit");
		String jsonObject = ambientToJsonString(amb);
		Response response = target.request().header("Content-type", MediaType.APPLICATION_JSON).post(Entity.json(jsonObject));
		String resbody = response.readEntity(String.class);
		return resbody;
	}
	
	public static String getSiblings() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080").path("fypsaa/webapi/mobility");
		Response response = target.request().header("Content-type", MediaType.APPLICATION_JSON).get();
		String resbody = response.readEntity(String.class);
		System.out.println(resbody);
		return resbody;
	}
	
	public static String ambientToJsonString(Ambient amb) {
		String jsonObject = null;
		try {
			jsonObject = new ObjectMapper().writeValueAsString(amb);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	public static EnterReturn JSONtoEnterReturn(String jsonString) {
		EnterReturn EntrObject = null;
		try {
	        EntrObject =new ObjectMapper().readValue(jsonString, EnterReturn.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EntrObject;
	}
	
	
}
