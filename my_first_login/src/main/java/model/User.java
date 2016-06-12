package model;

import java.io.IOException;

import javax.faces.context.FacesContext;


public class User {
	private String name;
	private String password;
	private boolean loggedIn;

	public User() {
		loggedIn = false;
	}

	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws IOException{
		String ret = "failed";
		// TODO name und password ueberpruefen - im Fehlerfall "failed" returnen,
		// ansonsten "loggedIn" auf true setzen und "success" returnen
		if(name.equals("tester") && password.equals("ichdarfrein")) {
			loggedIn = true;
			ret = "success";
		} else {
			loggedIn = false;
			ret = "failed";
			FacesContext.getCurrentInstance().getExternalContext().redirect("google.at");
		}
		return ret;
	}

	public String logout() {
		loggedIn = false;
		// This session is now invalid!
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "logout";
	}
}