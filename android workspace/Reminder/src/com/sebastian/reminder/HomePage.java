package com.sebastian.reminder;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class HomePage extends Activity 
{
	private final static String TAG="HomePage";
	
	private EditText title,date,time,type;
	private Button saveButton;
	
	private DatabaseControl dbControl = new DatabaseControl(this);

    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        
        initialiseUIElements();       
    }

	public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }
	
    private void initialiseUIElements() 
    {
    	saveButton = (Button)findViewById(R.id.save);
    	title = (EditText)findViewById(R.id.title);
    	date = (EditText)findViewById(R.id.date);
    	time = (EditText)findViewById(R.id.time);
    	type = (EditText)findViewById(R.id.type);		
	}
    
    public void buttonClickMethod (View view)
    {
    	if (view == saveButton) {
    		Log.e(TAG, "SAVE button clicked");
    		Log.e(TAG, "title: "+title.getText());
    		Log.e(TAG, "date: "+date.getText());
    		Log.e(TAG, "time: "+time.getText());
    		Log.e(TAG, "type: "+type.getText());
    		
    		String titleText = ""+title.getText();
    		String dateText = ""+date.getText();
    		String timeText = ""+time.getText();
    		String typeText = ""+type.getText();
    		
    		dbControl.openDatabase();
    		
    		long rowid = 0;
    		
    		rowid = dbControl.addDailyEvent(titleText, dateText, timeText, typeText);
    		
    		Log.e(TAG, "Item added in row: "+rowid);
    		dbControl.closeDatabase();
    		
    		    		
    	}
    }    
}