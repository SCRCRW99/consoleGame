import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class Games {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            char[] bridge = new char[]{'_', ' ', '_', '_', ' '};
            System.out.println(canStep(bridge, 0));
            System.out.println(canStep(bridge, 1));
        }
        if (input == 2) {
            int[][] shelves = new int[][]{{1, 2}, {1, 2, 3, 4}, {1}};
            warehouse(shelves);
        }
        if (input == 3) {
            String stepByStep = scanner.nextLine();
            char[][] maze = {
                    {'#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ',},
                    {'#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#'},
                    {'#', ' ', ' ', ' ', '#', ' ',},
                    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ',},
                    {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                    {'#', ' ', '#', '#', '#'}
            };
            steps(maze);
        }
        if (input == 4) {
            char[][][] hotel = {
                    {
                            {'0', '0', '0', '0'},
                            {'0', '0', '0', 'P'}
                    },
                    {
                            {'0', '0', '0', '0'},
                            {'0', '0', '0', '0'}
                    },
                    {
                            {'0', '0', '0', '0'},
                            {'P', '0', '0', '0'}
                    }
            };
            ghostHotel(hotel);
        }
        if (input == 5) {
            char[] magazine = {'B', 'B', 'B', 'B', 'B', 'B', ' ', ' ', ' ', ' '};
            magazine(magazine, 1);
        }
        if (input == 6) {
            String[][] rig = {{"Granade"},
                    {"Bandage", "painkiller"},
                    {"AK magazine", "AK magazine", "Bullets", " "}
            };
            arena(rig);
        }
        if (input == 7) {
            int[][] path = {
                    {1, 1, 1},
                    {1},
                    {1, 1, 1, 1},
                    {1, 1}
            };
            eldenRing(path,1,0);
        }
        if (input == 8) {
            int[][][] train = {
                    {
                            {0, 0},
                            {0, 0},
                            {0, 0}
                    },
                    {
                            {0, 0},
                            {0, 1},
                            {0, 0}
                    },
            };
            rdr2(train);
        }
        if (input == 9) {
            char[][][] tower = {
                    {
                        {'0','0','0'},
                        {'0','0','0'},
                        {'0','0','0'}
                    },
                    {
                        {'0','0','0','0'}
                    },
                    {
                        {'0'}
                    }
            };
            mistyStep(tower,0,0,0);
        }
    }

    public static void mistyStep(char[][][] tower,int f, int r, int c){
        if (f > tower.length || f <= 0 && r > tower.length || r <= 0 && c > tower.length){
            System.out.print("не на территории");
            return;
        }
        System.out.println("на территории");
    }

    public static void rdr2(int[][][] train){

        int counter1 = 0;
        for (int i = 0; i < train.length; i++){
            int counter2 = 0;
            int counter = 0;
            counter1++;
            for (int j = 0; j < train[i].length; j++){
                counter2++;
                for (int k = 0; k < train[i][j].length; k++){
                    counter++;
                    System.out.print(train[i][j][k] + " ");
                    if (train[i][j][k] == 1){
                        System.out.print("ряд " + counter2 + " вагон " + counter1 + " место " + counter);
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void eldenRing(int[][] path, int platformIndex, int positionIndex) {
        if (positionIndex < 0 || positionIndex > path.length || platformIndex < 0 || platformIndex > path.length) {
            System.out.println("за платформой");
        }

        if (path[platformIndex][positionIndex] == 1) {
            System.out.println(positionIndex + " безопасно");
        }
        else {
            System.out.println("упал");
        }
    }

    public static void arena(String[][] rig){
        int counter = 0;
        for (int i = 0; i < rig.length; i++){
            for (int j = 0; j < rig[i].length; j++){
                if (rig[i][j] == " "){
                    continue;
                }
                counter++;
            }
        }
        System.out.print(counter + " предметов");
    }

    public static boolean magazine(char[] magazine, int bulletIndex){
        if (bulletIndex <= 0 || bulletIndex > magazine.length){
            System.out.println("за пределами");
            return false;
        }

        while (true) {
            if (magazine[bulletIndex] == 'B') {
                System.out.println("выстрел");
                bulletIndex++;
            } else {
                System.out.println("холостой");
                return false;
            }
        }
    }

    public static void ghostHotel(char[][][] hotel){
        for (int i = 0; i < hotel.length;i++){
            for (int j = 0; j < hotel[i].length;j++) {
                for (int k = 0; k < hotel[i][j].length; k++) {

                    if (hotel[i][j][k] == 'P'){
                        System.out.print(i + "" + j + "" + k + " ");
                        System.out.print("player");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static boolean steps(char[][] maze) {
        int playerY = 5;
        int playerX = 1;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        while (true) {
            String input = scanner.nextLine();
            char steps = input.charAt(0);
            if (steps == 'd') {
                counter = maze[playerY][playerX + 1];
                if (counter == '#') {
                    System.out.print("сюда идти нельзя, стена");
                    continue;
                }
                else {
                    System.out.print("можно идти");
                    System.out.println();
                    playerX++;
                }
            }
            if (steps == 'w') {
                counter = maze[playerY - 1][playerX];
                if (counter == '#') {
                    System.out.print("сюда идти нельзя, стена");
                    return false;
                }
                else {
                    System.out.println("можно идти");
                    System.out.println();
                    playerY--;
                }
            }
            if (steps == 'a') {
                counter = maze[playerY][playerX - 1];
                if (counter == '#'){
                    System.out.println("сюда идти нельзя, стена");
                    return false;
                }
                else {
                    System.out.println("можно идти");
                    System.out.println();
                    playerX--;
                }
            }
            if (steps == 's') {
                counter = maze[playerY + 1][playerX];
                if (counter == '#') {
                    System.out.print("сюда идти нельзя, стена");
                    return false;
                } else {
                    System.out.println("можно идти");

                    playerY++;
                }
            }

        }
    }

    public static boolean canStep(char[] bridge, int index){
        if (index < 0 || index > bridge.length){
            return false;
        }
        if (bridge[index] == ' ') {
            return false;
        }
        return true;
    }

    public static void warehouse(int[][] shelves){
        for (int i = 0; i < shelves.length; i++){
            int count = 0;
            for (int j = 0; j < shelves[i].length; j++){
                System.out.print(shelves[i][j]);
                count++;
            }
            System.out.print(" на полке номер " + (i + 1) + " находится " + count + " предмета");
            System.out.println();
        }
    }
}
