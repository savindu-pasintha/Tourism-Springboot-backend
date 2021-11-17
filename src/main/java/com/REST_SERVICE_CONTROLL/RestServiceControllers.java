package com.REST_SERVICE_CONTROLL;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endPoint")
public class RestServiceControllers {
	
	
	@GetMapping(value = "/users")
	public String get() {
		return "users";
	}

	@PostMapping(value = "/users")
	public String post(String s) {
		return s;
	}
	
	@PatchMapping(value = "/users")
	public String update(String s) {
		return s;
	}

	@DeleteMapping(value = "/users/{id}")
	public String delete(@PathVariable("id") String id) {
		//http://localhost:8080/users/10
		return id;//=10
	}
}
