import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequency {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();
        input.close();
        if (sentence == "" || sentence == null) {
            System.out.println("Your sentence is empty or null ");
        } else {
            Map<String, Long> wordFrequencyMap = Stream.of(sentence.split("\\W+"))
                                                    .parallel()
                                                    .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

            LinkedHashMap<String, Integer> wordFrequencyMapInDescendingOrder  = new LinkedHashMap<>();
            wordFrequencyMap.entrySet().stream()
                                       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                       .forEachOrdered(entry -> wordFrequencyMapInDescendingOrder.put(entry.getKey(), Math.toIntExact(entry.getValue())));

            for (Map.Entry<String, Integer> entry : wordFrequencyMapInDescendingOrder.entrySet()) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }

        }

    }

}