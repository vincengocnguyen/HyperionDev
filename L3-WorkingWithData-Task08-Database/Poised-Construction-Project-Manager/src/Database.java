import java.util.*;
import java.sql.*;

/**
 * 
 * @author Vince Nguyen
 *
 */

public class Database {
	/**
	 * Method to connect to the database
	 * @return Statement object of the database
	 */
	public static Statement connectDatabaseStatement() {
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/poisepm?allowPublicKeyRetrieval=true&useSSL=false",
					"vincenguyen",
					"valentine"
					);
			Statement statement = connection.createStatement();
			return statement;
		}
		catch (SQLException e) {
			System.out.println("Could not establish connection to the database.");
			return null;
		}
	}
	
	/**
	 * Extract the Projects data from the database into an ArrayList
	 * @return ArrayList of Projects objects
	 */
	public static ArrayList<Project> selectProjects() {
		ArrayList<Project> projects = new ArrayList<Project>();
		
		try {
			Statement statement = connectDatabaseStatement();
			String query = "select * from project"
							+ " inner join contractor on project.CONT_ID = contractor.ID"
							+ " inner join customer on project.CUST_ID = customer.ID"
							+ " inner join architect on project.ARCH_ID = architect.ID";
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				// Creating Project object based on query result
				Project project = new Project();
				
				project.projectNumber = result.getString("NUM");
				project.projectName = result.getString("NAME");
				project.buildingType = result.getString("BUILD_TYPE");
				project.address = result.getString("BUILD_ADDRESS");
				project.erfNumber = result.getString("ERF_NUM");
				project.deadline = result.getString("DEADLINE");
				project.totalFee = result.getFloat("TOTAL_FEE");
				project.totalPaid = result.getFloat("AMOUNT_PAID");
				project.status = result.getString("STATUS");
				
				// Creating Person objects
				Person architect = new Person("Architect", result.getString("architect.FIRSTNAME"), result.getString("architect.LASTNAME"), result.getString("architect.PHONE_NUM"),
						result.getString("architect.EMAIL"),result.getString("architect.ADDRESS"));
				project.architect = architect;
				
				Person customer = new Person("Customer", result.getString("customer.FIRSTNAME"), result.getString("customer.LASTNAME"), result.getString("customer.PHONE_NUM"),
						result.getString("customer.EMAIL"),result.getString("customer.ADDRESS"));
				project.customer = customer;
				
				Person contractor = new Person("Contractor", result.getString("contractor.FIRSTNAME"), result.getString("contractor.LASTNAME"), result.getString("contractor.PHONE_NUM"),
						result.getString("contractor.EMAIL"),result.getString("contractor.ADDRESS"));
				project.contractor = contractor;
				
				// Adding the object to the ArrayList
				projects.add(project);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return projects;
	}
	
	/**
	 * Method to add a new Project object to the database
	 * @param project
	 */
	public static void addProject(Project project) {
		Statement statement = connectDatabaseStatement();
		int count = 0;
		
		try {
			ResultSet add = statement.executeQuery("select NUM from project");
			
			while(add.next()) {
				count ++;
			}
			
			// String used to insert new Projects fields into the Database
			String insertProjectString = "insert into project values ('" + project.projectNumber + "', '" + project.projectName + "', '" + project.buildingType
					+ "', '" + project.address + "', '" + project.erfNumber + "', '" + project.deadline + "', " + project.totalFee + ", "
					+ project.totalPaid + ", '" + project.status + "', " + (count +1) + ", " + (count +1) + ", " + (count +1) + ")";
			
			statement.executeUpdate(insertProjectString);
			
			String insertArchitectString = "insert into architect values (" + (count +1) + ", '" + project.architect.firstname + "', '" + project.architect.surname + "', '" + project.architect.telephone
					+ "', '" + project.architect.email + "', '" + project.architect.address + "')";
			
			statement.executeUpdate(insertArchitectString);			

			
			String insertCustomerString = "insert into customer values (" + (count +1) + ", '" + project.customer.firstname + "', '" + project.customer.surname + "', '" + project.customer.telephone
					+ "', '" + project.customer.email + "', '" + project.customer.address + "')";
			
			statement.executeUpdate(insertCustomerString);
			
			String insertContractorString = "insert into contractor values (" + (count +1) + ", '" + project.contractor.firstname + "', '" + project.contractor.surname + "', '" + project.contractor.telephone
					+ "', '" + project.contractor.email + "', '" + project.contractor.address + "')";
			
			statement.executeUpdate(insertContractorString);
			

			
 		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to update a Project record in the database
	 * @param field
	 * @param project
	 */
	public static void updateDatabase(String field, int project) {
		Statement statement = connectDatabaseStatement();
		
		// Strings for varies Update queries
		String updateDeadline = "update project set DEADLINE = '" + Menu.projects.get(project - 1 ).deadline + "' where CUST_ID = " + project;
		String updateAmountPaid = "update project set AMOUNT_PAID = " + Menu.projects.get(project - 1).totalPaid + " where CUST_ID = " + project;
		String updateContractor  = "update contractor set PHONE_NUM = '" + Menu.projects.get(project -1).contractor.telephone + "', EMAIL = '" + Menu.projects.get(project - 1).contractor.email + "' where ID = " + project;
		String updateFinalised = "update project set FINALISED = '" + Menu.projects.get(project - 1).status + "' where CUST_ID = " + project;
		
		try {
			// If statements to decide which update to make
			if(field.equals("Deadline")) {
				statement.executeUpdate(updateDeadline);
			}
			
			if(field.equals("AmountPaid")) {
				statement.executeUpdate(updateAmountPaid);
			}
			
			if(field.equals("Contractor")) {
				statement.executeUpdate(updateContractor);
			}
			
			if(field.equals("Finalised")) {
				statement.executeUpdate(updateFinalised);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}	

	}
}