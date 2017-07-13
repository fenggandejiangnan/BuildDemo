package vcredit.builddemo;

/**
 * 信用猫builder具体的实现
 * Created by zew on 17/7/8.
 */
public class CreditCatBuilder implements Builder{

    Product p;

    public CreditCatBuilder() {
        p=new Product();
    }

    @Override
    public void buildXuqiu() {
        p.setXuqiu("建造信用猫需求文档");
    }

    @Override
    public void buildUi() {
        p.setUi("建造信用猫画UI");
    }

    @Override
    public void buildLuoji() {
        p.setLuoji("建造信用猫写逻辑");
    }

    @Override
    public Product getApp() {
        return p;
    }
}
