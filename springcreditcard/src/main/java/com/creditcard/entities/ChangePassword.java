package com.creditcard.entities;

import javax.validation.constraints.Pattern;

public class ChangePassword {

	private User user;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()â€“[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password constraints not satisfied!")
    private String newPassword;
    
	
    public ChangePassword() {
		super();
	}
	public ChangePassword(User user, String newPassword) {
		super();
		this.user = user;
		this.newPassword = newPassword;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
    
}
