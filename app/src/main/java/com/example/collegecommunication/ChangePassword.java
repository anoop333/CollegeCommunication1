package com.example.collegecommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ChangePassword extends AppCompatActivity {
    EditText regno, pass, conpass;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        regno = findViewById(R.id.editText6);
        pass = findViewById(R.id.editText8);
        conpass = findViewById(R.id.editText10);
        submit = findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((regno.getText().toString().isEmpty()) || (pass.getText().toString().isEmpty()) || (conpass.getText().toString().isEmpty())) {
                    Toast.makeText(ChangePassword.this, "Field is Empty", Toast.LENGTH_LONG).show();
                }

                Intent in = new Intent(ChangePassword.this, Main3Activity.class);
                startActivity(in);
            }


        });
    }
}
