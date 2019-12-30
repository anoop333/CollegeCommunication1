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
    CheckBox ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        regno = findViewById(R.id.editText6);
        pass = findViewById(R.id.editText8);
        conpass = findViewById(R.id.editText10);
        submit = findViewById(R.id.button4);
        ch = findViewById(R.id.checkBox3);
        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    conpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ch.setText("Hide password");
                } else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    conpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    ch.setText("Show Password");
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((regno.getText().toString().isEmpty()) || (pass.getText().toString().isEmpty()) || (conpass.getText().toString().isEmpty())) {
                    Toast.makeText(ChangePassword.this, "Field is Empty", Toast.LENGTH_LONG).show();
                } else if (!(pass.getText().toString().equals(conpass.getText().toString()))) {
                    Toast.makeText(ChangePassword.this, "Password Mismatch", Toast.LENGTH_LONG).show();
                } else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anoopsuvarnan1.000webhostapp.com/anannya.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if (response.equals("success")) {

                                        Intent in = new Intent(ChangePassword.this, login.class);
                                        startActivity(in);
                                    } else {
                                        Toast.makeText(ChangePassword.this, "Incorrect Register Number", Toast.LENGTH_LONG).show();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() throws
                                AuthFailureError {
                            Map<String, String> Params = new HashMap<>();
                            Params.put("regno", regno.getText().toString());
                            Params.put("password", pass.getText().toString());


                            return Params;
                        }
                    };


                    RequestQueue requestQueue = Volley.newRequestQueue(ChangePassword.this);
                    requestQueue.add(stringRequest);


                }
            }


        });
    }
}

