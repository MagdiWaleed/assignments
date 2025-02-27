package view.admin;

import models.Travel;
import models.User;

public class SingleTravelAdminDetailsController{
    public static void getTravleDetails(Travel travel,User[] all_users){
        System.out.println(" **   Title: " + travel.getTitle());
        System.out.println(" **   Description: " + travel.getDescription());
        System.out.println(" **   City: " + travel.getCity());
        System.out.println(" **   Price: " + travel.getPrice());
        System.out.println(" **   Number of booked members: " + travel.getNumberofMyMembers());
        System.out.println(" **   Number of my max members: " + travel.getMaxMembers());
        System.out.println(" **   list of memmbers: ");
        int counter = 1;
        for (User user : travel.getAllMembers(all_users)) {
            System.out.println("        **  "+counter+")"+"    username: "+user.getUsername()+" ****" );
            counter++;
        }

    }
}