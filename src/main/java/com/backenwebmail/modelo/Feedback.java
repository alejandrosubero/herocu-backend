package com.backenwebmail.modelo;

import javax.validation.constraints.NotNull;


public class Feedback {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String feedback;

    private String token;

	public  Feedback(){
	}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
