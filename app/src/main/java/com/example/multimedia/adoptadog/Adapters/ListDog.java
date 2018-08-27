package com.example.multimedia.adoptadog.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multimedia.adoptadog.DataDog.Dog;
import com.example.multimedia.adoptadog.R;

import java.util.List;

public class ListDog extends RecyclerView.Adapter<ListDog.ListDogHolder> implements View.OnClickListener{

    private List<Dog> listDog;
    private Context context;

    private View.OnClickListener listener;

    public ListDog(List<Dog> listDog, Context context) {
        this.listDog = listDog;
        this.context = context;
    }

    @NonNull
    @Override
    public ListDogHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(context).inflate(R.layout.item_list_dog, viewGroup, false);

        //Colocamos la vista en escucha de un evento
        vista.setOnClickListener(this);

        return new ListDogHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListDogHolder holder, int i) {
        holder.imageView.setImageResource(listDog.get(i).getImagen());
        holder.viewName.setText(listDog.get(i).getNombre());
        holder.viewAge.setText(String.valueOf(listDog.get(i).getEdad()));
        holder.viewBreed.setText(listDog.get(i).getRaza());
        holder.viewGender.setText(listDog.get(i).getGenero());
    }

    @Override
    public int getItemCount() {
        return listDog.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onClick(view);
        }
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public class ListDogHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView viewName, viewAge, viewBreed, viewGender;

        public ListDogHolder(@NonNull View itemView) {
            super(itemView);

            //Creamos las referencias
            imageView = (ImageView) itemView.findViewById(R.id.image_list_dog);
            viewName = (TextView) itemView.findViewById(R.id.name_list_dog);
            viewAge = (TextView) itemView.findViewById(R.id.age_list_dog);
            viewBreed = (TextView) itemView.findViewById(R.id.breed_list_dog);
            viewGender = (TextView) itemView.findViewById(R.id.gender_list_dog);
        }
    }
}
