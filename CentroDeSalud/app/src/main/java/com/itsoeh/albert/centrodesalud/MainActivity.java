package com.itsoeh.albert.centrodesalud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIngresar; //Variables de las cajas de texto y boton en el layout de login
    EditText txtUsu, txtPas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsu=(EditText)findViewById(R.id.txtUsu);//Buscamos cada componente por su ID y lo asignamos
        txtPas=(EditText)findViewById(R.id.txtpas);//a las varuables
        btnIngresar=(Button)findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Thread tr=new Thread(){
            @Override
            public void run() {
                final String resultado=enviarDatosGET(txtUsu.getText().toString(), txtPas.getText().toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r=obtenerDatosJSON(resultado);
                        if (r>0){
                            Intent i =new Intent(getApplicationContext(), MenuActivity.class);
                            i.putExtra("cod", txtUsu.getText().toString());
                            startActivity(i);
                        }else {
                            Toast.makeText(getApplicationContext(),"Usuario o Contraseña Incorrectos", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        };
        tr.start();
    }

    public String enviarDatosGET(String usu, String pas){//Método que recopila lo que el usuario ingrese
        URL url=null;                                  //y los envia al web service
        String linea ="";
        int respuesta =0;
        StringBuilder resul = null;
        try {
            url = new URL("http://192.168.43.243:8081/ServiciosWeb/valida.php?usu="+usu+"&pas="+pas); //url de nuestro web service
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            respuesta = connection.getResponseCode();

            resul=new StringBuilder();
            if (respuesta==HttpURLConnection.HTTP_OK){
                InputStream in =new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea=reader.readLine())!=null){
                    resul.append(linea);
                }
            }
        }catch(Exception e){}

        return resul.toString();

    }
    public int obtenerDatosJSON(String response){//Crea un arreglo con todos los dats obtenidos de la
        int res =0;                              //consulta
        try{
            JSONArray json=new JSONArray(response);
            if(json.length()>0){
                res=1;
            }
        }catch (Exception e){}
        return res;
    }


}
