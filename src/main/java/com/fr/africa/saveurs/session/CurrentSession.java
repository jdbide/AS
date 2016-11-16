package com.fr.africa.saveurs.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.fr.africa.saveurs.dto.UserDto;

@SessionScoped
public class CurrentSession implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserDto currentUser;

	public CurrentSession() {
	}
	
	public UserDto getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserDto currentUser) {
		this.currentUser = currentUser;
	}
}
