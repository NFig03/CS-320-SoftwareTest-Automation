package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest 
{
	@Test  //verifies that contacts can be added to the contact service
	void testContactAddition()
	{
		new ContactService();
		ContactService.addContact("1","Noah","Figueroa","8716987631","723 Apple Field Dr.");
		assertTrue(ContactService.contacts.containsKey("1"));
		
		//verifies exception thrown when attempting to add contact with existing ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			ContactService.addContact("1","Noah","Figueroa","8716987631","723 Apple Field Dr.");
		}
		);
	}
	
	@Test  //verifies that contacts can be deleted from the contact service via contact ID
	void testContactDeletion()
	{
		new ContactService();
		ContactService.addContact("1","Noah","Figueroa","8716987631","723 Apple Field Dr.");
		assertTrue(ContactService.contacts.containsKey("1"));
		ContactService.deleteContact("1");
		assertTrue(ContactService.contacts.containsKey("1") == false);
		
		//verifies exception thrown when attempting to delete contact which does not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			ContactService.deleteContact("1");
		}
		);
	}
	
	@Test  //verifies that all contact fields can be updated per contact ID
	void testContactUpdates()
	{
		new ContactService();
		ContactService.addContact("1","Noah","Figueroa","8716987631","723 Apple Field Dr.");
		
		//verifies update of first name field works
		ContactService.updateFirstName("1", "Isaih");
		assertTrue(ContactService.contacts.get("1").getFirstName() == "Isaih");
		
		//verifies exception thrown when attempting to update name for contact which does not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{
			ContactService.updateFirstName("2", "Isaih");
		}
		);
		
		//verifies update of last name field works
		ContactService.updateLastName("1", "Nava");
		assertTrue(ContactService.contacts.get("1").getLastName() == "Nava");
		
		//verifies update of phone number field works
		ContactService.updateNumber("1", "8714469528");
		assertTrue(ContactService.contacts.get("1").getNumber() == "8714469528");
		
		//verifies update of address field works
		ContactService.updateAddress("1", "696 Rockwood Dr.");
		assertTrue(ContactService.contacts.get("1").getAddress() == "696 Rockwood Dr.");
	}
}
