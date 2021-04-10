package app;

import dao.TodoDao;
import dao.UserDao;
import entity.Todo;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
  private Scanner scan = new Scanner(System.in);
  private TodoDao todoDao = new TodoDao();
  private UserDao userDao = new UserDao();
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  private User users;
  private List<String> options =
      Arrays.asList(
          "Show All Users",
          "Show User by ID",
          "Add New User",
          "Delete User",
          "Add New Todo",
          "Update Todo",
          "Delete Todo");

  public Menu() throws SQLException {}

  public void start() {
    String selection = "";

    do {
      printMenu();
      selection = scan.nextLine();

      try {
        if (selection.equals("1")) {
          showAllUsers();
        } else if (selection.equals("2")) {
          showUserById();
        } else if (selection.equals("3")) {
          //                addNewUser();
        } else if (selection.equals("4")) {
          //                deleteUser();
        } else if (selection.equals("5")) {
          //                addNewTodo();
        } else if (selection.equals("6")) {
          //                updateTodo();
        } else if (selection.equals("7")) {
          //                deleteTodo();
        }
      } catch (SQLException throwables) {
        System.out.println("Error at start...not a good sign...debug or go home!");
        throwables.printStackTrace();
      }

      //            System.out.println("Press enter to continue...");
      //            scanner.nextLine();

    } while (!selection.equals("-1"));
  }



  private void printMenu() {
    System.out.println("Select an option: \n-------------------------");
    for (int i = 0; i < options.size(); i++) {
      System.out.println(i + 1 + ") " + options.get(i));
    }
  }

  private void showAllUsers() throws SQLException{
    List<User> users = userDao.showAllUsers();
    for (User user : users) {
      System.out.println(user.getUserId() + " | " + user.getFirstName() + " | " + user.getLastName() + " | " + user.getEmailAddress() + " | " + user.getPhoneNumber());
    }
      }


  private void showUserById() throws SQLException {
        System.out.println("Enter the User ID of who you want to view.");
    int userId = Integer.parseInt(scan.nextLine());
    User user = userDao.getUserByID(userId);
    System.out.println(user.getUserId() + " | " + user.getFirstName() + " | " + user.getLastName() + " | " + user.getEmailAddress() + " | " + user.getPhoneNumber());
  }

//
//  private void showAllUsers() throws SQLException {
//    List<User> users = userDao.showAllUsers();
//    for (User user : users) {
//      System.out.println(
//          "User ID: "
//              + user.getUserId()
//              + " | First Name: "
//              + user.getFirstName()
//              + " | Last Name: "
//              + user.getLastName());
//    }
//  }

//  private void showUserByID() throws SQLException {
//    System.out.println("Enter the User ID of who you want to view.");
//    int userId = Integer.parseInt(scanner.nextLine());
//    usersDao.showUserById(userId);
//
//
//    }


//    for (Todo todo : todos) {
//      System.out.println(
//          "User: " + usersDao.showUserById(userId) + "To-Do: " + todo.getTodoContent());
//    }
//  }

  //    private void showAll(){
  //        int user = users.getUserId();
  //
  //        for (User user: users
  //             ) {
  //
  //        }
  //    }

  //    private void showUserByID() throws SQLException {
  //        System.out.println("Enter the User ID of who you want to view.");
  //        int userId = Integer.parseInt(scanner.nextLine());
  //        List<Todo> todos = todoDao.getTodoByUserID(userId);
  //
  //        for (Todo todo : todos) {
  //            System.out.println("User: " + usersDao.showUserById(userId) + "To-Do: " +
  // todo.getTodoContent());
  //        }
  //    }

}
