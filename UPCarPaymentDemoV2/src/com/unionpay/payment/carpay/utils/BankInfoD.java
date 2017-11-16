package com.unionpay.payment.carpay.utils;

public class BankInfoD {

    private final static String[] sBankNameD = { "无棣中成村镇银行", "莱芜中成村镇银行", "自贡中成村镇银行", "犍为中成村镇银行",
            "峨嵋山中成村镇银行", "长宁中成村镇银行", "筠连中成村镇银行", "南部县中成村镇银行", "南充嘉陵中成村镇银行", "昆明马金铺中成村镇银行",
            "昆明东川中成村镇银行", "昆明石林中成村镇银行", "昆明禄劝中成村镇银行", "昆明寻甸中成村镇银行", "玉溪澄江中成村镇银行", "大理古城中成村镇银行",
            "泸水中成村镇银行", "鄯善中成村镇银行", "富蕴中成村镇银行", "德庆华润村镇银行", "百色右江华润村镇银行", "珠海横琴村镇银行", "江苏沛县汉源村镇银行",
            "江苏新沂汉源村镇银行", "西安高陵阳光村镇银行", "西安高陵阳光村镇银行", "陕西洛南阳光村镇银行", "陕西洛南阳光村镇银行", "浙江缙云杭银村镇银行",
            "浙江缙云联合村镇银行", "江苏邳州陇海村镇银行股份有限公 ", "定安合丰村镇银行", "澳洲联邦（栾城）村镇银行", "澳洲联邦银行（辛集）村镇银行",
            "澳洲联邦（邯郸县）村镇银行", "澳洲联邦（魏县）村镇银行", "澳洲联邦（成安）村镇银行", "澳洲联邦银行（磁县）村镇银行", "澳洲联邦（涉县）村镇银行",
            "澳洲联邦银行（永年）村镇银行", "澳洲联邦银行登封村镇银行", "澳洲联邦村镇银行兰考村镇银行", "澳洲联邦村镇银行伊川村镇银行", "澳洲联邦村镇银行温县村镇银行",
            "澳洲联邦村镇银行济源村镇银行", "澳洲联邦银行(渑池)村镇银行", "澳洲联邦银行(永城)村镇银行", "奉化罗蒙村镇银行", "天津滨海德商村镇银行",
            "江苏丹阳保得村镇银行", "余杭德商村镇银行", "海宁德商村镇银行", "浙江秀洲德商村镇银行", "浙江定海德商村镇银行", "范县德商村镇银行",
            "台前德商村镇银行", "襄城汇浦村镇银行", "民权德商村镇银行", "宁陵德商村镇银行", "睢县德商村镇银行", "江苏溧水民丰村镇银行", "江苏丰县民丰村镇银行",
            "江苏灌云民丰村镇银行", "江苏灌南民丰村镇银行", "安徽宿松民丰村镇银行", "安徽明光民丰村镇银行", "山东梁山民丰村镇银行", "山东肥城民丰村镇银行",
            "庆阳市西峰瑞信村镇银行", "鹿泉恒升村镇银行", "正定恒升村镇银行", "晋州恒升村镇银行", "藁城恒升村镇银行", "浙江永嘉恒升村镇银行",
            "浙江台州黄岩恒升村镇银行", "关岭恒升村镇银行", "贵定恒生村镇银行", "惠水恒升村镇银行", "清镇兴邦村镇银行", "六盘水钟山凉都村镇银行",
            "遵义汇川黔兴村镇银行", "平坝鼎立村镇银行", "安顺西航南马村镇银行", "滦平盛阳村镇银行", "香河益民村镇银行", "江苏洪泽金阳光村镇银行",
            "余姚通济村镇银行", "大洼恒丰村镇银行", "盘山安泰村镇银行股份有限公司", "浙江庆元泰隆村镇银行", "湖北大冶泰隆村镇银行", "浙江龙游义商村镇银行",
            "行唐利丰村镇银行", "保定满城区利丰村镇银行", "涞水利丰村镇银行", "怀来利丰村镇银行", "涿鹿利丰村镇银行", "荥阳利丰村镇银行",
            "乌鲁木齐县利丰村镇银行", "奇台利丰村镇银行", "乌苏利丰村镇银行", "汝州玉川村镇银行", "沂源博商村镇银行", "北京大兴华夏村镇银行",
            "四川江油华夏村镇银行", "昆明呈贡华夏村镇银行", "上海浦东恒通村镇银行", "浙江富阳恒通村镇银行", "浙江松阳恒通村镇银行", "九江恒通村镇银行",
            "鹰潭月湖恒通村镇银行", "横峰恒通村镇银行", "余干恒通村镇银行", "鄱阳恒通村镇银行", "西安雁塔恒通村镇银行", "太原市尖草坪区信都村镇银行",
            "阳高县兴都村镇银行", "大同市南郊区京都村镇银行", "平定县昌都村镇银行", "长治县泰都村镇银行", "武乡县泽都村镇银行", "应县金都村镇银行",
            "代县泓都村镇银行", "宁武县瑞都村镇银行", "忻州市忻府区秀都村镇银行", "汾阳市九都村镇银行有限公司", "文水县润都村镇银行", "临县泉都村镇银行",
            "交口融都村镇银行", "和顺县贵都村镇银行", "寿阳县汇都村镇银行", "介休市华都村镇银行", "临汾市尧都区惠都村镇银行", "襄汾万都村镇银行",
            "洪洞县洪都村镇银行", "河津市龙都村镇银行", "广饶梁邹村镇银行", "费县梁邹村镇银行", "辽宁台安金安村镇银行", "辽宁海城金海村镇银行",
            "辽宁岫岩金玉村镇银行", "辽宁千山金泉村镇银行", "郏县广天村镇银行", "宁夏中宁青银村镇银行", "浙江嵊州瑞丰村镇银行", "浙江玉环永兴村镇银行",
            "绥中长丰村镇银行", "建昌恒昌村镇银行", "兴城长兴村镇银行", "铁岭新星村镇银行", "无为徽银村镇银行", "金寨徽银村镇银行", "调兵山惠民村镇银行",
            "庄河汇通村镇银行", "大连经济技术开发区鑫汇村镇银行 ", "西昌金信村镇银行", "江苏通州华商村镇银行", "乐亭舜丰村镇银行", "唐山市丰南舜丰村镇银行",
            "大城舜丰村镇银行", "霸州舜丰村镇银行", "广阳舜丰村镇银行", "青岛黄岛舜丰村镇银行", "山东利津舜丰村镇银行", "山东惠民舜丰村镇银行",
            "黔西花都村镇银行", "中山古镇南粤村镇银行", "元氏信融村镇银行", "元氏信融村镇银行", "朝阳柳城村镇银行", "修文江海村镇银行", "贵阳小河科技村镇银行",
            "扬中恒丰村镇银行", "重庆云阳恒丰村镇银行", "重庆江北恒丰村镇银行", "上海闵行上银村镇银行", "浙江衢州衢江上银村镇银行", "崇州上银村镇银行",
            "垦利乐安村镇银行", "莱阳胶东村镇银行", "牟平胶东村镇银行", "夏津胶东村镇银行", "齐河胶东村镇银行", "禹城胶东村镇银行", "宁津胶东村镇银行",
            "许昌新浦村镇银行", "呼和浩特市赛罕金谷村镇银行", "献县融和村镇银行", "东营融和村镇银行", "北京昌平包商村镇银行", "天津津南村镇银行",
            "清徐惠民村镇银行", "固阳包商村镇银行", "宁城包商村镇银行", "莫力达瓦包商村镇银行", "鄂温克包商村镇银行", "科尔沁包商村镇银行",
            "西乌珠穆沁包商惠丰村镇银行", "集宁包闹村镇银行", "化德包商村镇银行", "准格尔旗包商村镇银行", "乌审旗包商村镇银行", "大连金州联丰村镇银行",
            "九台龙嘉村镇银行", "江苏南通如皋包商村镇银行", "仪征包商村镇银行", "鄄城包商村镇银行", "漯河市郾城包商村镇银行", "掇刀包商村镇银行",
            "武冈包商村镇银行", "新都桂城村镇银行", "广元包商贵民村镇银行", "贵阳花溪建设村镇银行", "息烽包商黔隆村镇银行", "毕节发展村镇银行",
            "宁夏贺兰回商村镇银行", "浙江浦江嘉银村镇银行", "临高惠丰村镇银行", "东方惠丰村镇银行", "乐东惠丰村镇银行", "浑源县慧融村镇银行",
            "怀仁县惠融村镇银行", "保德县慧融村镇银行", "岚县慧融村镇银行", "临沂河东齐商村镇银行", "北京延庆村镇银行", "农安北银村镇银行",
            "繁峙县新田村镇银行", "曲沃县新田村镇银行", "临猗县新田村镇银行", "新绛县新田村镇银行", "娄烦县三禾村镇银行", "屯留县三禾村镇银行",
            "阳城县三禾村镇银行", "永济市三禾村镇银行", "淇县中原村镇银行", "信阳平桥中原村镇银行", "武安村镇银行", "深州丰源村镇银行", "前郭县阳光村镇银行",
            "云霄润发村镇银行", "东山润鑫村镇银行", "平和润丰村镇银行", "远安金古村镇银行", "五峰金谷村镇银行", "昆明晋宁融丰村镇银行", "昆明宜良融丰村镇银行",
            "依兰惠鑫村镇银行", "哈尔滨宾州村镇银行", "哈尔滨农信村镇银行", "宝清广益村镇银行", "海伦惠丰村镇银行", "五大连池惠丰村镇银行",
            "安徽固镇新淮河村镇银行", "安徽黟县新淮河村镇银行", "禹州新民生村镇银行", "上蔡惠民村镇银行", "山东芝罘齐丰村镇银行", "山东莱山齐丰村镇银行",
            "山东泗水齐丰村镇银行", "山东新泰齐丰村镇银行", "山东冠县齐丰村镇银行", "山东蒙阴齐丰村镇银行", "南江农科村镇银行", "平昌农科村镇银行",
            "鄂尔多斯市天骄蒙银村镇银行", "辽宁太子河村镇银行", "上海嘉定洪都村镇银行", "昌乐乐安村镇银行", "庆云乐安村镇银行", "青海湟中三江村镇银行",
            "青海乐都三江村镇银行", "山东商河汇金村镇银行", "山东临淄汇金村镇银行", "葫芦岛国信村镇银行", "东港同合村镇银行", "兴义万丰村镇银行",
            "贵安新区发展村镇银行", "阿拉善左旗黄河村镇银行", "凤城丰益村镇银行", "东亚银行有限公司", "东亚银行有限公司", "东亚银行有限公司",
            "东亚银行有限公司", "东亚银行有限公司", "东亚银行有限公司", "东亚银行澳门分行", "花旗银行有限公司", "花旗银行有限公司", "大新银行有限公司",
            "大新银行有限公司", "大新银行有限公司", "大新银行有限公司", "大新银行有限公司", "大新银行有限公司", "大新银行有限公司", "大新银行有限公司",
            "大新银行有限公司", "大新银行有限公司", "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司",
            "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司", "中国建设银行亚洲股份有限公司", "中国建设银行亚洲股份有限公司", "中国建设银行亚洲股份有限公司",
            "中国建设银行亚洲股份有限公司", "中国建设银行亚洲股份有限公司", "中国建设银行亚洲股份有限公司", "中国建设银行亚洲股份有限公司",
            "中国建设银行亚洲股份有限公司", "中国建设银行亚洲股份有限公司", "星展银行香港有限公司", "星展银行香港有限公司", "星展银行香港有限公司",
            "星展银行香港有限公司", "星展银行香港有限公司", "星展银行香港有限公司", "星展银行香港有限公司", "星展银行香港有限公司", "星展银行香港有限公司",
            "星展银行香港有限公司", "星展银行香港有限公司", "星展银行香港有限公司", "上海商业银行", "上海商业银行", "上海商业银行", "上海商业银行",
            "永隆银行有限公司", "永隆银行有限公司", "永隆银行有限公司", "永隆银行有限公司", "永隆银行有限公司", "永隆银行有限公司", "永隆银行有限公司",
            "香港上海汇丰银行有限公司", "香港上海汇丰银行有限公司", "香港上海汇丰银行有限公司", "香港上海汇丰银行有限公司", "香港上海汇丰银行有限公司",
            "香港上海汇丰银行有限公司", "香港上海汇丰银行有限公司", "香港上海汇丰银行有限公司", "香港上海汇丰银行有限公司", "恒生银行有限公司", "恒生银行有限公司",
            "恒生银行有限公司", "恒生银行有限公司", "恒生银行有限公司", "恒生银行有限公司", "恒生银行", "恒生银行", "恒生银行", "恒生银行", "恒生银行",
            "恒生银行", "中信银行（国际）", "中信银行（国际）", "中信银行（国际）", "中信银行（国际）", "中信银行（国际）", "中信银行（国际）",
            "中信银行（国际）", "创兴银行有限公司", "创兴银行有限公司", "创兴银行有限公司", "创兴银行有限公司", "创兴银行有限公司", "创兴银行有限公司",
            "创兴银行有限公司", "创兴银行有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司",
            "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司",
            "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司",
            "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司",
            "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司",
            "中银信用卡(国际)有限公司", "中银信用卡(国际)有限公司", "中国银行（香港）", "中国银行（香港）", "中国银行（香港）", "中国银行（香港）",
            "中国银行（香港）", "中国银行（香港）", "中国银行（香港）", "南洋商业银行", "南洋商业银行", "南洋商业银行", "南洋商业银行", "南洋商业银行",
            "南洋商业银行", "南洋商业银行", "南洋商业银行", "集友银行", "集友银行", "集友银行", "集友银行", "集友银行", "集友银行", "集友银行",
            "集友银行", "AEON信贷财务亚洲有限公司", "大丰银行有限公司", "大丰银行有限公司", "大丰银行有限公司", "大丰银行有限公司", "大丰银行有限公司",
            "大丰银行有限公司", "中国建设银行澳门分行", "中国建设银行澳门分行", "中国建设银行澳门分行", "渣打银行（香港）", "渣打银行香港有限公司",
            "渣打银行香港有限公司", "渣打银行香港有限公司", "渣打银行香港有限公司", "中国银盛", "中国建设银行（亚洲）",
            "K & R International Limited", "K & R International Limited",
            "K & R International Limited", "PrimeCredit", "PrimeCredit",
            "33 Financial Services Limited  ", "33 Financial Services Limited  ",
            "33 Financial Services Limited  ", "33 Financial Services Limited  ",
            "Kasikorn Bank PCL", "Kasikorn Bank PCL", "Kasikorn Bank PCL", "Travelex", "Travelex",
            "Travelex", "Travelex", "新加坡大华银行", "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司",
            "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司", "华侨永亨银行股份有限公司",
            "华侨永亨银行股份有限公司", "日本三井住友卡公司", "澳门国际银行", "澳门国际银行", "澳门国际银行", "澳门国际银行", "澳门国际银行",
            "大西洋银行股份有限公司", "大西洋银行股份有限公司", "大西洋银行股份有限公司", "大西洋银行股份有限公司", "大西洋银行股份有限公司",
            "大西洋银行股份有限公司", "大西洋银行股份有限公司", "大西洋银行股份有限公司", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ",
            "Discover Financial Services，I ", "Discover Financial Services，I ", "澳门商业银行", "澳门商业银行",
            "澳门商业银行", "澳门商业银行", "澳门商业银行", "哈萨克斯坦国民储蓄银行", "哈萨克斯坦国民储蓄银行", "哈萨克斯坦国民储蓄银行",
            "哈萨克斯坦国民储蓄银行", "哈萨克斯坦国民储蓄银行", "哈萨克斯坦国民储蓄银行", "哈萨克斯坦国民储蓄银行", "哈萨克斯坦国民储蓄银行",
            "哈萨克斯坦国民储蓄银行", "Bangkok Bank Pcl", "中国工商银行（澳门）", "中国工商银行（澳门）", "中国工商银行（澳门）",
            "PUBLIC BANK BERHAD", "可汗银行", "可汗银行", "可汗银行", "可汗银行", "可汗银行", "越南Vietcombank",
            "越南Vietcombank", "越南Vietcombank", "Canadia Bank PLC", "Golomt bank of Monglia",
            "蒙古郭勒姆特银行", "蒙古郭勒姆特银行", "蒙古郭勒姆特银行", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司",
            "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司",
            "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司",
            "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司",
            "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司",
            "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司",
            "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司",
            "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司", "BC卡公司",
            "BC卡公司", "BC卡公司", "BC卡公司", "莫斯科人民储蓄银行", "丝绸之路银行", "俄罗斯远东商业银行", "CSC", "CSC", "CSC",
            "CSC", "Allied Bank", "Allied Bank", "日本三菱信用卡公司", "Baiduri Bank Berhad", "越南西贡商业银行",
            "越南西贡商业银行", "越南西贡商业银行", "菲律宾BDO", "菲律宾BDO", "菲律宾RCBC", "Gazprombank", "Gazprombank",
            "Gazprombank", "Gazprombank", "Gazprombank", "Gazprombank", "Gazprombank",
            "Gazprombank", "Gazprombank", "Gazprombank", "Gazprombank", "Gazprombank",
            "Gazprombank", "Gazprombank", "Gazprombank", "Gazprombank", "Siddhartha Bank Ltd",
            "EQUITY BANK KENYA LIMITED", "EQUITY BANK KENYA LIMITED", "新加坡星网电子付款私人有限公司 ",
            "Royal Bank Open Stock Company  ", "Royal Bank Open Stock Company  ",
            "Royal Bank Open Stock Company  ", "乌兹别克斯坦INFINBANK", "Russian Standard Bank",
            "Russian Standard Bank", "Russian Standard Bank", "Russian Standard Bank",
            "Russian Standard Bank", "Russian Standard Bank", "Russian Standard Bank", "BCEL",
            "Kyrgyz Investment Credit Bank  ", "Kyrgyz Investment Credit Bank  ",
            "Kyrgyz Investment Credit Bank  ", "Kyrgyz Investment Credit Bank  ", "澳门BDA", "澳门BDA",
            "澳门通股份有限公司", "澳门通股份有限公司", "澳门通股份有限公司", "韩国乐天", "韩国乐天", "韩国乐天", "韩国乐天",
            "巴基斯坦FAYSAL BANK", "OJSCBASIAALLIANCEBANK", "Cambodia Mekong Bank PL",
            "Cambodia Mekong Bank PL", "Cambodia Mekong Bank PL", "OJSC Russian Investment Bank",
            "OJSC Russian Investment Bank", "DE SURINAAMSCHE BANK N.V.",
            "Mongolia Trade Develop. Bank", "Mongolia Trade Develop. Bank",
            "Krung Thaj Bank Public Co. Ltd ", "韩国KB", "韩国KB", "韩国KB", "韩国KB", "韩国KB",
            "Credit Saison", "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司",
            "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司", "韩国三星卡公司",
            "CJSC Fononbank", "CRDB BANK PLC", "CRDB BANK PLC", "CRDB BANK PLC",
            "Commercial Bank of Dubai", "Commercial Bank of Dubai", "The Bancorp Bank",
            "The Bancorp Bank", "巴基斯坦HabibBank", "新韩卡公司", "新韩卡公司", "新韩卡公司", "新韩卡公司", "新韩卡公司",
            "新韩卡公司", "新韩卡公司", "新韩卡公司", "新韩卡公司", "新韩卡公司", "新韩卡公司", "Phongsavanh Bank Limited",
            "Phongsavanh Bank Limited", "Capital Bank of Mongolia", "Capital Bank of Mongolia",
            "Capital Bank of Mongolia", "JSC Liberty Bank", "JSC Liberty Bank", "JSC Liberty Bank",
            "JSC Liberty Bank", "JSC Liberty Bank", "JSC Liberty Bank",
            "Myanmar Oriental Bank Ltd", "Myanmar Oriental Bank Ltd",
            "The Mauritius Commercial Bank  ", "Non-banking credit", "格鲁吉亚 Invest Bank",
            "格鲁吉亚 Invest Bank", "PT Bank Sinarmas,Tbk", "PT Bank Sinarmas,Tbk", "Jsc Basisbank",
            "Jsc Basisbank", "Jsc Basisbank", "JSC Kazkommertsbank", "JSC Kazkommertsbank",
            "JSC Kazkommertsbank", "Cim Finance Ltd", "Cim Finance Ltd", "Rawbank S.a.r.l",
            "PVB Card Corporation", "PVB Card Corporation", "PVB Card Corporation",
            "PVB Card Corporation", "PVB Card Corporation", "PVB Card Corporation",
            "PVB Card Corporation", "PVB Card Corporation", "PVB Card Corporation",
            "PVB Card Corporation", "PVB Card Corporation", "PVB Card Corporation",
            "PVB Card Corporation", "PVB Card Corporation", "PT BANK SINARMAS TBK",
            "PT BANK SINARMAS TBK", "U Microfinance Bank Limited", "Ecobank Nigeria",
            "Al Baraka Bank(Pakistan)", "OJSC Hamkor bank", "NongHyup Bank", "NongHyup Bank",
            "NongHyup Bank", "NongHyup Bank", "NongHyup Bank", "NongHyup Bank", "NongHyup Bank",
            "NongHyup Bank", "NongHyup Bank", "NongHyup Bank", "Fidelity Bank Plc", "Davr Bank",
            "Advanced Bank of Asia Ltd.", "Advanced Bank of Asia Ltd.", "State Bank of Mauritius",
            "State Bank of Mauritius", "Global Bank of Commerce Ltd",
            "Global Bank of Commerce Ltd", "Global Bank of Commerce Ltd",
            "Global Bank of Commerce Ltd", "JSC ATFBank", "JSC ATFBank", "JSC ATFBank",
            "JSC ATFBank", "Optima Bank OJSC", "State bank", "State bank", "State bank",
            "Himalayan Bank Limited", "CJSC “Spitamen Bank”", "CJSC “Spitamen Bank”",
            "CJSC “Spitamen Bank”", "CJSC “Spitamen Bank”", "CJSC “Spitamen Bank”",
            "CJSC “Spitamen Bank”", "CJSC “Spitamen Bank”", "CJSC “Spitamen Bank”", "Light Bank",
            "Light Bank", "Light Bank", "Light Bank", "Light Bank", "Light Bank", "Light Bank",
            "Light Bank", "Light Bank", "Light Bank", "Light Bank", "Co-Operative Bank Limited",
            "Co-Operative Bank Limited", "Co-Operative Bank Limited", "Co-Operative Bank Limited",
            "Travelex Card Services", "Travelex Japan KK", "Bank AL Habib Limited",
            "Bank of China(Australia)", "OSJC MTS Bank", "OSJC MTS Bank", "OSJC MTS Bank",
            "OSJC MTS Bank", "OSJC MTS Bank", "OSJC MTS Bank", "Heritage International Bank",
            "OJSC Tojiksodirotbank", "MetaBank", "KCB BANK LIMITED", "Banque Pour Le Commerce",
            "Banque Pour Le Commerce", "Banque Pour Le Commerce", "Bank Alfalah Limited",
            "Bank Alfalah Limited", "Bank Alfalah Limited", "NXSystems Limited",
            "Cooperative & Agricultural", "Cooperative & Agricultural", "Open Joint-stock Company",
            "Open Joint-stock Company", "BANCO SOL,S.A", "BANCO SOL,S.A", "BANCO SOL,S.A",
            "Subsidiary Bank Sberbank RUS", "Subsidiary Bank Sberbank RUS",
            "Subsidiary Bank Sberbank RUS", "Subsidiary Bank Sberbank RUS",
            "Subsidiary Bank Sberbank RUS", "Lao China Bank Co.,Ltd", "Lao China Bank Co.,Ltd",
            "Lao China Bank Co.,Ltd", "Hyundaicard", "Hyundaicard", "Hyundaicard", "Hyundaicard",
            "Bank of Moscow OJSC", "Bank of Moscow OJSC", "Sindh Bank Limited",
            "Russian Agricultural Bank", "Russian Agricultural Bank", "PJSC Bank ZENIT",
            "ROSENERGOBANK", "ROSENERGOBANK", "ROSENERGOBANK", "ROSENERGOBANK",
            "Subsidiary JSC VTB Bank", "Subsidiary JSC VTB Bank", "Subsidiary JSC VTB Bank",
            "Subsidiary JSC VTB Bank", "Subsidiary JSC VTB Bank", "Subsidiary JSC VTB Bank",
            "Subsidiary JSC VTB Bank", "Subsidiary JSC VTB Bank", "international crads company",
            "international crads company", "international crads company",
            "international crads company", "international crads company",
            "international crads company", "international crads company",
            "Credit Ural Bank Joint Stock", "Credit Ural Bank Joint Stock",
            "Credit Ural Bank Joint Stock", "Credit Ural Bank Joint Stock",
            "FIDELITY BANK GHANA LIMITED", "FIDELITY BANK GHANA LIMITED", "DBS Bank Ltd",
            "XacBank", "XacBank", "XacBank", "XacBank", "XacBank", "XacBank", "XacBank",
            "DBS Bank Ltd", "Sinopay（Singapore）PTE Ltd", "Sinopay（Singapore）PTE Ltd",
            "Sinopay（Singapore）PTE Ltd", "Sinopay（Singapore）PTE Ltd", "Sinopay（Singapore）PTE Ltd",
            "SmartChoice Technologies", "SmartChoice Technologies", "JSCB Primorye",
            "JSCB Primorye", "Kiatnakin Bank Pubulic CL", "Habib Bank Limited", "HBL",
            "Habib Bank Limited", "Joint-Stock Commercial Bank", "Joint-Stock Commercial Bank",
            "Bangkok Bank Public Company Li ", "Banque S C pour Afrique",
            "Banque S C pour Afrique", "OJS SCBP Primsotsbank", "OJS SCBP Primsotsbank",
            "OJS SCBP Primsotsbank", "OJS SCBP Primsotsbank", "AGD Bank Ltd",
            "Land and Houses Bank PCL", "Conservative commercial bank",
            "Conservative commercial bank", "Conservative commercial bank", "Noor Bank PJSC",
            "Joint-Stock bank", "Joint-Stock bank", "Joint-Stock bank", "Joint-Stock bank",
            "National Bank of Pakistan", "PROCREDIT BANK CONGO", "National Bank of Kenya Limited ",
            "National Bank of Kenya Limited ", "National Bank of Kenya Limited ",
            "National Bank of Kenya Limited " };

    private final static String[] sBankBinD = { "62360623", "62360621", "62360600", "62360607",
            "62360608", "62360605", "62360604", "62360606", "62360609", "62360612", "62360613",
            "62360610", "62360614", "62360615", "62360616", "62360611", "62360617", "62360618",
            "62360619", "623608001", "623608002", "62350801", "623609001", "623609002", "62361026",
            "62361027", "62361025", "62361028", "62109216", "623502001", "623512001", "623045001",
            "623607012", "623607006", "623607014", "623607015", "623607011", "623607008",
            "623607013", "623607007", "623607002", "623607003", "623607004", "623607010",
            "623607001", "623607005", "623607009", "623522001", "623504010", "62351501",
            "623504002", "623504008", "623504004", "623504009", "623504001", "623504005",
            "623517001", "623504003", "623504006", "623504007", "62168305", "62168301", "62168304",
            "62168302", "62168309", "62168308", "62168306", "62168303", "623519533", "623525003",
            "623525004", "623525005", "623525006", "62352501", "623525002", "623525008",
            "623525007", "623525001", "62352739", "62352760", "62352733", "62352737", "62352784",
            "623530963", "623530953", "623532001", "623145001", "62314061", "62314062",
            "623535002", "623535001", "623538001", "62314907", "62314903", "62314906", "62314909",
            "62314902", "62314901", "62314910", "62314908", "62314905", "62355001", "62355358",
            "62355701", "62355702", "62355703", "623558617", "623558618", "62355865", "623558615",
            "623558611", "623558616", "623558612", "623558613", "623558619", "62357012",
            "62357017", "62357009", "62357022", "62357021", "62357015", "62357013", "62357010",
            "62357014", "62357006", "62357002", "62357008", "62357011", "62357007", "62357016",
            "62357004", "62357003", "62357018", "62357001", "62357005", "62357019", "62358421",
            "62359430", "62368004", "62368001", "62368002", "62368003", "62314701", "62358101",
            "623580001", "623579001", "62358303", "62358301", "62358302", "62358563", "623587001",
            "623587002", "62359065", "62361702", "62361703", "62361701", "621389", "62359364",
            "62359354", "62359356", "62359350", "62359353", "62359329", "62359349", "62359351",
            "62144735", "62006401", "62165826", "621658001", "62300401", "62310402", "62310401",
            "62312405", "62312402", "62312403", "62361345", "62361346", "62361347", "62314292",
            "62361528", "62361527", "62361523", "62361522", "62361525", "62361526", "623194773",
            "62364201", "623626706", "623626704", "621382076", "621382070", "621382053",
            "621382066", "621382063", "621382052", "621382068", "621382074", "621382051",
            "621382057", "621382058", "621382061", "621382062", "621382067", "621382060",
            "621382072", "621382064", "621382056", "621382050", "621382075", "621382073",
            "621382069", "621382071", "621382054", "621382065", "621382059", "621382055",
            "62363585", "62363440", "62363441", "62363442", "62361902", "62361901", "62361912",
            "62361982", "62362401", "62365003", "62365002", "62359602", "62359601", "62359603",
            "62359605", "62354290", "62354211", "62354215", "62354213", "62165202", "621652853",
            "62365178", "62365202", "62365212", "62365203", "62365204", "62365205", "62365208",
            "62365209", "62365206", "62365207", "62365504", "62365502", "62365501", "62365503",
            "62365506", "62365507", "62354901", "62354903", "623567001", "623567002", "62363914",
            "62363938", "62363974", "62363975", "62363940", "62363971", "62367292", "62367291",
            "62134612", "62367401", "62364710", "62314289", "62314259", "62364178", "62364194",
            "62354884", "62354879", "62368701", "62367501", "62706501", "62369470", "62367901",
            "62707501", "622372", "622471", "622472", "622365", "622943", "623318", "621411",
            "622371", "625091", "622293", "622294", "622295", "622296", "622297", "622373",
            "622451", "625940", "622375", "622489", "622798", "622871", "622957", "622958",
            "622963", "625010", "621083", "621487", "622381", "622382", "622675", "622676",
            "622677", "624329", "624458", "622487", "622490", "622491", "622492", "621744",
            "621745", "621746", "621747", "622487", "622490", "622491", "622492", "621034",
            "622386", "622952", "625107", "622387", "622423", "625062", "625063", "622970",
            "622971", "623497", "622360", "622361", "625034", "625096", "625098", "621442",
            "622406", "621443", "622407", "622376", "622377", "622378", "625024", "625026",
            "625092", "621440", "622410", "623106", "621441", "622409", "623107", "622453",
            "622456", "624303", "622459", "623328", "623397", "623465", "622272", "623413",
            "624337", "625008", "625009", "626396", "621087", "622463", "624472", "624483",
            "625040", "625042", "625044", "625046", "625048", "625053", "625055", "625058",
            "625060", "625136", "625172", "625174", "625176", "622750", "622751", "624474",
            "624485", "625141", "625143", "625145", "625147", "625196", "625198", "620202",
            "620203", "622348", "623040", "621741", "621782", "623309", "620208", "620209",
            "622351", "623041", "621042", "621743", "621783", "623308", "620206", "620207",
            "622355", "623042", "621043", "621742", "621784", "623310", "622493", "620204",
            "620205", "620072", "622546", "622547", "622548", "621084", "623350", "624412",
            "621740", "622482", "622483", "622484", "622948", "620070", "620107", "623334",
            "629131", "629140", "624477", "624478", "624481", "624488", "629139", "629148",
            "625842", "6258433", "6258434", "620152", "620153", "622495", "622496", "622433",
            "622775", "622785", "622861", "622862", "622932", "624300", "624302", "624308",
            "624309", "622920", "624407", "624408", "622434", "622435", "622436", "623043",
            "623064", "624371", "624372", "624398", "621232", "621247", "622432", "60110",
            "601100", "601101", "60112", "60112010", "60112011", "60112012", "60112013",
            "60112089", "601121", "601122", "601123", "601124", "601125", "601126", "601127",
            "601128", "6011290", "6011291", "6011292", "6011293", "6011294", "6011295", "6011296",
            "6011297", "60112980", "60112981", "60112986", "60112987", "60112988", "60112989",
            "60112990", "60112991", "60112992", "60112993", "60112994", "60112995", "60112996",
            "60112997", "60113", "6011300", "60113080", "60113081", "60113089", "601131", "601136",
            "601137", "601138", "6011390", "6011391", "6011392", "6011393", "60113940", "60113941",
            "60113943", "60113944", "60113945", "60113946", "60113984", "60113985", "60113986",
            "60113988", "60113989", "6011399", "60114", "601140", "601142", "601143", "601144",
            "601145", "601146", "601147", "601148", "601149", "601174", "601177", "601178",
            "601179", "601186", "601187", "601188", "601189", "60119", "644", "65", "6506", "6507",
            "6508", "6509", "625014", "625016", "621253", "621254", "621255", "622549", "622550",
            "623357", "6234500", "6234501", "624341", "6264030", "6264031", "6264032", "622354",
            "625017", "625018", "625019", "623488", "621224", "622954", "62345800", "62445400",
            "62927700", "621295", "625124", "625154", "623457", "622445", "621049", "622414",
            "622444", "620011", "620027", "620031", "620039", "620103", "620106", "620123",
            "620125", "620132", "620220", "620278", "620812", "621003", "621006", "621011",
            "621012", "621023", "621025", "621027", "621031", "621032", "621039", "621078",
            "621484", "621640", "621641", "623391", "623392", "623395", "623451", "623452",
            "623453", "624344", "624345", "624375", "624381", "624382", "624384", "624448",
            "624482", "625003", "625006", "625011", "625012", "625020", "625023", "625025",
            "625027", "625031", "625032", "625039", "625078", "625079", "625103", "625106",
            "625111", "625112", "625120", "625123", "625125", "625127", "625131", "625132",
            "625139", "625178", "625179", "625243", "625244", "625245", "625246", "629141",
            "621040", "621045", "621264", "621234", "622356", "62235600", "62349550", "622145",
            "625013", "622130", "621257", "620009", "621055", "625002", "625033", "625035",
            "625007", "6233710", "6233711", "6233712", "6233720", "6233721", "6233722", "6233723",
            "6233730", "6233731", "6233732", "6233760", "6233761", "6233762", "6243650", "6243651",
            "6243652", "62913200", "6234280", "6234290", "620015", "620024", "625004", "621344",
            "621349", "620108", "6201086", "6201088", "6216846", "6216848", "6250386", "6250388",
            "621354", "623326", "623327", "6234610", "6292740", "621274", "621324", "620532",
            "620126", "620537", "623358", "624313", "624333", "625904", "621645", "621624",
            "623332", "624338", "624351", "623339", "6244760", "623370", "621642", "624366",
            "621654", "623374", "624370", "624434", "625804", "626402", "620056", "624399",
            "624400", "624401", "624410", "624411", "624413", "624440", "624441", "624442",
            "624443", "625814", "625817", "626395", "621649", "623315", "623316", "623317",
            "620079", "620091", "622164", "624357", "621657", "623024", "624331", "624332",
            "624339", "624348", "624432", "624479", "624480", "625840", "625841", "626394",
            "621794", "625944", "621694", "62341601", "62341602", "6233451", "6233452", "6233453",
            "6233454", "6233455", "623347", "62443100", "62443101", "620129", "62927300", "621301",
            "6292750", "6214455", "6214458", "624428", "624429", "626398", "6234240", "6234241",
            "6234242", "624306", "624322", "623300", "623302", "623303", "623304", "623324",
            "62334910", "62334911", "62334912", "62334913", "62334921", "62334923", "6233493",
            "6233494", "623398", "623492", "6243051", "6243052", "623307", "623311", "623312",
            "623313", "623323", "623341", "624320", "624321", "624324", "624325", "624349",
            "624350", "624387", "624388", "623314", "623325", "623375", "629144", "623331",
            "623348", "6243550", "6243551", "6243560", "6243561", "623336", "623337", "623338",
            "624323", "623360", "62335201", "62335202", "62335203", "623499", "62335101",
            "62335102", "62335103", "62335104", "62335105", "62335106", "62335107", "62335108",
            "6233531", "6233532", "6233533", "6233534", "6233535", "6233536", "6233537", "6233538",
            "6233539", "6234980", "6234981", "623493", "62441900", "62441901", "62441902",
            "6221440", "6221441", "623359", "623362", "6243420", "6243421", "6243422", "6243423",
            "6243424", "6243425", "623369", "6233681", "624364", "62348700", "624352", "624353",
            "624354", "623381", "623402", "62340500", "6221740", "623380", "624367", "6233780",
            "6233781", "6233840", "6233841", "623385", "6233820", "6233821", "6233822", "6233823",
            "6233824", "623383", "623386", "623388", "624368", "624376", "624377", "624378",
            "6233960", "6233961", "623389", "6234460", "6234461", "6234470", "6234120", "6234121",
            "6234122", "6243970", "623417", "623418", "623419", "623420", "623421", "6234211",
            "629180", "6291802", "623410", "623411", "624392", "624393", "624394", "624395",
            "624396", "6234090", "6243900", "6243901", "6243902", "6233990", "6233991", "621052",
            "623414", "62341401", "62341402", "62341403", "62341407", "62341408", "62341409",
            "624391", "6234150", "6234151", "6234152", "6234154", "6234153", "623459", "623477",
            "6234250", "6234251", "6234220", "623448", "6234270", "623443", "6244092", "6244096",
            "623355", "62344901", "62441701", "6234320", "6234321", "6234322", "6234323",
            "6234330", "6234300", "6234350", "6234351", "6234352", "6234420", "6234450", "6234451",
            "6234452", "6234453", "62438500", "62343800", "62344000", "62344001", "62344100",
            "62441500" };

    public static String getNameOfBank(String pan) {
        int len = sBankBinD.length;
        int index = -1;
        for (int i = 0; i < len; i++) {
            if (pan.startsWith(sBankBinD[i])) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return "";
        }
        return sBankNameD[index];
    }

}