package models;

import java.util.ArrayList;

public class Travel {
    static int global_id =0;

    int id;
    double price;
    String title;
    String description;
    String city;
    int maxMembers;

    ArrayList<String> users_usernames = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
    public String getDescription(){
     return this.description;
    }

    public double getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }
    
    public int getMaxMembers() {
        return maxMembers;
    }

    public int getNumberofMyMembers(){
        return users_usernames.size();
    }


    public Travel( String title, String description, String city, double price, int maxMembers) {
        id = global_id;
        global_id++;
        this.title = title;
        this.description = description;
        this.price = price;
        this.maxMembers = maxMembers;
        this.city = city;
    }

    public int numberOfAvilableMembers() { 
        return maxMembers -users_usernames.size(); 
    }

    public void addMember(String username){
        users_usernames.add(username);
    }

    public void removeUser(String targetusername){ 
        for (int i =0;i<users_usernames.size();i++){
        if (users_usernames.get(i).equals(targetusername)){
            users_usernames.remove(i);
        }
    }
    
    }

    public User[] getAllMembers(User[] all_users){
        User[] my_users = new User[users_usernames.size()];
        int counter = 0;

        for(User user : all_users){

          for (String usrename: users_usernames){
            
            if(user.getUsername().equals(usrename)){
                my_users[counter]= user;
                counter++;
                // break;

            }
        }
    }
        return my_users;
    }


    

}
