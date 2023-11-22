package com.example.proyectoavengers;

import static com.example.proyectoavengers.R.id.imageView2;
import static com.example.proyectoavengers.R.id.textViewSuperHeroe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private Button botonMarvel;
private ImageView imagenIronMan;
private ImageView imagenLoki;
private ImageView imagenHulk;
private ImageView imagenSpiderMan;
private ImageView imagenCapi;
private ImageView imagenThor;
private ImageView imagenBlackPanther;
private ImageView imagen;
private ImageView imagenDos;
private ImageView imagenTres;
private ImageView imagenCuatro;
private ImageView imagenCinco;
private ImageView imagenSeis;
private ImageView imagenSiete;
private ImageView imagenOcho;
private Spinner spinnerFunkos;
private Context context =this;
private ArrayList<String> miArray= new ArrayList<>();
private Button botonLoki;
private Button botonIronMan;
private Button botonHulk;
private Button botonBlackPanther;
private Button botonThor;
private Button botonCapitanAmerica;
private Button botonSpiderMan;
private TextView superHeroe;
private TextView tipoFunko;
private CheckBox pop;
private CheckBox bitty;
private CheckBox cover;
private TextView tamanoFunko;
private RadioGroup tamanos;
private RadioButton radioButtonRegular;
private RadioButton radioButtonSuper;
private RadioButton radioButtonJumbo;
private RadioButton radioButtonMega;
private Button botonComprar;
private View layaoutprincipal;
private ImageButton thanos;
private ImageButton guantelete;
private ConstraintLayout constraintLayout;
private ConstraintLayout conlaya;
private ConstraintLayout conlaya2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonMarvel = findViewById(R.id.buttonTaparIconos);
        imagen= findViewById(imageView2);
        imagenDos = findViewById(R.id.imageView3);
        imagenTres = findViewById(R.id.imageView1);
        imagenCuatro = findViewById(R.id.imageView4);
        imagenCinco = findViewById(R.id.imageView5);
        imagenSeis = findViewById(R.id.imageView7);
        imagenSiete=findViewById(R.id.imageView13);
        imagenOcho=findViewById(R.id.imageView12);
        imagenIronMan=findViewById(R.id.imageIronMan);
        imagenLoki=findViewById(R.id.imageLoki);
        imagenHulk=findViewById(R.id.imageHulk);
        imagenSpiderMan=findViewById(R.id.imageSpiderMan);
        imagenCapi= findViewById(R.id.imageViewCapi);
        imagenThor=findViewById(R.id.imagenThor);
        imagenBlackPanther=findViewById(R.id.imageBlackPanther);
        spinnerFunkos= findViewById(R.id.spinnerCompra);
        botonLoki= findViewById(R.id.botonLoki);
        botonIronMan = findViewById(R.id.botonIronMan);
        botonHulk = findViewById(R.id.botonHulk);
        botonBlackPanther= findViewById(R.id.botonBlackPanther);
        botonCapitanAmerica = findViewById(R.id.botonCapitanAmerica);
        botonThor = findViewById(R.id.botonThor);
        botonSpiderMan = findViewById(R.id.botonSpiderMan);
        superHeroe = findViewById(R.id.textViewSuperHeroe);
        tipoFunko = findViewById(R.id.textViewTipo);
        pop=findViewById(R.id.checkBoxPOP);
        bitty=findViewById(R.id.checkBoxBitty);
        cover=findViewById(R.id.checkBoxCover);
        tamanoFunko=findViewById(R.id.textViewTamano);
        tamanos=findViewById(R.id.radiogroupTamanos);
        radioButtonRegular=findViewById(R.id.radioButtonRegular);
        radioButtonSuper=findViewById(R.id.radioButtonSuper);
        radioButtonJumbo=findViewById(R.id.radioButtonJumbo);
        radioButtonMega=findViewById(R.id.radioButtonMega);
        botonComprar=findViewById(R.id.buttonCompra);
        guantelete=findViewById(R.id.imageButtonGuantelete);
        thanos=findViewById(R.id.imageThanos);
        layaoutprincipal=findViewById(R.id.LayaoutPrincipal);
        constraintLayout=findViewById(R.id.constraintLayout);
        conlaya=findViewById(R.id.conlaya);
        conlaya2=findViewById(R.id.conlaya2);

        botonTapar();
        agregarValores();
        darClikc();
        tipoFunkoSeleccionado();
        tamanoSeleccionado();
        nuevoComienzo();

        botonIronMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarSuperheroe(botonIronMan);}
        });

        botonLoki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarSuperheroe(botonLoki);}
        });

        botonHulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarSuperheroe(botonHulk);}
        });

        botonThor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarSuperheroe(botonThor);}
        });

        botonCapitanAmerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarSuperheroe(botonCapitanAmerica);}
        });

        botonBlackPanther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarSuperheroe(botonBlackPanther);}
        });

        botonSpiderMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {mostrarSuperheroe(botonSpiderMan);}
        });

    }

    public void botonTapar(){
        botonMarvel.setOnClickListener(e->{
            imagen.setVisibility(View.VISIBLE);
            imagenDos.setVisibility(View.VISIBLE);
            imagenTres.setVisibility(View.VISIBLE);
            imagenCuatro.setVisibility(View.VISIBLE);
            imagenCinco.setVisibility(View.VISIBLE);
            imagenSeis.setVisibility(View.VISIBLE);
            imagenSiete.setVisibility(View.VISIBLE);
            imagenOcho.setVisibility(View.VISIBLE);
            spinnerFunkos.setVisibility(View.VISIBLE);
            tipoFunko.setVisibility(View.VISIBLE);
            pop.setVisibility(View.VISIBLE);
            bitty.setVisibility(View.VISIBLE);
            cover.setVisibility(View.VISIBLE);
            tamanoFunko.setVisibility(View.VISIBLE);
            tamanos.setVisibility(View.VISIBLE);
            botonComprar.setVisibility(View.VISIBLE);
            guantelete.setVisibility(View.VISIBLE);
            AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
            fadeIn.setDuration(2000);
            guantelete.startAnimation(fadeIn);
        });
    }
    public void agregarValores(){
        miArray.add("Funkos ↓");
        miArray.add("IronMan");
        miArray.add("Loki");
        miArray.add("Hulk");
        miArray.add("Thor");
        miArray.add("Capitan America");
        miArray.add("SpiderMan");
        miArray.add("Black Panther");
    }
    public void darClikc(){
        spinnerFunkos.setOnItemSelectedListener(this);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,miArray);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFunkos.setAdapter(adaptador);
    }
    public void mostrarSuperheroe(Button botonSuperheroe) {
        String textoSuperheroe = "";

        // Verificar qué botón se ha pulsado
        if (botonSuperheroe.getId() == R.id.botonIronMan) {
            textoSuperheroe = "Iron-Man";
        } else if (botonSuperheroe.getId() == R.id.botonLoki) {
            textoSuperheroe = "Loki";
        }else if (botonSuperheroe.getId() == R.id.botonHulk) {
            textoSuperheroe = "Hulk";
        }else if (botonSuperheroe.getId() == R.id.botonBlackPanther) {
            textoSuperheroe = "Black Panther";
        }else if (botonSuperheroe.getId() == R.id.botonThor) {
            textoSuperheroe = "Thor";
        }else if (botonSuperheroe.getId() == R.id.botonCapitanAmerica) {
            textoSuperheroe = "Capitan América";
        }else if (botonSuperheroe.getId() == R.id.botonSpiderMan) {
            textoSuperheroe = "Spider-Man";
        }
        superHeroe.setText(textoSuperheroe);

        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(2000);
        superHeroe.startAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
                anim.setDuration(1000);
                superHeroe.startAnimation(anim);

                // Ocultar el texto cuando termine la animación
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        superHeroe.setText("");
                        botonSuperheroe.clearFocus();
                    }
                }, 1000);
            }
        }, 1000);
    }

    @Override

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i==0){
            imagenIronMan.setVisibility(View.INVISIBLE);
            imagenLoki.setVisibility(View.INVISIBLE);
            imagenHulk.setVisibility(View.INVISIBLE);
            imagenSpiderMan.setVisibility(View.INVISIBLE);
            imagenCapi.setVisibility(View.INVISIBLE);
            imagenThor.setVisibility(View.INVISIBLE);
            imagenBlackPanther.setVisibility(View.INVISIBLE);
        } else {
            Object texto = adapterView.getSelectedItem();
            String cadena = String.valueOf(texto);
        switch (cadena) {

            case "IronMan":
                imagenIronMan.setVisibility(View.VISIBLE);
                imagenLoki.setVisibility(View.INVISIBLE);
                imagenHulk.setVisibility(View.INVISIBLE);
                imagenSpiderMan.setVisibility(View.INVISIBLE);
                imagenCapi.setVisibility(View.INVISIBLE);
                imagenThor.setVisibility(View.INVISIBLE);
                imagenBlackPanther.setVisibility(View.INVISIBLE);
                break;
            case "Loki":
                imagenLoki.setVisibility(View.VISIBLE);
                imagenIronMan.setVisibility(View.INVISIBLE);
                imagenHulk.setVisibility(View.INVISIBLE);
                imagenSpiderMan.setVisibility(View.INVISIBLE);
                imagenCapi.setVisibility(View.INVISIBLE);
                imagenThor.setVisibility(View.INVISIBLE);
                imagenBlackPanther.setVisibility(View.INVISIBLE);
                break;
            case "Hulk":
                imagenHulk.setVisibility(View.VISIBLE);
                imagenIronMan.setVisibility(View.INVISIBLE);
                imagenLoki.setVisibility(View.INVISIBLE);
                imagenSpiderMan.setVisibility(View.INVISIBLE);
                imagenCapi.setVisibility(View.INVISIBLE);
                imagenThor.setVisibility(View.INVISIBLE);
                imagenBlackPanther.setVisibility(View.INVISIBLE);
                break;
            case "SpiderMan":
                imagenSpiderMan.setVisibility(View.VISIBLE);
                imagenIronMan.setVisibility(View.INVISIBLE);
                imagenLoki.setVisibility(View.INVISIBLE);
                imagenHulk.setVisibility(View.INVISIBLE);
                imagenCapi.setVisibility(View.INVISIBLE);
                imagenThor.setVisibility(View.INVISIBLE);
                imagenBlackPanther.setVisibility(View.INVISIBLE);
                break;
            case "Capitan America":
                imagenCapi.setVisibility(View.VISIBLE);
                imagenIronMan.setVisibility(View.INVISIBLE);
                imagenLoki.setVisibility(View.INVISIBLE);
                imagenHulk.setVisibility(View.INVISIBLE);
                imagenSpiderMan.setVisibility(View.INVISIBLE);
                imagenThor.setVisibility(View.INVISIBLE);
                imagenBlackPanther.setVisibility(View.INVISIBLE);
                break;
            case "Thor":
                imagenThor.setVisibility(View.VISIBLE);
                imagenIronMan.setVisibility(View.INVISIBLE);
                imagenLoki.setVisibility(View.INVISIBLE);
                imagenHulk.setVisibility(View.INVISIBLE);
                imagenSpiderMan.setVisibility(View.INVISIBLE);
                imagenCapi.setVisibility(View.INVISIBLE);
                imagenBlackPanther.setVisibility(View.INVISIBLE);
                break;
            case "Black Panther":
                imagenBlackPanther.setVisibility(View.VISIBLE);
                imagenIronMan.setVisibility(View.INVISIBLE);
                imagenLoki.setVisibility(View.INVISIBLE);
                imagenHulk.setVisibility(View.INVISIBLE);
                imagenSpiderMan.setVisibility(View.INVISIBLE);
                imagenCapi.setVisibility(View.INVISIBLE);
                imagenThor.setVisibility(View.INVISIBLE);
                break;

            }
        }
    }
    public void tipoFunkoSeleccionado(){
        pop.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                bitty.setEnabled(false);
                cover.setEnabled(false);
            } else {
                bitty.setEnabled(true);
                cover.setEnabled(true);
            }
        });

        bitty.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                pop.setEnabled(false);
                cover.setEnabled(false);
            } else {
                pop.setEnabled(true);
                cover.setEnabled(true);
            }
        });

        cover.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                pop.setEnabled(false);
                bitty.setEnabled(false);
            } else {
                pop.setEnabled(true);
                bitty.setEnabled(true);
            }
        });
    }

    public void apiReset(){
        tamanos.clearCheck();
        pop.setChecked(false);
        bitty.setChecked(false);
        cover.setChecked(false);
        spinnerFunkos.setSelection(0);
        imagen.setVisibility(View.INVISIBLE);
        imagenDos.setVisibility(View.INVISIBLE);
        imagenTres.setVisibility(View.INVISIBLE);
        imagenCuatro.setVisibility(View.INVISIBLE);
        imagenCinco.setVisibility(View.INVISIBLE);
        imagenSeis.setVisibility(View.INVISIBLE);
        imagenSiete.setVisibility(View.INVISIBLE);
        imagenOcho.setVisibility(View.INVISIBLE);
        spinnerFunkos.setVisibility(View.INVISIBLE);
        tipoFunko.setVisibility(View.INVISIBLE);
        pop.setVisibility(View.INVISIBLE);
        bitty.setVisibility(View.INVISIBLE);
        cover.setVisibility(View.INVISIBLE);
        tamanoFunko.setVisibility(View.INVISIBLE);
        tamanos.setVisibility(View.INVISIBLE);
        botonComprar.setVisibility(View.INVISIBLE);
        guantelete.setVisibility(View.INVISIBLE);
        thanos.setVisibility(View.VISIBLE);
        layaoutprincipal.setBackgroundResource(R.drawable.fondo_nulo);
        constraintLayout.setBackgroundResource(R.drawable.fondo_nulo);
        conlaya.setBackgroundResource(R.drawable.fondo_nulo);
        conlaya2.setBackgroundResource(R.drawable.fondo_nulo);

    }

public void thanosAparece(){
    thanos.setVisibility(View.VISIBLE);
    Toast.makeText(getApplicationContext(), "Yo soy inevitable", Toast.LENGTH_LONG).show();

    AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
    fadeIn.setDuration(2000);
    thanos.startAnimation(fadeIn);
}


    public void tamanoSeleccionado() {
        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioButtonId = tamanos.getCheckedRadioButtonId();
                if (radioButtonId != -1 && (pop.isChecked() || bitty.isChecked() || cover.isChecked())) {
                    Toast.makeText(getApplicationContext(), "¡¡Funko comprado!!", Toast.LENGTH_SHORT).show();
                    apiReset();
                    thanospulsado();
                } else {
                    Toast.makeText(getApplicationContext(), "Selecciona un tipo y tamaño de Funko", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void nuevoComienzo(){
        guantelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiReset();
                thanosAparece();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        thanospulsado();
                    }
                }, 2000); // 2000 milisegundos = 2 segundos
            }
        });
    }

    public void pulsarThanos(){

    }

public void thanospulsado(){
    thanos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            layaoutprincipal.setBackgroundResource(R.drawable.fondo);
            constraintLayout.setBackgroundResource(R.drawable.fondo);
            conlaya.setBackgroundResource(R.drawable.fondo);
            conlaya2.setBackgroundResource(R.drawable.fondo);
            thanos.setVisibility(View.INVISIBLE);
        }
    });
}
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}