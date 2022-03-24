import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;

public class Menu {
    // Method to show the Main Menu
    public static void showMainMenu() {
        System.out.println("\n\nPlease choose the following options\n\t1 - Create a new project");
    }

    // Method to show the menu if the user wants to update a project's details
    public static void showProjectMenu() {
        System.out.println("\n\nPlease choose the following options\n\t1 - Change the due date of the project\n\t2 - Change the amount paid to date\n\t3 - Update a contractor's contact details\n\t4 - Finalise the project\n\t5 - Print project details\n\t0 - Exit");
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
        // Initialise Person Variables
        String firstname = "";
        String surname = "";
        String telephone = "";
        String email = "";
        String address = "";
        
        Scanner personInput = new Scanner(System.in);
        System.out.println("\nPlease enter the details for the " + personType + " of this project.");

        System.out.println("First Name: ");
        firstname = personInput.next();

        System.out.println("Surname: ");
        surname = personInput.next();

        System.out.println("Phone Number: ");
        telephone = personInput.next();

        System.out.println("Email Address: ");
        email = personInput.next();

        System.out.println("Address: ");
        address = personInput.next();

        // Creating a Person object
        Person person = new Person(personType, firstname, surname, telephone, email, address);
        
        return person;
    }

    // Method to take the inputs of the user to create a new Project object
    public static Project createProject() {
        // Initialise the Project Variables
        String projectNumber = "";
        String projectName = "";
        String buildingType = "";
        String address = "";
        String erfNumber = "";
        float totalFee = 0;
        float totalPaid = 0;
        String deadline = "";
        String status = "";
        
        System.out.println("Great. Please enter the details for your project.\n");

        Scanner projectInput = new Scanner(System.in);

        System.out.println("Project Number: ");
        projectNumber = projectInput.next();

        System.out.println("Project Name: ");
        projectName = projectInput.next();

        System.out.println("Building Type: ");
        buildingType = projectInput.next();

        System.out.println("Address: ");
        address = projectInput.next();

        System.out.println("ERF Number: ");
        erfNumber = projectInput.next();

        while(true) {
            try {
                System.out.println("Total Fee: ");
                totalFee = projectInput.nextFloat();
                break;
            }
            catch(Exception e) {
                System.out.println("\nPlease enter a valid number.");
                projectInput.next();
            }
        }
        
        while(true) {
            try {
                System.out.println("Amount Paid to Date: ");
                totalPaid = projectInput.nextFloat();
                break;
            }
            catch(Exception e) {
                System.out.println("\nPlease enter a valid number.");
                projectInput.next();
            }
        }
        
        status = "Not Completed";

        while(true) {
            try {
                System.out.println("Deadline (yyyy-MM-dd format): ");
                String tempDeadline = projectInput.next();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tempDeadline);
                deadline = new SimpleDateFormat("yyyy-MM-dd").format(date);
                break;
            }
            catch(Exception e) {
                System.out.println("\nPlease enter in valid date format. For example: 2020-05-30.");
            }
        }

        Person architect = Menu.createPerson("Architect");
        Person customer = Menu.createPerson("Customer");
        Person contractor = Menu.createPerson("Contractor");

        if (projectName.equalsIgnoreCase("")) {
            projectName = buildingType + customer.surname;
        }

        // Creating the Project Object
        Project project = new Project(projectNumber, projectName, buildingType, address, erfNumber, totalFee, totalPaid, status, deadline, architect, customer, contractor);

        return project;
    }


}