package Entidades.exceptions;

/**
 * Excepción personalizada para representar un error cuando se intenta crear una
 * entidad que ya existe.
 */
public class PreexistingEntityException extends Exception {

    /**
     * Constructor que acepta un mensaje de error y una causa raíz de la
     * excepción.
     *
     * @param message El mensaje de error asociado con la excepción.
     * @param cause La causa raíz de la excepción.
     */
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param message El mensaje de error asociado con la excepción.
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}
