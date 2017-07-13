package vcredit.builddemo;

/**
 * 抽象建造者
 * Created by zew on 17/7/8.
 */
public interface  Builder {
    void buildXuqiu();//文档设计
    void buildUi();//界面
    void buildLuoji();//业务逻辑

    Product getApp();//返回开发的产品
}
