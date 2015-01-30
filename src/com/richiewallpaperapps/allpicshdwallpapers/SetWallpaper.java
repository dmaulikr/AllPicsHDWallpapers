package com.richiewallpaperapps.allpicshdwallpapers;

import static com.richiewallpaperapps.allpicshdwallpapers.HeavyLifter.FAIL;
import static com.richiewallpaperapps.allpicshdwallpapers.HeavyLifter.SUCCESS;


import com.richiewallpaperapps.allpicshdwallpapers.R;
import com.richiewallpaperapps.allpicshdwallpapers.HeavyLifter;
import com.richiewallpaperapps.allpicshdwallpapers.OnSwipeTouchListener;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * A helper class that will do the heavy work of decoding images and actually
 * setting the wallpaper
 */

public class SetWallpaper extends Activity {
	private HeavyLifter chuckNorris;
	private int currentPos = 0;
	ArrayList<Integer> backgrounds = new ArrayList<Integer>();
	ArrayList<String> backgroundsURL = new ArrayList<String>();
	LinearLayout setWallLayout;
	private int screenWidth = 0;
	ProgressDialog progDialog;
	private int screenheight = 0;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		/*requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		setContentView(R.layout.setwallpaper);


	    
		DisplayMetrics metrics = this.getResources().getDisplayMetrics();
		screenWidth = metrics.widthPixels;
		screenheight = metrics.heightPixels;

		Intent intent = getIntent();

		currentPos = intent.getIntExtra("CurrentPosition", 0);
		setWallLayout = (LinearLayout) findViewById(R.id.setWallLayout);
		Log.i("URL", intent.getStringExtra("URL") );
		if(intent.getStringExtra("URL").equals("N"))
		{
			backgrounds = intent.getIntegerArrayListExtra("BackgoundImages");
			Log.i("Number Of Images", "List Size" + backgrounds.size());
			setWallLayout.setBackgroundResource(backgrounds.get(currentPos));	
			
			setWallLayout.setOnTouchListener(new OnSwipeTouchListener(this) {
				public void onSwipeTop() {
					//Toast.makeText(SetWallpaper.this, "top", Toast.LENGTH_SHORT)
						//	.show();
				}

				public void onSwipeRight() {
					currentPos--;

					if (currentPos == backgrounds.size()) {
						currentPos = 0;
					} else if (currentPos == 0) {
						currentPos = backgrounds.size();
					}

					Log.i("Action UP", "Current pos on action up" + currentPos);
					setWallLayout.setBackgroundResource(backgrounds.get(currentPos));
					//Toast.makeText(SetWallpaper.this, "right", Toast.LENGTH_SHORT)
						//	.show();
				}

				public void onSwipeLeft() {
					currentPos++;

					if (currentPos == backgrounds.size()) {
						currentPos = 0;
					} else if (currentPos == 0) {
						currentPos = backgrounds.size();
					}

					Log.i("Action Down", "Corrent pos on swipe right" + currentPos);
					setWallLayout.setBackgroundResource(backgrounds.get(currentPos));
					//Toast.makeText(SetWallpaper.this, "left", Toast.LENGTH_SHORT)
							//.show();
				}

				public void onSwipeBottom() {
					//Toast.makeText(SetWallpaper.this, "bottom", Toast.LENGTH_SHORT)
						//	.show();
				}

				public boolean onTouch(View v, MotionEvent event) {
					return gestureDetector.onTouchEvent(event);
				}

				@Override
				public boolean onTouchEvent(MotionEvent event) {
					// TODO Auto-generated method stub
					return gestureDetector.onTouchEvent(event);
				}
			});

		}
		else if(intent.getStringExtra("URL").equals("Y"))
		{

			backgroundsURL = intent.getStringArrayListExtra("BackgoundImagesURLs");
			Log.i("Number Of Images", "List Size" + backgrounds.size());
			
			
			/*Toast toast=Toast.makeText(this, "Please wait, the image is loading!!",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			*/
			//new DownloadImageTask(setWallLayout).execute(backgroundsURL.get(currentPos));
			if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
			{	
				Log.i("API Level 11 and Greater","API level 11 and Greater");
				new DownloadImageTask(setWallLayout).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, backgroundsURL.get(currentPos));
			}
			else
			{	
				Log.i("API Level Less then 11","API level less then 11");
				new DownloadImageTask(setWallLayout).execute(backgroundsURL.get(currentPos));	
			}
				
			setWallLayout.setOnTouchListener(new OnSwipeTouchListener(this) {
				
				public void onSwipeRight() {
					currentPos--;

					if (currentPos == backgroundsURL.size()) {
						currentPos = 0;
					} else if (currentPos == 0) {
						currentPos = backgroundsURL.size();
					}

					Log.i("Action Right", "Current pos on action right" + currentPos);
					if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
					{	
						Log.i("API Level 11 and Greater","API level 11 and Greater");
						new DownloadImageTask(setWallLayout).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, backgroundsURL.get(currentPos));
					}
					else
					{	
						Log.i("API Level Less then 11","API level less then 11");
						new DownloadImageTask(setWallLayout).execute(backgroundsURL.get(currentPos));	
					}
					//setWallLayout.setBackgroundResource(backgrounds.get(currentPos));
					//Toast.makeText(SetWallpaper.this, "right", Toast.LENGTH_SHORT)
						//	.show();
				}

				public void onSwipeLeft() {
					currentPos++;

					if (currentPos == backgroundsURL.size()) {
						currentPos = 0;
					} else if (currentPos == 0) {
						currentPos = backgroundsURL.size();
					}

					Log.i("Action Left", "Current pos on swipe left" + currentPos);
					if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
					{	
						Log.i("API Level 11 and Greater","API level 11 and Greater");
						new DownloadImageTask(setWallLayout).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, backgroundsURL.get(currentPos));
					}
					else
					{	
						Log.i("API Level Less then 11","API level less then 11");
						new DownloadImageTask(setWallLayout).execute(backgroundsURL.get(currentPos));	
					}
					//setWallLayout.setBackgroundResource(backgrounds.get(currentPos));
					//Toast.makeText(SetWallpaper.this, "left", Toast.LENGTH_SHORT)
							//.show();
				}

				

				public boolean onTouch(View v, MotionEvent event) {
					return gestureDetector.onTouchEvent(event);
				}

				@Override
				public boolean onTouchEvent(MotionEvent event) {
					// TODO Auto-generated method stub
					return gestureDetector.onTouchEvent(event);
				}
			});

		}

		
		chuckNorris = new HeavyLifter(this, chuckFinishedHandler);

	}

	public void setBackgroundWallpaper(View v) {
		try {
			int resourceId=0;
			if(backgrounds.size() > 0)
			{
				resourceId = backgrounds.get(currentPos);
				Log.i("Resource ID", "resource id" + resourceId);
				chuckNorris.setResourceAsWallpaper(resourceId, screenheight,screenWidth);
			}	
			else if(backgroundsURL.size() > 0)
			{
				chuckNorris.new SetImageURLWallpaper().execute(backgroundsURL.get(currentPos),String.valueOf(screenheight),String.valueOf(screenWidth),"N");
			}
			Log.i("After function call Resource ID", "resource id "+ resourceId);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			Log.i("Position for Wallpaper", "Current Position of the wallparer"+ currentPos);
			Log.e("Illegel State Exception", "Exception details " + e);
		} catch (Exception e) {
			// TODO: handle exception
			Log.i("Position for Wallpaper", "Current Position of the wallparer"
					+ currentPos);
			Log.e("Other Exception", "Exception details " + e);
		}
	}

	public void SaveImage(View v) {
		Log.i("Save Image", "Saving Image @ " + currentPos);

		//String root = Environment.getExternalStorageDirectory().toString();
		OutputStream output;
	       // Find the SD Card path
	        File filepath = Environment.getExternalStorageDirectory();

	      // Create a new folder in SD Card
	        File dir = new File(filepath.getAbsolutePath()
	              + "/AllPics/");
	        if (!dir.exists())
	        	dir.mkdirs();


	    
	        // Create a name for the saved image
	        String FileName= "AllPics"+Math.random()/1000+".jpg" ;
	        File file = new File(dir, FileName );

	        try {

	            output = new FileOutputStream(file);

	            // Compress into png format image from 0% - 100%
	            if(backgrounds.size() > 0) 
	            {
	            	chuckNorris.getImage(backgrounds.get(currentPos),screenheight,screenWidth).compress(Bitmap.CompressFormat.JPEG, 100, output);
	            	//MediaStore.Images.Media.insertImage(getContentResolver(), chuckNorris.getImage(backgrounds.get(currentPos),screenheight,screenWidth), FileName , FileName);
		            setBackgroundWallpaper(v);
	            }
	            else if(backgroundsURL.size() > 0)
	            {
	            	chuckNorris.new SetImageURLWallpaper().execute(backgroundsURL.get(currentPos),String.valueOf(screenheight),String.valueOf(screenWidth),"Y");
	            	//MediaStore.Images.Media.insertImage(getContentResolver(), chuckNorris.getImage(backgrounds.get(currentPos),screenheight,screenWidth), FileName , FileName);
		            
	            }
		        Toast.makeText(SetWallpaper.this, "Saved Successfully !!!",
				Toast.LENGTH_SHORT).show();
	            
	            output.flush();
	            output.close();
	        } catch (Exception e) {
	        	Dialog d = new Dialog(this);
	        	TextView tv = new TextView(this);
	        	tv.setText("Error Details : "+e);
	        	LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
						(screenWidth -100), (screenWidth-100) / 2, 1);
	        	d.addContentView(tv, param);
	        	d.show();
				Toast.makeText(SetWallpaper.this, "Oh, can't save image to sdcard right now "+e,
						Toast.LENGTH_SHORT).show();
		           e.printStackTrace();
		    }
		
		
	}

	
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		  LinearLayout bmImage;

		  public DownloadImageTask(LinearLayout bmImage) {
		      this.bmImage = bmImage;
		  }

		  @Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progDialog= new ProgressDialog(SetWallpaper.this,R.style.MyTheme);
			progDialog.setMessage("Please Wait, Loading the Image..");
			progDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
			progDialog.setIndeterminate(true);
			progDialog.show();
		}
		  protected Bitmap doInBackground(String... urls) {
			  Process.setThreadPriority(Process.THREAD_PRIORITY_MORE_FAVORABLE);
		      String urldisplay = urls[0];
		      Bitmap scaledBitmap = null;
		      try {
		    	BitmapFactory.Options options = new BitmapFactory.Options();
		    	options.inJustDecodeBounds = true;
		    	InputStream in = new java.net.URL(urldisplay).openStream();
		    	BitmapFactory.decodeStream(in, null, options);
		    	in.close();
		    	// Calculate inSampleSize
			    options.inSampleSize = calculateInSampleSize(options, screenWidth, screenheight);
			    options.inJustDecodeBounds = false;
			    InputStream in1 = new java.net.URL(urldisplay).openStream();
			    scaledBitmap = BitmapFactory.decodeStream(in1, null, options);
		      } catch (Exception e) {
		          Log.e("Error", e.getMessage());
		          e.printStackTrace();
		      }
		      return scaledBitmap;
		  }

		  @SuppressLint("NewApi")
		protected void onPostExecute(Bitmap result) {
			  Drawable d = new BitmapDrawable(getResources(),result);
		      bmImage.setBackground(d);
		      progDialog.dismiss();
		  }
		}
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}
	private Handler chuckFinishedHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SUCCESS:
				Toast.makeText(SetWallpaper.this, "Wallpaper set",
						Toast.LENGTH_SHORT).show();
				break;
			case FAIL:
				Toast.makeText(SetWallpaper.this,
						"Uh oh, can't do that right now", Toast.LENGTH_SHORT)
						.show();
				break;
			default:
				super.handleMessage(msg);
			}
		}
	};
	
}
