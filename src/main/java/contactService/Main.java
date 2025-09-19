package contactService;

import javax.swing.SwingUtilities;
//import contactService.Contact;
//import contactService.ContactService;
import contactService.ui.*;

public class Main 
{
    public static void main(String[] args)
    {
        // Declare, instantiate, and show GUI
        SwingUtilities.invokeLater(() -> 
        {
            new ContactServiceGUI().createAndShowGUI();
        });
    }
}
