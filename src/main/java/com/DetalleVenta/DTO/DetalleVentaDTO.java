package com.DetalleVenta.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {
    private Integer idDetalle;
    private Integer idVenta;
    private Integer idProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private String link;
}
