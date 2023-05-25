package com.example.constructionriskassessment;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class homefragment_activity extends Activity {


	private View _bg__homefragment_ek2;
	private ImageView down;
	private ImageView up;
	private ImageView rectangle_6;
	private TextView send_report;
	private ImageView rectangle_6_ek1;
	private TextView manage_risk;
	private ImageView rectangle_4;
	private TextView home;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.homefragment);


		_bg__homefragment_ek2 = (View) findViewById(R.id._bg__homefragment_ek2);
		down = (ImageView) findViewById(R.id.down);
		up = (ImageView) findViewById(R.id.up);
		rectangle_6 = (ImageView) findViewById(R.id.rectangle_6);
		send_report = (TextView) findViewById(R.id.send_report);
		rectangle_6_ek1 = (ImageView) findViewById(R.id.rectangle_6_ek1);
		manage_risk = (TextView) findViewById(R.id.manage_risk);
		rectangle_4 = (ImageView) findViewById(R.id.rectangle_4);
		home = (TextView) findViewById(R.id.home);


		//custom code goes here

	}
}
	

