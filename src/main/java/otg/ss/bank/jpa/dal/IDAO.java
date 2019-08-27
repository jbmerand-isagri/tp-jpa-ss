package otg.ss.bank.jpa.dal;

import java.util.List;

public interface IDAO<T, ID> {
	public T findById(ID id);

	public List<T> findAll();

	public void save(T entity);
}
