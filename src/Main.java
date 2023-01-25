import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String inputString = "the quick brown fox jumps over the lazy dog";
        inputString.toLowerCase();
        String[] str = inputString.split(" ");
        System.out.println("В тексте - " + str.length + " слов");
        System.out.println("Топ 10");
        Arrays.stream(str)
                .collect(Collectors.toMap(v -> v, v1 -> 1, Integer::sum))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    int equal = (o2.getValue().compareTo(o1.getValue()));
                    if (equal == 0){
                        equal = o1.getKey().compareTo(o2.getKey());
                    }
                    return equal;
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getValue() + " - " + e.getKey()));
    }
}