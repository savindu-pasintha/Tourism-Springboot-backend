package com.Normal_Mysql_Database.databasePkg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Normal_Mysql_Database.modelsPkg.CentersModel;

public class Centers extends Database {

	public Centers() throws SQLException, ClassNotFoundException {
		super();
	}

	public ArrayList<CentersModel> read() throws SQLException {
		ArrayList<CentersModel> cmList = new ArrayList<CentersModel>();
		ResultSet resultSe = super.read("SELECT * FROM centers");
		if (resultSet != null) {
			while (resultSe.next()) {
				CentersModel cm = new CentersModel();
				cm.setId(resultSe.getString("id"));
				cm.setName(resultSe.getString("name"));
				cm.setLocation(resultSe.getString("location"));
				cmList.add(cm);
			}
		}
		super.conn.close();
		return cmList;
	}

	public boolean add(CentersModel obj) throws SQLException {
		String query = "INSERT INTO `centers` (`id`, `name`, `location`) VALUES (?, ?, ?)";
		super.add(query);
		super.pStatment.setString(1, obj.getId());
		super.pStatment.setString(2, obj.getName());
		super.pStatment.setString(3, obj.getLocation());
		return super.executeQuery();
	}

	public boolean deletec(String id) throws SQLException {
		String query = "DELETE FROM `centers` WHERE id=?";
		super.pStatment.setString(1, id);
		super.delete(query);
		return super.executeQuery();
	}

}
