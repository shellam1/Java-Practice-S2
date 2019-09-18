/**
 * 
 */
package lab2;

/**
 * Daanish Fiaz and Asia Shell
 * CMSC 256 Lab 2
 */

import java.lang.IllegalArgumentException;
public class MyBook implements Comparable<MyBook> {
	

	@Override
	public String toString() {
		String output = "Title: " + this.title + "\n" + 
						"Author: " + this.authorFirstName + " " + this.authorLastName + "\n" +
						"ISBN10: " + ISBN10 + "\n" +
						"ISBN13: " + ISBN13;
		
		
		return output;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN10 == null) ? 0 : ISBN10.hashCode());
		result = prime * result + ((ISBN13 == null) ? 0 : ISBN13.hashCode());
		return result;
	}
	
	public int compareTo(MyBook other) {
		//0 equal
		//-1 is smaller
		//+1 is larger
		int lastnamecomp = authorLastName.compareTo(other.getAuthorLastName());
		int firstnamecomp = authorFirstName.compareTo(getAuthorFirstName());
		int titlecomp = title.compareTo(other.getTitle());
		
		if(lastnamecomp != 0) {
			return lastnamecomp;
		}
		else {
			if(firstnamecomp != 0) {
				return firstnamecomp;
			}
		}
		return titlecomp;
	}

	@Override
	public boolean equals(Object otherBook) {
		if (this == otherBook) {
			return true;
		}
		if (otherBook == null) {
			return false;
		}
		if (!(otherBook instanceof MyBook)) {
			return false;
		}
		MyBook other = (MyBook) otherBook;
		if (ISBN10 == null) {
			if (other.ISBN10 != null) {
				return false;
			}
		} else if (!ISBN10.equals(other.ISBN10)) {
			return false;
		}
		if (ISBN13 == null) {
			if (other.ISBN13 != null) {
				return false;
			}
		} else if (!ISBN13.equals(other.ISBN13)) {
			return false;
		}
		return true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title){
		this.title = title;
		if(title == null) {
			throw new IllegalArgumentException("Illegal Argument");
		}
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
		if(authorFirstName == null) {
			throw new IllegalArgumentException("Illegal Argument");
		}
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
		if(authorLastName == null) {
			throw new IllegalArgumentException("Illegal Argument");
		}
	}

	public String getISBN10() {
		return ISBN10;
	}

	public void setISBN10(String iSBN10) {
		if(iSBN10.length() != 10) {
			throw new IllegalArgumentException("Illegal Argument");
		}
		ISBN10 = iSBN10;
	}

	public String getISBN13() {
		return ISBN13;
	}

	public void setISBN13(String iSBN13) {	
		if(iSBN13.length() != 13) {
			throw new IllegalArgumentException("Illegal Argument");
		}
		ISBN13 = iSBN13;
	}

	public MyBook(String title, String authorFirstName, String authorLastName, String iSBN10, String iSBN13) {
		super();
		this.title = title;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		ISBN10 = iSBN10;
		ISBN13 = iSBN13;
		
		setTitle(this.title);
		setAuthorFirstName(this.authorFirstName);
		setAuthorLastName(this.authorLastName);
		setISBN10(ISBN10);
		setISBN13(ISBN13);
	}
	
	//Default constructor no parameters.
	public MyBook() {
		title = "None Given";
		authorFirstName = "None Given"; 
		authorLastName = "None Given";
		ISBN10 = "0000000000";
		ISBN13 = "0000000000000";
		
	}


	private String title, authorFirstName, authorLastName, ISBN10, ISBN13;

}
