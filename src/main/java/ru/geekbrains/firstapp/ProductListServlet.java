package ru.geekbrains.firstapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductListServlet", urlPatterns = "/product_list")
public class ProductListServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: GET");

        StringBuilder sb = new StringBuilder("<html><body>");
        int cost;
        for (int i = 0; i < 10; i++) {
            cost = (int) (1 + Math.random() * 1000);
            Product product = new Product(i, "product" + i, cost);
            sb.append("<span>").append(product).append("</span><br/>");
        }
        sb.append("</body></html>");
        resp.getWriter().printf(sb.toString());
    }

    @Override
    public void destroy() {
        logger.info("Log: Destroy");
    }

    @Override
    public void init() throws ServletException {
        logger.info("Log: Init");
    }
}
