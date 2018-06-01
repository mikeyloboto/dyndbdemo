package com.evilbas.dyndbdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	@Autowired
	private DataSource dataSource;

	public String getTestString() {
		String data = "";
		PreparedStatement preparedStatement;
		try {
			Connection connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select data from dyn_data where id = 1");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				data = resultSet.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
