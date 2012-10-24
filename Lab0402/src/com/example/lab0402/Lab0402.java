package com.example.lab0402;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Lab0402 extends Activity {

	private static final int DIALOG_ALERT_ONE = 1;
	private static final int DIALOG_ALERT_TWO = 2;

	// Place to display a status message
	TextView status;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen001);

		// get definition of status text view
		status = (TextView) findViewById(R.id.status);
	
	
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ALERT_ONE: {
			Log.v("log", "Creating new alert type 1");
			return createTypeOneDialog();
		}
		case DIALOG_ALERT_TWO: {
			Log.v("log", "Creating new alert type 2");
			return createTypeTwoDialog();
		}

		}
		return null;

	}

	private Dialog createTypeOneDialog() {
		// create a new alert dialog builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		// create type one
		builder.setMessage("This is a type one message")
				.setCancelable(false)
				.setPositiveButton("Okay",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// set message to indicate the alert button was
								// pressed
								status.setText("Alert 1 processed!");
							}
						});

		AlertDialog alert = builder.create();
		return alert;
	}

	private Dialog createTypeTwoDialog() {
		// create a new alert dialog builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		// create type one
		builder.setMessage("This is a type two message")
				.setCancelable(false)
				.setPositiveButton("Okay",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// set message to indicate the alert button was
								// pressed
								status.setText("Alert 2 processed!"); 
							}
						});

		AlertDialog alert = builder.create();
		return alert;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.screen001, menu);
		menu.add(0, 1, 0, "alert1");
		menu.add(0, 2, 0, "alert2");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1: {
			showDialog(DIALOG_ALERT_ONE);
			return true;
		}
		case 2: {
			showDialog(DIALOG_ALERT_TWO);
			return true;
		}
		}
		return super.onOptionsItemSelected(item);
	}
}
