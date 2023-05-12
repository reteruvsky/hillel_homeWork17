import java.io.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResultParser {
    private String pathString;
    private File file;
    private Path path;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH:mm:ss.SSS");

    public ResultParser(String pathString) {
        this.pathString = pathString;
    }

    public ResultParser(File file) {
        this.file = file;
    }

    public ResultParser(Path path) {
        this.path = path;
    }

    public Result parser() {
        if (file != null) {
            return result(file);
        } else if (path != null) {
            return result(path.toFile());
        } else if (pathString != null) {
            return result(new File(pathString));
        }
        throw new RuntimeException("File not found");
    }

    private Result result(File file) {
        Result testResult = new Result();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String str = reader.readLine();
                if (str.contains("found")) {
                    testResult.setAllTests(clean(str));
                } else if (str.contains("successful")) {
                    testResult.setSuccessfulTest(clean(str));
                } else if (str.contains("failed")) {
                    testResult.setFailedTests(clean(str));
                } else if (str.contains("Launch date: ")) {
                    testResult.setLocalDateTime(LocalDateTime.parse(str.split(" ")[2], FORMATTER));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return testResult;
    }

    private int clean(String s) {
        return Integer.parseInt(s.replaceAll("\\D+", ""));
    }
}
