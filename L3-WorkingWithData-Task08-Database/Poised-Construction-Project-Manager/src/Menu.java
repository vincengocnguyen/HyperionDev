import java.util.*;
import java.text.*;
import java.time.*;

/**
 * 
 * @author Vince Nguyen
 *
 */

public class Menu {
    static Scanner input = new Scanner(System.in);
	
	public static ArrayList<Project> projects = Database.selectProjects();
	
	/** Method to show the Main Menu */
    public static void showMainMenu() {
        System.out.println("\n\nPlease choose the following options\n"
        		+ "\t1 - Select a Project\n"
        		+ "\t2 - Create a new Project\n"
        		+ "\t3 - Print all Projects\n"
        		+ "\t4 - Print all Unfinished Projects\n"
        		+ "\t5 - Print all Overdue Projects\n"
        		+ "\t0 - Exit");
    }

	/** Method to show the menu if the user wants to update a project's details */    
    public static void showProjectMenu() {
        System.out.println("\n\nPlease choose the following options\n"
        		+ "\t1 - Change the due date of the project\n"
        		+ "\t2 - Change the amount paid to date\n"
        		+ "\t3 - Update a contractor's contact details\n"
        		+ "\t4 - Finalise the project\n"
        		+ "\t5 - Print project details\n"
        		+ "\t0 - Exit");
    }

    /** Method to get the menu input of an user */
    public static int menuChoice() {
        
        int choice = input.nextInt();

        if ((0 <= choice)) {
            return choice;
        }
        else {
            System.out.println("\nThat's not a valid option. Please enter a number from the menu.\n");
            return menuChoice();
        }
    }
    
    /** Displays all Projects by their Names only */
    public static void printAllProjectsName() {
    	for (int i = 0; i < projects.size(); i++) {
    		System.out.println(projects.get(i).projectNumber + "\t" + projects.get(i).projectName);
    	}
    }
    
    /** Displays all Projects */
    public static void printAllProjects() {
    	for (int i = 0; i < projects.size(); i++) {
    		System.out.println("Project "+ (i+1));
    		System.out.print(projects.get(i).toProjectString());
    	}
    }
    
    /**
     * Display the selected Project
     * @param i 
     */
    public static void printSelectedProject(int i) {
    	System.out.print(projects.get(i).toProjectString());
    }
    
    /**
     * Display the uncompleted projects
     */
    public static void printUncompletedProjects() {
    	for (int i = 0; i < projects.size(); i++) {
    		if (projects.get(i).status.equalsIgnoreCase("Not Completed")) {
    			System.out.print(projects.get(i).toProjectString());
    		}
    	}
    }
    
    /**
     * Display the overdue projects
     */
    public static void printOverdueProjects() {
    	for(int i = 0; i < projects.size();i++) {
			try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(projects.get(i).deadline);
			Date now = new Date();
			if(projects.get(i).status.equals("Not Completed") && now.compareTo(date) > 0) {
				System.out.print(projects.get(i).toProjectString());
			}
			} catch(ParseException e) {
				System.out.println("\nProject " + (i +1) + " Date invalid format! Please change it");
			}
		}
    }

    /**
     * Method to take the inputs of the user to create a new Project object
     * @return New Project object
     */
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
        
        // System.out.println("Great. Please enter the details for your project.");
        
        System.out.print("Project Number: ");
        input.nextLine();
        projectNumber = input.next();

        System.out.print("Project Name: ");
        projectName = input.next();

        System.out.print("Building Type: ");
        buildingType = input.next();

        System.out.print("Address: ");
        address = input.next();

        System.out.print("ERF Number: ");
        erfNumber = input.next();

        while(true) {
            try {
                System.out.print("Total Fee: ");
                totalFee = input.nextFloat();
                break;
            }
            catch(Exception e) {
                System.out.print("\nPlease enter a valid number.");
            }
        }
        
        while(true) {
            try {
                System.out.print("Amount Paid to Date: ");
                totalPaid = input.nextFloat();
                break;
            }
            catch(Exception e) {
                System.out.print("\nPlease enter a valid number.");
            }
        }
        
        status = "Not Completed";

        while(true) {
            try {
                System.out.print("Deadline (yyyy-MM-dd format): ");
                String tempDeadline = input.next();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tempDeadline);
                deadline = new SimpleDateFormat("yyyy-MM-dd").format(date);
                break;
            }
            catch(Exception e) {
                System.out.print("\nPlease enter in valid date format. For example: 2020-07-02.");
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
        
        System.out.println("A new project has been successfully created!");
        
        return project;
    }

    /**
     * Method to create a new Person object, to be used within the createProject method 
     * @param personType role of the Person on the project
     * @return New Person object
     */
    
    public static Person createPerson(String personType) {
        // Initialise Person Variables
        String firstname = "";
        String surname = "";
        String telephone = "";
        String email = "";
        String address = "";
        
        System.out.println("Please enter the details for the " + personType + " of this project.");

        System.out.print("First Name: ");
        input.nextLine();
        firstname = input.next();

        System.out.print("Surname: ");
        surname = input.next();

        System.out.print("Phone Number: ");
        telephone = input.next();

        System.out.print("Email Address: ");
        email = input.next();

        System.out.print("Address: ");
        address = input.next();

        // Creating a Person object
        Person person = new Person(personType, firstname, surname, telephone, email, address);
        
        return person;
    }

}