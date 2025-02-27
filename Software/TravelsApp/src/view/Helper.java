package view;


import java.io.IOException;

public class Helper {

    public static void clearScreen() {
        // try {
        //     new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        // } catch (IOException | InterruptedException ex) {
        //     System.out.println("Error clearing the screen: " + ex.getMessage());
        // }
        for (int i = 0; i <100;i++) {
            System.out.println();
        }

    }
    
    

}
