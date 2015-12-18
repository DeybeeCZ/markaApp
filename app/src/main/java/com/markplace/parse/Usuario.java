package com.markplace.parse;

import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Deybee on 15/12/2015.
 */
public class Usuario {

    public boolean registerUser(String nombre,String email,String password){

        try {
            ParseObject usuario = new ParseObject("Usuario");
            usuario.put("objectId",email);
            usuario.put("nombre",nombre);
            usuario.put("email", email);
            usuario.put("password",password);
            usuario.saveInBackground();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void getUserbyEmail(String email){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
        query.whereEqualTo("email",email);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }


}
