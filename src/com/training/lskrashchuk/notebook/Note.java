package com.training.lskrashchuk.notebook;

/**Class describes note which is contained in the class Notebook
 * 
 * @author Larisa Skrashchuk
 *
 */
public class Note {
	private String content;

	public Note(String note){
		content = note;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
