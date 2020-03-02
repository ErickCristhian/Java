package daojpa;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
 
 
public abstract class DAO<T> implements DAOInterface<T>  {

	protected static EntityManagerFactory factory;
    protected static EntityManager manager;
 
    public static void open() {
    	if (manager == null) {
    		factory = Persistence.createEntityManagerFactory("emprestimo-livro");
    		manager = factory.createEntityManager();
    	}
    }
    public static void close() {
    	if(manager != null) {
    		manager.close();
    		factory.close();
    	}
    }
    public void create(T t) {
    	manager.persist(t);
    };
    public abstract T read(Object chave) throws Exception ;
    
    @SuppressWarnings("unchecked")
    public List<T> readAll() {
    	Class<T> type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
    			.getActualTypeArguments()[0];
    	Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
    	return (List<T>) query.getResultList();
    };
    
    public T update(T t) {
    	return manager.merge(t);
    };
    
    public void delete(T t) {
    	manager.remove(t);
    };
    
 
    public static void begin(){
    	if(!manager.getTransaction().isActive())
    			manager.getTransaction().begin(); 
    }
   
    public static void commit(){
    	if(manager.getTransaction().isActive()) {
    		manager.getTransaction().commit();
    		manager.clear();
    	}
    }
 
    public static void rollback(){
    	if(manager.getTransaction().isActive())
    		manager.getTransaction().rollback();
    	}
}