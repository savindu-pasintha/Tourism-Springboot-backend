package com.REST_SERVICE_CONTROLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Normal_Mysql_Database.databasePkg.Login;
import com.Normal_Mysql_Database.databasePkg.Reservation;
import com.Normal_Mysql_Database.modelsPkg.AdminModel;
import com.Normal_Mysql_Database.modelsPkg.CustomerModel;
import com.Normal_Mysql_Database.modelsPkg.ReservationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetData {
	
	@GetMapping(value = "/api/customer")
	public ArrayList<CustomerModel> getAllCustomer() throws SQLException, ClassNotFoundException {
		return new Login().getAllCustomer();
	}

	@GetMapping(value = "/api/admin")
	public ArrayList<AdminModel> getAllAdmin() throws SQLException, ClassNotFoundException {
		return new Login().getAllAdmin();
	}

	@GetMapping(value = "/api/reservation")
	public ArrayList<ReservationModel> getAllReservation() throws SQLException, ClassNotFoundException {
		return new Reservation().readAll();
	}

}
