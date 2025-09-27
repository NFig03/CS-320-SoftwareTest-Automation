package contactService;

import java.util.HashMap;
import java.util.*;

public class ContactService 
{	
	// General Hash Map to store contacts with all information
	public static HashMap<String, Contact> contacts;

	// Hash Map of first names with corresponding IDs to keep first name lookup efficient
	public static HashMap<String, Set<String>> firstNameContacts;

	// Hash Map of last names with corresponding IDs to keep last name lookup efficient
	public static HashMap<String, Set<String>> lastNameContacts;

	// Hash Map of phone numbers with corresponding IDs to keep phone number lookup efficient
	public static HashMap<String, Set<String>> phoneContacts;

	// Hash Map of addresses with corresponding IDs to keep address lookup efficient
	public static HashMap<String, Set<String>> addressContacts;
	
	//constructor
	public ContactService()
	{
		// Initialize all indices
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

			// if there is no set corresponding to the last name, create a set and add the id, otherwise add id
			lastNameContacts.computeIfAbsent(last, k-> new HashSet<>()).add(id);

			// if there is no set corresponding to the phone number, create a set and add the id, otherwise add id
			phoneContacts.computeIfAbsent(phone, k-> new HashSet<>()).add(id);

			// if there is no set corresponding to the address, create a set and add the id, otherwise add id
			addressContacts.computeIfAbsent(addy, k-> new HashSet<>()).add(id);
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
			String lastName = contact.getLastName();
			String phoneNumber = contact.getNumber();
			String address = contact.getAddress();
			
			contacts.remove(id);

			// Derive a set of IDs associated to this name and remove the exact id from the set
			Set<String> ids = firstNameContacts.get(firstName);
			ids.remove(id);

			// Derive a set of IDs associated to this last name and remove that exact id from the set
			ids = lastNameContacts.get(lastName);
			ids.remove(id);

			// Retrieve the ID associated to the phone number and remove it from the set
			ids = phoneContacts.get(phoneNumber);
			ids.remove(id);

			// Retrieve a set of IDs associated with the address and remove the exact id from the set
			ids = addressContacts.get(address);
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

			// Derive a set of IDs associated with the provided last name
			Set<String> oldSet = lastNameContacts.get(toBeUpdated.getLastName());
			
			// If set is not null, remove the id, if set is empty then remove the key value pair entirely
			if (oldSet != null)
			{
				oldSet.remove(id);
			}
			if (oldSet.isEmpty())
			{
				lastNameContacts.remove(toBeUpdated.getFirstName());
			}

			toBeUpdated.updateLastName(last);

			// Insert last name and ID as key value pair, create a new set if one doesn't exist with last name
			lastNameContacts.computeIfAbsent(last, k -> new HashSet<>()).add(id);
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

			// Derive a set of IDs associated with the provided phone number
			Set<String> oldSet = phoneContacts.get(toBeUpdated.getNumber());
			
			// If set is not null, remove the id, if set is empty then remove the key value pair entirely
			if (oldSet != null)
			{
				oldSet.remove(id);
			}
			if (oldSet.isEmpty())
			{
				phoneContacts.remove(toBeUpdated.getNumber());
			}

			toBeUpdated.updateNumber(phone);

			// Insert phone number and ID as key value pair, create a new set if one doesn't exist with that phone number
			phoneContacts.computeIfAbsent(phone, k -> new HashSet<>()).add(id);
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

			// Derive a set of IDs associated with the provided address
			Set<String> oldSet = addressContacts.get(toBeUpdated.getAddress());
			
			// If set is not null, remove the id, if set is empty then remove the key value pair entirely
			if (oldSet != null)
			{
				oldSet.remove(id);
			}
			if (oldSet.isEmpty())
			{
				addressContacts.remove(toBeUpdated.getAddress());
			}

			toBeUpdated.updateAddress(addy);

			// Insert address and ID as key value pair, create a new set if one doesn't exist with that address
			addressContacts.computeIfAbsent(addy, k -> new HashSet<>()).add(id);
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

	// Method to query a contact by last name using a secondary index
	// Find the last name in the index of last names and return the associated set of IDs
	public static Set<String> queryLastName(String last)
	{
		if (lastNameContacts.containsKey(last))
		{
			return lastNameContacts.get(last);
		}
		else
		{
			return null;
		}
	}

	// Method to query a contact by phone number using a secondary index
	// Find the phone number in the index of phone numbers and return the associated set of IDs
	public static Set<String> queryPhoneNumber(String number)
	{
		if (phoneContacts.containsKey(number))
		{
			return phoneContacts.get(number);
		}
		else
		{
			return null;
		}
	}

	// Method to query a contact by address using a secondary index
	// Find the address in the index of addresses and return the associated set of IDs
	public static Set<String> queryAddress(String address)
	{
		if (addressContacts.containsKey(address))
		{
			return addressContacts.get(address);
		}
		else
		{
			return null;
		}
	}
}

