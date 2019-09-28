package com.example.tecsup.apitiendaenlinea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    void CargarCategorias(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viveyupi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Interface_Tienda interface_tienda = retrofit.create(Interface_Tienda.class);
         Call<List<Categorias>> servicio = interface_tienda.listCategorias("JSON");
        servicio.enqueue(new Callback<List<Categorias>>() {
            @Override
            public void onResponse(Call<List<Categorias>> call, Response<List<Categorias>> response) {
                List<Categorias> categ = response.body();
                Log.e("Cat", categ.get(0).descripcion);
            }

            @Override
            public void onFailure(Call<List<Categorias>> call, Throwable t) {

            }
        });
    }
}
