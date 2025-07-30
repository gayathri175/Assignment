package practice2;


import java.util.ArrayList;

class MediaLibrary {
	private ArrayList<Object> mediaList = new ArrayList<Object>();

	public void addMedia(Object media) {
		mediaList.add(media);
	}

	public Object getMedia(int index) {
		if (index >= 0 && index < mediaList.size()) {
			return mediaList.get(index);
		}
		return null;
	}
}

class GenericLibrary<T> {
	private ArrayList<T> mediaList = new ArrayList<>();

	public void addMedia(T media) {
		mediaList.add(media);
	}

	public T getMedia(int index) {
		if (index >= 0 && index < mediaList.size()) {
			return mediaList.get(index);
		}
		return null;
	}
}

public class NewspaperThirtynine {

	public static void main(String[] args) {

		MediaLibrary nonGenericLibrary = new MediaLibrary();
		nonGenericLibrary.addMedia("Book: Game Of Thrones");
		nonGenericLibrary.addMedia("Video: Interstellar");
		nonGenericLibrary.addMedia("Newspaper: Deccan Chronicle");

		System.out.println("Non-Generic Library:");
		System.out.println(nonGenericLibrary.getMedia(0));
		System.out.println(nonGenericLibrary.getMedia(1));
		System.out.println(nonGenericLibrary.getMedia(2));

		GenericLibrary<String> bookLibrary = new GenericLibrary<>();
		bookLibrary.addMedia("Book: Java Programming");
		bookLibrary.addMedia("Book: Clean Code");

		System.out.println("\nGeneric Book Library:");
		System.out.println(bookLibrary.getMedia(0));
		System.out.println(bookLibrary.getMedia(1));

		GenericLibrary<String> videoLibrary = new GenericLibrary<>();
		videoLibrary.addMedia("Video: The Matrix");

		System.out.println("\nGeneric Video Library:");
		System.out.println(videoLibrary.getMedia(0));
	}
}
/*Non-Generic Library:
 
Book: Game Of Thrones
Video: Interstellar
Newspaper: Deccan Chronicle

Generic Book Library:
Book: Java Programming
Book: Clean Code

Generic Video Library:
Video: The Matrix
*/