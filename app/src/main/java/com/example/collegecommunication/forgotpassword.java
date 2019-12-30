package com.example.collegecommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class forgotpassword extends AppCompatActivity {
    EditText regno;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);
        regno = findViewById(R.id.editText7);
        submit = findViewById(R.id.button3);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((regno.getText().toString().isEmpty())) {
                    Toast.makeText(forgotpassword.this, "Field is Empty", Toast.LENGTH_LONG).show();
                } else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anoopsuvarnan1.000webhostapp.com/forgotpass.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if (response.equals("correct1")) {

                                        Intent in = new Intent(forgotpassword.this, login.class);
                                        startActivity(in);
                                    } else {
                                        Toast.makeText(forgotpassword.this, response, Toast.LENGTH_SHORT).show();
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

                    RequestQueue requestQueue = Volley.newRequestQueue(forgotpassword.this);
                    requestQueue.add(stringRequest);
                }
            }
        });


    }

    }



