package edu.web.ajax;

public class SearchVO {
	private int sno;
	private String title;
	
	
	public SearchVO() {
	}

	

	public SearchVO(int sno, String title) {
		this.sno = sno;
		this.title = title;
	}



	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "SearchVO [sno=" + sno + ", title=" + title + "]";
	}
	
	
	
}
