package fr.uvsq.poo.RPN;

import java.util.Stack;

/**
 * Classe gérant l'éxécution des méthodes pour la calculette.
 * .
 */
public class MoteurRPN extends Interprete {
    /**
     * Memoire calculette.
     */
   private Stack<Integer> stackRPN;

    /**
     * Constructeur.
     * @param in Invoker du pattern command
     */
    MoteurRPN(final Invoker in) {
        super(in);
        stackRPN = new Stack<Integer>();

    }

    /**
     * ajoute un nombre à la memoire de la calculette.
     * @param numa le nombre courant
     */
    public void regOP(final int numa) {
       stackRPN.add(numa);
    }

    /**
     * Applique l'operation sur la memoire de la calculette.
     * @param apOP loperande appliquer sous forme d'objet
     * @return vrai si operation reussi faux sinon
     */
    public Boolean apOP(final ApOP apOP) {
        if (stackRPN.size() < 2) {
            System.out.println("not enough number in stack");
            return false;
        }
        int op1 = stackRPN.pop();
        int op2 = stackRPN.pop();
        stackRPN.push(apOP.operate(op1, op2));

    return true;
    }

    /**
     * Annule apOP.
     * @param nbr1 nombre a remettre numero 1
     * @param nbr2 nombre a remetter numero 2
     * @return vrai si reussie faux sinon
     */
    public boolean apOPUndo(final int nbr1, final int nbr2) {
        /*pop le dernier nombre reinserer les deux derniers int */
        stackRPN.pop();
        stackRPN.push(nbr2);
        stackRPN.push(nbr1);
        return true;
    }

    /**
     * affiche la memoire de la calculette.
     * @return la calculette
     */
    public Stack<Integer> retOP() {
        Stack<Integer> cpy = new Stack<Integer>();
        cpy = (Stack<Integer>) stackRPN.clone();
        if (cpy.isEmpty()) {
            System.out.println("empty");
            return stackRPN;
        }
        while (!cpy.isEmpty()) {
            System.out.println(cpy.pop());
        }
        return stackRPN;
    }

    /**
     * Annule l'ajout d'un nombre.
     */
    public void regOPUndo() {
            stackRPN.pop();
    }




}
