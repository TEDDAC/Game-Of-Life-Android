package fr.iut63.projetandroidribemontmaulus.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.File;
import java.util.ArrayList;

import fr.iut63.projetandroidribemontmaulus.R;
import modele.Dieu;
import modele.Loader;
import modele.Saver;

public class LoaderDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        ArrayList<String> mesMotifs = new ArrayList<>();

        for(File fichier : getContext().getFilesDir().listFiles()){
//            Log.d("SaverDialogFragment","fichier > " + fichier.getName());
            mesMotifs.add(fichier.getName());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.Load);
        builder.setItems(mesMotifs.toArray(new String[0]), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String path = getContext().getFilesDir().getPath() + "/" + mesMotifs.get(i);
                Log.d("LoaderDialogFragment","Chemin > " + path);
                new Loader().load(Dieu.getDieu(),path);
            }
        });
        builder.setPositiveButton(R.string.Save, (dialogInterface, i) -> {
            Log.d("LoaderDialogFragment", "Motif chargé");
        });
        builder.setNegativeButton(R.string.Cancel, (dialogInterface, i) -> Log.d("LoaderDialogFragment","Chargement annulée"));

        return builder.create();
    }
}
