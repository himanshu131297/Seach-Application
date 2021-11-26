package Dictionary;

import java.util.List;

import Tries.Trie;

public class Dictionaryhelper {
	Trie dataTrie = new Trie();

	public boolean insertdictionary(String word) {
		return dataTrie.insertTrie(word);
	}

	public boolean searchdictionary(String word) {
		return dataTrie.searchTrie(word);
	}

	public boolean deletedictionary(String word) {
		return dataTrie.deleteTrie(word);
	}

	public List<String> autoSuggest(String prefix) {
		return dataTrie.autoSuggest(prefix);
	}

}
