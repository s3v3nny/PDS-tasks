import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public static void addAll(List<Character> list, List<Character> addedList) {
        for (char c : addedList) {
            if(!contains(list, c)) list.add(c);
        }
    }

    public static void removeAll(List<Character> list, List<Character> removedList) {
        for(char c : removedList) {
            if(contains(list, c)) remove(list, c);
        }
    }

    public static boolean contains(List<Character> list, char letter) {
        for (char c : list) {
            if (letter == c) return true;
        }
        return false;
    }

    public static void remove(List<Character> list, char element) {
        for(int i = 0; i < list.size(); i++) {
            if(element == list.get(i)) {
                list.remove(i);
                break;
            }
        }
    }

    public static ArrayList<Character> distinct(List<Character> list) {
        ArrayList<Character> outputList = new ArrayList<>(65536);
        int[] buffer = new int[65536];

        for (char c : list) {
            if (buffer[c] == 0) {
                buffer[c] = 1;
                outputList.add(c);
            }
        }

        return outputList;
    }

    public static boolean vectorContains(List<Vector> list, Vector vector) {
        for (Vector v : list) {
            if (v.equals(vector)) return true;
        }
        return false;
    }

    public static int findIndex (List<Vector> list, Vector vector) {
        for(int i = 0; i < list.size(); i++) {
            if(vector.equals(list.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
