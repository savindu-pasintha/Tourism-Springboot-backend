package com.REST_SERVICE_CONTROLL;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatchData {
	@PatchMapping(value = "/api/users")
	public String updateUser(String s) {
		return s;
	}
}
