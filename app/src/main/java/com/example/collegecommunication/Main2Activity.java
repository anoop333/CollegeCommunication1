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

public class Main2Activity extends AppCompatActivity {
EditText regno,password,repassword,mobno,email;
Button register;
TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login=findViewById(R.id.textView3);
        regno=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        repassword=findViewById(R.id.editText3);
        register=findViewById(R.id.button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                                if ((regno.getText().toString().isEmpty()) || (password.getText().toString().isEmpty()) || (repassword.getText().toString().isEmpty()))
                {
                    Toast.makeText(Main2Activity.this, "Field is Empty", Toast.LENGTH_LONG).show();
                }

                 else {

                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anoopsuvarnan1.000webhostapp.com/anannya.php",
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    Toast.makeText(Main2Activity.this, response, Toast.LENGTH_LONG).show();
if (response.equals("success"))
{
    Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
    startActivity(intent);
}
else {
    Toast.makeText(Main2Activity.this, response, Toast.LENGTH_LONG).show();
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
                                            Params.put("password", password.getText().toString());




                                            return Params;
                                        }
                                    };


                        RequestQueue requestQueue = Volley.newRequestQueue(Main2Activity.this);
requestQueue.add(stringRequest);


                }
            }
        });




    login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
    }
    public void id()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anoopsuvarnan1.000webhostapp.com/anannya1.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Main2Activity.this, response, Toast.LENGTH_LONG).show();
                        if (response.equals("valid"))
                        {
                            Toast.makeText(Main2Activity.this, "Id", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(Main2Activity.this, "Incorrect Register Number", Toast.LENGTH_LONG).show();
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





                return Params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(Main2Activity.this);
        requestQueue.add(stringRequest);
    }
}
