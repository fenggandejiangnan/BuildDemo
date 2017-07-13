package vcredit.builddemo;

/**
 * 信用花builder具体的实现
 * Created by zew on 17/7/8.
 */
public class CreditHuaBuilder implements Builder{

    Product p;

    public CreditHuaBuilder() {
        p=new Product();
    }

    @Override
    public void buildXuqiu() {
        p.setXuqiu("建造信用花设计需求文档");
    }

    @Override
    public void buildUi() {
        p.setUi("建造信用花画UI");
    }

    @Override
    public void buildLuoji() {
        p.setLuoji("建造信用花写逻辑");
    }

    @Override
    public Product getApp() {
        return p;
    }
}
