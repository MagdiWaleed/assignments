package view.user;


import models.TravelModel;
public class TravelsView {

    public static boolean viewTravelsList(TravelModel[] travels){
        int counter = 0;
        for (TravelModel travel : travels) {
            
            System.out.println("  "+(counter+1)+")  Travel To: " + travel.getTitle()+"     cost: "+travel.getPrice()+" # of tickets left: "+travel.numberOfAvilableMembers());
            counter++;
        }
        return counter ==0? false: true;

    }
}
