package vcredit.supportlibrary;

/**
 * 常量类
 * <p>
 * Created by zew on 17/3/25.
 */
public class Constants {

    /**
     * NUMBER_FLOAT_20
     */
    public static final float NUMBER_FLOAT_20 = 20f;
    public static final float NUMBER_FLOAT_11_6 = 11.6f;
    public static final float NUMBER_FLOAT_30_0 = 30.0f;
    public static final float NUMBER_FLOAT_50_0 = 50.0f;
    public static final double NUMBER_FLOAT_0_3 = 0.3;
    public static final double NUMBER_FLOAT_0_59 = 0.59;
    public static final double NUMBER_FLOAT_0_11 = 0.11;


    /**
     * 数字1024
     */
    public static final int NUMBER_1024 = 1024;
    /**
     * 数字4
     */
    public static final int NUMBER_FOUR = 4;
    /**
     * 数字5
     */
    public static final int NUMBER_FIVE = 5;

    /**
     * 数字6
     */
    public static final int NUMBER_SIX = 7;

    /**
     * 数字10
     */
    public static final int NUMBER_TEN = 10;

    /**
     * 数字100
     */
    public static final int NUMBER_HUNDRED = 100;

    /**
     * true
     */
    public static final String TRUESTR = "true";
    /**
     * false
     */
    public static final String FALSESTR = "false";
    /**
     * 数字-2
     */
    public static final int NUMBER_NEGATIVE_TWO = -2;

    public static final int NUMBER_SEVEN = 7;
    /**
     * 数字-1
     */
    public static final int NUMBER_NEGATIVE_ONE = -1;
    /**
     * 数字0
     */
    public static final int NUMBER_ZERO = 0;
    /**
     * 数字1
     */
    public static final int NUMBER_ONE = 1;
    /**
     * 数字2
     */
    public static final int NUMBER_TWO = 2;
    /**
     * 数字3
     */
    public static final int NUMBER_THREE = 3;

    /**
     * 数字8
     */
    public static final int NUMBER_EIGHT = 8;

    /**
     * 数字16
     */
    public static final int NUMBER_SIXTEEN = 16;

    /**
     * 数字24
     */
    public static final int NUMBER_24 = 24;


    /**
     * 数字60
     */
    public static final int NUMBER_SIXTY = 60;

    /**
     * 数字90
     */
    public static final int NUMBER_NINETY = 90;

    /**
     * 数字80
     */
    public static final int NUMBER_EIETY = 80;

    /**
     * 数字180
     */
    public static final int NUMBER_HUNDRED_EIGHTY = 180;

    /**
     * 数字270
     */
    public static final int NUMBER_270 = 270;

    /**
     * 数字300
     */
    public static final int NUMBER_THREE_HUNDRED = 300;

    /**
     * 数字400
     */
    public static final int NUMBER_FOUR_HUNDRED = 400;

    /**
     * 数字1000
     */
    public static final int NUMBER_ONE_THOUSAND = 1000;

    public static final int REFRESH_AUTH_STATE = 5000;

    public static final int RESULTOK = 888;


    //数据传递常量
    /*传递Int数据*/
    public static final String DATA_INT = "data_int";
    /*传递String类型数据*/
    public static final String DATA_STRING = "data_string";
    /*传递String类型数据*/
    public static final String DATA_STRING2 = "data_string2";

    /*传递实体Bean数据*/
    public static final String DATA_BEAN = "data_bean";

    /*认证项页面跳转类型*/
    public static final String JUMP_TYPE = "jump_type";



    /**信用猫目录名*/
    public static final String VREDIT_CREDITCAT = "vredit_creditcat";
    /**百度定位失败*/
    public static final String BAIDU_LOCATION_FAILE = "4.9E-324";
    /**字符串0.0*/
    public static final String ZERO_POINT_ZERO = "0.0";
    /**中国国家测绘局标示*/
    public static final String GCJ02 = "gcj02";

    /**字符串数字0**/
    public static final String STR_NUMBER_ZERO = "0";
    /**字符串数字1**/
    public static final String STR_NUMBER_ONE = "1";
    /**点击登录的字符串**/
    public static final String CLICK_LOGIN = "点击登录";
    /**
     * 用户登陆账号
     */
    public static final String LOGIN_INFO_USER_CODE = "loginInfo.userCode";

    //隐式跳转常量
    /*信用库页面*/
    public static final String ACTION_CREADIT_LIBRARY_ACTIVITY="com.vcredit.creditcat.creditlibrary.creaditlibraryactivity";
    /**贷款直通车页面隐私跳转filter*/
    public static final String ACTION_LOAN_SECTION_ACTIVITY="com.vredit.creditcat.loancar";
    /**登录页面隐私跳转filter*/
    public static final String ACTION_LOGIN_ACTIVITY="com.vredit.creditcat.login";







    /**各银行代号*/
    public static final String[] BANK_CODES = new String[]{"CCB", "ICBC", "ABCB", "BOC", "CEB",
            "CMB", "CMBC", "ECTIC", "CGB", "SPDB", "PINGAN", "CIB", "YOUZHENG"};

    /*********************信用库start*******************/
    public static final String REALNAME = "1";//实名认证
    public static final String BASICINFO = "2";//基本信息
    public static final String HIGHREALNAME = "4";//高级实名认证
    public static final String BINDCARKAUTH = "8";//绑卡认证
    public static final String MOBILEAUTH = "16";//手机认证
    public static final String EDUAUTH = "32";//学历认证
    public static final String CREDITAUTH = "64";//央行征信
    public static final String SESAME= "128";//芝麻分
    public static final String SOCSEC = "256";//社保
    public static final String PROFUND = "512";//公积金
    public static final String ALIPAY = "1024";//支付宝
    public static final String TAOBAO = "2048";//淘宝
    public static final String JD = "4096";//京东
    public static final String CREDITCARD = "8192";//信用卡
    public static final String EMERGENCYCONTACT = "16384";//紧急联系人
    /*********************信用库end*******************/

    /*********************相机start*******************/

    /** app图片存放路径 */
    public static final String IMAGEPATH = "/XinYongHua/image/";
    //相机Activity用的表示码

    public static final int FRONT_CODE = 4011;
    public static final int BACK_CODE = 4012;
    public static final int HAND_CODE = 4013;
    public static final int NORMAL_CODE = 4014;

    //JS调用相机时传的入参字符串
    public static final String FRONT_STR = "FRONT";
    public static final String BACK_STR = "BACK";
    public static final String HAND_STR = "HAND";
    public static final String NORMAL_STR = "NORMAL";

    /*********************相机end*******************/

    /*********************信用库入口的类型*******************/
    public static final int CREDIT_LIBRARY_ACTIVITY = 111;//信用资料库页面
    public static final int IDENTITY_AUTH_ACTIVITY = 222;//身份认证页面
    public static final int LOAN_DETAIL_ACTIVITY = 333;//贷款产品详情页面
    public static final int CREDIT_UP_GRADE = 444;//信用提升页面
    /*********************信用库入口的类型*******************/

    //跳转类型1：信用诊断界面进入，2：信用库进入
    public final static int CREDIT_DIO_TYPE = 1;
    public final static int CREDIT_LIBRARY_TYPE = 2;


    /*********************认证项认证状态*******************/
    public static final String AUTH_STATU_NOT_DO = "0";//未认证
    public static final String AUTH_STATU_DO_SUCCESS = "1";//认证成功
    public static final String AUTH_STATU_DO_ING = "2";//认证中
    public static final String AUTH_STATU_DO_FAIL = "3";//认证失败
    /*********************认证项认证状态*******************/

    /*********************登录同步标示*******************/
    public static final int LOGIN_SYNC = 2343;

    /*********************信用卡列表类型*******************/
    //（1、热门卡片 2、消费热卡，3.商旅专用 4.大额定制 5，女性独享 6，全部）
    public static final int CREDITCARD_TYPE_HOT = 1;
    public static final int CREDITCARD_TYPE_SHOPPING = 2;
    public static final int CREDITCARD_TYPE_TRAVEL = 3;
    public static final int CREDITCARD_TYPE_BIGLIMIT = 4;
    public static final int CREDITCARD_TYPE_FEMALE = 5;
    public static final int CREDITCARD_TYPE_ALL = 6;
    /*********************信用卡列表类型*******************/

    //加密串
    public static final String ENC_STR="1487201BD119A39B";


    /**
     * 对各个模块用于生成路由映射表的生成类包名定义。让各自的组件中生成的映射表都对应使用各自的package。
     * <p>
     *     对Activity使用{@link com.lzh.nonview.router.anno.RouterRule} 注解。指定pack报名。即可
     * </p>
     */
    public static final class PACK {
        public static final String USERCENTER = "com.jm.android.app.usercenter";
        public static final String SOCIAL = "com.jm.android.app.social";

        /**
         * JMRouteManager中使用此数组数据来加载所有的路由映射表。
         */
        public static final String[] Packages = new String[] {USERCENTER,SOCIAL};
    }
}
