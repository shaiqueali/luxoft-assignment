package technical.task.luxoft;

import technical.task.luxoft.model.WordStatistics;
import technical.task.luxoft.model.WordSummary;

import java.util.Map;

import static technical.task.luxoft.constant.WordUtils.getListOfCleanWordsFromFile;
import static technical.task.luxoft.constant.WordUtils.writeResult;

public class Main {

    public static void main(String[] args) {
        CalculateAverageNumberOfVowels obj = new CalculateAverageNumberOfVowels();
        final Map<WordSummary, WordStatistics> wordCountMap = obj.averageNumberOfVowelsInWords(getListOfCleanWordsFromFile());
        writeResult(wordCountMap);
    }
}
