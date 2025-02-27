package data;

import models.TravelModel;
import models.UserModel;

public class UsersData {
        public static UserModel[] generateUsersData(TravelModel [] travelData){
        UserModel[] usersData = {
            new UserModel("magdi",500.0),
            new UserModel("ahmed", 4000.0),
            new UserModel("ali",350.0)
        };
        
        usersData[0].addTravel(travelData[0]);
        usersData[0].addTravel(travelData[1]);

        usersData[1].addTravel(travelData[0]);
        usersData[1].addTravel(travelData[1]);
        usersData[1].addTravel(travelData[2]);
        usersData[1].addTravel(travelData[3]);
        usersData[1].addTravel(travelData[3]);
        usersData[1].addTravel(travelData[0]);

        usersData[2].addTravel(travelData[0]);
        usersData[2].addTravel(travelData[1]);
        return usersData;
    }
}
