package Tries;

import java.util.ArrayList;
import java.util.List;

import Comparing.Pair;

public class Trie {
	TrieNode root = new TrieNode();
	int startIndex = 0;

	public boolean insertTrie(String word) {
		return root.insert(word, startIndex);

	}

	public boolean searchTrie(String word) {
		return root.search(word, startIndex);
	}

	public boolean deleteTrie(String word) {
		return root.delete(word, startIndex);
	}

	public List<String> autoSuggest(String prefix) {
		TrieNode prefixNode = root.getPrefixNode(prefix, startIndex);
		List<Pair> allSuggestions = prefixNode.getAllDescendentWords(prefix);
		List<String> result = new ArrayList<>();
		for (Pair p : allSuggestions) {
			result.add(p.getval());
		}
		return result;

	}

}
