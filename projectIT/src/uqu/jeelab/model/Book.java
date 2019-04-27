package uqu.jeelab.model;


public class Book {

	private String name;
	private String pages;
	
	public Book(String Name, String Pages) {
		name = Name;
		pages = Pages;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

}
