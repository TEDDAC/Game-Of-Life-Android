package fr.iut63.projetandroidribemontmaulus.view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import fr.iut63.projetandroidribemontmaulus.R;

public class FileViewHolder extends RecyclerView.ViewHolder {
    private TextView mfileName;

    FileViewHolder(View itemView){
        super(itemView);

        mfileName = (TextView)itemView.findViewById(R.id.name);
    }

    void display(String fileName){
        mfileName.setText(fileName);
    }
}
