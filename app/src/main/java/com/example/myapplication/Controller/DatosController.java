package com.example.myapplication.Controller;

import com.example.myapplication.DAO.Dao;
import com.example.myapplication.Model.CelularContainer;
import com.example.myapplication.Utils.ResultListener;

public class DatosController {

    private Dao dao;


    public DatosController() {
        this.dao = new Dao();
    }

    public void getCelu (final ResultListener<CelularContainer>escuchadorDeLaVista){
        dao.getCelular(new ResultListener<CelularContainer>() {
            @Override
            public void finish(CelularContainer celularContainer) {
                escuchadorDeLaVista.finish(celularContainer);
            }
        });
    }
}
