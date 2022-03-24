import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Vince Nguyen
 *
 */

public class Project {
    // Attributes
    String projectNumber;
    String projectName;
    String buildingType;
    String address;
    String erfNumber;
    float totalFee;
    float totalPaid;
    String status;
    String deadline;

    // People
    Person architect;
    Person customer;
    Person contractor;

    // Methods

    
    public Project() {
    	
    }
    
    /**
     * Constructor of the Project object
     * @param projectNumber
     * @param projectName
     * @param buildingType
     * @param address
     * @param erfNumber
     * @param totalFee
     * @param totalPaid
     * @param status
     * @param deadline
     * @param architect
     * @param customer
     * @param contractor
     */
    
    public Project(String projectNumber, String projectName, String buildingType, String address, String erfNumber, float totalFee, float totalPaid, String status, String deadline, Person architect, Person customer, Person contractor) {
        this.projectNumber = projectNumber;
        this.projectName = projectName;
        this.buildingType = buildingType;
        this.address = address;
        this.erfNumber = erfNumber;
        this.totalFee = totalFee;
        this.totalPaid = totalPaid;
        this.status = status;
        this.deadline = deadline;
        this.architect = architect;
        this.customer = customer;
        this.contractor = contractor;
    }

    Scanner input = new Scanner(System.in);

    /** Consolidate a Project object's details to a string */
    public String toProjectString() {
        String projectString = "\nProject Number: " + projectNumber + "\nProject Name: " + projectName + "\nBuilding Type: " + buildingType + "\nAddress: " + address + "\nERF Number: " + erfNumber + "\nDeadline: " + deadline + "\nTotal Fee: " + totalFee + "\nAmount Paid to Date: " + totalPaid + "\nStatus: " + status;

        String architectDetails = architect.toString();
        projectString += architectDetails;

        String customerDetails = customer.toString();
        projectString += customerDetails;

        String contractorDetails = contractor.toString();
        projectString += contractorDetails;

        return projectString;
    }

    /** Method to change the deadline */
    public void changeDate() {
    	while(true) {
    		try {
        		System.out.print("New Deadline: ");
        		String tempDate = input.next();
        		Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(tempDate);
        		this.deadline = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
        		break;
        	}
        	catch(Exception e) {
        		System.out.println("Please enter the deadline in a valid date format e.g. 2020-07-02.");
        	}
    	}
        System.out.println("Deadline updated");
    }

    /** Method to change the amount paid */
    public void changePaid() {
        System.out.print("New Amount paid to Date: ");
        this.totalPaid = input.nextFloat();
        System.out.println("Total Paid to Date updated.");
    }

    /** Method to update the contractor's contact details */
    public void updateContractor() {
        System.out.println("Do you want to update the Contractor's phone number? Yes or no.\n");
        String contractorMenu = input.next();
        if (contractorMenu.equalsIgnoreCase("Yes")) {
            System.out.print("New Phone Number for the Contractor: ");
            this.contractor.telephone = input.next();
            System.out.println("Contractor's phone number has been updated to: " + this.contractor.telephone);
        }

        System.out.println("Do you want to update the Contractor's email address? Yes or no.\n");
        contractorMenu = input.next();
        if (contractorMenu.equalsIgnoreCase("Yes")) {
            System.out.print("New Email Address for the Contractor: ");
            this.contractor.email = input.next();
            System.out.println("Contractor's email address has been updated to: " + this.contractor.email);
        }

        System.out.println("Do you want to update the Contractor's address? Yes or no.\n");
        contractorMenu = input.next();
        if (contractorMenu.equalsIgnoreCase("Yes")) {
            System.out.print("New Address for the Contractor: ");
            this.contractor.address = input.next();
            System.out.println("Contractor's address has been updated to: " + this.contractor.address);
        }
    }

    /** Method to finalise the project and create the invoice */
    public String[] finaliseProject() {
        String[] invoice = new String[5];
        float amountToPay = this.totalFee - this.totalPaid;
        this.status = "Completed";
        invoice[0] = "Customer's Name: " + this.customer.firstname + " " + this.customer.surname;
        invoice[1] = "Phone Number: " + this.customer.telephone;
        invoice[2] = "Email Address: " + this.customer.email;
        invoice[3] = "Outstanding Payment: " + amountToPay;
        invoice[4] = "Date Completed: " + LocalDateTime.now();
        
        return invoice;
    }
}