import java.util.Scanner;


public class p_and_q {
    public static void main(String[] args) {
        System.out.println("Find P and Q matrix ");
        System.out.println("Enter the value of a according to n*n ");
        Scanner S = new Scanner(System.in);

        System.out.print("a11: ");
        long A11 = S.nextInt();

        System.out.print("a12: ");
        long A12 = S.nextInt();

        System.out.print("a13: ");
        long A13 = S.nextInt();

        System.out.print("a21: ");
        long A21 = S.nextInt();

        System.out.print("a22: ");
        long A22 = S.nextInt();

        System.out.print("a23: ");
        long A23 = S.nextInt();

        System.out.print("a31: ");
        long A31 = S.nextInt();

        System.out.print("a32: ");
        long A32 = S.nextInt();

        System.out.print("a33: ");
        long A33 = S.nextInt();

        long Row1A11 = A11/A11;
        long Row1A12 = A12/A11;
        long Row1A13 = A13/A11;
        System.out.println(Row1A11);
        System.out.println(Row1A12);
        System.out.println(Row1A13);
        // R2-nR1 Where n =
//        float Row2A21 = A21-(Row1A11*A21);
//        float Row2A22 = A22-(Row1A12*A21);
//        float Row2A23 = A23-(Row1A13*A21);
//
////        System.out.println(Row1A11);
////        System.out.println(Row1A12);
////        System.out.println(Row1A13);
////        System.out.println(Row2A21);
////        System.out.println(Row2A22);
////        System.out.println(Row2A23);
//
//        //C2-nC1
//        float Col1A12 = A12-(A12*A11);
//        float Col1A22 = A21-(A21*A12);
//        float Col1A32 = A31-(A31*A11);





    }
}
