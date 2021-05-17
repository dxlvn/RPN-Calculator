package fr.uvsq.poo.RPN;

import java.util.Scanner;

/**
 * Lecture des données saisie utilisateur
 * .
 */
public class SaisieRPN {
    /**
     * Calculette.
     */
    private MoteurRPN rpn;
    /**
     * entrer user.
     */
    private Scanner scan = new Scanner(System.in);
    /**
     * invoqueur commande.
     */
    private Invoker in;

    /**
     * Constructeur.
     * @param ina invoker des commandes
     * @param rpna moteur de la calculatrice
     */
    public SaisieRPN(final Invoker ina, final MoteurRPN rpna) {
        this.rpn = rpna;
        this.in = ina;
    }

    /**
     * vérifie si une saisie est un nombre.
     * @param str saisie quelconque
     * @return vrai si nombre faux sinon
     */
    public static boolean isNumeric(final String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * lecture des saisie utilisateur.
     * @return vrai si termine correctement faux sinon
     */
    public boolean read() {

        String str = new String(" ");
        while (!str.equals("")) {
                str = scan.nextLine();
                if (str.equals("+") || str.equals("-")
                        || str.equals("*") || str.equals("/")) {
                    if (str.equals("+")) {
                        in.execute("Plus");

                    } else if (str.equals("-")) {
                        in.execute("Minus");
                    } else if (str.equals("*")) {
                        in.execute("Times");
                    } else if (str.equals("/")) {
                        in.execute("Divide");
                    }
                } else if (SaisieRPN.isNumeric(str)) {
                    in.modify("regOP", str, in.get("regOP"));
                    in.execute("regOP");

                } else {
                    if (str.equals("undo")) {
                        in.execute("undo");
                    } else if (str.equals("exit")) {
                        in.execute("retOP");
                        in.execute("exit");

                    } else if (str.equals("print")) {

                        in.execute("retOP");

                    } else {
                        System.out.println("Not a number nor operator");
                    }
           }
                str.replace(str, " ");
       }
       return true;

    }


}
