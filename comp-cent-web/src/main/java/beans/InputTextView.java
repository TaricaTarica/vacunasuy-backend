package beans;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class InputTextView {

    private String text;
    private Date date11;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

	public Date getDate11() {
		return date11;
	}

	public void setDate11(Date date11) {
		this.date11 = date11;
	}
    
    
}