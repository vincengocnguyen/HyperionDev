import java.util.*;
import java.time.*;
import Person;
import java.text.SimpleDateFormat;

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

    /** Constructor for the Project object */
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
        String projectString = "\nProject Number: " + projectNumber + "\nProject Name: " + projectName + "\nBuilding Type" + buildingType + "\nAddress: " + address + "\nERF Number; " + erfNumber + "\nDeadline: " + deadline + "\nTotal Fee: " + totalFee + "\nAmount Paid to Date: " + totalPaid + "\nStatus: " + status;

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
        System.out.println("New Deadline: ");
        String tempDate = input.nextLine();
        this.deadline = tempDate;
    }

    /** Method to change the amount paid */
    public void changePaid() {
        System.out.println("New Amount paid to Date: ");
        this.totalPaid = input.nextFloat();
    }

    /** Method to update the contractor's contact details */
    public void updateContractor() {
        System.out.println("Do you want to update the Contractor's phone number? Yes or no.\n");
        String contractorMenu = input.nextLine();
        if (contractorMenu.equalsIgnoreCase("Yes")) {
            System.out.println("New Phone Number for the Contractor: ");
            this.contractor.telephone = input.nextLine();
        }

        System.out.println("Do you want to update the Contractor's email address? Yes or no.\n");
        contractorMenu = input.nextLine();
        if (contractorMenu.equalsIgnoreCase("Yes")) {
            System.out.println("New Email Address for the Contractor: ");
            this.contractor.email = input.nextLine();
        }

        System.out.println("Do you want to update the Contractor's address? Yes or no.\n");
        contractorMenu = input.nextLine();
        if (contractorMenu.equalsIgnoreCase("Yes")) {
            System.out.println("New Address for the Contractor: ");
            this.contractor.address = input.nextLine();
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