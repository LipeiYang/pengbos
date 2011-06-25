package com.kiwi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class POSServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7450434004824007236L;
	private static final Logger log = Logger.getLogger(POSServlet.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String itemUrl = req.getParameter("itemUrl");
			log.log(Level.INFO, String.format("Here we know which item is sold and who is buyer through URL $1%s. Then do something in DB.", itemUrl));
			resp.getWriter().println("location.href='http://ftp.gnu.org/pub/gnu/clisp/NEWS.sig'");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
