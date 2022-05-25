import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int k = input.nextInt();
        int n = input.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;

        for (int i = k - 1; i >= 1; --i) {
            int position = random.nextInt(n--);
            int temp = array[i];
            array[i] = array[position];
            array[position] = temp;
        }

        for (int i = 0; i < k; i++)
            System.out.print(array[i] + " ");
    }
}