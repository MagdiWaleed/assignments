package view.admin;

import models.UserModel;

public class AllUsersView {
    public static void viewAllUsers(UserModel[] all_users){
        int counter = 1;
        for (UserModel user : all_users){
            System.out.println("  "+counter+")  User Name: " + user.getUsername() + " Money: (" +user.getTheRestOfTheMoney()+"/" +user.getOriginalMoney()+")"+" # Travels: "+user.getNumberOfTravles());
            counter++;
        }
    }
}
