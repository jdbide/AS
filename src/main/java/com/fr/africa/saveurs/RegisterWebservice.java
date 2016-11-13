package com.fr.africa.saveurs;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
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
import com.fr.africa.saveurs.model.ResponseBean;
import com.fr.africa.saveurs.model.UserEntity;
import com.fr.africa.saveurs.services.UserService;
import com.fr.africa.saveurs.utils.Utils;

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
	public Response register(String nom, String prenom, String email) throws JSONException {
		
		
		
		ResponseBuilder responseBuilder = null;
		ResponseBean responseBean = new ResponseBean();		

		UserEntity user = Utils.UserDtoToEntity(new UserDto());
		/*user.setNom(nom);
		user.setPrenom(prenom);
		user.setMail(email);*/
		try {
			userService.save(user);
			//new UserService().save(user);
			responseBean.setData(new UserDto());
			responseBuilder = Response.ok((Object) responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("erreur register",e);
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
			List<UserEntity> liste = userService.getAllUsers();
			List<UserDto> listeDto = new ArrayList<>();
			/*for(UserEntity userEntity: liste){
				listeDto.add(Utils.UserEntityToDto(userEntity));
			}*/
			responseBean.setData(liste);
			responseBuilder = Response.ok((Object) responseBean);
		} catch (Exception e) {
			e.printStackTrace();
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
			UserEntity userEntity = userService.getAUser(idUser);
			responseBean.setData(Utils.UserEntityToDto(userEntity));
			responseBuilder = Response.ok((Object) responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("erreur get all users",e);
			responseBuilder = Response.status(400);
		}			
		return responseBuilder.build();
	}

}
