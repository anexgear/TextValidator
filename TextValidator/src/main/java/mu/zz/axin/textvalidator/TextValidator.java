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
                return false;
            default:
                return false;
        }


    }

    
}
