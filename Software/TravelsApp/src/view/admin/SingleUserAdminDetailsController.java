package view.admin;

import models.Travel;
import models.User;

public class SingleUserAdminDetailsController {
    public static void getUserDetails(User user, Travel[] all_travel){
        System.out.println(" **   Username: " + user.getUsername());
        System.out.println(" **   Number of Travels: " + user.getNumberOfTravles());
        System.out.println(" **   Original Money: " + user.getOriginalMoney());
        System.out.println(" **   The rest of the money: " + user.getTheRestOfTheMoney());
        System.out.println(" **   My travels:");
        int counter = 1;
        for (Travel travel : user.getMyTravels(all_travel)) {
            System.out.println("         "+counter+")  Title: " + travel.getTitle()+" with cost: " + travel.getPrice());
            counter++;
        }

    }
}
