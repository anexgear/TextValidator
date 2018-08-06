package mu.zz.axin.textvalidator;

public class PhoneValidator implements Validator{
    //    https://howtodoinjava.com/regex/java-regex-validate-international-phone-numbers/
    private final String PHONE_VALIDATION_STRING = "^\\+(?:[0-9] ?){6,14}[0-9]$";

    @Override
    public boolean validate(String string) {
        return string.matches(PHONE_VALIDATION_STRING);
    }
}
