package com.example.drmpjct;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.format.Time;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drmpjct.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    static final int GALLERY_REQUEST = 1;
    static final int CAMERA_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Обьявление фрагментов, навигатора и их связь
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_plan, R.id.navigation_cam, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        navController.navigate(R.id.navigation_cam);



    }



    //Обработка программно созданных страниц
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageView = (ImageView) findViewById(R.id.imgview_photo);

        //Определение страницы
        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                   Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                    imageView.setImageBitmap(bitmap);
                }
                break;
            case CAMERA_REQUEST:
                if(resultCode == RESULT_OK) {
                    Bundle extras = imageReturnedIntent.getExtras();
                    bitmap = (Bitmap) extras.get("data");
                    imageView.setImageBitmap(bitmap);
                }break;
        }
    }

    //Оработчик кнопки галлерея
    public void btngalclc(View view){

        //Выставление условий использования
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        //Создание и активация стрницы Галлерея
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    //Оработчик кнопки Камера
    public void btncamclc(View view) throws IOException {

        //Выставление условий использования
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                ||
                (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        //Создание и активация стрницы камеры
        Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camIntent, CAMERA_REQUEST);
    }

    //Оработчик кнопки Анализ
    public void btnanalclc(View view) throws IOException {
/*
        URL url = new URL("https://api.logmeal.es/v2/image/segmentation/complete");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization","Bearer "+"2c1cec738ff7a71c05d7d5409f6cfcab7aa07808");
        conn.setRequestMethod("POST");
        JSONObject jsonObject;
        jsonObject.put("image",bitmap);



        conn.setR
       // img = <'replace-with-path-to-image'>
               // api_user_token = <'replace-with-your-api-user-token'>
             //  headers = {'Authorization': 'Bearer ' + api_user_token:


        //url = 'https://api.logmeal.es/v2/image/segmentation/complete'
        resp = requests.post(url,files={'image': open(img, 'rb')},headers=headers);


        url = 'https://api.logmeal.es/v2/recipe/nutritionalInfo'
        resp = requests.post(url,json={'imageId': resp.json()['imageId']}, headers=headers)
        print(resp.json())
*/
    }

}

