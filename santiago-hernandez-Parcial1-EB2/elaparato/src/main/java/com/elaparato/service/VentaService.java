package com.elaparato.service;

import com.elaparato.exception.NotFoundException;
import com.elaparato.model.Producto;
import com.elaparato.model.Venta;
import com.elaparato.repository.IProductoRepository;
import com.elaparato.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{



    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoRepository productoRepository;


    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public void saveVenta(Venta vent) throws NotFoundException {
        List<Producto> productos = new ArrayList<>();
        for (Producto producto : vent.getListaProductos()) {
            Producto productoVenta = productoRepository.findById(producto.getId()).orElseThrow(() -> new NotFoundException("producto no encontrado"));
            Producto productoNoEncontrado = productoVenta;
            productos.add(productoNoEncontrado);
        }

        vent.setListaProductos(productos);
        ventaRepo.save(vent);
    }

    @Override
    public void deleteVenta(int id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(int id) {
       return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Venta vent) throws NotFoundException {
        this.saveVenta(vent);
    }

    }
