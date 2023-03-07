package wrapper;
import java.util.List;

/**
 * CRUD method
 * @author pierre
 *
 * @param <T>
 */

public interface DAO<T> {

	
	/**
	 * Read 
	 */
	
	
	List<T> getAll(int id);
	
	
	T get(int id);
	
	
	/**
	 * Update
	 */
	
	void update(int id, T objectUpdated);
	
	/**
	 * Create
	 */
	
	void create(T newObject);
	
	/**
	 * Delete
	 */

	void delete(int id);
		
}
