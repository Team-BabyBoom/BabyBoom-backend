package com.babyboom.serviciesimplement;
import com.babyboom.entities.Servicio;
import com.babyboom.repositories.IServicioRepository;
import com.babyboom.services.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ServicioServiceImplement implements IServicioService {
    @Autowired
    private IServicioRepository sR;
    @Override
    public void insert(Servicio servicio) {
        sR.save(servicio);
    }
    @Override
    public List<Servicio> list() {
        return sR.findAll();
    }
    @Override
    public void delete(int idServicio) {
        sR.findById(idServicio);
    }
    @Override
    public Servicio listId(int idServicio) {
        return sR.findById(idServicio).orElse(new Servicio());
    }
}
