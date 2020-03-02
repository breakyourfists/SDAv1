import java.io.IOException;
import java.io.InputStream;

public class CriptAlphabetInputStream extends InputStream {
    char vogais[] = {'A','E','I','O','U'};
    String consoante = "bcdfghjkmnpqrstvwyxz";
    char consoantes[];


    InputStream input;
    public CriptAlphabetInputStream(InputStream input){
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


    Character getNextChar(char c){
        if(isVogal(c)){
            for (int i = 0; i < vogais.length; i++) {
                if(Character.valueOf(Character.toUpperCase(c)).equals(vogais[i])) {
                    return vogais[i+1];
                }
            }
        }else{
            for (int i = 0; i < consoantes.length; i++) {
                if(Character.valueOf(Character.toLowerCase(c)).equals(consoantes[i])) {
                    return Character.toUpperCase(consoantes[i+1]);
                }
            }
        }
        return null;
    }

    @Override
    public int read() throws IOException {
        char c = (char)input.read();
        return getNextChar(c);
    }

    @Override
    public int read(byte[] b) throws IOException {
        return input.read(b);
    }
}
