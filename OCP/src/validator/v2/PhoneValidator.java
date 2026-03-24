package validator.v2;

import java.util.regex.Pattern;

public class PhoneValidator implements IValidationStrategy {
    private static final String PHONE_REGEX = "^[0-9]{10}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    @Override
    public boolean validate(String value) {
        return PHONE_PATTERN.matcher(value).matches();
    }
}
