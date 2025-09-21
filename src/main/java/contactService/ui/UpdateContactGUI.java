package contactService.ui;

import contactService.ContactService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateContactGUI 
{
    // Update contact panel static and accessible to main file
    public static JPanel updateContactPanel = new JPanel(new GridLayout(6, 2, 10, 10));

    static
    {
        // Contact ID Field
        updateContactPanel.add(new JLabel("Contact ID:"));
        JTextField idField = new JTextField();
        updateContactPanel.add(idField);
        
        // Update First Name Field
        updateContactPanel.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        updateContactPanel.add(firstNameField);

        // Update Last Name Field
        updateContactPanel.add(new JLabel("Last Name:"));
        JTextField lastNameField = new JTextField();
        updateContactPanel.add(lastNameField);

        // Update Phone Number Field
        updateContactPanel.add(new JLabel("Phone Number:"));
        JTextField phoneNumberField = new JTextField();
        updateContactPanel.add(phoneNumberField);

        // Update Address Field
        updateContactPanel.add(new JLabel("Address:"));
        JTextField addressField = new JTextField();
        updateContactPanel.add(addressField);

        // Create back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        updateContactPanel.add(backButton);

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
        updateContactPanel.add(submitButton);

        // Add action listener to "Submit" button
        submitButton.addActionListener(new ActionListener() 
        {
            // When "Submit" pressed:
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Save all variables to strings
                String id = idField.getText().trim();
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String phoneNumber = phoneNumberField.getText().trim();
                String address = addressField.getText().trim();

                // If ID and first name are provided, update first name
                if((id.isEmpty() == false) & (firstName.isEmpty() == false))
                {
                    ContactService.updateFirstName(id, firstName);
                }

                // If ID and last name are provided, update last name
                if((id.isEmpty() == false) & (lastName.isEmpty() == false))
                {
                    ContactService.updateLastName(id, lastName);
                }

                // If ID and phone number are provided, update phone number
                if((id.isEmpty() == false) & (phoneNumber.isEmpty() == false))
                {
                    ContactService.updateNumber(id, phoneNumber);
                }

                // If ID and address are provided, update address
                if((id.isEmpty() == false) & (address.isEmpty() == false))
                {
                    ContactService.updateAddress(id, address);
                }
                
                // Switch panel back to main and clear all fields
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

