import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Scanner INPUT = new Scanner(System.in);
    public static final Random random = new Random();


    public static void main(String[] args) {
        // Welcome user
        System.out.println("**** Welcome to Battle Ships Game ****" +
                "\n Right now, the sea is empty. \n");
        //Create array represent ocean map
        char[][] ocean = new char[10][10];
        //Print current map
        showMap(ocean);
        //Deploy user ships
        deployShipsTo(ocean);
        showMap(ocean);
        //Computer deploy ships
        compDeployShips(ocean);
        Battle(ocean);
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
                if (ocean[row][col] == 0 || ocean[row][col] == 2) {
                    // 0 _ Available
                    // 2_ Computer's Ships
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

    private static void deployShipsTo(char[][] ocean) {
        boolean done;
        for (int latitude = 0; latitude < 5; latitude++) {
            done = false;
            while (!done) {
                int x = -1 , y = -1 ;
                boolean check = true;
                for (int longitude = 0; longitude < 2; longitude++) {
                    if (longitude == 0) {
                        System.out.print("Enter X coordinate for your ship: ");
                        x = INPUT.nextInt();
                    } else {
                        System.out.print("Enter Y coordinate for your ship: ");
                        y = INPUT.nextInt();
                    }
                }
                //Checks valid input
                check = checkX(x) && checkY(y);
                if(!check){
                    continue;
                }
                if (ocean[x][y] == 0) {
                    ocean[x][y] = '@';
                    done = true;
                } else {
                    System.out.println("There is a ship already there, try again");
                }
            }
        }
    }
    private static boolean checkX(int x){
        if (x > 9 || x < 0) {
            System.out.println("Invalid X coordinate");
            return false;
        }
        return true;
    }
    private static boolean checkY(int y){
        if (y > 9 || y < 0) {
            System.out.println("Invalid Y coordinate");
            return false;
        }
        return true;
    }

    private static void compDeployShips(char[][] ocean){
        System.out.println("Computer is deploying ships");
        for(int shipsDeployed = 0 ; shipsDeployed < 5 ;shipsDeployed ++){
            boolean done = false;
            while(!done) {
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                if (ocean[x][y] == 0) {
                    ocean[x][y] = 2;
                    done = true;
                    System.out.println(shipsDeployed + " . ship DEPLOYED");
                }
            }
        }
    }

    private static void Battle(char[][] ocean){
        boolean done = false;
        int compShips = 5, usrShips = 5;
        ArrayList<Integer> guessedSoFar = new ArrayList<>();
        ArrayList<Integer> compGuess = new ArrayList<>();
        while(!done){
            boolean check = false;
            //Player's Turn
            System.out.println("YOUR TURN");
            while(!check) {
                System.out.println("Enter X coordinate: ");
                int x = INPUT.nextInt();
                System.out.println("Enter Y coordinate: ");
                int y = INPUT.nextInt();
                check = checkX(x) && checkY(y) && checkGuessed(guessedSoFar, x, y);
                if (!check) {
                    System.out.println("You may enter a invalid coordinate or the coordinate you entered has been guessed");
                    continue;
                } else {
                    guessedSoFar.add(x);
                    guessedSoFar.add(y);
                }
                if (ocean[x][y] == 2){
                    System.out.println("Boom! You sunk the ship!");
                    compShips -= 1;
                    ocean[x][y]= '!';
                } else if (ocean[x][y] == '@'){
                    System.out.println("Oh no, you sunk your own ship :(");
                    usrShips -= 1;
                    ocean[x][y] = 'x';
                } else {
                    System.out.println("Sorry, you missed" );
                    if(ocean[x][y] == 0){
                        ocean[x][y] = '-';
                    }
                }
            }
            //Computer Turn
            check = false;
            System.out.println("COMPUTER TURN");
            while(!check){
                System.out.println("COMPUTER TURN");
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                check = checkGuessed(compGuess, x, y);
                if(!check){
                    continue;
                } else {
                    compGuess.add(x);
                    compGuess.add(y);
                }
                if (ocean[x][y] == '@'){
                    System.out.println("The Computer sunk one of your ships!");
                    usrShips -= 1;
                    ocean[x][y]= 'x';
                } else if (ocean[x][y] == 2){
                    System.out.println("The Computer sunk one of its own ships");
                    compShips -= 1;
                    ocean[x][y] = '!';
                } else {
                    System.out.println("Computer missed" );
                }
            }
            showMap(ocean);
            System.out.println("Your Ships: " + usrShips + "| Computer ships: "+ compShips);
            System.out.println("----------------------------------------------------------");
            if(compShips == 0){
                System.out.println("Hooray! You win the battle ;)");
                done = true;
            }
            if(usrShips == 0) {
                System.out.println("You Lose :( ");
                done = true;
            }

        }
    }
    private static boolean checkGuessed(ArrayList<Integer> List, int x , int y){
//        Return true if x , y have not yet guessed false otherwise
        for(int i = 0 ; i < List.size(); i++){
            if(i % 2 == 0){
                if(List.get(i) == x && List.get(i+1) == y){
                    return false;
                }
            }
        }
        return true;
    }


}
