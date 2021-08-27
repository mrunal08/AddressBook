package com.addressbook.controller;
import com.addressbook.model.*;

import java.util.*;

public class AddressBookController {

    Scanner scan = new Scanner(System.in);
    LinkedList<Person> personList = new LinkedList<Person>();
    HashMap<String,String > cityMap = new HashMap<>();
    HashMap<String,String> stateMap = new HashMap<>();

    public Person getPersonDetails() {
        System.out.println("enter first name");
        String firstName = scan.next();
        System.out.println("enter last name");
        String lastName = scan.next();

        for (Person person : this.personList) {
            if (firstName.equalsIgnoreCase(person.getFirstName()) && lastName.equalsIgnoreCase(person.getLastName())) {
                return person;
            }
        }
        return null;
    }

    public boolean checkPerson(String phoneNumber) {
        for (Person person : this.personList) {
            if (phoneNumber.equalsIgnoreCase(person.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public void addressDetails(Person person){
        System.out.println("enter address");
        person.setAddress(scan.next());

        System.out.println("enter city");
        person.setCity(scan.next());

        System.out.println("enter state");
        person.setState(scan.next());

        System.out.println("enter zipcode");
        person.setZip(scan.next());

        System.out.println("enter phone number");
        person.setPhoneNumber(scan.next());
    }

    public void addPerson() {
        Person person = new Person();
        System.out.println("enter first name");
        person.setFirstName(scan.next());
        System.out.println("enter last name");
        person.setLastName(scan.next());
        addressDetails(person);
        boolean duplicate=this.checkPerson(person.getPhoneNumber());
        if ( duplicate == false)
        {
            personList.add(person);
            cityMap.put(person.getCity(),person.getFirstName());
            stateMap.put(person.getState(),person.getFirstName());
            System.out.println("added person successfully");
        }
        else{
            System.out.println("details all ready exist");
        }
    }

    public void editPerson() {
        Person personToedit = this.getPersonDetails();
        if (personToedit != null) {
            addressDetails(personToedit);
            personToedit.setPhoneNumber(scan.next());
            System.out.println("details updated");
        }
        else{
            System.out.println("no details found");
        }
    }

    public void deletePerson(){
        Person personToDelete=this.getPersonDetails();
                if(personToDelete != null)
                {
                    this.personList.remove(personToDelete);
                    System.out.println("deleted successfully");
                }
                else
                    System.out.println("invalid details");
    }

    public void print(){
        for(Person items : personList){
            System.out.println(items);
        }
    }

}