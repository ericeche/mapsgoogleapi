package com.example.mapdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	private TextView tv, tv1, tv2, tv3, tv4, tv5;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);        
        
        Typeface tf = Typeface.createFromAsset(getAssets(),"data/fonts/spartan.otf");
        
        tv = (TextView) findViewById(R.id.sound);
        tv1 = (TextView) findViewById(R.id.music);
        tv2 = (TextView) findViewById(R.id.vibrate);
        tv3 = (TextView) findViewById(R.id.graphics);
        tv4 = (TextView) findViewById(R.id.url);
        tv5 = (TextView) findViewById(R.id.reset);
        
        
        tv.setTypeface(tf);
        tv1.setTypeface(tf);
        tv2.setTypeface(tf);
        tv3.setTypeface(tf);
        tv4.setTypeface(tf);
        tv5.setTypeface(tf);
        
        tv.setOnTouchListener(new CustomTouchListener());
        tv1.setOnTouchListener(new CustomTouchListener());
        tv2.setOnTouchListener(new CustomTouchListener());
        tv3.setOnTouchListener(new CustomTouchListener());
        tv4.setOnTouchListener(new CustomTouchListener());
        tv5.setOnTouchListener(new CustomTouchListener());
        
        tv.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        
        getSettings();
        
        setText();        
    }
        
	private void setText() {
		tv.setText(	Global.settings[0] ? "Sound on" 		: "Sound off");
        tv1.setText(Global.settings[1] ? "Music on" 		: "Music off");
        tv2.setText(Global.settings[2] ? "Vibrate on" 		: "Vibrate off");
        tv3.setText(Global.settings[3] ? "Graphics high" 	: "Graphics low");
        tv4.setText(Global.settings[4] ? "New JSON URL"   : "New JSON URL");
        tv4.setText(Global.settings[5] ? "Reset"  : "Reset");

	}

	private void getSettings() {
		SharedPreferences settings = getSharedPreferences(MenuChoiceScreen.PREFS_NAME, 0);
		
		Global.settings[0] = settings.getBoolean("sound", true);
		Global.settings[1] = settings.getBoolean("music", true);
		Global.settings[2] = settings.getBoolean("vibrate", true);
		Global.settings[3] = settings.getBoolean("graphics", true);		
		
		if(Global.settings[1]) Global.startMusic();
		else Global.stopMusic();
		
	}

	@Override
	public void onClick(View v) {
		SharedPreferences settings = getSharedPreferences(MenuChoiceScreen.PREFS_NAME, 0);
	    SharedPreferences.Editor editor = settings.edit();
	      
		switch(v.getId()){
			case R.id.sound:
				editor.putBoolean("sound", !Global.settings[0]);
				break;
			case R.id.music:
				editor.putBoolean("music", !Global.settings[1]);
				break;
			case R.id.vibrate:
				editor.putBoolean("vibrate", !Global.settings[2]);
				break;
			case R.id.graphics:
				editor.putBoolean("graphics", !Global.settings[3]);
				break;
			case R.id.url:
				makeUrlNameInputDialog();
			case R.id.reset:
				mapResetUrl();
				break;
		}
		
		editor.commit();
		
		getSettings();
		setText();
	}

	private void makeUrlNameInputDialog() {
		
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Input JSON URL");
		alert.setMessage("new JSON URL");

		// Set an EditText view to get user input 
		final EditText input = new EditText(this);
		input.setText(Global.url);
		alert.setView(input);

		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int whichButton) {
		  String value = input.getText().toString();
		  		Toast.makeText(getApplicationContext(), value + " is saved in settings", Toast.LENGTH_LONG).show();
		  		
		  		SharedPreferences settings = getSharedPreferences(MenuChoiceScreen.PREFS_NAME, 0);
			    SharedPreferences.Editor editor = settings.edit();
			    
			    editor.putString("url", value);
			    editor.commit();
		  }
		});

		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		  public void onClick(DialogInterface dialog, int whichButton) {}
		});

		alert.show();
		
	}

	 private void mapResetUrl (){
		    
		    SharedPreferences settings = getSharedPreferences(MenuChoiceScreen.PREFS_NAME, 0);
		    SharedPreferences.Editor editor = settings.edit();    
		    editor.putString("url", Global.url);
		    editor.commit();
		   }
	
	
}