package otg.ss.bank.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAO<T, ID> implements IDAO<T, ID> {
	private Class<T> tClass;
	private static EntityManagerFactory emf;

	public DAO(Class<T> tClass) {
		this.tClass = tClass;
	}

	@Override
	public T findById(ID id) {
		initFactory();
		T result = null;
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			result = (T) em.find(tClass, id);
			em.close();
		}
		closeFactory();
		return result;
	}

	@Override
	public List<T> findAll() {
		initFactory();
		List<T> resultList = null;
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("from " + tClass.getSimpleName());
			resultList = (List<T>) query.getResultList();
		}
		closeFactory();
		return resultList;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub

	}

	private static void initFactory() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("tp-jpa-ss");
		}
	}

	private static void closeFactory() {
		if (emf != null) {
			emf.close();
		}
	}

}
