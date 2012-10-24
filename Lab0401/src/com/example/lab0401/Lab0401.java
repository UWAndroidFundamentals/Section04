package com.example.lab0401;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

/*

This example shows the nature of callbacks for dialogs.

*/

public class Lab0401 extends Activity {

	// Place to display a status message
	TextView status;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen001);

		// get definition of status text view
		status = (TextView) findViewById(R.id.status);
		
		// set a message to indicate we are logically before the alert builder statement
		status.setText("Before dialog created.");
		
		// create a new alert dialog builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		// this one statement lets you set all the parameters and callbacks for the dialog
		// note that we use an anonymous (in line) listener
		builder.setMessage("This is the message")
				.setCancelable(false)
				.setPositiveButton("Okay",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// set message to indicate the alert button was pressed
								status.setText("You clicked the button!");
							}
						});
		
		// now that we have defined the alert, we have to actually create it
		AlertDialog alert = builder.create();
		
		// now that it has been created, we actually show it
		alert.show();

		// set a message to indicate we are logically after the alert builder statement
		status.setText("After dialog created.");
		
	}
}
