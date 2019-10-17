import org.junit.Test;

import java.io.IOException;

public class MainTest {
    @Test
    public void shouldWork() throws IOException {
        Principal.main(new String[]{"src/test/resources/standard_file.txt"});
    }

    @Test
    public void shouldDetectEmptyFile() throws IOException {
        Principal.main(new String[]{"src/test/resources/empty_file.txt"});
    }

    @Test
    public void fileContainingOnlyOneLine() throws IOException {
        Principal.main(new String[]{"src/test/resources/file_line_1.txt"});
    }
}
