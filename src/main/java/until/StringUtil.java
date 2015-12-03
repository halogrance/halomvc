package until;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class StringUtil extends TagSupport {

	private static final long serialVersionUID = 1L;
	private Object value = null;

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		String value = String.valueOf(this.value);
		if (value.length() > 6) {
			value = value.substring(0, 5);
		}
		try {
			pageContext.getOut().write(value + "...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
