package fr.uvsq.poo.RPN;

/**
 * Classe gérant les entrée de nombre dans la calculette.
 * .
 */
public class RegOP implements Command, Cloneable {
    /**
     * calculette.
     */
    private MoteurRPN mot;
    /**
     * numero.
     */
    private int num;

    /**
     * Constructeur.
     * @param mota Moteur de la calculette
     * @param numa nombre taper par l'utilisateur
     */
    public RegOP(final MoteurRPN mota, final int numa) {
        this.mot = mota;
        this.num = numa;
    }

    /**
     * Constructeur.
     * @param mota Moteur de la calculette
     */
    public RegOP(final MoteurRPN mota) {
        this.mot = mota;
    }

    /**
     * Modifieur.
     * @param numa nombre taper par l'utilisateur
     */
    public void setNum(final int numa) {

        this.num = numa;
    }

    /**
     * Methode de l'interface command qui execute la saisie de l'utilisateur.
     */
    @Override
    public void execute() {
        this.mot.regOP(num);
    }

    /**
     * Modifier le paramètre du nombre par la methode de l'interface command.
     * @param avr nombre à inserer
     */
    @Override
    public void modify(final String avr) {
        setNum(Integer.parseInt(avr));
    }

    /**
     * Annule la commande.
     */
    public void undo() {
        mot.regOPUndo();
    }

    /**
     * Acceseur.
     * @return numero
     */
    public int getNum() {
        return num;
    }

    /**
     * Clone lobjet courant.
     * @return une copie de l'objet (non une reference)
     * @throws CloneNotSupportedException pas effectuer
     */
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
