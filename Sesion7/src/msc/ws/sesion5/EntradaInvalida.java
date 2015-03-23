package msc.ws.sesion5;

@SuppressWarnings("serial")
public class EntradaInvalida extends Exception {
	public EntradaInvalida(String message, String cause){
		super(message, new Throwable(cause));
	}
}
