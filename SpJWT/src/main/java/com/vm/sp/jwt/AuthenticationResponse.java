package com.vm.sp.jwt;

public class AuthenticationResponse {

	String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
}
