package user.controller;

import common.controller.AbstractAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends AbstractAction {

    public LoginAction() {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        this.setViewPage("user/login.jsp");
        this.setRedirect(false);
		
    }
}
