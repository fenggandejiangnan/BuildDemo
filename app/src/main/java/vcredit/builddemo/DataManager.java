package vcredit.builddemo;

public enum DataManager {
    INSTANCE;
    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
