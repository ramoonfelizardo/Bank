package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Account{
	
	private Long id;
	private String number;
	private String agency;
	private Double balance;
	private Client client;
	@Builder.Default
	private List<Transaction> transactions = new ArrayList<Transaction>();
	

	public Double sacar(Double value) {
		if (this.balance >= value) {
			this.balance -= value;
		}
		this.transactions.add(createTransaction(this, value, "Saque"));
		return this.balance;
	}

	public Double depositar(Double value) {
		this.transactions.add(createTransaction(this, value, "Deposito"));
		return this.balance += value;
	}

	public Double transferir(Account Account, Double value) {
		if (this.balance >= value) {
			this.sacar(value);
			Account.depositar(value);
		}
		this.transactions.add(createTransaction(this, value, "Transferência"));
		return this.balance;
	}
	
	public List<Transaction> transacoes(){
		return this.transactions;
	}


	private Transaction createTransaction(Account account, Double value, String typeTransaction) {
		
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setValue(value);
		transaction.setTypeTransaction(typeTransaction);
		transaction.setDataTimeTransaction(formatDate(LocalDateTime.now()));
		
		return transaction;
	}
	
	
	private String formatDate(LocalDateTime date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateNow = date.format(formatter);

		return dateNow;
	}

}