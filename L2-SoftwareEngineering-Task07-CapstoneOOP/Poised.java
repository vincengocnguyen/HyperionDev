import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;
import Person;
import Project;

public class Poised {
    // Method to show the Main Menu
    public static void showMainMenu() {
        System.out.println("\nPlease choose the following options\n\t1 - Create a new project");
    }

    // Method to show the menu if the user wants to update a project's details
    public static void showProjectMenu() {
        System.out.println("\nPlease choose the following options\n\t1 - Change the due date of the project\n\t2 - Change the amount paid to date\n\t3 - Update a contractor's contact details\n\t4 - Finalise the project\n\t5 - Print project details\n\t0 - Exit");
    }

    // Method to test the menu input of an user
    public static int menuChoice() {
        Scanner menuInput = new Scanner(System.in);
        
        int choice = menuInput.nextInt();

        if ((0 <= choice) && (choice <= 5)) {
            return choice;
        }
        else {
            System.out.println("\nThat's not a valid option. Please enter a number from the menu.\n");
            return menuChoice();
        }
    }

    // Method to create a new Person object, to be used within the createProject method
    public static Person createPerson(String personType) {
        Scanner personInput = new Scanner(System.in);
        System.out.println("\nPlease enter the details for the " + personType + " of this project.");

        System.out.println("First Name: ");
        String firstname = personInput.next();

        System.out.println("Surname: ");
        String surname = personInput.next();

        System.out.println("Phone Number: ");
        String telephone = personInput.next();

        System.out.println("Email Address: ");
        String email = personInput.next();

        System.out.println("Address: ");
        String address = personInput.next();

        // Creating a Person object
        Person person = new Person(personType, firstname, surname, telephone, email, address);

        return person;
    }

    // Method to take the inputs of the user to create a new Project object
    public static Project createProject() {
        System.out.println("Great. Please enter the details for your project.\n");

        Scanner projectInput = new Scanner(System.in);

        System.out.println("Project Number: ");
        String projectNumber = projectInput.next();

        System.out.println("Project Name: ");
        String projectName = projectInput.next();

        System.out.println("Building Type: ");
        String buildingType = projectInput.next();

        System.out.println("Address: ");
        String address = projectInput.next();

        System.out.println("ERF Number: ");
        String erfNumber = projectInput.next();

        System.out.println("Total Fee: ");
        float totalFee = projectInput.nextFloat();

        System.out.println("Amount Paid to Date: ");
        float totalPaid = projectInput.nextFloat();

        String status = "Not Completed";

        System.out.println("Deadline (yyyy-MM-dd format): ");
        String deadline = projectInput.next();

        Person architect = createPerson("Architect");
        Person customer = createPerson("Customer");
        Person contractor = createPerson("Contractor");

        if (projectName.equalsIgnoreCase("")) {
            projectName = buildingType + customer.surname;
        }

        // Creating the Project Object
        Project project = new Project(projectNumber, projectName, buildingType, address, erfNumber, totalFee, totalPaid, status, deadline, architect, customer, contractor);

        return project;
    }

    /** MAIN PROGRAMME */
    public static void main(String[] args) {
        System.out.println("Welcome to Poised Project Management!\n");       // Print welcome message
        showMainMenu();

        int choice = menuChoice();

        // Main menu only has 1 option for now - which is to create a new project
        if (choice == 1) {
            Project project = createProject();
            showProjectMenu();
            int subChoice = menuChoice();

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
    
                showProjectMenu();
                subChoice = menuChoice();
            }
        }       
    }
}