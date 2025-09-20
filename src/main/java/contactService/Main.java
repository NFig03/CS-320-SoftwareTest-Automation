package contactService;

import javax.swing.SwingUtilities;
import contactService.ui.*;

public class Main 
{
    public static ContactService contactService = new ContactService();

    public static void main(String[] args)
    {   
        // Declare, instantiate, and show GUI
        SwingUtilities.invokeLater(() -> 
        {
            new ContactServiceGUI().createAndShowGUI();
        });
    }
}
