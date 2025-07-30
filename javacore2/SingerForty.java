package practice2;


import java.util.ArrayList;
import java.util.Collections;

class CD implements Comparable<CD> {
	String title;
	String singer;

	public CD(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}

	@Override
	public int compareTo(CD other) {
		return this.singer.compareTo(other.singer);
	}

	public String toString() {
		return "Title: " + title + ", Singer: " + singer;
	}
}

public class SingerForty {

	public static void main(String[] args) {
		ArrayList<CD> cds = new ArrayList<>();
		cds.add(new CD("Blinding Lights", "The Weekend"));
		cds.add(new CD("Divide", "anirudhravi"));
		cds.add(new CD("25", "ssthaman"));
		cds.add(new CD("Justice", "dsp"));

		Collections.sort(cds);

		for (CD cd : cds) {
			System.out.println(cd);
		}
	}
}
/*Title: Blinding Lights, Singer: The Weekend
Title: Divide, Singer: anirudhravi
Title: Justice, Singer: dsp
Title: 25, Singer: ssthaman
*/