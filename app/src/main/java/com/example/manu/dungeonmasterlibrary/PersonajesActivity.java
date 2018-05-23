package com.example.manu.dungeonmasterlibrary;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;


import com.example.manu.dungeonmasterlibrary.Adapters.AdapterPersonajes;
//import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CHARACTER.GetCharactersRetrofit;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CHARACTER.UploadCharacterRetrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonajesActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RecyclerView contenedor;
    MenuItem btnAddPersonajes;
    CardView cardViewChar;
    static ArrayList<Character> listaCharacters = new ArrayList<Character>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        contenedor = findViewById(R.id.contenedor);
        btnAddPersonajes = findViewById(R.id.btnAddPersonajes);
        cardViewChar = findViewById(R.id.cardViewChar);

        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.personajesItem:
                    cargarPersonajes();
                    break;
                case R.id.wikiItem:
                    Intent intent = new Intent(PersonajesActivity.this,WikiActivity.class);
                    WikiActivity.setActivity(PersonajesActivity.this);
                    startActivity(intent);
                    break;
                case R.id.tiendaItem:
                    Toast.makeText(PersonajesActivity.this, "En desarrollo", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.masterItem:
                    Toast.makeText(PersonajesActivity.this, "En desarrollo", Toast.LENGTH_SHORT).show();
                    break;
                default:
            }

            return true;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ac = getSupportActionBar();
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/TwoForJuanNF.ttf");

        TextView titulo = getActionBarTextView(toolbar);
        titulo.setTypeface(face);
        ac.setTitle("PERSONAJES");
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.personajesItem);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode==1){
            Bundle bundle = data.getExtras();
            Character personaje = bundle.getParcelable("PERSONAJE");
            Character uppersonaje = new Character();
            uppersonaje.setSkills(personaje.getSkills());
            uppersonaje.setName(personaje.getName());
            uppersonaje.setAbilities(personaje.getAbilities());
            uppersonaje.setLevel("1");
            uppersonaje.setClassesId(personaje.getaClass().getId());
            uppersonaje.setUsersId("1");
            uppersonaje.setRacesId(personaje.getRaza().getId());
            String baseurl = "http://thedmlibrary.ddns.net/api/index.php/";

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            UploadCharacterRetrofit Api = retrofit.create(UploadCharacterRetrofit.class);

            Call <Character> call = Api.loadChanges(uppersonaje);
            call.enqueue(new Callback<Character>() {
                @Override
                public void onResponse(Call<Character> call, Response<Character> response) {
                    String characters = response.body().toString();
                    Log.e("string", characters);
                }

                @Override
                public void onFailure(Call<Character> call, Throwable t) {
                    StringWriter errors = new StringWriter();
                    t.printStackTrace(new PrintWriter(errors));
                    Log.e("ERROR subir",errors.toString());
                    //Toast.makeText(PersonajesActivity.this, errors.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            listaCharacters.add(personaje);
            contenedor.setAdapter(new AdapterPersonajes(listaCharacters, PersonajesActivity.this));
            contenedor.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            contenedor.setLayoutManager(layoutManager);
        }
        bottomNavigationView.setSelectedItemId(R.id.personajesItem);

    }

    private TextView getActionBarTextView(Toolbar toolbar) {
        TextView titleTextView = null;

        try {
            Field f = toolbar.getClass().getDeclaredField("mTitleTextView");
            f.setAccessible(true);
            titleTextView = (TextView) f.get(toolbar);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
        return titleTextView;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.personajes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.btnAddPersonajes) {
            startActivityForResult(
                    new Intent(PersonajesActivity.this,
                            UnoCreacionPersonajesActivity.class),1);
        }

        return super.onOptionsItemSelected(item);
    }

    public void cargarPersonajes(){

        contenedor.setAdapter(new AdapterPersonajes(listaCharacters, PersonajesActivity.this));
        contenedor.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contenedor.setLayoutManager(layoutManager);

    }

    public static void setListaCharacter(ArrayList<Character> list){
        listaCharacters=list;
    }
}

