/**
 * 
 */
package model;

import lombok.Data;
import lombok.ToString;

@Data
public class Transaction {
	
	@ToString.Exclude
	private Account Account;
	private Double value;
	private String typeTransaction;
	private String dataTimeTransaction;
}
