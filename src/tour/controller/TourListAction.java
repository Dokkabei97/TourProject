package tour.controller;

import common.controller.AbstractAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TourListAction extends AbstractAction {

    public TourListAction() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        req.setAttribute("msg", "index");

        this.setViewPage("tour/tourList.jsp");
        this.setRedirect(false);
    }
}
