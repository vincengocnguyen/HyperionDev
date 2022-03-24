import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;

public class Core {
    /** MAIN PROGRAMME */
    public static void main(String[] args) {
        System.out.println("Welcome to Menu Project Management!\n");       // Print welcome message
        Menu.showMainMenu();

        int choice = Menu.menuChoice();

        // Main menu only has 1 option for now - which is to create a new project
        if (choice == 1) {
            Project project = Menu.createProject();
            Menu.showProjectMenu();
            int subChoice = Menu.menuChoice();

            // Loop to revert back to the Project Menu if the user does not quit explicitly
            while ((0 <= subChoice) && (subChoice < 6)) {
                if (subChoice == 1) {
                    project.changeDate();
                }
                // Change the amount paid
                else if (subChoice == 2) {
                    project.changePaid();
                }
                // Change the contractor's details
                else if (subChoice == 3) {
                    project.updateContractor();
                }
                else if (subChoice == 4) {
                    String[] invoice = project.finaliseProject();
                    for (int i = 0; i < 5; i++) {
                        System.out.println(invoice[i]);
                    }
                }
                else if (subChoice == 5) {
                    String projectDetails = project.toProjectString();
                    System.out.print(projectDetails);
                }
                else if (subChoice == 0) {
                    break;
                }
    
                Menu.showProjectMenu();
                subChoice = Menu.menuChoice();
            }
        }       
    }
}