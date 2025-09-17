package contactService;

import java.util.HashMap;

public class ContactService 
{	
	//Hash Map to store contacts, efficient addition, deletion, and lookup functionality
	public static HashMap<String, Contact> contacts;
	
	//constructor
	public ContactService()
	{
		contacts = new HashMap<>();
	}
	
	//method to add contact to contact service
	public static void addContact(String id, String first, String last, String phone, String addy)
	{
		//throws exception if ID is not unique, otherwise adds contact to service
		if (contacts.containsKey(id))
		{
			throw new IllegalArgumentException("Contact with this ID already exists.");
		}
		else
		{
			Contact contact = new Contact(id, first, last, phone, addy);
			contacts.put(id, contact);
		}
	}
	
	//method to delete contact from service
	public static void deleteContact(String id)
	{
		
		//if ID is in service, deletes it; otherwise exception is thrown
		if (contacts.containsKey(id))
		{
			contacts.remove(id);
		}
		else
		{
			throw new IllegalArgumentException("Contact with this ID does not exist.");
		}
	}
	
	//method to update contact first name
	public static void updateFirstName(String id, String first)
	{
		
		//if exists, updates, otherwise throws exception
		if (contacts.containsKey(id))
		{
			
			//creates temporary contact to be able to update accordingly
			Contact toBeUpdated;
			toBeUpdated = contacts.get(id);
			toBeUpdated.updateFirstName(first);
		}
		else
		{
			throw new IllegalArgumentException("Contact with this ID does not exist.");
		}
	}
	
	public static void updateLastName(String id, String last)
	{
		
		//if exists, updates, otherwise throws exception
		if (contacts.containsKey(id))
		{
			
			//creates temporary contact to be able to update accordingly
			Contact toBeUpdated;
			toBeUpdated = contacts.get(id);
			toBeUpdated.updateLastName(last);
		}
		else
		{
			throw new IllegalArgumentException("Contact with this ID does not exist.");
		}
	}
	
	public static void updateNumber(String id, String phone)
	{
		
		//if exists, updates, otherwise throws exception
		if (contacts.containsKey(id))
		{
			
			//creates temporary contact to be able to update accordingly
			Contact toBeUpdated;
			toBeUpdated = contacts.get(id);
			toBeUpdated.updateNumber(phone);
		}
		else
		{
			throw new IllegalArgumentException("Contact with this ID does not exist.");
		}
	}
	
	public static void updateAddress(String id, String addy)
	{
		
		//if exists, updates, otherwise throws exception
		if (contacts.containsKey(id))
		{
			
			//creates temporary contact to be able to update accordingly
			Contact toBeUpdated;
			toBeUpdated = contacts.get(id);
			toBeUpdated.updateAddress(addy);
		}
		else
		{
			throw new IllegalArgumentException("Contact with this ID does not exist.");
		}
	}
}

