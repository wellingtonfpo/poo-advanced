package validator.v1;

import java.util.regex.Pattern;

public class Validator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String PHONE_REGEX = "^[0-9]{10}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    public boolean validate(String field, String value) {
        if (field.equals("email")) {
            return EMAIL_PATTERN.matcher(value).matches();
        }  else if (field.equals("phone")) {
            return PHONE_PATTERN.matcher(value).matches();
        }
        return false;
    }
}
