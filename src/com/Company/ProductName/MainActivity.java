package com.Company.ProductName;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	public int progressStatus = 0;
	public Handler handler = new Handler();
	public Button continuar;
	
	private ImageView selectedImageView;

	private ImageView leftArrowImageView;

	private ImageView rightArrowImageView;

	private Gallery gallery;

	private int selectedImagePosition = 0;

	private List<Drawable> drawables;

	private GalleryImageAdapter galImageAdapter;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		continuar= (Button) findViewById(R.id.start);
		continuar.setEnabled(false);
		progressbar();
		
		continuar();
		
		getDrawablesList();
		setupUI();
		
		
	}



	  public void irLogin(View view) {
	        Intent login = new Intent(this,Login.class );
	        startActivity(login);
	  }
	  
	  
	  public void progressbar()	  {
		 
		  
		  final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
		  final TextView textView = (TextView) findViewById(R.id.progreso);
		 //inicia el hilo
	 new Thread(new Runnable() {
		     public void run() {
		        while (progressStatus < 100) {
		           progressStatus += 1;
		    // actualizacion de la vista de la barra de progreso
		          
		                         
		    handler.post(new Runnable() {
		    public void run() {
		    	
		    	//asignamos los valores a text 
		       progressBar.setProgress(progressStatus);
		       textView.setText(progressStatus+"/"+progressBar.getMax());
		    }
		        });
		        try {
		           
		           Thread.sleep(100);
		        } catch (InterruptedException e) {
		           e.printStackTrace();
		        }
		     }
		        
		        
		        
		        
		  }
		  }).start();
		  
		 }
public void continuar(){
	
	continuar.setEnabled(true);
}

//-------------------


private void setupUI() {

	selectedImageView = (ImageView) findViewById(R.id.selected_imageview);
	leftArrowImageView = (ImageView) findViewById(R.id.left_arrow_imageview);
	rightArrowImageView = (ImageView) findViewById(R.id.right_arrow_imageview);
	gallery = (Gallery) findViewById(R.id.gallery);

	leftArrowImageView.setOnClickListener(new OnClickListener() {

	
		public void onClick(View v) {

			if (selectedImagePosition > 0) {
				--selectedImagePosition;

			}

			gallery.setSelection(selectedImagePosition, false);
		}
	});

	rightArrowImageView.setOnClickListener(new OnClickListener() {

	
		public void onClick(View v) {

			if (selectedImagePosition < drawables.size() - 1) {
				++selectedImagePosition;

			}

			gallery.setSelection(selectedImagePosition, false);

		}
	});

	gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

	
		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

			selectedImagePosition = pos;

			if (selectedImagePosition > 0 && selectedImagePosition < drawables.size() - 1) {

				leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_left_enabled));
				rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_enabled));

			} else if (selectedImagePosition == 0) {

				leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_left_disabled));

			} else if (selectedImagePosition == drawables.size() - 1) {

				rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_disabled));
			}

			changeBorderForSelectedImage(selectedImagePosition);
			setSelectedImage(selectedImagePosition);
		}

		
		public void onNothingSelected(AdapterView<?> arg0) {

		}

	});

	galImageAdapter = new GalleryImageAdapter(this, drawables);

	gallery.setAdapter(galImageAdapter);

	if (drawables.size() > 0) {

		gallery.setSelection(selectedImagePosition, false);

	}

	if (drawables.size() == 1) {

		rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_disabled));
	}

}

private void changeBorderForSelectedImage(int selectedItemPos) {

	int count = gallery.getChildCount();

	for (int i = 0; i < count; i++) {

		ImageView imageView = (ImageView) gallery.getChildAt(i);
		imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.image_border));
		imageView.setPadding(3, 3, 3, 3);

	}

	ImageView imageView = (ImageView) gallery.getSelectedView();
	imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.selected_image_border));
	imageView.setPadding(3, 3, 3, 3);
}

private void getDrawablesList() {

	drawables = new ArrayList<Drawable>();
	drawables.add(getResources().getDrawable(R.drawable.instruccion1));
	drawables.add(getResources().getDrawable(R.drawable.instruccion2));
	drawables.add(getResources().getDrawable(R.drawable.instruccion3));
	drawables.add(getResources().getDrawable(R.drawable.instruccion4));

}

private void setSelectedImage(int selectedImagePosition) {

	BitmapDrawable bd = (BitmapDrawable) drawables.get(selectedImagePosition);
	Bitmap b = Bitmap.createScaledBitmap(bd.getBitmap(), (int) (bd.getIntrinsicHeight() * 0.9), (int) (bd.getIntrinsicWidth() * 0.7), false);
	selectedImageView.setImageBitmap(b);
	selectedImageView.setScaleType(ScaleType.FIT_XY);

}

}


