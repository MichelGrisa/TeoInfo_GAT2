
public class RLE {
	String text;
	
	public RLE(){}

	public RLE(String text){
		this.text = new String(text);
	}
	
	public String encode(){
		String encodedText = new String();
		int runLength = 1;
		char charRead = ' ';
		for(int i = 0; i < text.length(); i++){
			char currentChar = text.charAt(i);
			if(currentChar == charRead){
				runLength++;
			}else if(i == 0){
				charRead = currentChar;
			}else{	
				encodedText += String.valueOf(runLength) + charRead;		
				charRead = currentChar;
				runLength = 1;
			}
		}
		encodedText += String.valueOf(runLength) + charRead;
		return encodedText;
	}
	public String decode(String text){
		String decodedText = new String();
		int runLength = 0;
		char readChar = ' ';
		String runLengthString = new String();
		for(int i = 0; i < text.length(); i++){
			if(text.charAt(i)>= '0' && text.charAt(i) <= '9'){
				runLengthString += text.charAt(i);
			}else{
				runLength = Integer.parseInt(runLengthString);
				readChar = text.charAt(i);
				for(int j =0; j < runLength; j++){
					decodedText += readChar;
				}
				runLengthString = new String();
			}
		}
		return decodedText;
	}
}
