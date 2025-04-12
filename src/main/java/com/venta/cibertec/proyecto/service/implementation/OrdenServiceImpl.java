package com.venta.cibertec.proyecto.service.implementation;

import com.venta.cibertec.proyecto.data.repository.OrdenRepository;
import com.venta.cibertec.proyecto.data.repository.ProductoRepository;
import com.venta.cibertec.proyecto.presentation.dto.OrdenDTO;
import com.venta.cibertec.proyecto.service.interfaces.OrdenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {

    private  final OrdenRepository ordenRepository;
    private  final ModelMapper modelMapper;

    @Autowired
    public OrdenServiceImpl(OrdenRepository ordenRepository, ModelMapper modelMapper) {
        this.ordenRepository = ordenRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrdenDTO> getAll() {
        return List.of();
    }

    @Override
    public OrdenDTO createOrden() {
        return null;
    }

    @Override
    public String delete(int id) {
        return "";
    }
}
