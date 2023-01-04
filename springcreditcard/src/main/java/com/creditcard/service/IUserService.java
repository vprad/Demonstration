package com.creditcard.service;
import java.util.List;

import com.creditcard.entities.User;
import com.creditcard.exception.DuplicateUserException;
import com.creditcard.exception.InvalidLoginCredentialException;

public interface IUserService {

	public User registerUser(User user)throws DuplicateUserException;
    public User loginUser(User user) throws InvalidLoginCredentialException;

    public User changePassword(User user,String np)throws InvalidLoginCredentialException;
    public User getUserById(Integer uid);
    public User getUserByUserName(String username);
    public List<User> getallUsers();
}
