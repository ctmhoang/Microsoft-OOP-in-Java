import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        // Welcome user
        System.out.println("**** Welcome to Battle Ships Game ****" +
                "\n Right now, the sea is empty. \n");
        //Create array represent ocean map
        char[][] ocean = new char[10][10];
        //Create coordinates data for player ship
        int[][] pShipCor = new int[5][2];
        //Fill it with -1
        for (int[] row : pShipCor) {
            Arrays.fill(row, -1);
        }
        //Print current map
        showMap(ocean);

    }

    private static void printNav() {
        System.out.println("  0123456789  ");
    }

    private static void showMap(char[][] ocean) {
        //Printing the numbers on the grid
        printNav();
        for (int row = 0; row < ocean.length; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < ocean[row].length; col++) {
                if (ocean[row][col] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(ocean[row][col]);
                }
            }
            System.out.print("|" + row + "\n");
        }
        //Printing the numbers on the grid
        printNav();
    }

    private static void deployShips(int[][] pShipCor) {
        boolean done;
        for (int latitude = 0 ;latitude < 5; latitude++) {
            done = false;
            while(!done) {
                for (int longitude = 0; longitude < 2; longitude++) {
                    if (longitude == 0) {
                        System.out.print("Enter X coordinate for your ship: ");
                        int x = INPUT.nextInt();
                        pShipCor[latitude][longitude] = x;
                    } else {
                        System.out.print("Enter Y coordinate for your ship: ");
                        int y = INPUT.nextInt();
                        pShipCor[latitude][longitude] = y;
                    }
                }
                if(!done) {
                    if (pShipCor[latitude][0] > 9 || pShipCor[latitude][0] < 0) {
                        System.out.println("Invalid X coordinate");
                    }
                    if (pShipCor[latitude][1] > 9 || pShipCor[latitude][1] < 0) {
                        System.out.println("Invalid Y coordinate");
                    }
                    int timesExist = 0;
                    for(int[] row : pShipCor){
                        if(Arrays.equals(pShipCor[latitude], row)){
                            timesExist += 1;
                        }
                    }
                    if(timesExist > 1){

                    }
                }
            }
        }
    }


}
