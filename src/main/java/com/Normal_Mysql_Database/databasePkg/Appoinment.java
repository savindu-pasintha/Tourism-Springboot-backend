package com.Normal_Mysql_Database.databasePkg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Appoinment extends Database {

	public Appoinment() throws SQLException, ClassNotFoundException {
		super();
	}

	public ArrayList<AppoinmentModel> read() throws SQLException {
		ResultSet resultSet = super.read("SELECT * FROM appoinment");
		ArrayList<AppoinmentModel> aLA = new ArrayList<AppoinmentModel>();
		if (resultSet != null) {
			while (resultSet.next()) {
                  AppoinmentModel apm = new AppoinmentModel();
                  apm.setId(resultSet.getInt("id"));
                  apm.setDatetime(resultSet.getString("date-time"));
                  apm.setDoctorId(resultSet.getString("doctor"));
                  apm.setSpc(resultSet.getString("specialization"));
                  apm.setUserId(resultSet.getString("user_id"));
                  apm.setTimestamp(resultSet.getString("timestamp"));
                  apm.setHospital(resultSet.getString("hospital"));
                  aLA.add(apm);
			}
			super.conn.close();
		}
		return aLA;
	}

	public boolean add(String doctorId, String spc, String hospital, String datetime, String userId)
			throws SQLException {
		String query = "INSERT INTO `appoinment` (`id`, `doctor`, `specialization`, `hospital`, `date-time`, `timestamp`, `user_id`) VALUES (?,?,?,?,?,?,?)";
		super.add(query);
		super.pStatment.setInt(1, 0);// id=autoincrement timestamp=autoset
		super.pStatment.setString(2, doctorId);
		super.pStatment.setInt(3, Integer.valueOf(spc));
		super.pStatment.setString(4, hospital);
		super.pStatment.setString(5, datetime);
		super.pStatment.setString(6, null);
		super.pStatment.setInt(7, Integer.valueOf(userId));
		return super.executeQuery();
	}

	public boolean update(String doctorId, String spc, String hospital, String datetime, String userId, String id)
			throws SQLException {
		super.update(
				"UPDATE `appoinment` SET  `doctor`=?, `specialization`=?,`hospital`=?, `date-time`=?, `user_id`=?  WHERE `id`=?");
		super.pStatment.setString(1, doctorId);
		super.pStatment.setInt(2, Integer.valueOf(spc));
		super.pStatment.setString(3, hospital);
		super.pStatment.setString(4, datetime);
		super.pStatment.setInt(5, Integer.valueOf(userId));
		super.pStatment.setInt(6, Integer.valueOf(id));
		return super.executeQuery();
		// id=int autoincrement timestamp=autoset
	}

	public boolean deletec(String id) throws SQLException {
		String query = "DELETE FROM `appoinment` WHERE id=?";
		super.pStatment.setInt(1, Integer.valueOf(id));
		super.delete(query);
		return super.executeQuery();
	}

}
