package fr.iut63.projetandroidribemontmaulus.view;

import android.util.Log;

public class PrimeThread implements Runnable{
    long minPrime;
    public boolean running = true;

    PrimeThread(long minPrime){
        this.minPrime = minPrime;
    }

    public void run(){
        Log.d("Thread","Test du thread");
        while (running){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("Thread","3");
        }
    }
}
