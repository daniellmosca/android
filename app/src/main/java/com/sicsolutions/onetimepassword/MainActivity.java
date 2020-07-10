package com.sicsolutions.onetimepassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Created instances for both edit and button elements
        this.mViewHolder.otpValue = findViewById(R.id.otpEdit);
        this.mViewHolder.generateButton = findViewById(R.id.generateButton);
        this.mViewHolder.generateButton.setOnClickListener(this);

        //ViewHolder - used to create static instances of elements within an activity
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.generateButton){
            this.mViewHolder.otpValue.setText(randomizeSequence());
            Toast.makeText(this, "OTP Generated Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    private String randomizeSequence(){
        int otp;

        otp = new Random().nextInt();

        return String.valueOf(otp);
    }



    private static class ViewHolder{
        EditText otpValue;
        Button generateButton;
    }
}