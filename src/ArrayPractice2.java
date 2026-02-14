public class ArrayPractice2 {
    public static void printArray(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
    public static void swapNumber(int[] numbers){
         int temp = numbers[0];
         numbers[0] = numbers[numbers.length - 1];
         numbers[numbers.length - 1] = temp;
    }
    public static void transformEvenOdd(int[] number){
        for (int i = 0; i < number.length; i++){
            number[i]++;
        }
    }
    public static void evenOddCounter(int[] numbers){
        int counter = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] % 2 == 0){
                counter++;
            }
        }

        System.out.println("четные " + counter);
        System.out.println("нечетные " + (numbers.length - counter));
    }
    public static void main(String[] args) {
        int[] array = new int[]{5,5,4,3,2};

        printArray(array);
        swapNumber(array);
        printArray(array);
        transformEvenOdd(array);
        printArray(array);
        int[] array2 = new int[]{3,7,5,4,1,13,6};
        evenOddCounter(array2);
        transformEvenOdd(array2);
        evenOddCounter(array2);
        printArray(array2);
    }
}
