package mu.zz.axin.textvalidator;

public class TextValidator {
    TextType textType;
    PasswordStrength passwordStrength = PasswordStrength.WEAK;

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

    public boolean isTextValid(String text) {
        switch (textType) {
            case PASSWORD:
                switch (passwordStrength){
                    case WEAK:
                        return false;
                    case NORMAL:
                        return false;
                    case STRONG:
                        return false;
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
