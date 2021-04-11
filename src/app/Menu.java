package app;

import dao.TodoDao;
import dao.UserDao;
import entity.Todo;
import entity.User;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
  private Scanner scan = new Scanner(System.in);
  private TodoDao todoDao = new TodoDao();
  private UserDao userDao = new UserDao();
  private List<String> options =
      Arrays.asList(
          "Show All Users",
          "Show User by ID",
          "Add New User",
          "Delete User",
          "Add New Todo",
          "Show Todos By User ID",
          "Update Todo Status",
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
          addNewUser();
        } else if (selection.equals("4")) {
          deleteUserById();
        } else if (selection.equals("5")) {
          addNewTodoToUser();
        } else if (selection.equals("6")) {
          getTodosByUserId();
        } else if (selection.equals("7")) {
                          updateTodoStatus();
        } else if (selection.equals("8")) {
          deleteTodoById();
        }
      } catch (SQLException throwables) {
        System.out.println("Error...not a good sign...debug or go home!");
        throwables.printStackTrace();
      }

      System.out.println("Press enter to continue...");
      scan.nextLine();

    } while (!selection.equals("-1"));
  }

  private void printMenu() {
    System.out.println("Select an option: \n-------------------------");
    for (int i = 0; i < options.size(); i++) {
      System.out.println(i + 1 + ") " + options.get(i));
    }
  }

  private void showAllUsers() throws SQLException {
    List<User> users = userDao.showAllUsers();
    for (User user : users) {
      System.out.println(
          user.getUserId()
              + " | "
              + user.getFirstName()
              + " | "
              + user.getLastName()
              + " | "
              + user.getEmailAddress()
              + " | "
              + user.getPhoneNumber());
    }
  }

  private void showUserById() throws SQLException {
    System.out.println("Enter the User ID of who you want to view.");
    int userId = Integer.parseInt(scan.nextLine());
    User user = userDao.getUserByID(userId);
    System.out.println(
        user.getUserId()
            + " | "
            + user.getFirstName()
            + " | "
            + user.getLastName()
            + " | "
            + user.getEmailAddress()
            + " | "
            + user.getPhoneNumber());
  }

  private void getTodosByUserId() throws SQLException {
    System.out.println("Enter the User ID to view Todos.");
    int userId = Integer.parseInt(scan.nextLine());
    List<Todo> todos = todoDao.getTodoByUserId(userId);
    for (Todo todo : todos) {
      System.out.println("To-Do ID) " + todo.getTodoId() + " | To-Do: " + todo + " | Created On: " + todo.getCreatedDate());
    }
  }

  private void addNewUser() throws SQLException {
    System.out.println("Enter the first name of the new user: ");
    String firstName = scan.nextLine();
    System.out.println("Enter the last name of the new user: ");
    String lastName = scan.nextLine();
    System.out.println("Enter the email address of the new user: ");
    String emailAddress = scan.nextLine();
    System.out.println("Enter the phone number of the new user: ");
    String phoneNumber = scan.nextLine();
    userDao.addNewUser(firstName, lastName, emailAddress, phoneNumber);
    System.out.println("New user created successfully!");
  }

  private void deleteUserById() throws SQLException {
    System.out.println("Enter the user id of the user you want to delete: ");
    int userId = Integer.parseInt(scan.nextLine());
    userDao.deleteUserById(userId);
    System.out.println("User was successfully deleted!");
  }

  private void addNewTodoToUser() throws SQLException {
    System.out.println("Enter the User ID of the user the todo will be added to.");
    int userId = Integer.parseInt(scan.nextLine());
    System.out.println("Add the todo.");
    String todoContent = scan.nextLine();
    todoDao.addNewTodoToUser(userId, todoContent);
    System.out.println("New todo added successfully!");
  }

  private void updateTodoStatus() throws SQLException {
    System.out.println("To-Do Status: 1 = Open, 2 = Completed, 3 = Abandoned.");
    System.out.println("Enter the new todo status. Remember to use the correct value!");
    int status = Integer.parseInt(scan.nextLine());
    System.out.println("Enter the todo ID you want to change the status on.");
    int todoId = Integer.parseInt(scan.nextLine());
    todoDao.updateTodoStatus(status, todoId);
    System.out.println("To-Do status updated successfully!");
  }


  private void deleteTodoById() throws SQLException {
    System.out.println("Enter the Todo ID you want to delete: ");
    int todoId = Integer.parseInt(scan.nextLine());
    todoDao.deleteTodoById(todoId);
    System.out.println("Todo was successfully deleted!");
  }

}
