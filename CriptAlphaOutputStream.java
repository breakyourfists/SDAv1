import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CriptAlphaOutputStream extends OutputStream {
    char vogais[] = {'A','E','I','O','U'};
    String consoante = "bcdfghjkmnpqrstvwyxz";
    char consoantes[];

    OutputStream output;
    public CriptAlphaOutputStream(OutputStream output){
        this.output=output;
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
    public void write(int i) throws IOException {
        byte b = (byte) i;
        output.write(b);
    }

    public void write(String c)throws  IOException{
        String retorno = "";
        for (int i = 0; i < c.length() ; i++) {
            retorno += getNextChar(c.charAt(i));
            write(getNextChar(c.charAt(i)));
        }
        //System.out.println("\nRetorno: "+retorno);
    }

    @Override
    public void flush() throws IOException {
        output.flush();
    }
}
