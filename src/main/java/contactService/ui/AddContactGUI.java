package contactService.ui;

import contactService.ContactService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddContactGUI 
{
    
    // public static add contact panel as we only need one accessible to main GUI file
    public static JPanel addContactPanel = new JPanel(new GridLayout(6, 2, 10, 10));

    static
    {   
        // ID Field
        addContactPanel.add(new JLabel("ID:"));
        JTextField idField = new JTextField();
        addContactPanel.add(idField);

        // First name field
        addContactPanel.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        addContactPanel.add(firstNameField);

        // Last name field
        addContactPanel.add(new JLabel("Last Name:"));
        JTextField lastNameField = new JTextField();
        addContactPanel.add(lastNameField);

        // Phone number field
        addContactPanel.add(new JLabel("Phone Number:"));
        JTextField phoneNumberField = new JTextField();
        addContactPanel.add(phoneNumberField);

        // Address Field
        addContactPanel.add(new JLabel("Address:"));
        JTextField addressField = new JTextField();
        addContactPanel.add(addressField);
        
        // Create back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        addContactPanel.add(backButton);

        // Add action listener to "Back" button
        backButton.addActionListener(new ActionListener() 
        {
            // Switch panel back to main panel on click
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ContactServiceGUI.switchPanel(ContactServiceGUI.mainPanel);
            }
        });

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        addContactPanel.add(submitButton);

        // Add action listener to "Submit" button
        submitButton.addActionListener(new ActionListener() 
        {
            // When "Submit" pressed:
            // User input is stored as strings, these strings are passed to "addContact" method,
            // panel reverts back to main panel, and text fields are cleared
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String id = idField.getText().trim();
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String phoneNumber = phoneNumberField.getText().trim();
                String address = addressField.getText().trim();
                ContactService.addContact(id, firstName, lastName, phoneNumber, address);
                ContactServiceGUI.switchPanel(ContactServiceGUI.mainPanel);
                
                idField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                phoneNumberField.setText("");
                addressField.setText("");
            }
        });
    }
}
