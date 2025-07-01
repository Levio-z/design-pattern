package com.divine.code.mediator.mediator;

import com.divine.code.mediator.*;


public class LandingPageDialog implements Mediator {
    private Button loginButton;
    private Button regButton;
    private Selection selection;
    private Input usernameInput;
    private Input passwordInput;
    private Input repeatedPswdInput;
    private Text hintText;

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public void setRegButton(Button regButton) {
        this.regButton = regButton;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public void setUsernameInput(Input usernameInput) {
        this.usernameInput = usernameInput;
    }

    public void setPasswordInput(Input passwordInput) {
        this.passwordInput = passwordInput;
    }

    public void setRepeatedPswdInput(Input repeatedPswdInput) {
        this.repeatedPswdInput = repeatedPswdInput;
    }

    public void setHintText(Text hintText) {
        this.hintText = hintText;
    }

    @Override
    public void handleEvent(Component component, String event) {
        // 默认是比较引用的对象是不是同一个
        if (component.equals(loginButton)) {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            // 校验数据...
            // 做业务处理...
            System.out.println("Login button clicked. Username: " + username + ", Password: " + password);
        } else if (component.equals(regButton)) {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            String repeatedPassword = repeatedPswdInput.getText();
            // 校验数据...
            // 做业务处理...
            System.out.println("Register button clicked. Username: " + username + ", Password: " + password + ", Repeated Password: " + repeatedPassword);
        } else if (component.equals(selection)) {
            String selectedItem = selection.getSelectedItem();
            if ("login".equals(selectedItem)) {
                usernameInput.show();
                passwordInput.show();
                repeatedPswdInput.hide();
                hintText.hide();
                // ...省略其他代码
            } else if ("register".equals(selectedItem)) {
                usernameInput.show();
                passwordInput.show();
                repeatedPswdInput.show();
                hintText.show();
                // ...
            }
        }
    }
}