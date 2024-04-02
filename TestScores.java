import java.util.Collections;
import java.util.List;

public class TestScores {
    public static void analyzeScores(List<Integer> scores) {
        double average = scores.stream().mapToInt(Integer::intValue).average().orElse(0);
        long aboveAverage = scores.stream().filter(score -> score > average).count();
        long atAverage = scores.stream().filter(score -> score == average).count();
        long belowAverage = scores.stream().filter(score -> score < average).count();

        Collections.sort(scores);
        double median = scores.size() % 2 == 0 ?
                (scores.get(scores.size() / 2) + scores.get(scores.size() / 2 - 1)) / 2.0 :
                scores.get(scores.size() / 2);

        System.out.println("Above Average: " + aboveAverage + ", At Average: " + atAverage + ", Below Average: " + belowAverage);
        System.out.println("Median Score: " + median);
    }
}
