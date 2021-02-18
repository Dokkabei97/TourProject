package tour.controller;

import common.controller.AbstractAction;
import tour.api.TourAPIKeyword;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TourListAction extends AbstractAction {

    public TourListAction() {
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String keyword = req.getParameter("keyword");

        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = "서울";
        }

        TourAPIKeyword api = new TourAPIKeyword();

        String searchKeyword = api.TourAPIKeyword(keyword);

        System.out.println("keyword1= " + keyword);

        req.setAttribute("searchKeyword", searchKeyword);

        req.setAttribute("msg", "index");

        this.setViewPage("tour/tourList.jsp");
        this.setRedirect(false);
    }
}
