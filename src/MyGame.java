import java.util.Random;
import java.util.Scanner;

public class MyGame {
    // двери которые можно открыть (с ключом) и есть перегородки, есть двери с питанием (включается рубильник)
    // можно подбирать ключ на f
    // есть прогнившие доски (падаем на этаж ниже)
    // есть здоровье и есть факел, чем меньше здоровье тем больше тратится факел
    // молоток которым можно чинить доски


    //1 вывод HUD: текущий этажа, координаты игрока и заряд факела
    //2 вывод массива
    //3 проверка границ
    //4 проверка клеток
    //5 логика сохранения клеток
    //6 движение (по клетками и верх вниз)
    //7 механика факела + бонус за плюсик + вычитание за действие ( -1 )
    //8 механика класса
    //9 механика барьера
    public static int playerX = 1;
    public static int playerY = 1;
    public static int floor = 0;
    public static int torch = 37;
    public static int key = 0;
    public static int health = 100;
    public static int bandage = 0;
    public static int bleeding = 0;
    public static boolean isBleeding = false;
    public static int hammer = 0;
    public static boolean isGameRunning = true;
    public static boolean Switch = false;

    public static char[][][] dungeonMap = {
            // ========== ЭТАЖ 0 (ПОДВАЛ) ==========
            {
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', 'P', '.', '.', '#', '.', '.', '.', '.', '#'},
                    {'#', '.', '#', '.', '#', '▬', '#', '#', '.', '#'},
                    {'#', '.', '#', 'U', '.', '.', '#', '+', '.', '#'},
                    {'#', '.', '#', '#', '#', '.', '#', '#', '.', '#'},
                    {'#', '.', '|', '.', '#', '.', '.', '.', '.', '#'},
                    {'#', '#', '#', '.', '#', '#', '#', '#', '.', '#'},
                    {'#', '*', '|', '.', '.', '.', '.', '.', '+', '#'},
                    {'#', '♥', '#', '#', '#', '#', '.', '#', '.', '#'},
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
            },

            // ========== ЭТАЖ 1 (ОСНОВНОЙ) ==========
            {
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', '.', '.', '.', '#', '.', '.', '.', '.', '#'},
                    {'#', '.', '#', '=', '#', '.', '#', '#', '.', '#'},
                    {'#', '.', '#', 'D', '.', '.', '#', 'U', '.', '#'},
                    {'#', '.', '#', '#', '#', '.', '#', '#', '=', '#'},
                    {'#', '▬', '.', '.', '#', '.', '.', '.', '.', '#'},
                    {'#', '#', '#', '.', '#', '#', '#', '#', '.', '#'},
                    {'#', '♥', '|', '.', '=', '.', '.', '|', '.', '#'},
                    {'#', '+', '#', '#', '#', '#', 'K', '#', '.', '#'},
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
            },

            // ========== ЭТАЖ 2 (ЧЕРДАК) ==========
            {
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', 'X', '.', '.', '#', '.', '.', '⚒', '.', '#'},
                    {'#', '.', '#', '.', '#', '.', '#', '#', '.', '#'},
                    {'#', '.', '#', '.', '.', '.', '#', 'D', '.', '#'},
                    {'#', '.', '#', '#', '#', '.', '#', '#', '.', '#'},
                    {'#', 'U', '|', '.', '#', '=', '.', '.', '.', '#'},
                    {'#', '#', '#', '.', '#', '#', '#', '#', '.', '#'},
                    {'#', '▬', '=', '+', '.', 'B', '.', '.', 'B', '#'},
                    {'#', '+', '#', '#', '#', '#', 'F', '#', '.', '#'},
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
            },

            // ========== ЭТАЖ 3 (СКЛЕП) ==========
            {
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', '.', '.', '.', '#', '.', '▬', '.', '.', '#'},
                    {'#', '.', '#', '.', '#', '=', '#', '#', '.', '#'},
                    {'#', '.', '#', '+', '=', '=', '#', '.', '.', '#'},
                    {'#', '.', '#', '#', '#', 'K', '#', '#', '.', '#'},
                    {'#', 'D', '.', '.', '#', '=', '=', '.', '.', '#'},
                    {'#', '#', '#', '.', '#', '#', '#', '#', '.', '#'},
                    {'#', '+', '=', '.', '.', '.', '.', '.', '.', '#'},
                    {'#', '.', '#', '#', '#', '#', '.', '#', '.', '#'},
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
            }
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dungeonMap[floor][playerY][playerX] = '.';
        while (isGameRunning) {
            HUD();
            printFloor();
            System.out.print("введите действие: ");
            String input = scanner.next().toLowerCase();
            if (input.isEmpty()) continue;
            char cmd = input.charAt(0);
            handleMove(cmd);
            if (cmd == 'e'){
                System.out.print("введите направление: ");
                handleAction(scanner);
            }
            if (torch <= 0){
                System.out.println("вы проиграли, факел потух");
                isGameRunning = false;
            }
            if (health < 100) {
                torch--;
            }
            if (health <= 0) {
                System.out.println("вы разбились");
                isGameRunning = false;
            }
            if (isBleeding == true){
                bleeding++;
                health -= bleeding;
            }
        }
    }

    public static void handleAction(Scanner scanner) {

        String input = scanner.next().toLowerCase();
        char dir = input.charAt(0);

        int demoX = playerX;
        int demoY = playerY;

        switch (dir) {
            case 'w': demoY--;break;
            case 'a': demoX--;break;
            case 's': demoY++;break;
            case 'd': demoX++;break;
            default: return;
        }

        if (!isValidMove(demoX, demoY)) {
            return;
        }

        char target = dungeonMap[floor][demoY][demoX];

        if (target == 'U') {
            floor++;

            System.out.println("вы поднялись на этаж " + floor);
            playerY = demoY;
            playerX = demoX;
        }
        if (target == 'D') {
            floor--;
            System.out.println("вы спустились на этаж " + floor);
            playerY = demoY;
            playerX = demoX;
        }
        if (target == '⚒') {
            hammer += 3;
            System.out.println("вы подобрали молоток, его заряд равен: " + hammer + " вы можете чинить прогнившие доски");
            dungeonMap[floor][demoY][demoX] = '.';
        }
        if (target == 'K') {
            key += 1;
            System.out.println("вы подобрали ключ, его заряд равен: " + key + " вы можете открывать тяжелые двери");
            dungeonMap[floor][demoY][demoX] = '.';
        }
        if (target == 'X') {
            System.out.println("кажется... что-то щелкнуло... и подало электричество на двери");
            Switch = true;
            dungeonMap[floor][demoY][demoX] = '.';
        }
        if (target == '|' && Switch != true) {
            System.out.println("вам нужно включить рубильник");
            return;
        }

        if (target == '=' && hammer > 0){
            hammer--;
            System.out.println("вы починили доску, осталось использований молотка " + hammer);
            dungeonMap[floor][demoY][demoX] = '.';
        }

        if (target == 'B' && key > 0){
            key--;
            dungeonMap[floor][demoY][demoX] = '.';
        }
        if (key <= 0 && target == 'B'){
            System.out.println("у вас нет ключа");
            return;
        }
        if (hammer <= 0 && target == '='){
            System.out.println("у вас нет молотка");
            return;
        }
        if (target == '▬'){
            bandage++;
            System.out.println("вы подобрали бинт");
            dungeonMap[floor][demoY][demoX] = '.';
            isBleeding = false;
        }

    }

    public static void handleMove(char dir){
        Random random = new Random();
        int counter = random.nextInt(0,2);

        int demoX = playerX;
        int demoY = playerY;


        switch (dir){
            case 'w': demoY--; break;
            case 'a': demoX--; break;
            case 's': demoY++; break;
            case 'd': demoX++; break;
            default:return;
        }
        if (!isValidMove(demoX,demoY)){
            return;
        }

        char target = dungeonMap[floor][demoY][demoX];

        if (target == '|'){
            System.out.println("вы открыли дверь");
        }

        if (target == '#'){
            System.out.println("вы ударились об стену");
            return;
        }
        if (target == '+') {
            torch += 10;
            System.out.println("вы подобрали факел его заряд = " + torch);
            dungeonMap[floor][demoY][demoX] = '.';
            playerX = demoX;
            playerY = demoY;
        }
        if (target == '♥') {
            health += 50;
            System.out.println("вы подобрали здоровье, осталось" + health);
            dungeonMap[floor][demoY][demoX] = '.';
            playerY = demoY;
            playerX = demoX;
        }

        if (target == '='){
            floor--;
            System.out.println("вы наступили на прогнившую доску и упали на этаж ниже");
            if (counter == 0){
                System.out.println("вы вывернули ногу потеряв 50% здоровья");
                health -= 50;
            }
            if (counter == 1) {
                System.out.println("вы наступили на доску с ржавым гвоздем и провалились вниз, кажется вам повезло и гвоздь смягчил падение");
                System.out.println("вы не потеряли здоровье от падения, но получили кровотечение");
                isBleeding = true;

            }
        }

        if (target == 'F'){
            System.out.println("вы убежали из особняка");
            isGameRunning = false;
        }
        if (target == 'B' && key <= 0){
            System.out.println("вы не можете пройти в эту дверь пока не подберете ключ!!!");
            return;
        }
        if (target == '|' && Switch == false){
            System.out.println("вам нужно переключить рубильник");
            return;
        }

        if (target == '*'){
            System.out.println("вы подобрали большой кувшин масла");
            torch += 20;
            System.out.println("заряд факела прибавился на 20");
        }

        playerX = demoX;
        playerY = demoY;
        torch--;


    }

    public static boolean isValidMove(int x, int y){
        if (y < 0 || y >= dungeonMap[floor].length || x < 0 || x >= dungeonMap[floor][y].length){
            System.out.println("за пределами");
            return false;
        }
        return true;
    }


    public static void HUD(){
        System.out.println("[" + "здоровье " + health + "]");
        System.out.println("[" + "факел " + torch + "]");
        System.out.println("[" + "этаж " + floor + "]");
        System.out.println("[" + "X: " + playerX + "Y: " + playerY + "]");
    }

    public static void printFloor(){
        char[][] currentFloor = dungeonMap[floor];
        for (int i = 0; i < currentFloor.length; i++){
            for (int j = 0; j < currentFloor[i].length; j++){
                    if (i == playerY && j == playerX) {
                        System.out.print("P ");
                    } else {
                        System.out.print(currentFloor[i][j] + " ");
                    }
                }
            System.out.println();
            }

        }
    }

// ЛЕГЕНДА:
// '#' - стена (непроходимо)
// '.' - пол (проходимо)
// 'x' - запертая дверь (нужен ключ)
// 'E' - дверь с электропитанием
// 'S' - рубильник (включает двери E)
// 'k' - ключ (подобрать на F)
// '=' - гнилые доски (провал на этаж ниже)
// 'F' - факел (свет)
// '⚒' - молоток (чинить доски)
// '♥' - здоровье/аптечка
