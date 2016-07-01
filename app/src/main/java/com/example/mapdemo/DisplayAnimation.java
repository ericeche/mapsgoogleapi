/**
 *  Vanilla animation splash screen 
 *  Should give fast rendering as it 
 *  takes compiled images such as: static final int modustri1=0x7f020006;
 *  
 * @author Eric Echeverri
 */
package com.example.mapdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;



//TODO get this out here Eclipse, does this!


public class DisplayAnimation extends Activity {
    /** Called when the activity is first created. */
	
	private AnimationDrawable animation;
	public static short myTimer;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);

        Global.mp = MediaPlayer.create(this, R.raw.nullsleep);
        Global.mp.setLooping(true);
  
        final ImageView img = (ImageView) findViewById(R.id.animationview);        
        img.setBackgroundResource(R.drawable.animation_images);
        animation = (AnimationDrawable) img.getBackground();
          
        getSettings();   
	    Global.startMusic();	
	    Toast.makeText(this, "Hello World Changing Mobile Ideas", Toast.LENGTH_LONG).show();
       
	    img.post(new Starter());    
       
    
        Thread logoTimer = new Thread(){        	
	        @Override
			public void run(){
	        try{
	        	myTimer = 0;
	        	while(myTimer < 4000){
	        		sleep(1000);
	        		myTimer += 500;
	        		
	        	}
	        	
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         finally {
           
                startActivity( new Intent(DisplayAnimation.this,MenuChoiceScreen.class));
                finish();
            }
	        
	       }  
       
        };
	      
        logoTimer.start();  
      
   
    
	
    }
    
	class Starter implements Runnable {
        @Override
		public void run() {
            animation.start();      
        }     
    }
        
    @Override
	protected void onDestroy() {    	    	
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	private void getSettings() {
		SharedPreferences settings = getSharedPreferences(MenuChoiceScreen.PREFS_NAME, 0);
		
		Global.settings[0] = settings.getBoolean("sound", true);
		Global.settings[1] = settings.getBoolean("music", true);
		Global.settings[2] = settings.getBoolean("vibrate", true);
		Global.settings[3] = settings.getBoolean("graphics", true);	
		
	
	}

	

}
