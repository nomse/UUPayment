package com.unionpay.payment.carpay.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.unionpay.payment.carpay.data.BankCard;
import com.unionpay.payment.carpay.data.Module;
import com.unionpay.payment.carpay.data.TransRecord;
import com.unionpay.payment.carpay.utils.DatetimeUtil;

public class DataMock {

    public static String TEMP_CARD_PAN1 = "6225881309148029";
    public static String TEMP_CARD_PAN2 = "6228920100063056891";

    private List<BankCard> mBankCards = new ArrayList<BankCard>();
    private List<TransRecord> mTransRecords = new ArrayList<TransRecord>();
    private BankCard mCurBankCard;
    private BankCard mTempBankCard;

    private static DataMock mInstance;

    private DataMock() {
        initData();
    }

    public static DataMock getInstance() {
        if (mInstance == null) {
            mInstance = new DataMock();
        }
        return mInstance;
    }

    private void initData() {
        mTempBankCard = new BankCard();

        // 绑定卡列表
        BankCard card1 = new BankCard();
        card1.setId("001");
        card1.setName("Andy Wang");
        card1.setPan(TEMP_CARD_PAN1);
        card1.setCardNo("291200001156");
        card1.setValidity("0829");
        card1.setSafeCode("123");
        card1.setTelNumber("15221571231");
        card1.setDefault(true);
        BankCard card2 = new BankCard();
        card2.setId("002");
        card2.setName("Peter Pan");
        card2.setPan(TEMP_CARD_PAN2);
        card2.setCardNo("911230002381");
        card2.setValidity("0325");
        card2.setSafeCode("345");
        card2.setTelNumber("18612341923");
        card2.setDefault(false);
        mBankCards.add(card1);
        mBankCards.add(card2);

        // 消费记录
        TransRecord transRecrod1 = new TransRecord();
        transRecrod1.setId(1);
        transRecrod1.setCardPan(TEMP_CARD_PAN1);
        transRecrod1.setTransTime(System.currentTimeMillis() - 1000 * 60 * 15);
        transRecrod1.setType(Module.MODULE_1);
        transRecrod1.setAmount("-10.80");
        transRecrod1.setDesc("拥堵费-自动扣除-" + DatetimeUtil.getFormatCurrentTime("yyyy/MM/dd"));
        TransRecord transRecrod2 = new TransRecord();
        transRecrod2.setId(2);
        transRecrod2.setCardPan(TEMP_CARD_PAN2);
        transRecrod2.setTransTime(System.currentTimeMillis() - 1000 * 60 * 25);
        transRecrod2.setType(Module.MODULE_2);
        transRecrod2.setAmount("-6.00");
        transRecrod2.setDesc("高速不停车收费-自动扣除 -" + DatetimeUtil.getFormatCurrentTime("yyyy/MM/dd"));
        mTransRecords.add(transRecrod1);
        mTransRecords.add(transRecrod2);
    }

    public List<BankCard> getBankCards() {
        Collections.sort(mBankCards, new SortByDefaultCard());
        return mBankCards;
    }

    public void addBankCard(BankCard bankCard) {
        mBankCards.add(bankCard);
    }

    public void removeBankCard(BankCard bankCard) {
        mBankCards.remove(bankCard);
    }

    public void setDefaultBankCard(BankCard bankCard) {
        if (mBankCards.contains(bankCard)) {
            for (BankCard tempBankCard : mBankCards) {
                tempBankCard.setDefault(false);
            }
            bankCard.setDefault(true);
        }
    }

    /**
     * 获取默认卡,若没有则返回null
     * 
     * @return BankCard
     */
    public BankCard getDefaultBankCard() {
        for (BankCard tempBankCard : mBankCards) {
            if (tempBankCard.isDefault()) {
                return tempBankCard;
            }
        }
        return null;
    }

    public List<TransRecord> getTransRecords() {
        Collections.sort(mTransRecords, new SortByTransTime());
        return mTransRecords;
    }

    public void addTransRecord(int moduleId, String desc, String pan, float amount) {
        TransRecord transRecord = new TransRecord();
        transRecord.setType(moduleId);
        transRecord.setTransTime(System.currentTimeMillis());
        transRecord.setDesc(desc + "-" + DatetimeUtil.getFormatCurrentTime("yyyy/MM/dd"));
        transRecord.setCardPan(pan);
        transRecord.setAmount(String.format("-%.2f", amount));
        mTransRecords.add(transRecord);
    }

    /**
     * 返回指定卡号的最后一次交易记录，若没有则返回null
     * 
     * @param pan
     * @return TransRecord
     */
    public TransRecord getLastTransRecord(String pan) {
        Collections.sort(mTransRecords, new SortByTransTime());
        for (TransRecord transRecord : mTransRecords) {
            if (transRecord.getCardPan().equals(pan)) {
                return transRecord;
            }
        }
        return null;
    }

    public void removeTransRecord(TransRecord transRecord) {
        mTransRecords.remove(transRecord);
    }

    public List<Module> getModules() {
        List<Module> modules = new ArrayList<Module>();
        Module module1 = new Module(Module.MODULE_1);
        Module module2 = new Module(Module.MODULE_2);
        Module module3 = new Module(Module.MODULE_3);
        Module module4 = new Module(Module.MODULE_4);
        Module module5 = new Module(Module.MODULE_5);
        Module module6 = new Module(Module.MODULE_6);
        modules.add(module2);
        modules.add(module5);
        modules.add(module1);
        modules.add(module3);
        modules.add(module4);
        // modules.add(module6);
        return modules;
    }

    public void setCurBankCard(BankCard bankCard) {
        mCurBankCard = bankCard;
    }

    public BankCard getCurBankCard() {
        return mCurBankCard;
    }

    public void setTempBankCard(BankCard bankCard) {
        mTempBankCard = bankCard;
    }

    public BankCard getTempBankCard() {
        return mTempBankCard;
    }

    class SortByTransTime implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {
            TransRecord s1 = (TransRecord) o1;
            TransRecord s2 = (TransRecord) o2;
            return s2.getTransTime() > s1.getTransTime() ? 1 : -1;
        }
    }

    class SortByDefaultCard implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {
            BankCard s = (BankCard) o1;
            return s.isDefault() ? -1 : 1;
        }
    }
}
