import javax.sql.rowset.spi.SyncResolver;
import java.util.Scanner;

public class Practice1 {
    public static void printArray(int[] number){
        for (int i = 0; i < number.length; i++){
            System.out.print(number[i] + " ");
        }
        System.out.println();
    }

    public static int task11(int[] number){
        return number[0];
    }

    public static int task12(int[] number){
        return number[number.length - 1];
    }

    public static int task13(int[] number){
        int sum = 0;
        for (int i = 0; i < number.length; i++){
            sum = sum + number[i];
        }
        return sum;
    }

    public static int task14(int[] number){
        int average = 0;
        for (int i = 0; i < number.length; i++){
            average = number[i] + average;
        }
        return average / number.length;
    }
    public static boolean task15(int[] number){
        for (int i = 0; i < number.length; i++){
            if (number[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void task16(int[] number){
        for (int i = 0; i < number.length;i++){
            System.out.print((number[i] = 1) + " ");
        }
    }

    public static void task17(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                System.out.print(number[i] + " ");
            }
        }
    }
    public static void task18(int[] number){
        for (int i = number.length - 1; i % 2 == 0; i--){
            System.out.print(number[i] + " ");
        }
    }

    public static void task19(int[] number){
        for (int i = 0; i < number.length; i++) {
            if (number[i] < 0){
                number[i] = 0;
            }
            System.out.print(number[i] + " ");
        }
    }

    public static void task20(int[] number){
        int counter = 0;
        for (int i = 0; i < number.length; i++){
            if (number[i] > 0){
                counter++;
            }
        }
        System.out.print(counter + " ");
    }

    public static int task21(String number){
        return number.length();
    }
    public static void task22(String number){
        System.out.print(number.charAt(0) + " " + number.charAt(number.length() - 1));
    }
    public static void task23(String number){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next().toUpperCase();
        System.out.println(text);
    }
    public static int task24(String number){
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.next();
        String text2 = scanner.next();
        return text1.length() + text2.length();
    }

    public static char task25(String str, int index){
        return str.charAt(index);
    }

    public static String myUpperCase(String str) {
        char[] chars = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar >= 'a' && currentChar <= 'z') {
                chars[i] = (char) (currentChar - 32);
            } else {
                chars[i] = currentChar;
            }
        }
        return new String(chars);
    }

    public static int task26(int[] number){
        int maxNumber = 0;
        for (int i = 0; i < number.length; i++){
            if (number[i] > maxNumber){
                maxNumber = number[i];
            }
        }
        return maxNumber;
    }

    public static int task27(int[] number){
        int maxNumber = 0;
        for (int i = 0; i < number.length; i++){
            if (number[i] < maxNumber){
                maxNumber = number[i];
            }
        }
        return maxNumber;
    }

    public static int task28(int[] number, int x){
        for (int i = 0; i < number.length; i++){
            if (number[i] == x)
                return x;
        }
        return -1;
    }

    public static void task29(int n){
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
            System.out.println(res);
        }
    }

    public static void task30(int n){
        int counter = 0;
        while (counter < 10){
            counter++;
            System.out.println(n + " умноженное на " + counter + " = " + (n * counter));
        }
    }

    public static void task31(int[] number) {
        int start = 0;
        int temp;
        int end = number.length - 1;

        while (start < end) {
            temp = number[start];

            number[start] = number[end];
            number[end] = temp;
            start++;
            end--;
        }
    }

    public static void task32(int[] number){
        int[] array = new int[number.length];
        task31(array);
    }

    public static String task33(String[] array) {
        String res = "";
        for (int i = 0; i < array.length; i++) {
            res += array[i];
        }
        return res;
    }

    public static void task34(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                int temp = numbers[j];

                if (numbers[j] > numbers[j + 1]) {
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    public static int task35(int[] numbers, int x){
        int counter = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == x){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,0};
        int[] secondArray = new int[]{10,1,-2,-4,4,6,-11,21,22,-44,55,66};
        int number = 0;
        String task = scanner.next();
        String[] stringArray = new String[]{"привет", "как", "дела"};
//        System.out.println("номер 1: " + task11(array));
//        System.out.println("номер 2: " + task12(array));
//        System.out.println("номер 3: " + task13(array));
//        System.out.println("номер 4: " + task14(array));
//        System.out.println("номер 5: " + task15(array));
//        System.out.print("номер 6: ");
//        task16(array);
//        System.out.println();
//        System.out.println("номер 7:");
//        task17(secondArray);
//        System.out.println();
//        System.out.println("номер 8:");
//        task18(secondArray);
//        System.out.println("номер 9");
//        task19(secondArray);
//        System.out.println();
//        System.out.println("номер 10");
//        task20(secondArray);
//        System.out.println();
//        System.out.println("номер 11:");
//        System.out.println(task21(task));
//        System.out.println("номер 12:");
//        task22(task);
//        System.out.println();
//        task23(task);
//        System.out.println(task24(task));
//        System.out.println(task25(task, 1));
//        System.out.println(myUpperCase(task));
        System.out.println(task26(secondArray));
        System.out.println(task27(secondArray));
        System.out.println(task28(array, 4));
        task29(10);
        task30(5);
        printArray(array);
        task31(array);
        printArray(array);
        task32(array);
        printArray(array);
        System.out.println(task33(stringArray));
        task34(secondArray);
        System.out.println();
        System.out.println(task35(array,2));
    }
}