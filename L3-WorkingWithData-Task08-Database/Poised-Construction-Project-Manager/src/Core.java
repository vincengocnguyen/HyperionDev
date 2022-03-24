
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;

/** <h1>Poised Construction Project Manager </h1> 
 * <p>
 * This is a Java programme which offers basic functionalities to manage 
 * and keep track of the different projects under Poised.
 * </p>
 * 
 * @author Vince Nguyen
 * @version 1.1
 * @since 2020-07-07
 * */


public class Core {
    
    public static void main(String[] args) {
    	// Print welcome message
    	System.out.println("Welcome to Poised Construction Project Management!\n");       
        
        
        int projectSelection = 0;
        boolean projectSelected = false;
        
        Scanner input = new Scanner(System.in);
        int choice;
        boolean quit_menu = false;
        
        do {
        	Menu.showMainMenu();
        	choice = Menu.menuChoice();
        	
        	if (choice == 1) {
        		try {
        			System.out.println("Please select a Project using its Number.");
        			Menu.printAllProjectsName();
        			projectSelection = Menu.menuChoice() - 1;
					if(projectSelection < Menu.projects.size() && projectSelection >= 0) {
						projectSelected = true;
						Menu.showProjectMenu();
					} else {
						System.out.print("There is no project at that number");
					}
        		}
        		catch(Exception e) {
        			System.out.println("No Projects exist yet.");
        		}
        	}
        	if (choice == 2) {
        		Project project = Menu.createProject();
        		Menu.projects.add(project);
        		Database.addProject(project);
        	}
        	if (choice == 3) {
        		try {
        			Menu.printAllProjects();
        		}
        		catch(Exception e) {
        			System.out.println("No Projects exist yet.");
        		}
        	}
	        if (choice == 4) {
	        	try {
        			Menu.printUncompletedProjects();
        		}
        		catch(Exception e) {
        			System.out.println("No Projects exist yet.");
        		}
	        }
	        if (choice == 5) {
	        	try {
        			Menu.printOverdueProjects();
        		}
        		catch(Exception e) {
        			System.out.println("No Projects exist yet.");
        		}
	        }
	        if (choice == 0) {
	        	System.out.println("Thanks for using the programme.");
	        	quit_menu = true;
	        	break;
	        }
        	
        	while(projectSelected) {
				choice = Menu.menuChoice();
				
				// Changes a Projects Deadline
				if(choice == 1) {
					try {
						Menu.projects.get(projectSelection).changeDate();
						// Updating Project to Database
						Database.updateDatabase("Deadline",(projectSelection + 1));;
					} catch(Exception e) {
						System.out.println("No projects exist yet");
					}
				}
				// Change Total Paid to Date
				if(choice == 2) {
					try {
						Menu.projects.get(projectSelection).changePaid();
						// Updating Project to Database
						Database.updateDatabase("AmountPaid", (projectSelection + 1));;
					} catch(Exception e) {
						System.out.println("No projects exist yet");
					}
				}
				// Updates Contractor Details
				if(choice == 3) {
					try {
						Menu.projects.get(projectSelection).updateContractor();
						// Updating Project to Database
						Database.updateDatabase("Contractor", (projectSelection + 1));;
					} catch(Exception e) {
						System.out.println("No projects exist yet");
					}
				}
				// Print selected Project
				if(choice == 4) {
					try {
						// Creates Invoice
						String [] invoice = Menu.projects.get(projectSelection).finaliseProject();
						// Outputs Invoice
						for(int i = 0;i < 5;i++) {
							System.out.println(invoice[i]);
						}
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("No projects exist yet");
					}
				}
				// Print Project Details
				if(choice == 5) {
					try {
						Menu.printSelectedProject(projectSelection);
					} catch(Exception e) {
						System.out.println("No Projects exist yet");
					}
				}
				if(choice == 0) {
					break;
				}
				Menu.showProjectMenu();
        	}
              
        }
        while(!quit_menu);
    }
}