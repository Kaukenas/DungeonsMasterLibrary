package com.example.manu.dungeonmasterlibrary;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.dungeonmasterlibrary.Adapters.Adapter;
import com.example.manu.dungeonmasterlibrary.POJOS.Personajes;
import com.example.manu.dungeonmasterlibrary.POJOS.Pruebafotos;
import com.example.manu.dungeonmasterlibrary.POJOS2.Character;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.CHARACTER.GetCharacterRetrofit;
import com.example.manu.dungeonmasterlibrary.RETROFIT.INTERFACES.RACES.GetRacesRetrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class PersonajesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    RecyclerView contenedor;
    MenuItem btnAddPersonajes, btnRamon;
    MenuItem btnPersonaje;
    CardView cardViewChar;
    ArrayList<Personajes> listaPersonajes = new ArrayList<Personajes>();
    ArrayList<Character> listaCharacters = new ArrayList<Character>();
    WebView mWebView;
    Boolean webView = false;
    //ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        contenedor = findViewById(R.id.contenedor);
        btnAddPersonajes = findViewById(R.id.btnAddPersonajes);
        btnRamon = findViewById(R.id.btnRamon);
        cardViewChar = findViewById(R.id.cardViewChar);




        //mProgressBar =  findViewById(R.id.progressBar);

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

                        //cambiando el layout
                        setContentView(R.layout.webview_wiki);
                        //obteniendo el webview
                        mWebView = findViewById(R.id.mWebView);

                        String url = "https://www.d20pfsrd.com/";
                        if(savedInstanceState != null){
                            url = savedInstanceState.getString("URL");
                        }

                        WebSettings webSettings = mWebView.getSettings();
                        //webSettings.setJavaScriptEnabled(true);
                        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
                            webSettings.setBlockNetworkLoads(false);
                            webSettings.setDomStorageEnabled(true);
                        }

                        mWebView.setWebViewClient(new WebViewClient(){
                            @Override

                            //Decidir que se carga dentro del WebView y que se carga fuera
                            public boolean shouldOverrideUrlLoading(WebView view, String request) {
                                if (Uri.parse(request).getHost().endsWith("https://www.d20pfsrd.com/")){
                                    return false;
                                } else {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request));
                                    view.getContext().startActivity(intent);
                                    return true;
                                }
                            }

                            @Override
                            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                super.onPageStarted(view, url, favicon);
                                webView = true;
                                //mProgressBar.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onPageFinished(WebView view, String url) {
                                super.onPageFinished(view, url);
                                //mProgressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                                super.onReceivedError(view, request, error);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            Personajes personaje = bundle.getParcelable("PERSONAJE");
            listaPersonajes.add(personaje);
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

        if (webView){
            if (mWebView.canGoBack()){
                mWebView.goBack();
            } else {
                webView=false;
                super.onBackPressed();
            }
        } else {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
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
            startActivity(
                    new Intent(PersonajesActivity.this,TestActivity.class));
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

        GetCharacterRetrofit Api = retrofit.create(GetCharacterRetrofit.class);

        Call <Character> call = Api.loadChanges(1);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Character c = response.body();
                listaCharacters.add(c);
                contenedor.setAdapter(new Adapter(listaCharacters, PersonajesActivity.this));
                contenedor.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contenedor.setLayoutManager(layoutManager);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_character) {

            cargarPersonajes();


        } /*else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
