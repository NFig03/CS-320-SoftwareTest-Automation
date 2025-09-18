package contactService;

import contactService.Contact;
import contactService.ContactService;

public class Main 
{
    public static void main(String[] args)
    {
        // Used to test query function
        ContactService contactService = new ContactService();
        contactService.addContact("1", "Noah", "Figueroa", "3333333333", "623 Lollipop Lane");
        Contact result = ContactService.queryFirstName("Noah");
        System.out.println(result.getFirstName());
        System.out.println(result.getLastName());
        System.out.println(result.getAddress());
    }
}
