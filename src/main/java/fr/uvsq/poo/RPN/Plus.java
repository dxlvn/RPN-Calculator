package fr.uvsq.poo.RPN;

/**
 * Addition.
 * .
 */
public class Plus extends ApOP {
    /**
     * Constructeur.
     * @param mot calculette
     */
    public Plus(final MoteurRPN mot) {
        super(mot, "+");
    }

    /**
     * Addition.
     * @param nbr1
     * @param nbr2
     * @return resultat +
     */
    @Override
    protected int operate(final int nbr1, final int nbr2) {
        super.operate(nbr1, nbr2);
        return nbr1 + nbr2;
    }
}
