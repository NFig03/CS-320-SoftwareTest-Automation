package contactService;

public class Contact 
{
	public final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// constructor
	public Contact(String id, String first, String last, String phone, String address)
	{
		updateFirstName(first);
		updateLastName(last);
		updateNumber(phone);
		updateAddress(address);
		if (id == null || id.length() > 10)
		{
			throw new IllegalArgumentException ("Please include a unique id which is no longer than ten characters.");
		}
		if (ContactService.contacts.containsKey(id))
		{
			throw new IllegalArgumentException("Contact with this ID already exists.");
		}
		this.contactId = id;
	}
	
	
	// setter methods
	public void updateFirstName(String first)
	{
		if (first == null || first.length() > 10)
		{
			throw new IllegalArgumentException ("Please include a first name which is no longer than ten characters.");
		}
		this.firstName = first;
	}
	
	public void updateLastName(String last)
	{
		if (last == null || last.length() > 10)
		{
			throw new IllegalArgumentException ("Please include a last name which is no longer than ten characters.");
		}
		this.lastName = last;
	}
	
	public void updateNumber(String phone)
	{
		if (phone == null || phone.length() != 10)
		{
			throw new IllegalArgumentException ("Please include a ten digit phone number.");
		}
		this.phone = phone;
	}
	
	public void updateAddress(String addy)
	{
		if (addy == null || addy.length() > 30)
		{
			throw new IllegalArgumentException ("Please include an address no longer than thirty characters.");
		}
		this.address = addy;
	}
	
	// getter methods
	public String getContactId()
	{
		return contactId;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getNumber()
	{
		return phone;
	}
	
	public String getAddress()
	{
		return address;
	}
	
}
