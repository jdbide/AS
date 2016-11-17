package com.fr.africa.saveurs;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fr.africa.saveurs.constantes.Constantes;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/file/")
public class UploadFileService {

	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {

		String directory = null;
		String uploadLocation = null;
		String filename = fileDetail.getFileName();
		//Matcher m = checkString(filename);
		String[] split = filename.split("-");
		//boolean b = countTirets(filename.toCharArray());
//		if (split.s != null) {
//			directory = Constantes.AppDirectory + Constantes.Stores + (m.group(1).equals("R") ? Constantes.Restaurants : Constantes.Epiceries) + "//" + m.group(0) + "//";
//			uploadLocation = directory + fileDetail.getFileName();
//		}

			directory = Constantes.AppDirectory + Constantes.Stores + (split[1].equals("R") ? Constantes.Restaurants : Constantes.Epiceries) +split[0] ;
			uploadLocation = directory +"/"+ fileDetail.getFileName();


		try {
			createFolder(directory);
			// save it
			boolean success = FilesUtils.writeToFile(uploadedInputStream, uploadLocation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String output = "File uploaded to : " + uploadLocation;

		return Response.status(200).entity(output).build();

	}

	private static Pattern patt = Pattern.compile("(\\d+)-(\\d+)-(\\d+)");

	public static Matcher checkString(String s) {
		Matcher m = patt.matcher(s);
		if (m.matches())
			return m;
		return null;
	}

	public static boolean countTirets(char[] s) {
		int i = 0;
		for (char c : s) {
			//if (c.)
				//i++;
		}
		if (i == 3)
			return true;
		return false;
	}

	private void createFolder(String filePath) throws Exception {
		try {
			if (!FilesUtils.existFile(filePath)) {
				FilesUtils.mkDirs(filePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erreur de création du répertoire \"" + filePath + "\"");
			throw e;
		}
	}

}