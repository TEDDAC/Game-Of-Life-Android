package fr.iut63.projetandroidribemontmaulus.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.iut63.projetandroidribemontmaulus.R;
import modele.Dieu;
import modele.Notifiable;
import modele.Rules;
import modele.Stub;

public class PageSetting extends AppCompatActivity implements Notifiable {
    private HashMap<String, Rules> rulesPresets= new HashMap<String, Rules>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pagesetting);

        this.rulesPresets = Stub.configRules();

        instantiateFragment(savedInstanceState);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rulesPresets);
        radioGroup.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            String choice = getResources().getResourceName(checkedId).split("/")[1];
            Log.d("Settings","RadioGroup Changed: new checked is " + choice);
            Dieu.getDieu().setRules(this.rulesPresets.get(choice));
        });

        Dieu.getDieu().addOnRuleChangeListener(this);

        Button saverButton = findViewById(R.id.SaverButton);
        saverButton.setOnClickListener(view -> {
            SaverDialogFragment saverDialog = new SaverDialogFragment();
            saverDialog.show(getSupportFragmentManager(),"SaverDialogFragment");
        });

        Button loaderButton = findViewById(R.id.loadButton);
        loaderButton.setOnClickListener(view -> {
            LoaderDialogFragment loaderDialog = new LoaderDialogFragment();
            loaderDialog.show(getSupportFragmentManager(),"LoaderDialogFragment");
        });
    }

    private void instantiateFragment(@Nullable Bundle savedInstanceState) {
        if(savedInstanceState == null){
            Log.d("PageSetting","Debug > Création fragment");

            //argument pour fragmentBornRules
            Bundle bundleBorn = new Bundle();
            bundleBorn.putString("text_to_show",getResources().getText(R.string.howManyNeighboorToBorn).toString());
            bundleBorn.putBooleanArray("arrayToBind",Dieu.getDieu().getRules().getBornRules());

            //argument pour fragmentSurvivesRules
            Bundle bundleSurvive = new Bundle();
            bundleSurvive.putString("text_to_show",getResources().getText(R.string.howManyNeighboorToSurvive).toString());
            bundleSurvive.putBooleanArray("arrayToBind",Dieu.getDieu().getRules().getSurviveRules());

            this.getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentBornRules, FragmentRules.class, bundleBorn)
                    .replace(R.id.fragmentSurvivesRules, FragmentRules.class, bundleSurvive)
                    .commit();
        }
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

    @Override
    public void notifier() {
        instantiateFragment(null);
    }
}
