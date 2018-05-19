package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;

import java.io.ByteArrayOutputStream;

public class TresCreacionPersonajesActivity extends AppCompatActivity {

    Button btnBackTres, btnFinish;
    ImageView imageViewMonje, imageViewPicaro, imageViewBarbaro, imageViewGuerrero;
    Character personajes;
    Bitmap bitmapend= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_creacion_personajes);
        btnFinish = findViewById(R.id.btnFinishCharacter);
        imageViewMonje = findViewById(R.id.imageViewMonje);
        imageViewGuerrero = findViewById(R.id.imageViewGuerrero);
        imageViewBarbaro = findViewById(R.id.imageViewBarbaro);
        imageViewPicaro = findViewById(R.id.imageViewPicaro);

        personajes = getIntent().getExtras().getParcelable("PERSONAJE");


        /*//////////////////////////REESCALADO DE IMAGEN ////////////////////////////////////////*/
        Bitmap bitmap = ((BitmapDrawable)imageViewGuerrero.getDrawable()).getBitmap();
        Bitmap resized = Bitmap.createScaledBitmap(bitmap, 200, 200, true);
        imageViewGuerrero.setImageBitmap(resized);

        bitmap = ((BitmapDrawable)imageViewMonje.getDrawable()).getBitmap();
        resized = Bitmap.createScaledBitmap(bitmap, 200, 200, true);
        imageViewMonje.setImageBitmap(resized);

        bitmap = ((BitmapDrawable)imageViewPicaro.getDrawable()).getBitmap();
        resized = Bitmap.createScaledBitmap(bitmap, 200, 200, true);
        imageViewPicaro.setImageBitmap(resized);

        bitmap = ((BitmapDrawable)imageViewBarbaro.getDrawable()).getBitmap();
        resized = Bitmap.createScaledBitmap(bitmap, 200, 200, true);
        imageViewBarbaro.setImageBitmap(resized);
        /*//////////////////////////FIN REESCALADO DE IMAGEN /////////////////////////////////////*/

        btnBackTres = findViewById(R.id.btnBackTres);
        addListenerImageView();

        btnBackTres.setOnClickListener(view -> finish());


        btnFinish.setOnClickListener(view -> {
            if(bitmapend!=null){
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmapend.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] imageBytes = stream.toByteArray();
                String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
                personajes.setPhoto(encodedImage);
                Intent returnIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable("PERSONAJE",personajes);
                returnIntent.putExtras(bundle);
                setResult(RESULT_OK,returnIntent);
                finish();
            }else{
                Toast.makeText(TresCreacionPersonajesActivity.this, "Manu no tiene puta idea", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void addListenerImageView() {


        imageViewMonje.setOnClickListener(view -> {
            Drawable highlight = getResources().getDrawable( R.drawable.border_item);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(highlight);
                imageViewGuerrero.setBackground(Drawable.createFromPath(""));
                imageViewBarbaro.setBackground(Drawable.createFromPath(""));
                imageViewPicaro.setBackground(Drawable.createFromPath(""));
                bitmapend = ((BitmapDrawable)imageViewMonje.getDrawable()).getBitmap();
            }



        });

        imageViewGuerrero.setOnClickListener(view -> {
            Drawable highlight = getResources().getDrawable( R.drawable.border_item);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(highlight);
                imageViewMonje.setBackground(Drawable.createFromPath(""));
                imageViewBarbaro.setBackground(Drawable.createFromPath(""));
                imageViewPicaro.setBackground(Drawable.createFromPath(""));
                bitmapend = ((BitmapDrawable)imageViewGuerrero.getDrawable()).getBitmap();
            }
        });

        imageViewBarbaro.setOnClickListener(view -> {
            Drawable highlight = getResources().getDrawable( R.drawable.border_item);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(highlight);
                imageViewMonje.setBackground(Drawable.createFromPath(""));
                imageViewGuerrero.setBackground(Drawable.createFromPath(""));
                imageViewPicaro.setBackground(Drawable.createFromPath(""));
                bitmapend = ((BitmapDrawable)imageViewBarbaro.getDrawable()).getBitmap();
            }

        });

        imageViewPicaro.setOnClickListener(view -> {
            Drawable highlight = getResources().getDrawable( R.drawable.border_item);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(highlight);
                imageViewMonje.setBackground(Drawable.createFromPath(""));
                imageViewGuerrero.setBackground(Drawable.createFromPath(""));
                imageViewBarbaro.setBackground(Drawable.createFromPath(""));
                bitmapend = ((BitmapDrawable)imageViewPicaro.getDrawable()).getBitmap();
            }

        });
    }
}
