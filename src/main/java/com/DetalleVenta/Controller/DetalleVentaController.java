package com.DetalleVenta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DetalleVenta.DTO.DetalleVentaDTO;
import com.DetalleVenta.Model.DetalleVenta;
import com.DetalleVenta.Service.DetalleVentaService;

@RestController
@RequestMapping("/api/detalleventa")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService service;

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaDTO> getById(@PathVariable Integer id) {
        DetalleVentaDTO dto = service.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> create(@RequestBody DetalleVenta detalle) {
        DetalleVenta detalleGuardado = service.save(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleGuardado);
    }
}
