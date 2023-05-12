import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class TestLauncher {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH:mm:ss.SSS");
    public static void main(String[] args) throws FileNotFoundException {
        var launcher = LauncherFactory.create();

        var summaryGeneratingListener = new SummaryGeneratingListener();

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectPackage("test"))
                .build();
        launcher.execute(request, summaryGeneratingListener);

        try(var writer = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(writer);
        }

        long numTests = summaryGeneratingListener.getSummary().getTestsFoundCount();
        long executionTime = summaryGeneratingListener.getSummary().getTimeFinished() - summaryGeneratingListener.getSummary().getTimeStarted();

        try (PrintWriter writer = new PrintWriter(new File("input.txt"))) {
            summaryGeneratingListener.getSummary().printTo(writer);
            writer.println("Number of tests performed: " + numTests);
            writer.println("Execution time: " + executionTime);
        }
    }
}

