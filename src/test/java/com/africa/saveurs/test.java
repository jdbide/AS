package com.africa.saveurs;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.fr.africa.saveurs.FilesUtils;


public class test {

	
    @Test
    public void createfolder(){
    	try {
			createFolder("D:/test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertTrue(new File("D:/1").exists());
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
