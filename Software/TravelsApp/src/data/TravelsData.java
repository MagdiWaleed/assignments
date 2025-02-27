package data;

import models.Travel;
import models.User;

public class TravelsData {
    public static Travel[] generateIntialTravelsData(){
        Travel[] travelsdata = {
            new Travel("Welcom To Paris", "Discover the bustling cityscape of Paris","paris", 200, 3),
            new Travel("Milan", "Visit the ancient city of Milan","milan", 150, 5),
            new Travel("Rome", "Stroll through the stunning Roman ruins","rome", 180, 5),
            new Travel("Discover Tokyo", "Experience the bustling metropolis of Tokyo","tokyo", 250, 10)

        };
        return travelsdata;
    }

    public static Travel[] generateTravelsData( User[] usersData, Travel[] travelsData){
        
        addRelatedMembers(travelsData, usersData);
        return travelsData;
        }

    public static void addRelatedMembers(Travel [] generatedTravels, User[] generatedUsers){
        for (Travel generatedTravel : generatedTravels){
            for (User user : generatedUsers){
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
