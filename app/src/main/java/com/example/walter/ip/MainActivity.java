package com.example.walter.ip;


import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.textView);
    }
    public void wifiMac(View view) {
        WifiManager wifi=(WifiManager)getSystemService(WIFI_SERVICE);
        String address=wifi.getConnectionInfo().getMacAddress();
        txt.setText(address);
    }

    public void wifiIpAddress(View view) {
        WifiManager wifi=(WifiManager)getSystemService(WIFI_SERVICE);
        int address=wifi.getDhcpInfo().ipAddress;
        txt.setText(intToIP(address));
    }
    public String intToIP(int i) {
        return ((i & 0xFF)
                + "." + ((i >> 8) & 0xFF)
                + "." + ((i >> 16) & 0xFF)
                + "." + ((i >> 24) & 0xFF));
    }
    public void borrar(View view){
        txt.setText("");
    }

}
