package com.bridgelabz.adressbooksystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// Class to represent a Contact
class Contact {
    String firstName, lastName, address, city, state, email;
    int zip;
    long phone;

    public Contact(String firstName, String lastName, String address, String city,
                   String state, int zip, long phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nName: " + firstName + " " + lastName +
                "\nAddress: " + address + ", " + city + ", " + state + " - " + zip +
                "\nPhone: " + phone + "\nEmail: " + email;
    }
}

public class UC1AddressBookContact {

    static List<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        addContact();

        System.out.print("\nEnter first name of contact to edit: ");
        String nameToEdit = sc.nextLine();
        editContact(nameToEdit);

        System.out.print("\nEnter first name of contact to delete: ");
        String nameToDelete = sc.nextLine();
        deleteContact(nameToDelete);

        // Show updated contacts
        System.out.println("\nAll Contacts:");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void addContact() {
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter State: ");
        String state = sc.nextLine();
        System.out.print("Enter ZIP: ");
        int zip = sc.nextInt();
        System.out.print("Enter Phone Number: ");
        long phone = sc.nextLong();
        sc.nextLine(); // consume newline
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
        contacts.add(newContact);
        System.out.println("\nContact Added Successfully!");
    }

    public static void editContact(String name) {
        for (Contact c : contacts) {
            if (c.firstName.equalsIgnoreCase(name)) {
                System.out.println("Contact Found! Enter new details...");
                System.out.print("Enter New Address: ");
                c.address = sc.nextLine();
                System.out.print("Enter New City: ");
                c.city = sc.nextLine();
                System.out.print("Enter New State: ");
                c.state = sc.nextLine();
                System.out.print("Enter New ZIP: ");
                c.zip = sc.nextInt();
                System.out.print("Enter New Phone Number: ");
                c.phone = sc.nextLong();
                sc.nextLine(); // consume newline
                System.out.print("Enter New Email: ");
                c.email = sc.nextLine();

                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void deleteContact(String name) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.firstName.equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
