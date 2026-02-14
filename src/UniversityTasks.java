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
                    {'#', 'P', '_', '_', '_', '_'},
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
            String input = scanner.nextLine().toLowerCase();
            if (input.isEmpty()) continue;

            char dir = input.charAt(0);
            printFloor(tower[floor]);
            handleMove(dir);
        }
    }

    public static void handleMove(char dir){

        if (playerY < 0 || playerY >= tower[floor].length || playerX < 0 || playerX >= tower[floor][playerY].length || floor < 0 || floor >= tower.length){
            System.out.println("за пределы");
            return;
        }

        char playerPosition = 'P';
       int nextStepSign = tower[floor][playerY][playerX];
        char oldChar = 'P';
        char newChar = '_';
        System.out.println("x: " + playerX + " y: " + playerY);
        switch (dir){
            case 'w':
                System.out.println('w');
                if (tower[floor][playerY - 1][playerX] != '#') {
                    playerY -= 1;
                    positionCheck(tower);
                }
                break;
            case 'a':
                System.out.println('a');
                if (tower[floor][playerY][playerX - 1] != '#') {
                    playerX -= 1;
                    positionCheck(tower);
                }
                break;
            case 's':
                System.out.println('s');
                if (tower[floor][playerY + 1][playerX] != '#') {
                    playerY += 1;
                    positionCheck(tower);
                }
                break;
            case 'd':
                System.out.println('d');
                if (tower[floor][playerY][playerX + 1] != '#') {
                    playerX += 1;
                    positionCheck(tower);
                }
                break;
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

    public static void printFloor(char[][] floor){
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                System.out.print(floor[i][j] + " ");
            }
            System.out.println();
        }
    }
}


