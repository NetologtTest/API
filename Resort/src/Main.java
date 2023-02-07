import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        ArrayList<Integer> x = new ArrayList<>();

        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) > 0 && intList.get(i) % 2 == 0) {
                int a = intList.get(i);
                x.add(a);

            }

        }


        Collections.sort(x);
        for (int i = 0; i < x.size(); i++) {
            System.out.print(x.get(i) + " ");
        }
    }
}

