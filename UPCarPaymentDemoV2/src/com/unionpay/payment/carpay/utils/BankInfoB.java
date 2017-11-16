package com.unionpay.payment.carpay.utils;

public class BankInfoB {

    private final static String[] sBankNameB = { "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司",
            "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司",
            "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司", "广发银行股份有限公司",
            "广发银行股份有限公司", "CHINA GUANGFA BANK,MACAU", "CHINA GUANGFA BANK,MACAU", "平安银行（借记卡）",
            "平安银行（借记卡）", "平安银行（借记卡）", "平安银行（借记卡）", "平安银行（借记卡）", "平安银行（借记卡）", "平安银行（借记卡）",
            "平安银行（借记卡）", "平安银行（借记卡）", "平安银行（借记卡）", "平安银行（借记卡）", "招商银行", "招商银行", "招商银行", "招商银行",
            "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行",
            "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行",
            "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行",
            "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行", "招商银行",
            "招商银行", "招商银行", "招商银行", "招商银行信用卡中心", "招商银行信用卡中心", "招商银行信用卡中心", "招商银行信用卡中心",
            "招商银行信用卡中心", "招商银行信用卡中心", "招商银行信用卡中心", "招商银行信用卡中心", "招商银行信用卡中心", "招商银行信用卡中心",
            "招商银行信用卡中心", "招商银行信用卡中心", "招商银行香港分行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行",
            "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行",
            "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行",
            "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行", "兴业银行",
            "兴业银行", "兴业银行", "兴业银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行",
            "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行",
            "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行",
            "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行",
            "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行",
            "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行",
            "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "浦东发展银行", "恒丰银行",
            "恒丰银行", "恒丰银行", "浙商银行", "浙商银行", "浙商银行", "浙商银行", "浙商银行", "浙商银行天津分行", "浙商银行上海分行",
            "浙商银行营业部", "浙商银行宁波分行", "浙商银行温州分行", "浙商银行绍兴分行", "浙商银行义乌分行", "浙商银行成都分行", "浙商银行西安分行",
            "渤海银行", "渤海银行", "渤海银行", "渤海银行", "渤海银行股份有限公司", "平安银行", "花旗银行(中国)有限公司", "花旗银行(中国)有限公司",
            "花旗中国", "花旗中国", "花旗中国", "花旗中国", "东亚银行中国有限公司", "东亚银行中国有限公司", "东亚银行中国有限公司",
            "汇丰银(中国)有限公司", "汇丰银行（中国）", "渣打银行中国有限公司", "渣打银行中国有限公司", "渣打银行(中国)", "渣打银行(中国)", "星展银行",
            "星展银行", "星展银行", "恒生银行", "恒生银行", "友利银行(中国)有限公司", "友利银行(中国)有限公司", "新韩银行", "新韩银行",
            "韩亚银行（中国）", "韩亚银行（中国）", "华侨永亨银行（中国）", "华侨永亨银行（中国）", "南洋商业银行（中国）", "南洋商业银行（中国）",
            "南洋商业银行（中国）", "南洋商业银行（中国）", "南洋商业银行（中国）", "南洋商业银行（中国）", "法国兴业银行（中国）", "大华银行（中国）",
            "大华银行（中国）", "大新银行（中国）", "企业银行（中国）", "企业银行（中国）", "华商银行", "中德住房储蓄银行", "富邦华一银行",
            "深圳前海微众银行", "天津金城银行", "上海华瑞银行股份有限公司", "温州民商", "玉山银行（中国）", "重庆富民银行", "上海银行", "上海银行",
            "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行",
            "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行",
            "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行",
            "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "上海银行", "厦门银行股份有限公司", "厦门银行股份有限公司",
            "厦门银行股份有限公司", "厦门银行股份有限公司", "厦门银行股份有限公司", "厦门银行股份有限公司", "厦门银行股份有限公司", "北京银行", "北京银行",
            "北京银行", "北京银行", "北京银行", "北京银行", "北京银行", "北京银行", "北京银行", "北京银行", "北京银行", "烟台银行", "烟台银行",
            "福建海峡银行股份有限公司", "福建海峡银行股份有限公司", "福建海峡银行股份有限公司", "福建海峡银行股份有限公司", "福建海峡银行股份有限公司",
            "福建海峡银行", "福建海峡银行", "吉林银行", "吉林银行", "吉林银行", "吉林银行", "吉林银行", "吉林银行", "镇江市商业银行",
            "镇江市商业银行", "宁波银行", "宁波银行", "宁波银行", "宁波银行", "宁波银行", "宁波银行", "宁波银行", "齐鲁银行", "齐鲁银行",
            "齐鲁银行", "平安银行", "平安银行", "平安银行", "平安银行", "平安银行", "平安银行", "焦作中旅银行", "焦作中旅银行", "焦作中旅银行",
            "焦作中旅银行", "温州银行", "温州银行", "温州银行", "温州银行", "广州银行股份有限公司", "广州银行股份有限公司", "广州银行股份有限公司",
            "广州银行股份有限公司", "汉口银行", "汉口银行", "汉口银行", "汉口银行", "汉口银行", "龙江银行股份有限公司", "盛京银行", "盛京银行",
            "盛京银行", "盛京银行", "盛京银行", "盛京银行", "盛京银行", "盛京银行", "盛京银行", "盛京银行", "洛阳银行", "洛阳银行", "洛阳银行",
            "辽阳银行股份有限公司", "辽阳银行股份有限公司", "辽阳银行股份有限公司", "辽阳银行股份有限公司", "大连银行", "大连银行", "大连银行", "大连银行",
            "大连银行", "大连银行", "大连银行", "大连银行", "大连银行", "苏州市商业银行", "河北银行股份有限公司", "河北银行股份有限公司",
            "河北银行股份有限公司", "河北银行股份有限公司", "河北银行", "杭州商业银行", "杭州商业银行", "杭州商业银行", "杭州商业银行", "杭州商业银行",
            "杭州商业银行", "南京银行", "南京银行", "南京银行", "南京银行", "南京银行", "南京银行", "南京银行", "东莞市商业银行", "东莞市商业银行",
            "东莞市商业银行", "东莞市商业银行", "东莞市商业银行", "金华银行股份有限公司", "金华银行股份有限公司", "金华银行股份有限公司",
            "金华银行股份有限公司", "金华银行股份有限公司", "乌鲁木齐银行", "乌鲁木齐银行", "乌鲁木齐银行", "乌鲁木齐银行", "乌鲁木齐银行", "乌鲁木齐银行",
            "乌鲁木齐银行", "乌鲁木齐银行", "乌鲁木齐银行", "乌鲁木齐银行", "绍兴银行股份有限公司", "绍兴银行股份有限公司", "绍兴银行", "绍兴银行",
            "绍兴银行", "绍兴银行", "成都商业银行", "成都商业银行", "成都商业银行", "成都商业银行", "成都商业银行", "成都商业银行", "成都商业银行",
            "成都商业银行", "成都商业银行", "抚顺银行股份有限公司", "抚顺银行股份有限公司", "抚顺银行股份有限公司", "抚顺银行", "抚顺银行", "临商银行",
            "临商银行", "临商银行", "宜昌市商业银行", "宜昌市商业银行", "葫芦岛市商业银行", "葫芦岛市商业银行", "葫芦岛银行", "天津市商业银行",
            "天津银行", "天津银行", "天津银行", "天津银行", "天津银行", "天津银行", "天津银行", "天津银行", "郑州银行股份有限公司",
            "郑州银行股份有限公司", "郑州银行股份有限公司", "郑州银行股份有限公司", "宁夏银行", "宁夏银行", "宁夏银行", "宁夏银行", "宁夏银行",
            "宁夏银行", "宁夏银行", "宁夏银行", "宁夏银行", "珠海华润银行股份有限公司", "珠海华润银行股份有限公司", "珠海华润银行股份有限公司", "齐商银行",
            "齐商银行", "齐商银行", "锦州银行股份有限公司", "锦州银行股份有限公司", "锦州银行股份有限公司", "徽商银行", "徽商银行", "徽商银行",
            "徽商银行", "徽商银行", "徽商银行", "徽商银行芜湖分行", "徽商银行马鞍山分行", "徽商银行淮北分行", "徽商银行安庆分行", "重庆银行",
            "重庆银行", "重庆银行", "重庆银行", "重庆银行", "哈尔滨银行", "哈尔滨银行", "哈尔滨银行", "哈尔滨银行", "哈尔滨银行",
            "贵阳银行股份有限公司", "贵阳银行股份有限公司", "贵阳银行股份有限公司", "贵阳银行股份有限公司", "贵阳银行股份有限公司", "贵阳银行股份有限公司",
            "西安银行股份有限公司", "西安银行股份有限公司", "西安银行股份有限公司", "西安银行股份有限公司", "无锡市商业银行", "无锡市商业银行",
            "无锡市商业银行", "丹东银行股份有限公司", "丹东银行股份有限公司", "丹东银行", "丹东银行", "丹东银行", "丹东银行", "兰州银行",
            "兰州银行股份有限公司", "兰州银行股份有限公司", "兰州银行股份有限公司", "兰州银行股份有限公司", "兰州银行股份有限公司", "兰州银行股份有限公司",
            "兰州银行股份有限公司", "江西银行", "江西银行", "江西银行", "江西银行", "江西银行", "晋商银行", "晋商银行", "晋商银行", "晋商银行",
            "晋商银行", "青岛银行", "青岛银行", "青岛银行", "青岛银行", "青岛银行", "青岛银行", "吉林银行", "吉林银行", "南通商业银行",
            "南通商业银行", "南通商业银行", "九江银行股份有限公司", "九江银行股份有限公司", "九江银行股份有限公司", "日照银行", "日照银行", "日照银行",
            "鞍山银行", "鞍山银行", "鞍山银行", "秦皇岛银行股份有限公司", "秦皇岛银行股份有限公司", "秦皇岛银行股份有限公司", "秦皇岛银行股份有限公司",
            "秦皇岛银行", "青海银行", "青海银行", "青海银行", "青海银行", "台州银行", "台州银行", "台州银行", "台州银行", "台州银行",
            "台州银行", "盐城商行", "长沙银行股份有限公司", "长沙银行股份有限公司", "长沙银行股份有限公司", "长沙银行股份有限公司", "长沙银行股份有限公司",
            "长沙银行股份有限公司", "长沙银行股份有限公司", "长沙银行股份有限公司", "长沙银行股份有限公司", "长沙银行股份有限公司", "长沙银行股份有限公司",
            "长沙银行股份有限公司", "长沙银行股份有限公司", "潍坊银行", "潍坊银行", "潍坊银行", "赣州银行股份有限公司", "赣州银行股份有限公司",
            "赣州银行股份有限公司", "泉州银行", "泉州银行", "泉州银行", "泉州银行", "泉州银行", "营口银行股份有限公司", "营口银行股份有限公司",
            "昆明商业银行", "昆明商业银行", "昆明商业银行", "阜新银行股份有限公司", "阜新银行", "阜新银行", "嘉兴银行", "廊坊银行", "廊坊银行",
            "廊坊银行", "廊坊银行", "泰隆城市信用社", "泰隆城市信用社", "内蒙古银行", "内蒙古银行", "内蒙古银行", "内蒙古银行", "湖州市商业银行",
            "湖州市商业银行", "沧州银行股份有限公司", "沧州银行股份有限公司", "沧州银行股份有限公司", "沧州银行", "沧州银行", "南宁市商业银行",
            "南宁市商业银行", "包商银行", "包商银行", "包商银行", "包商银行", "包商银行", "包商银行", "包商银行", "包商银行", "包商银行",
            "包商银行", "包商银行", "连云港市商业银行", "威海商业银行", "威海商业银行", "攀枝花市商业银行", "攀枝花市商业银行", "绵阳市商业银行",
            "泸州市商业银行", "泸州市商业银行", "大同银行", "大同银行", "广东南粤银行", "广东南粤银行", "广东南粤银行", "张家口银行", "张家口银行",
            "桂林银行", "桂林银行", "桂林银行", "桂林银行", "龙江银行", "龙江银行", "龙江银行", "龙江银行", "龙江银行", "龙江银行", "龙江银行",
            "龙江银行", "龙江银行", "江苏长江商业银行", "江苏长江商业银行", "徐州市商业银行", "柳州银行股份有限公司", "柳州银行股份有限公司",
            "柳州银行股份有限公司", "柳州银行股份有限公司", "柳州银行股份有限公司", "柳州银行股份有限公司", "四川天府银行", "四川天府银行", "四川天府银行",
            "莱商银行", "莱芜银行", "莱商银行", "莱商银行", "长城华西银行", "长城华西银行", "长城华西银行", "长城华西银行", "长城华西银行",
            "唐山银行", "唐山银行", "唐山银行", "曲靖市商业银行", "曲靖市商业银行", "晋城银行股份有限公司", "晋城银行股份有限公司", "东莞商行",
            "东莞商行", "温州银行", "温州银行", "温州银行", "温州银行", "汉口银行", "汉口银行", "汉口银行", "汉口银行", "汉口银行", "汉口银行",
            "江苏银行", "江苏银行", "江苏银行", "江苏银行", "江苏银行", "江苏银行", "江苏银行", "江苏银行", "江苏银行", "江苏银行", "江苏银行",
            "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司",
            "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司",
            "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司",
            "平安银行股份有限公司", "平安银行股份有限公司", "长治银行股份有限公司", "长治银行股份有限公司", "承德市商业银行", "承德银行", "承德银行",
            "德州银行", "德州银行", "邯郸银行", "邯郸银行", "邯郸银行", "江苏银行", "江苏银行", "江苏银行", "江苏银行", "平凉市商业银行",
            "云南红塔银行", "云南红塔银行", "云南红塔银行", "浙江民泰商业银行", "浙江民泰商业银行", "浙江民泰商业银行", "浙江民泰商业银行",
            "浙江民泰商业银行", "上饶市商业银行", "东营银行", "东营银行", "泰安银行", "泰安银行", "浙江稠州商业银行", "浙江稠州商业银行",
            "浙江稠州商业银行", "乌海银行股份有限公司", "乌海银行股份有限公司", "自贡银行", "自贡银行", "龙江银行股份有限公司", "鄂尔多斯银行",
            "鄂尔多斯银行股份有限公司", "鄂尔多斯银行股份有限公司", "鄂尔多斯银行股份有限公司", "鄂尔多斯银行股份有限公司", "济宁银行股份有限公司",
            "济宁银行股份有限公司", "铁岭银行", "铁岭银行", "乐山市商业银行", "乐山市商业银行", "长安银行", "长安银行", "长安银行", "长安银行",
            "宝鸡商行", "重庆三峡银行", "重庆三峡银行", "石嘴山银行", "石嘴山银行", "石嘴山银行", "盘锦银行", "盘锦银行", "昆仑银行股份有限公司",
            "昆仑银行股份有限公司", "昆仑银行股份有限公司", "平顶山银行股份有限公司", "平顶山银行股份有限公司", "平顶山银行", "朝阳银行", "朝阳银行",
            "朝阳银行", "宁波东海银行", "宁波东海银行", "遂宁银行", "遂宁银行", "保定银行", "保定银行", "邢台银行股份有限公司", "邢台银行",
            "凉山州商业银行", "凉山州商业银行", "漯河银行", "达州银行", "达州银行", "晋中银行", "晋中银行", "驻马店银行", "衡水银行", "衡水银行",
            "衡水银行", "周口银行", "阳泉市商业银行", "阳泉市商业银行", "宜宾市商业银行", "宜宾市商业银行", "库尔勒银行", "雅安市商业银行",
            "雅安市商业银行", "信阳银行", "华融湘江银行", "华融湘江银行", "营口沿海银行", "营口沿海银行", "景德镇商业银行", "哈密市商业银行",
            "哈密市商业银行", "湖北银行", "湖北银行", "湖北银行", "湖北银行", "湖北银行", "湖北银行", "湖北银行", "湖北银行", "西藏银行",
            "新疆汇和银行", "广东华兴银行", "广东华兴银行", "广东华兴银行", "广东华兴银行", "广东华兴银行", "广东华兴银行", "广东华兴银行",
            "广东华兴银行", "宁波通商银行", "宁波通商银行", "甘肃银行", "甘肃银行", "甘肃银行", "甘肃银行", "甘肃银行", "枣庄银行",
            "本溪市商业银行", "本溪市商业银行", "贵州银行", "贵州银行", "贵州银行", "贵州银行", "贵州银行", "苏州银行", "苏州银行", "苏州银行",
            "苏州银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行",
            "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "中原银行", "厦门国际银行",
            "海南银行", "邯郸银行", "新疆银行", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司", "平安银行股份有限公司",
            "上海农商银行", "上海农商银行", "上海农商银行", "上海农商银行", "上海农商银行", "上海农商银行", "上海农商银行", "昆山农信社", "昆山农信社",
            "昆山农信社", "常熟市农村商业银行", "常熟市农村商业银行", "常熟市农村商业银行", "常熟农村商业银行", "常熟农村商业银行", "常熟农村商业银行",
            "常熟农村商业银行", "深圳农村商业银行", "深圳农村商业银行", "深圳农村商业银行", "深圳农村商业银行", "深圳农村商业银行", "广州农村商业银行",
            "广州农村商业银行股份有限公司", "广州农村商业银行股份有限公司", "广州农村商业银行股份有限公司", "广州农村商业银行股份有限公司", "广东南海农村商业银行",
            "广东南海农村商业银行", "广东顺德农村商业银行", "广东顺德农村商业银行", "广东顺德农村商业银行", "昆明农联社", "昆明农联社", "昆明农联社",
            "昆明农联社", "昆明农联社", "湖北农信", "湖北农信社", "湖北农信社", "湖北农信社", "湖北农信社", "湖北农信社", "湖北农信社", "武汉农信",
            "徐州市郊农村信用合作联社", "江阴农村商业银行", "江阴市农村商业银行", "江阴农村商业银行", "江阴农村商业银行", "江阴农村商业银行",
            "重庆农村商业银行股份有限公司", "重庆农村商业银行", "重庆农村商业银行", "重庆农村商业银行", "重庆农村商业银行", "重庆农村商业银行",
            "山东农村信用联合社", "山东农村信用联合社", "山东农村信用联合社", "山东省农村信用社联合社", "山东省农村信用社联合社", "山东省农村信用社联合社",
            "山东省农村信用社联合社", "青岛农信", "青岛农信", "青岛农信", "东莞农村商业银行", "东莞农村商业银行", "东莞农村商业银行", "东莞农村商业银行",
            "东莞农村商业银行", "东莞农村商业银行", "张家港农村商业银行", "张家港农村商业银行", "张家港农村商业银行", "福建省农村信用社联合社",
            "福建省农村信用社联合社", "福建省农村信用社联合社", "福建省农村信用社联合社", "福建省农村信用社联合社", "福建省农村信用社联合社",
            "福建省农村信用社联合社" };

    private final static String[] sBankBinB = { "625808", "625809", "625810", "628259", "628260",
            "620037", "621462", "622568", "623259", "623506", "62364873", "685800", "6858000",
            "6858001", "6858009", "9111", "623365", "623366", "412962", "412963", "415752",
            "415753", "620010", "622535", "622536", "622538", "622539", "622983", "998800",
            "690755", "356885", "356886", "356887", "356888", "356889", "356890", "402658",
            "410062", "439188", "439227", "468203", "479228", "479229", "512425", "521302",
            "524011", "545619", "545620", "545621", "545623", "545947", "545948", "552534",
            "552587", "621276", "621286", "621483", "621485", "621486", "622575", "622576",
            "622577", "622578", "622579", "622580", "622581", "622582", "622588", "622598",
            "622609", "623126", "623136", "623262", "623563", "625657", "628290", "95555",
            "690755", "620520", "62326536", "370285", "370286", "370287", "370289", "439225",
            "439226", "518710", "518718", "625802", "625803", "628262", "628362", "621299",
            "90592", "623287", "438588", "438589", "622908", "622909", "966666", "451289",
            "451290", "461982", "486493", "486494", "486861", "523036", "524070", "527414",
            "528057", "548738", "549633", "552398", "622571", "622572", "622573", "622591",
            "622592", "622593", "622901", "622902", "622922", "625082", "625083", "625084",
            "625085", "625086", "625087", "625353", "625356", "625960", "625961", "625962",
            "625963", "628212", "356850", "356851", "356852", "404738", "404739", "456418",
            "498451", "515672", "517650", "525998", "621351", "621352", "621390", "621791",
            "621792", "621793", "621795", "621796", "622176", "622177", "622228", "622276",
            "622277", "622500", "622516", "622517", "622518", "622519", "622520", "622521",
            "622522", "622523", "623250", "623559", "623658", "625957", "625958", "628222",
            "84301", "84336", "84342", "84361", "84373", "84380", "84385", "84390", "87000",
            "87010", "87030", "87040", "87050", "984301", "984303", "620530", "622384", "623078",
            "940034", "621019", "622309", "62326528", "625821", "628324", "6223091100",
            "6223092900", "6223093310", "6223093320", "6223093330", "6223093370", "6223093380",
            "6223096510", "6223097910", "621268", "621453", "622684", "622884", "625122", "623269",
            "621062", "621063", "625076", "625077", "625074", "625075", "622933", "622938",
            "623031", "622946", "625102", "622942", "622994", "622583", "622584", "621015",
            "621016", "623187", "622950", "622951", "621060", "623551", "621072", "623630",
            "621201", "623513", "621077", "621298", "621213", "621289", "621290", "621291",
            "621292", "623555", "621245", "621328", "623176", "621277", "621651", "62326516",
            "623163", "623526", "623565", "623633", "623616", "623622", "623632", "623661",
            "627061", "621005", "623183", "623185", "620522", "621050", "621243", "622172",
            "622267", "622278", "622279", "622468", "622892", "622985", "622987", "940021",
            "356827", "356828", "356829", "356830", "402673", "402674", "438600", "486466",
            "519498", "519961", "520131", "524031", "548838", "622148", "622149", "622268",
            "622269", "622300", "625099", "625180", "625350", "625351", "625352", "625839",
            "625953", "628230", "622393", "940023", "6886592", "621600", "623019", "623514",
            "623663", "421317", "422160", "422161", "602969", "621030", "621420", "621468",
            "623111", "623283", "623561", "623562", "622886", "623533", "622388", "620043",
            "621267", "621664", "623063", "622695", "628360", "940012", "622865", "622178",
            "622179", "628358", "623131", "622394", "940025", "621279", "622281", "622316",
            "940022", "620533", "621418", "623252", "622379", "62326575", "940008", "621626",
            "623058", "602907", "622298", "622986", "622989", "940032", "622338", "623205",
            "623511", "621977", "623112", "62326531", "623578", "603445", "621463", "622467",
            "940016", "622325", "623029", "623105", "62326510", "990027", "622475", "621244",
            "623081", "623108", "622955", "566666", "622455", "940039", "622466", "625811",
            "628285", "622420", "940041", "623118", "628309", "622399", "940043", "623151",
            "603708", "622993", "623069", "623070", "623172", "623173", "622383", "622385",
            "628299", "603506", "622498", "622499", "623000", "940046", "623582", "603367",
            "622878", "623061", "623209", "62326513", "62326527", "622303", "622595", "622596",
            "628242", "621259", "622305", "623270", "622333", "940050", "621439", "623010",
            "623278", "622449", "622450", "623067", "628204", "940051", "622476", "625135",
            "625155", "625502", "625503", "628278", "621751", "621754", "622143", "940001",
            "622486", "603602", "623026", "623086", "62326535", "628291", "621482", "621532",
            "622135", "622152", "622153", "622154", "622996", "622997", "940027", "622442",
            "940053", "622442", "623099", "628302", "622359", "623007", "940066", "940055",
            "622397", "622398", "940054", "623598", "940015", "6091201", "621452", "622331",
            "623554", "623574", "622426", "625995", "628205", "96828", "940056", "622421",
            "623531", "622428", "625335", "625529", "628214", "621417", "623089", "623200",
            "621529", "622429", "621455", "622363", "940048", "622311", "940057", "623119",
            "622990", "940003", "623568", "603601", "622877", "622879", "623291", "621775",
            "623203", "622137", "622327", "622340", "622366", "622134", "623016", "940018", "9896",
            "623096", "622425", "940049", "621577", "622425", "62326501", "888", "621552",
            "621735", "622133", "622170", "62326519", "622136", "622981", "623165", "623277",
            "60326500", "60326513", "622485", "622415", "940060", "623098", "62326533", "625190",
            "628329", "621538", "622139", "940040", "621242", "621496", "623129", "623275",
            "623541", "621269", "622275", "62326522", "940006", "621359", "622465", "940031",
            "621216", "623179", "62326538", "621252", "622146", "940061", "620551", "621419",
            "623170", "622440", "940047", "622418", "69580", "940017", "622162", "622307",
            "623146", "622857", "623077", "940065", "622413", "940002", "623188", "621237",
            "62249802", "94004602", "623003", "628357", "622310", "623599", "623670", "940068",
            "622321", "625001", "622427", "628273", "940069", "623039", "940070", "694301",
            "621446", "622368", "940071", "622806", "622898", "622900", "625901", "628281",
            "628282", "628283", "620519", "621739", "622391", "940072", "62326529", "622967",
            "623127", "940073", "628319", "683970", "940074", "621437", "622370", "622400",
            "623177", "622308", "990871", "621415", "622126", "623166", "62326552", "622132",
            "621340", "621341", "622140", "623073", "622141", "621480", "621633", "622147",
            "623057", "62326525", "622301", "623171", "621266", "62249804", "94004604", "621422",
            "628395", "622335", "623001", "621760", "622336", "623273", "623592", "623631",
            "622165", "622315", "623210", "625359", "625950", "628295", "622337", "622411",
            "623102", "622342", "623048", "622367", "622392", "623085", "622395", "622925",
            "622448", "62326571", "623595", "622982", "621413", "621456", "622856", "623221",
            "621562", "622860", "621037", "621097", "621588", "622644", "623032", "623216",
            "62326503", "623518", "622870", "623150", "622866", "620118", "622880", "622881",
            "621412", "622291", "622292", "622897", "623072", "623285", "628279", "622864",
            "621403", "62326526", "622561", "622562", "622563", "623137", "623264", "622167",
            "623193", "62326558", "622777", "621497", "622532", "623197", "622888", "628398",
            "622868", "622899", "625988", "628255", "622566", "622567", "622625", "622626",
            "625946", "628200", "504923", "622422", "622447", "940076", "621076", "621579",
            "622131", "622173", "622873", "622876", "623279", "356868", "356869", "435744",
            "435745", "483536", "526855", "528020", "531659", "622155", "622156", "622157",
            "622525", "622526", "625360", "625361", "625823", "625825", "628296", "998801",
            "998802", "622962", "623509", "622936", "623060", "62326515", "622937", "623101",
            "622960", "623523", "623653", "622283", "625902", "628210", "62844805", "621010",
            "628351", "622980", "623135", "620517", "621088", "621726", "622740", "625036",
            "621014", "621004", "623130", "622972", "623196", "621028", "623083", "628250",
            "622973", "623153", "621070", "623121", "622977", "628253", "62364302", "628378",
            "622978", "623093", "621200", "623116", "621038", "623180", "621086", "621498",
            "621296", "621448", "621551", "628385", "621044", "621755", "622945", "622940",
            "623120", "628355", "621089", "623161", "621029", "621766", "623139", "621071",
            "623152", "628339", "621074", "621515", "623030", "621345", "623167", "621090",
            "623178", "621091", "623168", "621238", "628325", "621057", "623199", "628303",
            "621233", "623588", "621223", "621780", "628389", "621239", "623068", "628380",
            "628315", "621272", "621738", "621273", "623079", "621263", "621325", "623084",
            "628331", "621366", "621388", "621348", "620063", "623080", "621360", "623566",
            "622396", "622511", "621217", "621270", "622959", "623076", "625850", "628340",
            "621391", "621339", "621469", "621625", "623113", "623293", "623611", "623627",
            "623665", "623688", "621655", "623537", "621636", "623182", "62326523", "625201",
            "628356", "623087", "621696", "623577", "621591", "622508", "622961", "622939",
            "621460", "621461", "622855", "62326542", "623521", "622441", "623505", "623660",
            "621235", "621035", "621075", "621221", "621271", "621327", "621337", "621601",
            "621748", "621753", "6224217", "622979", "623037", "623138", "623160", "62326565",
            "623623", "623621", "628377", "623667", "627066", "627067", "627068", "627069",
            "621495", "622478", "940013", "621688", "623162", "62326508", "623552", "622443",
            "623132", "940029", "622462", "625101", "628272", "603694", "622323", "623071",
            "9400301", "622128", "622129", "623035", "623186", "623296", "621522", "622439",
            "623257", "909810", "940035", "622271", "940037", "622322", "940038", "985262",
            "622369", "18572", "940042", "621017", "623190", "621523", "621013", "622412",
            "623055", "623276", "625889", "628254", "940044", "622312", "628381", "622481",
            "622341", "623115", "940058", "940020", "621258", "621465", "621528", "622867",
            "622885", "622319", "900105", "900205", "621521", "621690", "622320", "628375",
            "62231902", "90010502", "90020502", "625288", "625888", "628298", "622328", "623038",
            "940062", "622332", "623123", "940063", "621251", "621589", "621701", "622127",
            "622184", "623036", "62326562" };

    public static String getNameOfBank(String pan) {
        int len = sBankBinB.length;
        int index = -1;
        for (int i = 0; i < len; i++) {
            if (pan.startsWith(sBankBinB[i])) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return "";
        }
        return sBankNameB[index];
    }

}