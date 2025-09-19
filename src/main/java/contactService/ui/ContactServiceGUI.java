package contactService.ui;

import javax.swing.*;
import java.awt.*;

public class ContactServiceGUI 
{
    public static void main(String[] args)
    {
        // Declare, instantiate, and show GUI
        SwingUtilities.invokeLater(() -> 
        {
            new ContactServiceGUI().createAndShowGUI();
        });
    }

    // Set up and display GUI
    public void createAndShowGUI()
    {
        // New JFrame for main window
        JFrame frame = new JFrame("Contact Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Main panel label
        JLabel label = new JLabel("Contact Service", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // Main panel structure
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(label, BorderLayout.NORTH);

        // Button panel components (layered on main panel)
        JButton addContactButton = new JButton("Add Contact");
        JButton deleteContactButton = new JButton("Delete Contact");
        JButton searchFirstNameButton = new JButton("Search By First Name");
        JButton updateContactButton = new JButton("Update Contact");
        addContactButton.setFont(new Font("Arial", Font.BOLD, 20));
        deleteContactButton.setFont(new Font("Arial", Font.BOLD, 20));
        searchFirstNameButton.setFont(new Font("Arial", Font.BOLD, 20));
        updateContactButton.setFont(new Font("Arial", Font.BOLD, 20));

        // Button panel structure (layered on main panel)
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        buttonPanel.add(addContactButton);
        buttonPanel.add(searchFirstNameButton);
        buttonPanel.add(deleteContactButton);
        buttonPanel.add(updateContactButton);

        // Add button panel to center of main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add main panel to frame's content pane
        frame.getContentPane().add(mainPanel);

        // Toggle visibility of frame
        frame.setVisible(true);
    }
}
