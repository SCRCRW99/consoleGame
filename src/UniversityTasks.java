import java.util.Scanner;

public class UniversityTasks {

    public static int playerX = 1;
    public static int playerY = 1;
    public static int floor = 0;
    public static int torch = 30;
    public static boolean isGameRunning = true;
    public static int durability = 3;

    public static String playerClass = "";

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

        System.out.println("=*=**ВЫБЕРИТЕ КЛАСС**=*=");
        System.out.println("(1) ВЗЛОМЩИК. Для вас X — это сложный замок, требующий тонкой работы.");
        System.out.println("(2) КРУШИТЕЛЬ. Для вас X — это груда камней, которую можно разбить.");
        System.out.println("(3) ТЕНЬ. Для вас X — это провал в полу. ");
        System.out.print("выбери номер класса: ");

        String choice = scanner.nextLine();

        switch (choice){
            case "1": playerClass = "Rogue"; System.out.println("вы играете за " + playerClass); System.out.println("у вас есть ключ. Вы можете использовать его на букву 'K' чтобы открыть барьер"); break;
            case "2": playerClass = "Brute"; System.out.println("вы играете за " + playerClass); System.out.println("вам дали кирку. Использовать ее можно на букву 'B' но помните что у нее есть прочность и она может сломаться (изначально она равна 3)"); break;
            case "3": playerClass = "Shadow"; System.out.println("вы играете за " + playerClass); break;
            default: playerClass = "Rogue";
                System.out.println("вы ввели неверный класс, вам дали класс взломщика (по умолчанию)");
        }

        tower[floor][playerY][playerX] = '_';

        System.out.print("передвижение на w/s/a/d ");
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
                handelSpecialAbility(scanner,cmd);
            }

            else{
                handleMove(cmd);
            }
        }
    }

    public static void handelSpecialAbility(Scanner scanner, char cmd){


        if (!playerClass.equals("Rogue") && cmd == 'k'){
            System.out.println("вы не взломщик!!!");
            return;
        }
        if (!playerClass.equals("Brute") && cmd == 'b'){
            System.out.println("вы не крушитель!!!");
            return;
        }
        if (!playerClass.equals("Shadow") && cmd == 'j'){
            System.out.println("вы не тень!!!");
            return;
        }

        System.out.println("в какую сторону использовать? ");

        String input = scanner.nextLine().toLowerCase();
        if (input.isEmpty()){
            return;
        }


        char dir = input.charAt(0);
        int dx = 0, dy = 0;

        switch (dir){
            case 'w': dy = -1; break;
            case 'a': dx = -1; break;
            case 's': dy = 1; break;
            case 'd': dx = 1; break;
            default: return;
        }

        int moveX = playerX + dx;
        int moveY = playerY + dy;

        if (!isValidMove(moveY,moveX)){
            return;
        }


        if (playerClass.equals("Rogue")){
            int targetX = playerX + dx;
            int targetY = playerY + dy;

            int target = tower[floor][targetY][targetX];
            if (target == 'X'){
                System.out.println("вы открыли барьер");
                torch -= 5;
                tower[floor][targetY][targetX] = '_';
            }
            else {
                System.out.println("барьера нет");
            }
        }
        if (playerClass.equals("Brute")){
            int targetX = playerX + dx;
            int targetY = playerY + dy;
            if (durability <= 0){
                System.out.println("кирка сломана");
                return;
            }
            int target = tower[floor][targetY][targetX];
            if (target == 'X' || target == '#'){
                System.out.println("вы сломали препятствие");
                torch -= 3;
                tower[floor][targetY][targetX] = '_';
                durability--;
                System.out.println("прочность кирки = " + durability);
            }
            else {
                System.out.println("препятствия нет");
            }
        }
        if (playerClass.equals("Shadow")){
            int targetX = playerX + dx * 2;
            int targetY = playerY + dy * 2;
            int target = tower[floor][targetY][targetX];
            if (target == '_' || target == 'F' || target == 'U' || target == 'D'){
                System.out.println("прыжок");
                torch -= 2;
                playerY = targetY;
                playerX = targetX;
            }
        }

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
        if (!isValidMove(demoY,demoX)){
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

        if (!isValidMove(demoY,demoX)){
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

    public static boolean isValidMove(int y, int x){
        if (y < 0 || y >= tower[floor].length || x < 0 || x >= tower[floor][y].length){
            System.out.println("вы за пределами");
            return false;
        }
        return true;
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


