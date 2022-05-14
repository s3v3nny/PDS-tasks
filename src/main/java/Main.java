import java.util.*;


public class Main {

    private static void getComposition(int n, boolean[][] r) {
        for (int i = 0; i < n; i++)
            for (int k = 0; k < n; k++) {
                r[i][k] = r[i][k] & r[k][i];
            }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] multipleString = input.nextLine().split(" ");

        int n = multipleString.length;

        boolean[][] matrix = new boolean[n][n];

        for (int k = 0; k < n; k++) {
            if ("1".equals(multipleString[k])) matrix[0][k] = true;
            if ("0".equals(multipleString[k])) matrix[0][k] = false;
        }

        for (int i = 1; i < n; i++) {
            multipleString = input.nextLine().split(" ");
            for (int k = 0; k < n; k++) {
                if ("1".equals(multipleString[k])) matrix[i][k] = true;
                if ("0".equals(multipleString[k])) matrix[i][k] = false;
            }
        }

        getComposition(n, matrix);

        for (boolean[] i : matrix) {
            for (boolean k : i) {
                if (k) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}