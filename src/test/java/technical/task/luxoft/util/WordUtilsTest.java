package technical.task.luxoft.util;

import org.junit.Test;
import technical.task.luxoft.model.WordStatistics;
import technical.task.luxoft.model.WordSummary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static technical.task.luxoft.constant.WordUtils.OUT_FILE;
import static technical.task.luxoft.constant.WordUtils.getListOfCleanWordsFromFile;
import static technical.task.luxoft.constant.WordUtils.vowelsInWord;
import static technical.task.luxoft.constant.WordUtils.writeResult;

public class WordUtilsTest {

    @Test
    public void testVowelsInWord() {
        List<Character> vowels = vowelsInWord("Shaique");
        assertEquals(vowels.size(), 4);
        assertEquals(Arrays.asList('a', 'i', 'u', 'e'), vowels);
    }

    @Test
    public void testGetListOfCleanWordsFromFile() {
        List<String> words = getListOfCleanWordsFromFile();
        assertEquals(4, words.size());
        assertEquals("platon", words.get(0));
    }

    @Test
    public void testWriteResult() throws IOException {
        final Map<WordSummary, WordStatistics> wordCountMap = new HashMap<>();
        WordSummary summary1 = new WordSummary("a, o", 6);
        WordStatistics statistics1 = new WordStatistics(2, 5);
        wordCountMap.put(summary1, statistics1);

        WordSummary summary2 = new WordSummary("a, o", 5);
        WordStatistics statistics2 = new WordStatistics(1, 2);
        wordCountMap.put(summary2, statistics2);

        WordSummary summary3 = new WordSummary("a, e", 4);
        WordStatistics statistics3 = new WordStatistics(1, 2);
        wordCountMap.put(summary3, statistics3);
        writeResult(wordCountMap);

        Stream<String> rows = Files.lines(Paths.get(OUT_FILE));
        int rowCount = (int) rows
                .map(x -> x.split("->"))
                .filter(x -> x.length == 2)
                .count();
        assertEquals(3, rowCount);
    }

}
