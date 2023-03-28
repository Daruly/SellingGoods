import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlyWordValidator {
    private Pattern pattern;
    private Matcher matcher;
    private static final String ONLY_LETTERS_PATTERN = "[\u0401\u0451\u0410-\u044f]";

    public OnlyWordValidator() {
        pattern = Pattern.compile(ONLY_LETTERS_PATTERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }
}
