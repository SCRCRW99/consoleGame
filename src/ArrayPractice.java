import java.util.Scanner;
import java.util.Random;

public class ArrayPractice {
    public static void printArray(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillArrayRandom(int[][] numbers) {
        Random random = new Random();
        int randomNumber = random.nextInt();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = random.nextInt(20, 70);
            }
        }
    }
    public static void printMainDiagonal(int[][] numbers){
        System.out.println("главная диагональ");
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[i].length; j++){
                if (i == j){
                    System.out.print(numbers[i][j] + " ");
                }
            }
        }
        System.out.println();
    }
    public static int getSumOfDiagonals(int[][] numbers){
        int sumDiagonals = 0;
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers.length; j++){
                if (i == j || i + j + 1 == numbers.length) {
                    sumDiagonals += numbers[i][j];
                }
            }
        }
        return sumDiagonals;
    }


    public static void printSupDiagonal(int[][] numbers) {
        System.out.println("побочная диагональ");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (i + j + 1 == numbers.length) {
                    System.out.print(numbers[i][j] + " ");
                }
            }
        }
        System.out.println();
    }


    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] numbers = new int[rows][columns];
        fillArrayRandom(numbers);
        printArray(numbers);
        printMainDiagonal(numbers);
        printSupDiagonal(numbers);
        System.out.println(getSumOfDiagonals(numbers));
    }
}
