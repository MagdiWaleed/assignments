package view.admin;

import models.Travel;

public class AllTravlesController {
     public static boolean viewTravelsList(Travel[] travels){
        int counter = 0;
        for (Travel travel : travels) {
            
            System.out.println("  "+(counter+1)+")  Travel To: " + travel.getCity()+"     cost: "+travel.getPrice()+"   members: ("+travel.getNumberofMyMembers()+"/"+travel.getMaxMembers()+")");
            counter++;
        }
        return counter ==0? false: true;

    }
}
