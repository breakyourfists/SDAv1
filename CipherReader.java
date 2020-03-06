import java.io.IOException;
import java.io.InputStreamReader;

public class CipherReader {
    char vogais[] = {'A','E','I','O','U'};
    String consoante = "bcdfghjkmnpqrstvwyxz";
    char consoantes[];


    InputStreamReader input;
    public CipherReader(InputStreamReader input){
        this.input=input;
        consoantes = new char[consoante.length()];
        for (int i=0; i < consoante.length(); i++){
            consoantes[i] = consoante.charAt(i);
        }
    }

    boolean isVogal(char c){
        for (char vogal: vogais){
            if(Character.valueOf(Character.toUpperCase(c)).equals(vogal))
                return true;
        }
        return false;
    }


    Character getPreviousChar(char c) {
		try {
			if (isVogal(c)) {
				for (int i = 0; i < vogais.length; i++) {
					if (Character.valueOf(Character.toUpperCase(c)).equals(vogais[i])) {
						if(i==0)
							return vogais[vogais.length-1];
						return vogais[i - 1];
					}
				}
			} else {
				for (int i = 0; i < consoantes.length; i++) {
					if (Character.valueOf(Character.toLowerCase(c)).equals(consoantes[i])) {
						if(i==0)
							return Character.toUpperCase(consoantes[consoantes.length-1]);
						return Character.toUpperCase(consoantes[i - 1]);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("erro ao processar o char " + c);
			e.printStackTrace();
		}
		return null;
	}

    
    public int read() throws IOException {
        char c = (char)input.read();
        try{
        	return getPreviousChar(c);
        }catch (NullPointerException e) {
			return -1;
		}
    }
    


}
