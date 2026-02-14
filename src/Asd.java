import java.util.Random;


public class Asd {

    public static void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        int counter = 0;
        int counter1 = 0;
        int size = 3;

//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix.length; j++){
//                matrix[i][j] = random.nextInt(1,100);
//                if (i == j){
//                    counter += matrix[i][j];
//                    System.out.print("{" + matrix[i][j] + "}" + " ");
//                }
//                if (i + j == size - 1){
//                    counter1 += matrix[i][j];
//                    System.out.print(matrix[i][j] + " ");
//                }
//            }
//            System.out.println();
//        }
//
//        if (counter1 > counter){
//            System.out.println("побочная диагональ больше");
//        }
//        else {
//            System.out.println("основная диагональ больше");
//        }

        int max = Integer.MIN_VALUE;
        int numStr = 0;
//        for (int i = 0; i < matrix.length; i++){
//            int counter11 = 0;
//            for (int j = 0; j < matrix.length; j++) {
//                matrix[i][j] = random.nextInt(1, 100);
//                System.out.print(matrix[i][j] + " ");
//                counter11 += matrix[i][j];
//            }
//            if (counter11 > max){
//                numStr = i;
//                max = counter11;
//            }
//            System.out.println(counter11 + " ");
//        }
//        System.out.println(max);
//        System.out.print(numStr + 1);


        int[][] transponir = new int[3][2];
        int[][] matrix = new int[4][4];
//        for (int i = 0; i < matrix.length ; i++){
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[i][j] = random.nextInt(1, 100);
//                transponir[j][i] = matrix[i][j];
//                System.out.print(transponir[j][i] + " ");
//           }
//            System.out.println();
//        }
//
//        printArray(transponir);

//        int sort = 0;
        int temp = 1;

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = temp++;

                }
            }
            else{
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[i][j] = temp++;

                }
            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}