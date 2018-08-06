package mu.zz.axin.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import mu.zz.axin.textvalidator.Validator;
import mu.zz.axin.textvalidator.ValidatorFactory;

public class MainActivity extends AppCompatActivity {
    TextView weakPswd, normalPswd, strongPswd, wrongEmail, wrongEmail2, wrongEmail3, goodEmail, correctPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        Validator passwordValidator = new ValidatorFactory().normalPassword();
        Validator emailValidator = new ValidatorFactory().email();
        Validator phoneValidator = new ValidatorFactory().phone();


        weakPswd.setText("WEAK password: 123 - result " + String.valueOf(passwordValidator.validate("123")));
        normalPswd.setText("NORMAL password: 1234asdf - result " + String.valueOf(passwordValidator.validate("1234asdf")));
        strongPswd.setText("STRONG password: 123!@#qweQWE - result " + String.valueOf(passwordValidator.validate("123!@#qweQWE")));

        wrongEmail.setText("WRONG EMAIL: wrong Email - result " + String.valueOf(emailValidator.validate("wrong Email")));
        wrongEmail2.setText("WRONG EMAIL: wrong.email- result " + String.valueOf(emailValidator.validate("wrong.email")));
        wrongEmail3.setText("WRONG EMAIL: qwert@@asdf.zxc- result " + String.valueOf(emailValidator.validate("qwert@@asdf.zxc")));
        goodEmail.setText("CORRECT EMAIL: qwert@asdf.zxc- result " +String.valueOf(emailValidator.validate("qwert@asdf.zxc")));

        correctPhoneNumber.setText("CORRECT PHONE: +79654323425 - result " + String.valueOf(phoneValidator.validate("+79654323425")));

    }

    private void initViews() {
        weakPswd = findViewById(R.id.weakPassword);
        normalPswd = findViewById(R.id.normalPassword);
        strongPswd = findViewById(R.id.strongPassword);
        wrongEmail = findViewById(R.id.wrongEmail);
        wrongEmail2 = findViewById(R.id.wrongEmail2);
        wrongEmail3 = findViewById(R.id.wrongEmail3);
        goodEmail = findViewById(R.id.goodEmail);
        correctPhoneNumber = findViewById(R.id.correctPhoneNumber);

    }
}
