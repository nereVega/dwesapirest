package birt.dwes.apirest.service;

import java.util.List;

import birt.dwes.apirest.entity.Articulo;

public interface IArticuloService {
	public List<Articulo> selectAll();
	public Articulo selectById(int id);
	public void save(Articulo articulo);
	public void delete(int id);

}
