package fr.iut63.projetandroidribemontmaulus.view;

import android.util.Log;

public class PrimeThread implements Runnable{
    long minPrime;
    PrimeThread(long minPrime){
        this.minPrime = minPrime;
    }

    public void run(){
        Log.d("Thread","Test du thread");
        while (true){
            Log.d("Thread","Test du thread");
        }
    }
}
