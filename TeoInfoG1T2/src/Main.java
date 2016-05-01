import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Main {
	private String allowedChars = "abcdefghijklmnopqrstuvwyxz";
	private String image = new String();

	public Main(){

		Scanner ioin = new Scanner(System.in);
		System.out.println("|============================================|");
		System.out.println("|TGA 2 - RLE + Huffman                       |");
		System.out.println("|============================================|");
		System.out.println("1- Gerar imagem e compactar (será gerado um arquivo compactado).");
		System.out.println("2- Descompactar um arquivo.");
		System.out.print(">");

		int opt = ioin.nextInt();
		
		if (opt == 1)
		{
			System.out.println("Quantas colunas a imagem deve ter? ");
			System.out.print(">");
			int col = ioin.nextInt();
			System.out.println("E quantas linhas? ");
			System.out.print(">");
			int lin = ioin.nextInt();

			System.out.println("Criando imagem " + col + "x" + lin);
			createImage(col, lin);
			
			System.out.println("Imagem gerada: " + image);

			System.out.println("Rodando RLE");
			RLE rle = new RLE(image);
			
			String encodedText = rle.encode();
			System.out.println("RLE code: " + encodedText);
			
			Compactador c = new Compactador(encodedText, col, lin);

		} else if (opt == 2) {

			Descompactador d = new Descompactador();
			System.out.println("Descompactando...");
			String s = d.descompacta();
			int col = Integer.parseInt(s.substring(0, s.indexOf('x')));
			int lin = Integer.parseInt(s.substring(s.indexOf('x')+1, s.indexOf('|')));
			s = s.substring(s.indexOf('|')+1, s.length());
			
			System.out.println("Tamanho da imagem: " + col + "x" + lin);
			System.out.println("Retorno RLE: " + s);
			RLE rle = new RLE();
			
			System.out.println("Imagem: " + rle.decode(s));
			
			

		} else {
			System.out.println("\nFinalizado.");
		}
		//System.out.println(encodedText);
		//System.out.println(rle.decode(encodedText));*/
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
