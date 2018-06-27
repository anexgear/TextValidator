package mu.zz.axin.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import mu.zz.axin.textvalidator.TextValidator;

public class MainActivity extends AppCompatActivity {
    TextView weakPswd, normalPswd, strongPswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weakPswd = findViewById(R.id.weakPassword);
        normalPswd = findViewById(R.id.normalPassword);
        strongPswd = findViewById(R.id.strongPassword);

        TextValidator validator = new TextValidator().setTextType(TextValidator.TextType.PASSWORD)
                .setPasswordStrength(TextValidator.PasswordStrength.WEAK);
        weakPswd.setText(String.valueOf(validator.isTextValid("123")));
        normalPswd.setText(String.valueOf(validator.isTextValid("1234asdf")));
        strongPswd.setText(String.valueOf(validator.isTextValid("123!@#qweQWE")));

    }
}
