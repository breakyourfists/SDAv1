import java.io.IOException;
import java.io.OutputStreamWriter;

public class CipherWriter {
	char vogais[] = { 'A', 'E', 'I', 'O', 'U' };
	String consoante = "bcdfghjkmnpqrstvwyxz";
	char consoantes[];

	OutputStreamWriter output;

	public CipherWriter(OutputStreamWriter output) {
		this.output = output;
		consoantes = new char[consoante.length()];
		for (int i = 0; i < consoante.length(); i++) {
			consoantes[i] = consoante.charAt(i);
		}
	}

	boolean isVogal(char c) {
		for (char vogal : vogais) {
			if (Character.valueOf(Character.toUpperCase(c)).equals(vogal))
				return true;
		}
		return false;
	}

	Character getNextChar(char c) {
		try {
			if (isVogal(c)) {
				for (int i = 0; i < vogais.length; i++) {
					if (Character.valueOf(Character.toUpperCase(c)).equals(vogais[i])) {
						if(i+1>=vogais.length)
							return Character.toUpperCase(vogais[0]);
						return vogais[i + 1];
					}
				}
			} else {
				for (int i = 0; i < consoantes.length; i++) {
					if (Character.valueOf(Character.toLowerCase(c)).equals(consoantes[i])) {
						if(i+1>=consoantes.length)
							return Character.toUpperCase(consoantes[0]);
						return Character.toUpperCase(consoantes[i + 1]);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("erro ao processar o char " + c);
			e.printStackTrace();
		}
		return null;
	}

	public void write(int i) throws IOException {
		byte b = (byte) i;
		output.write(b);
	}

	public void write(String c) throws IOException {
		// String retorno = "";
		for (int i = 0; i < c.length(); i++) {
			// retorno += getNextChar(c.charAt(i));
			write(getNextChar(c.charAt(i)));
		}
		// System.out.println("\nRetorno: "+retorno);
	}

	void flush() throws IOException {
		output.flush();
	}

}
