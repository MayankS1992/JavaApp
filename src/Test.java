import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Removes repetitions from a String
public class Test {
    public static List<Character> transform(String input) {
        List<Character> myList = new ArrayList<>();
        input.chars().forEach(ch->myList.add((char) ch));
        return IntStream
                .range(0, myList.size())
                .filter(i -> ((i < myList.size() - 1 && !myList.get(i).equals(myList
                        .get(i + 1))) || i == myList.size() - 1))
                .mapToObj(myList::get).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(Test.transform("abbcbbb").stream().map(Object::toString).reduce("", String::concat));
    }
}
