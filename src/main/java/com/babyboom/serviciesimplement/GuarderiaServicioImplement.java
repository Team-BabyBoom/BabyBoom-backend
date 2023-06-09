package com.babyboom.serviciesimplement;

import com.babyboom.entities.GuarderiaServicio;
import com.babyboom.repositories.IControlVacunacionRepository;
import com.babyboom.repositories.IGuarderiaServicioRepository;
import com.babyboom.servicies.IGuarderiaServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuarderiaServicioImplement implements IGuarderiaServicioService {
    @Autowired
    private IGuarderiaServicioRepository iGSr;
    @Override
    public void insert(GuarderiaServicio guarderiaServicio) {
        iGSr.save(guarderiaServicio);
    }
    @Override
    public List<GuarderiaServicio> list() {
        return iGSr.findAll();
    }
}