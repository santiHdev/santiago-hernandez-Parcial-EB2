package com.elaparato.service;

import com.elaparato.exception.NotFoundException;
import com.elaparato.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();


    public void saveVenta(Venta vent) throws NotFoundException;


    //acá en la implementación se puede hacer por ejemplo borrado lógico
    public void deleteVenta(int id);


    public Venta findVenta(int id);

    public void editVenta(Venta vent) throws NotFoundException;

}
