import java.util.Scanner;

public class Task4 {

    public static int[][] main(int R, int C) {
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

    public static void calculateSquares(int arr[][]) {
        int N = arr.length;

        if (N % 2 != 0) {
            System.out.println("N must be even");
            return;
        }

        int halfN = N / 2;

        int sumGreen = 0;
        int sumWhite = 0;
        int sumGray = 0;
        int sumYellow = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i < halfN) {
                    if (j < halfN)
                        sumGreen += arr[i][j];
                    else {
                        sumWhite += arr[i][j];
                    }
                }
                else {
                    if (j < halfN)
                        sumGray += arr[i][j];
                    else {
                        sumYellow += arr[i][j];
                    }
                }
            }
        }

        System.out.println("Green: " + sumGreen);
        System.out.println("White: " + sumWhite);
        System.out.println("Gray: " + sumGray);
        System.out.println("Yellow: " + sumYellow);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N;

        System.out.println("Введите N: ");
        N = scanner.nextInt();

        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = scanner.nextInt();
            }
        }

        calculateSquares(result);

    }
}