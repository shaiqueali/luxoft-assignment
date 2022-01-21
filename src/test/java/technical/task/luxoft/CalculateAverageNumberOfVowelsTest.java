package technical.task.luxoft;

import org.junit.Before;
import org.junit.Test;
import technical.task.luxoft.model.WordStatistics;
import technical.task.luxoft.model.WordSummary;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculateAverageNumberOfVowelsTest {

    CalculateAverageNumberOfVowels obj;

    @Before
    public void before() {
        obj = new CalculateAverageNumberOfVowels();
    }

    @Test
    public void testCalculate() {
        final Map<WordSummary, WordStatistics> wordCountMap = obj.averageNumberOfVowelsInWords(Arrays.asList("Platon", "made", "bamboo", "boats"));
        WordSummary result1 = new WordSummary();
        result1.setVowels("[a, o]");
        result1.setLength(6);

        WordSummary result2 = new WordSummary();
        result2.setVowels("[a, e]");
        result2.setLength(4);
        double avg = (double) wordCountMap.get(result1).getTotalVowels() / (double) wordCountMap.get(result1).getWordCounts();
        String decimal = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance()).format(avg);
        assertTrue(wordCountMap.containsKey(result1));
        assertTrue(wordCountMap.containsKey(result2));
        assertEquals("2.5", decimal);
    }

    @Test
    public void testCalculateWhenDuplicateWords() throws IOException {
        final Map<WordSummary, WordStatistics> wordCountMap = obj.averageNumberOfVowelsInWords(Arrays.asList("Platon", "made", "bamboo", "boats", "Platon"));
        WordSummary result1 = new WordSummary();
        result1.setVowels("[a, o]");
        result1.setLength(6);

        WordSummary result2 = new WordSummary();
        result2.setVowels("[a, e]");
        result2.setLength(4);
        double avg = (double) wordCountMap.get(result1).getTotalVowels() / (double) wordCountMap.get(result1).getWordCounts();
        String decimal = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance()).format(avg);
        assertTrue(wordCountMap.containsKey(result1));
        assertTrue(wordCountMap.containsKey(result2));
        assertEquals("2.33", decimal);
    }
}
