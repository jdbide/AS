package com.fr.africa.saveurs;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.fr.africa.saveurs.dto.PaysDto;
import com.fr.africa.saveurs.dto.UserDto;
import com.fr.africa.saveurs.entities.Pays;
import com.fr.africa.saveurs.model.ResponseBean;
import com.fr.africa.saveurs.services.PaysService;
import com.fr.africa.saveurs.services.UserService;
import com.fr.africa.saveurs.utils.Utils;
import com.mysql.fabric.xmlrpc.base.Array;

@Path("/pays/")
@RequestScoped
public class PaysWebservice {


	private static Logger logger = Logger.getLogger(PaysWebservice.class);
	
	//@Inject
	//private CurrentSession currentSession;
	
	private UserDto userDto;

	//private UserService userService = new UserService();
	@Inject
	private UserService userService;
	
	@Inject
	private PaysService paysService;

	@Path("getPays")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPays() throws JSONException {
		
		ResponseBuilder responseBuilder = null;
		ResponseBean responseBean = new ResponseBean();		
		List<PaysDto> liste = new ArrayList<>();
		try {
			for(Pays pays : paysService.getAll()){
				liste.add(Utils.PaysEntityToDto(pays));
			}
			responseBean.setData(liste);
			responseBean.setStatus(true);
			responseBuilder = Response.ok((Object) responseBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("erreur getpays",e);
			responseBean.setStatus(false);
			responseBean.setMessage("Récupération de la liste des pays impossible");
			responseBuilder = Response.status(400);
		}			
		return responseBuilder.build();
	}
}
