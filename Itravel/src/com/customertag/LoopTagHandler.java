package com.customertag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.bean.PostBean;

public class LoopTagHandler extends SimpleTagSupport {

	private List postList;

	public void setpostList(List postList) {
		if(postList!= null){
			this.postList = postList;	
		}else{// to control if the array is empty
			this.postList= new ArrayList();
		}
		
	}

	public void doTag() throws JspException, IOException {
		Iterator i = postList.iterator();
		while (i.hasNext()) {
			PostBean post = (PostBean) i.next();
			getJspContext().setAttribute("mypost", post);
			getJspBody().invoke(null);
		}
	}

}
