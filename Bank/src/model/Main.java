package model;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Transaction> tras = new  ArrayList<Transaction>();

		Client mario = new Client();
		mario.setId(1L);
		mario.setName("Mario Sergio");
		mario.setEmail("seucuca@gmail.com");
		mario.setPhone("242424242424");
		
		Client paulo = new Client();
		paulo.setId(1L);
		paulo.setName("Mario Sergio");
		paulo.setEmail("seucuca@gmail.com");
		paulo.setPhone("83987123123");
		
		
		
		Account accountMario = CurrentAccount.builder()
				.id(1L)
				.number("123")
				.agency("0001")
				.balance(500.00)
				.client(paulo)
				.build();
		
		CurrentAccount accountPaulo = CurrentAccount.builder()
				.id(1L)
				.number("0002-x")
				.agency("0002")
				.client(paulo)
				.balance(200.00)
				.tax(2.0)
				.build();
		

		
		System.out.println("paulo: " + accountPaulo.getBalance());
		accountPaulo.sacar(100.00);
		System.out.println("paulo: " + accountPaulo.getBalance());
		accountPaulo.depositar(20.00);
		System.out.println("paulo depois que depositou: " + accountPaulo.getBalance());
		accountPaulo.transferir(accountMario, 100.00);
		System.out.println("paulo depois que transferiu: " + accountPaulo.getBalance());
		
		for (Transaction transaction : accountPaulo.getTransactions()) {
			System.out.println(transaction.getTypeTransaction());
		}
		
		System.out.println(accountPaulo);
		//System.out.println(accountMario.getTransactions().toString());
	}

}
