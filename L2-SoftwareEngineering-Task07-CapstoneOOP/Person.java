public class Person {
    // Attributes
    String personType;
    String firstname;
    String surname;
    String telephone;
    String email;
    String address;

    // Methods
    /** Constructor for a Person object */ 
    public Person(String personType, String firstname, String surname, String telephone, String email, String address) {
        this.personType = personType;
        this.firstname = firstname;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    /** Consolidate a Person object's details to a string */
    public String toString() {
        String personString = "\nRole: " + personType + "\nName: " + firstname + " " + surname + "\nPhone number: " + telephone + "\nEmail: " + email  + "\nAddress: " + address;
        return personString;
    }
}