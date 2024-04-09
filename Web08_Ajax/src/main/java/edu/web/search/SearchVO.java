package edu.web.search;

public class SearchVO {
	private String title;

	public SearchVO() {
	}

	public SearchVO(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "SearchVO [title=" + title + "]";
	}

}
