package fr.iut63.projetandroidribemontmaulus.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.projetandroidribemontmaulus.R;

public class PageSetting extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ------------------
        setContentView(R.layout.pagesetting);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LogAppVie","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LogAppVie","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LogAppVie","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LogAppVie","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LogAppVie","onDestroy");
    }

    public void clickBack(View view) {
        Intent monIntent = new Intent(this, FenetreDeJeu.class);
        startActivity(monIntent);
    }

    public int recupNbVoisinNaissance(View view){
        boolean checked = ((CheckBox) view).isChecked();
        int nbVoisin = 0;
        switch (view.getId()){
            case R.id.checkBox_1_Voisin_Naitre:
                if (checked){
                    nbVoisin = 1;
                }
            case R.id.checkBox_2_Voisin_Naitre:
                if (checked){
                    nbVoisin = 2;
                }

            case R.id.checkBox_3_Voisin_Naitre:
                if (checked){
                    nbVoisin = 3;
                }

            case R.id.checkBox_4_Voisin_Naitre:
                if (checked){
                    nbVoisin = 4;
                }

            case R.id.checkBox_5_Voisin_Naitre:
                if (checked){
                    nbVoisin = 5;
                }

            case R.id.checkBox_6_Voisin_Naitre:
                if (checked){
                    nbVoisin = 6;
                }

            case R.id.checkBox_7_Voisin_Naitre:
                if (checked){
                    nbVoisin = 7;
                }

            case R.id.checkBox_8_Voisin_Naitre:
                if (checked){
                    nbVoisin = 8;
                }
        }
        return nbVoisin;

    }



    /*
    public void onCheckboxClicked(View view) {
    // Is the view now checked?
    boolean checked = ((CheckBox) view).isChecked();

    // Check which checkbox was clicked
    switch(view.getId()) {
        case R.id.checkbox_meat:
            if (checked)
                // Put some meat on the sandwich
            else
                // Remove the meat
            break;
        case R.id.checkbox_cheese:
            if (checked)
                // Cheese me
            else
                // I'm lactose intolerant
            break;
        // TODO: Veggie sandwich
}



     */
}
