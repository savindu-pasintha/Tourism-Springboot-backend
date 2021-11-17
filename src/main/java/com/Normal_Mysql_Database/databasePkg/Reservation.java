package com.Normal_Mysql_Database.databasePkg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Normal_Mysql_Database.modelsPkg.ReservationModel;

public class Reservation extends Database {

	public Reservation() throws SQLException, ClassNotFoundException {
		super();
	}

	public ArrayList<ReservationModel> readAll() throws SQLException {
		ArrayList<ReservationModel> mpList = new ArrayList<ReservationModel>();
		ResultSet resultSe = super.read("SELECT * FROM `reservation` ");
		if (resultSet != null) {
			while (resultSe.next()) {
				ReservationModel mp = new ReservationModel();
				mp.setBookingId(resultSe.getInt("r_id"));
				mp.setRoomID(resultSe.getInt("cust_id"));
				mp.setUserId(resultSe.getInt("room_id"));
				mp.setBookingDate(resultSet.getString("booking_date"));
				mp.setStartDate(resultSet.getString("start_date"));
				mp.setEndDate(resultSet.getString("end_date"));
				mp.setAmount(resultSet.getInt("amount"));
				mpList.add(mp);
			}
			super.conn.close();
		}

		return mpList;
	}

	public boolean add(ReservationModel obj) throws SQLException {
		String query = "INSERT INTO `reservation`(`r_id`, `cust_id`, `room_id`, `booking_date`, `start_date`, `end_date`, `amount`) " +
				"VALUES (?,?,?,?,?,?,?)";
		super.add(query);
		super.pStatment.setInt(1,obj.getBookingId());
		super.pStatment.setInt(2,obj.getUserId());
		super.pStatment.setInt(3,obj.getRoomID());
		super.pStatment.setString(4,obj.getBookingDate());
		super.pStatment.setString(5,obj.getStartDate());
		super.pStatment.setString(6,obj.getEndDate());
		super.pStatment.setFloat(7,obj.getAmount());
		return super.executeQuery();
		// id=int autoincrement
	}

	public boolean update(ReservationModel obj) throws SQLException {
		super.update("UPDATE `reservation` SET `r_id`=?,`cust_id`=?,`room_id`=?,`booking_date`=?,`start_date`=?,`end_date`=?,`amount`=? WHERE `r_id`=?");
		super.pStatment.setInt(1, obj.getBookingId());
		super.pStatment.setInt(2, obj.getUserId());
		super.pStatment.setInt(3,obj.getRoomID());
		super.pStatment.setString(4, obj.getBookingDate());
		super.pStatment.setString(5,obj.getStartDate());
		super.pStatment.setString(6,obj.getEndDate());
		super.pStatment.setFloat(7,obj.getAmount());
		super.pStatment.setInt(8,obj.getBookingId());
		return super.executeQuery();
	}

	public boolean delete(int id) throws SQLException {
		String query = "DELETE FROM `reservation` WHERE r_id = ?";
		super.pStatment.setInt(1,id);
		super.delete(query);
		return super.executeQuery();
	}
	
	
	

}
