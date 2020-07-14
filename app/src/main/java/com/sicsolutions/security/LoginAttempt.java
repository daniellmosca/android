package com.sicsolutions.security;

import android.text.Editable;
import android.util.Log;
import android.widget.Toast;

import com.sicsolutions.security.Encryption;

import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_SHORT;

public class LoginAttempt {

    public String username = "admin";
    public String password = "sicmundus";
    public boolean isValid;

    public boolean LoginAttempt (Editable username, Editable password) {

        if ((username.toString().equals(this.username)) && (password.toString().equals(this.password))) {
            isValid = true;
            Log.i("LoginAttempt", "Login OK");
        }

        else {
            isValid=false;
            Log.e("LoginAttempt", "Login FAILED");
        }

        return isValid;
    }

    public String HashUser (String username){

        //Here we do the hash to store the created username

        byte [] hashedUsername = new byte[0];

        try {
            hashedUsername = Encryption.encryptSHA(username.getBytes(), "SHA-1");
        }catch(Exception e){

        }

        return hashedUsername.toString();
    }
}
