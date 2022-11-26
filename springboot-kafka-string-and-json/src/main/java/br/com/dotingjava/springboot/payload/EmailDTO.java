/*
 Author: Sandro Lemanski da Silva (sandrogates@gmail.com)
 Version 1.0
 Date: 01/10/2022 
 */

package br.com.dotingjava.springboot.payload;

/*
 * here, I could even have used lombok (https://projectlombok.org/), but to simplify, I made the standard get and set methods
 * Tks. Sandro
 */
public class EmailDTO {
    private String fromEmail;
    private String toEmail;
    private String subject;
    private String message;

    public String getFromEmail() {
		return fromEmail;
	}


	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}


	public String getToEmail() {
		return toEmail;
	}


	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
    public String toString() {
        return "EmailDTO {" +
                "fromEmail=" + this.getFromEmail() +
                ", toEmail='" + this.getToEmail() + '\'' +
                ", subject='" + this.getSubject() + '\'' +
                ", message='" + this.getMessage() + '\'' +
                '}';
    }
}
