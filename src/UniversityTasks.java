import java.sql.Struct;
import java.util.Scanner;

public class UniversityTasks {

    public static int playerX = 1;
    public static int playerY = 1;
    public static int floor = 0;
    public static int torch = 30;
    public static boolean isGameRunning = true;

    public static String playerClass = "";

    public static char[][][] tower = {
// === ЭТАЖ 0: "Обрыв" (5x6) ===
            {
                    {'#', '#', '#', '#', '_', '_'},
                    {'#', '_', '_', '_', '_', '_'},
                    {'#', '_', '_', 'U', '_', '_'},
                    {'#', '_', '_', '_', '_', '_'},
                    {'#', '_', '_', '_', '_', '_'}
            },
// === ЭТАЖ 1: "Тоннель" (3x8) ===
            {
                    {'_', '_', '_', '#', '#', '#', '#', '#'},
                    {'_', '_', '_', '_', '_', 'U', '_', '+'},
                    {'#', '#', '#', 'D', '#', '#', '#', '#'}
            },
// === ЭТАЖ 2: "Финал" (4x7) ===
            {
                    {'_', '#', '#', '#', '_', '_', '_'},
                    {'_', '#', 'F', 'X', '_', 'D', '_'},
                    {'_', '#', '#', '#', '_', '#', '_'},
                    {'_', '_', '_', '_', '_', '_', '_'}
            }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=*=**ВЫБЕРИТЕ КЛАСС**=*=");
        System.out.println("(1) ВЗЛОМЩИК. Для вас X — это сложный замок, требующий тонкой работы.");
        System.out.println("(2) КРУШИТЕЛЬ. Для вас X — это груда камней, которую можно разбить.");
        System.out.println("(3) ТЕНЬ. Для вас X — это провал в полу. ");
        System.out.print("выбери номер класса: ");

        String choice = scanner.nextLine();

        switch (choice){
            case "1": playerClass = "Rogue"; break;
            case "2": playerClass = "Brute"; break;
            case "3": playerClass = "Shadow"; break;
            default: playerClass = "Rogue";
                System.out.println("вы ввели неверный класс, вам дали класс взломщика (по умолчанию)");
        }
        System.out.println("вы играете за " + playerClass);

        System.out.print("w/s/a/d ");
        while (isGameRunning) {
            printHud();
            printFloor();

            if (torch <= 0){
                System.out.print("кажется факел потух и надежда угасла с ним ");
                break;
            }

            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) continue;
            char cmd = input.charAt(0);
            if (cmd == 'e') {
                handleAction(scanner);
            }
            else if (cmd == 'k' || cmd == 'b' || cmd == 'j'){
            }

            else{
                handleMove(cmd);
            }
        }
    }

    public static void handleAbility(Scanner scanner, char cmd){
        // проверить соответствие класса с командой
        // получить направление и в какую сторону она активируется
        // если класс, то соответствующие действия
    }

    public static void handleMove(char dir){

        int demoX = playerX;
        int demoY = playerY;

        switch (dir){
            case 'w': demoY--; break;
            case 'a': demoX--; break;
            case 's': demoY++; break;
            case 'd': demoX++; break;
            default: return;
        }
        if (demoY < 0 || demoY >= tower[floor].length ||
            demoX < 0 || demoX >= tower[floor][demoY].length){
            System.out.println("за пределы");
            return;
        }
        char targetTile = tower[floor][demoY][demoX];
        if (targetTile == '#'){
            System.out.println("вы ударились о стену ");
        }
        else if (targetTile == 'X') {
            System.out.println("вы ударяетесь о барьер ");
        }
        else {
            playerX = demoX;
            playerY = demoY;
            torch--;

            if (targetTile == '+'){
                torch += 10;
                tower[floor][playerY][playerX] = '_';
                System.out.println("вы подобрали масло");
            }
            if (targetTile == 'F'){
                System.out.println("вы добрались до финиша");
                isGameRunning = false;
            }
        }
    }

    public static void handleAction(Scanner scanner) {

        System.out.println("в какую сторону использовать? ");

        String input = scanner.nextLine().toLowerCase();
        if (input.isEmpty()) return;

        char dir = input.charAt(0);

        int demoX = playerX;
        int demoY = playerY;

        switch (dir){
            case 'w': demoY--; break;
            case 's': demoY++; break;
            case 'a': demoX--; break;
            case 'd': demoX++; break;
        }

        if (demoY < 0 || demoY >= tower[floor].length ||
            demoX < 0 || demoX >= tower[floor][demoY].length){
            System.out.println("за границей");
            return;
        }

        char tile = tower[floor][demoY][demoX];

        if (tile == 'U'){
            floor++;
            playerX = demoX;
            playerY = demoY;
            System.out.println("вы поднялись на этаж " + floor);
        }
        else if (tile == 'D'){
            floor--;
            playerX = demoX;
            playerY = demoY;
            System.out.println("вы спустились на этаж " + floor);
        }
        else{
            System.out.println("у нас нет лестницы");
        }
    }

    public static void printHud(){
        System.out.println("этаж " + floor);
        System.out.println("x: " + playerX + " y: " + playerY);
        System.out.println("факел " + torch);
    }

    public static void printFloor(){
        char[][] currentFloor = tower[floor];
        for (int i = 0; i < currentFloor.length; i++) {
            for (int j = 0; j < currentFloor[i].length; j++) {
                if (i == playerY && j == playerX) {
                    System.out.print("P ");
                }
                else {
                    System.out.print(currentFloor[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}


