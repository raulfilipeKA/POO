package semana03;
public class Painting implements Drawable{
	private String artist;
	private String title;
	
	public Painting(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}

	@Override
	public void draw() {
		System.out.println("Pintar o quadro " + title + " de " + artist);	
	}
	
	
}
