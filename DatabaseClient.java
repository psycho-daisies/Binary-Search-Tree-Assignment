// Assignment: Binary Search Tree
// Authors: Troy Brunette

// This program constructs a data structure called Binary Search Tree
// that contain Entry objects (a person) with a name, phone number, and address.
// A Binary Search tree organizes elements in a tree-like structure.
// For each node, the elements in it's left subtree must be less than
// and the elements in the right subtree are greater.
// A BST is efficient at searching, insertion, and deletion operations.
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseClient {
  public static void main(String[] args) throws IOException {
    BinarySearchTree tree = new BinarySearchTree();
    menuSelection(tree);
  }

  // a menu (add, delete, modify, lookup, list number of records.
  public static void menuSelection(BinarySearchTree tree) throws IOException {
    ArrayList<Entry> list = new ArrayList<Entry>();
    Scanner input = new Scanner(System.in);
    String choice;
    System.out.println("(1.) Add a new contact, (2.) Remove a contact, (3.) Search for a contact, (4.) View all Contacts, (5.) Add Contacts from file, (Q)uit ");
    System.out.print("Enter a choice:  ");
    do { // START OF MENU DO WHILE LOOP
      choice = input.next().toUpperCase();
      switch (choice) {
        case "1" -> addNewContact(input, tree); // Add a new contact to the List
        case "2" -> removeContact(input, tree); // Remove a contact from the list
        case "3" -> lookup(input, tree); // Search for a contact in the list
        case "4" -> { // View all contacts
          if (tree.size() == 0) {
            System.out.println("Tree is empty");
          } else {
            System.out.println("This is your current contact list");
            tree.printEntry();
          }
        }
        case "5" -> { // Add from file
          addEntryFromFile(list, tree);
        }
        case "Q" -> { // Quit the program
          System.out.println("Good-Bye");
        }
      }
      System.out.println("(1.) Add a new contact, (2.) Remove a contact, (3.) Search for a contact, (4.) View all Contacts, (Q)uit ");
    } while (!choice.equals("Q")); // END OF LOOP
  }

  // method for adding a new contact from user input
  public static void addNewContact(Scanner input,  BinarySearchTree tree) {
    System.out.println("Enter a new contact");
    System.out.print("First name: ");
    // prompt user to enter contact information
    String firstName = input.next();

    System.out.print("Last name: ");
    String lastName = input.next();

    System.out.print("Phone Number: ");
    String phoneNumber = input.next();

    System.out.print("Address: ");
    String address = input.next();
    address += input.nextLine();

    System.out.print("Zip code: ");
    String zipCode = input.next();

    System.out.print("City: ");
    String city = input.next();
    city += input.nextLine();

    System.out.print("State: ");
    String state = input.next();

    // Chaining methods technique

    tree.add(new Entry().setFullName(firstName, lastName)
            .setPhone(phoneNumber)
            .newAddress(address)
            .setZipCode(zipCode)
            .setCity(city)
            .setState(state)
    );
    System.out.println("New entry added for: " + firstName + " " + lastName);
  }

  // User can remove a contact from the phonebook
  // Prints a list of contacts with an index number
  // uses try / catch to handle user input
  public static void removeContact(Scanner input, BinarySearchTree tree) {

    String name;
    System.out.println("This is your current contact list");

    while (true) {
      System.out.print("Enter the first name of the person you want to remove: ");
      try {
        // Prompt user for a first name to remove
        name = input.next();
        // Remove the contact
        tree.remove(name);
        System.out.println("Removing contact " + name);
        // break the loop
        break;
      } catch (Exception e) {
        System.out.println("Something went wrong, let's try that again.");
        // tell Scanner to go to next line to prevent infinite loop
        input.nextLine();
      }
    }
  }

  // Search phonebook for an Entry and displays it
  public static void lookup(Scanner input, BinarySearchTree tree) {
    System.out.println("Please enter the name you want to search for");
    String name = input.next(); // Prompt user for a name to search for
    // returns true that "Alex" is in the tree
    if (tree.contains(name)) {
      System.out.println("The name " + name + " was found in the tree.");
    } else {
      System.out.println("The name " + name + " was not found in the tree.");
    }
  }

  // Reads a csv file and adds the contacts to the phonebook
  public static void addEntryFromFile(ArrayList list, BinarySearchTree tree) throws IOException {
    try {
      String path = "C:\\Users\\Troy\\Desktop\\Database\\src\\entry.csv";
      readFile(path, list, tree);
    } catch (IOException e) {
      System.out.println("That file was not found.");
    }
  }

  // Reads a csv file with contacts and adds to the phonebook list
  public static void readFile(String path, ArrayList list, BinarySearchTree tree) throws IOException {
    ArrayList<Entry> contacts = new ArrayList<Entry>();
    Scanner scanner = new Scanner(new FileReader(path));
    // Grab each line from the file
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      // Split the lines at each comma, and store them in a String array
      String[] lines = line.split(",");
      String lName = lines[0];
      String fName = lines[1];
      String city = lines[2];
      String phone = lines[3];

      // Adding new entries to the phonebook
      contacts.add(new Entry()
              .setFullName(fName, lName)
              .setPhone(phone)
              .setCity(city));

      tree.add(new Entry()
              .setFullName(fName, lName)
              .setPhone(phone)
              .setCity(city));

    }
  }
}
