package com.markplace.markplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText usuario,password;
    private Button login;
    private TextView registrar,resetear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText)findViewById(R.id.main_txt_usuario);
        password = (EditText)findViewById(R.id.main_txt_password);
        login = (Button)findViewById(R.id.main_btn_login);
        registrar = (TextView)findViewById(R.id.main_lbl_register);
        resetear = (TextView)findViewById(R.id.main_lbl_reset);
    }

    @Override
    protected void onResume() {
        super.onResume();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUsuario=usuario.getText().toString().trim();
                String txtPassword=password.getText().toString().trim();
                if(txtUsuario.isEmpty() || txtPassword.isEmpty()){
                   if (txtUsuario.isEmpty()){
                       usuario.setError("El campo usuario es requerido");
                   }else{
                       password.setError("El campo password es requerido");
                   }
                }else{
                    Intent intent= new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
