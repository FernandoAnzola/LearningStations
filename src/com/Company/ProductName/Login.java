package com.Company.ProductName;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Login extends Activity {

	TextView text1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		
		}
	
	public void alertCancela(View view ){
		AlertDialog.Builder alertCancelar = new AlertDialog.Builder(this);  
        alertCancelar.setTitle("Salir");  
        alertCancelar.setMessage("¿ seguro que quiere salir ?");            
        alertCancelar.setCancelable(false);  
        alertCancelar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface alertCancela, int id) {  
                aceptar();  
            }  
        });  
        alertCancelar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface alertCancela, int id) {  
                cancelar();
            }  
        });            
        alertCancelar.show(); 
	}
	
	
	
	public void aceptar() {
		   finish();
    }
    
    public void cancelar() {
     
    }
    
    
    public void gamemode(View view) {
        Intent mode = new Intent(this,GameMode.class );
        startActivity(mode);
  }
    

}
