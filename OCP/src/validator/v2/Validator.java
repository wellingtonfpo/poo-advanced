package validator.v2;

import java.util.HashMap;
import java.util.Map;

public class Validator {
    private static final Map<String, IValidationStrategy> strategies = new HashMap<>();

    public void addStrategy(String field, IValidationStrategy strategy) {
        strategies.put(field, strategy);
    }

    public boolean validate(String field, String value) {
        IValidationStrategy strategy = strategies.get(field);

        if (strategy == null) {
            throw new  IllegalArgumentException("Strategy not found for field: " + field);
        }

        return strategy.validate(value);
    }
}
