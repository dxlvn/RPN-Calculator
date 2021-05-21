# Architecture

Les opérations de la calculatrice sont gérées par les Classes Interpréteur et MoteurRPN directement dérivées de celle-ci.Interpreteur contient les methodes undo et exit, Moteur RPN contient les methodes regOP qui ajoutent un nombre dans la mémoire de la calculette (pile), apOP qui effectue une opération donnée en entrée sur la calculette (vérifie la possibilité de l'opération), retOP qui affiche le contenant de la calculette, ainsi que regOPUndo et apOPUndo qui effectuent le retour en arrière pour les commandes regOP et apOP ( directement dérivées de undo).

SaisieRPN permet de récuperer la saisie utilisateur ainsi que de traiter cette dernière en appliquant le pattern command, via l'invoker qui invoque les commandes.

L'interface command est dérivé en apOP, regOP, retOP, Exit, apOP est dérivé selon les 4 opérations de base, Plus, Minus, Times, Divide

CalculatriceRPN permet de lancer la calculette ainsi que d'enregistrer les commandes du pattern.
