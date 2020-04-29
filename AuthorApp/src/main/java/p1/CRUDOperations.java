package p1;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class CRUDOperations {
	
	public void insertEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        System.out.println("-------------Insert Operation------------");
        Author author = new Author();
        author.setAuthorId(11);
        author.setFirstName("Akshat");
        author.setMiddleName("Kumar");
        author.setLastName("Saxena");
        author.setPhoneNo("9717663773");
        System.out.println("id :: " + author.getAuthorId());
        System.out.println("First Name :: " + author.getFirstName());
        System.out.println("Middle Name :: " + author.getMiddleName());
        System.out.println("Last Name :: " + author.getLastName());
        System.out.println("Phone Number :: " + author.getPhoneNo());
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }

    public void findEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("-------------Read Operation------------");
        Author author = entityManager.find(Author.class, 11);
        System.out.println("id :: " + author.getAuthorId());
        System.out.println("First Name :: " + author.getFirstName());
        System.out.println("Middle Name :: " + author.getMiddleName());
        System.out.println("Last Name :: " + author.getLastName());
        System.out.println("Phone Number :: " + author.getPhoneNo());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("-------------Before Updation Operation------------");
        Author author = entityManager.find(Author.class, 11);
        System.out.println("First Name :: " + author.getFirstName());
        System.out.println("Last Name :: " + author.getLastName());
        //The entity object is physically updated in the database when the transaction
        // is committed
        author.setFirstName("Anamika");
        author.setLastName("Chaudhary");
        System.out.println("-------------After Updation Operation------------");
        System.out.println("First Name :: " + author.getFirstName());
        System.out.println("Last Name :: " + author.getLastName());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, 11);
        System.out.println("-------------Delete Operation------------");
        System.out.println("id :: " + author.getAuthorId());
        entityManager.remove(author);
        System.out.println("Successfully Delete");
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    
    List<Author> findAllAuthors(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Author"); 
        List<Author> authors=query.getResultList();
        return authors;
    }

}
