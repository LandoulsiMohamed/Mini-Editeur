/**
 * @file Editeur.java
 * @author Dorian "Aexelion" DUMANGET
 * @author Corentin "Heartbroken-Git" CHÉDOTAL
 * @copyright LPRAB 1.0
 * @version 2.0
 */

package fr.istic.m1.aco.miniediteur.v2;

/**
 * @brief Classe principale représentant l'éditeur et appelant toutes les pièces nécessaires à son fonctionnement
 */
public class Editeur {
	private IHM gui;
	private Moteur engine;
	private Enregistreur recorder; //V2

	//Commandes V1
	private Coller coller;
	private Copier copier;
	private Couper couper;
	private Selectionner selectionner;
	private Inserer inserer;

	//Commandes V2
	private Demarrer demarrer;
	private Stopper stopper;
	private Rejouer rejouer;

	/**
	 * @brief Constructeur chargeant une IHM, un Moteur dans l'Editeur et l'Enregistreur utilisé pour les macros et lancant le chargement des Commandes disponible dans l'Editeur
	 * @param i l'IHM à charger dans l'Editeur
	 * @param m le Moteur à charger dans l'Editeur
	 * @param e l'Enregistreur à charger dans l'Editeur
	 */
	public Editeur (IHM i, Moteur m, Enregistreur e) {

		this.gui = i;
		this.engine = m;
		this.recorder = e;

		this.createV1();
		this.createV2();
	}

	/**
	 * @brief Fonction créant et affectant les Commandes de la version 1 à l'IHM
	 * @details Donne les commandes Copier, Coller, Couper, Selectionner et Inserer telles que les spécifications de la version 1 demandent
	 */
	private void createV1(){
		this.coller = new Coller(engine, recorder);
		this.copier = new Copier(engine, recorder);
		this.couper = new Couper(engine, recorder);
		this.selectionner = new Selectionner(engine, gui, recorder);
		this.inserer = new Inserer(engine, gui, recorder);

		gui.addCmd("Coller",		this.coller);
		gui.addCmd("Copier",		this.copier);
		gui.addCmd("Couper",		this.couper);
		gui.addCmd("Selectionner",	this.selectionner);
		gui.addCmd("Inserer",		this.inserer);
	}

	/**
	 * @brief Fonction créant et affectant les Commandes de la version 2 à l'IHM
	 * @details Donne les commandes Demarrer, Stopper et Rejouer permettant de créer et rejouer une macro telles que les spécifications de la version 2 demandent
	 */
	private void createV2(){
		this.demarrer = new Demarrer(recorder);
		this.stopper = new Stopper(recorder);
		this.rejouer = new Rejouer(recorder);

		gui.addCmd("Demarrer",		this.demarrer);
		gui.addCmd("Stopper",		this.stopper);
		gui.addCmd("Rejouer",		this.rejouer);
	}

	/**
	 * @brief Fonction principale du Mini-Editeur
	 */
	public static void main(String[] args){

		ImplMoteur engine = new ImplMoteur();
		Affiche affiche = new Affiche(engine);
		ImplIHMText gui = new ImplIHMText(affiche);
		ImplEnregistreur recorder = new ImplEnregistreur();

		Editeur editeur = new Editeur(gui, engine, recorder);

		gui.execution();
	}
}


