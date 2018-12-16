package org.brewingjava.model;

/**
 * @author Brewing Java
 *
 * class Books used as 
 * model class to get details
 * of Book like id, title,
 * price,author,category
 */

public class Books {

	private int bookid;
	private String title;
	private float price;
	private String author;
	private String category;

	/**
	 * ${constructor: AccountInfo}
	 */
	public Books() {
		
	}
	
	/**
	 * ${Parameterized constructor: AccountInfo}
	 */
	public Books(int bookid, String title, float price, String author, String category) {
		
		this.bookid = bookid;
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
	}

	/**
	 * @return the bookid
	 */
	public int getBookid() {
		return bookid;
	}

	/**
	 * @param bookid the bookid to set
	 */
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	
	@Override 
	public String toString() {
		return "Categories [bookid=" + bookid + ", title=" + title + ", price=" + price + ", author=" + author
				+ ", category=" + category + "]";
	}

}
