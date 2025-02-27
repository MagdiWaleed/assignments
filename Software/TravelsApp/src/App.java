import java.util.Arrays;
import java.util.Scanner;

import controller.UserLoginController;
import data.TravelsData;
import data.UsersData;
import models.TravelModel;
import models.UserModel;
import view.Helper;
import view.admin.AdminPage;
import view.user.UserPage;

public class App {
    public static void main(String[] args) throws Exception {
        TravelModel [] inizilzedTravlesData = TravelsData.generateIntialTravelsData();
        UserModel[] all_users = UsersData.generateUsersData(inizilzedTravlesData);
        TravelModel[] all_travles = TravelsData.generateTravelsData(all_users,inizilzedTravlesData);// make relation many to many between the users and the travels
        Scanner scanner = new Scanner(System.in);
        UserModel current_user = null;
        //get current user object
        do {
            String choice;// chooser
            Helper.clearScreen();// helper function to clear screen
            System.out.println("///////// choose from below to continue... ///////////");
            System.out.println("  1)  Log in");
            System.out.println("  2)  Sign up");
            System.out.println("  3)  continue as Admin");
            System.out.print("Choose: ");
            choice = scanner.next();


            

            switch (choice) {
                case "1":{
                    Helper.clearScreen();
                    System.out.println("    /////// ENTER UR USERNAME ///////   ");
                    System.out.print("username: ");
                    scanner.nextLine();  
                    String username = scanner.nextLine(); 
                    
                    current_user = UserLoginController.getUserOutuput(all_users,username);//to check if the user is already exist
                    
                    if(current_user == null){// if no user found just continue
                        continue;
                    }
                 
                    UserPage.loadPgae(current_user,all_travles);// if there an account with the given username go to user page
        

                break;
                
            }
                case "2":{
                    Helper.clearScreen();
                    System.out.println("    /////// CREATE UR PROFILE ///////    ");
                    System.out.print("username: ");  
                    scanner.nextLine();
                    String username = scanner.nextLine();
                    
                    current_user = UserLoginController.getUserOutuput(all_users,username);
                    
                    if(current_user != null){// check if the user is already has an account
                        continue;
                    }
                    System.out.print("Enter your money: ");
                    double usermoney = scanner.nextDouble();
                    UserModel newuser = new UserModel(username, usermoney);// create new user instance
                    UserModel [] newUsersList = Arrays.copyOf(all_users, all_users.length+1);
                    newUsersList[all_users.length] = newuser; //append it to the list of users
                    all_users = newUsersList;
                 
                    UserPage.loadPgae(newuser,all_travles);//then load user page


                break;
            }
            
                case "3":{
                    Helper.clearScreen();
                    System.out.println("    /////// ADMIN PANEL ///////    ");
                    AdminPage.loadPgae(all_users, all_travles);
                    continue;
                }

                default:{
                    System.out.println("please enter valid option... ");
                    choice = scanner.next();

                    break;
                }
            }            
        } while(true);
    }



}
