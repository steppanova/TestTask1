package steppanova.com.ua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test2 {
	
	public static void findWord(String text) {
		String wordList[] = text.toLowerCase().split("[\\.,\\s!;?:\"]+");
		String result[] = new String[3];
		Arrays.sort(wordList);
		HashMap<String, Integer> resultSort = new HashMap<String, Integer>();
		int k = 0;
		for (String word : wordList) {
			if (!word.isEmpty()) {
				if (word.matches("[a-zA-Z]+(?:'[a-zA-Z]+)*")) {
					for (int i = 0; i < wordList.length; i++) {
						if (wordList[i].equals(word)) {
							k++;
							if (k > 1) {
								resultSort.put(wordList[i], k);
							}
						}
					}
					k = 0;
				}
			}
		}
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<Integer> intesgers = new ArrayList<>();
		for (HashMap.Entry<String, Integer> e : resultSort.entrySet()) {
			int value = e.getValue();
			boolean isAdded = false;
			for (int i = 0; i < intesgers.size(); i++) {
				if (value > intesgers.get(i)) {
					intesgers.add(i, value);
					strings.add(i, e.getKey());
					isAdded = true;
					break;
				}
			}
			if (!isAdded) {
				intesgers.add(value);
				strings.add(e.getKey());
			}
		}
		for (int i = 0; i < strings.size(); i++) {
			if (strings.size() < 3) {
				System.out.println(Arrays.toString(result));
				return;
			}
			for (; i < result.length; i++) {
				result[i] = strings.get(i);
			}
		}
		for (String words : result) {
			System.out.println(words);
		}
	}

	public static void main(String[] args) {
		findWord(
				",sdff 43 k'asdf, As'd sdff,As'd asdf++/*% @@@++  43 434 K'asdf As'd sdff k'asdf As'd As'd sdff As'd k'asdf stop sdff stop adf stop");

	}
}
