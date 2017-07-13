package vcredit.builddemo;

/**
 * 指挥类，该类定义一个construct方法，该方法拥有一个抽象建造者类型的参数这样可以通过范型把不同的建造者模式都可以传入
 * Created by zew on 17/7/8.
 */
public class AppDirector {
    public Product construct(Builder builder){
        //完成需求文档
        builder.buildXuqiu();
        //完成ui
        builder.buildUi();
        //完成业务逻辑
        builder.buildLuoji();
        //返回产品
        return builder.getApp();
    }
}
