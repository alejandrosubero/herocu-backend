package com.backenwebmail.modelo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Emailcfg {


	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.port}")
	private int port;

	private String username;

	private String password;


	public Emailcfg() {
	}


	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Emailcfg emailcfg = (Emailcfg) o;
		return port == emailcfg.port && Objects.equals(host, emailcfg.host) && Objects.equals(username, emailcfg.username) && Objects.equals(password, emailcfg.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(host, port, username, password);
	}

	@Override
	public String toString() {
		return "Emailcfg{" +
				"host='" + host + '\'' +
				", port=" + port +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
