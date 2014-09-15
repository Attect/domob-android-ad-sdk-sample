package cn.domob.ads.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import cn.domob.android.ads.AdEventListener;
import cn.domob.android.ads.AdManager.ErrorCode;
import cn.domob.android.ads.AdView;

public class BannerAdActivity extends Activity {
	RelativeLayout mAdContainer;
	AdView mAdview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.banner);
		mAdContainer = (RelativeLayout) findViewById(R.id.adcontainer);
		// Create ad view
		mAdview = new AdView(this, DomobSampleActivity.PUBLISHER_ID, DomobSampleActivity.InlinePPID);
		mAdview.setKeyword("game");
		mAdview.setUserGender("male");
		mAdview.setUserBirthdayStr("2000-08-08");
		mAdview.setUserPostcode("123456");
		mAdview.setAdEventListener(new AdEventListener() {
			@Override
			public void onAdOverlayPresented(AdView adView) {
				Log.i("DomobSDKDemo", "overlayPresented");
			}
			@Override
			public void onAdOverlayDismissed(AdView adView) {
				Log.i("DomobSDKDemo", "Overrided be dismissed");
			}
			@Override
			public void onAdClicked(AdView arg0) {
				Log.i("DomobSDKDemo", "onDomobAdClicked");
			}
			@Override
			public void onLeaveApplication(AdView arg0) {
				Log.i("DomobSDKDemo", "onDomobLeaveApplication");
			}
			@Override
			public Context onAdRequiresCurrentContext() {
				return BannerAdActivity.this;
			}
			@Override
			public void onAdFailed(AdView arg0, ErrorCode arg1) {
				Log.i("DomobSDKDemo", "onDomobAdFailed");
			}
			@Override
			public void onEventAdReturned(AdView arg0) {
				Log.i("DomobSDKDemo", "onDomobAdReturned");
			}
		});
		RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		layout.addRule(RelativeLayout.CENTER_HORIZONTAL);
		mAdview.setLayoutParams(layout);
		mAdContainer.addView(mAdview);
	}
}
