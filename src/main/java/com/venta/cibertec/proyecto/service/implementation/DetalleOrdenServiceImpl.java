package com.venta.cibertec.proyecto.service.implementation;

import com.venta.cibertec.proyecto.data.repository.DetalleOrdenRepository;
import com.venta.cibertec.proyecto.data.repository.OrdenRepository;
import com.venta.cibertec.proyecto.data.repository.ProductoRepository;
import com.venta.cibertec.proyecto.presentation.dto.DetalleOrdenDTO;
import com.venta.cibertec.proyecto.service.interfaces.DetalleOrdenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService {

    private final DetalleOrdenRepository detalleOrdenRepository;
    private  final ModelMapper modelMapper;

    @Autowired
    public DetalleOrdenServiceImpl(DetalleOrdenRepository detalleOrdenRepository, ModelMapper modelMapper) {
        this.detalleOrdenRepository = detalleOrdenRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DetalleOrdenDTO> getAllByOrden(int idOrden) {
        return List.of();
    }
}
