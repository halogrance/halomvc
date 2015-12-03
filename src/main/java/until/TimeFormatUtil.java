package until;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TimeFormatUtil extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long value;
	private String parttern;

	public void setValue(long value) {
		this.value = value;
	}

	public void setParttern(String parttern) {
		this.parttern = parttern;
	}

	public static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss:SSS");

	public int doStartTag() throws JspException {
		String value=String.valueOf(this.value);
		long time=Long.valueOf(value);
		String timeStr = null;
		Date date = new Date(time);
		if (parttern == null) {
			timeStr = format.format(date);
		} else {
			format = new SimpleDateFormat(parttern);
			timeStr = format.format(date);
		}
		try {
			pageContext.getOut().write(timeStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
