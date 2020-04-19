package com.example.springdaohtml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class SpringDaoHtmlApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SpringDaoHtmlApplication.class, args);

		/*

		DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();

		Connection connection = connectionManager.getConnection();

		EmployeeDAO employeeDAO = new EmployeeDAO(connection);

		System.out.println(employeeDAO.getAllEmployee());
*/

	}

}
