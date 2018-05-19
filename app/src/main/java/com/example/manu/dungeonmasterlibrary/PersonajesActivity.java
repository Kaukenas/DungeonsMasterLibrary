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

//import com.example.manu.dungeonmasterlibrary.Adapters.Adapter;
import com.example.manu.dungeonmasterlibrary.Adapters.AdapterPersonajes;
import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
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
    MenuItem btnAddPersonajes, btnRamon;
    MenuItem btnPersonaje;
    CardView cardViewChar;
    ArrayList<Personajes> listaPersonajes = new ArrayList<Personajes>();
    ArrayList<Character> listaCharacters = new ArrayList<Character>();
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        contenedor = findViewById(R.id.contenedor);
        btnAddPersonajes = findViewById(R.id.btnAddPersonajes);
        btnRamon = findViewById(R.id.btnRamon);
        cardViewChar = findViewById(R.id.cardViewChar);


        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.personajesItem:
                        //setContentView(R.layout.activity_personajes);
                        cargarPersonajes();
                        break;
                    case R.id.wikiItem:
                        setContentView(R.layout.webview_wiki);
                        //obteniendo el webview
                        mWebView = findViewById(R.id.mWebView);

                        String url = "https://www.d20pfsrd.com/";
                        if(savedInstanceState != null){
                            url = savedInstanceState.getString("URL");
                        }

                        WebSettings webSettings = mWebView.getSettings();
                        webSettings.setJavaScriptEnabled(true);
                        mWebView.setFocusable(true);
                        mWebView.setFocusableInTouchMode(true);
                        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
                        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
                        webSettings.setDatabaseEnabled(true);
                        webSettings.setAppCacheEnabled(true);
                        mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                            //webSettings.setBlockNetworkLoads(false);
                            webSettings.setDomStorageEnabled(true);
                        }
                        mWebView.setWebViewClient(new WebViewClient(){
                            @Override
                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                view.loadUrl(url);
                                return true;
                            }
                        });
                        //Cargar la URL
                        mWebView.loadUrl(url);

                }

                return true;
            }
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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("URL",mWebView.getUrl());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode==1){
            Bundle bundle = data.getExtras();
            Character personaje = bundle.getParcelable("PERSONAJE");
            /*String baseurl = "http://thedmlibrary.ddns.net/api/index.php/";

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            UploadCharacterRetrofit Api = retrofit.create(UploadCharacterRetrofit.class);

            Call <Character> call = Api.loadChanges(personaje);
            call.enqueue(new Callback<Character>() {
                @Override
                public void onResponse(Call<Character> call, Response<Character> response) {
                    String characters = response.body().toString();
                    Log.e("ERROR", characters);
                }

                @Override
                public void onFailure(Call<Character> call, Throwable t) {
                    StringWriter errors = new StringWriter();
                    t.printStackTrace(new PrintWriter(errors));
                    Log.e("ERROR",errors.toString());
                    Toast.makeText(PersonajesActivity.this, errors.toString(), Toast.LENGTH_SHORT).show();
                }
            });*/
            listaCharacters.add(personaje);
            contenedor.setAdapter(new AdapterPersonajes(listaCharacters, PersonajesActivity.this));
            contenedor.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            contenedor.setLayoutManager(layoutManager);

        }else{
            Toast.makeText(this, "wah wah wah", Toast.LENGTH_SHORT).show();
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

        if (mWebView.canGoBack()){
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }

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
        if(id == R.id.btnRamon){

        }

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    public void cargarPersonajes(){
        String baseurl = "http://thedmlibrary.ddns.net/api/index.php/";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GetCharactersRetrofit Api = retrofit.create(GetCharactersRetrofit.class);

        Call <List<Character>> call = Api.loadChanges();
        call.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
                List<Character> characters = response.body();
                for (int i = 0; i <characters.size() ; i++) {
                    listaCharacters.add(characters.get(i));
                }
                contenedor.setAdapter(new AdapterPersonajes(listaCharacters, PersonajesActivity.this));
                contenedor.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {
                StringWriter errors = new StringWriter();
                t.printStackTrace(new PrintWriter(errors));
                Log.e("ERROR",errors.toString());
                Toast.makeText(PersonajesActivity.this, errors.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contenedor.setLayoutManager(layoutManager);

    }
}
