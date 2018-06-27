package mu.zz.axin.textvalidator;



public class TextValidator {
    private TextType textType;
    private PasswordStrength passwordStrength = PasswordStrength.WEAK;
    private String digitPolicy = "(?=.*[0-9])";
    private String lowercaseLettersPolicy = "(?=.*[a-z])";
    private String uppercaseLettersPolicy = "(?=.*[A-Z])";
    private String specialCharactersPolicy = "(?=.*[!@#$%^&*_+=])";
    private String noWhitespacePolicy = "(?=\\S+$)";
    private String longPasswordLengthPolicy = ".{8,25}";
    private String normalPasswordLengthPolicy = ".{5,25}";
    private String shortPasswordLengthPolicy = ".{2,25}";
    private String start = "(";
    private String end = ")";
    private String startOr = "[";
    private String endOr = "]";
//    Email validation string take from:  https://fightingforalostcause.net/content/misc/2006/compare-email-regex.php
    private final String EMAIL_VALIDATION_STRING = "(?!(?:(?:\\x22?\\x5C[\\x00-\\x7E]\\x22?)|(?:\\x22?[^\\x5C\\x22]\\x22?)){255,})(?!(?:(?:\\x22?\\x5C[\\x00-\\x7E]\\x22?)|(?:\\x22?[^\\x5C\\x22]\\x22?)){65,}@)(?:(?:[\\x21\\x23-\\x27\\x2A\\x2B\\x2D\\x2F-\\x39\\x3D\\x3F\\x5E-\\x7E]+)|(?:\\x22(?:[\\x01-\\x08\\x0B\\x0C\\x0E-\\x1F\\x21\\x23-\\x5B\\x5D-\\x7F]|(?:\\x5C[\\x00-\\x7F]))*\\x22))(?:\\.(?:(?:[\\x21\\x23-\\x27\\x2A\\x2B\\x2D\\x2F-\\x39\\x3D\\x3F\\x5E-\\x7E]+)|(?:\\x22(?:[\\x01-\\x08\\x0B\\x0C\\x0E-\\x1F\\x21\\x23-\\x5B\\x5D-\\x7F]|(?:\\x5C[\\x00-\\x7F]))*\\x22)))*@(?:(?:(?!.*[^.]{64,})(?:(?:(?:xn--)?[a-z0-9]+(?:-[a-z0-9]+)*\\.){1,126}){1,}(?:(?:[a-z][a-z0-9]*)|(?:(?:xn--)[a-z0-9]+))(?:-[a-z0-9]+)*)|(?:\\[(?:(?:IPv6:(?:(?:[a-f0-9]{1,4}(?::[a-f0-9]{1,4}){7})|(?:(?!(?:.*[a-f0-9][:\\]]){7,})(?:[a-f0-9]{1,4}(?::[a-f0-9]{1,4}){0,5})?::(?:[a-f0-9]{1,4}(?::[a-f0-9]{1,4}){0,5})?)))|(?:(?:IPv6:(?:(?:[a-f0-9]{1,4}(?::[a-f0-9]{1,4}){5}:)|(?:(?!(?:.*[a-f0-9]:){5,})(?:[a-f0-9]{1,4}(?::[a-f0-9]{1,4}){0,3})?::(?:[a-f0-9]{1,4}(?::[a-f0-9]{1,4}){0,3}:)?)))?(?:(?:25[0-5])|(?:2[0-4][0-9])|(?:1[0-9]{2})|(?:[1-9]?[0-9]))(?:\\.(?:(?:25[0-5])|(?:2[0-4][0-9])|(?:1[0-9]{2})|(?:[1-9]?[0-9]))){3}))]))";



    public enum TextType {
        PASSWORD,
        EMAIL
    }

    public enum PasswordStrength {
        WEAK,
        NORMAL,
        STRONG
    }

    public TextValidator setTextType(TextType textType) {
        this.textType = textType;
        return this;
    }


    public TextValidator setPasswordStrength(PasswordStrength passwordStrength) {
        this.passwordStrength = passwordStrength;
        return this;
//        (?=.*[0-9])       # a digit must occur at least once
//        (?=.*[a-z])       # a lower case letter must occur at least once
//        (?=.*[A-Z])       # an upper case letter must occur at least once
//        (?=.*[@#$%^&+=])  # a special character must occur at least once
//        (?=\S+$)          # no whitespace allowed in the entire string
//        .{6,20}             # anything, at least eight places though
//        (([(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=])])([(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=])])(?=\S+$).{5,25}) - normal password
    }

    private String passwordPolicyBuilder(PasswordStrength passwordStrength){
        StringBuilder passwordPolicy = new StringBuilder(start);
        switch (passwordStrength) {
            case WEAK:
                passwordPolicy.append(startOr)
                        .append(digitPolicy)
                        .append(lowercaseLettersPolicy)
                        .append(uppercaseLettersPolicy)
                        .append(specialCharactersPolicy)
                        .append(endOr)
                        .append(noWhitespacePolicy)
                        .append(shortPasswordLengthPolicy)
                        .append(end);
                return passwordPolicy.toString();
            case NORMAL:
                passwordPolicy.append(start)
                        .append(startOr)
                        .append(digitPolicy)
                        .append(lowercaseLettersPolicy)
                        .append(uppercaseLettersPolicy)
                        .append(specialCharactersPolicy)
                        .append(endOr)
                        .append(end)
                        .append(start)
                        .append(startOr)
                        .append(digitPolicy)
                        .append(lowercaseLettersPolicy)
                        .append(uppercaseLettersPolicy)
                        .append(specialCharactersPolicy)
                        .append(endOr)
                        .append(end)
                        .append(noWhitespacePolicy)
                        .append(normalPasswordLengthPolicy)
                        .append(end);
                return passwordPolicy.toString();
            case STRONG:
                passwordPolicy.append(digitPolicy)
                        .append(lowercaseLettersPolicy)
                        .append(uppercaseLettersPolicy)
                        .append(specialCharactersPolicy)
                        .append(noWhitespacePolicy)
                        .append(longPasswordLengthPolicy)
                        .append(end);
                return passwordPolicy.toString();
            default:
                return null;
        }
    }

    public boolean isTextValid(String text) {
        String pattern;
        switch (textType) {
            case PASSWORD:
                switch (passwordStrength){
                    case WEAK:
                        pattern = passwordPolicyBuilder(PasswordStrength.WEAK);
                        System.out.println(pattern);
                        assert pattern != null;
                        return text.matches(pattern);
                    case NORMAL:
                        pattern = passwordPolicyBuilder(PasswordStrength.NORMAL);
                        System.out.println(pattern);
                        assert pattern != null;
                        return text.matches(pattern);
                    case STRONG:
                        pattern = passwordPolicyBuilder(PasswordStrength.STRONG);
                        System.out.println(pattern);
                        assert pattern != null;
                        return text.matches(pattern);
                    default:
                        return false;
                }
            case EMAIL:
                return text.matches(EMAIL_VALIDATION_STRING);
            default:
                return false;
        }


    }

    
}
