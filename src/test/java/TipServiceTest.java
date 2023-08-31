import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TipServiceTest {
    private final TipService tipService = new TipService();

    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    public void shouldReturnTenPercent(BigDecimal parameter) {
        BigDecimal result = tipService.roundTips(parameter);

        assertEquals(parameter.multiply(BigDecimal.valueOf(1.1)), result);
    }

    static Stream<BigDecimal> argsProviderFactory() {
        return Stream.of(
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(500),
                BigDecimal.valueOf(999));
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    public void shouldReturnFivePercent(BigDecimal parameter) {
        BigDecimal result = tipService.roundTips(parameter);

        assertEquals(parameter.multiply(BigDecimal.valueOf(1.05)), result);
    }
    static Stream<BigDecimal> argsProvider() {
        return Stream.of(
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1500));
    }
}
