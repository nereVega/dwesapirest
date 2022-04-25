package birt.dwes.apirest.DAO;

import java.util.List;

import birt.dwes.apirest.entity.Articulo;

public interface IArticuloDAO {
	public List<Articulo> selectAll();
	public Articulo selectById(int id);
	public void save(Articulo articulo);
	public void delete(int id);
}
