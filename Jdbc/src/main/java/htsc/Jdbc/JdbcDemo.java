package htsc.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import htsc.Jdbc.User;

public class JdbcDemo {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?" + "characterEncoding=utf-8&serverTimezone=GMT%2B8", "root",
					"Lqz2017.");
			String sql = "select * from user where sex = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "男");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setSex(resultSet.getString("sex"));
				user.setAddress(resultSet.getString("address"));
				user.setBirthday(resultSet.getString("birthday"));
				System.out.println(user.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
