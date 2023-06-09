// Assignment: Binary Search Tree
// Authors: Troy Brunette
// Entry class represents a person in the Binary Search Tree
//      - has private fields, constructor methods, getter/setter methods
public class Entry {
    // CLASS FIELDS
    private String firstName;
    private String lastName;
    private String fullName;
    private String phone;
    private String address;
    private String zipCode;
    private String city;
    private String state;

    // CONSTRUCTORS
    public Entry() {}

    public Entry(String name, String phone) {
        this.fullName = name;
        this.phone = phone;
    }
    public Entry(String firstName, String lastName, String phone) {
        this.fullName = firstName + " " + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Entry(Entry entry) {
        this.fullName = entry.fullName;
        this.firstName = entry.firstName;
        this.lastName = entry.lastName;
        this.phone = entry.phone;
        this.address = entry.address;
        this.city = entry.city;
        this.state = entry.state;
        this.zipCode = entry.zipCode;
    }


    public String toString() {
        return String.format("|%-18s%2$2s|", fullName, phone);
    }


    //SETTER METHODS:
    //  * each method returns the Entry object
    //  * allows for chaining methods when creating a new Entry
    public Entry setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public Entry setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
        this.firstName = firstName;
        this.lastName = lastName;
        return this;
    }
    public Entry newAddress(String address) {
        this.address = address;
        return this;
    }
    public Entry setCity(String city) {
        this.city = city;
        return this;
    }
    public Entry setState(String state) {
        this.state = state;
        return this;
    }
    public Entry setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    // GETTER METHODS ////////////////////////////////////
    public Entry getEntry() { return this; }
    public String getName() { return fullName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhoneNumber() { return phone; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getZipCode() { return zipCode; }

}

// TYPICAL SETTER METHODS - not using
//   void setPhoneNumber(String phone) {
//        this.phone = phone;
//    }
//    void setAddress(String address) {
//        this.address = address;
//    }
//    void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//    void setState(String state) {
//        this.state = state;
//    }
//    void setName(String name) {
//        this.name = name;
//    }
//    void setName(String firstName, String lastName) {
//        this.name = firstName + " " + lastName;
//    }
//    void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    void setCity(String city) {
//        this.city = city;
//    }