package com.sicsolutions.intelliradio;

import androidx.appcompat.app.AppCompatActivity;
import com.sicsolutions.security.LoginAttempt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public ViewHolder mViewHolder = new ViewHolder();
    private LoginAttempt mLogginAttempt = new LoginAttempt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instances of the elements
        this.mViewHolder.username = findViewById(R.id.usernameEditText);
        this.mViewHolder.password = findViewById(R.id.passwordEditText);
        this.mViewHolder.loginButton = findViewById(R.id.loginButton);
        this.mViewHolder.loginProgress = findViewById(R.id.progressBar);
        this.mViewHolder.signUp = findViewById(R.id.singUpText);
        this.mViewHolder.hashUser = findViewById(R.id.hashUser);
        this.mViewHolder.hashPass = findViewById(R.id.hashPass);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.loginButton) //Login button was pressed
        {
            this.mViewHolder.loginProgress.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Attempting Login...", Toast.LENGTH_SHORT).show();

            //Hash and show in the TextView
            this.mViewHolder.hashUser.setText(mLogginAttempt.HashUser(this.mViewHolder.username.toString()));

            if(mLogginAttempt.LoginAttempt(this.mViewHolder.username.getText(),this.mViewHolder.password.getText()))
            {
                //Opens BluetoothScan screen after clicked the button and matched credentials
                this.mViewHolder.loginProgress.setVisibility(View.VISIBLE);
                OpenScan();
            }
            else
            {
                this.mViewHolder.loginProgress.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId()==R.id.singUpText)
        {
            this.mViewHolder.loginProgress.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Redirecting to sign up page...", Toast.LENGTH_SHORT).show();
        }
    }

    public void OpenScan(){
        Intent intent = new Intent(this, BluetoothScan.class);
        startActivity(intent);
    }

    private static class ViewHolder {

        EditText username;
        EditText password;
        Button loginButton;
        ProgressBar loginProgress;
        TextView signUp;
        TextView hashUser;
        TextView hashPass;
    }
}

