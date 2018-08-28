package com.example.multimedia.adoptadog.Dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multimedia.adoptadog.DataBase.Utilidades;
import com.example.multimedia.adoptadog.Fragments.FragmentDogs;
import com.example.multimedia.adoptadog.R;

public class FullDialog extends DialogFragment{

    private Toolbar toolbar;
    private ImageView imageDog;
    private TextView nameDog, ageDog, breedDog, genderDog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("CutPasteId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.full_dialog, container, false);

        //Creamos las referencias
        toolbar = (Toolbar) vista.findViewById(R.id.toolbar_full_dialog);
        imageDog = (ImageView) vista.findViewById(R.id.image_full_dialog);
        nameDog = (TextView) vista.findViewById(R.id.name_full_dialog);
        ageDog = (TextView) vista.findViewById(R.id.age_full_dialog);
        breedDog = (TextView) vista.findViewById(R.id.breed_full_dialog);
        genderDog = (TextView) vista.findViewById(R.id.gender_full_dialog);

        //toolbardos.setVisibility(View.GONE);

        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        //actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel);

        setHasOptionsMenu(true);

        //Si recibimos los argumentos de FragmentDogs
        if (getArguments() != null){
            imageDog.setImageResource(getArguments().getInt(Utilidades.IMAGEN));
            nameDog.setText(getArguments().getString(Utilidades.NOMBRE));
            ageDog.setText(String.valueOf(getArguments().getInt(Utilidades.EDAD)));
            breedDog.setText(getArguments().getString(Utilidades.RAZA));
            genderDog.setText(getArguments().getString(Utilidades.GENERO));
        }

        return vista;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){


            FragmentDogs fragmentDogs = new FragmentDogs();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                    .replace(R.id.content_fragment, fragmentDogs)
                    .commit();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
