package com.DetalleVenta.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DetalleVenta.DTO.DetalleVentaDTO;
import com.DetalleVenta.Model.DetalleVenta;
import com.DetalleVenta.Repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository repository;

    public DetalleVentaDTO findById(Integer idDetalle) {
        DetalleVenta detalle = repository.findById(idDetalle).orElse(null);
        return toDTO(detalle);
    }

    public DetalleVentaDTO save(DetalleVenta detalle) {
        DetalleVenta saved = repository.save(detalle);
        return toDTO(saved);
    }

    private DetalleVentaDTO toDTO(DetalleVenta detalle) {
        if (detalle == null) return null;

        return new DetalleVentaDTO(
            detalle.getIdDetalle(),
            detalle.getIdVenta(),
            detalle.getIdProducto(),
            detalle.getCantidad(),
            detalle.getPrecioUnitario(),
            "http://localhost:8089/api/detalleventa/" + detalle.getIdDetalle()
        );
    }
}
