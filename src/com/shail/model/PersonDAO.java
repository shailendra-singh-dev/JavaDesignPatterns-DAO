package com.shail.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PersonDAO {

  public void addPerson(final Person person) {

    Connection connection = Database.getInstance().getConnection();
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement =
          connection.prepareStatement("insert into person(name,password) values(?,?)");
      preparedStatement.setString(1, person.getName());
      preparedStatement.setString(2, person.getPassword());
      preparedStatement.executeUpdate();
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public Person getPerson(int id) {
    return null;
  }

  public List<Person> getPeople() throws SQLException {
    List<Person> people = new ArrayList<Person>();
    Connection conn = Database.getInstance().getConnection();

    String sql = "select id, name, password from people order by id";
    Statement selectStatement = conn.createStatement();

    ResultSet results = selectStatement.executeQuery(sql);

    while (results.next()) {
      int id = results.getInt("id");
      String name = results.getString("name");
      String password = results.getString("password");

      Person person = new Person(id, name, password);
      people.add(person);
    }

    results.close();
    selectStatement.close();

    return people;
  }

  public int updatePerson(Person person) {
    Connection conn = Database.getInstance().getConnection();
    int updated = 0;
    PreparedStatement p;
    try {
      p = conn.prepareStatement("update people set name=?, password=? where id=?");
      p.setString(1, person.getName());
      p.setString(2, person.getPassword());
      p.setInt(3, person.getID());

      updated = p.executeUpdate();

      p.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return updated;

  }

  public void deletePerson(int id) {

  }
}
