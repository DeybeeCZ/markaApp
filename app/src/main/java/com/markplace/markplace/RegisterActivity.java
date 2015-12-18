package com.markplace.markplace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.markplace.application.Configuration;
import com.parse.Parse;
import com.parse.ParseObject;

import bolts.Task;

/**
 * Created by deybee on 28/11/15.
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText txtUsuario,txtEmail,txtPassword,txtConfPassword;
    private Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsuario = (EditText)findViewById(R.id.register_txt_usuario);
        txtEmail = (EditText)findViewById(R.id.register_txt_email);
        txtPassword = (EditText)findViewById(R.id.register_txt_password);
        txtConfPassword = (EditText)findViewById(R.id.register_txt_confirm_password);
        btnRegistrar = (Button)findViewById(R.id.register_btn_registrar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(txtUsuario)){
                    error(txtUsuario);
                }
                if (isEmpty(txtEmail)){
                    error(txtEmail);
                }
                if (isEmpty(txtPassword) && isEmpty(txtConfPassword)){
                    if (isEmpty(txtPassword)){
                        error(txtPassword);
                    }
                    if (isEmpty(txtConfPassword)){
                        error(txtConfPassword);
                    }
                }else{
                    if (!confirmPassword(txtPassword,txtConfPassword)){
                        txtPassword.setError(getResources().getString(R.string.passFail));
                    }else{
                        //guardado de usuario
                        if (Configuration.user.registerUser(txtUsuario.getText().toString().trim(),
                                txtEmail.getText().toString().trim(),
                                txtPassword.getText().toString().trim())){
                            Toast.makeText(getApplicationContext(),"Se guardo el usuario",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Ocurrio un error al guardar",Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            }
        });
    }

    private boolean isEmpty(EditText editText){
        String valor=editText.getText().toString().trim();
        if (valor.length()>0){
            return false;
        }
        return true;
    }

    private void error(EditText editText){
            editText.setError(getResources().getString(R.string.required));
    }

    private boolean confirmPassword(EditText txtPassword,EditText txtConfirm){
        String password=txtPassword.getText().toString().trim();
        String confirm=txtConfirm.getText().toString().trim();
        if(!password.equals(confirm)){
            return false;
        }
        return true;
    }
}
