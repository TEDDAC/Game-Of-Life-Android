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

    public boolean[] recupNbVoisinNaissance(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        boolean[] rulesVoisin = new boolean[9];
        switch (view.getId()) {
            case R.id.checkBox_0_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[0] = true;
                }
            case R.id.checkBox_1_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[1] = true;
                }
            case R.id.checkBox_2_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[2] = true;
                }

            case R.id.checkBox_3_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[3] = true;
                }

            case R.id.checkBox_4_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[4] = true;
                }

            case R.id.checkBox_5_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[5] = true;
                }

            case R.id.checkBox_6_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[6] = true;
                }

            case R.id.checkBox_7_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[7] = true;
                }

            case R.id.checkBox_8_Voisin_Naitre:
                if (checked) {
                    rulesVoisin[8] = true;
                }
        }
        return rulesVoisin;
    }

    public boolean[] recupNbVoisinMort(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        boolean[] rulesMort = new boolean[9];
        switch (view.getId()) {
            case R.id.checkBox_1_Voisin_Survie:
                if (checked) {
                    rulesMort[1] = true;
                }

            case R.id.checkBox_2_Voisin_Survie:
                if (checked) {
                    rulesMort[2] = true;
                }

            case R.id.checkBox_3_Voisin_Survie:
                if (checked) {
                    rulesMort[3] = true;
                }

            case R.id.checkBox_4_Voisin_Survie:
                if (checked) {
                    rulesMort[4] = true;
                }

            case R.id.checkBox_5_Voisin_Survie:
                if (checked) {
                    rulesMort[5] = true;
                }

            case R.id.checkBox_6_Voisin_Survie:
                if (checked) {
                    rulesMort[6] = true;
                }

            case R.id.checkBox_7_Voisin_Survie:
                if (checked) {
                    rulesMort[7] = true;
                }
            case R.id.checkBox_8_Voisin_Survie:
                if (checked) {
                    rulesMort[8] = true;
                }
        }
        return rulesMort;
    }


}
