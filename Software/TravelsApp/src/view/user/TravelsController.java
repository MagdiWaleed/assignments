package view.user;


import models.Travel;
public class TravelsController {

    public static boolean viewTravelsList(Travel[] travels){
        int counter = 0;
        for (Travel travel : travels) {
            
            System.out.println("  "+(counter+1)+")  Travel To: " + travel.getTitle()+"     cost: "+travel.getPrice()+" # of tickets left: "+travel.numberOfAvilableMembers());
            counter++;
        }
        return counter ==0? false: true;

    }
}
