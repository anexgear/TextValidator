package mu.zz.axin.textvalidator;


class PasswordValidator {


    public static class Weak implements Validator{
        private final String WEAK_PASSWORD_PATTERN = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=])(?=\\S+$).{8,25})";

        @Override
        public boolean validate(String string) {
            return string.matches(WEAK_PASSWORD_PATTERN);
        }
    }

    public static class Normal implements Validator{
        private final String NORMAL_PASSWORD_PATTERN = "(([(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=])])([(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=])])(?=\\S+$).{5,25})";

        @Override
        public boolean validate(String string) {
            return string.matches(NORMAL_PASSWORD_PATTERN);
        }
    }

    public static class Strong implements Validator{
        private final String STRONG_PASSWORD_PATTERN = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_+=])(?=\\S+$).{8,25})";

        @Override
        public boolean validate(String string) {
            return string.matches(STRONG_PASSWORD_PATTERN);
        }
    }

}
