package com.divine.code.mediator.mediator;

import com.divine.code.mediator.*;

public interface Mediator {
    void handleEvent(Component component, String event);

    void setLoginButton(Button loginButton);

    void setRegButton(Button regButton);

    void setUsernameInput(Input usernameInput);

    void setPasswordInput(Input passwordInput);

    void setRepeatedPswdInput(Input repeatedPswdInput);

    void setHintText(Text hintText);

    void setSelection(Selection selection);

}