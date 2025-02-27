package view.user;

import java.util.Scanner;

import models.TravelModel;
import models.UserModel;
import view.Helper;

    public class UserPage {
            public static void loadPgae(UserModel current_user,TravelModel [] all_travles){
                Scanner userScanner = new Scanner(System.in);
            do{
                ////////////////////////////////////////////////////////////////////////////////////
                AppBar(current_user);// main screen/////////////////////////////
                System.out.println("Choose an option:");
                System.out.println("1. Book a travel");
                System.out.println("2. View your travels");
                System.out.println("3. Log out");
                
                int option = userScanner.next().charAt(0);
                userScanner.nextLine();
                switch (option) {

                    case '1':{
                        
                        ////////////////////////////////////////////////////////////////////////////////////
                        AppBar(current_user);// all travels screen/////////////////////////////

                        System.out.println("    ////// Welcome all Travels Page!.. type travel number to view its details or (q) to quit //////");
                        TravelsView.viewTravelsList(all_travles);
                        System.out.print("Enter Travel Number To View its Details: "); 
                        String travel_index_input = userScanner.next();
                        if (travel_index_input.equals("q")) break;
                        while (Integer.parseInt(travel_index_input)> all_travles.length){
                            System.out.println("Invalid number! please try again...");
                            travel_index_input = userScanner.next();
                        }
                        int travel_index =Integer.parseInt(travel_index_input)- 1;// becase the visualization is strating from 1
                            ////////////////////////////////////////////////////////////////////////////////////
                            AppBar(current_user);//here travel details will start/////////////////////////////
                            
                            TravelModel current_travel = all_travles[travel_index];    
                            SingleTravelDetailsView.getTravleDetails(current_travel);
                            System.out.print("do you want to booked it? (y) for yes (n) for no or (q) to quit: ");
                            char answer = userScanner.next().charAt(0);
                            if(answer== 'y'){ 
                                boolean valid = current_user.addTravel(current_travel) ;
                                if (!valid){
                                    System.out.println("Not enough money or no space left!");
                                    System.out.println("enter anything to continue...");
                                    userScanner.next().charAt(0);
                                    break;    
                                } 
                                    current_travel.addMember(current_user.getUsername());
                                }
                           

                                  }
                                  break;
                    case '2':{
                        ////////////////////////////////////////////////////////////////////////////////////
                        AppBar(current_user);//my travels screen/////////////////////////////
                        TravelModel [] my_travels = current_user.getMyTravels(all_travles);
                        System.out.println("    ////// Welcome to your booked Travels Page!.. type travel number to view its details or (q) to quit //////");
                        boolean doIhaveTravles = TravelsView.viewTravelsList(my_travels);
                        if (doIhaveTravles){
                            System.out.print("Enter Travel Number: ");
                            String input =userScanner.next();
                            if (input.equals("q") ) break;
                            String travel_index_input = userScanner.next();
                            if (travel_index_input.equals("q")) break;
                            while (Integer.parseInt(travel_index_input)> my_travels.length){
                                System.out.println("Invalid number! please try again...");
                                travel_index_input = userScanner.next();
                            }
                            int travel_index =Integer.parseInt(travel_index_input)- 1;// becase the visualization is strating from 1
                            ////////////////////////////////////////////////////////////////////////////////////
                            AppBar(current_user);//single travel screen/////////////////////////////
                            TravelModel current_travel = my_travels[travel_index];
                            SingleTravelDetailsView.getTravleDetails(current_travel);
                            System.out.print("do you want to unbooked it? (y) for yes (n) for no or (q) to quit: ");
                            char answer = userScanner.next().charAt(0);
                
                            if (answer == 'y'){
                                current_user.removeTravle(my_travels[travel_index]);
                                my_travels[travel_index].removeUser(current_user.getUsername());
                            }
                            
                        } else {
                            System.out.println();
                            System.out.println("    ////// You don't have any booked travels //////");
                            System.out.println("Enter anything to quit ...");
                            userScanner.next().charAt(0);
                        }
                        break;
                    }
                    case '3':{
                        System.out.println("    ////// Logged out successfully //////");
                        return;
                    }
                }
            } while (true);

        }
    
        private static void AppBar( UserModel current_user) {
        
        Helper.clearScreen();
        System.out.println("Welcome " + current_user.getUsername() + "! the rest of Your money is: (" + current_user.getTheRestOfTheMoney()+ ") out of("+current_user.getOriginalMoney()+") Number of travels: " +current_user.getNumberOfTravles());


        }

}