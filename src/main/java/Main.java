import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    private static void printMultiple(ArrayList<Element> multipleList) {
        int counter = 0;
        for (Element e : multipleList) {
            if (counter == multipleList.size() - 1) {
                System.out.print("(" + e.x + ", " + e.y + ")");
            } else {
                System.out.print("(" + e.x + ", " + e.y + ") ");
            }
            counter++;
        }
    }

    private static boolean checkReflexivity(ArrayList<Element> multipleList) {

        for(Element e : multipleList) {
            if(!Objects.equals(e.x, e.y)) return false;
        }
        return true;
    }

    private static boolean checkSymmetry (ArrayList<Element> multipleList) {

        for(Element e : multipleList) {
            if(e.y - 1 != e.x * 2) return false;
        }
        return true;

    }

    private static boolean checkTransitivity (ArrayList<Element> multipleList) {
        for(int i = 0; i < multipleList.size(); i++) {
            if(!(multipleList.get(i).x - 1 == multipleList.get(i+1).x * 2)
                    && i != multipleList.size() - 1) return false;

        }
        return true;
    }

    public static ArrayList<Element> getMultiplePairs(Integer[] multiple) {
        ArrayList<Element> multipleList = new ArrayList<>();
        Element element;
        for (int i = 0; i < multiple.length; i++)
            for (int k = i + 1; k < multiple.length; k++) {
                if (multiple[i] - 1 == multiple[k] * 2) {
                    element = new Element(multiple[i], multiple[k]);
                    multipleList.add(element);
                }
            }

        return multipleList.stream()
                .sorted(Comparator.comparing(Element::getX))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] multipleString = input.nextLine().split("\\|" + " ");
        Integer[] multiple = new Integer[multipleString.length - 1];

        for(int i = 0; i < multipleString.length; i++)
            if(!" ".equals(multipleString[i])
                    && !"  ".equals(multipleString[i])) multiple[i - 1] = Integer.parseInt(multipleString[i]);


        ArrayList<Element> multipleList = getMultiplePairs(multiple);

        if(checkReflexivity(multipleList)) System.out.println("Рефлексивно");
        else System.out.println("Антирефлексивно");

        if(checkSymmetry(multipleList)) System.out.println("Симметрично");
        else System.out.println("Антисимметрично");

        if(checkTransitivity(multipleList)) System.out.println("Транзитивно");
        else System.out.println("Нетранзитивно");

    }
}
