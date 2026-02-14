import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputWords = scanner.nextLine().trim();
        String[] words = inputWords.split(" ");

        String inputNumbers = scanner.nextLine().trim();
        String[] numbersStr = inputNumbers.split(" ");

        int[] numbers = new int[numbersStr.length];

        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        int minNumber = numbers[0];
        int maxNumber = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }

        for(int i = 0; i < words.length; i++) {
            int wordLength = words[i].length();
            if (wordLength >= minNumber && wordLength <= maxNumber) {
                System.out.print(words[i] + " ");
            }
        }

    }
}