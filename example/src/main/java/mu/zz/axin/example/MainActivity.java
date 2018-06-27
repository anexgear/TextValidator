package mu.zz.axin.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import mu.zz.axin.textvalidator.TextValidator;

public class MainActivity extends AppCompatActivity {
    TextView weakPswd, normalPswd, strongPswd, wrongEmail, wrongEmail2, wrongEmail3, goodEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        TextValidator passwordValidator = new TextValidator().setTextType(TextValidator.TextType.PASSWORD)
                .setPasswordStrength(TextValidator.PasswordStrength.WEAK);
        TextValidator emailValidator = new TextValidator().setTextType(TextValidator.TextType.EMAIL);

        weakPswd.setText(String.valueOf(passwordValidator.isTextValid("123")));
        normalPswd.setText(String.valueOf(passwordValidator.isTextValid("1234asdf")));
        strongPswd.setText(String.valueOf(passwordValidator.isTextValid("123!@#qweQWE")));

        wrongEmail.setText(String.valueOf(emailValidator.isTextValid("wrong Email")));
        wrongEmail2.setText(String.valueOf(emailValidator.isTextValid("wrong.email")));
        wrongEmail3.setText(String.valueOf(emailValidator.isTextValid("qwert@@asdf.zxc")));
        goodEmail.setText(String.valueOf(emailValidator.isTextValid("qwert@asdf.zxc")));



    }

    private void initViews() {
        weakPswd = findViewById(R.id.weakPassword);
        normalPswd = findViewById(R.id.normalPassword);
        strongPswd = findViewById(R.id.strongPassword);
        wrongEmail = findViewById(R.id.wrongEmail);
        wrongEmail2 = findViewById(R.id.wrongEmail2);
        wrongEmail3 = findViewById(R.id.wrongEmail3);
        goodEmail = findViewById(R.id.goodEmail);

    }
}
