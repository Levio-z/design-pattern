package com.divine.code.mediator;

public class UIControl {
    private static final String LOGIN_BTN_ID = "login_btn";
    private static final String REG_BTN_ID = "reg_btn";
    private static final String USERNAME_INPUT_ID = "username_input";
    private static final String PASSWORD_INPUT_ID = "pswd_input";
    private static final String REPEATED_PASSWORD_INPUT_ID = "repeated_pswd_input";
    private static final String HINT_TEXT_ID = "hint_text";
    private static final String SELECTION_ID = "selection";

    public static void main(String[] args) {
        Button loginButton = new Button(LOGIN_BTN_ID);
        Button regButton = new Button(REG_BTN_ID);
        Input usernameInput = new Input(USERNAME_INPUT_ID);
        Input passwordInput = new Input(PASSWORD_INPUT_ID);
        Input repeatedPswdInput = new Input(REPEATED_PASSWORD_INPUT_ID);
        Text hintText = new Text(HINT_TEXT_ID);
        Selection selection = new Selection(SELECTION_ID);

        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 直接访问其他控件
                String username = usernameInput.getText();
                String password = passwordInput.getText();
                // 校验数据...
                // 做业务处理...
                System.out.println("Login button clicked. Username: " + username + ", Password: " + password);
            }
        });

        regButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 直接访问其他控件
                String username = usernameInput.getText();
                String password = passwordInput.getText();
                String repeatedPassword = repeatedPswdInput.getText();
                // 校验数据...
                // 做业务处理...
                System.out.println("Register button clicked. Username: " + username + ", Password: " + password + ", Repeated Password: " + repeatedPassword);
            }
        });

        selection.setSelectedItem("login");
        selection.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(View v, String selectedItem) {
                if ("login".equals(selectedItem)) {
                    usernameInput.show();
                    passwordInput.show();
                    repeatedPswdInput.hide();
                    hintText.hide();
                } else if ("register".equals(selectedItem)) {
                    usernameInput.show();
                    passwordInput.show();
                    repeatedPswdInput.show();
                    hintText.show();
                }
            }
        });

        // 模拟用户操作
        loginButton.onClick();
        regButton.onClick();
        selection.onItemSelected("register");
    }
}