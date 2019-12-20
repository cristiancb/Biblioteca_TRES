package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt_act extends AppCompatActivity {


    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:13270";
    static String USERNAME = "awyhhxls";
    static String PASSWORD = "iO54CzHaUA9n";
    String topic = "LIBROS TRABAJADOS";
    MqttAndroidClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(),MQTTHOST,clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());



        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(),"Se ha conectado",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(),"No se ha conectado",Toast.LENGTH_LONG).show();


                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void Farenheith(View view)
    {
        String topics = topic;
        String mensaje = "Farenheith";
        try{
            client.publish(topics,mensaje.getBytes(),0,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public void Revival(View view)
    {
        String topics = topic;
        String mensaje = "Revival";
        try{
            client.publish(topics,mensaje.getBytes(),0,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void Alquimista(View view)
    {
        String topics = topic;
        String mensaje = "El Alquimista";
        try{
            client.publish(topics,mensaje.getBytes(),0,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void Poder(View view)
    {
        String topics = topic;
        String mensaje = "El Poder";
        try{
            client.publish(topics,mensaje.getBytes(),0,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void Despertar(View view)
    {
        String topics = topic;
        String mensaje = "Despertar";
        try{
            client.publish(topics,mensaje.getBytes(),0,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
