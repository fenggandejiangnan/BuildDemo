package vcredit.supportlibrary;

/**
 * 路由接口类型
 * <p>
 * Created by zew on 17/3/26.
 */
public enum Rout implements RoutInterface {

    HOMEMAIN(RountConstants.HOMEMAIN_ACTIVITY),//登录界面
    REGISTER(RountConstants.REGISTER_ACTIVITY),//注册界面
    LOGIN(RountConstants.LOGINACTIVITY),//登录界面
    CREDITFRAGMENT(RountConstants.MINECREDITACTIVITY),//信用价值界面
    CREDITREPORT(RountConstants.CREDITREPORTACTIVITY),//信用诊断页面
    IDENTITYAUTH(RountConstants.IDENTITYAUTHACTIVITY),//身份认证页面
    INDENTITY_PLUS_V(RountConstants.IDENTITY_PLUS_V),//身份加v特权申请页面
    ONE_KEY_TO_LOAN(RountConstants.ONE_KEY_TO_LOAN),//一键贷款特权申请页面
    LoanCar(RountConstants.LOAN_CAR_ACTIVITY),//一键贷款特权申请页面
    CREDIT_LIBRARY(RountConstants.CREDIT_LIBRARY_ACTIVITY),//信用库页面
    WAIT_QUERYCODE(RountConstants.WAIT_QUERYCODE_ACTIVITY),//等待查询码界面
    BANK_SELECT(RountConstants.BANK_SELECT_ACTIVITY),//等待查询码界面
    CENTRALBANK_CREDIT(RountConstants.CENTRALBANK_CREDIT_ACTIVITY),//等待查询码界面
    TOKEN_FAILURE(RountConstants.TOKEN_FAILURE_ACTIVITY),//等待查询码界面
    SIGNATURE(RountConstants.SIGNATURE_ACTIVITY),//签名界面
    OneModue(RountConstants.OneModueActivity),//签名界面
    mainModule(RountConstants.mainModuleActivity),//签名界面
    ;
    Rout(String routClass) {
        this.routClass=routClass;
    }

    public String getClazzType() {
        return routClass;
    }
    private String routClass;
}
