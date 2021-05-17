package fr.uvsq.poo.RPN;

/**
 * classe quitter.
 */
public class Exit implements Command {
    /**
     * calculette.
     */
    private MoteurRPN inter;

    /**
     * Constrcuteur.
     * @param intera calculette
     */
    public Exit(final MoteurRPN intera) {
        this.inter = intera;
    }

    /**
     * execution de la commande.
     */
    @Override
    public void execute() {
        this.inter.exit();
    }

    /**
     * modification (inutiliser).
     * @param avr parametre modifier
     */
    @Override
    public void modify(final String avr) {
    }

    /**
     * annulation (inutiliser).
     */
    public void undo() {
    }
}
