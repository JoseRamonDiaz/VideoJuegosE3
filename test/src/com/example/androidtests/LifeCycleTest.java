package com.example.androidtests;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LifeCycleTest extends Activity{
	StringBuilder builder = new StringBuilder();
	TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_life_cycle_test);
        textView = new TextView(this);
        textView.setText(builder.toString());
        setContentView(textView);
        log("created");
    }
    
    protected void onResume(){
    	super.onResume();
    	log("resumed");
    }
    
    protected void onPause(){
    	super.onPause();
    	log("paused");
    	if(isFinishing()) log("finishing");
    }
    
    private void log(String text){
    	Log.d("LifeCycle", text);
    	builder.append(text);
    	builder.append('\n');
    	textView.setText(builder.toString());
    }
}
