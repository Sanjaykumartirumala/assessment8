import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRatings {
    static class Movie {
        String title;
        String ratingCategory;
        double rating;

        Movie(String title, String category, double rating) {
            this.title = title;
            this.ratingCategory = category;
            this.rating = rating;
        }
    }

    public static void analyzeRatings(List<Movie> movies) {
        Map<String, Integer> countByCategory = new HashMap<>();
        Map<String, Double> totalRatingByCategory = new HashMap<>();

        for (Movie movie : movies) {
            countByCategory.merge(movie.ratingCategory, 1, Integer::sum);
            totalRatingByCategory.merge(movie.ratingCategory, movie.rating, Double::sum);
        }

        for (String category : countByCategory.keySet()) {
            double averageRating = totalRatingByCategory.get(category) / countByCategory.get(category);
            System.out.println(category + ": Count = " + countByCategory.get(category) + ", Average Rating = " + averageRating);
        }
    }
}
