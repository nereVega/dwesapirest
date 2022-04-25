package birt.dwes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import birt.dwes.apirest.entity.Articulo;
import birt.dwes.apirest.service.IArticuloService;

@RestController
@RequestMapping("/api")
public class ArticuloController {
	
	@Autowired
	private IArticuloService articuloService;
	
	@GetMapping("/articulos")
	public List<Articulo> selectAll(){
		return articuloService.selectAll();
	}
	
	@GetMapping("/articulo/{id}")
	public Articulo selectById(@PathVariable int id) {
		Articulo articulo = articuloService.selectById(id);
		if (articulo == null) {
			throw new RuntimeException("No se encuentra el artículo con id " + id);
		}
		return articulo;
	}
	
	@PostMapping("/articulos")
	public Articulo newArticulo(@RequestBody Articulo articulo) {
		if(articulo == null) {
			throw new RuntimeException("Error. Revise los datos");
		}
		
		articuloService.save(articulo);
		return articulo;
	}
	
	//TODO 
	@PutMapping("/articulo")
	public String updateArticulo(@RequestBody Articulo nuevosDatos) {
		articuloService.save(nuevosDatos);
		
		return "Modificado artículo con id " + nuevosDatos.getIdarticulo();
	}
	
	@DeleteMapping("/articulo/{id}")
	public String deleteArticulo(@PathVariable int id) {
		Articulo articulo = articuloService.selectById(id);
		
		if (articulo == null) {
			return "No se encuentra ningún artículo con id " + id;
		}
		
		articuloService.delete(id);
		return "Se ha eliminado el artículo con id " + id;
	}
}
