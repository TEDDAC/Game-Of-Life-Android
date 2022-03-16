package fr.iut63.projetandroidribemontmaulus.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.iut63.projetandroidribemontmaulus.R;
import modele.Dieu;

public class PageSetting extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ------------------
        setContentView(R.layout.pagesetting);


        //il faudra mettre

        LinearLayout bornRuleLayout = (LinearLayout) findViewById(R.id.bornRuleLayout);
        for (int i = 0; i < 9; i++) {
            View v = bornRuleLayout.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox)v).setChecked(Dieu.getDieu().getRules().getBornRules()[i]);
                ((CheckBox) v).setOnCheckedChangeListener((compoundButton, b) -> {
                    String id = compoundButton.getResources().getResourceName(compoundButton.getId()).split("/")[1];
                    Log.d("PageSetting","OnCreate: type rule: "+id);
                    Integer num = Integer.parseInt(id.split("_")[1]);
                    Dieu.getDieu().getRules().getBornRules()[num] = b;
                });
            }
        }

        LinearLayout surviveRuleLayout = (LinearLayout) findViewById(R.id.surviveRuleLayout);
        for (int i = 0; i < 9; i++) {
            View v = surviveRuleLayout.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox)v).setChecked(Dieu.getDieu().getRules().getSurviveRules()[i]);
                ((CheckBox) v).setOnCheckedChangeListener((compoundButton, b) -> {
                    String id = compoundButton.getResources().getResourceName(compoundButton.getId()).split("/")[1];
                    Log.d("PageSetting","OnCreate: type rule: "+id);
                    Integer num = Integer.parseInt(id.split("_")[1]);
                    Dieu.getDieu().getRules().getSurviveRules()[num] = b;
                });
            }
        }


        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rulesPresets);
        radioGroup.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            Log.d("Settings","RadioGroup Changed: new checked is " + getResources().getResourceName(checkedId));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LogAppVie","onStart");

        // Récuération des regles Born à partir du modele

        LinearLayout bornRuleLayout = (LinearLayout) findViewById(R.id.bornRuleLayout);
        boolean[] bornRules;
        bornRules = Dieu.getDieu().getRules().getBornRules();

        for(int i = 0; i < 9;i++)
        {
            View v = bornRuleLayout.getChildAt(i);
            if(bornRules[i])
            {
                ((CheckBox) v).setChecked(true);
            }
        }

        // Récuération des regles Born à partir du modele

        LinearLayout surviveRuleLayout = (LinearLayout) findViewById(R.id.surviveRuleLayout);
        boolean[] surviveRules;
        surviveRules = Dieu.getDieu().getRules().getSurviveRules();

        for(int i = 0; i < 9;i++)
        {
            View w = surviveRuleLayout.getChildAt(i);
            if(surviveRules[i])
            {
                ((CheckBox) w).setChecked(true);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LogAppVie","onResume");

        // ------------------------------------
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    public void clickBack(View view) {
        this.finish();
    }
}
