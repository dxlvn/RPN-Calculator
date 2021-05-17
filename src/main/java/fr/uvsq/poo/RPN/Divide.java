package fr.uvsq.poo.RPN;

/**
 * Classe dérivé pour l'opération Division.
 * .
 */
public class Divide extends ApOP {

    /**
     * Constructeur de la classe.
     * @param mot moteur faisant tourner la calculette
     */
    public Divide(final MoteurRPN mot) {
        super(mot, "/");
    }
    /**
     * Applique l'operation division.
     * @param nbr1 nombre numero 1
     * @param nbr2 nombre numero 2
     */
    @Override
    protected int operate(final int nbr1, final int nbr2) {
        super.operate(nbr1, nbr2);
        return nbr1 / nbr2;
    }

}
