package view.admin;

import models.TravelModel;
import models.UserModel;

public class SingleTravelAdminDetailsView{
    public static void getTravleDetails(TravelModel travel,UserModel[] all_users){
        System.out.println(" **   Title: " + travel.getTitle());
        System.out.println(" **   Description: " + travel.getDescription());
        System.out.println(" **   City: " + travel.getCity());
        System.out.println(" **   Price: " + travel.getPrice());
        System.out.println(" **   Number of booked members: " + travel.getNumberofMyMembers());
        System.out.println(" **   Number of my max members: " + travel.getMaxMembers());
        System.out.println(" **   list of memmbers: ");
        int counter = 1;
        for (UserModel user : travel.getAllMembers(all_users)) {
            System.out.println("        **  "+counter+")"+"    username: "+user.getUsername()+" ****" );
            counter++;
        }

    }
}