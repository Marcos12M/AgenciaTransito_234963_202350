package Entidades.exceptions;

/**
 * Excepción personalizada para representar un error cuando se intenta acceder a
 * una entidad inexistente.
 */
public class NonexistentEntityException extends Exception {

    /**
     * Constructor que acepta un mensaje de error y una causa raíz de la
     * excepción.
     *
     * @param message El mensaje de error asociado con la excepción.
     * @param cause La causa raíz de la excepción.
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param message El mensaje de error asociado con la excepción.
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
