package edu.step;

import java.sql.SQLException;
import java.sql.*;

public class EmployeesDB {
    public Connection getConnection()throws SQLException { //
        String url="jdbc:mysql://localhost/employeesdb";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url,username,password);
    }
    public void createEmployee (String nume, String departament , double salariu){
        try{
            Connection connection = getConnection();
            String sql = "INSERT INTO employees(nume,departament,salariu)value(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,nume);
            statement.setString(2,departament);
            statement.setDouble(3,salariu);

            int rows = statement.executeUpdate(); // da ca raspuns cate randuri au fost modificate

            System.out.println("s-au creat "+rows+" randuri");
            connection.close();
        }
        catch(SQLException ex){
            System.out.println("nu am putut executa operatia de create \n"+ex.getMessage());
        }
    }

            public void getEmployeeById(int id) {
                boolean found = false;
                try {
                    Connection connection = getConnection();

                    String sql = "SELECT * FROM employees WHERE id = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, id);

                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        found = true;
                        String nume = resultSet.getString("nume");
                        String departament = resultSet.getString("departament");
                        double salariu = resultSet.getDouble("salariu");

                        System.out.println("Angajat cu id " + id + ": " + nume + " - " + departament + " - " + salariu);
                    }

                    resultSet.close();
                    statement.close();

                    connection.close();

                    if (!found) {
                        System.out.println("Nu s-au găsit persoane cu ID-ul specificat.");
                    }

                } catch (SQLException ex) {
                    System.out.println("Nu am putut executa operația de căutare \n" + ex.getMessage());
                }
            }

    public void updateEmployee(int id, String nume,String departament,double salariu){
        try{
            Connection connection = getConnection();
            String sql = "UPDATE employees SET nume=?,departament=?,salariu=? WHERE id=?";
            PreparedStatement statament = connection.prepareStatement(sql);

            statament.setString(1,nume);
            statament.setString(2,departament);
            statament.setDouble(3,salariu);
            statament.setInt(4,id);

            int rows = statament.executeUpdate();

            System.out.println("S-au modifica "+rows+" randuri");
            connection.close();

        }catch (SQLException ex){
            System.out.println("nu am putut executa operatia de update \n"+ex.getMessage());
        }
    }

    public void deleteEmployeById (int id){
        try{
            Connection connection = getConnection();
            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement statament = connection.prepareStatement(sql);
            statament.setInt(1,id);

            int rows = statament.executeUpdate();

            System.out.println("s-au sters "+rows+" randuri");
            connection.close();
        }catch ( SQLException ex ){
            System.out.println("nu am putut executa operatia de stergere \n"+ex.getMessage());
        }
    }

}
