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

public class pacientes extends AppCompatActivity implements View.OnClickListener{

    Button consultar;
    Button consultarporid;
    Button insertar;
    Button actualizar;
    Button borrar;
    EditText nombre;
    EditText apellidoP;
    EditText apellidoM;
    EditText jurisdiccion;
    EditText municipio;
    EditText centro;
    EditText domicilio;
    EditText mna;
    EditText viv;
    EditText n_micro;
    EditText programa;
    EditText fecha;
    TextView resultado;

    String IP ="http://192.168.43.243:8081/ServiciosWeb/pacientes";

    String GET = IP +"/obtener_paciente.php";
    String GET_BY=IP+"/obtener_paciente_por.php";
    String UPDATE=IP+"/actualizar_paciente.php";
    String DELETE=IP+"/borrar_paciente.php";
    String INSERT=IP+"/insertar_paciente.php";

    ObtenerWebService hiloconexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacientes);

        consultar = (Button)findViewById(R.id.consultar);
        consultarporid = (Button)findViewById(R.id.consultarid);
        insertar = (Button)findViewById(R.id.insertar);
        actualizar = (Button)findViewById(R.id.actualizar);
        borrar = (Button)findViewById(R.id.borrar);

        nombre = (EditText)findViewById(R.id.enombre);
        apellidoP = (EditText)findViewById(R.id.eapellidop);
        apellidoM = (EditText)findViewById(R.id.eapellidom);
        jurisdiccion = (EditText)findViewById(R.id.ejurisdicccion);
        municipio = (EditText)findViewById(R.id.emunicipio);
        centro = (EditText)findViewById(R.id.ecentro);
        domicilio = (EditText)findViewById(R.id.edomicilio);
        mna = (EditText)findViewById(R.id.emna);
        viv = (EditText)findViewById(R.id.eviv);
        n_micro = (EditText)findViewById(R.id.en_micro);
        programa = (EditText)findViewById(R.id.programa);
        fecha = (EditText)findViewById(R.id.efecha);
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
                String cadenallamada = GET_BY+"?nombre=" + nombre.getText().toString();
                hiloconexion.execute(cadenallamada,"2");
                break;
            case R.id.insertar:
                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(INSERT,"3",nombre.getText().toString(),
                        apellidoP.getText().toString(),
                        apellidoM.getText().toString(),
                        jurisdiccion.getText().toString(),
                        municipio.getText().toString(),
                        centro.getText().toString(),
                        domicilio.getText().toString(),
                        mna.getText().toString(),
                        viv.getText().toString(),
                        n_micro.getText().toString(),
                        programa.getText().toString(),
                        fecha.getText().toString());

                break;
            case R.id.actualizar:
                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(UPDATE,"4",nombre.getText().toString(),
                        apellidoP.getText().toString(),
                        apellidoM.getText().toString(),
                        jurisdiccion.getText().toString(),
                        municipio.getText().toString(),
                        centro.getText().toString(),
                        domicilio.getText().toString(),
                        mna.getText().toString(),
                        viv.getText().toString(),
                        n_micro.getText().toString(),
                        programa.getText().toString(),
                        fecha.getText().toString());
                break;
            case R.id.borrar:
                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(DELETE,"5",nombre.getText().toString());
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
                            JSONArray medicamentosJSON=respuestaJson.getJSONArray("pacientes");
                            for (int i=0; i<medicamentosJSON.length(); i++){
                                devuelve=devuelve+medicamentosJSON.getJSONObject(i).getString("nombre")+" "+
                                        medicamentosJSON.getJSONObject(i).getString("apellidoP")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("apellidoM")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("jurisdiccion")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("municipio")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("centro")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("domicilio")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("mna")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("viv")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("n_micro")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("programa")+"  "+
                                        medicamentosJSON.getJSONObject(i).getString("fecha")+"\n";
                            }
                        }else if(resultJson.equals("2")){
                            devuelve="No hay Pacientes";
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
                            devuelve=devuelve+
                                    respuestaJson.getJSONObject("pacientes").getString("nombre")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("apellidoP")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("apellidoM")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("jurisdiccion")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("municipio")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("centro")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("domicilio")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("mna")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("viv")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("n_micro")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("programa")+"  "+
                                    respuestaJson.getJSONObject("pacientes").getString("fecha")+"\n";

                        }else if(resultJson.equals("2")){
                            devuelve="No hay pacientes";
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
                    jsonParam.put("nombre", strings[2]);
                    jsonParam.put("apellidoP", strings[3]);
                    jsonParam.put("apellidoM", strings[4]);
                    jsonParam.put("jurisdiccion", strings[5]);
                    jsonParam.put("municipio", strings[6]);
                    jsonParam.put("centro", strings[7]);
                    jsonParam.put("domicilio", strings[8]);
                    jsonParam.put("mna", strings[9]);
                    jsonParam.put("viv", strings[10]);
                    jsonParam.put("n_micro", strings[11]);
                    jsonParam.put("programa", strings[12]);
                    jsonParam.put("fecha", strings[13]);

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
                            devuelve="Paciente insertado correctamente";
                        }else if (resultJSON.equals("2")){
                            devuelve="El paciente no se pudo insertar";
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
                    jsonParam.put("nombre", strings[2]);
                    jsonParam.put("apellidoP", strings[3]);
                    jsonParam.put("apellidoM", strings[4]);
                    jsonParam.put("jurisdiccion", strings[5]);
                    jsonParam.put("municipio", strings[6]);
                    jsonParam.put("centro", strings[7]);
                    jsonParam.put("domicilio", strings[8]);
                    jsonParam.put("mna", strings[9]);
                    jsonParam.put("viv", strings[10]);
                    jsonParam.put("n_micro", strings[11]);
                    jsonParam.put("programa", strings[12]);
                    jsonParam.put("fecha", strings[13]);

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
                            devuelve="Paciente actualizado correctamente";
                        }else if (resultJSON.equals("2")){
                            devuelve="El paciente no se pudo actualizar";
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
                    jsonParam.put("nombre", strings[2]);

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
                            devuelve="Paciente borrado correctamente";
                        }else if (resultJSON.equals("2")){
                            devuelve="No hay pacientes";
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
