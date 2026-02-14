public class Loops {

    public static void main(String[] args) {
//        for (int i = 1; i < 6; i++){
//            System.out.print(i + " ");
//            for (int j = 1; j < 11; j++) {
//                System.out.print(j);
//            }
//            System.out.println();
//        }
//        int k = 1;
//        for (int i = 16; i > 13; i--){
//            for (int j = 0; j < 3; j++){
//                System.out.print(k++);
//            }
//            System.out.println(" " + i);
//        }
//        for (int i = 1; i < 4; i++){
//            System.out.print(i + " ");
//            for (int j = 1; j < 7; j++){
//                System.out.print(j);
//            }
//            System.out.println(" " + (i + 1));
//        }
//        for (int i = 1; i <= 5; i++){
//            System.out.print(i + " ");
//            for (int j = 5; j > 0; j--){
//                System.out.print(j);
//            }
//            System.out.println();
//        }
        int x = 1;
        for (int i = 10; i < 50; i += 10){
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++){
                System.out.print(x++ + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 1; i < 5; i++){
            System.out.print(i + " ");
            for (int j = 1; j < 5; j++){
                System.out.print(j);
            }
            System.out.println(" " + (i + 5));
        }
        System.out.println();
        for (int i = 1; i < 6; i++){
            System.out.print(i + ": ");
            for (int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
        int k = 1;
        int z = 20;
        for (int i = 1; i < 8; i += 2) {
            System.out.print(i + " ");
            for (int j = 5; j > 5 - k; j--) {
                System.out.print(j);
            }
            System.out.println(" " + z);
            k++;
            z--;
        }
    }
}
