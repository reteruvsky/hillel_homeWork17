import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SimpleMathLibraryTest {
    private static final double a = 2.5;
    private static final double b = 2.0;
    private SimpleMathLibrary simpleMathLibrary;

    @BeforeAll
    public void prepare() {
        simpleMathLibrary = new SimpleMathLibrary();
    }

    @Test
    public void addIfResultIsTrue() {
        assertThat(simpleMathLibrary.add(a, b)).isEqualTo(4.5);
    }

    @Test
    public void addIfResultIsFalse() {
        assertThat(simpleMathLibrary.add(a, b)).isEqualTo(4);
    }

    @Test
    public void minusIfResultIsTrue() {
        assertThat(simpleMathLibrary.minus(a, b)).isEqualTo(0.5);
    }

    @Test
    public void minusIfResultIsFalse() {
        assertThat(simpleMathLibrary.minus(a, b)).isEqualTo(1.5);
    }
}
