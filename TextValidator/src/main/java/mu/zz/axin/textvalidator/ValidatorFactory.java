package mu.zz.axin.textvalidator;

public class ValidatorFactory {
    public ValidatorFactory() {
    }

    public Validator weakPassword() {
        return new PasswordValidator.Weak();
    }

    public Validator normalPassword() {
        return new PasswordValidator.Normal();
    }

    public Validator strongPassword() {
        return new PasswordValidator.Strong();
    }

    public Validator email() {
        return new EmailValidator();
    }

    public Validator phone() {
        return new PhoneValidator();
    }

}
