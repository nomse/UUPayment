package com.unionpay.payment.carpay.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.TransRecord;
import com.unionpay.payment.carpay.widget.TransRecordListAdapter;

public class TabTransFragment extends Fragment {

    private Context mContext;
    private PullToRefreshListView mPullRefreshListView;
    private ListView mTransRecordListView;
    private TransRecordListAdapter mTransRecordAdapter;

    private List<TransRecord> mTransRecords = new ArrayList<TransRecord>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.fragment_tab_trans, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View v) {
        mPullRefreshListView = (PullToRefreshListView) v.findViewById(R.id.list_trans);
        mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                // Do work to refresh the list here.
                new GetDataTask().execute();
            }
        });
        mTransRecordListView = mPullRefreshListView.getRefreshableView();
        mTransRecordListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    private void initData() {
        mTransRecords = DataMock.getInstance().getTransRecords();

        mTransRecordAdapter = new TransRecordListAdapter(mContext, mTransRecords);
        mTransRecordListView.setAdapter(mTransRecordAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mTransRecords = DataMock.getInstance().getTransRecords();
        mTransRecordAdapter.notifyDataSetInvalidated();
    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String[] result) {
            mTransRecordAdapter.notifyDataSetChanged();

            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshListView.onRefreshComplete();

            super.onPostExecute(result);
        }
    }

}
