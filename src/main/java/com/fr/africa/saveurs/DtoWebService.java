package com.fr.africa.saveurs;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.simple.JSONArray;

import com.fr.africa.saveurs.dto.StoreDto;
import com.fr.africa.saveurs.dto.UserDto;
import com.fr.africa.saveurs.entities.User;
import com.fr.africa.saveurs.model.ResponseBean;
import com.fr.africa.saveurs.services.UserService;
import com.fr.africa.saveurs.utils.Utils;

@Path("/dto/")
@RequestScoped
public class DtoWebService {

	private static Logger logger = Logger.getLogger(RegisterWebservice.class);
	
	//@Inject
	//private CurrentSession currentSession;
	
	private UserDto userDto;
	

	private StoreDto storeDto;

	//private UserService userService = new UserService();
	@Inject
	private UserService userService;

	
	@Path("getStoreDto")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam("idUser")long idUser) throws JSONException {	
		ResponseBuilder responseBuilder = null;
		ResponseBean responseBean = new ResponseBean();		
		try {
			storeDto = new StoreDto();
			storeDto.initStoreDto();
			responseBean.setData(storeDto);
			responseBean.setStatus(true);
			responseBuilder = Response.ok((Object) responseBean);
		
			//currentSession.getCurrentUser().initUserDto();
			//System.out.println("noooom " + currentSession.getCurrentUser().getNom());
			
		} catch (Exception e) {
			responseBean.setStatus(false);
			e.printStackTrace();
			responseBuilder = Response.status(400);
		}			
		return responseBuilder.build();
	}
	
	@Path("getUserDto")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUserDto() throws JSONException {	
		ResponseBuilder responseBuilder = null;
		ResponseBean responseBean = new ResponseBean();		
		try {
			userDto = new UserDto();
			userDto.initUserDto();
			responseBean.setData(userDto);
			responseBean.setStatus(true);
			responseBuilder = Response.ok((Object) responseBean);
			
		} catch (Exception e) {
			responseBean.setStatus(false);
			e.printStackTrace();
			responseBuilder = Response.status(400);
		}			
		return responseBuilder.build();
	}

}
