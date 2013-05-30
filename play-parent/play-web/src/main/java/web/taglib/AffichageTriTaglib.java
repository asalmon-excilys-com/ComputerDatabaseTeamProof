package web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Page;

public class AffichageTriTaglib extends TagSupport {
	final static Logger logger = LoggerFactory
			.getLogger(AffichageTriTaglib.class);
	private static final long serialVersionUID = 1L;

	public int doStartTag() {

		JspWriter out = pageContext.getOut();
		Page page = (Page) pageContext.getRequest().getAttribute("page");

		Integer s = 0;
		if (page.getS() != null) {
			s = page.getS();
		}

		String f = "";
		if (page.getF() != null) {
			f = page.getF();
		}

		Integer[] tabCol = { 0, 3, 4, 5 };

		switch (s) {
		case 0:
			tabCol[0] = -2;
			break;
		case -2:
			break;
		case 3:
			tabCol[1] = -3;
			break;
		case 4:
			tabCol[2] = -4;
			break;
		case 5:
			tabCol[3] = -5;
			break;
		default:
			tabCol[0] = -2;
			break;
		}

		String up = "headerSortUp";
		String down = "headerSortDown";
		String[] stringCol = { "", "", "", "" };
		String use;

		if (s < 0) {
			use = down;
			stringCol[-s - 2] = use;
		} else if (s > 0) {
			use = up;
			stringCol[s - 2] = use;
		} else {
			stringCol[0] = up;
		}

		try {
			out.println("<th class=\"col2 header " + stringCol[0]
					+ "\"><a href=\"TableauComputer.html?s=" + tabCol[0]
					+ "&f=" + f + "\">Computer name</a></th>");
			out.println("<th class=\"col3 header " + stringCol[1]
					+ "\"><a href=\"TableauComputer.html?s=" + tabCol[1]
					+ "&f=" + f + "\">Introduced</a></th>");
			out.println("<th class=\"col4 header " + stringCol[2]
					+ "\"><a href=\"TableauComputer.html?s=" + tabCol[2]
					+ "&f=" + f + "\">Discontinued</a></th>");
			out.println("<th class=\"col5 header " + stringCol[3]
					+ "\"><a href=\"TableauComputer.html?s=" + tabCol[3]
					+ "&f=" + f + "\">Company</a></th>");

		} catch (IOException e) {
			logger.error("Erreur de gestion headers" + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() {
		return EVAL_PAGE;
	}
}
