package teste;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);
		Random sorteio = new Random();
		int numero = sorteio.nextInt(100);
		System.out.println("digite o seu palpite");
		int palpite = teclado.nextInt(34);
		while(palpite != numero) {
			if (palpite > numero)
				   System.out.println("digite um numero menor");
				else
				  System.out.println("digite um numero maior");
			System.out.println("tente outro palpite");
			palpite = teclado.nextInt();
		}
		
		System.out.println("ok, vc acertou");

	}

}
