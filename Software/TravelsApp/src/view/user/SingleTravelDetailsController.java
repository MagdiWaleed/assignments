package view.user;


import models.Travel;

public class SingleTravelDetailsController {
  
    public static void getTravleDetails(Travel travelsDetails){
        System.out.println(" **   Title: " + travelsDetails.getTitle());
        System.out.println(" **   Description: " + travelsDetails.getDescription());
        System.out.println(" **   city: " + travelsDetails.getCity());
        System.out.println(" **   Price: " + travelsDetails.getPrice());
        System.out.println(" **   Number of available members: " + travelsDetails.numberOfAvilableMembers());

    }
}
