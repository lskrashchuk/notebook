package com.training.lskrashchuk.notebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**Class for work with notebook from console. It also contains method for print all notes from
 * notebook.
 * 
 * @author Larisa Skrashchuk
 *
 */
public class NotebookApplication {

	public static void printAllNotes(Notebook notebook){
		for (int i=0; i<notebook.getNotesCount(); i++) {
			System.out.println(notebook.getNoteByIndex(i).getContent());
		}
	}
	
	public static void main(String[] args) throws IOException {
		Notebook notebook = new Notebook();
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		String inputLine = reader.readLine();
        
		while (!(inputLine.equals("q"))) {
			if (inputLine.length()==0) inputLine=" ";
			switch (inputLine.substring(0,1)) {
				case "a" :
					inputLine = reader.readLine();
					notebook.addNote(new Note(inputLine));
					break;
				case "l" :
					printAllNotes(notebook);
					break;
				case "d" :
					try {
						notebook.deleteNote(Integer.parseInt(inputLine.substring(2)));
						break;
					}
					catch (NumberFormatException e) {
						System.out.println("int index required");
					}
					catch (StringIndexOutOfBoundsException e) {
						System.out.println("index required");					
					}
				case "e" :
					try {
						int indexEdit = Integer.parseInt(inputLine.substring(2));
						inputLine = reader.readLine();
						notebook.editNote(indexEdit,inputLine);
						break;
					}
					catch (NumberFormatException e) {
						System.out.println("int index required");
					}
					catch (StringIndexOutOfBoundsException e) {
						System.out.println("index required");					
					}
					
				default :
					System.out.println("Usage notebook:");
					System.out.println("a - add note");
					System.out.println("d index - delete note in position index, where index - int and numbering begins with 0");
					System.out.println("e index - edit note in position index, where index - int and numbering begins with 0");
					System.out.println("l - list all notes");
					System.out.println("q - exit");
					break;
			}
			inputLine = reader.readLine();
		
		}

	}
}
