package technical.task.luxoft.constant;

import com.google.common.base.CharMatcher;
import lombok.SneakyThrows;
import technical.task.luxoft.model.WordStatistics;
import technical.task.luxoft.model.WordSummary;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class WordUtils {

    public static final String INPUT_FILE = "./src/main/resources/INPUT.txt";
    public static final String OUT_FILE = "./src/main/resources/OUTPUT.txt";
    public static final String SPLITTER = " ";
    public static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private static final CharMatcher REGEX =
            CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z'))
                    .or(CharMatcher.inRange(' ', ' ')).precomputed();
    private static final DecimalFormatSymbols DECIMAL_SYMBOLS = DecimalFormatSymbols.getInstance();

    public static List<Character> vowelsInWord(final String words) {
        List<Character> wordVowels = new ArrayList<>();
        for (char ch : words.toCharArray()) {
            if (VOWELS.contains(ch)) {
                wordVowels.add(ch);
            }
        }
        return wordVowels;
    }

    @SneakyThrows
    public static List<String> getListOfCleanWordsFromFile() {
        String file = Files.readString(Paths.get(INPUT_FILE));
        return Arrays.asList(REGEX.retainFrom(file.toLowerCase(Locale.ROOT)).split(SPLITTER));
    }

    @SneakyThrows
    public static void writeResult(final Map<WordSummary, WordStatistics> wordCountMap) {
        List<String> lines = wordCountMap.entrySet().stream().map(entry -> {
            WordSummary summary = entry.getKey();
            WordStatistics statistics = entry.getValue();
            double avg = (double) statistics.getTotalVowels() / (double) statistics.getWordCounts();
            return String.format(Locale.US, "({%s}, %d) -> %s",
                    summary.getVowels(),
                    summary.getLength(),
                    new DecimalFormat("#.##", DECIMAL_SYMBOLS).format(avg));

        }).collect(Collectors.toList());
        Files.write(FileSystems.getDefault().getPath(OUT_FILE), (Iterable<String>) lines::iterator);
    }
}
