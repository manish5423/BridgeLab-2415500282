import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        int i = 0;
        int j = list.size() - 1;

    while (i < j) {
    int temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);

    i++;
    j--;
}
        System.out.println("Reversed: " + list);
    }
}
