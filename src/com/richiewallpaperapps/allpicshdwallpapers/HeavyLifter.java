package com.richiewallpaperapps.allpicshdwallpapers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * <b>This class uses Threads</b> An alternative to this class would be to use
 * an ASyncTask
 * 
 * @author blundell
 * 
 */
public class HeavyLifter {

	public static final int SUCCESS = 0;
	public static final int FAIL = 1;

	private final Context context;
	private final Handler callback;
	private WallpaperManager manager;
	private int screenWidth = 0;
	private int screenheight = 0;

	/**
	 * Setup the HeavyLifter
	 * 
	 * @param context
	 *            the context we are running in - typically an activity
	 * @param callback
	 *            the handler you want to be notified when we finish doing an
	 *            operation
	 */
	@SuppressLint("ServiceCast")
	public HeavyLifter(Context context, Handler callback) {
		this.context = context;
		this.callback = callback;
		try {
			this.manager = (WallpaperManager) context
					.getSystemService(Context.WALLPAPER_SERVICE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e("CoughtException", "Erroorrr" + e);
		}
	}

	/**
	 * Takes a resource id of a file within our /res/drawable/ folder<br/>
	 * It then spawns a new thread to do its work on<br/>
	 * The reource is decoded and converted to a byte array<br/>
	 * This array is passed to the system which can use it to set the phones
	 * wallpaper<br/>
	 * Upon completion the callback handler is sent a message with eith
	 * {@link HeavyLifter#SUCCESS} or {@link HeavyLifter#FAIL}
	 * 
	 * @param resourceId
	 *            id of a file within our /res/drawable/ folder
	 */
	public void setResourceAsWallpaper(final int resourceId,
			final int screenHeight, final int screenWidth) {
		new Thread() {
			@Override
			public void run() {
				try {
					manager.setBitmap(getImage(resourceId, screenHeight,
							screenWidth));
					manager.setWallpaperOffsetSteps(1, 1);
					manager.suggestDesiredDimensions(screenWidth, screenHeight);

					callback.sendEmptyMessage(SUCCESS);
				} catch (IOException e) {
					Log.e("Main", "Cant set wallpaper");
					callback.sendEmptyMessage(FAIL);
				} catch (Exception e) {
						
					Log.e("Main", "Some other exception" + e);
					callback.sendEmptyMessage(FAIL);
				}
			}
		}.start();
	}

	/**
	 * Decodes a resource into a bitmap, here it uses the convenience method
	 * 'BitmapFactory.decodeResource', but you can decode using alternatives
	 * these will give you more control over the size and quality of the
	 * resource. You may need certain size resources within each of your /hdpi/
	 * /mdpi/ /ldpi/ folders in order to have the quality and look you want on
	 * each different phone.
	 */
	public Bitmap getImage(int resourceId, int screenHeight, int screenWidth) {
		Bitmap scaledBitmap = null;
		Log.d("Resource Id : ", " " + resourceId);
		Log.d("Screen height : ", " " + screenHeight);
		Log.d("Screen width :", " " + screenWidth);
		if (screenHeight <= 0 || screenWidth <= 0) {
			screenHeight = manager.getDesiredMinimumHeight();
			screenWidth = manager.getDesiredMinimumWidth();
		}
		try {
			Bitmap bitmap = BitmapFactory.decodeResource(
					context.getResources(), resourceId, null);
			scaledBitmap = Bitmap.createScaledBitmap(bitmap, screenWidth,
					screenHeight, true);

			bitmap.recycle();
			bitmap = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			Log.e("Error in get Image Method ", ": " + e);
			e.printStackTrace();
		}

		return scaledBitmap;
	}

	public class SetImageURLWallpaper extends AsyncTask<String, Void, Bitmap> {
		 // LinearLayout bmImage;

		 /* public SetImageURLWallpaper(LinearLayout bmImage) {
		      this.bmImage = bmImage;
		  }
*/
		  protected Bitmap doInBackground(String... urls) {
			  String urldisplay = urls[0];
		      String height = urls[1];
		      String width = urls[2];
		      String save = urls[3];
		      screenheight = Integer.parseInt(height);
		      screenWidth = Integer.parseInt(width);
		      Bitmap mIcon11 = null;
		      Bitmap scaledBitmap = null;
		      try {
			    	  if (screenheight <= 0 || screenWidth <= 0) {
			    		  	screenheight = manager.getDesiredMinimumHeight();
			  				screenWidth = manager.getDesiredMinimumWidth();
			  			}
		        InputStream in = new java.net.URL(urldisplay).openStream();
		        mIcon11 = BitmapFactory.decodeStream(in);
		        scaledBitmap = Bitmap.createScaledBitmap(mIcon11, screenWidth, screenheight, true);
		        manager.setBitmap(scaledBitmap);
		        manager.setWallpaperOffsetSteps(1, 1);
				manager.suggestDesiredDimensions(screenWidth, screenheight);
				
				if(save.equals("Y"))
				{
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
				        File file = new File(dir, "AllPics"+Math.random()/1000+".jpg" );

				        try {

				            output = new FileOutputStream(file);

				            // Compress into png format image from 0% - 100%
				            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
				            
				            Toast.makeText(context, "Saved Successfully !!!",
							Toast.LENGTH_SHORT).show();
				            
				            output.flush();
				            output.close();
				        } catch (Exception e) {
							Toast.makeText(context, "Oh, can't save image to sdcard right now "+e,
									Toast.LENGTH_SHORT).show();
					           e.printStackTrace();
					    }
				}
		        mIcon11.recycle();
		        mIcon11 = null;
		      } catch (Exception e) {
		          Log.e("Error", "Error detail"+e);
		          e.printStackTrace();
		      }
		      return scaledBitmap;
		  }

		  @SuppressLint("NewApi")
		protected void onPostExecute(Bitmap result) {
			  try {
					manager.setBitmap(result);
					callback.sendEmptyMessage(SUCCESS);
				} catch (IOException e) {
					Log.e("Main", "Cant set wallpaper");
					callback.sendEmptyMessage(FAIL);
				} catch (Exception e) {
						
					Log.e("Main", "Some other exception" + e);
					callback.sendEmptyMessage(FAIL);
				}
		  }
		}
}