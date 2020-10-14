import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {


        List<Integer> a = Arrays.asList(1, null, 2);

        List<Integer> b = Arrays.asList(3, 4, null, 5, 6);

        List<Integer> c = Arrays.asList(7, 8, 9, null);

        List<List<Integer>> test = new ArrayList<>();
        test.add(a);
        test.add(b);
        test.add(c);

        for (Integer t : flatten(test)) {
            System.out.println(t);
        }
    }

    public static  <T> List<T> flatten(List<List<T>> input) {
        List<T> finalList = new ArrayList<>();
        for (List<T> list : input) {
            list.stream()
                    .forEach(finalList::add);
        }
        for (T list : finalList) {
            finalList = finalList.stream()
                    .filter(t -> t != null)
                    .collect(Collectors.toList());
        }

        return finalList;
    }
}