package birt.dwes.apirest.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import birt.dwes.apirest.entity.Articulo;

@Repository
public class ArticuloDAO implements IArticuloDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Articulo> selectAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Articulo> selectAll = currentSession.createQuery("FROM Articulo", Articulo.class);
		List<Articulo> articulos= selectAll.getResultList();
		return articulos;
	}

	@Override
	@Transactional
	public Articulo selectById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Articulo articulo = currentSession.get(Articulo.class, id);
		return articulo;
	}

	@Override
	@Transactional
	public void save(Articulo articulo) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(articulo);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Articulo> delete = currentSession.createQuery("DELETE FROM Articulo WHERE idarticulo=?1");
		
		delete.setParameter(1, id);
		delete.executeUpdate();

	}

}
