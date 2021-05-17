package fr.uvsq.poo.RPN;

/**
 * Classe gérant les opérations générale d'une calculette RPN.
 */
public class ApOP implements Command, Cloneable {
    /**
     * calculette.
     */
    private MoteurRPN mot;
    /**
     * operande.
     */
    private String str;
    /**
     * nb1.
     */
    private int nbr1;
    /**
     * nb2.
     */
    private int nbr2;

    /**
     * Constructeur.
     * @param mota calculette
     * @param stra operande
     */
    public ApOP(final MoteurRPN mota, final String stra) {
        this.mot = mota;
        this.str = stra;
    }

    /**
     * Constructeur.
     * @param mota calculette
     */
    public ApOP(final MoteurRPN mota) {
        this.mot = mota;

    }

    /**
     * Effectue operation pour chaque sous calcul +-*\ (polymorphisme).
     * @param nbr1a nb1a
     * @param nbr2a nb2a
     * @return 0
     */
     protected int operate(final int nbr1a, final int nbr2a) {
        this.nbr1 = nbr1a;
        this.nbr2 = nbr2a;
        return 0;
     }

    /**
     * Execute loperation courante.
     */
    @Override
    public void execute() {
        this.mot.apOP(this);
    }

    /**
     * Modifie loperande courante.
     * @param avr parametre modifier
     */
    @Override
    public void modify(final String avr) {
       this.str = avr;

    }

    /**
     * Modifier les deux nombre a operer.
     * @param nbr1a nb1
     * @param nbr2a 2
     */
    public void modify(final int nbr1a, final int nbr2a) {
        this.nbr1 = nbr1a;
        this.nbr2 = nbr2a;
    }

    /**
     * annuler operation.
     */
    @Override
    public void undo() {
        this.mot.apOPUndo(nbr1, nbr2);
    }

    /**
     * clone l'instance de classe.
     * @return une copie de l'objet
     * @throws CloneNotSupportedException pas effectuer
     */
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
