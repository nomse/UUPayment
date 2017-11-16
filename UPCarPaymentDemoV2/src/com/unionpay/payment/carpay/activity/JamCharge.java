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
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.map.Text;
import com.baidu.mapapi.model.LatLng;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.sunflower.FlowerCollector;
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
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
public class JamCharge extends Activity implements Runnable {
	private MapView mMapView;
	private BaiduMap mBaiduMap;
	private Polyline mPolyline;
	private Marker mMoveMarker;
	private Handler mHandler;
	MapStatus.Builder builder;
	// 设置全局视图参数
	private static final RoadInfo[] latlngs = RoadInfoStatic.roadInfoJam;
	private TextView speed;
	private TextView road;
	private TextView direction;
	private RelativeLayout upLayout;
	private LinearLayout chargeLayout;
	private TextView date;
	private TextView cardNo;
	private boolean myFlag = true;
	private int mCount = -100;
	// 计时全局变量
	private Handler timeHandler;
	private TextView time;
	final Context context = JamCharge.this;
	// 初始化全局 bitmap 信息，不用时及时 recycle
	BitmapDescriptor mRedTexture = BitmapDescriptorFactory.fromAsset("icon_road_red_arrow.png");
	BitmapDescriptor mYellowTexture = BitmapDescriptorFactory.fromAsset("icon_road_yellow_arrow.png");
	BitmapDescriptor mGreenTexture = BitmapDescriptorFactory.fromAsset("icon_road_green_arrow.png");
	Polyline jamPloyline;
	BitmapDescriptor bd = BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);
	protected TimeDialog timeDialog;
	// 通过设置间隔时间和距离可以控制速度和图标移动的距离
	private static final int TIME_INTERVAL = 80;
	private static double DISTANCE = 0.000012;
	private int roadInfoJamSize = latlngs.length;
	private boolean exit = false;
	private boolean inJam = false;
	AutobahnServerTest test;
	private double lat1 = RoadInfoStatic.jamArea[0].latitude;
	private double lng1 = RoadInfoStatic.jamArea[0].longitude;
	private double lat2 = RoadInfoStatic.jamArea[3].latitude;
	private double lng2 = RoadInfoStatic.jamArea[2].longitude;
	DecimalFormat decimalFormat = new DecimalFormat("0.00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
	SpeechSynthesizer mTts;

	// 语音合成
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initWebservice();
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_trace);
		mMapView = (MapView) findViewById(R.id.bmapView);
		mMapView.onCreate(this, savedInstanceState);
		mBaiduMap = mMapView.getMap();
		builder = new MapStatus.Builder();
		builder.target(latlngs[0].getLl());
		builder.zoom(19.0f);
		mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
		mBaiduMap.setTrafficEnabled(true);
		mHandler = new Handler(Looper.getMainLooper());
		drawPolyLine();
		initLayout();
		moveLooper();
		initVoice();
		mMapView.showZoomControls(false);
	}

	private void initVoice() {
		// 语音初始化验证
		SpeechUtility.createUtility(context, SpeechConstant.APPID + "=596b21dc");
		mTts = SpeechSynthesizer.createSynthesizer(JamCharge.this, null);
		// 清空参数
		mTts.setParameter(SpeechConstant.PARAMS, null);
		mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD); // 设置云端
		mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");// 设置发音人
		mTts.setParameter(SpeechConstant.SPEED, "60");// 设置语速
		// 设置合成音调
		mTts.setParameter(SpeechConstant.PITCH, "50");
		mTts.setParameter(SpeechConstant.VOLUME, "80");// 设置音量，范围0~100
		mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");
		// 设置播放合成音频打断音乐播放，默认为true
		mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");
	}

	private void drawPolyLine() {
		speed = (TextView) findViewById(R.id.speed);
		road = (TextView) findViewById(R.id.road);
		direction = (TextView) findViewById(R.id.direction);
		// 主干道暂时全绿色规划
		List<LatLng> polylinesMain = new ArrayList<LatLng>();// 获取主干道的点
		for (int index = 0; index < RoadInfoStatic.roadInfoMain.length; index++) {
			polylinesMain.add(RoadInfoStatic.roadInfoMain[index].getLl());
		}
		OverlayOptions mainPloyline = new PolylineOptions().width(20).points(polylinesMain).dottedLine(true)
				.customTexture(mGreenTexture);
		mPolyline = (Polyline) mBaiduMap.addOverlay(mainPloyline);
		// 拥堵区域
		List<LatLng> polylinesJam = new ArrayList<LatLng>();
		List<BitmapDescriptor> textureList = new ArrayList<BitmapDescriptor>();
		List<Integer> textureIndexs = new ArrayList<Integer>();
		int jamL = RoadInfoStatic.roadInfoJam.length;
		for (int index = 0; index < jamL; index++) {
			polylinesJam.add(RoadInfoStatic.roadInfoJam[index].getLl());
			if (index < jamL - 1) {
				textureIndexs.add(index);
				if (RoadInfoStatic.roadInfoJam[index].getRoadCon() == 4) {
					textureList.add(mGreenTexture);
				} else if (RoadInfoStatic.roadInfoJam[index].getRoadCon() == 2) {
					textureList.add(mYellowTexture);
				} else if (RoadInfoStatic.roadInfoJam[index].getRoadCon() == 1) {
					textureList.add(mRedTexture);
				}
			}
		}
		OverlayOptions jamOptions = new PolylineOptions().width(20).points(polylinesJam).dottedLine(true)
				.customTextureList(textureList).textureIndex(textureIndexs);
		jamPloyline = (Polyline) mBaiduMap.addOverlay(jamOptions);
		// 小车图标，表示自己所在位置
		OverlayOptions markerOptions;
		markerOptions = new MarkerOptions().flat(true).anchor(0.5f, 0.5f)
				.icon(BitmapDescriptorFactory.fromAsset("car.png")).position(polylinesMain.get(0))
				.rotate((float) MoveUtil.getAngle(0, mPolyline));// 起始旋转角度
		mMoveMarker = (Marker) mBaiduMap.addOverlay(markerOptions);

		// 拥堵区域
		LatLng pt1 = RoadInfoStatic.jamArea[0];
		LatLng pt2 = RoadInfoStatic.jamArea[1];
		LatLng pt3 = RoadInfoStatic.jamArea[2];
		LatLng pt4 = RoadInfoStatic.jamArea[3];
		List<LatLng> pts = new ArrayList<LatLng>();
		pts.add(pt1);
		pts.add(pt2);
		pts.add(pt3);
		pts.add(pt4);
		OverlayOptions ooPolygon = new PolygonOptions().points(pts).stroke(new Stroke(5, 0x66ff0000))
				.fillColor(0x16FF0000);
		mBaiduMap.addOverlay(ooPolygon);

		OverlayOptions start, end;
		start = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_st))
				.position(polylinesMain.get(0));
		end = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_en))
				.position(polylinesJam.get(polylinesJam.size() - 1));
		mBaiduMap.addOverlay(start);
		mBaiduMap.addOverlay(end);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mMapView.onResume();
		FlowerCollector.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mMapView.onPause();
		FlowerCollector.onPause(this);
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
		mRedTexture.recycle();
		mYellowTexture.recycle();
		mGreenTexture.recycle();
		mTts.destroy();
		exit = true;
		super.onDestroy();
		myFlag = false;
		mMapView.onDestroy();
		mBaiduMap.clear();
	}

	public void initWebservice() {
		WebSocketImpl.DEBUG = false;
		try {
			test = new AutobahnServerTest(54300, new Draft_6455());
			test.setConnectionLostTimeout(0);
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
					DISTANCE = (float) roadInfo.getRoadCon() / 200000;// 设置当前移动速度
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
					if (i == 3 && !exit) {
						runOnUiThread(new Runnable() {
							public void run() {
								if(!exit){
									timeDialog = new TimeDialog(context, 3000);
									timeDialog.setMessage("进入拥堵区域，开始收费！");
									timeDialog.setTitle("温馨提示");
									timeDialog.setPositiveButton("确定", null);
									timeDialog.setIcon(android.R.drawable.ic_dialog_info);
									timeDialog.show();
									timeDialog.getWindow().setGravity(Gravity.BOTTOM);
									// 开始合成
									int code = mTts.startSpeaking("进入拥堵区域，开始收费！", mSynListener);
									if (code != ErrorCode.SUCCESS) {
										if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {
											// 上面的语音配置对象为初始化时：
											Toast.makeText(JamCharge.this, "语音组件未安装", Toast.LENGTH_LONG).show();
										} else {
											Toast.makeText(JamCharge.this, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();
										}
									}
								}
							}
						});
					}
					Log.e("i", i + "++++");
					double slope = MoveUtil.getSlope(startPoint, endPoint);
					// 是不是正向的标示
					boolean isReverse = (startPoint.latitude > endPoint.latitude);

					double intercept = MoveUtil.getInterception(slope, startPoint);

					double xMoveDistance = isReverse ? MoveUtil.getXMoveDistance(slope, DISTANCE)
							: -1 * MoveUtil.getXMoveDistance(slope, DISTANCE);

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
								speed.setText(decimalFormat.format(DISTANCE * 2000000 + Math.random()));
							}
						});
						try {
							Thread.sleep(TIME_INTERVAL);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (!exit) {
						// 聚焦点
						test.setLl(endPoint.longitude + ":" + endPoint.latitude);
						builder.target(endPoint);
						builder.zoom(19.0f);
						mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
						// 终点是主干道倒数第二个点跳出弹框
						Message message = Message.obtain();
						message.what = 1;
						if (!inJam && endPoint.latitude <= lat1 && endPoint.latitude >= lat2
								&& endPoint.longitude >= lng1 && endPoint.longitude <= lng2) {// 拥堵区域内部，开始计费
							myFlag = true;
							mCount = 0;
							inJam = true;
							timeHandler.sendMessage(message);
						} else if (inJam && endPoint.longitude >= lng2) {// 结束计费
							inJam = false;
							// 开始合成
							int code = mTts.startSpeaking("缴费成功！本次拥堵计费16.9元！", mSynListener);
							if (code != ErrorCode.SUCCESS) {
								if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {
									// 上面的语音配置对象为初始化时：
									Toast.makeText(JamCharge.this, "语音组件未安装", Toast.LENGTH_LONG).show();
								} else {
									Toast.makeText(JamCharge.this, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();
								}
							}
						}
						if (i == roadInfoJamSize - 2) {
							goToEnd();
						}
						if (i == 8) {
							i = roadInfoJamSize - 7;
						}
					}
				}
			}

		}.start();
	}

	protected void goToEnd() {
		runOnUiThread(new Runnable() {
			public void run() {
				builder.target(new LatLng(31.230445, 121.475582));
				builder.zoom(15.0f);
				mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
				myFlag = false;
				upLayout.setVisibility(View.GONE);
				exit = true;
				try {
					test.stop();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 初始化方法
	private void initLayout() {
		// 页面控件初始化
		new Thread(this).start();// 启动子线程
		time = (TextView) findViewById(R.id.time);
		date = (TextView) findViewById(R.id.date);
		cardNo=(TextView)findViewById(R.id.cardNo);
		upLayout = (RelativeLayout) findViewById(R.id.upLayout);
		chargeLayout = (LinearLayout) findViewById(R.id.chargeLayout);
		/*backToHome = (Button) findViewById(R.id.backToHome);
		backToHome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});*/
		// 两个handler,控制跳转逻辑
		mHandler = new Handler(Looper.getMainLooper());
		timeHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				int what = msg.what;
				switch (what) {
				case 1:
					int arg1 = msg.arg1;
					if (inJam) {
						if (arg1 != 30) {
							time.setText("拥堵区域计费" + decimalFormat.format(arg1 * 0.05) + "元");
							time.setTextColor(Color.parseColor("#88ff0000"));
						} else if (arg1 == 30) {
							mCount = 330;
							if (!exit) {
								builder.target(new LatLng(31.236902, 121.492111));
								builder.zoom(19.0f);
								mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
								timeDialog = new TimeDialog(context, 3000);
								timeDialog.setTitle("10分钟过后...");
								timeDialog.setIcon(android.R.drawable.ic_dialog_info);
								timeDialog.show();
								timeDialog.getWindow().setGravity(Gravity.BOTTOM);
							}
						}
					} else if (mCount > 0) {
						if(!exit){
							myFlag = false;// 停止计费
							chargeLayout.setVisibility(View.VISIBLE);
							BankCard defaultCard = DataMock.getInstance().getDefaultBankCard();
							String cardString=defaultCard.getPan();
							cardNo.setText(cardString.substring(cardString.length()-4, cardString.length()));
							date.setText(DatetimeUtil.getFormatCurrentTime("yyyy-MM-dd"));
						}
					}
					break;
				}
			}
		};
	}

	@Override
	public void run() {
		while (myFlag) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 每间隔 一秒钟 发送 一个Message 给主线程的 handler让主线程的hanlder 来修改UI
			// 注意 这里的 message可以是通过obtain来获取 这样节省内存，它会自动的看有没有可以复用的，就不重复创建了
			Message message = Message.obtain();
			message.what = 1;
			message.arg1 = mCount;
			mCount++;
			timeHandler.sendMessage(message);
		}
	}

	private SynthesizerListener mSynListener = new SynthesizerListener() {
		// 会话结束回调接口，没有错误时，error为null
		public void onCompleted(SpeechError error) {
		}

		// 缓冲进度回调
		// percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
		public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
		}

		// 开始播放
		public void onSpeakBegin() {
		}

		// 暂停播放
		public void onSpeakPaused() {
		}

		// 播放进度回调
		// percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
		public void onSpeakProgress(int percent, int beginPos, int endPos) {
		}

		// 恢复播放回调接口
		public void onSpeakResumed() {
		}

		// 会话事件回调接口
		public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {
		}
	};
}
