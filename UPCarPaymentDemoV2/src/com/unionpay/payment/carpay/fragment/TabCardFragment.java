package com.unionpay.payment.carpay.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.unionpay.payment.carpay.R;
import com.unionpay.payment.carpay.cache.DataMock;
import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.utils.ActivityUtils;
import com.unionpay.payment.carpay.widget.BankCardListAdapter;

public class TabCardFragment extends Fragment {

    private Context mContext;

    private ImageView mAddCardView;
    private PullToRefreshListView mPullRefreshListView;
    private ListView mBankCardListView;
    private BankCardListAdapter mBankCardAdapter;

    private List<BankCard> mBankCards = new ArrayList<BankCard>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.fragment_tab_card, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View v) {
        mAddCardView = (ImageView) v.findViewById(R.id.img_add_card);
        mAddCardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.showAddCardActivity(mContext);
            }
        });

        mPullRefreshListView = (PullToRefreshListView) v.findViewById(R.id.list_card);
        mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                // Do work to refresh the list here.
                new GetDataTask().execute();
            }
        });
        mBankCardListView = mPullRefreshListView.getRefreshableView();
        mBankCardListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataMock.getInstance().setCurBankCard(mBankCards.get(position - 1));
                ActivityUtils.showCardDetailsActivity(mContext);
            }
        });
    }

    private void initData() {
        mBankCards = DataMock.getInstance().getBankCards();

        mBankCardAdapter = new BankCardListAdapter(mContext, mBankCards);
        mBankCardListView.setAdapter(mBankCardAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBankCards = DataMock.getInstance().getBankCards();
        mBankCardAdapter.notifyDataSetInvalidated();
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
            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshListView.onRefreshComplete();

            super.onPostExecute(result);
        }
    }
}
