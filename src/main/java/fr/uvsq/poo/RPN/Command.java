package fr.uvsq.poo.RPN;


/**
 * Interface du pattern Command.
 * .
 */
public interface Command {
    /**
     * permet d'executer les command enregistrer.
     */
    void execute();

    /**
     * modifie les parametre des commandes.
     * @param avr parametre modifier
     */
    void modify(String avr);

    /**
     * annule la commande.
     */
    void undo();
}
