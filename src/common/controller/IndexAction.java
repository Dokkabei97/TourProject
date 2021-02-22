package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction extends AbstractAction {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//        System.out.println("index 호출");
        
        req.setAttribute("msg", "index");

        this.setViewPage("/templet.jsp");
        this.setRedirect(false);
    }
}
