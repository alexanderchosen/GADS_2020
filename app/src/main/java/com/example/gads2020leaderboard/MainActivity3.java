package com.example.gads2020leaderboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.gads2020leaderboard.services.ApiPost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity3 extends AppCompatActivity {
    private Button back_arrow;

    Toolbar toolbar;
        private ApiPost mApiPost;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);

            final EditText firstName= findViewById(R.id.first_name);
            final EditText lastName=findViewById(R.id.last_name);
            final EditText emailAddress=findViewById(R.id.email_address);
            final EditText gitHubLink=findViewById(R.id.project_link);

            final TextView Send=findViewById(R.id.button);

            mApiPost=ApiUtil.getApiPost();
            Send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String firstName2= firstName.getText().toString().trim();
                    String lastName2= lastName.getText().toString().trim();
                    String emailAddress2= emailAddress.getText().toString().trim();
                    String githubLink2= gitHubLink.getText().toString().trim();

                    if (!TextUtils.isEmpty(firstName2) && !TextUtils.isEmpty(lastName2) && !TextUtils.isEmpty(emailAddress2) &&!TextUtils.isEmpty(githubLink2)){
                        showDialog();

                    }
                    else{
                        Toast.makeText(MainActivity3.this, "fields cannot be empty",Toast.LENGTH_LONG).show();
                    }

                }
            });

        }

        private void showDialog() {
            final Dialog dialog=new Dialog(MainActivity3.this);

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog);
            final TextView Yes=dialog.findViewById(R.id.Yes);
            final  TextView cancel =dialog.findViewById(R.id.cancel);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            Yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final EditText firstName= findViewById(R.id.first_name);
                    final EditText lastName=findViewById(R.id.last_name);
                    final EditText emailAddress=findViewById(R.id.email_address);
                    final EditText gitHubLink=findViewById(R.id.project_link);
                    String firstName2= firstName.getText().toString().trim();
                    String lastName2= lastName.getText().toString().trim();
                    String emailAddress2= emailAddress.getText().toString().trim();
                    String githubLink2= gitHubLink.getText().toString().trim();
                    mApiPost=ApiUtil.getApiPost();
                    Call<Void> call=mApiPost.savePost(firstName2,lastName2,emailAddress2,githubLink2);
                    call.enqueue(new Callback<Void>() {
                        @Override

                        public void onResponse(Call<Void> call, Response<Void> response) {
                            int statuscode=response.code();
                            if(response.isSuccessful()) {

                                dialog.dismiss();
                                Dialog dialog1=new Dialog(MainActivity3.this);

                                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                dialog1.setContentView(R.layout.successful);

                                dialog1.show();
                                Window window=dialog1.getWindow();
                                assert window != null;
                                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
                            }
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            dialog.dismiss();
                            Dialog dialog2=new Dialog(MainActivity3.this);

                            dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);

                            dialog2.setContentView(R.layout.notsuccessful);

                            dialog2.show();
                            Window window=dialog2.getWindow();
                            assert window != null;
                            window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
                        }
                    });
                    back_arrow=findViewById(R.id.button2);
                    back_arrow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(MainActivity3.this, MainActivity2.class);
                            startActivity(intent);
                        }
                    });



                }
            });
            dialog.show();
            Window window=dialog.getWindow();
            assert window != null;
            window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        }
    }
