package mu.zz.axin.textvalidator;


class PasswordValidator {

    //Test regex https://www.freeformatter.com/java-regex-tester.html


    static class Weak implements Validator{
        private final String WEAK_PASSWORD_PATTERN = "(.*).{2,}";

        @Override
        public boolean validate(String string) {
            return string.matches(WEAK_PASSWORD_PATTERN);
        }
    }

    static class Normal implements Validator{
        private final String NORMAL_PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d].{4,}";

        @Override
        public boolean validate(String string) {
            return string.matches(NORMAL_PASSWORD_PATTERN);
        }
    }

    static class Strong implements Validator{
        private final String STRONG_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$#!%*?&])[A-Za-z\\d$@#$!%*?&]{8,}";

        @Override
        public boolean validate(String string) {
            return string.matches(STRONG_PASSWORD_PATTERN);
        }
    }

}
