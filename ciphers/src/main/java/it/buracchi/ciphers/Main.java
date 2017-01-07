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
		logger.info("Come controprova decifriamo, usando gli stessi parametri, la stringa appena ottenuta");
		aff.decoding(aff.coding("test", 3, 5), 3, 5);
		logger.info("**************OneTimePad cipher**************");
		logger.info(
				"OneTimePad cipher ha bisogno di una codifica binaria 'B' del messaggio da cifrare e di una chiave 'K' lunga almeno quanto 'B'.");
		logger.info("I messaggi verranno cifrati con la formula C[i] = (B[i] XOR K[i]");
		logger.info("Anche in questo caso vogliamo cifrare la parola 'test'");
		logger.info(
				"Innanzi tutto facciamoci convertire la parola test in una stringa binaria utilizzando la codifica di Huffmann relativa all'alfabeto inglese");
		String test = otp.fromStringToBinary("test");
		logger.info("A questo punto, facciamoci creare una chiave casuale lunga almeno quanto il messaggio da cifrare");
		String key = otp.createKey(test);
		logger.info("A questo punto procediamo con la cifratura");
		String res = otp.coding(test, key);
		logger.info("Come controprova decifriamo con la stessa chiave la stringa appena ottenuta");
		otp.fromBinaryToString(otp.coding(res, key));
		logger.info("**************Shift cipher**************");
		logger.info(
				"Shift cipher, dato un parametro 'a', semplicemente cifra il messaggio con la formula C[i] = (P[i] + a)%26");
		logger.info("La versione con a = 3 è anche nota come CIFRARIO DI GIULIO CESARE");
		logger.info("Proviamo a cifrare 'test' anche con questo cifrario con a = 1");
		logger.info("Il risultato che ci aspettiamo è 'uftu'");
		shift.coding("test", 1);
		logger.info("Effettuiamo la solita controprova");
		shift.decoding("uftu", 1);
		logger.info("**************Substitution cipher**************");
		logger.info(
				"Substitution cipher ha bisogno di una permutazione dell'alfabeto inglese 'N'. Il messaggio cifrato sarà quindi C[i] = N[P[i]]");
		logger.info("Proviamo a cifrare 'test' con N = qwertyuiopasdfghjklzxcvbnm");
		logger.info(
				"Mettendo in colonna i due alfabeti è semplice verificare che utilizzando questa permutazione ci aspettiamo di ricevere come cifratura la stringa 'ztlz'");
		logger.info("abcdefghijklmnopqrstuvwxyz");
		logger.info("qwertyuiopasdfghjklzxcvbnm");
		logger.info("Procediamo");
		sub.coding("test");
		logger.info("Controprova");
		sub.decoding("ztlz");
		logger.info("**************Substitution cipher**************");
		logger.info(
				"Vigenere cipher ha bisogno di una parola chiave 'K' che verrà ripetuta fino al raggiungimento della dimensione del messaggio da cifrare. Il messaggio cifrato sarà quindi C[i] = (P[i] + K[i]) % 26");
		logger.info("Proviamo a cifrare 'testmessage' con K = test");
		vig.coding("testmessage");
		logger.info("Controprova");
		vig = new Vigenere(parser, "test");
		vig.decoding("mikmfikltkw");

	}

}
