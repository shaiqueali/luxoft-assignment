package technical.task.luxoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordStatistics {
    private int wordCounts;
    private int totalVowels;

    @Override
    public String toString() {
        return "WordStatistics{" +
                "wordCounts=" + wordCounts +
                ", totalVowels=" + totalVowels +
                '}';
    }
}
