package Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Comparing.Pair;

public class TrieNode {

	int numPrefixes = 0;
	int accessFrequency = 0;
	boolean WordEnding = false;
	HashMap<Character, TrieNode> children = new HashMap<>();

	public boolean insert(String word, int index) {
		if (index == word.length()) {
			if (WordEnding) {
				return false;
			} else {
				numPrefixes++;
				WordEnding = true;
				return true;
			}

		}
		if (children.get(word.charAt(index)) == null) {
			children.put(word.charAt(index), new TrieNode());
		}
		if (children.get(word.charAt(index)).insert(word, index + 1)) {
			numPrefixes++;
			return true;
		}
		System.out.println(numPrefixes);
		return false;

	}

	public boolean search(String word, int index) {
		if (index == word.length()) {
			if (WordEnding) {
				accessFrequency++;
			}
			return WordEnding;
		}
		if (children.get(word.charAt(index)) == null) {
			return false;
		}
		return children.get(word.charAt(index)).search(word, index + 1);
	}

	public boolean delete(String word, int index) {
		if (word.length() == index) {
			if (WordEnding) {
				numPrefixes--;
				WordEnding = false;
				return true;
			}
			return false;
		}
		if (children.get(word.charAt(index)) == null) {
			return false;
		}
		if (children.get(word.charAt(index)).delete(word, index + 1)) {
			numPrefixes--;
			if (numPrefixes == 0) {
				children.remove(word.charAt(index));
			}
			return true;
		}
		return false;
	}

	TrieNode getPrefixNode(String word, int index) {
		if (word.length() == index) {
			return this;
		}
		if (children.get(word.charAt(index)) == null) {
			return null;
		}
		return children.get(word.charAt(index)).getPrefixNode(word, index + 1);
	}

	List<Pair> getAllDescendentWords(String word) {
		List<Pair> descendents = new ArrayList<>();
		if (WordEnding) {
			descendents.add(new Pair(word, accessFrequency));
		}
		for (char c : children.keySet()) {
			String newPrefix = word + c;
			descendents.addAll(children.get(c).getAllDescendentWords(newPrefix));
		}
		return descendents;
	}

}
