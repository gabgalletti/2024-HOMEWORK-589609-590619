package it.uniroma3.diadia.IOConsole;

import java.util.Scanner;
import it.uniroma3.diadia.*;

public class IOConsole implements IO{

	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
		}
	Scanner scannerDiLinee;

	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
	}

	public String leggiRiga(Scanner scannerDiLinee) {
		// TODO Auto-generated method stub
		return null;
	}
}

