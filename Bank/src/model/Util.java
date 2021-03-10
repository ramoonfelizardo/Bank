/**
 * 
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author cbgomes
 *
 */
public class Util {

	public static String formatDate(LocalDateTime date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateNow = date.format(formatter);

		return dateNow;
	}

}
