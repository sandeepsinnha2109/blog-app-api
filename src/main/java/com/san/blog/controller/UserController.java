package com.san.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.blog.payloads.ApiResponse;
import com.san.blog.payloads.UserDto;
import com.san.blog.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createdUserDto = userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED); 
	}
	
	@PostMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updatedUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
		UserDto updatedUserDto=this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUserDto);
	}
	
//	@PostMapping("/{userId}")
//	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
//		 this.userService.deleteUser(uid);
//		 return new ResponseEntity(Map.of("message","User deleted successfully"),HttpStatus.OK);
//	}
//	
	//by using api response class
	@PostMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
	}
	
	/**
	 * get all users
	 * @return
	 */
		
	@GetMapping("/allUser")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	/**
	 * Get user by Id
	 */
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable("userId") Integer uid){
		
		return ResponseEntity.ok(this.userService.getUserById(uid));
	}
	
}
