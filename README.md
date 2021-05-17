# Architecture

Les opérations de la calculatrice sont gérées par les Classes Interepreteur et MoteurRPN directement dérivée de celle-ci.Interpreteur contient les methodes undo et exit, Moteur RPN contient les methodes regOP qui ajoute un nombre dans la mémoire de la calculette (pile), apOP qui effectue une opération donnée en entrée sur la calculette (vérifie la possibilité de l'opération), retOP qui affiche le contenant de la calculette, ainsi que regOPUndo,et apOPUndo qui effectue le retour en arrière pour les commandes regOP et apOP (dérivé de undo directement).

SaisieRPN permet de récuperer la saisie utilisateur ainsi que de traiter cette dernière en appliquant le pattern command, via l'invoker qui invoque les commandes.

L'interface command est dérivé en apOP,regOP,retOP,Exit, apOP est dérivé selon les 4 opérations de base, Plus,Minus,Times, Divide

CalculatriceRPN permet de lancer la calculette ainsi que d'enregistrer les commandes du pattern de celle ci
