package doapps.testingcollaboration;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 15/07/2016.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btLogin;

    private Pattern regexPattern;
    private Matcher regMatcher;

    private String sEmail;
    private String sPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_pass);
        btLogin  = (Button) findViewById(R.id.bt_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sEmail = etEmail.getText().toString();
                sPass = etPassword.getText().toString();
                if(validarEmail(sEmail) && sPass.length()>=6){
                    if(etPassword.equals("bsoto4@gmail.com")&&etPassword.equals("123456")){

                    }else{
                        Toast.makeText(getBaseContext(), "Verificar email y/o constraseña", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getBaseContext(), "Verificar datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validarEmail(String emailAddress) {

        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher   = regexPattern.matcher(emailAddress);
        if(regMatcher.matches()){
            return true;
        } else {
            return false;
        }
    }

}

