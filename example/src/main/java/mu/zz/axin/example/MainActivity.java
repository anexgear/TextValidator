package mu.zz.axin.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import mu.zz.axin.textvalidator.PasswordStrength;
import mu.zz.axin.textvalidator.TextType;
import mu.zz.axin.textvalidator.TextValidator;

public class MainActivity extends AppCompatActivity {
    TextView weakPswd, normalPswd, strongPswd, wrongEmail, wrongEmail2, wrongEmail3, goodEmail, correctPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        TextValidator passwordValidator = new TextValidator().setTextType(TextType.PASSWORD)
                .setPasswordStrength(PasswordStrength.STRONG);
        TextValidator emailValidator = new TextValidator().setTextType(TextType.EMAIL);
        TextValidator phoneValidator = new TextValidator().setTextType(TextType.PHONE);


        weakPswd.setText("WEAK password: 123 - result " + String.valueOf(passwordValidator.isTextValid("123")));
        normalPswd.setText("NORMAL password: 1234asdf - result " + String.valueOf(passwordValidator.isTextValid("1234asdf")));
        strongPswd.setText("STRONG password: 123!@#qweQWE - result " + String.valueOf(passwordValidator.isTextValid("123!@#qweQWE")));

        wrongEmail.setText("WRONG EMAIL: wrong Email - result " + String.valueOf(emailValidator.isTextValid("wrong Email")));
        wrongEmail2.setText("WRONG EMAIL: wrong.email- result " + String.valueOf(emailValidator.isTextValid("wrong.email")));
        wrongEmail3.setText("WRONG EMAIL: qwert@@asdf.zxc- result " + String.valueOf(emailValidator.isTextValid("qwert@@asdf.zxc")));
        goodEmail.setText("CORRECT EMAIL: qwert@asdf.zxc- result " +String.valueOf(emailValidator.isTextValid("qwert@asdf.zxc")));

        correctPhoneNumber.setText("CORRECT PHONE: +79654323425 - result " + String.valueOf(phoneValidator.isTextValid("+79654323425")));

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
