package mu.zz.axin.textvalidator;

public class ValidatorFactory {

    public Validator weakPassword() {
        return new PasswordValidator();
    }

    public Validator normalPassword() {
        return new PasswordValidator();
    }

    public Validator strongPassword() {
        return new PasswordValidator();
    }

    public Validator email() {
        return new EmailValidator();
    }

    public Validator phone() {
        return new PhoneValidator();
    }
}
