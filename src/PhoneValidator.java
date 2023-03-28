import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    private Pattern pattern;
    private Matcher matcher;
    private static final String DIGIT_PATTERN =
            "\\d+";

    public PhoneValidator() {
        pattern = Pattern.compile(DIGIT_PATTERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }
}
