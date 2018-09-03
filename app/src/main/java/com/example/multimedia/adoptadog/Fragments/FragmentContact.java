package com.example.multimedia.adoptadog.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.multimedia.adoptadog.ActivityPrincipal;
import com.example.multimedia.adoptadog.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentContact.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentContact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentContact extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText name, lastName, message;
    private Button btnSend;
    private Spinner spinner;
    private ActivityPrincipal activityPrincipal;
    private Toolbar toolbar;

    private OnFragmentInteractionListener mListener;

    public FragmentContact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentContact.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContact newInstance(String param1, String param2) {
        FragmentContact fragment = new FragmentContact();
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
        View vista = inflater.inflate(R.layout.fragment_fragment_contact, container, false);

        //Validamos si activityPrincipal no es null
        if (activityPrincipal != null){
            //Cambiamos el titulo del Toolbar
            activityPrincipal.toolbar.setTitle("Contacto");
        }

        //Creo las referencias
        name = (EditText) vista.findViewById(R.id.txt_name);
        lastName = (EditText) vista.findViewById(R.id.txt_last_name);
        message = (EditText) vista.findViewById(R.id.txt_message);
        btnSend = (Button) vista.findViewById(R.id.btn_send_contact);
        spinner = (Spinner) vista.findViewById(R.id.spinner);

        String[] dataSpinner = new String[]{"Adoptar", "Apadrinar"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, dataSpinner);
        spinner.setAdapter(adapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        return vista;
    }

    private void sendEmail() {
        String nametxt = name.getText().toString();
        String lastNametxt = lastName.getText().toString();
        String body = message.getText().toString();
        if (!nametxt.isEmpty() && !lastNametxt.isEmpty() && !body.isEmpty()){
            //Creo el mensaje
            String messagetxt = "Nombre: " + nametxt + "\n" +
                    "Apellido: " + lastNametxt + "\n" + body;
            //Creo el Intent
            Intent intent = new Intent(Intent.ACTION_SEND);
            //Especifico el tipo
            intent.setType("txt/plain");
            //Especificamos el correo al cual se enviara
            //pruebafundacion@gmail.com
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"fhjuanias@misena.edu.co"});
            //Especificamos el asunto del correo
            intent.putExtra(Intent.EXTRA_SUBJECT, spinner.getSelectedItem().toString());
            //Especificamos el mensaje del Email
            intent.putExtra(Intent.EXTRA_TEXT, messagetxt);
            //Iniciamos el envio
            startActivity(intent);
            //startActivity(Intent.createChooser(intent, "Send contact"));

            //Limpiamos los campos
            name.setText("");
            lastName.setText("");
            message.setText("");
        }else {
            Toast.makeText(getContext(), "Campos obligatorios.", Toast.LENGTH_SHORT).show();
        }
        
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
        if (context instanceof ActivityPrincipal){
            activityPrincipal = (ActivityPrincipal) context;
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
