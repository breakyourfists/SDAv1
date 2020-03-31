package rede;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) {
		try {
			InetAddress[] localaddr = InetAddress.getAllByName("amazon.com");
			for (int i = 0; i < 5; i++) {
				InetAddress lc2 = InetAddress.getByName("amazon.com");
				System.out.println(lc2);
				Thread.sleep(2000);
			}
		} catch (UnknownHostException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}	
