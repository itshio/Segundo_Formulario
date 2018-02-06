package com.example.segundo_formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Spinner spdia,spmes,spano;
    EditText etnombre,etTelefono,etsueldo,etprima,ettotal;
    Button botonirpf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonirpf= (Button)findViewById(R.id.btn_irpf);

        etnombre= (EditText)findViewById(R.id.et_nombre);
        etTelefono= (EditText)findViewById(R.id.et_telefono);
        etsueldo= (EditText)findViewById(R.id.et_sueldo);
        etprima= (EditText)findViewById(R.id.et_prima);
        ettotal= (EditText)findViewById(R.id.et_total);

        spdia=(Spinner)findViewById(R.id.sp_dia);
        spmes=(Spinner)findViewById(R.id.sp_mes);
        spano=(Spinner)findViewById(R.id.sp_ano);

        String [] dia= {"Dia","1","2","3","4","5","6","7","8","9","10",
                "11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

        ArrayAdapter<String> adaptadordia= new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,dia);

        spdia.setAdapter(adaptadordia);



        String [] mes= {"Mes","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre",
                "Noviembre","Diciembre"};

        ArrayAdapter<String> adaptadormes= new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,mes);

        spmes.setAdapter(adaptadormes);


        String [] ano= {"Año","2018","2017","2016","2015","2014","2013"};

        ArrayAdapter<String> adaptadorano= new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,ano);

        spano.setAdapter(adaptadorano);


    }// On Create


    public void clickirpf (View view) {

        String cajasueldo = etnombre.getText().toString() + " ";

        if (cajasueldo.equals("")) {

            Toast.makeText(this, "Debes rellenar el sueldo", Toast.LENGTH_LONG).show();
        } else {

            double sueldo = Double.parseDouble(cajasueldo);
            double sueldonuevo = sueldo - (sueldo * 0.10);
            etsueldo.setText(sueldonuevo + " ");
            botonirpf.setEnabled(false);
            etsueldo.setEnabled(false);
            botonirpf.setText("Aplicado");


        }
    }

    public void clickmas (View view){




    }

    public void clickmenos (View view){


    }

    public void clickcalcular (View view){


    }

    public void clickgenerar (View view){

        //RECOGER EL VALOR DE LA CAJA DE TEXTO NOMBRE

        String nombrecompleto = etnombre.getText().toString();

        //COMPROBAR SI EL NOMBRE ESTA VACIO

        if(nombrecompleto.equals("") || nombrecompleto.length()==0){

            Toast.makeText(this,"Debes rellenar el nombre",Toast.LENGTH_LONG).show();


        }else{

            //SPLIT DEVUELVE UN ARRAY DE STRING SEPARADOS POR EL VALOR QUE LE DEMOS

            String[] arraynombre = nombrecompleto.split(" ");

            //SI EL ARRAYNOMBRE TIENE MENOS DE 3 POSIVIONES AVISAMOS AL USUARIO
            if(arraynombre.length<3){

                Toast.makeText(this,"EL FORMATO DEL NOMBRE NO ES CORRECTO\n" +
                        "Formato: Nobre Apellido1 Apellido2",Toast.LENGTH_LONG).show();

            }else{

                //VALIDACION DE APELLIDOS
                int tamarray = arraynombre.length;
                String apellido2 = arraynombre[tamarray-1];
                String apellido1 = arraynombre[tamarray-2];

                //VALIDACION DE NOMBRE

                int tamrestante = tamarray-2;

                String nombre="";
                for (int i=0; i<tamrestante; i++){
                    nombre+=arraynombre[i]+" ";
                }
                Toast.makeText(this,"Nombre: "+nombre+ "Apellido1: "+apellido1+"Apellido2: "+apellido2,Toast.LENGTH_LONG).show();
            }
        }

        //COMPROBAR TELEFONO

        String cajatelefono = etTelefono.getText().toString();

        if(cajatelefono.equals("")){

            Toast.makeText(this,"Debes de rellenar el telefono",Toast.LENGTH_LONG).show();


        }else {

            //CONVERTIR EL STRING EN INT
            int telefono= Integer.parseInt(cajatelefono);

            if(telefono<600000000 || telefono>999999999){

                Toast.makeText(this,"formato incorrecto, debe comenzar por 6,7,8 o 9",Toast.LENGTH_LONG).show();
            }else{

                Toast.makeText(this,"telefono correcto",Toast.LENGTH_LONG).show();

            }

        }
    }







}//NO BORRAR
