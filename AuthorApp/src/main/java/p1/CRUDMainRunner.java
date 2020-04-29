package p1;

import java.util.List;

public class CRUDMainRunner {

	public static void main(String[] args) {
			
			CRUDOperations crudOperations = new CRUDOperations();
			crudOperations.insertEntity();
			crudOperations.findEntity();
			crudOperations.updateEntity();
			crudOperations.removeEntity();
			System.out.println("----------Author Records-----------");
			List<Author> authors= crudOperations.findAllAuthors();
			print(authors);
			
	}
	
	static void print(List<Author> authors)
    {
        for (Author author:authors){
        	System.out.println("Author id= "+author.getAuthorId());
	        System.out.println("Author First Name= "+author.getFirstName());
	        System.out.println("Author Middle Name= "+author.getMiddleName());
	        System.out.println("Author Last Name= "+author.getLastName());
	        System.out.println("Author PhoneNo= "+author.getPhoneNo()); 
        }
    }
}
