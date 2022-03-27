package fr.iut63.projetandroidribemontmaulus.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.File;

import fr.iut63.projetandroidribemontmaulus.R;
import modele.Dieu;
import modele.Saver;

public class SaverDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        EditText field = new EditText(getContext());
        field.setId(R.id.text_field);
        field.setHint(R.string.Filename);
        builder.setMessage(R.string.Save);
        builder.setView(field);
        builder.setPositiveButton(R.string.Save, (dialogInterface, i) -> {
            String filename = ((EditText) this.getDialog().findViewById(R.id.text_field)).getText().toString();
//            Log.d("SaverDialogFragment",filename);
            if(!filename.endsWith(".cgl")){
                filename = filename+".cgl";
            }

            File file = new File(getContext().getFilesDir(),filename);
            Saver saver = new Saver();
            saver.save(Dieu.getDieu().getMonde(),file);

            Log.d("SaverDialogFragment", "Motif sauvegardé");
        });
        builder.setNegativeButton(R.string.Cancel, (dialogInterface, i) -> Log.d("SaverDialogFragment","Sauvegarde annulée"));

        return builder.create();
    }
}
