package app.yablee.yableepart1;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class InputActivity extends Activity {

	String wifiSsid;
	String password;
	String macId;
	Button sendit;
	EditText wifi, pass, mac;
	Button send; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_input);

        wifi = (EditText)findViewById(R.id.wifissidtext);
        pass = (EditText)findViewById(R.id.passwordtext);
        mac  = (EditText)findViewById(R.id.macidtext);
        send = (Button)findViewById(R.id.sendit);
        pass.setInputType(InputType.TYPE_CLASS_TEXT
				| InputType.TYPE_TEXT_VARIATION_PASSWORD);
        send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				wifiSsid = wifi.getText().toString().trim();
				password = pass.getText().toString().trim();
				macId = mac.getText().toString().trim();
				if (wifiSsid.trim().equalsIgnoreCase("") == true
						|| password.trim().equalsIgnoreCase("") == true
						|| macId.trim().equalsIgnoreCase("") == true) {
					Toast.makeText(getApplicationContext(), "Input All Fields",
							Toast.LENGTH_SHORT).show();
				} else if (macId.length()!=12) {
					Toast.makeText(getApplicationContext(), "Invalid MacID",
							Toast.LENGTH_SHORT).show();
				}
				else {
					
						Intent i = new Intent(InputActivity.this, ShowDetails.class);
						i.putExtra("Wifissid", wifiSsid);
						i.putExtra("Password", password);
						i.putExtra("BluetoothMacID", macId);
						startActivity(i);
						
				}
			}
		});
    }
}
