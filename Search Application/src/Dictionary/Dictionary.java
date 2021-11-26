package Dictionary;

import java.util.List;

public class Dictionary {
	private Dictionaryhelper helper;

	public static enum Operation {
		INSERT, SEARCH, DELETE, AUTOSUGGEST, AUTOCORRECT;

		public static Operation parse(String str) {
			return valueOf(str.toUpperCase());
		}
	}

	public Dictionary(Dictionaryhelper helper) {
		this.helper = helper;
	}

	public boolean insert(String word) {
		return helper.insertdictionary(word);
	}

	public boolean search(String word) {
		return helper.searchdictionary(word);
	}

	public boolean delete(String word) {
		return helper.deletedictionary(word);
	}

	public List<String> autoSuggest(String prefix) {
		return helper.autoSuggest(prefix);
	}

}
