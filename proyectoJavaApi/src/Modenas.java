import java.util.Map;

public class Modenas {
    String base_code;
    Map<String, Double> conversion_rates;

    public Modenas(String base_code, Map<String, Double> conversion_rates) {
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }
}
