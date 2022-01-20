package technical.task.luxoft;

import technical.task.luxoft.constant.WordUtils;
import technical.task.luxoft.model.WordStatistics;
import technical.task.luxoft.model.WordSummary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 1 - Get list of clean words
 * 2 - Calculate and note vowels in word
 * 3 - Calculate word length
 * 4 - Group by same vowels and length word
 */
public class CalculateAverageNumberOfVowels {

    private final Map<WordSummary, WordStatistics> wordCountMap = new HashMap<>();

    public Map<WordSummary, WordStatistics> averageNumberOfVowelsInWords(final List<String> words) {
        words.forEach(word -> {
            List<Character> vowels = WordUtils.vowelsInWord(word);
            buildWordMap(word.length(), vowels.size(), new HashSet<>(vowels).toString());
        });
        return wordCountMap;
    }

    private void buildWordMap(int length, int count, String wordVowels) {
        WordSummary result = new WordSummary();
        result.setVowels(wordVowels);
        result.setLength(length);
        WordStatistics wordStatistics;
        if (wordCountMap.containsKey(result)) {
            wordStatistics = wordCountMap.get(result);
            wordStatistics.setWordCounts(wordStatistics.getWordCounts() + 1);
            wordStatistics.setTotalVowels(wordStatistics.getTotalVowels() + count);
        } else {
            wordStatistics = new WordStatistics();
            wordStatistics.setWordCounts(1);
            wordStatistics.setTotalVowels(count);
        }
        wordCountMap.put(result, wordStatistics);
    }
}
