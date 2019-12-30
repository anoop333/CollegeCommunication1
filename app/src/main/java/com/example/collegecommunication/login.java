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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
EditText regno,password;
Button login;
TextView forgotpwd,reg;
CheckBox c;
    String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        reg=findViewById(R.id.textView7);
        forgotpwd=findViewById(R.id.textView5);
        reg=findViewById(R.id.textView7);
        regno =findViewById(R.id.editText5);
        password=findViewById(R.id.editText4);
        login=findViewById(R.id.button2);
        c=findViewById(R.id.checkBox2);

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean  isChecked) {
                if (isChecked)
                {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());


                    c.setText("Hide password");

                }
                else
                    {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    c.setText("Show Password");
                   }
            }


        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((regno.getText().toString().isEmpty()) || (password.getText().toString().isEmpty()))
                {
                    Toast.makeText(com.example.collegecommunication.login.this, "Field is Empty", Toast.LENGTH_LONG).show();
                }
                else
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://anoopsuvarnan1.000webhostapp.com/anannya1.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                  //  Toast.makeText(login.this,response,Toast.LENGTH_SHORT).show();
                                    try {
                                        JSONArray jsonArray = new JSONArray(response);
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject json_obj = jsonArray.getJSONObject(i);
                                             status=json_obj.getString("status");
//ba = json_obj.getString("balance");


                                        }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }



                                  //  Toast.makeText(login.this, response, Toast.LENGTH_LONG).show();
                                    if (status.equals("1"))
                                    {
                                       //
                                        // Toast.makeText(login.this, "Id", Toast.LENGTH_LONG).show();
                                        Intent in= new Intent(com.example.collegecommunication.login.this, tab.class);
                                        startActivity(in);
                                    }
                                    else if(status.equals("2")) {
                                        Toast.makeText(com.example.collegecommunication.login.this, "Admin", Toast.LENGTH_LONG).show();

                                        Intent in= new Intent(login.this, post_activity.class);
                                        startActivity(in);

                                    }
                                    else {
                                        Toast.makeText(com.example.collegecommunication.login.this, "Incorrect Register Number or Password", Toast.LENGTH_LONG).show();
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

                    RequestQueue requestQueue = Volley.newRequestQueue(com.example.collegecommunication.login.this);
                    requestQueue.add(stringRequest);
                }
            }
        });
        forgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.collegecommunication.login.this, forgotpassword.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com.example.collegecommunication.login.this, signup.class);
                startActivity(intent);
            }
        });
    }
}
