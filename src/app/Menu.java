package app;

import dao.TodoDao;
import entity.Todo;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private TodoDao todoDao;
    private int userId;
    private List<String> options = Arrays.asList(
            "Show All Users",
            "Add New User",
            "Delete User",
            "Add New Todo",
            "Update Todo",
            "Delete Todo");


    public void start() {
        String selection = "";

        do {
            printMenu();
            selection = scanner.nextLine();

            try {
                if (selection.equals("1")) {
                    showAllUsers();
                } else if (selection.equals("2")) {
                    showUserByID();
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

    private void showAllUsers() throws SQLException {
        List<Todo> todos = todoDao.getTodoByUserID(userId);
        for (Todo todo : todos) {
            System.out.println("To-Do: " + todo.getTodoContent());
        }
    }

}
