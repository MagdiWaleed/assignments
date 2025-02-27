package controller;


import models.UserModel;

public class UserLoginController {
    public  static UserModel  getUserOutuput(UserModel[] all_users,String username){
        int user_index = getUser(all_users,username);
        if (user_index == -1) return null;
        else return all_users[user_index]; 

}
private static int getUser(UserModel[] all_users,String username){
    for(int i = 0; i < all_users.length; i++){
        if(all_users[i].getUsername().equals(username)){
            return i;
        }
    }
    return -1;



}
}
