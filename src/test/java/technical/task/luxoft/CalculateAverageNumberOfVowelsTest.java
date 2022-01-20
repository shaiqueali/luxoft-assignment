package technical.task.luxoft;

import org.junit.Before;
import org.junit.Test;
import technical.task.luxoft.model.WordStatistics;
import technical.task.luxoft.model.WordSummary;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CalculateAverageNumberOfVowelsTest {

    CalculateAverageNumberOfVowels obj;

    @Before
    public void before() {
        obj = new CalculateAverageNumberOfVowels();
    }

    @Test
    public void testCalculate() {
        final Map<WordSummary, WordStatistics> wordCountMap = obj.averageNumberOfVowelsInWords(Arrays.asList("Platon", "made", "bamboo", "boats."));
        WordSummary result1 = new WordSummary();
        result1.setVowels("[a, o]");
        result1.setLength(6);

        WordSummary result2 = new WordSummary();
        result2.setVowels("[a, e]");
        result2.setLength(4);
        assertEquals(true, wordCountMap.containsKey(result1));
        assertEquals(true, wordCountMap.containsKey(result2));
    }
}
