package contactService;

import java.util.HashMap;
import java.util.*;

public class ContactService 
{	
	// General Hash Map to store contacts with all information
	public static HashMap<String, Contact> contacts;

	// Hash Map of first names with corresponding IDs to keep first name lookup efficient
	public static HashMap<String, Set<String>> firstNameContacts;

	public static HashMap<String, Contact> lastNameContacts;
	public static HashMap<String, Contact> phoneContacts;
	public static HashMap<String, Contact> addressContacts;
	
	//constructor
	public ContactService()
	{
		contacts = new HashMap<>();
		firstNameContacts = new HashMap<>();

		lastNameContacts = new HashMap<>();
		phoneContacts = new HashMap<>();
		addressContacts = new HashMap<>();
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

			// if there is no set corresponding to the name, create a set and add the id, otherwise add id
			firstNameContacts.computeIfAbsent(first, k-> new HashSet<>()).add(id);
		}
	}
	
	//method to delete contact from service
	public static void deleteContact(String id)
	{
		
		//if ID is in service, deletes it; otherwise exception is thrown
		if (contacts.containsKey(id))
		{
			Contact contact = contacts.get(id);
			String firstName = contact.getFirstName();
			
			contacts.remove(id);

			// Derive a set of IDs associated to this name and remove the exact id
			Set<String> ids = firstNameContacts.get(firstName);
			ids.remove(id);
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

			//Save the set associated with the original first name
			//If the set is not null, remove the id from that first name
			//If the set is empty, remove the key value pair completely
			Set<String> oldSet = firstNameContacts.get(toBeUpdated.getFirstName());
			if (oldSet != null)
			{
				oldSet.remove(id);
			}
			if (oldSet.isEmpty())
			{
				firstNameContacts.remove(toBeUpdated.getFirstName());
			}

			toBeUpdated.updateFirstName(first);

			//Add the ID back into firstNameContacts
			firstNameContacts.computeIfAbsent(first, k -> new HashSet<>()).add(id);
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

	// Method to query a contact by first name using a secondary index
	// Find the queried first name in first name index, and return the associated contact IDs as a set
	public static Set<String> queryFirstName(String first)
	{
		if (firstNameContacts.containsKey(first))
		{
			return firstNameContacts.get(first);
		}
		else
		{
			return null;
		}
	}

}

