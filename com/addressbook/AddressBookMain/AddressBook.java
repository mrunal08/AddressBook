package com.addressbook.AddressBookMain;
import com.addressbook.controller.*;

import java.util.Arrays;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Program");
        Scanner Scan=new Scanner(System.in);

        AddressBookController addressBookController = new AddressBookController();

        while(true) {

            System.out.println("Choose what to do");
            System.out.println("1) add a person");
            System.out.println("2) edit person");
            System.out.println("3) delete a person");
            System.out.println("4) exit");
            int choice = Scan.nextInt();

            switch (choice) {
                case 1: addressBookController.addPerson();
                        addressBookController.print();
                        break;
                case 2: addressBookController.editPerson();
                    addressBookController.print();
                        break;
                case 3: addressBookController.deletePerson();
                    addressBookController.print();
                        break;
                case 4:    addressBookController.print();
                   break;
                case 5:return;
            }
        }

    }
}
