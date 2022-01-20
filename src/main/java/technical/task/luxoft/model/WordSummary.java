package technical.task.luxoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordSummary {
    private String vowels;
    private int length;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordSummary that = (WordSummary) o;
        return Objects.equals(length, that.length) &&
                Objects.equals(vowels, that.vowels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vowels, length);
    }


    @Override
    public String toString() {
        return "WordSummary{" +
                "vowels='" + vowels + '\'' +
                ", length=" + length +
                '}';
    }
}
