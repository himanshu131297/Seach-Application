package Comparing;

import java.util.Comparator;

public class Pair implements Comparator<Pair> {
	String value;
	int frequency;

	public Pair(String str, int freq) {
		this.value = str;
		this.frequency = freq;
	}

	public int getfreq() {
		return frequency;
	}

	public String getval() {
		return value;
	}

	@Override
	public int compare(Pair p1, Pair p2) {
		if (p1.frequency < p2.frequency) {
			return 1;
		} else if (p1.frequency > p2.frequency) {
			return -1;
		}
		return 0;
	}
}
