package view.admin;

import models.TravelModel;

public class AllTravlesView {
     public static boolean viewTravelsList(TravelModel[] travels){
        int counter = 0;
        for (TravelModel travel : travels) {
            
            System.out.println("  "+(counter+1)+")  Travel To: " + travel.getCity()+"     cost: "+travel.getPrice()+"   members: ("+travel.getNumberofMyMembers()+"/"+travel.getMaxMembers()+")");
            counter++;
        }
        return counter ==0? false: true;

    }
}
