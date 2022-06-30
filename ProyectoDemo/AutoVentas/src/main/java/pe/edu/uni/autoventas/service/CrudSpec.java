package pe.edu.uni.autoventas.service;

import java.util.List;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware
 * @cursos gcoronelc.github.io
 */
public interface CrudSpec<T> {

	List<T> readAll();
	
	T readForId(int id);
	
	List<T> read(T bean);
	
	void insert(T bean);
	
	void update(T bean);
	
	void delete(int id);
	
}
