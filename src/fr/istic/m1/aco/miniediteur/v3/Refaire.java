package fr.istic.m1.aco.miniediteur.v3;

/**
 * Created by 16009566 on 20/10/17.
 */
public class Refaire implements Commande {

    private GestionnaireDefaireRefaire gest;

    public Refaire(GestionnaireDefaireRefaire gest){
        this.gest = gest;
    }

    @Override
    public void execute() {
        gest.refaire();
    }
}