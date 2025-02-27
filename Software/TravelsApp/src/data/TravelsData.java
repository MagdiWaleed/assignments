package data;

import models.TravelModel;
import models.UserModel;

public class TravelsData {
    public static TravelModel[] generateIntialTravelsData(){
        TravelModel[] travelsdata = {
            new TravelModel("Welcom To Paris", "Discover the bustling cityscape of Paris","paris", 200, 3),
            new TravelModel("Milan", "Visit the ancient city of Milan","milan", 150, 5),
            new TravelModel("Rome", "Stroll through the stunning Roman ruins","rome", 180, 5),
            new TravelModel("Discover Tokyo", "Experience the bustling metropolis of Tokyo","tokyo", 250, 10)

        };
        return travelsdata;
    }

    public static TravelModel[] generateTravelsData( UserModel[] usersData, TravelModel[] travelsData){
        
        addRelatedMembers(travelsData, usersData);
        return travelsData;
        }

    public static void addRelatedMembers(TravelModel [] generatedTravels, UserModel[] generatedUsers){
        for (TravelModel generatedTravel : generatedTravels){
            for (UserModel user : generatedUsers){
                for (int user_travelid : user.getTravelsIds()){
                    if (user_travelid ==  generatedTravel.getId()){
                        generatedTravel.addMember(user.getUsername());
                        break;
                    }
                }
            }
        }
    }
}
