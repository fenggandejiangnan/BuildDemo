package vcredit.builddemo;

/**
 * 复杂的产品，考虑到代码的可读性，这里只列举部分的成员属性
 * 且作为测试成员属性都是String，真实的情况下有些属性是需要自定义的。
 * Created by zew on 17/7/8.
 */
public class Product {
    private String xuqiu;//需求
    private String ui;//界面
    private String luoji;//逻辑


    public String getXuqiu() {
        return xuqiu;
    }

    public void setXuqiu(String xuqiu) {
        this.xuqiu = xuqiu;
    }

    public String getUi() {
        return ui;
    }

    public void setUi(String ui) {
        this.ui = ui;
    }

    public String getLuoji() {
        return luoji;
    }

    public void setLuoji(String luoji) {
        this.luoji = luoji;
    }
}
