package contactService.ui;

import java.util.*;
import contactService.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchFirstNameGUI 
{
    // Search first name panel static and accessible to main file
    public static JPanel searchFirstNamePanel = new JPanel(new GridLayout(3, 2, 10, 10));

    static
    {
        // Name Field
        searchFirstNamePanel.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        searchFirstNamePanel.add(firstNameField);

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
                firstNameField.setText("");
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
            // When "Submit" pressed:
            // Clear output area, retrieve contact(s)
            // If no contact(s) found, output corresponding statement
            // If contact(s) found, output associated values
            @Override
            public void actionPerformed(ActionEvent e)
            {
                outputArea.setText("");
                String firstName = firstNameField.getText().trim();
                Set<String> output = ContactService.queryFirstName(firstName);

                if(output == null)
                {
                    outputArea.append("No contact found.");
                }

                for (String id : output)
                {
                    Contact Holder = ContactService.contacts.get(id);
                    outputArea.append(Holder.contactId + ", ");
                    outputArea.append(Holder.firstName + " ");
                    outputArea.append(Holder.lastName + ", ");
                    outputArea.append(Holder.phone + ", ");
                    outputArea.append(Holder.address + "\n");
                }
            }
        });
    }
}
