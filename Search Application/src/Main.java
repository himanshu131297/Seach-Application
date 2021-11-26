import java.util.List;
import java.util.Scanner;

import Dictionary.Dictionary;
import Dictionary.Dictionaryhelper;

public class Main {
	private static void printMessage(Dictionary.Operation operation, boolean isSuccess) {
		System.out.printf("<<<<< %s operation, success = %s >>>>>\n", operation, isSuccess);
	}

	private static void printMessage(Dictionary.Operation operation, List<String> output) {
		System.out.printf("<<<<< %s operation, here is the list:-\n", operation);
		for (String s : output) {
			System.out.printf(" ----> %s\n", s);
		}
	}

	public static void main(String[] args) {

		Dictionaryhelper helper = new Dictionaryhelper();
		Dictionary dictionary = new Dictionary(helper);
		Scanner sc = new Scanner(System.in);
		boolean breakOutOfLoop = false;
		System.out.println("Hello User, You have entered Dictionary Search Application System");
		System.out.println("Select any of the supported operation");
		for (Dictionary.Operation operation : Dictionary.Operation.values()) {
			System.out.println(operation);
		}
		System.out.println("Type exit in the prompt, when you want to terminate the program");
		while (!breakOutOfLoop) {
			System.out.println("===== Input the operation you want to perform! =====");
			try {
				Dictionary.Operation requestedOperation = Dictionary.Operation.parse(sc.next());
				String word = "";
				switch (requestedOperation) {
				case INSERT:
					System.out.println("=== Input the desired word ===");
					word = sc.next();
					printMessage(requestedOperation, dictionary.insert(word));
					break;
				case SEARCH:
					System.out.println("=== Input the desired word ===");
					word = sc.next();
					printMessage(requestedOperation, dictionary.search(word));
					break;
				case DELETE:
					System.out.println("=== Input the desired word ===");
					word = sc.next();
					printMessage(requestedOperation, dictionary.delete(word));
					break;
				case AUTOSUGGEST:
                    System.out.println("=== Input the desired word ===");
                    word = sc.next();
                    printMessage(requestedOperation, dictionary.autoSuggest(word));
                    break;           
                
				}
				
			} catch (IllegalArgumentException exception) {
				breakOutOfLoop = true;
				System.out.println("Thank you for using our dictionary application, exiting . . . . ");
			}
		}

	}
}
