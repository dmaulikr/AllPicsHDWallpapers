package com.richiewallpaperapps.allpicshdwallpapers;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.richiewallpaperapps.allpicshdwallpapers.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class MyMainActivity extends Activity {

	// TextView welComeTxt=(TextView) findViewById(R.id.welcome);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		setContentView(R.layout.activity_main);
		// welComeTxt.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,
		// android.R.anim.slide_in_left));

		// Look up the AdView as a resource and load a request.
	    AdView adView = (AdView) this.findViewById(R.id.adView);
	    AdRequest adRequest = new AdRequest.Builder().build();
	    adView.loadAd(adRequest);
	    
	    
		Thread bgtimer = new Thread() {
			@Override
			public void run() {
				try {
					sleep(5000);
					Intent menuIntent = new Intent(
							"com.richie.allpicshdwallpapers.MENU");
					startActivity(menuIntent);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NullPointerException e) {
					// TODO: handle exception
					Log.e("Menu", "Null Pointer exception");
					Log.d("Menu", "Exception Details" + e);
				} catch (Exception e) {
					Log.e("Menu", "Some other exception");
					Log.d("Menu", "Exception Details" + e);

				} finally {
					finish();
				}
			}
		};
		bgtimer.start();
	}

}
