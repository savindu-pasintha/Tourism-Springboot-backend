package com.REST_SERVICE_CONTROLL;

import com.Normal_Mysql_Database.databasePkg.Login;
import com.Normal_Mysql_Database.databasePkg.Reservation;
import com.Normal_Mysql_Database.modelsPkg.ReservationModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class PutData {
	
	@PutMapping(value = "/api/profile/{id}/{name}/{email}/{mobile}")
	public boolean updateCustomerProfile(@PathVariable("id") int id,
										 @PathVariable("name") String name,
										 @PathVariable("email") String email,
										 @PathVariable("mobile") String mobile
										 ) throws SQLException, ClassNotFoundException {
		return new Login().updateCustomer(id,name,mobile,email);
	}

	@PutMapping(value = "/api/reservation/{bi}/{ui}/{ri}/{bd}/{sd}/{ed}/{a}")
	public boolean updateReservation(@PathVariable("bi") int bi,
									 @PathVariable("ui") int ui,
									 @PathVariable("ri") int ri,
									 @PathVariable("bd") String bd,
									 @PathVariable("sd") String sd,
									 @PathVariable("ed") String ed,
									 @PathVariable("a") Float a
									) throws SQLException, ClassNotFoundException {
		ReservationModel obj=new ReservationModel();
		obj.setBookingId(bi);
		obj.setUserId(ui);
		obj.setRoomID(ri);
		obj.setBookingDate(bd);
		obj.setStartDate(sd);
		obj.setEndDate(ed);
		obj.setAmount(a);
		return new Reservation().update(obj);
	}
}
