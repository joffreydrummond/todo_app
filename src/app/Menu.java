package app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
private Scanner scanner = new Scanner(System.in);
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

            if (selection.equals("1")){
//                showAllUsers();
            } else if(selection.equals("2")){
//                addNewUser();
            }else if(selection.equals("3")){
//                deleteUser();
            }else if(selection.equals("4")){
//                addNewTodo();
            }else if(selection.equals("5")){
//                updateTodo();
            }else if(selection.equals("6")){
//                deleteTodo();
            }
//            System.out.println("Press enter to continue...");
//            scanner.nextLine();

        } while (!selection.equals("-1"));
    }

    private void printMenu(){
        System.out.println("Select an option: \n-------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ") " + options.get(i));
        }
    }

}
