package view.admin;

import models.User;

public class AllUsersController {
    public static void viewAllUsers(User[] all_users){
        int counter = 1;
        for (User user : all_users){
            System.out.println("  "+counter+")  User Name: " + user.getUsername() + " Money: (" +user.getTheRestOfTheMoney()+"/" +user.getOriginalMoney()+")"+" # Travels: "+user.getNumberOfTravles());
            counter++;
        }
    }
}
