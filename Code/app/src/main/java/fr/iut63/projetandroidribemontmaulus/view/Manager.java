package fr.iut63.projetandroidribemontmaulus.view;

public class Manager {
    Thread thread;


    public Manager() {
        //PrimeThread primeThread = new PrimeThread(5000);
        //thread = new Thread(primeThread);

    }

    public void launchThread(){
        this.thread.start();
    }

    public void stopThread(){
        this.thread.stop();
    }
}
