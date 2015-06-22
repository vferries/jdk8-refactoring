package loops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loops {
    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1,3,5,7);
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (i > 2) {
                result.add(i * i);
            }
        }
        System.out.println(result);
    }
}
