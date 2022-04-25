package birt.dwes.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birt.dwes.apirest.DAO.IArticuloDAO;
import birt.dwes.apirest.entity.Articulo;

@Service
public class ArticuloService implements IArticuloService {
	
	@Autowired
	private IArticuloDAO articuloDAO;
	
	@Override
	public List<Articulo> selectAll() {
		List<Articulo> articulos = articuloDAO.selectAll();
		return articulos;
	}

	@Override
	public Articulo selectById(int id) {
		Articulo articulo = articuloDAO.selectById(id);
		return articulo;
	}

	@Override
	public void save(Articulo articulo) {
		articuloDAO.save(articulo);
	}

	@Override
	public void delete(int id) {
		articuloDAO.delete(id);
	}

}
