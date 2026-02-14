import javax.xml.xpath.XPathEvaluationResult;
import java.util.Scanner;
import java.util.Random;

public class Chernovik {
    public static void printArray(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void fillRandom(int[][] numbers, int randLow, int randHigh) {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = random.nextInt(randLow, randHigh);
            }
        }
    }
    public static void reverseArray(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length / 2; j++) {
                int temp = numbers[i][j];
                numbers[i][j] = numbers[i][numbers[i].length - 1 - j];
                numbers[i][numbers[i].length - 1 - j] = temp;
            }
        }
    }


    public static int[][] rotateArrayby90(int[][] numbers){
        int[][] transposeMatrix = new int[numbers.length][numbers[0].length];
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[i].length; j++){
                transposeMatrix[j][i] = numbers[i][j];

            }
        }
        reverseArray(transposeMatrix);
        return transposeMatrix;
    }
    public static void addK(int[][] numbers, int k) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if ((numbers[i][j] + k) <= 255){
                    numbers[i][j] += k;
                }
            }
        }
    }

    public static void changeArray(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] % 2 == 0 && (numbers[i][j] * 3) <= 453){
                    numbers[i][j] *= 3;
                    continue;
                }
                if ((numbers[i][j] * numbers[i][j]) <= 1000){
                    numbers[i][j] *= numbers[i][j];
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employers = scanner.nextInt();
        int months = scanner.nextInt();
        int[] numbersss = new int[]{2,3,4,5,6};

        int[][] numberssss = new int[][]{
                {2,4,5,6,7},
                {23,213,532,53}
        };
        int[][] numbers = new int[employers][months];
        fillRandom(numbers,0,256);
        printArray(numbers);
        reverseArray(numbers);
        System.out.println();
        printArray(numbers);
        System.out.println();
        addK(numbers, 100);
        printArray(numbers);
        System.out.println();
        int[][] numberss = new int[5][5];
        fillRandom(numberss,10,70);
        printArray(numberss);
        System.out.println();
        changeArray(numberss);
        printArray(numberss);
        System.out.println();
        System.out.println();
        numberss = rotateArrayby90(numberss);
        printArray(numberss);
    }
}

