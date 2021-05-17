# Projet Calculatrice Reverse Polish avec Pattern Command

Pour integrer le Pattern Command nous avons suivi l'exemple du cours avec une interface Command qui permet de creer des instances de commandes stockable.

Nous y avons mis trois methodes : execute() qui permet de lancer la commande dite, undo() qui permet d'annuler la commandes courante, et modify() qui gèrent la modification et l'utilisation de paramètre dans les commandes du pattern.

Dans ce projet spécifique seul un paramètre peut être changé soit le stockage d'un chiffre pour la commande d'ajout d'un nombre, soit le stockage d'une opérande pour l'application d'une opération sur la calculette.

En respectant le pattern (Invoker.java), nous enregistrons les commands dans la liste des commands  et nous stockons chaque command avec leur paramètre courant de l'action effectué dans une autre pile désigné comme l'historique. Pour procéder à l'annulation d'une commande il nous suffit d'effectuer l'opération undo() ainsi que dépiler la dernière commande de l'historique.

# Architecture

Les opérations de la calculatrice sont gérés par les Classes Interepreteur et MoteurRPN directement dérivé de celle-ci.Interpreteur contient les methodes undo et exit, Moteur RPN contient les methodes regOP qui ajoute un nombre dans la mémoire de la calculette (pile), apOP qui effectue une opération donnée en entrée sur la calculette (vérifie la possibilité de l'opération), retOP qui affiche le contenant de la calculette, ainsi que regOPUndo,et apOPUndo qui effectue le retour en arrière pour les commandes regOP et apOP (dérivé de undo directement).

SaisieRPN permet de récuperer la saisie utilisateur ainsi que de traiter cette dernière en appliquant le pattern command, via l'invoker qui invoque les commandes.

L'interface command est dérivé en apOP,regOP,retOP,Exit, apOP est dérivé selon les 4 opérations de base, Plus,Minus,Times, Divide

CalculatriceRPN permet de lancer la calculette ainsi que d'enregistrer les commandes du pattern de celle ci

# Détails technique

Afin de prendre en compte les paramètres des méthodes apOP et regOP il nous as fallu ajouter une méthode modify(string) qui permet de changer le paramètre d'une des commandes (apOP/regOP) ce qui permet d'enregistrer dans l'historique la commande saisie de manière précise. Grâce à cela on est capable d'effectuer undo seulement en lisant la dernière commande et en appliquant l'annulation selon le type de command (identifié à l'aide de getClass()). Le undo se fait de manière efficace en temps effectif

