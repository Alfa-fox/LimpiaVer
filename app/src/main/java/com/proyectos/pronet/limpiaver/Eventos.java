package com.proyectos.pronet.limpiaver;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

public class Eventos extends Fragment {

    private OnFragmentInteractionListener mListener;

    View vista;
    Button btndato;
    EditText dato, campocoment;
    Spinner spnasunto,spnmotvs;

    public Eventos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_eventos, container, false);

        spnasunto = vista.findViewById(R.id.spnasunto);
        ArrayList<String> listaAsuntos = new ArrayList<>();
        listaAsuntos.add("Junta Vecinal");
        listaAsuntos.add("Limpia Ciudadana");
        listaAsuntos.add("Limpia Vecinal");
        listaAsuntos.add("Vigilancia Vecinal");
        listaAsuntos.add("Marcha");
        listaAsuntos.add("Día de reciclaje");
        listaAsuntos.add("Ayuda comunitaria");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, listaAsuntos);
        spnasunto.setAdapter(adapter);

        spnmotvs = vista.findViewById(R.id.spnmotvs);
        ArrayList<String> listaMotvs = new ArrayList<>();
        listaMotvs.add("Caso 1");
        listaMotvs.add("Caso 2");
        listaMotvs.add("Caso 3");
        listaMotvs.add("Caso 4");
        listaMotvs.add("Caso 5");

        ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, listaMotvs);
        spnmotvs.setAdapter(adapter1);

        dato = vista.findViewById(R.id.txttexto);
        campocoment = vista.findViewById(R.id.campocoment);
        btndato = vista.findViewById(R.id.buttonmostrar);
        btndato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dato.setText(null);
                campocoment.setText(null);
                Toast.makeText(getContext(),"Solicitud confirmada", Toast.LENGTH_SHORT).show();
                btndato.setEnabled(false);
            }
        });


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
