package view.admin;

import models.TravelModel;
import models.UserModel;

public class SingleUserAdminDetailsView {
    public static void getUserDetails(UserModel user, TravelModel[] all_travel){
        System.out.println(" **   Username: " + user.getUsername());
        System.out.println(" **   Number of Travels: " + user.getNumberOfTravles());
        System.out.println(" **   Original Money: " + user.getOriginalMoney());
        System.out.println(" **   The rest of the money: " + user.getTheRestOfTheMoney());
        System.out.println(" **   My travels:");
        int counter = 1;
        for (TravelModel travel : user.getMyTravels(all_travel)) {
            System.out.println("         "+counter+")  Title: " + travel.getTitle()+" with cost: " + travel.getPrice());
            counter++;
        }

    }
}
