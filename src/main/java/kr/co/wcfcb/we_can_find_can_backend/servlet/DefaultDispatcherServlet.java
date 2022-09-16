package kr.co.wcfcb.we_can_find_can_backend.servlet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "defaultServlet", urlPatterns = "/*")
public class DefaultDispatcherServlet extends HttpServlet {

    private final Logger logger;

    DefaultDispatcherServlet() {
        this.logger = LoggerFactory.getLogger(getClass());
    }

    private void showLogger(HttpServletRequest req) {
        String method = req.getMethod();
        logger.info("[START]" + method + "WE_CAN_FIND_CAN ##############");
        logger.info("Method \t\t\t:\t" + method);
        logger.info("Protocol \t\t\t:\t" + req.getProtocol());
        logger.info("RequestURI \t\t:\t" + req.getRequestURI());
        logger.info("RequestURL \t\t:\t" + req.getRequestURL());
        logger.info("Scheme \t\t\t:\t" + req.getScheme());
        logger.info("QueryString \t\t:\t" + req.getQueryString());
        logger.info("ContentType \t\t:\t" + req.getContentType());
        logger.info("ContentLength \t\t:\t" + req.getContentLength());
        logger.info("CharacterEncoding \t:\t" + req.getCharacterEncoding());

        req.getHeaderNames().asIterator().forEachRemaining(
                headerName -> logger.info(StringUtils.rightPad(headerName, 15, " ") + "\t:\t" + req.getHeader(headerName))
        );
        logger.info("[END]" + method + "WE_CAN_FIND_CAN ##############\n");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showLogger(req);
        super.service(req, resp);
    }
}
