package contactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest 
{
	@Test  //verifies contact creation works as expected
	void testContactCreation()
	{
		new ContactService();
		Contact contact = new Contact("1","Noah","Figueroa","8716987631","723 Apple Field Dr.");
		
		//verifies that all fields are equivalent to their assigned values respectively
		assertTrue(contact.getContactId().equals("1"));
		assertFalse(contact.getContactId().equals(null));
		assertTrue(contact.getFirstName().equals("Noah"));
		assertFalse(contact.getFirstName().equals(null));
		assertTrue(contact.getLastName().equals("Figueroa"));
		assertFalse(contact.getLastName().equals(null));
		assertTrue(contact.getNumber().equals("8716987631"));
		assertFalse(contact.getNumber().equals(null));
		assertTrue(contact.getAddress().equals("723 Apple Field Dr."));
		assertFalse(contact.getAddress().equals(null));
	}
	
	@Test  //verifies contact ID constraints work as expected
	void testContactID()
	{
		new ContactService();
		Contact contact = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
		ContactService.contacts.put(contact.contactId, contact);
		
		//verifies only unique IDs can be created
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			assertTrue(ContactService.contacts.containsKey("123"));
			ContactService.addContact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
		}
		);
		
		//verifies ID can be no longer than ten characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			ContactService.addContact("123456789011","Noah","Figueroa","8716987631","723 Apple Field Dr.");
		}
		);
		
		//verifies ID cannot be null
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			ContactService.addContact(null,"Noah","Figueroa","8716987631","723 Apple Field Dr.");
		}
		);
	}
	
	@Test  //verifies first name constraints work as expected
	void testContactFirstName()
	{
		new ContactService();
		
		//verifies first name longer than ten characters throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			Contact tester = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
			tester.updateFirstName("NoahNoahNoah");
		}
		);
		
		//verifies first name null throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			Contact tester = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
			tester.updateFirstName(null);
		}
		);
	}
	
	@Test  //verifies last name constraints work as expected
	void testContactLastName()
	{
		new ContactService();
		
		//verifies last name longer than ten characters throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			Contact tester = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
			tester.updateLastName("FigueroaFigueroa");
		}
		);
		
		//verifies last name null throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			Contact tester = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
			tester.updateLastName(null);
		}
		);
	}
	
	@Test  //verifies phone number constraints work as expected 
	void testContactPhone()
	{
		new ContactService();
		
		//verifies exception is thrown when phone number not exactly ten characters long
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			Contact tester = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
			tester.updateNumber("87169876311");
		}
		);
		
		//verifies exception is thrown if phone number field is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			Contact tester = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
			tester.updateNumber(null);
		}
		);
	}
	
	@Test  //verifies address constraints work as expected
	void testContactAddress()
	{
		new ContactService();
		
		//verifies exception thrown if address is longer than 30 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			Contact tester = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
			tester.updateAddress("723 Apple Field Dr.723 Apple Field Dr.723 Apple Field Dr.");
		}
		);
		
		//verifies exception is thrown if address is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			Contact tester = new Contact("123","Noah","Figueroa","8716987631","723 Apple Field Dr.");
			tester.updateAddress(null);
		}
		);
	}
}
