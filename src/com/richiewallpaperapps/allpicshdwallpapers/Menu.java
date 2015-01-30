package com.richiewallpaperapps.allpicshdwallpapers;

import java.io.InputStream;
import java.util.ArrayList;

import com.richiewallpaperapps.allpicshdwallpapers.R;
import com.richiewallpaperapps.allpicshdwallpapers.HeavyLifter;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class Menu extends Activity implements OnClickListener{
	/**
	 * A list containing the resource identifiers for all of our selectable
	 * backgrounds
	 */
	private static final ArrayList<Integer> backgrounds = new ArrayList<Integer>();
	private static final ArrayList<String> backgroundDrawable = new ArrayList<String>();
	private static int errorCount=0; 
	private Boolean isError=false;
	/** The total number of backgrounds in the list */
	private static final int TOTAL_IMAGES;
	/**
	 * Instantiate the list statically, so this will be done once on app load,
	 * also calculate the total number of backgrounds
	 */
	static {
		backgrounds.add(R.drawable.pop1);
		backgrounds.add(R.drawable.pop2);
		backgrounds.add(R.drawable.pop3);
		backgrounds.add(R.drawable.pop4);
		backgrounds.add(R.drawable.pop5);
		backgrounds.add(R.drawable.pop6);
		backgrounds.add(R.drawable.pop7);
		backgrounds.add(R.drawable.pop8);
		backgrounds.add(R.drawable.pop9);
		backgrounds.add(R.drawable.pop10);
		backgrounds.add(R.drawable.pop11);
		backgrounds.add(R.drawable.pop12);
		backgrounds.add(R.drawable.pop13);
		backgrounds.add(R.drawable.pop14);
		backgrounds.add(R.drawable.pop15);
		backgrounds.add(R.drawable.pop16);
		backgrounds.add(R.drawable.pop17);
		backgrounds.add(R.drawable.pop18);
		backgrounds.add(R.drawable.pop19);
		backgrounds.add(R.drawable.cp25);
		backgrounds.add(R.drawable.cp54);
		backgrounds.add(R.drawable.cp44);
		backgrounds.add(R.drawable.cp51);
		backgrounds.add(R.drawable.lv10);
		backgrounds.add(R.drawable.lv14);
		backgrounds.add(R.drawable.cn22);
		backgrounds.add(R.drawable.cp1);
		backgrounds.add(R.drawable.cn19);
		backgrounds.add(R.drawable.cn29);
		backgrounds.add(R.drawable.cp46);
		backgrounds.add(R.drawable.cl45);
		backgrounds.add(R.drawable.cn7);
		backgrounds.add(R.drawable.cl13);
		backgrounds.add(R.drawable.cp36);
		backgrounds.add(R.drawable.cp21);
		backgrounds.add(R.drawable.lv40);
		backgrounds.add(R.drawable.lv52);
		backgrounds.add(R.drawable.cp1);
		backgrounds.add(R.drawable.gd2);
		backgrounds.add(R.drawable.cp78);
		backgrounds.add(R.drawable.cn44);
		backgrounds.add(R.drawable.cl7);
		backgrounds.add(R.drawable.cl44);
		backgrounds.add(R.drawable.cl28);
		backgrounds.add(R.drawable.cl8);
		backgrounds.add(R.drawable.lv28);
		backgrounds.add(R.drawable.cp31);
		backgrounds.add(R.drawable.cp52);
		backgrounds.add(R.drawable.cp67);
		backgrounds.add(R.drawable.cp80);
		TOTAL_IMAGES = (backgrounds.size() - 1);
	}
	/** the state of what wallpaper is currently being previewed */
	private int currentPosition = 0;
	/** our image wallpaper preview */
	/**
	 * A helper class that will do the heavy work of decoding images and
	 * actually setting the wallpaper
	 */
	private HeavyLifter chuckNorris;

	private ImageButton[] popIV;
	private LinearLayout scrollableImageLayout;
	private LinearLayout[] imagesLayout;
	private LinearLayout myLayout;
	private Spinner wallCatagory;
	public int screenWidth;
	public int screenheight;
	private Boolean flag = false;
	private int layoutIndex = 1;
	private int backgraoundSize = 0;
	private Boolean isAsyncTaskRunning=false;
	CheckConnectivity check;
	Boolean conn;
	/**
	 * A helper class that will do the heavy work of decoding images and
	 * actually setting the wallpaper
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		/*requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		setContentView(R.layout.menu);
		  // Create the interstitial.
		
		check = new CheckConnectivity();
	    conn = check.checkNow(this.getApplicationContext());

		
		scrollableImageLayout = (LinearLayout) findViewById(R.id.scrollableImageLayout);
		myLayout =  (LinearLayout) findViewById(R.id.edtLinearLayout);
		DisplayMetrics metrics = this.getResources().getDisplayMetrics();
		screenWidth = metrics.widthPixels;
		screenheight = metrics.heightPixels;
		wallCatagory = (Spinner) findViewById(R.id.wallPaperSelector);
		ArrayAdapter mySpinnerAdpt = (ArrayAdapter) wallCatagory.getAdapter();
		int spinnerPos = mySpinnerAdpt.getPosition("Most Popular");
		wallCatagory.setSelection(spinnerPos);
		selectedWallPaperCatagory();
		backgraoundSize = backgrounds.size();
		

	}

	private void selectedWallPaperCatagory() {
		// TODO Auto-generated method stub
		wallCatagory.setOnItemSelectedListener(new OnItemSelectedListener() {

			@SuppressLint("NewApi")
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if (wallCatagory.getSelectedItem().equals("The Vampire Diaries (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://pu.i.wp.pl/k,NjI5MTA5NzMsNDgyMTkwNjA=,f,Vampire_Diaries.jpg");
						backgroundDrawable.add("http://wallpaper.pickywallpapers.com/iphone4/the-vampire-diaries-3.jpg");
						backgroundDrawable.add("http://worldgsm.pl/tapety/000037d591563a4/6f141d61731e5b3.jpg");
						backgroundDrawable.add("http://www4.images.coolspotters.com/wallpapers/79144/the-vampire-diaries-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://images5.fanpop.com/image/photos/24800000/mobile-wallpaper-delena-24867407-320-480.jpg");
						backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/145236/the-vampire-diaries-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://lh3.ggpht.com/ScqwgI03A6nZfU7jdmwtv6q8YHPrmcJKDRwj-Dd1MUYVK1Jf44f3esLTm5KC4XuhYNguEjGuUaLJ-R0LvIoT-g");
						backgroundDrawable.add("http://wallpoper.com/images/00/04/48/97/damon-elena-stefan_00044897.jpg");
						backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/124881/the-vampire-diaries-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://www4.images.coolspotters.com/wallpapers/124970/the-vampire-diaries-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://www.timepasssms.com/images/big/Entertainment/big_Vampire_Diaries_Entertainment1315915970.jpg");
						backgroundDrawable.add("http://images2.fanpop.com/image/photos/9400000/Wallpaper-phone-the-vampire-diaries-9450130-240-400.jpg");
						backgroundDrawable.add("http://mobi-wall.brothersoft.com/files/240400/v/1283469500425.jpg");
						backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/109666/the-vampire-diaries-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://www4.images.coolspotters.com/wallpapers/1585/the-vampire-diaries-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/08/45/14/the-vampire-diaries_00084514.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/1315252575_The_Vampire_Diaries.jpg");
						backgroundDrawable.add("http://vampirediariesonline.com/wp-content/uploads/2010/09/vampire-diaries-season-2-nina-dobrev.png");
						backgroundDrawable.add("http://wallpoper.com/images/00/08/82/01/vampire-diaries_00088201.jpg");
						backgroundDrawable.add("http://images.buddytv.com/btv_2_1000014885_1_434_593_0_/nina-dobrev-in--the-.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/08/97/75/the-vampire-diaries_00089775.jpg");
						backgroundDrawable.add("http://vampirediariesonline.com/wp-content/uploads/2009/12/candice-accola-2.png");
						backgroundDrawable.add("http://vampirediariesguide.com/wp-content/uploads/2012/11/118.jpg");
						backgroundDrawable.add("http://images6.fanpop.com/image/photos/34300000/Love-is-a-vampire-s-Greatest-Weakness-Klaus-Caroline-in-The-Vampire-Diaries-klaus-and-caroline-34365125-459-750.jpg");
						backgroundDrawable.add("http://www.blastr.com/sites/blastr/files/styles/blog_post_media/public/VampireDiaries-klaus-caroline_0.jpg?itok=oUQTfjeH");
						backgroundDrawable.add("http://images5.fanpop.com/image/photos/24800000/mobile-wallpaper-the-vampire-diaries-24867374-320-480.jpg");
						backgroundDrawable.add("http://images5.fanpop.com/image/photos/28200000/Klaus-Caroline-klaus-and-caroline-28278481-500-428.gif");
						
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				} else if (wallCatagory.getSelectedItem().equals("Smile Please!")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgrounds.add(R.drawable.sp1);
					backgrounds.add(R.drawable.sp2);
					backgrounds.add(R.drawable.sp3);
					backgrounds.add(R.drawable.sp4);
					backgrounds.add(R.drawable.sp5);
					backgrounds.add(R.drawable.sp6);
					backgrounds.add(R.drawable.sp7);
					backgrounds.add(R.drawable.sp8);
					backgrounds.add(R.drawable.sp9);
					backgrounds.add(R.drawable.sp10);
					backgrounds.add(R.drawable.sp11);
					backgrounds.add(R.drawable.sp12);
					backgrounds.add(R.drawable.sp13);
					backgrounds.add(R.drawable.sp14);
					backgrounds.add(R.drawable.sp15);
					backgrounds.add(R.drawable.sp16);
					backgrounds.add(R.drawable.sp17);
					backgrounds.add(R.drawable.sp18);
					backgrounds.add(R.drawable.sp19);
					backgrounds.add(R.drawable.sp20);
					backgrounds.add(R.drawable.sp21);
					backgrounds.add(R.drawable.sp22);
					backgrounds.add(R.drawable.sp23);
					backgrounds.add(R.drawable.sp24);
					backgrounds.add(R.drawable.sp25);
					backgrounds.add(R.drawable.sp26);
					backgrounds.add(R.drawable.sp27);
					backgrounds.add(R.drawable.sp28);
					backgrounds.add(R.drawable.sp24);
					backgrounds.add(R.drawable.bh1);
					backgrounds.add(R.drawable.bh2);
					backgrounds.add(R.drawable.bh3);
					backgrounds.add(R.drawable.bh4);
					backgrounds.add(R.drawable.bh5);
					backgrounds.add(R.drawable.bh6);
					backgrounds.add(R.drawable.bh7);
					backgrounds.add(R.drawable.bh8);
					backgrounds.add(R.drawable.bh9);
					backgrounds.add(R.drawable.bh10);
					backgrounds.add(R.drawable.bh11);
					backgrounds.add(R.drawable.bh12);
					backgrounds.add(R.drawable.bh13);
					backgrounds.add(R.drawable.bh14);
					backgraoundSize = backgrounds.size();
					layoutIndex = 1;
					createImageButton();
				} else if (wallCatagory.getSelectedItem().equals("Cartoon")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgrounds.add(R.drawable.cn1);
					backgrounds.add(R.drawable.cn2);
					backgrounds.add(R.drawable.cn3);
					backgrounds.add(R.drawable.cn4);
					backgrounds.add(R.drawable.cn5);
					backgrounds.add(R.drawable.cn6);
					backgrounds.add(R.drawable.cn7);
					backgrounds.add(R.drawable.cn8);
					backgrounds.add(R.drawable.cn9);
					backgrounds.add(R.drawable.cn10);
					backgrounds.add(R.drawable.cn11);
					backgrounds.add(R.drawable.cn12);
					backgrounds.add(R.drawable.cn13);
					backgrounds.add(R.drawable.cn14);
					backgrounds.add(R.drawable.cn15);
					backgrounds.add(R.drawable.cn16);
					backgrounds.add(R.drawable.cn17);
					backgrounds.add(R.drawable.cn18);
					backgrounds.add(R.drawable.cn19);
					backgrounds.add(R.drawable.cn20);
					backgrounds.add(R.drawable.cn21);
					backgrounds.add(R.drawable.cn22);
					backgrounds.add(R.drawable.cn23);
					backgrounds.add(R.drawable.cn24);
					backgrounds.add(R.drawable.cn25);
					backgrounds.add(R.drawable.cn26);
					backgrounds.add(R.drawable.cn27);
					backgrounds.add(R.drawable.cn28);
					backgrounds.add(R.drawable.cn29);
					backgrounds.add(R.drawable.cn30);
					backgrounds.add(R.drawable.cn31);
					backgrounds.add(R.drawable.cn32);
					backgrounds.add(R.drawable.cn33);
					backgrounds.add(R.drawable.cn34);
					backgrounds.add(R.drawable.cn35);
					backgrounds.add(R.drawable.cn36);
					backgrounds.add(R.drawable.cn38);
					backgrounds.add(R.drawable.cn39);
					backgrounds.add(R.drawable.cn40);
					backgrounds.add(R.drawable.cn41);
					backgrounds.add(R.drawable.cn42);
					backgrounds.add(R.drawable.cn43);
					backgrounds.add(R.drawable.cn44);
					backgrounds.add(R.drawable.cn45);
					backgrounds.add(R.drawable.cn46);
					backgraoundSize = backgrounds.size();
					layoutIndex = 1;
					createImageButton();
				} else if (wallCatagory.getSelectedItem().equals("Art (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
							backgroundDrawable.add("http://www.streetartutopia.com/wp-content/uploads/2012/04/street_art_yarn_crochet_1.jpeg");
							backgroundDrawable.add("http://ladena.bg/wp-content/uploads/2013/12/yarn-bomb-bike.jpg");
							backgroundDrawable.add("http://www.thisiscolossal.com/wp-content/uploads/2013/10/squid-2.jpg");
							backgroundDrawable.add("http://ahrcnyc.files.wordpress.com/2010/10/art-show-pratt1.jpg");
							backgroundDrawable.add("http://ipicturee.com/wp-content/uploads/2013/10/Abstract-Digital-Art-HD-Wallpaper.jpg");
							backgroundDrawable.add("http://media.newindianexpress.com/article1279842.ece/alternates/w460/United-Colours-of-Art.jpg");
							backgroundDrawable.add("http://inseaadvocacy.files.wordpress.com/2013/05/arts2.jpg");
							backgroundDrawable.add("http://www.wcfe.ie/jcms/images/stories/coursephotos/images2013/art.jpg");
							backgroundDrawable.add("http://www.revista-atelierul.ro/wp-content/uploads/2012/05/paints-box-hd-wallpapers-2012.jpg");
							backgroundDrawable.add("http://shedsenn.files.wordpress.com/2012/06/sucha-lefty-brain-art.jpg");
							backgroundDrawable.add("http://www.whitegadget.com/attachments/pc-wallpapers/86010d1320816131-art-art-pics.jpg");
							backgroundDrawable.add("http://capturexp.ca/wp-content/gallery/art-basel/art-basel-switzerland-2009-00.jpg");
							backgroundDrawable.add("http://upload.wikimedia.org/wikipedia/commons/9/9e/Landmark_Arts_Centre,_Teddington_P6220013.jpg");
							backgroundDrawable.add("http://diycozyhome.com/wp-content/uploads/2013/08/stunning-egg-shell-art.jpg");
							backgroundDrawable.add("http://tameraseeversstudios.com/wp-content/uploads/2010/10/Goose-Eggs1.jpg");
							backgroundDrawable.add("http://graphics8.nytimes.com/images/2013/06/14/arts/14BRICK_SPAN/14BRICK-articleLarge.jpg");
							backgroundDrawable.add("http://www.streetartutopia.com/wp-content/uploads/2012/11/Street-Art-by-David-Walker-in-London-England-mini.jpeg");
							backgroundDrawable.add("http://www.ubc.ca/okanagan/fccs/__shared/assets/VisualArts-FCCS-slide34982.jpg");
							backgroundDrawable.add("http://www.malatintamagazine.com/wp-content/uploads/2014/01/Lego-1.jpg");
							backgroundDrawable.add("http://www.bravotv.com/media/imagecache/640x360/images/hero/2013/03/Work-Of-Art-season-2-Inside-the-Artists-Studio-Hero.jpg");
							backgroundDrawable.add("http://lytum.com/wp-content/uploads/2013/04/10-Art-designs-very-beautiful-for-computer-creations-2013.jpg");
							backgroundDrawable.add("http://wallpapertoon.com/wp-content/uploads/2014/03/michael-jackson-art-hd-wallpapers.jpg");
							backgroundDrawable.add("http://ijuney.files.wordpress.com/2012/07/art2.jpg");
							backgroundDrawable.add("http://sg.hu/kep/2014_02/02043dkiallitas9.jpg");
							backgroundDrawable.add("http://www.hdwallpaperscool.com/wp-content/uploads/2013/11/art-kids-love-phots-desktop-children-best-wallpapers-hd-fullscreen.jpg");
							backgroundDrawable.add("http://freesoftwarekit.com/server13/photos/y2lLP1geuxRiXM~/179648_Donald-Zolan-Paintings-Wallpapers-Art-Desktop_1600x1200.jpg");
							backgroundDrawable.add("http://dl.bizhi.sogou.com/images/2012/05/12/13154.jpg");
							backgroundDrawable.add("http://www.artwallpaper.eu/wallpaper/wp-content/uploads/2013/04/15/1618/painting-hd-wallpaper-art.jpg");
							backgroundDrawable.add("http://www.lovethispic.com/uploaded_images/35470-Autumn-Abstract-Painting.jpg");
							backgroundDrawable.add("http://freewallpapersbackgrounds.com/server13/photos/PO7f7sAL3Qz_BM~/208487_Autumn-Oil-Painting-Leonid-Afremov-Wallpaper-1454x1064-33626_1454x1064.jpg");
							backgroundDrawable.add("http://ih3.redbubble.net/image.8868672.4409/flat,550x550,075,f.jpg");
							backgroundDrawable.add("http://ih2.redbubble.net/image.12113532.8040/flat,550x550,075,f.jpg");
							backgroundDrawable.add("https://lh6.googleusercontent.com/-PTJFtY8uxyA/TmKhRfYWY6I/AAAAAAAAAE4/PtqlJpMuWf4/w426-h311/wallpaper-406800.jpg");
							backgroundDrawable.add("http://fc05.deviantart.net/fs71/i/2012/234/3/5/flamenco_dancer___leonid_afremov_by_leonidafremov-d5c2x0b.jpg");
							backgroundDrawable.add("http://uniquehomeriview.com/wp-content/uploads/2014/03/painting-art-wallpaperwallpapers-barcelona-city-ladies-paintings-art-painting-hd-vcgxmyg4.jpg");
							backgroundDrawable.add("http://4.bp.blogspot.com/-xwAd2gCcJWI/TqZIzvy1xbI/AAAAAAAAB6g/8UmuG4UmQG0/s320/SUNNY_RAIN___LEONID_AFREMOV_by_Leonidafremov.jpg");
							backgroundDrawable.add("http://www.wallpaperhi.com/thumbnails/detail/20120804/paintings%20frogs%20artwork%201920x1080%20wallpaper_www.wallpaperhi.com_73.jpg");
							backgroundDrawable.add("http://blog.mann-ivanov-ferber.ru/wp-content/uploads/2014/04/%D0%B4%D0%B8%D1%82%D1%8F.jpg");
							backgroundDrawable.add("http://www.wallsave.com/wallpapers/1920x1200/jesus/1792549/jesus-christ-art-painting-hd-1792549.jpg");
							backgroundDrawable.add("http://www.wallpapershdi.com/wallpaper-original/wallpapers/jesus-wallpaper-2085.jpg");
							backgroundDrawable.add("http://cdnimg.visualizeus.com/thumbs/ec/47/fine,art,doll,illustration,art,ballet,paintings-ec47e3c08403369a5cfc27f958b076db_h.jpg");
							backgroundDrawable.add("https://lh6.googleusercontent.com/-G-rtt6nVH9A/UYyNBArp9kI/AAAAAAAAALM/2jFILe3fy5I/s150-c/photo.jpg");
							backgroundDrawable.add("http://lunar.thegamez.net/kidsroomdesign/wall-art-for-kids-rooms/kids-art-prints-art-wall-and-posters-wall-murals-buy-a-poster-1920x1200.jpg");
							backgroundDrawable.add("http://www.hdwallpapersin.com/files/submissions/Girl_Child_Wreath_Art_HD_Wallpaper_973192242.jpg");
							backgroundDrawable.add("http://www.td-pk.ru/files/pub/praga/tree.jpg");
							backgroundDrawable.add("http://100in1day.ca/halifax/wp-content/uploads/2014/03/P.1_Yarn-Bombing-Flowers-on-fence.jpg");
							backgroundDrawable.add("http://iliketowastemytime.com/sites/default/files/creative-graffiti-world-17.jpg");
								
							backgraoundSize = backgroundDrawable.size();
							layoutIndex=1;
							createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
					
				}
				 else if (wallCatagory.getSelectedItem().equals("Cars (Web)")) {
						scrollableImageLayout.removeAllViews();
						backgrounds.clear();
						backgroundDrawable.clear();
						if(conn == true){
					          //run your normal code path here
							//Log.i("Connection Startus", "Internet connection is proper");
							//connectivityMessage("Internet is working!please wait, image are loading."); 
							backgroundDrawable.add("http://cdn.jaxov.com/wp-content/uploads/2012/02/Sports-Car-iPhone-Wallpaper.jpg");
							backgroundDrawable.add("http://3.bp.blogspot.com/-OnqA6H8cYkg/TntsXwAbLrI/AAAAAAAACQ8/9SFZRc0S6qs/s400/mobile+wallpapers+cars+3.jpg");
							backgroundDrawable.add("http://ilgiliforum.com/resimler/ceptelefonuduvarkagitlari/cep%20telefonu%20duvar%20kagitlari%20240x320%20(82).jpg");
							backgroundDrawable.add("http://www.mypcwallpaper.com/wp-content/uploads/2011/11/car-wallpapers-mobile-2.jpg");
							backgroundDrawable.add("http://www.cellphonewallpapers.us/mobile-phone-wallpapers-pictures/phone/220FQ35G5.gif");
							backgroundDrawable.add("http://media.santabanta.com/wall2009/cars/lamborghini/480x640/lamborghini-7108.jpg");
							backgroundDrawable.add("http://jo-jo.ru/uploads/posts/2012-06/1340981323_walls-iphone-jo-jo.ru-61.jpg");
							backgroundDrawable.add("http://endopakistan.com/wp-content/uploads/2013/09/latest-stylish-car-sony-ericsson-k770i-mobile-phone-wallpaper-1368082304.jpg");
							backgroundDrawable.add("http://4.bp.blogspot.com/-Bavt7n0yHoI/TpHsOOqw77I/AAAAAAAAeu0/F4_qDwgt8yU/s1600/car-wallpapers-for-mobile-5.jpg");
							backgroundDrawable.add("http://endopakistan.com/wp-content/uploads/2013/09/latest-stylish-car-sony-ericsson-k770i-mobile-phone-wallpaper-1368082304.jpg");
							backgroundDrawable.add("http://www.phtheme.com/androidimg/allimg/120619/2-1206191430420-L.jpg");
							backgroundDrawable.add("http://f0.pepst.com/c/E4CCA1/913006/ssc3/home/052/fanfan.screensavers-2011/voiture_rouge.gif_480_480_0_64000_0_1_0.gif");
							backgroundDrawable.add("http://4.bp.blogspot.com/-Bavt7n0yHoI/TpHsOOqw77I/AAAAAAAAeu0/F4_qDwgt8yU/s1600/car-wallpapers-for-mobile-5.jpg");
							backgroundDrawable.add("http://1.bp.blogspot.com/-ZmxsZ2JTMeI/UFW_evnHzjI/AAAAAAAAAf4/KUMjfRW0OO0/s1600/Lamborghini%2BCars_35%2B%2528NayyerMobile.com%2529.jpg");
							backgroundDrawable.add("http://www.cellphonewallpapers.us/mobile-phone-wallpapers-pictures/mobile/16400Q23059.jpg");
							backgroundDrawable.add("http://www.hdiphonewallpapers.us/phone-wallpapers/mobilewallpaper/1293V923191F-21622.jpg");
							backgroundDrawable.add("http://1.bp.blogspot.com/-5heCe4f9y1g/UQ_1At09_rI/AAAAAAAAFmk/HQcpzpW7KlU/s320/mazda-car-mobile-wallpapers.jpg");
							backgroundDrawable.add("http://www.funshun.com/mobile/data/wall/bikes-mobile-wallpaper-(funshun.com)4763.jpg");
							backgroundDrawable.add("http://www.techagesite.com/Animated%20phone%20wallpapers/Animated-cell-phone-wallpaper-240x320-black-car.gif");
							backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/sports_wallpapers/preview/30/33345-animated-car.jpg");
							backgroundDrawable.add("http://iphonecarbackgrounds.com/img/samsung-galaxy-cars/samsung-galaxy-ace-plus-wallpapers-mobile-phones.jpg");
							backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/automotive_wallpapers/preview/93/33789-fire-car.jpg");
							backgroundDrawable.add("http://www.mobile-phone.pk/images/wallpapers/super_car_cars_mobile_wallpaper.jpg");
							backgroundDrawable.add("http://www.mypcwallpaper.com/wp-content/uploads/2011/11/car-wallpapers-mobile-2.jpg");
							backgroundDrawable.add("http://www.hdwallpaperbackground.com/uploads/allimg/130702/Various%20cars%20mobile%20hd%20free%20wallpapers%20downloads%202_480x854.jpg");
							backgroundDrawable.add("http://www.obilesky.com/wallpapers/allimg/c110130/1296361RK2U0-14Z9_lit.jpg");
							backgroundDrawable.add("http://www.mobilephun.com/wp-content/uploads/2009/10/Furrari-Car-Wallpaper.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-24990.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-25364.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-23390.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-22249.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-19516.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-19481.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-19596.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-22819.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-14586.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-14414.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-14774.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/artfoto-avto-bmv_bmw-dozhd-transport-14850.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-15812.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-19426.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-18085.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-9616.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-dorogi-transport-17741.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-mosty-transport-17748.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-13306.jpg");
							backgroundDrawable.add("http://images.mob.org/pic/gallery/111x185/avto-bmv_bmw-transport-11023.jpg");
								
							backgraoundSize = backgroundDrawable.size();
							layoutIndex=1;
							createImageButtonForURL();
					     }
					     else{
					          //Send a warning message to the user
								Log.i("Connection Startus", "Internet connection is not proper");
					          connectivityMessage("Internet is not working,Please check your network connection."); 
					      }
						
					} else if (wallCatagory.getSelectedItem().equals("Actors (Web)")) {
						scrollableImageLayout.removeAllViews();
						backgrounds.clear();
						backgroundDrawable.clear();
						if(conn == true){
					          //run your normal code path here
							//Log.i("Connection Startus", "Internet connection is proper");
							//connectivityMessage("Internet is working!please wait, image are loading."); 
							backgroundDrawable.add("http://robertpattinsonuk.com/wp-content/uploads/2012/12/0245.jpg");
							backgroundDrawable.add("http://2.bp.blogspot.com/_Po_ieQp6ijA/TSwLTWXITHI/AAAAAAAAAP8/9xhbbhk8zMY/s1600/Zac_Efron.jpg");
							backgroundDrawable.add("http://fonepics.net/uploads/pictures/big_images/1330599213_zac_efron.jpg");
							backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/1315258549_Brad_Pitt.jpg");
							backgroundDrawable.add("http://freemobzone.com/Wallpapers/Wallpapers/Bollywood/Actors/R/Ranbir%20Kapoor/Ranbir%20Kapoor%20(16)(MobileWap.Mobi).jpg");
							backgroundDrawable.add("http://mobiwallpapers.net/uploads/pictures/big_images/34185-tom-cruise.jpg");
							backgroundDrawable.add("http://www4.images.coolspotters.com/wallpapers/969/brad-pitt-mobile-wallpaper.jpg");
							backgroundDrawable.add("http://wallpaperpassion.com/upload_big_thumb/23707/robert-pattinson-look-wallpaper.jpg");
							backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/1681/tom-cruise-mobile-wallpaper.jpg");
							backgroundDrawable.add("http://m.img.brothersoft.com/android/85/859c0238788d69ec498ca701ff343bd9_screen0.jpg");
							backgroundDrawable.add("http://www4.images.coolspotters.com/wallpapers/94026/zac-efron-mobile-wallpaper.jpg");
							backgroundDrawable.add("http://www4.images.coolspotters.com/wallpapers/135273/tom-cruise-mobile-wallpaper.jpg");
							backgroundDrawable.add("http://3.bp.blogspot.com/-E27wkEDvINA/UKezDa6Q9hI/AAAAAAAAHXA/f-MGjGPbkeY/s1600/zac-efron-hq-wallpaper.jpg");
							backgroundDrawable.add("http://1.bp.blogspot.com/_qB9TcUQzp0M/TJ33YNqcTFI/AAAAAAAABJk/Z_U4TT8X1gU/s1600/Ranbir_Kapoor(7).jpg");
							backgroundDrawable.add("http://www.imnotobsessed.com/wp-content/uploads/hot-guy-of-the-day2012-09-05_07-26-15bradley-cooper.jpg");
							backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/Brad_Pitt.jpg");
							backgroundDrawable.add("http://i1.ytimg.com/vi/bKSvAmZ82vA/hqdefault.jpg");
							backgroundDrawable.add("http://wallpoper.com/images/00/02/69/49/salman-khan_00026949.jpg");
							backgroundDrawable.add("http://2.bp.blogspot.com/-k1de6kTey-Y/URzZDNVNIFI/AAAAAAAACIE/JsGvUbJMu6A/s400/hollywood+celebrities+wallpapers+26.jpg");
							backgroundDrawable.add("http://www.mypcwallpaper.com/wp-content/uploads/2011/10/salman-khan-wallpaper-for-mobile3.jpg");
							backgroundDrawable.add("http://m.img.brothersoft.com/android/85/859c0238788d69ec498ca701ff343bd9_screen1.jpg");
							backgroundDrawable.add("http://media-cache-ec0.pinimg.com/236x/2a/01/1d/2a011db497c4522388e9e779e4e4e8c3.jpg");
							backgroundDrawable.add("http://3.bp.blogspot.com/-y2YRzRxvaI4/US5N__WWVJI/AAAAAAAAC7Y/_cbb1Mlil1c/s1600/Salman_Khan+(19).jpg");
							backgroundDrawable.add("http://4.bp.blogspot.com/-sP3ceFUSTbA/TpwityHUdMI/AAAAAAAAAZE/h6U8SCtp9Xo/s1600/shha.jpg");
							backgroundDrawable.add("http://www.mobileapples.com/Assets/Content/Wallpapers/8010brad%20pitt.jpg");
							backgroundDrawable.add("http://wallpaperpassion.com/upload/3435/hritik-roshan-wallpaper.jpg");
							backgroundDrawable.add("http://content.mobizill.com/wallpapers/images/Ranb5612130355465361250.jpg");
							backgroundDrawable.add("http://2.bp.blogspot.com/-oknkQVEsxdw/TuIRgBixisI/AAAAAAAAP4g/icTpQSy_j-U/s1600/leonardo-dicaprio-mobile-wallpaper.jpg");
							backgroundDrawable.add("http://wallpaperpassion.com/upload_big_thumb/22568/zac-efron-close-up-wallpaper.jpg");
							backgroundDrawable.add("http://cdn8.staztic.com/app/a/1273/1273153/andrew-garfield-wallpaper-919604-1-s-307x512.jpg");
							backgroundDrawable.add("http://wallpaperpassion.com/upload_big_thumb/21541/ranbir-kapoor-wallpaper.jpg");
							backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/124738/ian-somerhalder-mobile-wallpaper.jpg");
							backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/107948/ian-somerhalder-mobile-wallpaper.jpg");
							backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/137841/ian-somerhalder-mobile-wallpaper.jpg");
							backgroundDrawable.add("http://static.hothdwallpaper.net/51b35f98cef6157821.jpg");
							backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/33053/ian-somerhalder-mobile-wallpaper.jpg");
							backgraoundSize = backgroundDrawable.size();
							layoutIndex=1;
							createImageButtonForURL();
					     }
					     else{
					          //Send a warning message to the user
								Log.i("Connection Startus", "Internet connection is not proper");
					          connectivityMessage("Internet is not working,Please check your network connection."); 
					      }
				} else if (wallCatagory.getSelectedItem().equals("Actress (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
						//Log.i("Connection Startus", "Internet connection is proper");
						//connectivityMessage("Internet is working!please wait, image are loading."); 
						backgroundDrawable.add("http://3.bp.blogspot.com/_oalwC3a4OAg/TJYaU4Ub3iI/AAAAAAAABqM/LoH9V-y-qzs/s400/Ashley_Tisdale_mobile_wallpapers.jpg");
						backgroundDrawable.add("http://www.softarina.com/ss/1328062520-screenshot.jpeg");
						backgroundDrawable.add("http://www.savemefromboredom.com/images/ajcook/AJ-Cook-hot.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/-gHgAq7VtqlQ/TZsVg-b2GtI/AAAAAAAABNY/H8fWy9rj418/s1600/Sexiest-Hottest-Hollywood-Actress-Wallpaper2.jpg");
						backgroundDrawable.add("http://www.flixya.com/files-photo/y/o/u/youtv-2026455.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/-fOMgE0pXv20/UdMt7oI97ZI/AAAAAAAAAX4/s8WS1-mO8_A/s320/Jennifer+Lawrence+22.jpg");
						backgroundDrawable.add("http://www.softarina.com/ss1/1338514324-screenshot.jpg");
						backgroundDrawable.add("http://www.freeehdwallpapers.com/wp-content/uploads/2013/12/1.Britney-Spears-Photoshoot.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/-OzfxHgjtAnw/UfkiaGTaLXI/AAAAAAAAD8I/_7thqzFY3aU/s1600/Shailene+Woodley-480x800-hd-wallpaper-for-mobile.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/-CXn78I79--I/UefmH-1kwQI/AAAAAAAAN9g/0IY8n1dXtGg/s640/Drew-Barrymore-image.jpg");
						backgroundDrawable.add("http://wallpaperpassion.com/upload/8772/angelina-jolie-wallpaper.jpg");
						backgroundDrawable.add("http://wallpaperpassion.com/upload/26225/kellie-pickler-cute-wallpaper.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/celebrity_wallpapers/preview/21/54823-angelina-jolie.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/_cf1JYAXoiFU/TQPU6k8DHcI/AAAAAAAAALg/7eBd_gqwhYs/s1600/angelina-jolie-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/-mHD3Lh27Qkk/UJKqGt4Ho-I/AAAAAAAACbA/qLHjx1t5xLo/s1600/HD-Angelina-Jolei-Masti-Wallpaper.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/-iJA9UPy77C0/T5Ge40dkXiI/AAAAAAAAEoU/OyLZ6ldGIUk/s1600/Selena+-Gomez-+Hot+-Photos+8.jpg");
						backgroundDrawable.add("http://www.latintrends.com/wp-content/uploads/2012/08/selena-300x300.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/_EMpWvl4wjFo/S_qzH87Lv0I/AAAAAAAAAYU/0IbabRt-O34/s200/Copy+of+Emma_Watson.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/-Sr2AcJy7Rm4/TkC-7iojQiI/AAAAAAAAABs/2iKOWrK0Ih8/s320/Selena-Gomez-4.jpg");
						backgroundDrawable.add("http://biography123.files.wordpress.com/2012/07/hollywood-actress-wallpaper-mobile-ycti.jpg");
						backgroundDrawable.add("http://download-mobile-wallpapers.com/server13/photos/w7Y07C_-bZi0PM~/24009_Hollywood-actress_360x640.jpg");
						backgroundDrawable.add("http://bgwall.net/wp-content/uploads/2014/01/Keira-Knightley-Top-Hollywood-Actress-Wallpapers-2011-480x768.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/-MWctRbFuq5I/UpCzEoSQ7aI/AAAAAAAADG8/taKloOGJYdc/s1600/bollywood+actress+mobile+wallpaper-8.jpg");
						backgroundDrawable.add("http://wallpaperpassion.com/upload_big_thumb/23213/odette-annable-wallpaper.jpg");
						backgroundDrawable.add("http://wallpaperpassion.com/upload_big_thumb1/35477/actress-jennifer-aniston-wallpaper.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/04/46/98/scarlett-johansson_00044698.jpg");
						backgroundDrawable.add("https://lh4.googleusercontent.com/-equE3kE6LOE/TXzsffXy6rI/AAAAAAAAASE/XHols57NGVM/s400/scarlett+johansson+on+allure+magazine.jpg");
						
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
							Log.i("Connection Startus", "Internet connection is not proper");
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
				} else if (wallCatagory.getSelectedItem().equals("Almighty God")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgrounds.add(R.drawable.gd1);
					backgrounds.add(R.drawable.gd2);
					backgrounds.add(R.drawable.gd3);
					backgrounds.add(R.drawable.gd4);
					backgrounds.add(R.drawable.gd5);
					backgrounds.add(R.drawable.gd6);
					backgrounds.add(R.drawable.gd7);
					backgrounds.add(R.drawable.gd8);
					backgrounds.add(R.drawable.gd9);
					backgrounds.add(R.drawable.gd10);
					backgrounds.add(R.drawable.gd11);
					backgrounds.add(R.drawable.gd12);
					backgrounds.add(R.drawable.gd14);
					backgrounds.add(R.drawable.gd15);
					backgrounds.add(R.drawable.gd16);
					backgrounds.add(R.drawable.gd17);
					backgrounds.add(R.drawable.gd18);
					backgrounds.add(R.drawable.gd19);
					backgrounds.add(R.drawable.gd20);
					backgrounds.add(R.drawable.gd21);
					backgrounds.add(R.drawable.gd22);
					backgrounds.add(R.drawable.gd23);
					backgrounds.add(R.drawable.gd24);
					backgrounds.add(R.drawable.gd25);
					backgrounds.add(R.drawable.gd26);
					backgrounds.add(R.drawable.gd27);
					backgrounds.add(R.drawable.gd28);
					backgrounds.add(R.drawable.gd29);
					backgrounds.add(R.drawable.gd30);
					backgrounds.add(R.drawable.gd31);
					backgrounds.add(R.drawable.gd32);
					backgrounds.add(R.drawable.gd33);
					backgrounds.add(R.drawable.gd34);
					backgrounds.add(R.drawable.gd35);
					backgrounds.add(R.drawable.gd36);
					backgrounds.add(R.drawable.gd37);
					backgrounds.add(R.drawable.gd38);
					backgrounds.add(R.drawable.gd39);
					backgrounds.add(R.drawable.gd40);
					backgraoundSize = backgrounds.size();
					layoutIndex = 1;
					createImageButton();
				} else if (wallCatagory.getSelectedItem().equals("Buildings (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
							backgroundDrawable.add("http://cdn.freshome.com/wp-content/uploads/2013/01/Seattle1.jpg");
							backgroundDrawable.add("http://img.brothersoft.com/screenshots/softimage/n/night_cities_screensaver-124157-1.jpeg");
							backgroundDrawable.add("http://www.pluswallpapers.com/places/america/St_Louis_1440-900.jpg");
							backgroundDrawable.add("http://st3.flashrolls.net/wallpaper/308/32afbf196412925cbc81038d28f9fbfd.jpg");
							backgroundDrawable.add("http://streetsblog.net/wp-content/uploads/2012/10/desmoines_best_c_20101215131823_mg.jpg");
							backgroundDrawable.add("http://15pictures.com/wp-content/gallery/15-pictures-modern-buildings/modern-buildings-7.jpg");
							backgroundDrawable.add("http://2.bp.blogspot.com/-nsMaxv9br-s/UD9kuWYA9nI/AAAAAAAAIrk/nXh4bHrH1qE/s400/Modern+Buildings+Wallpapers+7.jpg");
							backgroundDrawable.add("http://www.toxel.com/wp-content/uploads/2009/05/building08.jpg");
							backgroundDrawable.add("http://www.lookingatbuildings.org.uk/typo3temp/pics/l_35b44fec48.jpg");
							backgroundDrawable.add("http://www.henniker.org.uk/images/places/local_a/lochrin_tollx_fbridge/rosemount_buildings03.jpg");
							backgroundDrawable.add("http://4.bp.blogspot.com/-6JEBAxf37yU/UD9kG-nff1I/AAAAAAAAIrE/hCHnUFWkF08/s400/Modern+Buildings+Wallpapers+3.jpg");
							backgroundDrawable.add("http://cadinsider.typepad.com/.a/6a00d834538fbb69e201156fa98731970b-800wi");
							backgroundDrawable.add("http://static1.businessinsider.com/image/530ce0b26da811733efadc58/the-worlds-most-spectacular-university-buildings.jpg");
							backgroundDrawable.add("http://www.architecturaldigest.com/architecture/2007-11/buildings_slideshow_112007/_jcr_content/par/cn_contentwell/par-main/cn_pagination_container/cn_slideshow/item0.rendition.slideshowHorizontal.arsl01_buildings.jpg");
							backgroundDrawable.add("http://assets.inhabitat.com/files/greengherkin.jpg");
							backgroundDrawable.add("http://wallpapers.free-review.net/wallpapers/35/Modern_buildings_1366x768_laptop.jpg");
							backgroundDrawable.add("http://4.bp.blogspot.com/-2FHctoRaCXI/UbTOlwX5reI/AAAAAAAAJEs/6xe345ZIm_w/s1600/Hi-tech+city+in+the+world+HD+wallpaper.jpg");
							backgroundDrawable.add("http://www.wallsave.com/wallpapers/2560x1440/buildings/1001326/buildings-apocalypse-building-hd-jootix-with-px-resolution-1001326.jpg");
							backgroundDrawable.add("http://www.wallsave.com/wallpapers/1920x1080/building/585909/building-hd-live-p-buildings-585909.jpg");
							backgroundDrawable.add("http://wallpaperskd.com/wallpapers/2012/03/guggenheim-museum-bilbao-spain-city-architecture-1080x1920.jpg");
							backgroundDrawable.add("http://toptravellists.net/wallpapers/2013/03/Darling-Harbour-Building-Sydney-Australia-1200x1920.jpg");
							backgroundDrawable.add("http://www.sexyli.com/wp-content/uploads/2013/07/Eiffel-Tower-Wallpaper-HD.jpg");
							backgroundDrawable.add("http://www.wallpaperhi.com/thumbnails/detail/20111202/gee_ru_430575.jpg");
							backgroundDrawable.add("http://hdwallpaper.freehdw.com/0003/nature-landscapes_hdwallpaper_stormy-skies-over-empire-states-building_25681.jpg");
							backgroundDrawable.add("http://www.photoaxe.com/wp-content/uploads/2014/03/wallpaper-246174.jpg");
							backgroundDrawable.add("http://www.hdwallpapers.in/walls/beneath_the_eiffel_tower-wide.jpg");
							backgroundDrawable.add("http://www.houseofmoli.com/images/document/100913084701-eiffel-tower-paris-night-france.jpg");
							backgroundDrawable.add("http://www.9to5hdwallpapers.com/wp-content/uploads/2012/04/Beautiful-Building-hd-wallpaper538854.jpg");
							backgroundDrawable.add("http://fearlessflyer.com/main/wp-content/uploads/2010/10/beautiful-buildings-7.jpg");
							backgroundDrawable.add("http://www.desktopcrunch.com/wp-content/uploads/wallpapers/HD/Sunset-Clouds-Sun-Cityscapes-Buildings-Rivers-Fresh-New-Hd-Wallpaper.jpg");
							backgroundDrawable.add("http://www.wall321.com/thumbnails/detail/20120612/sunsets%20cityscapes%20photography%20buildings%20roads%202560x1600%20wallpaper_www.wall321.com_76.jpg");
							backgroundDrawable.add("http://img1.mxstatic.com/wallpapers/1f5f5eaee3e3ee818b0414e0d42501cd_large.jpeg");
							backgroundDrawable.add("http://defwalls.com/wallpapers-n/water-cityscapes-lights-buildings-skyscrapers-_3904-40.jpg");
							backgroundDrawable.add("http://www.highresolution-wallpapers.net/walls/buildings_at_night-HD.jpg");
					
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}  else if (wallCatagory.getSelectedItem().equals("Rainy Day (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://content.mobizill.com/wallpapers/images/Love9185820638284132575.jpg");
						backgroundDrawable.add("http://cdn7.staztic.com/app/a/442/442977/mushroom-rain-live-wallpaper-296663-2-s-307x512.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/_oalwC3a4OAg/TJm3LR7VW3I/AAAAAAAABsU/AqXKq31puMw/s1600/Blue_rain_drops_360x640.jpg");
						backgroundDrawable.add("http://wallpaperpassion.com/upload1/30881/rain-umbrella-wallpaper.jpg");
						backgroundDrawable.add("http://www.spwallpapers.com/var/albums/360x640/HD%20Landscape%20Wallpaper%20for%20Nokia%20360X640/HD%20Landscape%20Wallpaper%20for%20Nokia%20360X640%20(22).jpg?m=1343460780");
						backgroundDrawable.add("http://www.ilikewallpaper.net/ipad-wallpapers/download/5734/After-the-rain-of-the-glittering-and-translucent-ipad-wallpaper-ilikewallpaper_com.jpg");
						backgroundDrawable.add("http://wallpaperpassion.com/upload/12905/rain-wallpaper.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/Awesome_Rain.jpg");
						backgroundDrawable.add("http://www.elmaha.com/vb/2011/i-rain-wp03.jpg");
						backgroundDrawable.add("http://fsa.zedge.net/scale.php?img=NS85LzUvMi8xLTEwMDkxODgyLTU5NTI1NjYuanBn&ctype=1&v=4&q=71&xs=300&ys=266&sig=e1c0fc387fccc7865548eed8fd3db03bbc6d3623");
						backgroundDrawable.add("http://picsmobi.net/uploads/pictures/nature-pictures/63655-animated-rain-drop.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/love_wallpapers/preview/25/63100-love-rain.jpg");
						backgroundDrawable.add("http://www.mobileapples.com/Assets/Content/Wallpapers/black%20rain.jpg");
						backgroundDrawable.add("http://images.www.dailymobile.net/wp-content/uploads/wallpapers/nokia-5800-wallpapers/after_the_rain.jpg");
						backgroundDrawable.add("http://wallpaperpassion.com/upload_big_thumb/28905/glass-on-the-rain-wallpaper.jpg");
						backgroundDrawable.add("http://chiasetructuyen.com/upload/files/25102012/1044bx9xW1-4405783-8796-t.jpg");
						backgroundDrawable.add("http://www.wallpaper1080hd.com/Picture/allimg/c111007/131OL2643B50-4M17.jpg");
						backgroundDrawable.add("http://hd.wallpaperswide.com/thumbs/rain_2-t2.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/-vk3IBOo1UJ8/UKZDV9Xt9GI/AAAAAAAAKag/ENA1IP7bwPg/s320/rain-drop-320x480.jpg");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/rain/rain22.jpg");
						backgroundDrawable.add("http://mobi-wall.brothersoft.com/files/320480/i/128144101294.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/_ykdRtT4Egmc/TQHgb5SGSrI/AAAAAAAAAAg/ky2ciLZX2z8/s1600/Rain+time+water+spray+landscap+mobile+wallpaper.jpg");
						backgroundDrawable.add("http://www.mobiflame.com/mobile_wallpaper/beautiful-rain-drops-wallpaper.jpg");
						backgroundDrawable.add("http://cdn8.staztic.com/app/a/508/508885/sun-after-the-rain-wallpaper-799358-4-s-307x512.jpg");
						backgroundDrawable.add("http://www.wallpaper-mobile.com/free_download/640_1136_wallpapers/11201321/B/B_rain_wbyHkqBh.jpg");
						backgroundDrawable.add("http://smspk.kalpoint.com/modules/wallpapers-submit/images/rain-wallpaper-1367323593.jpg");
						backgroundDrawable.add("http://romanticlovepictures.com/downloads/Love_in_rain_mobile_wallpaper1.jpg");
						backgroundDrawable.add("http://images.mygalaxynotewallpaper.com/Gallery/6_Nature/My-Galaxy-Note2-Wallpaper-HD-Nature%20(20).jpg");
						backgroundDrawable.add("http://images.mygalaxys3wallpaper.com/Gallery/6_Nature/My-Samsung-Galaxy-S3-Wallpaper-HD-Nature(33).jpg");
						backgroundDrawable.add("http://images.mygalaxys3wallpaper.com/Gallery/6_Nature/My-Samsung-Galaxy-S3-Wallpaper-HD-Nature(39).jpg");
						backgroundDrawable.add("http://images.mygalaxys3wallpaper.com/Gallery/6_Nature/My-Samsung-Galaxy-S3-Wallpaper-HD-Nature(7).jpg");
						backgroundDrawable.add("http://images.mygalaxynotewallpaper.com/Gallery/6_Nature/My-Galaxy-Note2-Wallpaper-HD-Nature%20(2).jpg");
						backgroundDrawable.add("http://images.mygalaxynotewallpaper.com/Gallery/6_Nature/My-Galaxy-Note2-Wallpaper-HD-Nature%20(5).jpg");
						backgroundDrawable.add("http://images.mygalaxynotewallpaper.com/Gallery/6_Nature/My-Galaxy-Note2-Wallpaper-HD-Nature%20(23).jpg");
						backgroundDrawable.add("http://images.mygalaxys3wallpaper.com/Gallery/6_Nature/My-Samsung-Galaxy-S3-Wallpaper-HD-Nature(15).jpg");
						backgroundDrawable.add("http://images.mygalaxynotewallpaper.com/Gallery/6_Nature/My-Galaxy-Note2-Wallpaper-HD-Nature%20(1).jpg");
						backgroundDrawable.add("http://images.mygalaxys3wallpaper.com/Gallery/6_Nature/My-Samsung-Galaxy-S3-Wallpaper-HD-Nature(57).jpg");
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				} else if (wallCatagory.getSelectedItem().equals("Love")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgrounds.add(R.drawable.lv1);
					backgrounds.add(R.drawable.lv2);
					backgrounds.add(R.drawable.lv3);
					backgrounds.add(R.drawable.lv4);
					backgrounds.add(R.drawable.lv5);
					backgrounds.add(R.drawable.lv6);
					backgrounds.add(R.drawable.lv7);
					backgrounds.add(R.drawable.lv8);
					backgrounds.add(R.drawable.lv9);
					backgrounds.add(R.drawable.lv10);
					backgrounds.add(R.drawable.lv11);
					backgrounds.add(R.drawable.lv12);
					backgrounds.add(R.drawable.lv14);
					backgrounds.add(R.drawable.lv15);
					backgrounds.add(R.drawable.lv16);
					backgrounds.add(R.drawable.lv17);
					backgrounds.add(R.drawable.lv18);
					backgrounds.add(R.drawable.lv19);
					backgrounds.add(R.drawable.lv20);
					backgrounds.add(R.drawable.lv21);
					backgrounds.add(R.drawable.lv22);
					backgrounds.add(R.drawable.lv23);
					backgrounds.add(R.drawable.lv24);
					backgrounds.add(R.drawable.lv25);
					backgrounds.add(R.drawable.lv26);
					backgrounds.add(R.drawable.lv27);
					backgrounds.add(R.drawable.lv28);
					backgrounds.add(R.drawable.lv29);
					backgrounds.add(R.drawable.lv30);
					backgrounds.add(R.drawable.lv31);
					backgrounds.add(R.drawable.lv32);
					backgrounds.add(R.drawable.lv33);
					backgrounds.add(R.drawable.lv34);
					backgrounds.add(R.drawable.lv35);
					backgrounds.add(R.drawable.lv36);
					backgrounds.add(R.drawable.lv38);
					backgrounds.add(R.drawable.lv39);
					backgrounds.add(R.drawable.lv40);
					backgrounds.add(R.drawable.lv41);
					backgrounds.add(R.drawable.lv42);
					backgrounds.add(R.drawable.lv43);
					backgrounds.add(R.drawable.lv44);
					backgrounds.add(R.drawable.lv45);
					backgrounds.add(R.drawable.lv46);
					backgrounds.add(R.drawable.lv47);
					backgrounds.add(R.drawable.lv48);
					backgrounds.add(R.drawable.lv49);
					backgrounds.add(R.drawable.lv50);
					backgrounds.add(R.drawable.lv51);
					backgrounds.add(R.drawable.lv52);
					backgrounds.add(R.drawable.lv53);
					backgrounds.add(R.drawable.lv54);
					backgrounds.add(R.drawable.lv55);
					backgrounds.add(R.drawable.lv56);
					backgrounds.add(R.drawable.lv57);
					backgrounds.add(R.drawable.lv58);
					backgrounds.add(R.drawable.lv59);
					backgraoundSize = backgrounds.size();
					layoutIndex = 1;
					createImageButton();
				} else if (wallCatagory.getSelectedItem().equals(
						"Cute and Pink")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgrounds.add(R.drawable.cp1);
					backgrounds.add(R.drawable.cp2);
					backgrounds.add(R.drawable.cp3);
					backgrounds.add(R.drawable.cp4);
					backgrounds.add(R.drawable.cp5);
					backgrounds.add(R.drawable.cp6);
					backgrounds.add(R.drawable.cp7);
					backgrounds.add(R.drawable.cp8);
					backgrounds.add(R.drawable.cp9);
					backgrounds.add(R.drawable.cp10);
					backgrounds.add(R.drawable.cp11);
					backgrounds.add(R.drawable.cp12);
					backgrounds.add(R.drawable.cp13);
					backgrounds.add(R.drawable.cp14);
					backgrounds.add(R.drawable.cp15);
					backgrounds.add(R.drawable.cp16);
					backgrounds.add(R.drawable.cp17);
					backgrounds.add(R.drawable.cp18);
					backgrounds.add(R.drawable.cp19);
					backgrounds.add(R.drawable.cp20);
					backgrounds.add(R.drawable.cp21);
					backgrounds.add(R.drawable.cp22);
					backgrounds.add(R.drawable.cp23);
					backgrounds.add(R.drawable.cp24);
					backgrounds.add(R.drawable.cp25);
					backgrounds.add(R.drawable.cp26);
					backgrounds.add(R.drawable.cp27);
					backgrounds.add(R.drawable.cp28);
					backgrounds.add(R.drawable.cp29);
					backgrounds.add(R.drawable.cp30);
					backgrounds.add(R.drawable.cp31);
					backgrounds.add(R.drawable.cp32);
					backgrounds.add(R.drawable.cp33);
					backgrounds.add(R.drawable.cp34);
					backgrounds.add(R.drawable.cp35);
					backgrounds.add(R.drawable.cp36);
					backgrounds.add(R.drawable.cp38);
					backgrounds.add(R.drawable.cp39);
					backgrounds.add(R.drawable.cp40);
					backgrounds.add(R.drawable.cp41);
					backgrounds.add(R.drawable.cp42);
					backgrounds.add(R.drawable.cp43);
					backgrounds.add(R.drawable.cp44);
					backgrounds.add(R.drawable.cp45);
					backgrounds.add(R.drawable.cp46);
					backgrounds.add(R.drawable.cp47);
					backgrounds.add(R.drawable.cp48);
					backgrounds.add(R.drawable.cp49);
					backgrounds.add(R.drawable.cp50);
					backgrounds.add(R.drawable.cp51);
					backgrounds.add(R.drawable.cp52);
					backgrounds.add(R.drawable.cp53);
					backgrounds.add(R.drawable.cp54);
					backgrounds.add(R.drawable.cp55);
					backgrounds.add(R.drawable.cp56);
					backgrounds.add(R.drawable.cp57);
					backgrounds.add(R.drawable.cp58);
					backgrounds.add(R.drawable.cp59);
					backgrounds.add(R.drawable.cp60);
					backgrounds.add(R.drawable.cp61);
					backgrounds.add(R.drawable.cp62);
					backgrounds.add(R.drawable.cp63);
					backgrounds.add(R.drawable.cp64);
					backgrounds.add(R.drawable.cp65);
					backgrounds.add(R.drawable.cp66);
					backgrounds.add(R.drawable.cp67);
					backgrounds.add(R.drawable.cp68);
					backgrounds.add(R.drawable.cp69);
					backgrounds.add(R.drawable.cp70);
					backgrounds.add(R.drawable.cp71);
					backgrounds.add(R.drawable.cp72);
					backgrounds.add(R.drawable.cp73);
					backgrounds.add(R.drawable.cp74);
					backgrounds.add(R.drawable.cp75);
					backgrounds.add(R.drawable.cp76);
					backgrounds.add(R.drawable.cp78);
					backgrounds.add(R.drawable.cp79);
					backgrounds.add(R.drawable.cp80);
					backgrounds.add(R.drawable.cp81);
					backgrounds.add(R.drawable.cp82);
					backgrounds.add(R.drawable.cp83);
					backgrounds.add(R.drawable.cp84);
					backgraoundSize = backgrounds.size();
					layoutIndex = 1;
					createImageButton();
				} else if (wallCatagory.getSelectedItem().equals("Cool")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgrounds.add(R.drawable.cl1);
					backgrounds.add(R.drawable.cl2);
					backgrounds.add(R.drawable.cl3);
					backgrounds.add(R.drawable.cl4);
					backgrounds.add(R.drawable.cl5);
					backgrounds.add(R.drawable.cl6);
					backgrounds.add(R.drawable.cl7);
					backgrounds.add(R.drawable.cl8);
					backgrounds.add(R.drawable.cl9);
					backgrounds.add(R.drawable.cl10);
					backgrounds.add(R.drawable.cl11);
					backgrounds.add(R.drawable.cl12);
					backgrounds.add(R.drawable.cl13);
					backgrounds.add(R.drawable.cl14);
					backgrounds.add(R.drawable.cl15);
					backgrounds.add(R.drawable.cl16);
					backgrounds.add(R.drawable.cl17);
					backgrounds.add(R.drawable.cl18);
					backgrounds.add(R.drawable.cl19);
					backgrounds.add(R.drawable.cl20);
					backgrounds.add(R.drawable.cl21);
					backgrounds.add(R.drawable.cl22);
					backgrounds.add(R.drawable.cl23);
					backgrounds.add(R.drawable.cl24);
					backgrounds.add(R.drawable.cl25);
					backgrounds.add(R.drawable.cl26);
					backgrounds.add(R.drawable.cl27);
					backgrounds.add(R.drawable.cl28);
					backgrounds.add(R.drawable.cl29);
					backgrounds.add(R.drawable.cl30);
					backgrounds.add(R.drawable.cl31);
					backgrounds.add(R.drawable.cl32);
					backgrounds.add(R.drawable.cl33);
					backgrounds.add(R.drawable.cl34);
					backgrounds.add(R.drawable.cl35);
					backgrounds.add(R.drawable.cl36);
					backgrounds.add(R.drawable.cl37);
					backgrounds.add(R.drawable.cl38);
					backgrounds.add(R.drawable.cl39);
					backgrounds.add(R.drawable.cl40);
					backgrounds.add(R.drawable.cl41);
					backgrounds.add(R.drawable.cl42);
					backgrounds.add(R.drawable.cl43);
					backgrounds.add(R.drawable.cl44);
					backgrounds.add(R.drawable.cl45);
					backgrounds.add(R.drawable.cl46);
					backgraoundSize = backgrounds.size();
					layoutIndex = 1;
					createImageButton();
				} else if (wallCatagory.getSelectedItem().equals("Nature (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://4.bp.blogspot.com/-W8li4_-xpI0/UPmctgLsyjI/AAAAAAAAA2Q/g95sPQlu2H8/s1600/My_Earth_With_Lake.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/-HFXzRBdFukE/UPmcKFeyCtI/AAAAAAAAAzw/TbTcFqpGP4I/s1600/1315229918_Nature.jpg");
						backgroundDrawable.add("http://markjacksonmaui.com/wp-content/themes/thesis_18/custom/rotator/priroda13.jpg");
						backgroundDrawable.add("http://mobiliv.ru/_ph/52/2/973277934.jpg");
						backgroundDrawable.add("http://bass.heck.in/files/red-leaves.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/Nature_Best.jpg");
						backgroundDrawable.add("http://static.spoonful.com/sites/default/files/crafts/nature-mobile-summer-craft-photo-420-FF0809REUNA06.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/Best_Nature.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/nature_wallpapers/preview/43/55244-orange-nature.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/--lIW8XXMD44/T7qIPuRrhdI/AAAAAAAABMw/EvJl9a9OFDE/s1600/gallerys99+(34)-001.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/-1ZsQsFwK9dk/Ua1_ComQfgI/AAAAAAAABJI/y9AqM8vho0M/s1600/dry-tree-nature-wallpapers-for-mobile.jpg");
						backgroundDrawable.add("http://www.techagesite.com/home/sony-xperia-z-hd-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/-XX4j2IBjxLA/T5ppS1WbLzI/AAAAAAAAGaw/BPA0uNZlMzg/s1600/mobile%2Bwallpapers.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/nature_wallpapers/preview/43/48132-art-nature-wallpaper.gif");
						backgroundDrawable.add("http://s.iosfans.com/?u=http://inceptionwallpaper.com/wp-content/uploads/2012/10/Forest-Waterfall-iPhone-5-Wallpaper.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/Nature_With_Music.jpg");
						backgroundDrawable.add("http://www.hdwallpapersarena.com/wp-content/uploads/2013/03/nature-sea-animated-wallpaper1.png");
						backgroundDrawable.add("http://www.mobilephun.com/wp-content/uploads/2009/10/Nature-Mountain-Wallpaper.jpg");
						backgroundDrawable.add("http://kutegroup.com/wp-content/uploads/2010/08/beauty-nature-mobile-wallpaper-2.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/-R3wjRg13ijo/Ua2Anac8HWI/AAAAAAAABJY/mi0Vb5kjJnM/s1600/1-11042Q15329.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/-2F9eW1W333E/T_1ze4McU_I/AAAAAAAAI8Q/gk8PYz4zIlc/s320/samsung%2Bgalaxy%2Bflower%2Bwallpaper.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/nature_wallpapers/preview/43/31399-new-natural-flower-wallpaper.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/9491408.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/07/38/96/nature_00073896.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/5676733.jpg");
						backgroundDrawable.add("http://fsa.zedge.net/scale.php?img=NS82LzgvMi8xLTkyNjUwMDctNTY4MjMxMS5qcGc&ctype=1&v=4&q=81&xs=620&ys=383&sig=74584599c5f6ae5f787bc2cf77efe2e28970d3e8");
						backgroundDrawable.add("http://www.androidsoft4u.com/wallpapers/pdtimgs/374725a1-154b-4b45-93a7-5a08f09d966a_1.jpg");
						backgroundDrawable.add("http://www.theunlocker.co.uk/wallpapers/360x640/Nature/115747.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/_qB9TcUQzp0M/TKxXp55-GII/AAAAAAAABh8/IfT8YdImgF8/s1600/Nature_Tree(2).jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/nature_wallpapers/preview/43/61844-lovely-nature.jpeg");
						backgroundDrawable.add("http://quoctrung.wapsite.me/storage/hinh-nen/176x220/nature3_H9c88QSq.jpg");
						backgroundDrawable.add("http://mobile.freewallpaper4.me/320x480/6589-lovely-day.jpg");
						backgroundDrawable.add("http://fsb.zedge.net/scale.php?img=Ny8wLzgvMC8xLTcwMzg0NTAtNzA4MDc3OC5qcGc&ctype=1&v=4&q=81&xs=620&ys=383&sig=a7e9a9bd9c914121333b417fb2016119874769ce");
						backgroundDrawable.add("http://www.spwallpapers.com/var/albums/480x800/Fresh%20and%20natural%20flowers%20cell%20phone%20wallpapers%20480x800/Fresh%20and%20natural%20flowers%20cell%20phone%20wallpapers%20480x800%20(01).jpg?m=1370054572");
						backgroundDrawable.add("http://picsmobi.net/uploads/pictures/nature-pictures/62118-beautiful-scene.jpg");
						backgroundDrawable.add("http://fonepics.net/uploads/pictures/big_images/1330537713_beautiful_view.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/07/58/93/beautiful-nature_00075893.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/07/38/79/beautiful-nature_00073879.jpg");
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("Good Morning (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://www.mobilephun.com/wp-content/uploads/2011/08/Good-Morning.jpg");
						backgroundDrawable.add("http://jay.mobile9.com/download/media/41/goodmornin_TC2aDqNg.gif");
						backgroundDrawable.add("http://mobiwallpapers.net/uploads/pictures/big_images/18167-good-morning.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/Good_Morning_Tea.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/9304540.jpg");
						backgroundDrawable.add("http://media.santabanta.com/wall2009/miscellaneous/good%20morning/480x640/good-morning-11919.jpg");
						backgroundDrawable.add("http://free-mobile-wallpapers.mobilclubs.com/sites/default/files/img-wallpapers/good_morning.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/9296052.jpg");
						backgroundDrawable.add("http://media.santabanta.com/wall2009/miscellaneous/good%20morning/480x640/good-morning-14261.jpg");
						backgroundDrawable.add("http://www.wallpaper-mobile.com/free_download/360_640_wallpapers/11201321/B/B_360_qFZWgMPt.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/misc_wallpapers/preview/32/72346-good-morning.jpg");
						backgroundDrawable.add("http://d3k0efmm336514.cloudfront.net/goodmorni_157d854c0ab7af6c5042754a59672f1a.jpeg");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/morning/mrning031.jpg");
						backgroundDrawable.add("http://mobiwallpapers.net/uploads/pictures/big_images/24492-good-morning.jpg");
						backgroundDrawable.add("http://www.dertz.in/wallpapers/files/GOOD%20MORNING-468.jpg");
						backgroundDrawable.add("http://media-cache-ec0.pinimg.com/736x/ad/2a/bf/ad2abf3c8e714b1d6d79ceef4701b5d1.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/misc_wallpapers/preview/32/69252-good-morning.jpg");
						backgroundDrawable.add("http://www.toparina.net/ss2/1371574617-screenshot.jpg");
						backgroundDrawable.add("http://fonepics.net/uploads/pictures/big_images/1330529704_good_morning.jpg");
						backgroundDrawable.add("http://2kwalls.com/wp-content/uploads/2014/06/Good-Morning-Wallpaper-HD.gif");
						backgroundDrawable.add("http://d3k0efmm336514.cloudfront.net/goodmorni_6d98ede6934e4ed8a1eaee4d583b1c27.jpeg");
						backgroundDrawable.add("http://media.santabanta.com/wall2009/miscellaneous/good%20morning/480x640/good-morning-13257.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/misc_wallpapers/preview/32/72346-good-morning.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/-SqbKJFN_WUE/UGpwGvHucpI/AAAAAAAAA6w/Ub4N90Mp2JI/s1600/good+morning+friend-001.jpg");
						backgroundDrawable.add("http://mobiwallpapers.net/uploads/pictures/big_images/14120-good-morning.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/misc_wallpapers/preview/32/70632-have-nice-day.jpg");
						backgroundDrawable.add("http://www.cnjtc.com/wp-content/uploads/2014/02/good_morning_friends_have_a_nice_day_.jpeg");
						backgroundDrawable.add("http://www.venkatmails.com/wp-content/uploads/2013/05/Good-Morning-Friends-Have-a-nice-day.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/-llyJvLtGG9s/UA5JCd2oQHI/AAAAAAAABZg/pqgcZeowec8/s400/4.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/-ijElNq9UnVk/UGp0aZdrNHI/AAAAAAAAA_I/yWNUvh3XD0k/s1600/good+morning+images-005.jpeg");
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("My Life My Rules (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/abstract_wallpapers/preview/92/58398-my-life.jpg");
						backgroundDrawable.add("https://s3.amazonaws.com/sitecdn/quotepictures-cdn/uploads/Rules-of-life.jpg");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/attitude/atitu2601.jpg");
						backgroundDrawable.add("http://www.desicomments.com/dc1/11/147167/147167.jpg");
						backgroundDrawable.add("http://goran.mobile9.com/download/media/442/mylifemyru_7bhdmm54.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/misc_wallpapers/preview/32/60639-my-life-my-rules.jpg");
						backgroundDrawable.add("http://sherly.mobile9.com/download/media/210/rule_OvNIBZaw.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/10/15/09/my-life-my-rules_00101509.jpg");
						backgroundDrawable.add("http://sherly.mobile9.com/download/media/210/myrules_X5s6YrqB.jpg");
						backgroundDrawable.add("http://www.desicomments.com/dc1/11/155241/155241.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/00/39/31/my-life-my-rules_00003931.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/-0I0fBPpXo0c/T_dLDONLdRI/AAAAAAAAAJg/CQupilhKSI8/s640/57364-my-life-my-rules.jpg");
						backgroundDrawable.add("http://goran.mobile9.com/download/media/442/mylifemyru_z9ujla65.jpg");
						backgroundDrawable.add("http://kim.mobile9.com/download/media/453/mylifemyru_11tnet9p.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/09/87/36/my-rules-my-life_00098736.jpg");
						backgroundDrawable.add("https://s3.amazonaws.com/sitecdn/quotepictures-cdn/uploads/Its-my-life-with-my-rules.jpg");
						backgroundDrawable.add("http://sherly.mobile9.com/download/media/210/my-life-my_FJx5XYWy.jpg");
						backgroundDrawable.add("https://s3.amazonaws.com/sitecdn/quotepictures-cdn/uploads/My-Life-My-Rules-Love-me-or-reject-me-I-dont-care.jpg");
						backgroundDrawable.add("http://www.wordsonimages.com/pics/72412-My+life+my+rules+and+keep+your.jpg");
						backgroundDrawable.add("http://sherly.mobile9.com/download/media/210/mylifemyru_a97a4uyv.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/-jHeDcNdXb8s/T3Q2boyECvI/AAAAAAAAAIc/33dF1wPR6u0/s640/Girls_Dream.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/12/54/14/my-life-my-rules_00125414.jpg");
						backgroundDrawable.add("http://wallpaperpassion.com/upload/21234/my-life-my-rules-image.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/10/04/46/my-life-my-rules-v5_00100446.jpg");
						backgroundDrawable.add("http://goran.mobile9.com/download/media/442/mylifemyru_3hcsjaq3.jpg");
						backgroundDrawable.add("http://d3k0efmm336514.cloudfront.net/mylifemyr_36fa1e11ec2725a5bd34cdefe3a773af.jpeg");
						backgroundDrawable.add("http://sherly.mobile9.com/download/media/210/mylifemyru_wn29jyn2.jpg");
						backgroundDrawable.add("http://d3k0efmm336514.cloudfront.net/mylifemys_45795ebd68b53d667f2124299f5c4487.jpeg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/abstract_wallpapers/preview/92/74666-my-life-my-attitude-.jpg");
						backgroundDrawable.add("http://www.timepasssms.com/images/big/People/big_Attitude_Boy_People1314265839.jpg");
						backgroundDrawable.add("http://f1.pepst.com/c/5B24F1/502519/ssc3/home/046/a.mamun/albums/attitude.jpg_480_480_0_64000_0_1_0.jpg");
						backgroundDrawable.add("http://profilepictures.weebly.com/uploads/7/8/4/2/7842277/2615635_orig.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/10/04/75/attitude_00100475.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/1315258009_Attitude_Boy.jpg");
						backgroundDrawable.add("http://smspk.kalpoint.com/modules/wallpapers-submit/images/Meaning%20Of%20My%20Life-1294382701.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/music_wallpapers/preview/89/65859-music-is-my-life.jpg");
						backgroundDrawable.add("http://www.getmobsoft.com/ss/1303097356-screenshot.jpg");
						backgroundDrawable.add("http://d3k0efmm336514.cloudfront.net/mylifemyr_1c2cdc29d4b496cabec1155b91ce6c27.jpeg");
						backgroundDrawable.add("http://d3k0efmm336514.cloudfront.net/mystylemy_acce4274eff08fdcab1fc5ea8d1f2bf0.jpeg");
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("Yummy N Delicious (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://s2.wallippo.com/thumbs/300x250/delicious-cake-5f41b90cef162c111f8ab32d193c22a0.jpeg");
						backgroundDrawable.add("http://img0.liveinternet.ru/images/attach/c/1//60/306/60306116_klubnika8796.jpg");
						backgroundDrawable.add("http://i.i.ua/cards/pic/7/8/234087.jpg");
						backgroundDrawable.add("http://www.porjati.ru/uploads/posts/2011-03/1299740915_chocolate-strawberries.jpg");
						backgroundDrawable.add("http://www.sedty.com/up_ar/ar/large322230.jpg");
						backgroundDrawable.add("http://cache.desktopnexus.com/thumbnails/799343-bigthumbnail.jpg");
						backgroundDrawable.add("http://data.whicdn.com/images/22451920/colorful,delicious,icecream,tasty,yummy,ice,cream-898b67d640104146d4b1cd721c81f94f_h_large.jpg");
						backgroundDrawable.add("http://everydaydolce.com/wp-content/uploads/2013/03/cream-delicious-food-ice-cream-pink-Favim.com-207343_large.jpg");
						backgroundDrawable.add("http://s1.favim.com/orig/19/chocolate-delicious-food-ice-cream-yummy-Favim.com-202131.jpg");
						backgroundDrawable.add("https://farm8.staticflickr.com/7295/10744963583_1b1ff3b39a_n.jpg");
						backgroundDrawable.add("http://s3.goodfon.su/wallpaper/previews-middle/634704.jpg");
						backgroundDrawable.add("http://theverybesttop10.files.wordpress.com/2013/06/the-world_s-top-10-best-ice-cream-cone-cupcakes-6.jpg");
						backgroundDrawable.add("http://tourismkeralas.com/admin/Import/images/deal_s3_1342064582.jpg");
						backgroundDrawable.add("http://www.wearemobians.com/media/wallpaper/divers/gateau_large.jpg");
						backgroundDrawable.add("http://blog.kaggle.com/wp-content/uploads/2012/02/41277-cakes-cherry-chocolate-cake.jpg");
						backgroundDrawable.add("https://lh5.ggpht.com/hNx4dYuMNlUSiyXOTJvGvt2St_OIcIYpVQKP8Lr1c5ybH0xehHczaDiIWrkEWSybEMo=w300");
						backgroundDrawable.add("http://4.bp.blogspot.com/-Yi1Eqg_HaV8/UHLp3Ft3cmI/AAAAAAAAAO4/IQy_I8kShcM/s400/Delicious%2BDesserts%2BWallpapers%2BMediafire.jpg");
						backgroundDrawable.add("http://images.meredith.com/bhg/images/desktops/a_dydANC401951.jpg");
						backgroundDrawable.add("http://img14.slando.ua/images_slandocomua/91867141_3_644x461_buket-konfet-klubnichnoe-nastroenie-sladkiy-podarok-zhenschine-podarki.jpg");
						backgroundDrawable.add("http://images.meredith.com/bhg/images/desktops/a_dydBKS050997.jpg");
						backgroundDrawable.add("http://cdn9.staztic.com/app/a/3781/3781688/yummy-creamy-cakes-wallpapers-1-0-s-307x512.jpg");
						backgroundDrawable.add("http://cdn9.staztic.com/app/a/3404/3404707/cakes-and-muffins-wallpapers-22-1-s-307x512.jpg");
						backgroundDrawable.add("http://p1.funnypicker.com/picture/fp/126/8/img_3212608_5377a60da9dd2969335.jpeg");
						backgroundDrawable.add("http://blog.todobonito.com/wp-content/uploads/2014/01/heart-cupcake-1.jpg");
						backgroundDrawable.add("http://image.shutterstock.com/display_pic_with_logo/887974/887974,1323870523,348/stock-photo-mixed-ice-cream-with-fresh-fruits-90795167.jpg");
						backgroundDrawable.add("http://www.fitnessandnutritionforkids.com/wp-content/uploads/2013/08/Finalf.jpg");
						backgroundDrawable.add("http://www.gelita.com/sites/default/files/filebase/images/Sorbet.jpg");
						backgroundDrawable.add("http://www.marquefoods.com/system/images/0003/5287/Coupe-sorbet.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/-X8UrfYb0e24/Ty5MEtjM_HI/AAAAAAAAFIA/J9KBAnbPQoI/s400/japanese_food.jpg");
						backgroundDrawable.add("http://cdn9.staztic.com/app/a/3404/3404707/cakes-and-muffins-wallpapers-22-2-s-307x512.jpg");
						backgroundDrawable.add("http://stuffkit.com/wp-content/uploads/2011/06/ice-cream-wallpaper-10.jpg");
						
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("Transformer (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://free-mobile-wallpapers.mobilclubs.com/sites/default/files/img-wallpapers/transformers.jpg");
						backgroundDrawable.add("http://www.mobileapples.com/Assets/Content/Themes/Transformers_2(4).jpg");
						backgroundDrawable.add("http://www.mwallpaper.com/images/transformer_240x320_2671.jpg");
						backgroundDrawable.add("http://www.3g37.com/haotu/UploadFiles_5488/201103/20110306003343688.jpg");
						backgroundDrawable.add("http://www.gotowallpapers.com/wallpapers/allimg/c111006/131NF3215SP-49B7.jpg");
						backgroundDrawable.add("http://www.timepasssms.com/images/big/Entertainment/big_Transformers_3_Entertainment1315915458.jpg");
						backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/97576/transformers-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://www.aditif.net/share/thumb/mobile-poster-853.jpg");
						backgroundDrawable.add("http://static.ddmcdn.com/gif/real-transformer-movie-5.jpg");
						backgroundDrawable.add("http://www.mobiwalls.net/wp-content/attachment/64096015/4-iphone-wallpaper-36521.jpg");
						backgroundDrawable.add("http://mobiwallpapers.net/uploads/pictures/big_images/35208-transformers.jpg");
						backgroundDrawable.add("http://picsmobi.net/uploads/pictures/technology-pictures/88151-transformers.jpg");
						backgroundDrawable.add("http://www.cellphonewallpapers.us/mobile-phone-wallpapers-pictures/mobilephone/140303156040.jpg");
						backgroundDrawable.add("http://fonepics.net/uploads/pictures/big_images/transformers_rtf.jpg");
						backgroundDrawable.add("http://www.umnet.com/pic/diy/screensaver/6%5CTransformers--69828.jpg");
						backgroundDrawable.add("http://www.umnet.com/pic/diy/screensaver_s/8/Transformers--81615.jpg");
						backgroundDrawable.add("http://www.mobileapples.com/Assets/Content/Wallpapers/transformers-optimus.jpg");
						backgroundDrawable.add("http://pic2.actoys.net/attachment/photo/Mon_1203/6696_4d08133188925275c2672be5fd448.jpg");
						backgroundDrawable.add("http://www.hdiphonewallpapers.us/phone-wallpapers/mobilewallpapers/1293VXE5ZF-46407.jpg");
						backgroundDrawable.add("http://www.androidsoft4u.com/wallpapers/pdtimgs/90d258aa-ece5-4bdb-b421-83114b55e6e3_1.JPG");
						backgroundDrawable.add("http://www.mobile-phone.pk/images/wallpapers/transformer_fighter_others_mobile_wallpaper.jpg");
						
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("Ian Somerhalder (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://i.perezhilton.com/wp-content/uploads/2013/12/ian-somerhalder-china-promo-camera-49320__oPt.jpg");
						backgroundDrawable.add("http://spd.fotolog.com/photo/45/19/123/nomoreteachers/1290388006231_f.jpg");
						backgroundDrawable.add("http://vampirediaries.alloyentertainment.com/files/2012/09/ian-somerhalder-in-defy-magazine-e1346796155217.jpg");
						backgroundDrawable.add("http://www.womenshealthmag.com/files/wh6_uploads/images/1307-ian-somerhalder.jpg");
						backgroundDrawable.add("http://data1.whicdn.com/images/3777467/large.jpg");
						backgroundDrawable.add("http://images.hngn.com/data/images/full/1052/ian-somerhalder.jpg?w=600");
						backgroundDrawable.add("http://images4.fanpop.com/image/photos/17100000/Ian-Somerhalder-ian-somerhalder-17124838-604-453.jpg");
						backgroundDrawable.add("http://cyly.eu/img/2014/01/damon-salvatore-wallpaper.jpg");
						backgroundDrawable.add("http://imworld.aufeminin.com/dossiers/D20110218/Ian-Somerhalder-The-Vampire-Diaries-8-juin-2010-1-104702_L.jpg");
						backgroundDrawable.add("http://images4.fanpop.com/image/photos/24100000/Ian-Wallpaper-ian-somerhalder-24152860-1024-768.jpg");
						backgroundDrawable.add("http://www3.images.coolspotters.com/photos/1084277/ian-somerhalder-profile.png");
						backgroundDrawable.add("http://d75822.medialib.glogster.com/criscare124/media/cf/cf17686f89a7c6dd65b53d6501136d76fd30ee5e/ashley-greene-ian-somerhalder-couple-05.jpg");
						backgroundDrawable.add("http://static.tumblr.com/xv7ki2h/fyRlxm64p/tumblr_lhpe8udik11qhspwqo1_500.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/_hdTw1wbmgYM/TPWR7GoHPCI/AAAAAAAAAIU/m8Vqp-_XtzM/s200/ian-somerhalder-young-hollywood-studios-3.jpg");
						backgroundDrawable.add("http://images6.fanpop.com/image/photos/34300000/-Ian-Somerhalder-ian-somerhalder-34379688-500-667.png");
						backgroundDrawable.add("http://d1mxyp5ceukbya.cloudfront.net/images/ian-somerhalder-birthday.jpg");
						backgroundDrawable.add("http://cdn.fstatic.com/public/artists/avatar/2013/08/thumbs/ian-somerhalder_a28599_4_jpg_640x480_upscale_q90.jpg");
						backgroundDrawable.add("http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=48384351");
						backgroundDrawable.add("http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=44208023");
						backgroundDrawable.add("http://2.bp.blogspot.com/-MMK2TzH6BHI/UPXSsioGDBI/AAAAAAAAAQk/IWNwoslyaOA/s1600/Teen-choice-awards-2012-ian-somerhalder-31559319-421-480.jpg");
						backgroundDrawable.add("http://38.media.tumblr.com/d81bf9a2f3f30857522f606b58f74d7b/tumblr_n33qquyw1c1qik2bvo1_500.png");
						backgroundDrawable.add("http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=44208023");
						backgroundDrawable.add("http://images4.fanpop.com/image/photos/24100000/Ian-Wallpaper-ian-somerhalder-24152678-1024-768.jpg");
						backgroundDrawable.add("http://iansomerhalderaustralia.com/wp-content/uploads/2012/11/ian-somerhalder-2011-emmys-02.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/-T0XfpisKsL0/UQvLbVmHLSI/AAAAAAAACAI/3FkMdf7daoc/s1600/Ian+Somerhalder+Workout+and+Diet.jpg");
						backgroundDrawable.add("http://0.tqn.com/d/movies/1/7/5/1/W/ian-somerhalder-teen-choice-2010.jpg");
						backgroundDrawable.add("http://www.listentolena.com/wp-content/uploads/2014/05/Ian-Somerhalder.jpg");
						backgroundDrawable.add("http://vampirediaries.alloyentertainment.com/wp-content/blogs.dir/6/files/nina-and-ian-in-toronto/ian-somerhalder-at-the-airport-2013.jpg");
						backgroundDrawable.add("http://cdn03.cdn.justjared.com/wp-content/uploads/2013/07/somerhalder-tank/ian-somerhalder-wears-muscle-tank-in-lake-como-04.jpg");
						backgroundDrawable.add("http://vampirediaries.alloyentertainment.com/files/2013/04/ian-somerhalder-kissing-a-puppy.jpg");
						backgroundDrawable.add("http://images.sugarscape.com/userfiles/image/AAAAAAAAAAAAAAAJAN2014/lizzie/ian-somerhalder-china.jpg");
						backgroundDrawable.add("http://cdn03.cdn.justjared.com/wp-content/uploads/2013/12/somerhalder-benq/ian-somerhalder-benq-digital-camera-promotion-in-china-03.jpg");
						backgroundDrawable.add("http://cdn04.cdn.justjared.com/wp-content/uploads/2013/12/somerhalder-benq/ian-somerhalder-benq-digital-camera-promotion-in-china-11.jpg");
						backgroundDrawable.add("http://www.aceshowbiz.com/images/wennpic/somerhalder-dobrev-2012-coachella-day-3-06.jpg");
						backgroundDrawable.add("http://media2.onsugar.com/files/2011/05/21/3/192/1922398/412d6d90f7c3e478_FP_7368237_ANG_Somerhalder_Ian_052411wtmk.xxxlarge/i/Ian-Somerhalder-Pictures-Paris-Girlfriend-Vampire-Diaries-Costar-Nina-Dobrev.jpg");
						backgroundDrawable.add("http://cdn03.cdn.justjaredjr.com/wp-content/uploads/headlines/2014/04/ian-somerhalder-wants-to-know-what-you-stand-for.jpg");
						backgroundDrawable.add("http://herevilroyalty.files.wordpress.com/2012/12/5126-the-vampire-diaries-ian-somerhalder.jpg?w=497&h=440");
						backgroundDrawable.add("http://ohmychinilyn.files.wordpress.com/2013/01/ian-somerhalder.jpg");
						backgroundDrawable.add("http://www.missmalini.com/wp-content/uploads/2012/12/eye-candy-ian-somerhalder-25.jpg");
						backgroundDrawable.add("http://cdn.buzznet.com/assets/users15/poisonana/default/msg-117518608731.jpg");
						backgroundDrawable.add("http://images5.fanpop.com/image/photos/28100000/my-Nian-manip-ian-somerhalder-and-nina-dobrev-28103114-750-1106.jpg");
						backgroundDrawable.add("http://cdn02.cdn.justjared.com/wp-content/uploads/2013/10/somerhalder-icon/ian-somerhalder-covers-icon-magazine-mens-issue-2013-01.jpg");
						backgroundDrawable.add("http://s9.favim.com/orig/140107/damon-salvatore-hot-ian-somerhalder-man-Favim.com-1235973.png");
						backgroundDrawable.add("http://lh5.ggpht.com/-1eDTBGeeD5U/TVciYikj0SI/AAAAAAAAADE/myJjZgpMx94/s9000/Ian_Somerhalder_766247.jpg");
						backgroundDrawable.add("http://cdn04.cdn.justjaredjr.com/wp-content/uploads/headlines/2014/05/ian-somerhalders-heart-aches-for-bring-back-our-girls-moms1.jpg");
						
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("Harry Potter (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://lh6.ggpht.com/_sCVW6_19AYk/TOZxHnFRUGI/AAAAAAAADL8/BgSfzhVAbN0/240x320_Harry_Potter_Mobile_Screensa%5B1%5D.jpg?imgmax=800");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/movie_wallpapers/preview/27/p21634-1236158522.jpg");
						backgroundDrawable.add("http://www.mobileapples.com/Assets/Content/Wallpapers/harrypotter.jpg");
						backgroundDrawable.add("http://www4.images.coolspotters.com/wallpapers/94638/harry-potter-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/-VGLSj9c9n5U/T6vL2kpbFnI/AAAAAAAAB5c/j3S0m1KLHCw/s640/harry-potter-and-the-prisoner-of-azkaban-wallpaper_422_23244.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/movie_wallpapers/preview/27/p15977-1217261397.jpg");
						backgroundDrawable.add("http://imworld.aufeminin.com/dossiers/D20090715/harry-potter-daniel-radcliffe-2-2-160947_L.jpg");
						backgroundDrawable.add("http://cdn.klimg.com/kapanlagi.com/wallpaper/img/harry-potter02.jpg");
						backgroundDrawable.add("http://s2.wallippo.com/thumbs/300x250/emma-watson-in-harry-potter-102e8c75fd0ea498eccf772c58f2bae7.jpeg");
						backgroundDrawable.add("http://3.bp.blogspot.com/-OJQgGJqmsyg/TsePHi1a-DI/AAAAAAAAAFU/j1pdfxb7AfU/s1600/Harry+Potter+Wallpaper+Free+Downloads+2011.3.jpg");
						backgroundDrawable.add("http://web.engr.oregonstate.edu/~pascok/COI/wp-content/uploads/2012/09/Harry-Potter.jpg");
						backgroundDrawable.add("http://www.umnet.com/pic/diy/screensaver/6/Harry-Potter--60758.jpg");
						backgroundDrawable.add("http://www.moviemuggle.com/wp-content/uploads/2011/07/harry-potter-and-the-goblet-of-fire-wallpaper.jpg");
						backgroundDrawable.add("http://i2.listal.com/image/1069915/936full-harry-potter-and-the-prisoner-of-azkaban-screenshot.jpg");
						backgroundDrawable.add("http://www.wallpapers3000.com/wallpapersen/Movie/H/Harry_Potter/images/Harry_Potter_68.jpg");
						backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/74107/harry-potter-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://www.timepasssms.com/images/big/Entertainment/big_Harry_Potter_Entertainment1315915846.jpg");
						backgroundDrawable.add("http://www3.images.coolspotters.com/wallpapers/124664/harry-potter-and-the-deathly-hallows-mobile-wallpaper.jpg");
						backgroundDrawable.add("http://www.cellphonewallpapers.us/mobile-phone-wallpapers-pictures/iphone/1293W01935A20-39420.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/movie_wallpapers/preview/27/p8665-1211674835.jpg");
						backgroundDrawable.add("http://members.outpost10f.com/~lindax/harrypotter/wallpaper/hp_wallpaper_07_1152x864.JPG");
						backgroundDrawable.add("http://screenshots.en.sftcdn.net/en/scrn/47000/47979/harry-potter-screensaver-4.jpg");
						backgroundDrawable.add("http://s2.wallippo.com/thumbs/300x250/harry-and-ginny-harry-potter-09dfd75a99b5a26f7acf4dee14f4416b.jpeg");
						backgroundDrawable.add("http://www.thethirdcity.org/blog/wp-content/uploads/2010/04/Free_Harry_Potter_Screensaver-43473.jpg");
						backgroundDrawable.add("http://www.free-wallpapers-free.com/wallpapers/preview/ha/harry-potter-mobile-1.jpg");
						backgroundDrawable.add("http://www.harrypotterwallpaper.com/wp-content/gallery/harry-potter-240x320/harrypotter0337651357.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/_x1OnKnh8LH4/SZeHNzqjQmI/AAAAAAAAAgk/faeWn0QAVe0/s400/poahh001.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/Harry_Potter_Movie_P.jpg");
						backgroundDrawable.add("http://lh6.ggpht.com/_ShYMN0KZ8w4/TOd_YT81LRI/AAAAAAAAD2U/erIrxIQI-WA/s1600-h/Mobile_Wallpaper_Harry_Potter%5B2%5D.jpg");
						backgroundDrawable.add("http://www.harrypotterwallpaper.com/wp-content/gallery/harry-potter-320x480/harrypotter0112971935.jpg");
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("Cutie Pie (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://4.bp.blogspot.com/-7zeFu78S0c8/UWj8R59FfXI/AAAAAAAAFbc/tiWumK66vLM/s1600/lovely-cute-little-baby-girl-child.jpg");
						backgroundDrawable.add("http://www.recycledsurfboards.com/small-cute-babies-wallpapers-free-download-15.jpg");
						backgroundDrawable.add("http://picsmobi.net/uploads/pictures/love-pictures/51864-cute-baby.jpg");
						backgroundDrawable.add("http://f9view.com/wp-content/uploads/2013/04/Cute-Baby-HD-Wallpaper-for-Mobile-Screen-240x320-5.jpg");
						backgroundDrawable.add("http://media-cache-ak0.pinimg.com/236x/43/cf/f9/43cff9895e20d176d114f08555989301.jpg");
						backgroundDrawable.add("http://25.media.tumblr.com/tumblr_m8rza5aM8W1r10i4xo1_500.jpg");
						backgroundDrawable.add("http://greatwallpapers.org/wp-content/uploads/2014/07/cute-little-baby-wallpaper-1.jpg");
						backgroundDrawable.add("http://25.media.tumblr.com/tumblr_m9x1parK1e1reiifno1_500.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/-bMFdfRrO6ng/TpXhFLkV2OI/AAAAAAAADww/pHfrDKOTkIM/s1600/baby+wallpapers+for+mobile+4.jpg");
						backgroundDrawable.add("http://www.iwallpapersfive.com/wp-content/uploads/2013/11/cute-baby-wallpapers-for-mobile-phones-smiling-cute-baby-samsung-s.jpg");
						backgroundDrawable.add("http://data2.whicdn.com/images/58017744/tumblr_mgztzsCTdq1s3fiwbo1_500_large.jpg");
						backgroundDrawable.add("http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=58850957");
						backgroundDrawable.add("http://www.mobilephun.com/wp-content/uploads/2013/06/Baby-wallpaper.jpg");
						backgroundDrawable.add("https://31.media.tumblr.com/53fa83e1d41ecb8910e06c843eaba994/tumblr_inline_n0sukc3OIR1szpemg.jpg");
						backgroundDrawable.add("http://www.imagespk.com/thumbnails/large_little_cute_baby_98933.jpeg");
						backgroundDrawable.add("http://metheprincess.files.wordpress.com/2010/06/baby-blue-eyes-hat-21.jpg?w=300&h=300");
						backgroundDrawable.add("http://itsmyviews.com/wp-content/uploads/2013/02/latest-baby-wallpapers-2013-2014.jpg");
						backgroundDrawable.add("http://f9view.com/wp-content/uploads/2013/04/Cute-Baby-HD-Wallpaper-for-Mobile-Screen-240x320-2.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/-xSXljJjGvwQ/UNCQt-SFsJI/AAAAAAACgSs/4FRzdGrGRtI/s1600/Magazines-24+(13).jpg");
						backgroundDrawable.add("https://lh4.ggpht.com/kOs64Gb8T_zJAF4yuUaznbpoNOVeUfoTgmJiTzRJFOsYSJH70IRIethF5qeahBx7_Qw=h310");
						backgroundDrawable.add("http://2.bp.blogspot.com/-N8AuwexVkdc/TmcUwX2rF-I/AAAAAAAAB-o/m69gv1mxwAk/s1600/cute+baby+pic+%25283%2529.jpg");
						backgroundDrawable.add("http://www.boomwallpaper.com/wp-content/uploads/2014/06/Cute_Baby_Couple_Wallpaper_For_Facebook_Cover-2.jpg");
						backgroundDrawable.add("http://www.desicomments.com/dc/23/57082/57082.jpg");
						backgroundDrawable.add("http://38.media.tumblr.com/fa4ce3a25b00191b3b0ef7f1d8ddbb0f/tumblr_n6yccwivoO1tt8rt3o7_500.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/-jmqQWR7OQAY/UWeYu7KnHqI/AAAAAAAAFMw/IQTfPOnG9RA/s1600/beautiful-girl-child-picture.jpg");
						backgroundDrawable.add("http://www.listofimages.com/wallpapers/2012/12/baby-cute-mouth-lips-blue-eyes-boy-nose-other-768x1024.jpg");
						backgroundDrawable.add("http://www.desktopdress.com/desktopwallpapers/babies/little-cute-baby-big-laugh.jpg");
						backgroundDrawable.add("http://www.el-raa3y.com/wp-content/uploads/2013/10/%D8%B5%D9%88%D8%B1-%D8%A7%D8%B7%D9%81%D8%A7%D9%84-6.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/babies_wallpapers/preview/19/p16140-1217777279.jpg");
						backgroundDrawable.add("http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=54199168");
						backgroundDrawable.add("http://2.bp.blogspot.com/-ca3TxPuLHKU/UXQIqwsnNoI/AAAAAAAAFQ4/s4Y0A_Nyg6k/s400/New-Charming-Babies-Wallpapers-3.jpg");
						backgroundDrawable.add("http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=51323579");
						backgroundDrawable.add("http://media.tumblr.com/a51cdfe7d7d1339461cad1ae2e28b601/tumblr_inline_mguho7hhV81r44f5b.jpg");
						backgroundDrawable.add("http://cdnpix.com/show/imgs/93f10585854261272f87cb4e060d8932.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/_1k0siWzSItE/RboiVlOnDcI/AAAAAAAAAB4/arnZPhahZ4A/s400/J3.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/-vHLz2sm7Fpk/Ucx-f1QEIcI/AAAAAAAALus/MKlP0vn91DM/s1026/sasiran-sirin-cocuk-aman-allahim-1749-originalsize-I2.jpg");
						
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("Cute Puppies N Kittens (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://www.asnclassifieds.com/im/images-426/3143123-122003649.jpg");
						backgroundDrawable.add("http://www.esetka.pl/photos/ewelinadeja_1398824241_1.jpg");
						backgroundDrawable.add("http://www.dailycuteness.com/wp-content/uploads/2008/06/dog-cute-baby.jpg");
						backgroundDrawable.add("http://www.lovethispic.com/uploaded_images/19060-Cute-Little-Puppy.jpg");
						backgroundDrawable.add("http://37.media.tumblr.com/tumblr_lyz4t1mmeT1qapjwyo1_500.jpg");
						backgroundDrawable.add("http://pixdaus.com/files/items/pics/2/38/315238_03bedd54fe91f3c7ef8b1c73773ef493_large.jpg");
						backgroundDrawable.add("http://www.fifidaily.com/wp-content/uploads/2012/10/baby-kobe.jpg");
						backgroundDrawable.add("http://stuffpoint.com/puppies/image/455325-puppies-cute-little-puppy.jpg");
						backgroundDrawable.add("https://blazingardor.files.wordpress.com/2013/07/cutest-little-white-fluffy-puppy.jpeg");
						backgroundDrawable.add("http://s3.favim.com/orig/45/beautiful-cute-dog-white-Favim.com-405790.jpg");
						backgroundDrawable.add("http://www.bestdogpix.com/wp-content/uploads/2014/01/tumblr_mycib4F3MK1stlkgho1_250.jpg");
						backgroundDrawable.add("http://www.joyenjoys.com/wp-content/uploads/2012/03/Worlds-Cute-Tiny-Puppies-33.jpg");
						backgroundDrawable.add("http://data.whicdn.com/images/31421693/Cute-Dogs-6_large.jpg");
						backgroundDrawable.add("http://cdnimg.visualizeus.com/thumbs/f9/f7/cute,adorable,baby,dog,eyes,pet-f9f79304bbfb19af4ebcfb48e1a51c1c_h.jpg");
						backgroundDrawable.add("http://31.media.tumblr.com/tumblr_lb65ps8W8D1qbpbxdo1_500.jpg");
						backgroundDrawable.add("http://www.bangngangan.com/images/cute-pink-dogs-graphics-and-comments_57711.jpg");
						backgroundDrawable.add("http://www.mundimascota.it/images/anuncios/290620141404003443_1.jpg");
						backgroundDrawable.add("http://www.wallcoo.net/animal/white_baby_dog/images/white_baby_dog_82446.jpg");
						backgroundDrawable.add("http://www.joyenjoys.com/wp-content/uploads/2012/03/Worlds-Cute-Tiny-Puppies-30.jpg");
						backgroundDrawable.add("http://www.deshow.net/d/file/animal/2009-04/white-fluffy-puppy-508-12.jpg");
						backgroundDrawable.add("http://cdn.dailycute.net/2011/3/24/201103240712134140559103eac3bd9c2ae54936ebec15.jpg");
						backgroundDrawable.add("http://cutearoo.com/wp-content/uploads/2012/11/Kitten8.jpg");
						backgroundDrawable.add("http://www.thedevilsdemons.com/wp-content/uploads/2010/04/cute_kitty.jpg");
						backgroundDrawable.add("http://i.imgur.com/RjS7A.jpg");
						backgroundDrawable.add("http://cutearoo.com/wp-content/uploads/2011/09/Puppy.jpg");
						backgroundDrawable.add("http://www.123inspiration.com/wp-content/uploads/2013/03/baby-animals-351.jpg");
						backgroundDrawable.add("http://fakti.bg/img/news2013/91221/1e15e7debe4a128be2f0821d16c22b30.jpg");
						backgroundDrawable.add("http://freefunnydogpictures.com/wp-content/uploads/2014/05/baby-puppies_1400068718.jpg");
						backgroundDrawable.add("http://www.themudflats.net/wp-content/uploads/2013/01/cute_animal_pictures_3.jpg");
						backgroundDrawable.add("http://cdn.theanimals.pics/pictures/www.funnycutepics.com/wp/wp-content/uploads/2011/02/baby-puppy.jpg");
						backgroundDrawable.add("http://coyneclients.com/blog_pet/wp-content/uploads/2013/01/Cute-baby-puppy.jpg");
						backgroundDrawable.add("http://i512.photobucket.com/albums/t327/Mashona666/baby-puppies.jpg");
						backgroundDrawable.add("http://www.eyeonannapolis.net/wp-content/uploads/2013/07/fluffy.jpg");
						backgroundDrawable.add("http://www.animaatjes.nl/uploads/forum/plaats-iets-schattigs-10.jpg");
						backgroundDrawable.add("http://cutearoo.com/wp-content/uploads/2011/12/Puppy6.jpg");
						backgroundDrawable.add("http://media-cache-ak0.pinimg.com/236x/b3/95/28/b395283fbaa02a8b180d37ec64e27750.jpg");
						backgroundDrawable.add("http://lukeromyn.com/blog/wp-content/uploads/2011/05/two-cute-puppies-running.jpg");
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				}else if (wallCatagory.getSelectedItem().equals("Friends Forever (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				          //run your normal code path here
							//connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/misc_wallpapers/preview/32/65205-friends-forever.jpg");
						backgroundDrawable.add("http://fsb.zedge.net/scale.php?img=OC8wLzQvMy8xLTk1ODE3OTctODA0Mzg2MS5qcGc&ctype=1&v=4&q=81&xs=620&ys=383&sig=b51036b12d645763dfac85c8b6452fc83b301d9e");
						backgroundDrawable.add("http://fonepics.net/uploads/pictures/big_images/1330549410_friends_forever.jpg");
						backgroundDrawable.add("http://fsa.zedge.net/scale.php?img=MS8wLzYvNi8xLTU3NTYxNzQtMTA2NjIyMy5qcGc&ctype=1&v=4&q=81&xs=620&ys=383&sig=763ab013e7c712f16313bedc1260c03a8bec8e04");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/friends/frndz01.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/-jfJlQf9j2RE/T51llbr2dxI/AAAAAAAAATM/MDpeE5mfGbE/s200/13929.jpg");
						backgroundDrawable.add("http://media-cache-ak0.pinimg.com/236x/13/fa/aa/13faaa6d4dbfbf5bfdb914deeff332a0.jpg");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/friends/frndz03.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/abstract_wallpapers/preview/92/62654-friends-for.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/abstract_wallpapers/preview/92/70888-dearst-friend.jpg");
						backgroundDrawable.add("http://displaypix.com/images/items/thumb/220_itm_2013-01-22_21-23-06_2.jpg");
						backgroundDrawable.add("http://www.mobiles24.com/static/previews/downloads/default/159/P-490199-4nFzwFlH6m-1.jpg");
						backgroundDrawable.add("http://www.wallpaperg.com/screenshot/ss4/1369985156-www.wallpaperg.com-screenshot.jpg");
						backgroundDrawable.add("http://www.toparina.net/ss1/1348819815-screenshot.jpg");
						backgroundDrawable.add("http://fsb.zedge.net/scale.php?img=OC8zLzEvNS8xLTk5NTA5NzctODMxNTM3MC5qcGc&ctype=1&v=4&q=71&xs=300&ys=266&sig=86257d36adea68761638c58fd80d5639e611e591");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/friendship_wallpapers/preview/24/72264-friends.jpg");
						backgroundDrawable.add("http://telepics.net/uploads/pictures/big_images/1315255196_Friendship.jpg");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/friends/fndz027.jpg");
						backgroundDrawable.add("http://www.godwallpaper.in/wallpaper/M001/C031/SC059/mobile/FriendshipYF5D.jpg");
						backgroundDrawable.add("http://www.watnodoor.com/pictures/watnPDcH7.jpg");
						backgroundDrawable.add("http://3.bp.blogspot.com/-yDLkvYE95tg/USEOrj5RiVI/AAAAAAAAASk/b5Jk4O4TwFs/s400/friendship-quote77676.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/-O0NituUyy7I/Uf1TxHyyEJI/AAAAAAAAEMY/AAGFLLeH7c8/s1600/Happy+Friendshipday+wallpaper+2013+(2).jpg");
						backgroundDrawable.add("http://fsb.zedge.net/scale.php?img=MS84LzAvMi8xLTg2Mzk4NzEtMTgwMjMzNS5qcGc&ctype=1&v=4&q=71&xs=300&ys=266&sig=48d4b4403a26900e73815eefcd24206c310332fb");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/friends/friends011.jpg");
						backgroundDrawable.add("http://mobiwallpapers.net/uploads/pictures/big_images/38845-friendship-quote.jpg");
						backgroundDrawable.add("http://media-cache-ec0.pinimg.com/736x/5c/13/38/5c13380d61eea85d7b9fded8e10ee646.jpg");
						backgroundDrawable.add("http://wallpapersgrill.com/wp-content/uploads/2013/11/Latest-Love-Wallpapers-For-Mobile121.jpg");
						backgroundDrawable.add("http://4.bp.blogspot.com/-zSFd4jgEGBg/UlI_ve86zPI/AAAAAAAAGGg/LquP8d2Fvh0/s400/Android-Mobile-Phone-Wallpapers-480x800-4.jpg");
						backgroundDrawable.add("http://freesoftwarekit.com/server13/photos/zrHcRER3uD_vvM~/14091_love-quotes-wallpapers_480x800.jpg");
						backgroundDrawable.add("http://d2tq98mqfjyz2l.cloudfront.net/image_cache/1381647827519116.png");
						backgroundDrawable.add("http://images6.fanpop.com/image/photos/35500000/quote-quotes-35564600-240-320.jpg");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/friends/friends081.jpg");
						backgroundDrawable.add("http://i752.photobucket.com/albums/xx163/mobile2/2432/friends/frndz02.jpg");
						backgroundDrawable.add("http://fsb.zedge.net/scale.php?img=MS8wLzQvNS8xLTYzMzczMzktMTA0NTA3Ny5qcGc&ctype=1&v=4&q=81&xs=620&ys=383&sig=66a91d42c177a8c59f7c4a5eb677832f27905255");
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
						
				} else if (wallCatagory.getSelectedItem()
						.equals("Most Popular")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgrounds.add(R.drawable.pop1);
					backgrounds.add(R.drawable.pop2);
					backgrounds.add(R.drawable.pop3);
					backgrounds.add(R.drawable.pop4);
					backgrounds.add(R.drawable.pop5);
					backgrounds.add(R.drawable.pop6);
					backgrounds.add(R.drawable.pop7);
					backgrounds.add(R.drawable.pop8);
					backgrounds.add(R.drawable.pop9);
					backgrounds.add(R.drawable.pop10);
					backgrounds.add(R.drawable.pop11);
					backgrounds.add(R.drawable.pop12);
					backgrounds.add(R.drawable.pop13);
					backgrounds.add(R.drawable.pop14);
					backgrounds.add(R.drawable.pop15);
					backgrounds.add(R.drawable.pop16);
					backgrounds.add(R.drawable.pop17);
					backgrounds.add(R.drawable.pop18);
					backgrounds.add(R.drawable.pop19);
					backgrounds.add(R.drawable.cp25);
					backgrounds.add(R.drawable.cp54);
					backgrounds.add(R.drawable.cp44);
					backgrounds.add(R.drawable.cp51);
					backgrounds.add(R.drawable.lv10);
					backgrounds.add(R.drawable.lv14);
					backgrounds.add(R.drawable.cn22);
					backgrounds.add(R.drawable.cp1);
					backgrounds.add(R.drawable.cn19);
					backgrounds.add(R.drawable.cn29);
					backgrounds.add(R.drawable.cp46);
					backgrounds.add(R.drawable.cl45);
					backgrounds.add(R.drawable.cn7);
					backgrounds.add(R.drawable.cl13);
					backgrounds.add(R.drawable.cp36);
					backgrounds.add(R.drawable.cp21);
					backgrounds.add(R.drawable.lv40);
					backgrounds.add(R.drawable.lv52);
					backgrounds.add(R.drawable.cl1);
					backgrounds.add(R.drawable.gd2);
					backgrounds.add(R.drawable.cp78);
					backgrounds.add(R.drawable.cn44);
					backgrounds.add(R.drawable.cl7);
					backgrounds.add(R.drawable.cl44);
					backgrounds.add(R.drawable.cl28);
					backgrounds.add(R.drawable.cl8);
					backgrounds.add(R.drawable.lv28);
					backgrounds.add(R.drawable.cp31);
					backgrounds.add(R.drawable.cp52);
					backgrounds.add(R.drawable.cp67);
					backgrounds.add(R.drawable.cp80);
					backgraoundSize = backgrounds.size();
					layoutIndex = 1;
					createImageButton();
				} else if (wallCatagory.getSelectedItem().equals(
						"Motivational Quotes (Web)")) {
					scrollableImageLayout.removeAllViews();
					backgrounds.clear();
					backgroundDrawable.clear();
					if(conn == true){
				        //connectivityMessage("Internet is working!please wait, image are loading.");
						backgroundDrawable.add("http://photographyheat.com/wp-content/uploads/2013/09/Inspirational.jpg");
						backgroundDrawable.add("http://1.bp.blogspot.com/_KLJU3hHDGVM/TIDefGO2LoI/AAAAAAAAD_8/Nhqczh2--AM/s320/Original+wallpaper.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/comic_wallpapers/preview/22/56845-dreams.jpg");
						backgroundDrawable.add("http://cmster.com/media/QIjcSdttFW4IkFxWqBqycxvvl1f91vYzMQeWc1mW7CFq13EsScd5EwcbWw1b8u3S.jpg");
						backgroundDrawable.add("http://media-cache-ec0.pinimg.com/236x/09/db/87/09db87a52b605272b36ffadad335f04b.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/10/22/63/quote_00102263.jpg");
						backgroundDrawable.add("http://media-cache-ak0.pinimg.com/236x/fa/b5/d5/fab5d504fb0960d730c93b4aae9f774f.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/09/89/47/love-quotes_00098947.jpg");
						backgroundDrawable.add("http://media-cache-ec0.pinimg.com/236x/6b/db/ec/6bdbec7e36a83cb9aac9c1e7abbf6ec2.jpg");
						backgroundDrawable.add("http://photographyheat.com/wp-content/uploads/2013/09/tumblr_m0k1r5ps2m1rrru5uo1_500.jpg");
						backgroundDrawable.add("http://cdn7.staztic.com/app/a/3628/3628925/inspirational-free-quotes-2-11-s-307x512.jpg");
						backgroundDrawable.add("http://cmster.com/media/9ZjC4PdOPAtjNmVJZtLhGkjY9JojMk7elr4viYljzGCjEedNIm3oP7JYzLDtj3Bo.jpg");
						backgroundDrawable.add("http://cdn7.staztic.com/app/a/3628/3628925/inspirational-free-quotes-2-16-s-307x512.jpg");
						backgroundDrawable.add("http://media-cache-ec0.pinimg.com/236x/95/ec/ee/95eceed540294bfa60707b025732d15e.jpg");
						backgroundDrawable.add("http://media.santabanta.com/wall2009/emotions/motivational/480x640/motivational-9988.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/09/95/06/future_00099506.jpg");
						backgroundDrawable.add("http://media.santabanta.com/wall2009/emotions/motivational/480x640/motivational-15699.jpg");
						backgroundDrawable.add("http://media-cache-ak0.pinimg.com/236x/66/e5/b3/66e5b3a68b38c01ea9c43cddd24d99ed.jpg");
						backgroundDrawable.add("http://media.santabanta.com/wall2009/emotions/motivational/480x640/motivational-10421.jpg");
						backgroundDrawable.add("http://www.mobiletoones.com/downloads/wallpapers/people_wallpapers/preview/44/68045-motivational.jpg");
						backgroundDrawable.add("http://media-cache-ak0.pinimg.com/236x/fa/c2/1f/fac21f49cb2853dcc6afd90d88035c97.jpg");
						backgroundDrawable.add("http://media-cache-ec0.pinimg.com/736x/3c/cf/98/3ccf9886e975f17cbe0be3a91618d741.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/09/89/35/quote_00098935.jpg");
						backgroundDrawable.add("http://wallpoper.com/images/00/08/27/84/a-prayer_00082784.jpg");
						backgroundDrawable.add("http://media.santabanta.com/wall2009/emotions/motivational/480x640/motivational-11453.jpg");
						backgroundDrawable.add("http://media.santabanta.com/wall2009/emotions/motivational/480x640/motivational-12694.jpg");
						backgroundDrawable.add("http://download-mobile-wallpapers.com/server13/photos/ANvv1XNgxz9aUM~/84124_Motivational-Thoughts-Inspirational-Quotes-wallpapers-pictures_360x640.jpg");
						backgroundDrawable.add("http://a1.mzstatic.com/us/r30/Purple/v4/43/ff/a3/43ffa382-25e9-a66c-abc3-1e28d4014e57/screen568x568.jpeg");
						backgroundDrawable.add("http://media-cache-ak0.pinimg.com/236x/22/39/e4/2239e4be672fe4d7a0d4bce8fd8133c8.jpg");
						backgroundDrawable.add("http://2.bp.blogspot.com/-QzlNaXS6nfM/UxQLMGGjpbI/AAAAAAAABSc/tbwB1ZnLiPk/s1600/henry+ford+quote+iphone+wallpaper.jpg");
						backgroundDrawable.add("http://justhappyquotes.com/wp-content/uploads/2014/03/Its_My_Life_Quote_360x640.jpg");
						backgraoundSize = backgroundDrawable.size();
						layoutIndex=1;
						createImageButtonForURL();
				     }
				     else{
				          //Send a warning message to the user
				          connectivityMessage("Internet is not working,Please check your network connection."); 
				      }
					
				}
				Log.i("Spinner",
						"Seleted Item" + wallCatagory.getSelectedItem());
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
	}
	/*private void createImageButtonForURL(){
		ListView myList = new ListView(getApplicationContext());
		
		ArrayAdapterItem a=new ArrayAdapterItem(getApplicationContext(), R.layout.list,backgroundDrawable);
		myList.setAdapter(a);
		myLayout.addView(myList);
		
	}
*/
	@SuppressLint("NewApi")
	private void createImageButtonForURL() {
		// TODO Auto-generated method stub
		
		try {
			flag = false;
			Log.i("Number of Images", "Image Number : " + backgroundDrawable.size());
			backgraoundSize=backgroundDrawable.size();
			popIV = new ImageButton[backgraoundSize];
			imagesLayout = new LinearLayout[backgraoundSize / 2];
			for (int i = 0; i < backgraoundSize; i++) {
				//Log.i("Image Number starting", "Image " + i);
				ImageButton wImageButton = new ImageButton(this);
				//Log.i("Before function call url",backgroundDrawable.get(i));
				wImageButton.setImageResource(R.drawable.load);
				
				Animation vanish =AnimationUtils.loadAnimation(this,R.anim.vanish);
				wImageButton.startAnimation(vanish);
				wImageButton.setPadding(110,110,110,110);
				if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
				{	
					Log.i("API Level 11 and Greater","API level 11 and Greater");
					new DownloadImageTask(wImageButton).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,backgroundDrawable.get(i));
				}
				else
				{	
					Log.i("API Level Less then 11","API level less then 11");
					new DownloadImageTask(wImageButton).execute(backgroundDrawable.get(i));	
				}
				// new DownloadImageTask(wImageButton).execute(backgroundDrawable.get(i));
				//wImageButton.setImageBitmap(LoadImageFromWebOperations(backgroundDrawable.get(i)));
				//Log.i("after function call url",backgroundDrawable.get(i));
				LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
						screenWidth / 2, screenWidth / 2, 1);
				wImageButton.setLayoutParams(param);
				wImageButton.setScaleType(ScaleType.FIT_XY);
				wImageButton.setBackgroundColor(Color.TRANSPARENT);
				wImageButton.setOnClickListener(this);
				wImageButton.setTag(i);
				popIV[i] = wImageButton;

				if (flag) {

					//Log.i("Image Number Current", "Image " + i);
					LinearLayout ll = new LinearLayout(this);
					ll.setOrientation(LinearLayout.HORIZONTAL);
					LinearLayout.LayoutParams llParam = new LinearLayout.LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT, 2);
					ll.setLayoutParams(llParam);
					imagesLayout[i - layoutIndex] = ll;
					//Log.i("Image Number Current", "Image " + i);
					imagesLayout[i - layoutIndex].addView(popIV[i]);
					imagesLayout[i - layoutIndex].addView(popIV[i - 1]);
					//Log.i("Image Number Current", "Image " + i);

					scrollableImageLayout
							.addView(imagesLayout[i - layoutIndex]);
					//Log.i("Layout iadex", "Layout index" + (i - layoutIndex));
					layoutIndex++;
					flag = false;
				} else {
					flag = true;

				}
				//Log.i("Scrollable view number of images","Image Count : "+scrollableImageLayout.getChildCount());
				Log.i("Image Number ending", "Image " + i);
			}
				
		} catch (Exception e) {
			Log.e("Exception during the fetch of images", "Exception details "
					+ e);
		}
	}
	
	public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		  private static final int THREAD_PRIORITY_BACKGROUND = 10;
		private static final int THREAD_PRIORITY_MORE_FAVORABLE = 9;
		ImageButton bmImage;
		Boolean cancelTask=false;

		public DownloadImageTask(ImageButton bmImage) {
		      this.bmImage = bmImage;
		  }
		  
		  @SuppressLint("NewApi")
		  @Override
	        protected void onPreExecute() {
		      bmImage.setBackground(getResources().getDrawable(R.drawable.load));
		      isAsyncTaskRunning = true;
	        }


		  protected Bitmap doInBackground(String... urls) {
			  //Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND + Process.THREAD_PRIORITY_MORE_FAVORABLE);
		      if(isCancelled()){
		    	  cancelTask = true;
		      }
			  String urldisplay = urls[0];
		      Bitmap scaledBitmap = null;
		      final String urlImage = urldisplay;
		      try {
		    	BitmapFactory.Options options = new BitmapFactory.Options();
		    	options.inJustDecodeBounds = true;
		        InputStream in = new java.net.URL(urldisplay).openStream();
		        //Log.i("Input Stream","Get First Input Stream");
		        BitmapFactory.decodeStream(in, null, options);
		        in.close();
		        
		       // Calculate inSampleSize
			    options.inSampleSize = calculateInSampleSize(options, 100, 100);
		        //Log.i("Sample Size","Resize the image");
			    
			    //scaledBitmap = Bitmap.createScaledBitmap(mIcon11, 100, 100, true);
			    
				options.inJustDecodeBounds = false;
		        InputStream in1 = new java.net.URL(urldisplay).openStream();
		        //Log.i("Input Stream","Get Second Input Stream");
				scaledBitmap = BitmapFactory.decodeStream(in1, null, options);
		        Log.i("Set the bitmap","Return the scaled bitmap");
		    	  isError = false;
				in1.close();
		      } 
		      catch (Exception e) {
		    	  errorCount++;
		    	  isError = true;
		    	  //Log.e("Error", e.getMessage());
		          e.printStackTrace();
		      }
		      return scaledBitmap;
		      

		  }

		  protected void onPostExecute(Bitmap result) { 
			  if(!cancelTask)
			  {
			  if(!isError){
				  bmImage.setPadding(0, 0, 0, 0);
			      bmImage.clearAnimation();
			      bmImage.setImageBitmap(result);  
			      Log.i("Set Image Button","Setting main image");
			  }
		      
			  }else
			  {
				  isAsyncTaskRunning = true;
			  }
		  }
		  @Override
		protected void onCancelled() {
			// TODO Auto-generated method stub
			super.onCancelled();
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
	
	private void createImageButton() {
		// TODO Auto-generated method stub
		try {
			flag = false;
			Log.i("Number of Images", "Image Number : " + backgraoundSize);
			popIV = new ImageButton[backgraoundSize];
			imagesLayout = new LinearLayout[backgraoundSize / 2];
			for (int i = 0; i < backgraoundSize; i++) {
				Log.i("Image Number starting", "Image " + i);
				ImageButton wImageButton = new ImageButton(this);
				wImageButton.setImageBitmap(getImage(backgrounds.get(i)));
				LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
						screenWidth / 2, screenWidth / 2, 1);
				wImageButton.setLayoutParams(param);
				wImageButton.setScaleType(ScaleType.FIT_XY);
				wImageButton.setBackgroundColor(Color.TRANSPARENT);
				wImageButton.setPadding(0, 0, 0, 0);
				wImageButton.setOnClickListener(this);
				wImageButton.setTag(i);
				popIV[i] = wImageButton;

				if (flag) {

					Log.i("Image Number Current", "Image " + i);
					LinearLayout ll = new LinearLayout(this);
					ll.setOrientation(LinearLayout.HORIZONTAL);
					LinearLayout.LayoutParams llParam = new LinearLayout.LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT, 2);
					ll.setLayoutParams(llParam);
					imagesLayout[i - layoutIndex] = ll;
					Log.i("Image Number Current", "Image " + i);
					imagesLayout[i - layoutIndex].addView(popIV[i]);
					imagesLayout[i - layoutIndex].addView(popIV[i - 1]);
					Log.i("Image Number Current", "Image " + i);
						
					scrollableImageLayout
							.addView(imagesLayout[i - layoutIndex]);
					Log.i("Layout iadex", "Layout index" + (i - layoutIndex));
					layoutIndex++;
					flag = false;
				} else {
					flag = true;

				}
				Log.i("Image Number ending", "Image " + i);
			}
		} catch (Exception e) {
			//Log.e("Exception during the fetch of images", "Exception details "
				//	+ e);
			e.printStackTrace();
		}
	}

	
	
	public Bitmap getImage(int resourceId) {
		Bitmap scaledBitmap = null;
		Log.d("Resource Id : ", " " + resourceId);
		try {
			Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
					resourceId, null);
			scaledBitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
			bitmap.recycle();
			bitmap = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			Log.e("Error in get Image Method ", ": " + e);
			e.printStackTrace();
		}

		return scaledBitmap;
	}

	public void onClick(View v) {
		errorCount=10;
		ImageButton ib = (ImageButton) v;
		Log.e("Index Of selected Image ",
				"Index of Resource Id " + (Integer) ib.getTag() + " is "
						+ (Integer) ib.getTag());
		Intent setWallIntent = new Intent(Menu.this, SetWallpaper.class);
		if(backgrounds.size() > 0) 
		{
		setWallIntent.putExtra("URL", "N");
		setWallIntent.putIntegerArrayListExtra("BackgoundImages", backgrounds);
		}
		else if(backgroundDrawable.size() > 0)
		{
			setWallIntent.putExtra("URL", "Y");
			setWallIntent.putStringArrayListExtra("BackgoundImagesURLs", backgroundDrawable);
		}
			
		currentPosition = (Integer) ib.getTag();
		setWallIntent.putExtra("CurrentPosition", currentPosition);
		startActivity(setWallIntent);
	}

	public void connectivityMessage(String msg){
		 Log.i("Connection Status", msg);
	     AlertDialog.Builder ad= new AlertDialog.Builder(this);
	     ad.setTitle("AlPics DH Wallpaper");
	     ad.setMessage(msg);
	     ad.setCancelable(false);
	     ad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//Menu.this.finish();
			}
		});
	     ad.show();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("One Pause Called", "On Pause Called");
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("On Resume Called", "On Resume Called");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("On Stop Called","On Stop Called");
		if(isAsyncTaskRunning){
			Log.i("Asynctask still running", "Runninggggg");
		}
		else
		{
			Log.i("AsyncTask is Stopped", "Stooppeedd");
		}
		
	}
	
	


}
