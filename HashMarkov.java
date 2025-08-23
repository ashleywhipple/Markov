import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.*;



public class HashMarkov implements MarkovInterface {
    protected String[] myWords;		// Training text split into array of words 
	protected Random myRandom;		// Random number generator
	protected int myOrder;			// Length of WordGrams used
	protected static String END_OF_TEXT = "*** ERROR ***"; 
    // this hashmap stores mapping of WordGram lists of words
    private HashMap<WordGram, List<String>> myMap = new HashMap<>();
    //constrtuctor 
    public HashMarkov(int order){
        myOrder = order;
		myRandom = new Random();
        myMap = new HashMap<>(order);
        
    }

    @Override
    public void setTraining(String text) {
        myWords = text.split("\\s+");
        int order = getOrder(); // Get the order of the Markov model
        // Loop through the words to create WordGrams and update myMap
        for (int i = 0; i <= myWords.length - order; i++) {
        WordGram key = new WordGram(myWords, i, order);
        String nextWord; 
        if (i + order < myWords.length) {
            nextWord = myWords[i + order];
        } else {
            nextWord = null;
        }
        
        // If key is not already in the map, add a new entry
        myMap.putIfAbsent(key, new ArrayList<>());

        // Add the next word to the list associated with the key
        myMap.get(key).add(nextWord);
    }
    }

    @Override
    public List<String> getFollows(WordGram wgram) {
        if(myMap.containsKey(wgram)){
            return myMap.get(wgram);
        }
        return new ArrayList<>();
    }
    private String getNextWord(WordGram wgram) {
        List<String> follows = getFollows(wgram);
        if (follows.size() == 0) {
            return END_OF_TEXT;
        } else {
            int randomIndex = myRandom.nextInt(follows.size());
            String nextWord = follows.get(randomIndex);
            if (nextWord != null) {
                return nextWord;
            } else {
                return END_OF_TEXT;
            }
        }
    }
    
    @Override
	public String getRandomText(int length){
		int index = myRandom.nextInt(myWords.length - getOrder() + 1);
        WordGram current = new WordGram(myWords, index, getOrder());
        ArrayList<String> randomWords = new ArrayList<>(length);
        // Check if current is null before adding to randomWords
        if (current != null) {
            randomWords.add(current.toString());
        }

		for(int k=0; k < length-myOrder; k += 1) {
			String nextWord = getNextWord(current);
			if (nextWord.equals(END_OF_TEXT)) {
				break;
			}
			randomWords.add(nextWord);
			current = current.shiftAdd(nextWord);
		}
		return String.join(" ", randomWords);
	}

	/**
	 * Returns order of Markov model = the length of
	 * WordGrams used.
	 */
	@Override
	public int getOrder() {
		return myOrder;
	}

	/**
	 * Sets the seed of the random number generator
	 * Model will return same value when called with 
	 * same training text after same seed set.
	 * @param seed Random number generator seed
	 */
	@Override
	public void setSeed(long seed) {
		myRandom.setSeed(seed);
	}
	
	
}
