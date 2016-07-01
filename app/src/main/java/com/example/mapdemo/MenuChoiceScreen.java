package com.example.mapdemo;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;





import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;






public class MenuChoiceScreen extends Activity implements OnClickListener  {
	private MediaPlayer mplayer;
	private static final String TAG = "MyActivity";
	public static final String PREFS_NAME = "HellowWorldSettings";	
	
	private EditText emailAddress;
    private EditText password;
    private EditText username;
	private ProgressDialog progressDialog;
	private Thread logoTimer;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        
        Global.stopMusic();
        
        Typeface tf = Typeface.createFromAsset(getAssets(),"data/fonts/spartan.otf");
        
        TextView tv = (TextView) findViewById(R.id.start);
        TextView tv1 = (TextView) findViewById(R.id.quick);
        TextView tv2 = (TextView) findViewById(R.id.settings);
        TextView tv3 = (TextView) findViewById(R.id.about);
        
        tv.setTypeface(tf);
        tv1.setTypeface(tf);
        tv2.setTypeface(tf);
        tv3.setTypeface(tf);
        
        tv.setOnTouchListener(new CustomTouchListener());
        tv1.setOnTouchListener(new CustomTouchListener());
        tv2.setOnTouchListener(new CustomTouchListener());
        tv3.setOnTouchListener(new CustomTouchListener());
        
        tv.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
    
	       
	        
	
             
    }

   
    @Override
	public void onClick(View v) {
		
		switch(v.getId()){
			case R.id.start:
				  startActivity(new Intent(MenuChoiceScreen.this, BasicMapDemoActivity.class));
				break;
			case R.id.quick:
				Intent s = new Intent(this, BasicMapDemoActivity.class);
				startActivity(s);
				break;
			case R.id.settings:
				Intent i = new Intent(this, SettingsActivity.class);
				startActivity(i);
				break;
			case R.id.about:
				makeDialog();
				break;				
		}
		
	}
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
	
		super.onCreateOptionsMenu(menu);
    	MenuInflater main_menu = getMenuInflater();
    	main_menu.inflate(R.menu.main_menu,menu);
    	
    	return true;
    	
	}


@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	   switch(item.getItemId()) {
	   case R.id.menu_item:
	       // this.progressDialog = ProgressDialog.show(this, "working . . .", "Initializing the game");
	       Global.stopMusic();
		   startActivity(new Intent(MenuChoiceScreen.this, BasicMapDemoActivity.class));
		   finish();
		   return true;
	   
	   case R.id.menu_toast:
		   // to do list
		   return true;
	   case R.id.menu_new:
		   // to do list
		   return true;
	   case R.id.menu_play:
		   // to do list	
		   startActivity(new Intent(MenuChoiceScreen.this, SettingsActivity.class));
		   return true;
		
	   case R.id.menu_quit:
		   // to do list
		   finish();
		   return true;
		
	  
		   
	   }	   
	   return false;
   }
    
	@Override
	protected void onDestroy() {
	//	Global.mp.stop();
		super.onDestroy();
	}

	@Override
	protected void onResume() {
	
	//	Global.startMusic(this);
		super.onResume();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
	}
	private void makeDialog() {		
		
	    AlertDialog.Builder dialog = new AlertDialog.Builder(this);	    
	    
	    dialog.setMessage("This is a demo");

	    dialog.setPositiveButton("Buy the full version", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	        	Toast.makeText(getBaseContext(), "BUY IT", Toast.LENGTH_LONG).show();
	        }
	    });
	
	    dialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {}
	    });
	
	    dialog.show();
	}

	
    

 	@Override
 	protected void onPause() {
 		// TODO Auto-generated method stub
 		
 		super.onPause();
 	}

 

}