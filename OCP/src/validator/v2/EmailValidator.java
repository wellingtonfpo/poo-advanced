package validator.v2;

import java.util.regex.Pattern;

public class EmailValidator implements IValidationStrategy{
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Override
    public boolean validate(String value) {
        return EMAIL_PATTERN.matcher(value).matches();
    }
}
