package fr.iut63.projetandroidribemontmaulus.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import fr.iut63.projetandroidribemontmaulus.R;

public class MotifsAdapter extends RecyclerView.Adapter<FileViewHolder> {

    List<String> mesMotifs;

    MotifsAdapter(List<String> mesMotifs){
        this.mesMotifs = mesMotifs;
    }

    @Override
    public FileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.motif_items, parent, false);
        return new FileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {
        holder.display(mesMotifs.get(position));

    }


    @Override
    public int getItemCount() {
        return mesMotifs.size();
    }
}
