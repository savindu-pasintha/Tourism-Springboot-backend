package com.REST_SERVICE_CONTROLL;

import com.Normal_Mysql_Database.databasePkg.Reservation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class DeleteData {


	@DeleteMapping(value = "/api/users/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		return id;
	}

	@DeleteMapping(value = "/api/reservation/{id}")
	public boolean deleteReservationById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException {
		return new Reservation().delete(id);
	}
}
