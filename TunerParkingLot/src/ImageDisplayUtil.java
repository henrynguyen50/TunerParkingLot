import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageDisplayUtil extends JFrame {
    private JPanel imagePanel;
    
    //create GUI
    public ImageDisplayUtil() {
        setTitle("Parking Lot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel to hold images
        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(0, 2, 10, 10)); // 2 columns, flexible rows
        imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add scrolling capability
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        setSize(1920, 1080);
        setLocationRelativeTo(null);
    }
    
    //add images to GUI with captions that are the cars description
    public void addImageWithCaption(String imageUrl, String caption) {
        try {
            // Load the image from URL
            @SuppressWarnings("deprecation")
            URL url = new URL(imageUrl);
            BufferedImage originalImage = ImageIO.read(url);
            
            if (originalImage != null) {
                // Create a panel for caption and image
                JPanel containerPanel = new JPanel();
                containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
                containerPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                containerPanel.setBackground(Color.WHITE);
                
                // Create and configure caption label
                JLabel captionLabel = new JLabel(caption);
                captionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                captionLabel.setFont(new Font("Arial", Font.BOLD, 20));
                captionLabel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));
                
                // Resize image to fit nicely in the panel
                int targetWidth = 600;
                int targetHeight = (int) (targetWidth * ((double) originalImage.getHeight() / originalImage.getWidth()));
                
                Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(scaledImage);
                
                // Create and configure image label, which is the image
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));
                
                // Add caption and image
                containerPanel.add(captionLabel);
                containerPanel.add(imageLabel);
                
                // Add container to main panel
                imagePanel.add(containerPanel);
                
                // Refresh the panel
                imagePanel.revalidate();
                imagePanel.repaint();
            }
        } catch (IOException e) {
            System.err.println("Error loading image from " + imageUrl);
            e.printStackTrace();
            
            // Show error message in UI
            JOptionPane.showMessageDialog(
                this,
                "Failed to load image: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    
    
}