import java.util.Scanner;

public class UniversityTasks {

    public static int playerX = 1;
    public static int playerY = 1;
    public static int floor = 0;
    public static int torch = 30;

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

        System.out.print("w/s/a/d ");
        while (true) {
            printHud();
            printFloor();

            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) continue;
            char cmd = input.charAt(0);
            if (cmd == 'e') {
                handleAction(scanner);
            }
            else{
                handleMove(cmd);
            }
            if (torch == 0){
                System.out.print("кажется факел потух и надежда угасла с ним ");
                break;
            }
        }
    }

    public static void handleMove(char dir){

        if (playerY < 0 || playerY >= tower[floor].length ||
            playerX < 0 || playerX >= tower[floor][playerY].length ||
            floor < 0 || floor >= tower.length){
            System.out.println("за пределы");
            return;
        }

        char playerPosition = 'P';
        int nextStepSign = tower[floor][playerY][playerX];
        char oldChar = 'P';
        char newChar = '_';
        switch (dir){
            case 'w':
                System.out.println('w');
                if (tower[floor][playerY - 1][playerX] != '#') {
                    playerY -= 1;
                    torch--;
                    positionCheck(tower);
                }
                break;
            case 'a':
                System.out.println('a');
                if (tower[floor][playerY][playerX - 1] != '#') {
                    playerX -= 1;
                    torch--;
                    positionCheck(tower);
                }
                break;
            case 's':
                System.out.println('s');
                if (tower[floor][playerY + 1][playerX] != '#') {
                    playerY += 1;
                    torch--;
                    positionCheck(tower);
                }
                break;
            case 'd':
                System.out.println('d');
                if (tower[floor][playerY ][playerX + 1] != '#') {
                    playerX += 1;
                    torch--;
                    positionCheck(tower);
                }
                break;
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
        if (demoY < 0 || demoY > tower[floor].length ||
            demoX < 0 || demoX > tower[floor][demoY].length){

            System.out.print("за границей");
        }
        char tile = tower[floor][demoY][demoX];
        if (tile == 'U'){
            floor++;
            playerX = demoX;
            playerY = demoY;
            System.out.println("вы поднялись на этаж " + floor);
        }
        if (tile == '+'){
            playerY = demoY;
            playerX = demoX;
            torch = torch + 10;
            System.out.println("вы подобрали факел, заряд увеличился на 10 ");
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

    public static void positionCheck(char[][][] tower){
        char nextStepSign = tower[floor][playerY][playerX];

        if (nextStepSign == '#') {
            System.out.println("стена");
        }
        if (nextStepSign == '_') {
            System.out.println("шаг");
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


