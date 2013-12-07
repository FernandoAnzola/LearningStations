package com.Company.ProductName;

import java.io.IOException;

import com.qualcomm.QCARUnityPlayer.QCARPlayerProxyActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class Camerapreview extends  Activity implements SurfaceHolder.Callback{

	 android.hardware.Camera camera;
	 SurfaceView surfaceView;
	 SurfaceHolder surfaceHolder;
	 boolean previewing = false;;
	 
	 String stringPath = "/sdcard/samplevideo.3gp";
	 
	   /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.camerapreview);
	      
	       Button buttonStartCameraPreview = (Button)findViewById(R.id.startcamerapreview);
	       Button buttonStopCameraPreview = (Button)findViewById(R.id.stopcamerapreview);
	      
	       getWindow().setFormat(PixelFormat.UNKNOWN);
	       surfaceView = (SurfaceView)findViewById(R.id.surfaceView1);
	       surfaceHolder = surfaceView.getHolder();
	       surfaceHolder.addCallback(this);
	       surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	       
	      
	       
	      
//	       buttonStartCameraPreview.setOnClickListener(new Button.OnClickListener(){
//
//	  
////	   public void onClick(View v) {
////	    // TODO Auto-generated method stub
////	    if(!previewing){
////	     camera = android.hardware.Camera.open();
////	     if (camera != null){
////	      try {
////	       camera.setPreviewDisplay(surfaceHolder);
////	       camera.startPreview();
////	       previewing = true;
////	      } catch (IOException e) {
////	       // TODO Auto-generated catch block
////	       e.printStackTrace();
////	      }
////	     }
////	    }
//	    
//	    
//	    
//	   //}
//	    	  
//	   	       
//	   	  
//	       });
	       
	     
	      
	       buttonStopCameraPreview.setOnClickListener(new Button.OnClickListener(){


	   public void onClick(View v) {
	    // TODO Auto-generated method stub
	    if(camera != null && previewing){
	     camera.stopPreview();
	     camera.release();
	     camera = null;
	     
	     previewing = false;
	    }
	   }});
	      
	   }

	   
	   
	   public void camara(View view) {
	        Intent visita = new Intent(this,QCARPlayerProxyActivity.class );
	        startActivity(visita);
	  }
	   public void regvisita(View view) {
	        Intent reg = new Intent(this,visitante.class );
	        startActivity(reg);
	  }
	  
	   public void salir(View view)
	   {
		   finish();
	   }
	  

	
	 public void surfaceChanged(SurfaceHolder holder, int format, int width,
	   int height) {
	  // TODO Auto-generated method stub
	  
	 }

	
	 public void surfaceCreated(SurfaceHolder holder) {
	  // TODO Auto-generated method stub
	  
	 }

	
	 public void surfaceDestroyed(SurfaceHolder holder) {
	  // TODO Auto-generated method stub
	  
	 }
}