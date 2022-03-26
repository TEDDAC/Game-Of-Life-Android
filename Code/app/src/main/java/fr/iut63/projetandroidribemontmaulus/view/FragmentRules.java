package fr.iut63.projetandroidribemontmaulus.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fr.iut63.projetandroidribemontmaulus.R;

public class FragmentRules extends Fragment {
    public FragmentRules(){
        super(R.layout.fragment_rules);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView text = (TextView)getView().findViewById(R.id.textTitle);
        text.setText(requireArguments().getString("text_to_show"));


        LinearLayout ruleLayout = (LinearLayout)getView().findViewById(R.id.RuleLayout);
        for (int i = 0; i < 9; i++) {
            View v = ruleLayout.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox)v).setChecked(requireArguments().getBooleanArray("arrayToBind")[i]);
                ((CheckBox) v).setOnCheckedChangeListener((compoundButton, b) -> {
                    String id = compoundButton.getResources().getResourceName(compoundButton.getId()).split("/")[1];
                    Log.d("PageSetting","OnCreate: type rule: "+id);
                    Integer num = Integer.parseInt(id.split("_")[1]);
                    requireArguments().getBooleanArray("arrayToBind")[num] = b;
                });
            }
        }
    }
}
