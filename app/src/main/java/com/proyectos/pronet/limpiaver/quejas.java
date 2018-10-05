package com.proyectos.pronet.limpiaver;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class quejas extends Fragment {

    private OnFragmentInteractionListener mListener;

    public quejas() {
        // Required empty public constructor
    }

    View vista;
    Spinner spnreport;
    Spinner spnsolicitud;
    Button btnenvi;
    EditText nomcamp, libtxtcom;
    int cont = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_quejas, container, false);

        spnreport = vista.findViewById(R.id.spnreport);
        ArrayList<String> listaReports = new ArrayList<>();
        listaReports.add("Basura esparcida");
        listaReports.add("Fuga de agua");
        listaReports.add("Aguas negras");
        listaReports.add("Aguas negras y basura");
        listaReports.add("Animales muertos");
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, listaReports);
        spnreport.setAdapter(adapter);

        spnsolicitud = vista.findViewById(R.id.spncolonia);
        ArrayList<String> listaSolicitud = new ArrayList<>();
        listaSolicitud.add("Reserva 1");
        listaSolicitud.add("Formando hogar");
        listaSolicitud.add("Rio medio");
        listaSolicitud.add("Amapolas");
        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, listaSolicitud);
        spnsolicitud.setAdapter(adapter2);

        nomcamp = vista.findViewById(R.id.nomtxt);
        libtxtcom = vista.findViewById(R.id.libtxtcom);
        btnenvi = vista.findViewById(R.id.quejabtn);
        btnenvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nomcamp.getText().equals("") && libtxtcom.getText().equals("")){
                    Toast.makeText(getContext(),"Inserte Texto en los campos", Toast.LENGTH_SHORT).show();
                }else{
                    nomcamp.setText(null);
                    libtxtcom.setText(null);
                    Toast.makeText(getContext(),"Queja enviada", Toast.LENGTH_SHORT).show();
                    cont = 1;
                    btnenvi.setEnabled(false);
                }

            }
        });


        return vista;

        //return inflater.inflate(R.layout.fragment_quejas, container, false);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
