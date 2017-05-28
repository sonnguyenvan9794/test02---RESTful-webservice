package model.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Model {

	final static Logger logger = Logger.getLogger(Model.class);
	
	/**
	 * Lưu đối tượng(class) vào cơ sở dữ liệu
	 * @param obj đối tượng tham chiếu bảng cơ sở dữ liệu
	 * @return
	 * @throws Exception
	 */
	public static Serializable save(Object obj)  {
		Serializable serializable = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			serializable = session.save(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
			}
			tx.rollback();
			logger.error("Lỗi save đối tượng: " + e.getMessage());
			e.printStackTrace();
		} finally {
			//session.flush();
			session.close();
		}
		return serializable;
	}

	/**
	 * get content any table
	 * 
	 * @param objectEntity đối tượng
	 * @return ArrayList >= 1 phần tử nếu k lỗi, null nếu có lỗi
	 */
	public static ArrayList<Object> getList(String objectEntity) {
		ArrayList<Object> list = new ArrayList<Object>();
		//Tạo 1 phần tử để phân biệt 
		// - getList lỗi: return null
		// - list trống:  return 1 phần tử
		list.add(new Object());
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			List tmpList = session.createQuery("FROM " + objectEntity).list();
			for (Iterator iterator = tmpList.iterator(); iterator.hasNext();) {
				Object tmp = (Object) iterator.next();
				list.add(tmp);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
			}
			tx.rollback();
			logger.error("Lỗi lấy danh sách đối tượng");
			return null;
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * Xóa theo id
	 * @param obj
	 * @throws Exception
	 */
	public static boolean delete(Object obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(obj);
			
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (tx != null) {
			}
			tx.rollback();

			logger.error("Lỗi delete đối tượng");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	
	/**
	 * Xóa theo Id theo class và id
	 * @param type class
	 * @param id
	 * @return
	 */
	private boolean deleteById(Class<?> type, Serializable id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
		    Object persistentInstance = session.load(type, id);
		    if (persistentInstance != null) {
		        session.delete(persistentInstance);
		        return true;
		    }
	    } catch (Exception e) {
			if (tx != null) {
			}
			tx.rollback();

			logger.error("Lỗi delete đối tượng");
			return false;
		} 
	    return false;
	}
	
	/**
	 * Cập nhật đối tượng
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static boolean update(Object obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
			}
			logger.error("Lỗi update đối tượng csdl");
			tx.rollback();
			return false;
		} finally {
			//session.flush();
			session.close();
		}
		return true;
	}
	
	/**
	 * Load Object by Id
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Object getById(Class<?> type, Serializable id) {
		Object object = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			object = session.get( type, id);
		} catch (Exception e) {
			logger.error("Lỗi getById đối tượng");
		} finally {
			session.close();
		}
		return object;
	}
	
}
