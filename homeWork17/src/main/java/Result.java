import java.time.LocalDateTime;

public class Result {
    private int allTests;
    private int successfulTest;
    private int failedTests;
    private LocalDateTime localDateTime;

    public int getAllTests() {
        return allTests;
    }

    public void setAllTests(int allTests) {
        this.allTests = allTests;
    }

    public int getSuccessfulTest() {
        return successfulTest;
    }

    public void setSuccessfulTest(int successfulTest) {
        this.successfulTest = successfulTest;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public void setFailedTests(int failedTests) {
        this.failedTests = failedTests;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Result{" +
                "allTests=" + allTests +
                ", successfulTest=" + successfulTest +
                ", failedTests=" + failedTests +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
