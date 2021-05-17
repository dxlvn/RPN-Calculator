package fr.uvsq.poo.RPN;

/**
 * Affichage de la memoire calculette.
 */
public class RetOP implements Command {
    /**
     * calculette.
     */
    private MoteurRPN mot;

    /**
     * Constructeur.
     * @param mota moteur de calculette
     */
    public RetOP(final MoteurRPN mota) {
        this.mot = mota;
    }

    /**
     * execute la command associer.
     */
    @Override
    public void execute() {
        this.mot.retOP();
    }

    /**
     * heritage interface inutiliser.
     * @param avr parametre modifier
     */
    @Override
    public void modify(final String avr) {

    }

    /**
     * undo.
     */
    public void undo()  {
    }
}
