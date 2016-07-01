package com.example.mapdemo;

import java.io.IOException;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class Global {
  
    public static String url = "http://www.droidaddiction.com/aida.json";
    public static int[] intArray = new int[] {0,0,0};
    public static boolean[] settings = new boolean[6];
    public static MediaPlayer mp;  
    
    
    public static void startMusic() {
        	
  		if(Global.settings[1]){

  			try {
  				mp.prepare();
  			} catch (Exception e) {
  				e.printStackTrace();
  			}

  			mp.start();
  		  }
	   }
    
    public static void stopMusic() {
    	if(mp.isPlaying()){
    		mp.stop();
    	}
	   }

}
