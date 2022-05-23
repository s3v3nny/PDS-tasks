import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    private static ArrayList<Character> getStorage(char[] symbols) {
        ArrayList<Character> storage = new ArrayList<>();
        for (char c : symbols) storage.add(c);

        ListUtils.distinct(storage);
        return storage.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static void print(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) System.out.print(list.get(i));
            else System.out.print(list.get(i) + " ");
        }
    }

    private static ArrayList<Character> subtract(List<Character> appended, List<Character> surname) {

        ListUtils.removeAll(surname, appended);

        return surname.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static ArrayList<Character> append(List<Character> name, List<Character> middleName) {

        ListUtils.addAll(name, middleName);

        return name.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] surname = input.nextLine().toCharArray();
        char[] name = input.nextLine().toCharArray();
        char[] middleName = input.nextLine().toCharArray();

        List<Character> nameStorage = getStorage(name);
        List<Character> surnameStorage = getStorage(surname);
        List<Character> middleNameStorage = getStorage(middleName);

        print(surnameStorage);
        System.out.println("");
        print(nameStorage);
        System.out.println("");
        print(middleNameStorage);
        System.out.println("");

        nameStorage = append(nameStorage, middleNameStorage);
        surnameStorage = subtract(nameStorage, surnameStorage);

        System.out.print("R={");
        print(surnameStorage);
        System.out.print("}");


    }
}
