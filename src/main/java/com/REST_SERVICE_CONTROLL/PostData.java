package com.REST_SERVICE_CONTROLL;

import com.Normal_Mysql_Database.databasePkg.Login;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class PostData {

	@PostMapping(value = "/api/login/customer/{user}/{pass}")
	public boolean customerLogin(@PathVariable("user") String u,@PathVariable("pass") String p) throws SQLException, ClassNotFoundException {
		return new Login().customerValid(u,p);
	}

	@PostMapping(value = "/api/login/admin/{user}/{pass}")
	public boolean adminLogin(@PathVariable("user") String u,@PathVariable("pass") String p) throws SQLException, ClassNotFoundException {
		return new Login().customerValid(u,p);
	}

	@PostMapping(value = "/api/customer/{id}/{username}/{email}/{mobile}/{password}")
	public Boolean customerAdd(
			@PathVariable("id") int id,
			@PathVariable("username") String u,
								   @PathVariable("email") String e,
								   @PathVariable("mobile") String m,
								   @PathVariable("password") String p, String request) throws SQLException, ClassNotFoundException {
		return new Login().addCustomer(id,u,e,m,p);
	}

	@PostMapping(value = "/api/admin/{id}/{hotelId}/{name}/{email}/{password}")
	public Boolean adminAdd(
			@PathVariable("id") int id,
			@PathVariable("hotelId") int hi,
			@PathVariable("name") String n,
			@PathVariable("email") String e,
			@PathVariable("password") String p, String request) throws SQLException, ClassNotFoundException {
		return new Login().addAdmin(id,hi,n,e,p);
	}
}
