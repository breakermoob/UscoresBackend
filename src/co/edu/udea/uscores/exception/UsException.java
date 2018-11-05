package co.edu.udea.uscores.exception;

import org.apache.log4j.Logger;

/**
 * <p>Esta clase se creo para el manejo de errores</p>
 * 
* @Author Leon Arango - leon.arango@udea.edu.co
* @since 01/05/2018
* @Version = 1.0 
* */ 

public class UsException extends Exception{ 
		
	/**
	 * <p>Este objeto es para escribir el log en un archivo</p>
	 */
	private Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;

	public UsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsException(String message, Throwable cause) {
		super(message, cause);
		//Podemos utilizarlo en cada constructor
		logger.error(message,cause);
		// TODO Auto-generated constructor stub
	}

	public UsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
