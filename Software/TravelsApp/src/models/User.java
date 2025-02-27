package models;

import java.util.ArrayList;

public class User {

    String username;
    double original_money;
    double spentMoney =0;
    int numberofTravles = 0;
    ArrayList<Integer> travels_ids = new ArrayList<>();

    public String getUsername(){
        return this.username;
    }

    public int getNumberOfTravles(){
        return this.numberofTravles;
    }

    public double getOriginalMoney(){
        return this.original_money;
    }

    public User(String username, double original_money) {
        this.username = username;
        this.original_money = original_money;
        
    }
    public int[] getTravelsIds() {
        int[] ids = new int[travels_ids.size()];
        for (int i = 0; i < travels_ids.size(); i++) {
            ids[i] = travels_ids.get(i);
        }
        return ids;
    }

    public User(String username, double original_money, int [] travels_ids) {
        this.username = username;
        this.original_money = original_money;
        
            for (int travel_id : travels_ids) {
               
                    this.travels_ids.add(travel_id);
            }
        
    }

    public double getTheRestOfTheMoney() {
        return original_money - spentMoney;
    }
    

    public Travel[] getMyTravels(Travel[] travelsList){
        Travel[] myTravleList = new Travel[travels_ids.size()];
        int counter = 0;
        for (Integer myTravelId  : this.travels_ids) {

            for (Travel travel : travelsList) {
                if (travel.id == myTravelId){
                    myTravleList[counter] = travel;
                    counter++;
                    // break;
                }
            }
        }
        return myTravleList;
    }
    
    public boolean addTravel(Travel travel){
        if (this.getTheRestOfTheMoney()>= travel.price && travel.numberOfAvilableMembers()-1 >=0) {
            spentMoney += travel.price;
            travels_ids.add(travel.id);
            numberofTravles++;
            return true;
        }
        else{
            return false;
        }
        
    }

    public void removeTravle(Travel travel){
       spentMoney-= travel.price;
       for(int i=0; i< travels_ids.size();i++){
            if (travel.id==travels_ids.get(i)){
                travels_ids.remove(i);
                numberofTravles--;
                break;
            }
        }
    }
    

}
