/**
 * A WordGram object represents an immutable
 * sequence of words.
 * For use in Compsci 201, Duke University, Fall 2022
 * Add yourself as an author when you make edits
 * @author Brandon Fain
 * @author Owen Astrachan, revised Fall 2023
 * @author Ashley Whipple, Spring 2024
 */

public class WordGram {
	private String[] myWords; 	// Stores WordGram words
	private String myToString;	// Stores space separated words as one string
	private int myHash;			// Stores hash value of WordGram

	
	/**
	 * Constructor should generate a WordGram with size words
	 * beginning at the start index value of source array.
	 * Each element of source array should be a single word.
	 * @param source Source array, each element should be a single word
	 * @param start Index of first word for WordGram object
	 * @param size Number of elements in WordGram object
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for(int k=0; k < size; k++) {
			myWords[k] = source[start + k];
		}
		myToString = String.join(" ", myWords);
		myHash = myToString.hashCode();
	}

	/**
	 * Returns number of words in this WordGram
	 * @return order of wordgram, number of words
	 */
	public int length() {
		return myWords.length;
	}


	/** 
	 * Returns true if o is also a wordgram with the
	 * same words, otherwise returns false 
	*/
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram other = (WordGram) o;
		return myToString.equals(other.myToString);
	}


	/**
	 * Returns a hashCode for WordGram object equal to 
	 * the hashCode of the space separated words stored in 
	 * the WordGram.
	 */
	@Override
	public int hashCode() {
		return myHash;
	}


	/**
 * Return a new WordGram of the same length as this WordGram
 * consisting of words 1 through length-1 of this WordGram
 * followed by last. Does NOT mutate this WordGram.
 * @param last added as the last string of the returned WordGram
 *              Should be a single word
 * @return new WordGram
 */
public WordGram shiftAdd(String last) {
    String[] newWords = new String[this.length()];

    // Copy words from index 1 through length-1 to the new array
    for (int j = 0; j < myWords.length - 1; j++) {
        newWords[j] = myWords[j + 1];
    }

    // Add the new word at the end
    newWords[myWords.length - 1] = last;

    // Create and return a new WordGram with the updated array
    return new WordGram(newWords, 0, length());
}


	/**
	 * Returns space separated words stored in the WordGram
	 * as a single String.
	 */
	@Override
	public String toString() {
		return myToString;
	}
}
