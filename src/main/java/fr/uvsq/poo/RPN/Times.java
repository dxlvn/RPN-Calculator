package fr.uvsq.poo.RPN;

/**
 * Multiplication
 * .
 */
public class Times extends ApOP {
    /**
     * Constructeur.
     * @param mot calculette
     */
    public Times(final MoteurRPN mot) {
        super(mot, "*");
    }

    /**
     * Effectue Multiplication.
     * @param nbr1 1
     * @param nbr2 2
     * @return resultat
     */
    @Override
    protected int operate(final int nbr1, final int nbr2) {
        super.operate(nbr1, nbr2);
        return nbr1 * nbr2;
    }

}
