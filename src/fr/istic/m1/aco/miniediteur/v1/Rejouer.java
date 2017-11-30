/**
 * @file Rejouer.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 */

package fr.istic.m1.aco.miniediteur.v1;

/**
 * @brief Classe contrôlant le fonctionnement de la fonctionnalité permettant de rejouer la macro enregistrée
 * @details Fonctionnalité introduite dans la spécification de la version 2 du Mini-Éditeur. N'est pas elle même enregistrable conformément à la spécification pour éviter un empilement d'enregistrements qui résulterait en un écrasement des précédents.
 */
public class Rejouer implements Commande {

    private Enregistreur recorder;

	/**
     * @brief Implémentation permettant d'effectuer l'action exécutant la macro et ses actions enregistrées
     * @details Fait appel à l'implémentation de l'exécution des macros. Est donc "implementation-dependent" de l'Enregistreur.
     */
    @Override
    public void execute() {
        recorder.rejouer();
    }
}
