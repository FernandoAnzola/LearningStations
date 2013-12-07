package com.Company.ProductName;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameMode extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.game_mode);

	}
	
	  public void visitar(View view) {
	        Intent visita = new Intent(this,visitante.class );
	        startActivity(visita);
	  }
	
	
	
	

}
