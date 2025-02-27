package data;

import models.Travel;
import models.User;

public class UsersData {
        public static User[] generateUsersData(Travel [] travelData){
        User[] usersData = {
            new User("magdi",500.0),
            new User("ahmed", 4000.0),
            new User("ali",350.0)
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
