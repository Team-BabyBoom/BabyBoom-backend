package com.babyboom.repositories;

import com.babyboom.entities.Tipocomprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipocomprobanteRepository extends JpaRepository<Tipocomprobante,Integer> {

}