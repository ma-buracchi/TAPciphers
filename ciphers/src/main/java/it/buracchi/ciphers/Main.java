package it.buracchi.ciphers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.*;

public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws IOException {

		BasicConfigurator.configure();

		Parser parser = new InputManager();
		Affine aff = new Affine(parser);
		OneTimePad otp = new OneTimePad(parser);
		Shift shift = new Shift(parser);
		Substitution sub = new Substitution(parser, "qwertyuiopasdfghjklzxcvbnm");
		Vigenere vig = new Vigenere(parser, "test");
		
		logger.info("Benvenuti in ciphers, progetto per esame di Tecniche Avanzate di Programmazione");
		logger.info(
				"In questo progetto assumiamo che 'P' (plaintext) rappresenti il messaggio in chiaro, 'C' (ciphertext) rappresenti il messaggio cifrato, C[i] l'i-esimo carattere del messaggio cifrato e P[i] l'i-esimo carattere del messaggio in chiaro");
		logger.info("Vediamo tutte le funzionalità implementate dai vari cifrari");
		logger.info("**************Affine cipher**************");
		logger.info(
				"Per quanto riguarda l'Affine cipher, dati due parametri 'a' e 'b', i messaggi verranno cifrati con la formula C[i] = (a*P[i] + b)%26");
		logger.info(
				"Proviamo a cifrare la stringa 'test' usando come parametri a=3 e b=5. Dovremmo ottenere la stringa 'krhk'");
		logger.info("Proviamo:");
		aff.coding("test", 3, 5);
		logger.info("Come controprova decodifichiamo, usando gli stessi parametri, la stringa appena ottenuta");
		aff.decoding(aff.coding("test", 3, 5), 3, 5);
		logger.info("**************OneTimePad cipher**************");
		
	}

}
