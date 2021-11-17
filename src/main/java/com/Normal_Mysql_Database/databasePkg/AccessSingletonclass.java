package com.Normal_Mysql_Database.databasePkg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Normal_Mysql_Database.modelsPkg.CustomerModel;

public class AccessSingletonclass {
	private Singleton obj = null;

	public AccessSingletonclass() throws ClassNotFoundException, SQLException {
		obj = Singleton.getInstance();
	}

	public ArrayList<CustomerModel> read() throws SQLException, ClassNotFoundException {
		ResultSet resultSet = obj.read("SELECT * FROM `login`");
		ArrayList<CustomerModel> alm = new ArrayList<CustomerModel>();
		if (resultSet != null) {
			int id = 0;
			while (resultSet.next()) {
				CustomerModel lm = new CustomerModel();
				lm.setId(id);
				lm.setUsername(resultSet.getString("username"));
				lm.setPassword(resultSet.getString("password"));
				alm.add(lm);
				id++;
			}
		}
		return alm;
	}

	public boolean add(String username, String password) throws SQLException {

		obj.add("INSERT INTO `login` (`username`, `password`, `timestamp`) VALUES (?,?,?)");
		obj.pStatment.setString(1, username);
		obj.pStatment.setString(2, password);
		obj.pStatment.setString(3, null);
		return obj.executeQuery();
		// id:autoincrement int
	}

	public boolean update(String username, String password, String idUsername) throws SQLException {
		obj.update("UPDATE `login` SET `username`=?, `password`=? WHERE `username`=?");
		obj.pStatment.setString(1, username);
		obj.pStatment.setString(2, password);
		obj.pStatment.setString(3, idUsername);
		return obj.executeQuery();
	}

	public boolean deletec(String username) throws SQLException {
		obj.delete("DELETE FROM `login` WHERE `username`=?");
		obj.pStatment.setString(1, username);
		return obj.executeQuery();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(new AccessSingletonclass().read().get(1).getUsername());
		System.out.println(new AccessSingletonclass().deletec("ff"));
	}

}
