package com.fr.africa.saveurs;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
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

import com.fr.africa.saveurs.dto.UserDto;
import com.fr.africa.saveurs.model.Pays;
import com.fr.africa.saveurs.model.ResponseBean;
import com.fr.africa.saveurs.model.User;
import com.fr.africa.saveurs.model.UserEntity;
import com.fr.africa.saveurs.services.UserService;
import com.fr.africa.saveurs.utils.Utils;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Path("/user/")
@RequestScoped
public class RegisterWebservice {

	// Logger log4j
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(RegisterWebservice.class);
	
//	@Inject
//	private CurrentSession currentSession;
//	
//	@Inject
//	private UserDto userDto;

	private UserService userService = new UserService();

	@Path("register")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON})
	public Response register(UserDto newUser) throws JSONException {
		
		ResponseBuilder responseBuilder = null;
		ResponseBean responseBean = new ResponseBean();		
		
		UserDto userDto = new UserDto();		
		userDto.setNom(newUser.getNom());
		userDto.setPrenom(newUser.getPrenom());
		userDto.setMail(newUser.getMail());
		userDto.getVille().setIdVille(1);
		try {
			userService.save(Utils.UserDtoToEntity(userDto));
			responseBean.setData(userDto);
			responseBean.setStatus(true);
			responseBuilder = Response.ok((Object) responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("erreur register",e);
			responseBean.setStatus(false);
			responseBean.setMessage("Impossible de creer le user");
			responseBuilder = Response.status(400);
		}			
		return responseBuilder.build();
	}
	
	@Path("getAll")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllUsers() throws JSONException {
		ResponseBuilder responseBuilder = null;
		ResponseBean responseBean = new ResponseBean();		
		JSONArray jsonArray = new JSONArray();
		try {
			List<User> liste = userService.getAllUsers();
			List<UserDto> listeDto = new ArrayList<>();
			/*for(UserEntity userEntity: liste){
				listeDto.add(Utils.UserEntityToDto(userEntity));
			}*/
			responseBean.setData(liste);
			responseBean.setStatus(true);
			responseBuilder = Response.ok((Object) responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setStatus(false);
			logger.error("erreur get all users",e);
			responseBuilder = Response.status(400);
		}			
		return responseBuilder.build();
	}
	
	@Path("get/{idUser}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam("idUser")long idUser) throws JSONException {	
		ResponseBuilder responseBuilder = null;
		ResponseBean responseBean = new ResponseBean();		
		try {
			User userEntity = userService.getAUser(idUser);
			responseBean.setData(Utils.UserEntityToDto(userEntity));
			responseBean.setStatus(true);
			responseBuilder = Response.ok((Object) responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			responseBean.setStatus(false);
			logger.error("erreur get all users",e);
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
			responseBean.setData(new UserDto());
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
