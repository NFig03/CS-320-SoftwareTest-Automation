package contactService.ui;

import java.util.*;
import contactService.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchFirstNameGUI 
{
    // Search first name panel static and accessible to main file
    public static JPanel searchFirstNamePanel = new JPanel(new GridLayout(7, 2, 10, 10));

    static
    {
        // ID Field
        searchFirstNamePanel.add(new JLabel("ID:"));
        JTextField idField = new JTextField();
        searchFirstNamePanel.add(idField);
        
        // First Name Field
        searchFirstNamePanel.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        searchFirstNamePanel.add(firstNameField);

         // Last Name Field
        searchFirstNamePanel.add(new JLabel("Last Name:"));
        JTextField lastNameField = new JTextField();
        searchFirstNamePanel.add(lastNameField);

         // Phone Number Field
        searchFirstNamePanel.add(new JLabel("Phone Number:"));
        JTextField phoneNumberField = new JTextField();
        searchFirstNamePanel.add(phoneNumberField);

         // Address Field
        searchFirstNamePanel.add(new JLabel("Address:"));
        JTextField addressField = new JTextField();
        searchFirstNamePanel.add(addressField);

        // Create Output Area as read only for contact output
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        searchFirstNamePanel.add(outputArea);

        // Create secondary Output Area as read only for filler
        JTextArea outputAreaFiller = new JTextArea();
        outputAreaFiller.setEditable(false);
        searchFirstNamePanel.add(outputAreaFiller);

        // Create back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        searchFirstNamePanel.add(backButton);

        // Add action listener to "Back" button
        backButton.addActionListener(new ActionListener() 
        {
            // Switch back to main panel and clear I/O on click
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ContactServiceGUI.switchPanel(ContactServiceGUI.mainPanel);
                outputArea.setText("");
                idField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                phoneNumberField.setText("");
                addressField.setText("");
                outputArea.setText("");
            }
        });

        // Create submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        searchFirstNamePanel.add(submitButton);

        // Add action listener to "Submit" button
        submitButton.addActionListener(new ActionListener() 
        {
            // Triggered when "Submit" is pressed:
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Clear output area
                outputArea.setText("");

                // Placeholders for query results
                Set<String> output = null;
                Contact outputContact = null;
                
                // Get trimmed user input from each field
                String id = idField.getText().trim();
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String phoneNumber = phoneNumberField.getText().trim();
                String address = addressField.getText().trim();

                // Perform the appropriate query based on which field is filled
                if (id.isEmpty() == false)
                {
                    outputContact = ContactService.contacts.get(id);
                }
                else if (firstName.isEmpty() == false)
                {
                    output = ContactService.queryFirstName(firstName);
                }
                else if (lastName.isEmpty() == false)
                {
                    output = ContactService.queryLastName(lastName);
                }
                else if (phoneNumber.isEmpty() == false)
                {
                    output = ContactService.queryPhoneNumber(phoneNumber);
                }
                else if (address.isEmpty() == false)
                {
                    output = ContactService.queryAddress(address);
                }

                // If a contact was found by ID, display it
                if (outputContact != null)
                {
                    outputArea.append(outputContact.contactId + ", ");
                    outputArea.append(outputContact.firstName + " ");
                    outputArea.append(outputContact.lastName + ", ");
                    outputArea.append(outputContact.phone + ", ");
                    outputArea.append(outputContact.address + "\n");
                }
                // If any other query returned output and is not null, print associated information
                else if (output != null && !output.isEmpty())
                {
                    // iterate over returned set if there are multiple IDs associated with the queried attribute
                    for (String idNum : output)
                {
                    Contact Holder = ContactService.contacts.get(idNum);
                    outputArea.append(Holder.contactId + ", ");
                    outputArea.append(Holder.firstName + " ");
                    outputArea.append(Holder.lastName + ", ");
                    outputArea.append(Holder.phone + ", ");
                    outputArea.append(Holder.address + "\n");
                }
                }
                else
                {
                    // No matching contact found
                    outputArea.append("No contact found.");
                }
            }
        });
    }
}
