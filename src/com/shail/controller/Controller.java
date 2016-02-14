package com.shail.controller;

import javax.security.auth.spi.LoginModule;

import com.shail.model.Model;
import com.shail.model.Person;
import com.shail.model.PersonDAO;
import com.shail.view.LoginFormEvent;
import com.shail.view.View;
import com.shail.view.View.IAccountCreatedListener;

public class Controller implements IAccountCreatedListener {
  private View view;
  private Model model;
  private PersonDAO personDAO =new PersonDAO();
  
  public Controller(View view, Model model) {
    this.view = view;
    this.model = model;
  }

  @Override
  public void accountCreated(Person person) {
    System.out.println("Account creation event received: " + person.getName() + "; "
        + person.getPassword());
    personDAO.addPerson(person);
    
  }
}
