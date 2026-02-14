import java.util.Scanner;

public class Task3 {

    public static int[][] fillArraySnake(int R, int C) {
        int[][] arr = new int[R][C];
        int currentValue = 1;

        for (int j = C - 1; j >= 0; j--) {

            if ((C - 1 - j) % 2 == 0) {
                for (int i = R - 1; i >= 0; i--) {
                    arr[i][j] = currentValue++;
                }
            }
            else {
                for (int i = 0; i < R; i++) {
                    arr[i][j] = currentValue++;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R, C;

        System.out.println("Введите количество строк: ");
        R = scanner.nextInt();

        System.out.println("Введите количество столбцов: ");
        C = scanner.nextInt();

        int[][] result = fillArraySnake(R, C);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.printf("%2s ", result[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}