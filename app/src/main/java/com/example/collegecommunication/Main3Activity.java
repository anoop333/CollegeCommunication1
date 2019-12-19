package com.example.collegecommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class Main3Activity extends AppCompatActivity {
EditText regno,password;
Button login;
TextView forgotpwd,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        reg=findViewById(R.id.textView7);
        forgotpwd=findViewById(R.id.textView5);
        reg=findViewById(R.id.textView7);
        regno =findViewById(R.id.editText5);
        password=findViewById(R.id.editText7);
        login=findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((regno.getText().toString().isEmpty()) || (password.getText().toString().isEmpty()))
                {
                    Toast.makeText(Main3Activity.this, "Field is Empty", Toast.LENGTH_LONG).show();
                }
                else
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anoopsuvarnan1.000webhostapp.com/anannya1.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                  //  Toast.makeText(Main3Activity.this, response, Toast.LENGTH_LONG).show();
                                    if (response.equals("valid"))
                                    {
                                       //
                                        // Toast.makeText(Main3Activity.this, "Id", Toast.LENGTH_LONG).show();
                                        Intent in= new Intent(Main3Activity.this,Main4Activity.class);
                                        startActivity(in);
                                    }
                                    else {
                                        Toast.makeText(Main3Activity.this, "Incorrect Register Number or Password", Toast.LENGTH_LONG).show();
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
Params.put("password",password.getText().toString());




                            return Params;
                        }
                    };


                    RequestQueue requestQueue = Volley.newRequestQueue(Main3Activity.this);
                    requestQueue.add(stringRequest);
                }
            }
        });
        forgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main3Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
