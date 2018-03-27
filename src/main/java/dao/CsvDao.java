package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CsvDao {
    private static final String SEPARATOR = ";";

    public CsvDao(Reader source) {
        this.source = source;
    }

    public void setSource(Reader source) {
        this.source = source;
    }

    private Reader source;

    List<List<String>> readRecords() {
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
                    .map(line -> Arrays.asList(line.split(SEPARATOR)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
