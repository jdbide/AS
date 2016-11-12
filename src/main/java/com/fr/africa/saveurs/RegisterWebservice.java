package com.fr.africa.saveurs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.fr.africa.saveurs.dto.UserDto;
import com.fr.africa.saveurs.model.ResponseBean;
import com.fr.africa.saveurs.model.UserEntity;
import com.fr.africa.saveurs.services.UserService;
import com.fr.africa.saveurs.session.CurrentSession;
import com.fr.africa.saveurs.utils.Utils;

@Path("/register")
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

	@Inject
	private UserService userService;

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
			responseBean.setData(user);
			responseBuilder = Response.ok((Object) responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("erreur register",e);
			responseBuilder = Response.status(400);
		}			
		return responseBuilder.build();
	}

}
