package contactService.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContactServiceGUI 
{
    // New JFrame for main window
    public static JFrame frame = new JFrame("Contact Service");

    // New panel (Main panel)
    public static JPanel mainPanel = new JPanel(new BorderLayout());

    // Set up and display GUI
    public void createAndShowGUI()
    {
        // Main frame(window) modifiers
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Main panel label
        JLabel label = new JLabel("Contact Service", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // Main panel structure
        mainPanel.add(label, BorderLayout.NORTH);

        // Button panel components (layered on main panel)
        JButton addContactButton = new JButton("Add Contact");
        JButton deleteContactButton = new JButton("Delete Contact");
        JButton searchFirstNameButton = new JButton("Search By");
        JButton updateContactButton = new JButton("Update Contact");

        // Add action listener to "Add Contact" button
        addContactButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switchPanel(AddContactGUI.addContactPanel);
            }
        });

        // Add action listener to "Delete Contact" button
        deleteContactButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switchPanel(DeleteContactGUI.deleteContactPanel);
            }
        });

        // Add action listener to "Search First Name" button
        searchFirstNameButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switchPanel(SearchFirstNameGUI.searchFirstNamePanel);
            }
        });

         // Add action listener to "Update Contact" button
        updateContactButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                switchPanel(UpdateContactGUI.updateContactPanel);
            }
        });

        // Button modifiers
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

    // Method to switch between panels
    public static void switchPanel(JPanel panel)
    {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }
}
