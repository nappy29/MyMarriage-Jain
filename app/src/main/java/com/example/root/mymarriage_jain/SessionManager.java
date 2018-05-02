package com.example.root.mymarriage_jain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by root on 6/28/17.
 */


public class SessionManager {

    // Shared Preferences
    static SharedPreferences pref;

    // Editor for Shared preferences
    static SharedPreferences.Editor editor;

    // Context
    static Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "MY_PREF";

    private static final String Pref= "category";
    private static final String IS_PrefSet = "IsPrefSet";

    private static final String KEY_NOTIFICATIONS = "notifications";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "token_id";

    // public constructor. Should be used to make reference to this class
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

    }

    public void createLoginSession(String name){

        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // commit changes
        editor.commit();
    }

    @Nullable
    public String getUserToken(){

        // return user
        return pref.getString(KEY_NAME,null);
    }

    public void checkLogin(){
        // Check login status
        if(this.isLoggedIn()){
            // user is not logged in redirect him to Main Activity
            Intent i = new Intent(_context, MainActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public static void logout(){

        editor.clear();

        editor.commit();
        // user is not logged in redirect him to Login Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    public void setUser(int id,String username, String email, String phone, String api_token, String gender){
        editor.putInt("user_id",id);
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("api_token", api_token);
        editor.putString("gender", gender);

        editor.commit();
    }

    public static String getUsername(){
        return pref.getString("username", "Undefined");
    }

    public static String getemail(){
        return pref.getString("email", null);
    }

    public static String getPhone(){
        return pref.getString("phone", null);
    }

    public static String getApiToken(){
        return pref.getString("api_token", null);
    }

    public void setPrefCat(String pref){
        editor.putString("cat_pref", pref);
        editor.commit();
    }

    public void setPrefField(String pref){
        editor.putString("cat_pref", pref);
        editor.commit();
    }

    public void setLanguage(String en){
        editor.putString("language", en);
        editor.commit();
    }

    public static String getLanguage(){
        return pref.getString("language", "en");
    }

    @Nullable
    public String getEncodedImage(){
        return pref.getString("encodedImage",null);
    }

    //encoded image for user
    public static String encodeTobase64(Bitmap img){
        Bitmap image = img;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        return imageEncoded;
    }

    public static Bitmap getBitmapFromUrl(@NonNull String picurl) {

        try {
            URL url = new URL(picurl);
            return BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static Bitmap decodeBase64(@Nullable String encoded){
        if(encoded != null) {
            byte[] decodedByte = Base64.decode(encoded, 0);
            return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
        }
        return null;
    }

    public void setEncodedImage(String image){
        editor.putString("encodedImage",image);
        editor.commit();
    }

    public void addNotification(String notification) {

        // get old notifications
        String oldNotifications = getNotifications();

        if (oldNotifications != null) {
            oldNotifications += "|" + notification;
        } else {
            oldNotifications = notification;
        }

        editor.putString(KEY_NOTIFICATIONS, oldNotifications);
        editor.commit();
    }

    @Nullable
    public String getNotifications() {
        return pref.getString(KEY_NOTIFICATIONS, null);
    }

}
