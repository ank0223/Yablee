package app.yablee.yableepart1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetails extends Activity {

	String wifiSsid;
	String password;
	String macId;
	TextView wifi, pass, mac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdetails);

        wifi = (TextView)findViewById(R.id.wifissidshow);
        pass = (TextView)findViewById(R.id.passwordshow);
        mac  = (TextView)findViewById(R.id.macidshow);
        
        wifiSsid = getIntent().getExtras().getString("Wifissid");
		password = getIntent().getExtras().getString("Password");
		macId    = getIntent().getExtras().getString("BluetoothMacID");
		
		wifi.setText(wifiSsid);
		pass.setText(password);
		mac .setText(macId);
    }
}
