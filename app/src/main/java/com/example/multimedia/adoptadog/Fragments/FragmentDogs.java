package com.example.multimedia.adoptadog.Fragments;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.multimedia.adoptadog.Adapters.ListDog;
import com.example.multimedia.adoptadog.DataBase.DataHelper;
import com.example.multimedia.adoptadog.DataBase.Utilidades;
import com.example.multimedia.adoptadog.DataDog.Dog;
import com.example.multimedia.adoptadog.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentDogs.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentDogs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDogs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerDogs;
    private List<Dog> listDog;
    private Context context;
    private SQLiteDatabase objDb;

    private OnFragmentInteractionListener mListener;

    public FragmentDogs() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDogs.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDogs newInstance(String param1, String param2) {
        FragmentDogs fragment = new FragmentDogs();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_fragment_dogs, container, false);

        objDb = connectDb();

        //Creo la referencia para el Recycler
        recyclerDogs = (RecyclerView) vista.findViewById(R.id.recycler_dogs);
        //Configuro la forma de mostrar el Recycler
        recyclerDogs.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        listDog = new ArrayList<>();

        //Llenamos la lista
        llenaLista();

        //Instanciamos al adaptador
        ListDog objAdapter = new ListDog(listDog, context);
        //Creamos el evento para la lista
        objAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = listDog.get(recyclerDogs.getChildAdapterPosition(v)).getId();
                Toast.makeText(context, "ID: " + id, Toast.LENGTH_SHORT).show();
            }
        });
        //Asignamos el adaptador al recycler
        recyclerDogs.setAdapter(objAdapter);

        return vista;
    }

    public void llenaLista(){
        //Creamos la consulta
        Cursor objCursor = objDb.rawQuery("SELECT * FROM " + Utilidades.TBL_PERRO, null);
        //Si se obtienen registros
        if (objCursor.moveToFirst()){
            do {
                listDog.add(new Dog(objCursor.getInt(0), objCursor.getInt(1),
                        objCursor.getString(2), objCursor.getInt(3),
                        objCursor.getString(4), objCursor.getString(5)));
            }while (objCursor.moveToNext());
        }
        //Cerramos el cursor
        objCursor.close();
        //Cerramos la coneccion
        objDb.close();
    }

    public SQLiteDatabase connectDb(){
        DataHelper objHelper = new DataHelper(context, "Dogs", null, 1);
        return objHelper.getWritableDatabase();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            this.context = context;
        }

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
