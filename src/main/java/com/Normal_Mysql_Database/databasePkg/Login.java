package com.Normal_Mysql_Database.databasePkg;

import com.Normal_Mysql_Database.modelsPkg.AdminModel;
import com.Normal_Mysql_Database.modelsPkg.CustomerModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Login extends Database {
	public String ss ="savindu";

	public Login() throws SQLException, ClassNotFoundException {
		super();
	}
	
	public boolean customerValid(String username,String password) throws SQLException {
		boolean res = false;
		ResultSet resultSe = super.read("SELECT  `cust_email`, `cust_password` FROM `customer` WHERE `cust_email`='"+username+"'");
		if (resultSet != null) {
			while (resultSe.next()) {
				if(password.equals(resultSe.getString("cust_password"))) {
					res = true;
				}
			}
		}else {
			res=false;
		}
		super.conn.close();
		return res;
	}

	public boolean adminValid(String username,String password) throws SQLException {
		boolean res = false;
		ResultSet resultSe = super.read("SELECT `admin_email`, `admin_password` FROM `admin` WHERE `admin_email`='"+username+"'");
		if (resultSet != null) {
			while (resultSe.next()) {
				if(password.equals(resultSe.getString("admin_password"))) {
					res = true;
				}
			}
		}
		super.conn.close();
		return res;
	}

	public ArrayList<CustomerModel> getAllCustomer() throws SQLException {
		ResultSet resultSe = super.read("SELECT `cust_id`, `cust_name`, `cust_email`, `cust_phone`, `cust_password` FROM `customer`");
		ArrayList<CustomerModel> alm = new ArrayList<CustomerModel>();
		if (resultSet != null) {
			while (resultSe.next()) {
				CustomerModel lm = new CustomerModel();
				lm.setId(resultSe.getInt("cust_id"));
				lm.setUsername(resultSe.getString("cust_name"));
				lm.setMobile(resultSe.getString("cust_phone"));
				lm.setPassword(resultSe.getString("cust_password"));
				lm.setEmail(resultSe.getString("cust_email"));
				alm.add(lm);
			}
		}
		super.conn.close();
		return alm;
	}
	public ArrayList<AdminModel> getAllAdmin() throws SQLException {
		ResultSet resultSe = super.read("SELECT `admin_id`, `hotel_id`, `admin_name`, `admin_email`, `admin_password` FROM `admin`");
		ArrayList<AdminModel> alm = new ArrayList<AdminModel>();
		if (resultSet != null) {
			while (resultSe.next()) {
				AdminModel lm = new AdminModel();
				lm.setId(resultSe.getInt("admin_id"));
				lm.setName(resultSe.getString("admin_name"));
				lm.setPassword(resultSe.getString("admin_password"));
				lm.setEmail(resultSe.getString("admin_email"));
				lm.setHotelId(resultSe.getInt("hotel_id"));
				alm.add(lm);
			}
		}
		super.conn.close();
		return alm;
	}
	
	public boolean addCustomer(int id,String name,String email,String mobile,String pass) throws SQLException {
		super.add("INSERT INTO `customer`(`cust_id`, `cust_name`, `cust_email`, `cust_phone`, `cust_password`) VALUES (?,?,?,?,?)");
		super.pStatment.setInt(1,id);
		super.pStatment.setString(2, name);
		super.pStatment.setString(3, email);
		super.pStatment.setString(4, mobile);
		super.pStatment.setString(5,pass);
		return super.executeQuery();
	}

	public boolean addAdmin(int id,int hotelId,String name,String email,String pass) throws SQLException {
		super.add("INSERT INTO `admin`(`admin_id`, `hotel_id`, `admin_name`, `admin_email`, `admin_password`) (?,?,?,?,?)");
		super.pStatment.setInt(1,id);
		super.pStatment.setInt(2, hotelId);
		super.pStatment.setString(3, name);
		super.pStatment.setString(4, email);
		super.pStatment.setString(5,pass);
		return super.executeQuery();
	}


	public boolean updateCustomer(int id,String name,String mobile,String email) throws SQLException {
		super.add("UPDATE `customer` SET ,`cust_name`=?,`cust_email`=?,`cust_phone`=?, WHERE `cust_id`=?");
		super.pStatment.setString(1, name);
		super.pStatment.setString(2, email);
		super.pStatment.setString(3, mobile);
		super.pStatment.setInt(4,id);
		return super.executeQuery();
	}

	public boolean customerDelete(int id) throws SQLException {
		super.delete("DELETE FROM `customer` WHERE `cust_id`=?");
		super.pStatment.setInt(1,id);
		return super.executeQuery();
	}

	public boolean adminDelete(int id) throws SQLException {
		super.delete("DELETE FROM `admin` WHERE `admin_id`=?");
		super.pStatment.setInt(1,id);
		return super.executeQuery();
	}
	



}