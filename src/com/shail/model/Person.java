package com.shail.model;

public class Person {

  private int mID;
  private String mName;
  private String mPassword;


  public Person() {
    // Empty Constructor...
  }

  public Person(int id, String name, String password) {
    mID = id;
    mName = name;
    mPassword = password;
  }

  public int getID() {
    return mID;
  }

  public void setID(int ID) {
    this.mID = ID;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    this.mName = name;
  }

  public String getPassword() {
    return mPassword;
  }

  public void setPassword(String password) {
    this.mPassword = password;
  }
}
