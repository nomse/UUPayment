/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.unionpay.payment.carpay.activity;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft_6455;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.data.RoadInfo;
import com.unionpay.payment.carpay.data.RoadInfoStatic;
import com.unionpay.payment.carpay.utils.DatetimeUtil;
import com.unionpay.payment.carpay.utils.MoveUtil;
import com.unionpay.payment.carpay.widget.TimeDialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 轨迹运行demo展示
 */
public class ETCDemo extends Activity {
		private MapView mMapView;
		private BaiduMap mBaiduMap;
		private Polyline mPolyline;
		private Marker mMoveMarker;
		private Handler mHandler;
		MapStatus.Builder builder;
		// 设置全局视图参数
		private TextView speed;
		private TextView road;
		private TextView direction;
		private LinearLayout chargeLayout;
		private RelativeLayout upLayout;
		// 倒计时全局变量
		final Context context = ETCDemo.this;
		BitmapDescriptor mGreenTexture = BitmapDescriptorFactory.fromAsset("icon_road_green_arrow.png");
		// 初始化全局 bitmap 信息，不用时及时 recycle
	    BitmapDescriptor bd = BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);
		protected TimeDialog timeDialog;
		// 通过设置间隔时间和距离可以控制速度和图标移动的距离
		private static final int TIME_INTERVAL = 80;
		private static double DISTANCE =0.000009;
		private int roadInfoETCSize=latlngs.length;
		private boolean exit=false;
		AutobahnServerTest test;
		SpeechSynthesizer mTts;
		DecimalFormat decimalFormat=new DecimalFormat("0.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initWebservice();
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_etc);
		mMapView = (MapView) findViewById(R.id.bmapView);
		mMapView.onCreate(this, savedInstanceState);
		mBaiduMap = mMapView.getMap();
		builder = new MapStatus.Builder();
		builder.target(RoadInfoStatic.roadInfoETC[0].getLl());
		builder.zoom(19.0f);
		mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
		mBaiduMap.setTrafficEnabled(true);
		mHandler = new Handler(Looper.getMainLooper());
		drawPolyLine();
		moveLooper();
		initVoice();
		//语音初始化验证
		SpeechUtility.createUtility(context, SpeechConstant.APPID +"=596b21dc");
		mMapView.showZoomControls(false);
	}
	private void initVoice(){
		//语音初始化验证
		SpeechUtility.createUtility(context, SpeechConstant.APPID +"=596b21dc");
		mTts= SpeechSynthesizer.createSynthesizer(ETCDemo.this, null);
		// 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);  
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD); //设置云端  
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");//设置发音人  
        mTts.setParameter(SpeechConstant.SPEED, "60");//设置语速  
        //设置合成音调  
        mTts.setParameter(SpeechConstant.PITCH, "50");  
        mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围0~100  
        mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");  
        // 设置播放合成音频打断音乐播放，默认为true  
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");
	}
	private void drawPolyLine() {
		// 页面控件初始化
		chargeLayout=(LinearLayout) findViewById(R.id.chargeLayout);
		upLayout=(RelativeLayout) findViewById(R.id.upLayout);
		List<LatLng> polylines = new ArrayList<LatLng>();// 获取主干道的点
		for (int index = 0; index < roadInfoETCSize; index++) {
			polylines.add(latlngs[index].getLl());
		}
		OverlayOptions mainPloyline = new PolylineOptions().width(20).points(polylines).dottedLine(true)
				.customTexture(mGreenTexture);
		mPolyline = (Polyline) mBaiduMap.addOverlay(mainPloyline);
		// 移动物体图标
		speed = (TextView) findViewById(R.id.speed);
		road = (TextView) findViewById(R.id.road);
		direction = (TextView) findViewById(R.id.direction);
	    TextView date=(TextView)findViewById(R.id.date);
	    TextView cardNo=(TextView)findViewById(R.id.cardNo);
	    date.setText(DatetimeUtil.getFormatCurrentTime("yyyy-MM-dd"));
	    BankCard defaultCard = DataMock.getInstance().getDefaultBankCard();
		String cardString=defaultCard.getPan();
		cardNo.setText(cardString.substring(cardString.length()-4, cardString.length()));
		// 小车图标，表示自己所在位置
		OverlayOptions markerOptions;
		markerOptions = new MarkerOptions().flat(true).anchor(0.5f, 0.5f)
				.icon(BitmapDescriptorFactory.fromAsset("car.png")).position(latlngs[0].getLl())
				.rotate((float) MoveUtil.getAngle(0, mPolyline));// 起始旋转角度
		mMoveMarker = (Marker) mBaiduMap.addOverlay(markerOptions);
		//ECT文字
		LatLng llText1 = new LatLng(31.032342,121.438513);
		LatLng llText2 = new LatLng(31.003122,121.453561);
		MarkerOptions ooA = new MarkerOptions().position(llText1).icon(bd)
	                .zIndex(9).draggable(true);
		mBaiduMap.addOverlay(ooA);
		ooA=new MarkerOptions().position(llText2).icon(bd)
                .zIndex(9).draggable(true);
		mBaiduMap.addOverlay(ooA);
        OverlayOptions ooText = new TextOptions()
                .fontSize(24).fontColor(0xFFFF00FF).text("ETC专用通道").rotate(30)
                .position(llText1);
        mBaiduMap.addOverlay(ooText);
        ooText=new TextOptions()
                .fontSize(24).fontColor(0xFFFF00FF).text("ETC专用通道").rotate(30)
                .position(llText2);
        mBaiduMap.addOverlay(ooText);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mMapView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mMapView.onPause();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mMapView.onSaveInstanceState(outState);
	}

	@Override
	protected void onDestroy() {
		try {
			test.stop();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exit=true;
		mGreenTexture.recycle();
		super.onDestroy();
		mMapView.onDestroy();
		mBaiduMap.clear();
		mTts.destroy();
	}
	public void initWebservice(){
		WebSocketImpl.DEBUG = false;
		try {
			test = new AutobahnServerTest(54300, new Draft_6455());
			test.setConnectionLostTimeout( 0 );
			test.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 移动逻辑
	 */
	public void moveLooper() {
		new Thread() {
			public void run() {
				for (int i = 0; i < latlngs.length - 1&&!exit; i++) {
					final RoadInfo roadInfo = latlngs[i];
					final LatLng startPoint = latlngs[i].getLl();
					final LatLng endPoint = latlngs[i + 1].getLl();
					mMoveMarker.setPosition(startPoint);
					mHandler.post(new Runnable() {
						@Override
						public void run() {
							// refresh marker's rotate
							if (mMapView == null) {
								return;
							}
							mMoveMarker.setRotate((float) MoveUtil.getAngle(startPoint, endPoint));
						}
					});
					Log.e("i", i+"++++");
					
					double slope = MoveUtil.getSlope(startPoint, endPoint);
					// 是不是正向的标示
					boolean isReverse = (startPoint.latitude > endPoint.latitude);

					double intercept = MoveUtil.getInterception(slope, startPoint);

					double xMoveDistance = isReverse ? MoveUtil.getXMoveDistance(slope, DISTANCE) : -1 * MoveUtil.getXMoveDistance(slope, DISTANCE);

					for (double j = startPoint.latitude; !((j > endPoint.latitude) ^ isReverse); j = j
							- xMoveDistance) {
						LatLng latLng = null;
						if (slope == Double.MAX_VALUE) {
							latLng = new LatLng(j, startPoint.longitude);
						} else {
							latLng = new LatLng(j, (j - intercept) / slope);
						}

						final LatLng finalLatLng = latLng;
						mHandler.post(new Runnable() {
							@Override
							public void run() {
								if (mMapView == null) {
									return;
								}
								road.setText(roadInfo.getRoad());
								direction.setText(roadInfo.getDirection());
								mMoveMarker.setPosition(finalLatLng);
								speed.setText(decimalFormat.format(DISTANCE * 2000000+Math.random()));;
							}
						});
						try {
							Thread.sleep(TIME_INTERVAL);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (!exit) {
						//聚焦点
						test.setLl(endPoint.longitude+":"+endPoint.latitude);
						builder.target(endPoint);
						builder.zoom(19.0f);
						mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
						if(i==12){
							runOnUiThread(new Runnable() {
								public void run() {
									upLayout.setVisibility(View.GONE);
									/*try {
										test.stop();
									} catch (IOException e) {
										e.printStackTrace();
									} catch (InterruptedException e) {
										e.printStackTrace();
									}*/
								}
							});
						}
					} 
					if(i==3&&!exit){
						runOnUiThread(new Runnable() {
							public void run() {
								timeDialog=new TimeDialog(context,3000);
								timeDialog.setMessage("您已进入沪金高速！");
								timeDialog.setIcon(android.R.drawable.ic_dialog_info);
								timeDialog.show();
								timeDialog.getWindow().setGravity(Gravity.BOTTOM);
						        //开始合成  
						        int code = mTts.startSpeaking("您已进入沪金高速！", mSynListener);  
						        if (code != ErrorCode.SUCCESS) {  
						            if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {  
						                //上面的语音配置对象为初始化时：  
						                Toast.makeText(ETCDemo.this, "语音组件未安装", Toast.LENGTH_LONG).show();  
						            } else {  
						                Toast.makeText(ETCDemo.this, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();  
						            }  
						        }  
							}
						});
						DISTANCE = 0.000004;
					}else if(i<=5&&!exit){
						DISTANCE =0.000009;
						if(i==4){
							DISTANCE=0.000014;
							i=8;
							runOnUiThread(new Runnable() {
								public void run() {
									builder.target(new LatLng(31.005552,121.452218));
									builder.zoom(19.0f);
									mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
									timeDialog = new TimeDialog(context, 3000);
									timeDialog.setTitle("5分钟过后...");
									timeDialog.setIcon(android.R.drawable.ic_dialog_info);
									timeDialog.show();
									timeDialog.getWindow().setGravity(Gravity.BOTTOM);
								}
							});
						}
					}else{
						if(i==11){
							DISTANCE=0.000009;
						}
						if(i==12&&!exit){
							runOnUiThread(new Runnable() {
								public void run() {
									chargeLayout.setVisibility(View.VISIBLE);
									builder.target(new LatLng(31.005552,121.452218));
									builder.zoom(15.0f);
									mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
									int code = mTts.startSpeaking("缴费成功！本次收费5元！", mSynListener);  
							        if (code != ErrorCode.SUCCESS) {  
							            if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {  
							                //上面的语音配置对象为初始化时：  
							                Toast.makeText(ETCDemo.this, "语音组件未安装", Toast.LENGTH_LONG).show();  
							            } else {  
							                Toast.makeText(ETCDemo.this, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();  
							            }  
							        }  
									/*final Button backToHome=(Button) findViewById(R.id.backToHome);
									backToHome.setOnClickListener(new OnClickListener() {
										@Override
										public void onClick(View v) {
											finish();
										}
									});*/
								}
							});
						}
					}
					
				}
			}

		}.start();
	}

	private static final RoadInfo[] latlngs = RoadInfoStatic.roadInfoETC;
	private SynthesizerListener mSynListener = new SynthesizerListener() {  
        //会话结束回调接口，没有错误时，error为null  
        public void onCompleted(SpeechError error) {  
        }  
  
        //缓冲进度回调  
        //percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。  
        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {  
        }  
  
        //开始播放  
        public void onSpeakBegin() {  
        }  
  
        //暂停播放  
        public void onSpeakPaused() {  
        }  
  
        //播放进度回调  
        //percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.  
        public void onSpeakProgress(int percent, int beginPos, int endPos) {  
        }  
  
        //恢复播放回调接口  
        public void onSpeakResumed() {  
        }  
  
        //会话事件回调接口  
        public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {  
        }  
    };  
}
