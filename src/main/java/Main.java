import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    private static ArrayList<Character> getStorage(char[] symbols) {
        List<Character> storage = new ArrayList<>();
        for (char c : symbols) storage.add(c);
        return storage.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void print(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) System.out.print(list.get(i));
            else System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
    }

    private static void printVector(List<Vector> vector) {
        for (int i = 0; i < vector.size(); i++) {
            if (i == vector.size() - 1) System.out.print(vector.get(i).value);
            else System.out.print(vector.get(i).value + " ");
        }
        System.out.print("\n");
    }

    private static ArrayList<Vector> getVector(List<Character> universum, List<Character> list) {
        ArrayList<Vector> vectorList = new ArrayList<>();

        for (char c : list) {
            Vector vector;
            if (universum.contains(c)) {
                vector = new Vector(c, '1');
            } else {
                vector = new Vector(c, '0');
            }
            vectorList.add(vector);
        }
        return vectorList;
    }

    private static ArrayList<Character> getUniversum(List<Character> a, List<Character> b, List<Character> c) {
        List<Character> universum = new ArrayList<>();

        universum.addAll(a);
        universum.addAll(b);
        universum.addAll(c);

        return universum.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

    }

    private static ArrayList<Character> subtract(List<Character> appended, List<Character> surname) {

        surname.removeAll(appended);

        return surname.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static ArrayList<Character> append(List<Character> name, List<Character> middleName) {
        name.addAll(middleName);
        return name.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char[] a = input.nextLine().toCharArray();
        char[] b = input.nextLine().toCharArray();
        char[] c = input.nextLine().toCharArray();

        List<Character> aStorage = getStorage(a);
        List<Character> bStorage = getStorage(b);
        List<Character> cStorage = getStorage(c);

        List<Character> universum = getUniversum(aStorage, bStorage, cStorage);

        List<Vector> aVector = getVector(universum, aStorage);
        List<Vector> bVector = getVector(universum, bStorage);
        List<Vector> cVector = getVector(universum, cStorage);

        print(universum);
        printVector(aVector);
        printVector(bVector);
        printVector(cVector);

        bStorage = append(bStorage, cStorage);
        aStorage = subtract(bStorage, aStorage);

        aVector = getVector(universum, aStorage);
        printVector(aVector);


    }
}
