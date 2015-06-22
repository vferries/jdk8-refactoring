import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExtractFunctionalParameter {
    public static void main(String... params) {
        int j = 3;
        System.out.println(j * j);

        List<Integer> list = Arrays.asList(1,3,5,7);
        List<Integer> result = list.stream().filter(i -> i > 2).map(i -> i * i).collect(Collectors.toList());
        System.out.println(result);
    }
}
