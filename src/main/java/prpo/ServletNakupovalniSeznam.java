package prpo;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("NakupovalniSeznam")
public class ServletNakupovalniSeznam extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //Izpis v konzolo - System.out.println()
        //Izpis v na spletno stran: resp.getWriter().println()
        // implementacija
        resp.getWriter().println("ime aplikacije :" + ConfigurationUtil.getInstance().get("kumuluzee.name").orElse("N/A"));
        resp.getWriter().println("verzija:" + ConfigurationUtil.getInstance().get("kumuluzee.version").orElse("N/A"));
        resp.getWriter().println("okolje :" + ConfigurationUtil.getInstance().get("kumuluzee.env.name").orElse("N/A"));


    }
}


