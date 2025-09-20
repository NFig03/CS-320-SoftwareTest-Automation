package contactService.ui;

import contactService.ContactService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteContactGUI 
{
    // Delete contact panel static and accessible to main file
    public static JPanel deleteContactPanel = new JPanel(new GridLayout(4, 1, 10, 10));

    static
    {
        // ID Field
        deleteContactPanel.add(new JLabel("ID:"));
        JTextField idField = new JTextField();
        deleteContactPanel.add(idField);

        // Create back button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        deleteContactPanel.add(backButton);

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
        deleteContactPanel.add(submitButton);

        // Add action listener to "Submit" button
        submitButton.addActionListener(new ActionListener() 
        {
            // When "Submit" pressed:
            // User input saved as a string, passed to deleteContact method,
            // panel is switched back to main, and idField is cleared
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String id = idField.getText().trim();
                ContactService.deleteContact(id);
                ContactServiceGUI.switchPanel(ContactServiceGUI.mainPanel);
                idField.setText("");
            }
        });
    }
}
