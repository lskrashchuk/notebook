package com.training.lskrashchuk.notebook;

/**Class contains objects by type Note. There are possible to add notes into notebook,
 * to detele notes from notebook by index, to edit notes in notebook by index. 
 * @author Larisa Skrashchuk
 *
 */
public class Notebook {
	/**
	 * Property to store notes
	 */
	private Note[] notes;
	/**
	 * Property to store count of notes
	 */
	private int notesCount;
		
	/**
	 * Given the initial size of the array.
	 */
	public Notebook() {
		notes = new Note[10];
	}
	
	public int getNotesCount() {
		return notesCount;
	}

	/**
	 * Add note in notebook. If array of notes is full its size is increased by one third.
	 * @param note 
	 */
	public void addNote(Note note) {
		if (notesCount >= notes.length) {
			Note[] newNotes = new Note[notes.length+notes.length/3];
			System.arraycopy(notes, 0, newNotes, 0, notesCount);
			notes = newNotes;
		}
		notes[notesCount] = note;
		notesCount++;
	}
	
	/**
	 * Delete note from notebook by index.
	 * @param noteIndex
	 */
	public void deleteNote(int noteIndex){
		if ((noteIndex >= 0)&&(noteIndex < notesCount)) {
			Note[] copyNotes = notes;
			System.arraycopy(copyNotes, noteIndex+1, notes, noteIndex, notesCount-noteIndex-1);
			notesCount--;
		}
		else System.out.println("Index out of range");
	}
	
	/**
	 * Edit note in notebook - the existing note by index noteIndex replaced by 
	 * new note @param note.  
	 * @param noteIndex
	 * @param note
	 */
	public void editNote(int noteIndex, String content){
		if ((noteIndex >= 0)&&(noteIndex < notesCount)) {
			notes[noteIndex].setContent(content);
		}
		else System.out.println("Index out of range");
	}
	
	public Note getNoteByIndex(int noteIndex) {
		return notes[noteIndex]; 
	}
		

}
