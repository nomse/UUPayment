package com.unionpay.payment.carpay.fragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.activity.ETCDemo;
import com.unionpay.payment.carpay.activity.EleDemo;
import com.unionpay.payment.carpay.activity.JamCharge;
import com.unionpay.payment.carpay.activity.ParkDemo;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.data.Module;
import com.unionpay.payment.carpay.data.TransRecord;
import com.unionpay.payment.carpay.utils.ActivityUtils;
import com.unionpay.payment.carpay.utils.DatetimeUtil;
import com.unionpay.payment.carpay.widget.CustomGridView;
import com.unionpay.payment.carpay.widget.GlideImageLoader;
import com.unionpay.payment.carpay.widget.ModuleGridAdapter;
import com.youth.banner.Banner;

public class TabHomeFragment extends Fragment implements OnClickListener {

    private Context mContext;
    private Banner mBannerView;
    private CustomGridView mGridView;
    private ModuleGridAdapter mModuleGridAdapter;
    private String videoSocket = "";
    private int videoFlag = 0;
    private List<Module> mModules = new ArrayList<Module>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.fragment_tab_home, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View v) {
        mBannerView = (Banner) v.findViewById(R.id.banner);
        mGridView = (CustomGridView) v.findViewById(R.id.gridView_module);
        mGridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onModelItemClicked(position);
            }
        });
        v.findViewById(R.id.layout_insurance).setOnClickListener(this);
        v.findViewById(R.id.layout_kfc).setOnClickListener(this);
        v.findViewById(R.id.layout_cloud_pay).setOnClickListener(this);
    }

    private void initData() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.banner_home_4);
        list.add(R.drawable.banner_home_1);
        list.add(R.drawable.banner_home_2);
        list.add(R.drawable.banner_home_3);
        mBannerView.setImages(list).setImageLoader(new GlideImageLoader()).start();

        mModules = DataMock.getInstance().getModules();
        mModuleGridAdapter = new ModuleGridAdapter(mContext, mModules);
        mGridView.setAdapter(mModuleGridAdapter);
    }

    private void onModelItemClicked(int position) {
        Module module = (Module) mModuleGridAdapter.getItem(position);
        int moduleId = module.getModuleId();
        TransRecord transRecord = new TransRecord();
        transRecord.setType(moduleId);
        transRecord.setTransTime(System.currentTimeMillis());
        File file = new File(Environment.getExternalStorageDirectory() + "/" + "socket.txt");
        if (!file.exists()) {// 文件不存在
            copyFile("socket.txt");
        }
        if (videoSocket.isEmpty() || videoSocket == "" || videoSocket == null) {
            try {
                InputStreamReader read;
                read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                videoSocket= bufferedReader.readLine(); 
                Log.e("socket", videoSocket);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(mContext, JamCharge.class);
        BankCard defaultCard = DataMock.getInstance().getDefaultBankCard();
        if (defaultCard == null) {
            showToast(mContext.getString(R.string.notice_set_default_card));
            return;
        }
        switch (moduleId) {
        case Module.MODULE_1:
            DataMock.getInstance().addTransRecord(Module.MODULE_1, "拥堵费-自动扣除",
                    defaultCard.getPan(), 16.90f);
            videoFlag = 1;
            new Thread(networkTask).start();// 播放拥堵视频
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            // ActivityUtils.showCommonActivity(mContext,
            // mContext.getString(module.getLableResId()));
            break;
        case Module.MODULE_2:
            DataMock.getInstance().addTransRecord(Module.MODULE_2, "高速不停车收费-自动扣除",
                    defaultCard.getPan(), 5.00f);
            videoFlag = 2;
            new Thread(networkTask).start();// 播放etc视频
            intent = new Intent(mContext, ETCDemo.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            // ActivityUtils.showCommonActivity(mContext,
            // mContext.getString(module.getLableResId()));
            break;
        case Module.MODULE_3:
            ActivityUtils.showShoppingEntryActivity(mContext);
            break;
        case Module.MODULE_4:
        	videoFlag=3;
	    	new Thread(networkTask).start();//播放ele视频
	    	intent = new Intent(mContext,EleDemo.class); 
	    	intent.putExtra("videoSocket", videoSocket);
	    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    	startActivity(intent);
            break;
        case Module.MODULE_5:
        	videoFlag=4;
	    	new Thread(networkTask).start();//播放park视频
	    	intent = new Intent(mContext,ParkDemo.class); 
	    	intent.putExtra("videoSocket", videoSocket);
	    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    	startActivity(intent);
            break;
        case Module.MODULE_6:
            transRecord.setDesc("ETC收费-自动扣除-" + DatetimeUtil.getFormatCurrentTime("yyyy/MM/dd"));
            // DataMock.getInstance().addTransRecord(transRecord);
            ActivityUtils.showCommonActivity(mContext, mContext.getString(module.getLableResId()));
            break;
        default:
            break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.layout_insurance:
            String insurance_url = "https://mp.weixin.qq.com/s/48mjWfAFMVL45G0EMsTvew";
            ActivityUtils.showCommonWebActivity(mContext, "阳光车险", insurance_url);
            break;
        case R.id.layout_kfc:
            String kfc_url = "http://static.95516.com/static/page/sctzb/kfc01/index.html";
            ActivityUtils.showCommonWebActivity(mContext, "KFC汽车餐厅", kfc_url);
            break;
        case R.id.layout_cloud_pay:
            String cloudpay_url = "http://mp.weixin.qq.com/s/Ce0tnhyYMglA1vM799CDSg";
            ActivityUtils.showCommonWebActivity(mContext, "银联云闪付", cloudpay_url);
            break;

        default:
            break;
        }
    }

    /**
     * 网络操作相关的子线程
     */
    Runnable networkTask = new Runnable() {
        @Override
        public void run() {
            // TODO
            // 在这里进行 http request.网络请求相关操作
            Log.e("tag333333", "+++++++++++++++++++1 " + videoSocket);
            try {
                Socket socket = new Socket(videoSocket, 54322);
                // 向服务器发送消息
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),
                        true);
                out.println(videoFlag);
                out.flush();
                socket.shutdownOutput();//关闭输出流
                // 接受服务器消息
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                String info = "";
                while ((info = br.readLine()) != null) {
                    System.out.println("Hello,我是客户端，服务器说：" + info);
                }
                out.close();
                br.close();
                socket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    // 文件操作
    private void copyFile(String fileName) {
        AssetManager assetManager = mContext.getAssets();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(fileName);
            String newFileName = Environment.getExternalStorageDirectory() + "/" + fileName;
            out = new FileOutputStream(newFileName);
            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag2", e.getMessage());
        }
    }

    @Override
    public void onResume() {
        videoFlag = 0;
        new Thread(networkTask).start();// 播放概念视频
        super.onResume();
    }

    private void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }
}
