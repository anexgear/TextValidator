package mu.zz.axin.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mu.zz.axin.textvalidator.TextValidator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextValidator validator = new TextValidator().setTextType(TextValidator.TextType.PASSWORD)
                .setPasswordStrength(TextValidator.PasswordStrength.STRONG);
        validator.isTextValid("E");
    }
}
