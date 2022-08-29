package vn.trung;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import vn.trung.model.Address;
import vn.trung.model.Cource;
import vn.trung.model.Fresher;
import vn.trung.model.Group;
import vn.trung.model.Syllabus;

public class Managment {
	
	private static SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
	
	public static void main(String[] args) {

//		createCourceSyllabuses();
//		getCourceSyllabuses(1);

//		createFresherAndAddress();

//		createFresherAndCource();
		
//		createFresherAndGroup();
		
		createGroup();
//		getGroup(1);
		
		
//		updateGroupUsingHQL();
//		deleteGroupUsingHQL(1);
		queryGroupUsingHql();		 
		
//		queryUsingCriterial();
//		useNameQuery();
		sessionFactory.close();
		
		
		
	}
	
	
	private static void useNameQuery() {
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query q = session.createNamedQuery("groupByname");
			q.setParameter("name", "java%");
			List<Group> groups =session.createNamedQuery("groupByname").getResultList();
			
			System.out.println(groups.size());
//			groups.forEach(n->System.out.println(n.getName()));
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	
	
	private static void queryUsingCriterial() {
		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			
			CriteriaBuilder cBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Group> createQuery = cBuilder.createQuery(Group.class);
			Root<Group> root = createQuery.from(Group.class);
			
			
			createQuery.select(root);
			
			Query<Group> q = session.createQuery(createQuery);
			
			List<Group> list = q.getResultList();
			
			list.forEach(n->System.out.println(n));
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	private static void deleteGroupUsingHQL(int id) {
		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String queryStr = "delete from Group  where id = :id ";
			Query query = session.createQuery(queryStr);
			query.setParameter("id",id);
			int result=query.executeUpdate();
			System.out.println(result);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	private static void updateGroupUsingHQL() {
		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String queryStr = "update Group  set name = :name where id = :id ";
			Query query = session.createQuery(queryStr);
			query.setParameter("id",1);
			query.setParameter("name","SqlServer" );
			int result=query.executeUpdate();
			System.out.println(result);
			session.getTransaction().commit();

			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	private static void queryGroupUsingHql() {
		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String queryStr = "From Group";
//			String queryStr = "From Group where id =?1 and name like ?2";
//			String queryStr = "From Group where id = :id and name like :name"; //nên dùng cách này hơn cách trên
//			String queryStr = "SELECT name From Group where id = :id and name like :name";//Select 1 attribute
			
//			String queryStr = "SELECT name From Group where id = :id ";
			Query query = session.createQuery(queryStr);
//			query.setParameter("id",1);
//			query.setParameter("name","java%" );
			
			List<Group> groups =(List<Group>) query.list();
			System.out.println(groups);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			session.close();
		}
	}
	
	private static void getGroup(int id) {
		try {

			
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			Group group = session.get(Group.class, id);
			System.out.println(group.getName());
//			group.setName("New Java Group");
//			session.update(group);
			session.delete(group);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static void createGroup() {
		try {

		
			Session session = sessionFactory.openSession();
			Group group1 = new Group("java group");
			Group group2 = new Group("javascript group");
			session.beginTransaction();
			session.save(group1);
			session.save(group2);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void createFresherAndGroup() {

		Set<Group> groups = new HashSet<>();
		Group group1 = new Group("group1");
		Group group2 = new Group("group2");
		groups.add(group1);
		groups.add(group2);
		
		Set<Fresher> freshers = new HashSet<>();
		Fresher fresher1 = new Fresher("fresher1");
		Fresher fresher2 = new Fresher("fresher2");
		fresher1.setGroups(groups);
		fresher2.setGroups(groups);
		freshers.add(fresher1);
		freshers.add(fresher2);
		
		group1.setFreshers(freshers);
		group2.setFreshers(freshers);
			
		try {

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			for (Fresher fresher : freshers) {
				session.save(fresher);
			}
			for (Group group : groups) {
				session.save(group);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
	

	public static void createFresherAndCource() {

		List<Cource> cources = new ArrayList<>();
		cources.add(new Cource("Java"));
		cources.add(new Cource("Learn Hibernaate"));
		Fresher fresher = new Fresher("trung", cources);
		try {

		
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			for (Cource cource : cources) {
				session.save(cource);
			}

			session.save(fresher);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void createFresherAndAddress() {

		Address address = new Address("Vinh", "VietNam");
		Fresher fresher = new Fresher("trung", address);
		try {

		
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(address);
			session.save(fresher);

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void getCourceSyllabuses(int id) {
		try {

	
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Cource cource = session.get(Cource.class, id);
			System.out.println(cource.getName());
			System.out.println(cource.getSyllabuss());

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	
	private static void createCourceSyllabuses() {
		List<Syllabus> syllabuses = new ArrayList<>();
		syllabuses.add(new Syllabus("Hibernate Online", 10));
		syllabuses.add(new Syllabus("Hibernate Ofline", 200));

		Cource cource = new Cource("Learn Hibernate", new Date(), syllabuses);

		try {

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(cource);
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
