package fr.uvsq.poo.RPN;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



/**
 * Classe dinvocation des commandes, permet la confidentialiter du code
 * .
 */
public class Invoker {
    /**
     * liste commande.
     */
    private HashMap<String, Command> commands = new HashMap<>();
    /**
     * Historique commande.
     */
    private List<Command> history = new ArrayList<>();

    /**
     * enregistrer une nouvelle commande.
     * @param msgCmd nom de la commande
     * @param cmd commande courante
     */
    public void register(final String msgCmd, final Command cmd) {
        commands.put(msgCmd, cmd);
    }


    /**
     * execute une commande donner.
     * @param msgCmd nom de commande
     */
    public void execute(final String msgCmd) {
        HashMap<String, Command> tempCmd =
                (HashMap<String, Command>) commands.clone();
        Command command = tempCmd.get(msgCmd);
        int undoCount = 0;

        if (msgCmd == "undo") {
            Command teste = this.history.get(history.size() - 1);
            remove();

            if (teste.getClass().getName().contains("RegOP")) {
                get("RegOP").undo();

            } else if (teste.getClass().getName().contains("Plus")
                    || teste.getClass().getName().contains("Minus")
                    || teste.getClass().getName().contains("Times")
                    || teste.getClass().getName().contains("Divide")) {
                teste.undo();
            }
        } else {

            if (command == null) {
                throw new IllegalStateException("no command registered"
                        + msgCmd);
            }
            command.execute();
            if (!command.getClass().getName().contains("RetOP")) {
                if (command.getClass().getName().contains("Plus")
                        || command.getClass().getName().contains("Minus")
                        || command.getClass().getName().contains("Times")
                        || command.getClass().getName().contains("Divide")) {

                    ApOP tmp = (ApOP) tempCmd.get(msgCmd);
                    ApOP tm = null;

                    try {
                        tm = (ApOP) ((ApOP) tempCmd.get(msgCmd)).clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    this.history.add(tm);
                } else {
                    RegOP tmp = (RegOP) tempCmd.get(msgCmd);
                    RegOP tm = null;

                    try {
                        tm = (RegOP) tmp.clone();

                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }

                    this.history.add(tm);
                }
            }
        }

    }

    /**
     * enleve une commande de l'historique.
     */
    public void remove() {

        this.history.remove(history.size() - 1);
    }

    /**
     * recupere une commande par son nom.
     * @param name nom de la commande
     * @return la commande
     */
    public Command get(final String name) {
        return this.commands.get(name);
    }

    /**
     * modifie les paramètres dune commande.
     * @param name nom e la commande
     * @param avr modification du parametre
     * @param cmd la commande
     */
    public void modify(final String name, final String avr, final Command cmd) {

        HashMap<String, Command> tempCmd =
                (HashMap<String, Command>) commands.clone();
        Command a = tempCmd.get(name);
        a.modify(avr);
        commands.remove(name);
        commands.put(name, a);
    }



}
