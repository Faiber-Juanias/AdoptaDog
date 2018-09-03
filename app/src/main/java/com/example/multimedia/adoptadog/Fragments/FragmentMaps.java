package com.example.multimedia.adoptadog.Fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.multimedia.adoptadog.ActivityPrincipal;
import com.example.multimedia.adoptadog.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentMaps.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentMaps#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMaps extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GoogleMap mMap;
    private MapView mapView;
    private Context context;
    private ActivityPrincipal activityPrincipal;

    private OnFragmentInteractionListener mListener;

    public FragmentMaps() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMaps.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMaps newInstance(String param1, String param2) {
        FragmentMaps fragment = new FragmentMaps();
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
        View vista = inflater.inflate(R.layout.fragment_fragment_maps, container, false);

        //Validamos que activityPrincipal no sea null
        if (activityPrincipal != null){
            activityPrincipal.toolbar.setTitle("Locaciones");
        }

        mapView = (MapView) vista.findViewById(R.id.maps_dogs);

        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }

        return vista;
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
            this.activityPrincipal = (ActivityPrincipal) context;
        }

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

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
            return;
        }
        mMap.setMyLocationEnabled(true);

        LatLng direcUno = new LatLng(4.6766188, -74.0500105);
        mMap.addMarker(new MarkerOptions().position(direcUno).title("Carrera 13 entre 93A y 93B"));

        LatLng direcDos = new LatLng(4.6734333,-74.0979161);
        mMap.addMarker(new MarkerOptions().position(direcDos).title("Avenida Calle 63, Chapinero Central"));

        LatLng direcTres = new LatLng(4.6586762,-74.0961491);
        mMap.addMarker(new MarkerOptions().position(direcTres).title("Parque Simón Bolívar Bogotá"));

        LatLng direcCua = new LatLng(4.6294952,-74.0922158);
        mMap.addMarker(new MarkerOptions().position(direcCua).title("Carrera. 37 #24-67-Corferias"));

        LatLng direcCin = new LatLng(4.6019769,-74.0742204);
        mMap.addMarker(new MarkerOptions().position(direcCin).title("Carrera. 6 #15-88- Museo del Oro"));

        LatLng direcSeis = new LatLng(4.5955316,-74.0797092);
        mMap.addMarker(new MarkerOptions().position(direcSeis).title("Casa de Nariño-Bogotá"));

        LatLng direcSiet = new LatLng(4.6533059,-74.1120549);
        mMap.addMarker(new MarkerOptions().position(direcSiet).title("Centro Comercial Salitre Plaza"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(direcSiet, 11));

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
