package com.Company.ProductName;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class visitante extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visitante);
	}
	
	
	  public void ircamara(View view) {
	        Intent camara = new Intent(this,Camerapreview.class );
	        startActivity(camara);
	  }

}
