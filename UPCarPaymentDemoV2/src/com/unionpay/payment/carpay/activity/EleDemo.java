package com.unionpay.payment.carpay.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.data.Module;
import com.unionpay.payment.carpay.utils.DatetimeUtil;
import com.unionpay.payment.carpay.widget.LEDView;
import com.unionpay.payment.carpay.widget.TimingView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class EleDemo extends Activity implements Runnable {
	final Context context = EleDemo.this;
	TimingView timing_view ;
	private LEDView ledViewst;
	private LEDView ledViewend;
	private TextView price;
	private TextView cardNo;
	private TextView date;
	private TextView startTime;
	private TextView endTime;
	private LinearLayout chargeLayout;
	private String videoSocket;
	private Button goToHome;
	DecimalFormat decimalFormat = new DecimalFormat("0.00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
	// 计时全局变量
	private Handler timeHandler;
	private Boolean mFlag=true;
	private int mCount=0;
	SpeechSynthesizer mTts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_ele);
		timing_view = (TimingView) findViewById(R.id.timing_view);
        ledViewst = (LEDView) findViewById(R.id.ledviewst);
		ledViewend=(LEDView) findViewById(R.id.ledviewend);
		price=(TextView) findViewById(R.id.price);
		cardNo=(TextView) findViewById(R.id.cardNo);
		date=(TextView) findViewById(R.id.date);
		startTime=(TextView) findViewById(R.id.startTime);
		endTime=(TextView) findViewById(R.id.endTime);
		chargeLayout=(LinearLayout) findViewById(R.id.chargeLayout);
		ledViewst.setColor("ffffff");
		ledViewend.setColor("ffffff");
		videoSocket=getIntent().getStringExtra("videoSocket");
		initVoice();
		goToHome=(Button) findViewById(R.id.goToHome);
		goToHome.setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						new Thread(networkTask).start();// 播放概念视频
						timing_view.stopRunning();
						BankCard defaultCard = DataMock.getInstance().getDefaultBankCard();
						float timeR=(float)timing_view.getRunningTime()+1;
						Log.e("timeR", timeR+"");
						timeR/=100;
						DataMock.getInstance().addTransRecord(Module.MODULE_4, "充电加油",
				                defaultCard.getPan(), Float.parseFloat(decimalFormat.format(timeR)));
						price.setText(decimalFormat.format(timeR).toString());
						endTime.setText(ledViewend.stop());//获取结束时间
						chargeLayout.setVisibility(View.VISIBLE);
						// 开始合成
						int code = mTts.startSpeaking("缴费成功！本次充电计费"+timeR+"元", mSynListener);
						if (code != ErrorCode.SUCCESS) {
							if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {
								// 上面的语音配置对象为初始化时：
								Toast.makeText(context, "语音组件未安装", Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(context, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();
							}
						}
						mFlag=false;
						goToHome.setVisibility(View.GONE);
					}
				}
		);
		timeHandler = new Handler() {//按时间顺序处理10的时候开始计费，64的时候离开然后弹出收费框，停止计费
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				int what = msg.what;
				switch (what) {
				case 1:
					int time = msg.arg1;
					if (time==10) {
						startTime.setText(ledViewst.setNow());//设置开始时间
						date.setText(DatetimeUtil.getFormatCurrentTime("yyyy-MM-dd"));//设置日期
						BankCard defaultCard = DataMock.getInstance().getDefaultBankCard();
						String cardString=defaultCard.getPan();
						cardNo.setText(cardString.substring(cardString.length()-4, cardString.length()));//设置卡号
						Toast.makeText(context, "充电计费开始", Toast.LENGTH_SHORT).show();
						ledViewend.start();
						timing_view.startRunning();
						// 开始合成
						int code = mTts.startSpeaking("充电计费开始！", mSynListener);
						if (code != ErrorCode.SUCCESS) {
							if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {
								// 上面的语音配置对象为初始化时：
								Toast.makeText(context, "语音组件未安装", Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(context, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();
							}
						}
						goToHome.setVisibility(View.VISIBLE);
					}else if(time==63&&mFlag){
						timing_view.stopRunning();
						BankCard defaultCard = DataMock.getInstance().getDefaultBankCard();
						float timeR=(float)timing_view.getRunningTime()+1;
						Log.e("timeR", timeR+"");
						timeR/=100;
						DataMock.getInstance().addTransRecord(Module.MODULE_4, "充电加油",
				                defaultCard.getPan(), Float.parseFloat(decimalFormat.format(timeR)));
						price.setText(decimalFormat.format(timeR).toString());
						endTime.setText(ledViewend.stop());//获取结束时间
						chargeLayout.setVisibility(View.VISIBLE);
						// 开始合成
						int code = mTts.startSpeaking("缴费成功！本次充电计费0.18元", mSynListener);
						if (code != ErrorCode.SUCCESS) {
							if (code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED) {
								// 上面的语音配置对象为初始化时：
								Toast.makeText(context, "语音组件未安装", Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(context, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();
							}
						}
						mFlag=false;
					}
					break;
				}
			}
		};
		new Thread(this).start();// 启动子线程
    }
	private void initVoice() {
		// 语音初始化验证
		SpeechUtility.createUtility(context, SpeechConstant.APPID + "=596b21dc");
		mTts = SpeechSynthesizer.createSynthesizer(context, null);
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
	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mFlag=false;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mTts.destroy();
	}
	@Override
	public void run() {
		while (mFlag) {
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
			Log.e("runtime", mCount+"=============");
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
	/**
     * 网络操作相关的子线程
     */
    Runnable networkTask = new Runnable() {
        @Override
        public void run() {
            // TODO
            // 在这里进行 http request.网络请求相关操作
            try {
                Socket socket = new Socket(videoSocket, 54322);
                // 向服务器发送消息
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),
                        true);
                out.println(0);
                out.flush();
                // 接受服务器消息
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                String info = "";
                while ((info = br.readLine()) != null) {
                    System.out.println("Hello,我是客户端，服务器说：" + info);
                    out.close();
                    br.close();
                    socket.close();
                }
                
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}

