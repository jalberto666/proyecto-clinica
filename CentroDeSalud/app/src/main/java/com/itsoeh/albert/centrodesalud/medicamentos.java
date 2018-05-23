package com.itsoeh.albert.centrodesalud;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class medicamentos extends AppCompatActivity implements View.OnClickListener{

    Button consultar;
    Button consultarporid;
    Button insertar;
    Button actualizar;
    Button borrar;
    EditText identificador;
    EditText nombre;
    EditText tipo;
    EditText cantidad;
    TextView resultado;

    String IP ="http://192.168.43.243:8081/ServiciosWeb";

    String GET = IP +"/obtener_medicamento.php";
    String GET_BY_ID=IP+"/obtener_medicamento_por_id.php";
    String UPDATE=IP+"/actualizar_medicamento.php";
    String DELETE=IP+"/borrar_medicamento.php";
    String INSERT=IP+"/insertar_medicamento.php";

    ObtenerWebService hiloconexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos);

        consultar = (Button)findViewById(R.id.consultar);
        consultarporid = (Button)findViewById(R.id.consultarid);
        insertar = (Button)findViewById(R.id.insertar);
        actualizar = (Button)findViewById(R.id.actualizar);
        borrar = (Button)findViewById(R.id.borrar);

        identificador = (EditText)findViewById(R.id.eid);
        nombre = (EditText)findViewById(R.id.enombre);
        tipo = (EditText)findViewById(R.id.etipo);
        cantidad = (EditText)findViewById(R.id.ecantidad);
        resultado = (TextView)findViewById(R.id.resultado);


        consultar.setOnClickListener(this);
        consultarporid.setOnClickListener(this);
        insertar.setOnClickListener(this);
        actualizar.setOnClickListener(this);
        borrar.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.consultar:
                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(GET,"1");
            break;
            case R.id.consultarid:
                hiloconexion = new ObtenerWebService();
                String cadenallamada = GET_BY_ID+"?id_medicamento=" + identificador.getText().toString();
                hiloconexion.execute(cadenallamada,"2");
                break;
            case R.id.insertar:
                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(INSERT,"3",identificador.getText().toString(),
                nombre.getText().toString(), tipo.getText().toString(),cantidad.getText().toString());
                break;
            case R.id.actualizar:
                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(UPDATE,"4",identificador.getText().toString(),
                        nombre.getText().toString(), tipo.getText().toString(),cantidad.getText().toString());
                break;
            case R.id.borrar:
                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(DELETE,"5",identificador.getText().toString());
                break;
                default:

                    break;
        }

    }

    public class ObtenerWebService extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            resultado.setText(s);
            // /super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            String cadena = strings[0];
            String devuelve="";
            URL url = null;

            if (strings[1]=="1"){//Consultar todos
                try {
                    url = new URL(cadena);
                    HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestProperty("User-Agent","Mozilla/5.0"+"(Linux; Android 4.4; es-ES) Ejemplo http");
                    int respuesta = connection.getResponseCode();
                    StringBuilder result = new StringBuilder();

                    if (respuesta==HttpURLConnection.HTTP_OK){
                        InputStream in =new BufferedInputStream(connection.getInputStream());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                        String linea;
                        while ((linea=reader.readLine())!=null){
                            result.append(linea);
                        }
                        JSONObject respuestaJson = new JSONObject(result.toString());
                        String  resultJson = respuestaJson.getString("estado");



                        if (resultJson.equals("1")){
                            JSONArray medicamentosJSON=respuestaJson.getJSONArray("medicamentos");
                            for (int i=0; i<medicamentosJSON.length(); i++){
                                devuelve=devuelve+medicamentosJSON.getJSONObject(i).getString("id_medicamento")+" "+
                                        medicamentosJSON.getJSONObject(i).getString("nombre")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("tipo")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("cantidad")+"\n";
                            }
                        }else if(resultJson.equals("2")){
                            devuelve="No hay medicamentos";
                        }
                    }
                } catch(IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    e.printStackTrace();
                }

                return devuelve;

            }else if(strings[1]=="2"){//Consultar por ID


                try {
                    url = new URL(cadena);
                    HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestProperty("User-Agent","Mozilla/5.0"+"(Linux; Android 4.4; es-ES) Ejemplo http");
                    int respuesta = connection.getResponseCode();
                    StringBuilder result = new StringBuilder();

                    if (respuesta==HttpURLConnection.HTTP_OK){
                        InputStream in =new BufferedInputStream(connection.getInputStream());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                        String linea;
                        while ((linea=reader.readLine())!=null){
                            result.append(linea);
                        }
                        JSONObject respuestaJson = new JSONObject(result.toString());
                        String  resultJson = respuestaJson.getString("estado");



                        if (resultJson.equals("1")){
                            devuelve=devuelve+respuestaJson.getJSONObject ("medicamentos").getString("id_medicamento")+ " "+
                                        respuestaJson.getJSONObject("medicamentos").getString("nombre")+"  "+
                                        respuestaJson.getJSONObject("medicamentos").getString("tipo")+"  "+
                                        respuestaJson.getJSONObject("medicamentos").getString("cantidad")+"\n";

                        }else if(resultJson.equals("2")){
                            devuelve="No hay medicamentos";
                        }
                    }
                } catch(IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    e.printStackTrace();
                }

                return devuelve;
            }else if(strings[1]=="3"){ //Insertar

                try {
                    HttpURLConnection urlConn;

                    DataOutputStream printout;
                    DataInputStream input;
                    url = new URL(cadena);
                    urlConn=(HttpURLConnection) url.openConnection();
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    urlConn.setRequestProperty("Accept", "application/json");
                    urlConn.connect();

                    JSONObject jsonParam=new JSONObject();
                    jsonParam.put("id_medicamento", strings[2]);
                    jsonParam.put("nombre", strings[3]);
                    jsonParam.put("tipo", strings[4]);
                    jsonParam.put("cantidad", strings[5]);

                    OutputStream os=urlConn.getOutputStream();
                    BufferedWriter writer=new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(jsonParam.toString());
                    writer.flush();
                    writer.close();

                    int respuesta = urlConn.getResponseCode();

                    StringBuilder result = new StringBuilder();
                    if (respuesta==HttpURLConnection.HTTP_OK){
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                        while ((line=br.readLine()) != null){
                            result.append(line);
                        }
                        JSONObject respuestaJSON = new JSONObject(result.toString());
                        String resultJSON = respuestaJSON.getString("estado");

                        if (resultJSON.equals("1")){
                            devuelve="Medicamento insertado correctamente";
                        }else if (resultJSON.equals("2")){
                            devuelve="El medicamento no se pudo insertar";
                        }
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
                return devuelve;

            }else if(strings[1]=="4"){//Actualizar
                try {
                    HttpURLConnection urlConn;

                    DataOutputStream printout;
                    DataInputStream input;
                    url = new URL(cadena);
                    urlConn=(HttpURLConnection) url.openConnection();
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    urlConn.setRequestProperty("Accept", "application/json");
                    urlConn.connect();

                    JSONObject jsonParam=new JSONObject();
                    jsonParam.put("id_medicamento", strings[2]);
                    jsonParam.put("nombre", strings[3]);
                    jsonParam.put("tipo", strings[4]);
                    jsonParam.put("cantidad", strings[5]);

                    OutputStream os=urlConn.getOutputStream();
                    BufferedWriter writer=new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(jsonParam.toString());
                    writer.flush();
                    writer.close();

                    int respuesta = urlConn.getResponseCode();

                    StringBuilder result = new StringBuilder();
                    if (respuesta==HttpURLConnection.HTTP_OK){
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                        while ((line=br.readLine()) != null){
                            result.append(line);
                        }
                        JSONObject respuestaJSON = new JSONObject(result.toString());
                        String resultJSON = respuestaJSON.getString("estado");

                        if (resultJSON.equals("1")){
                            devuelve="Medicamento actualizado correctamente";
                        }else if (resultJSON.equals("2")){
                            devuelve="El medicamento no se pudo actualizar";
                        }
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
                return devuelve;

            }else if(strings[1]=="5"){//Borrar
                try {
                    HttpURLConnection urlConn;

                    DataOutputStream printout;
                    DataInputStream input;
                    url = new URL(cadena);
                    urlConn=(HttpURLConnection) url.openConnection();
                    urlConn.setDoInput(true);
                    urlConn.setDoOutput(true);
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type", "application/json");
                    urlConn.setRequestProperty("Accept", "application/json");
                    urlConn.connect();

                    JSONObject jsonParam=new JSONObject();
                    jsonParam.put("id_medicamento", strings[2]);

                    OutputStream os=urlConn.getOutputStream();
                    BufferedWriter writer=new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(jsonParam.toString());
                    writer.flush();
                    writer.close();

                    int respuesta = urlConn.getResponseCode();

                    StringBuilder result = new StringBuilder();
                    if (respuesta==HttpURLConnection.HTTP_OK){
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                        while ((line=br.readLine()) != null){
                            result.append(line);
                        }
                        JSONObject respuestaJSON = new JSONObject(result.toString());
                        String resultJSON = respuestaJSON.getString("estado");

                        if (resultJSON.equals("1")){
                            devuelve="Medicamento borrado correctamente";
                        }else if (resultJSON.equals("2")){
                            devuelve="No hay medicamentos";
                        }
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
                return devuelve;
                }


            return null;
        }
    }
}
