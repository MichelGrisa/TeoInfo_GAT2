import java.util.Random;

public class Main {
	private String allowedChars = "abcdefghijklmnopqrstuvwyxz";
	private String image = new String();
	public Main(){
		createImage(10,10);
		System.out.println(image);
		RLE rle = new RLE(image);
		String encodedText = rle.encode();
		System.out.println(encodedText);
		System.out.println(rle.decode(encodedText));
	}

	private void createImage(int collumns, int rows) {
//		image = new char[rows][collumns];
		Random randonCharOfImage = new Random(System.currentTimeMillis());
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < collumns; j++){
				image += allowedChars.charAt(randonCharOfImage.nextInt(allowedChars.length()));
			}
		}
		
	}
	public static void main(String[] args) {
		new Main();

	}

}
