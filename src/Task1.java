import java.util.Scanner;

import static java.lang.Math.*;

public class Task1 {

    public static int[] getNewArray(int[] arr) {
        int newArrayCount = 1;
        boolean isConditionTrue = true;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    isConditionTrue = false;
                    break;
                }
            }

            if (isConditionTrue) {
                newArrayCount++;
            }
            isConditionTrue = true;
        }

        int[] newArray = new int[newArrayCount];

        int index = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    isConditionTrue = false;
                    break;
                }
            }

            if (isConditionTrue) {
                newArray[index] = arr[i];
                index++;
            }
            isConditionTrue = true;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Sum: " + sum);
        System.out.println("Count: " + arr.length);
        newArray[newArrayCount - 1] = arr[arr.length - 1];
        for (int i = 0; i < newArrayCount; i++) {
            System.out.print(newArray[i] + " ");
        }
        System.out.println();

        return newArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        String[] numbersStr = input.split(" ");
        int size = numbersStr.length;

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        numbers = getNewArray(numbers);

    }
}
