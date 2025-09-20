package contactService.ui;

import contactService.ContactService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchFirstNameGUI 
{
    // Search first name panel static and accessible to main file
    public static JPanel searchFirstNamePanel = new JPanel(new GridLayout(4, 1, 10, 10));

    static
    {
        // Name Field
        searchFirstNamePanel.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();
        searchFirstNamePanel.add(firstNameField);

        // Create back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        searchFirstNamePanel.add(backButton);

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
        searchFirstNamePanel.add(submitButton);

        // Add action listener to "Submit" button
        submitButton.addActionListener(new ActionListener() 
        {
            // When "Submit" pressed:
            // User input saved as a string, passed to queryFirstName method,
            // panel is switched back to main, and nameField is cleared
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String firstName = firstNameField.getText().trim();
                ContactService.queryFirstName(firstName);
                ContactServiceGUI.switchPanel(ContactServiceGUI.mainPanel);
                firstNameField.setText("");
            }
        });
    }
}
