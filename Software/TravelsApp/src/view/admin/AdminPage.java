package view.admin;

import java.util.Scanner;

import models.Travel;
import models.User;
import view.Helper;

public class AdminPage {
    
    public static void loadPgae(User[] all_users, Travel[] all_Travels){
        Scanner AdminScanner = new Scanner(System.in);
        boolean logout=false;
        do{
            ////////////////////////////////////////////////////////////////////////////////////
                    // main screen/////////////////////////////
            Helper.clearScreen();
            System.out.println("Choose an option:");
            System.out.println("1. View All Travels");
            System.out.println("2. View All Users");
            System.out.println("3. Log out");
            
            String option = AdminScanner.next();
            AdminScanner.nextLine();
            switch (option) {
                
                case "1":{
                    /////// ALL TRAVELS SCREEN ////////
                    ///////////////////////////////////
                    
                    Helper.clearScreen();
                    AllTravlesController.viewTravelsList(all_Travels);
                    System.out.println("Enter the number of travel u want to view its details... " );
                    String allTravelsChooser = AdminScanner.next();
                    if (allTravelsChooser.equals("q")) break;
                    while (Integer.parseInt(allTravelsChooser)> all_Travels.length){
                        System.out.println("Invalid number! please try again...");
                        allTravelsChooser = AdminScanner.next();
                    }
                        ///// SINGLE SCREEN DETAILS /////
                        Helper.clearScreen();
                        SingleTravelAdminDetailsController.getTravleDetails(all_Travels[Integer.parseInt(allTravelsChooser)-1], all_users);
                        System.out.println("Enter anything to go back... ");
                        AdminScanner.next().charAt(0);
                    break;
                }

                case "2":{
                    Helper.clearScreen();
                    AllUsersController.viewAllUsers(all_users);
                    System.out.println("Enter the number of user you want to view his/her details or (q) to quit... " );
                    String allTravelsChooser = AdminScanner.next();
                    if (allTravelsChooser.equals("q")) break;
                    while (Integer.parseInt(allTravelsChooser)> all_Travels.length){
                        System.out.println("Invalid number! please try again...");
                        allTravelsChooser = AdminScanner.next();
                    }
                        ///// SINGLE USER SCREEN /////
                        //////////////////////////////
                        Helper.clearScreen();
                        SingleUserAdminDetailsController.getUserDetails(all_users[Integer.parseInt(allTravelsChooser)-1],all_Travels);
                        System.out.println("Enter anything to go back... ");
                        AdminScanner.next().charAt(0);
                    break;
    

                        
                }
              
                case "3":{
                   logout = true;
                   break; 
                }

                default:{
                    System.out.println("please enter valid number... ");
                    option = AdminScanner.next();
                }
            }
        }
        while(!logout);


    }
}
