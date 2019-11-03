package prpo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("NakupovalniSeznam")
public class ServletNakupovalniSeznam extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BaseDao dao = new BaseDaoImpl();
        List<Entiteta> uporabniki = dao.vrniVse();

        int size = uporabniki.size();
        for(int i = 0; i < size; i++){
            resp.getWriter().println(uporabniki.get(i).toString());
        }

    }
}


