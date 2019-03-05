package com.ex.eynos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.ex.eynos.activity.Dashboard;
import com.ex.eynos.model.Datum;
import com.ex.eynos.model.Eynos;
import com.ex.eynos.network.ClientApi;
import com.ex.eynos.network.ClientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{

    AppCompatEditText mailid,password;
    AppCompatButton login;
    List<Datum> dlist;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();
        dlist = new ArrayList<>();
        loginPage();

    }
    public void initviews()
    {
        login = (AppCompatButton)findViewById(R.id.loginButton);
        mailid = (AppCompatEditText)findViewById(R.id.editLoginName);
        password = (AppCompatEditText)findViewById(R.id.editLoginPassword);

    }
    public void loginPage()
    {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                getLoginDetails();


            }
        });
    }

    public void getLoginDetails()
    {

        final Datum d = new Datum();
        String email = mailid.getText().toString().trim();
        String passw = password.getText().toString().trim();

        ClientService call = ClientApi.getData().create(ClientService.class);
        Call<Eynos> data = call.getData(email,passw);

        data.enqueue(new Callback<Eynos>() {
            @Override
            public void onResponse(Call<Eynos> call, Response<Eynos> response)
            {
                   // dlist = response.body().getData();

                    if(response.body().getStatus().equals("true"))
                    {
                           // String status = response.body().getStatus();
//                            if(status.equals("true"))
//                            {
                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                               Intent i = new Intent(MainActivity.this, Dashboard.class);
                               startActivity(i);
//                    String r = d.getEmailAddress();
                                //Intent i = new Intent(MainActivity.this, Dashboard.class);
                                //startActivity(i);
//                            }
//                            else
//                            {
//                                Toast.makeText(MainActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
//                            }
                    }

                else
                {
                    Toast.makeText(MainActivity.this, "Login Fail", Toast.LENGTH_LONG).show();
                }






//                if(response.body().getStatus().equals("true"))
//                {
//                    Intent i = new Intent(MainActivity.this,Dashboard.class);
//                    startActivity(i);
//                }

            }

            @Override
            public void onFailure(Call<Eynos> call, Throwable t)
            {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
