package com.creditcard.controller;

import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditcard.entities.ChangePassword;
import com.creditcard.entities.User;
import com.creditcard.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public IUserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.ACCEPTED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		User user1 = userService.loginUser(user);
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "login successful");
		response.put("username", user.getUserName());
		response.put("uid", String.valueOf(user1.getUserId()));
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
	@PutMapping("/Change Password")
	public ResponseEntity<?> changePassword(@RequestBody @Valid ChangePassword changePassword) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(userService.changePassword(changePassword.getUser(), changePassword.getNewPassword()));
	}

	@GetMapping("/id/{UserID}")
	public ResponseEntity<?> getUserById(@PathVariable ("UserID") int uid) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(uid));
	}

	@GetMapping("/un/{Username}")
	public ResponseEntity<?> getByUserName(@PathVariable ("Username") String uname) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUserName(uname));
	}

	@GetMapping()
	public List<User> getallUsers() {
		return userService.getallUsers();
	}

}