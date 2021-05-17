package fr.uvsq.poo.RPN;
/**
 * Classe De Base du MoteurRPN.
 * permettant de quitter l'application et de revenir en arriere.
 *
 */
public class Interprete {
    /**
     * invoqueur de commande.
     */
      private Invoker in;

    /**
     * Constructeur.
     * @param ina Invoker pour effectuer le pattern command
     */
    public Interprete(final Invoker ina) {
        this.in = ina;
    }

    /**
     * annule une commande au nom de name.
     * @param name nom de la commande à annuler
     */
    public void undo(final String name) {
            Command a = in.get(name);
            a.undo();

    }

    /**
     * Quitte lapplication.
     */
    public void exit() {
        System.out.println("exit");
        System.exit(0);
    }
}
