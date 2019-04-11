package com.fikri.gnoovel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    private Context mCtx;
    private List<Model> modelList;


    public ModelAdapter(Context mCtx, List<Model> modelList) {
        this.mCtx = mCtx;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        ModelViewHolder holder = new ModelViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {

        Model model = modelList.get(position);

        holder.textViewTitle.setText(model.getTitle());
        holder.textViewDesc.setText(model.getShortdesc());
        holder.textViewRating.setText(String.valueOf(model.getRating()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(model.getImage()));

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class ModelViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewRating;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);

        }
    }
}
