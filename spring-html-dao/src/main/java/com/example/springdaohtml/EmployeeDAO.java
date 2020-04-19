package com.example.springdaohtml;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {

    Connection conn;

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<EmployeeDTO> getAllEmployee(){

        ArrayList<EmployeeDTO> allEmp = new ArrayList<EmployeeDTO>();

        // create statement
        try {
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * from emp");


            while (resultSet.next()){
                EmployeeDTO employeeDTO = new EmployeeDTO();

                employeeDTO.setEmpNo(resultSet.getInt(1));
                employeeDTO.setEname(resultSet.getString(2));
                employeeDTO.setJob(resultSet.getString(3));
                employeeDTO.setMgr(resultSet.getInt(4));
                employeeDTO.setHiredate(resultSet.getString(5));
                employeeDTO.setSal(resultSet.getDouble(6));
                employeeDTO.setComm(resultSet.getDouble(7));
                employeeDTO.setDeptno(resultSet.getInt(8));

                allEmp.add(employeeDTO);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return allEmp;
    }


}
