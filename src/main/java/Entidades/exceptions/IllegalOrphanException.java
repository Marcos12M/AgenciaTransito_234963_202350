package Entidades.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta es una clase de excepción personalizada que representa una excepción de
 * huérfanos ilegales.Se utiliza para manejar casos en los que se detectan
 huérfanos ilegales en un contexto específico.
 *
 */
public class IllegalOrphanException extends Exception {

    private final List<String> messages;

    /**
     * Constructor de la clase IllegalOrphanException.
     *
     * @param messages - Una lista de mensajes que describen los huérfanos
     * ilegales detectados.
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && !messages.isEmpty() ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<>();
        } else {
            this.messages = messages;
        }
    }

    /**
     * Obtiene la lista de mensajes que describen los huérfanos ilegales
     * detectados.
     *
     * @return La lista de mensajes.
     */
    public List<String> getMessages() {
        return messages;
    }
}
