package com.Normal_Mysql_Database.databasePkg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Normal_Mysql_Database.modelsPkg.ContactModel;

public class Contact extends Database{
	public Contact() throws SQLException, ClassNotFoundException {
		super();
	}

	public ArrayList<ContactModel> read() throws SQLException {
		ArrayList<ContactModel> cmList = new ArrayList<ContactModel>();
		ResultSet resultSe = super.read("SELECT * FROM contact");
		if (resultSet != null) {
			while (resultSe.next()) {
				ContactModel cm = new ContactModel();
				cm.setId(resultSe.getInt("id"));
				cm.setName(resultSe.getString("name"));
				cm.setEmail(resultSe.getString("email"));
				cm.setMessage(resultSe.getString("message"));
				cm.setCall(resultSe.getString("call"));
				cm.setTimestamp(resultSe.getString("timestamp"));
				cmList.add(cm);
			}
			super.conn.close();
		}
		
		return cmList;
	}
	
	public boolean add(ContactModel ob) throws SQLException {
		String query = "INSERT INTO `contact` (`id`,`name`, `email`, `call`, `message`,`timestamp`) "
				+ "      VALUES (?,?,?, ?,?,?)";
		// id - autoincremnet , timestamp - autoset
		super.add(query);
		super.pStatment.setInt(1, 0);
		super.pStatment.setString(2,ob.getName());
		super.pStatment.setString(3,ob.getEmail());
		super.pStatment.setString(4,ob.getCall());
		super.pStatment.setString(5,ob.getMessage());
		super.pStatment.setString(6, null);
		return super.executeQuery();
	}
	
	
}
