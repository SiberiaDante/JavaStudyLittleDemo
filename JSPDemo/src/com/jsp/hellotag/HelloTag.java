package com.jsp.hellotag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	StringWriter sw = new StringWriter();

	public void doTag() throws JspException, IOException {
		// JspWriter out = getJspContext().getOut();
		// out.println("Hello Custom Tag!");
		getJspBody().invoke(sw);
		getJspContext().getOut().println(sw.toString());
	}

}
