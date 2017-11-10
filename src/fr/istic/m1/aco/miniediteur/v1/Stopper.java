package fr.istic.m1.aco.miniediteur.v1;

/**
 * Created by 16009566 on 13/10/17.
 */
public class Stopper implements Commande {

    private Enregistreur recorder;

    public Stopper(Enregistreur recorder){
        this.recorder = recorder;
    }

    @Override
    public void execute() {
        recorder.stopper();
    }
}
