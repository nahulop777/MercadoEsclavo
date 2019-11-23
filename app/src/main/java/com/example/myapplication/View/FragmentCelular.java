package com.example.myapplication.View;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Controller.DatosController;
import com.example.myapplication.Model.Celular;
import com.example.myapplication.Model.CelularContainer;
import com.example.myapplication.R;
import com.example.myapplication.Utils.ResultListener;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCelular extends Fragment implements AdapterCelular.IrAlProducto {


    public FragmentCelular() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_celular, container, false);

        RecyclerView celularRecyclerView = view.findViewById(R.id.celRecycler);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        celularRecyclerView.setLayoutManager(linearLayout);
        final AdapterCelular adapterCelular = new AdapterCelular((AdapterCelular.IrAlProducto) this, new ArrayList<Celular>());
        celularRecyclerView.setAdapter(adapterCelular);


        DatosController datosController = new DatosController();
        datosController.getCelu(new ResultListener<CelularContainer>() {
            @Override
            public void finish(CelularContainer celularContainer) {
                List<Celular> data = celularContainer.getResults();
                adapterCelular.actualizarLista(data);
            }
        });

        return view;
    }

    @Override
    public void seleccionaronEsteProducto(Celular celular) {

    }
}

