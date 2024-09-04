package notepad;


import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
import java.util.Map;
import java.awt.font.TextAttribute;
import java.net.URL;

class Notepad extends JFrame implements ActionListener {
    // Text component
    JTextArea t;

    // Frame
    JFrame f;

    // Status bar
    JLabel statusBar;

    // Constructor
    Notepad() {
        // Create a frame
        f = new JFrame("Notepad");
        URL imageURL = Notepad.class.getResource("/notepad/logo/notepad1.png");
        if (imageURL != null) {
            Image icon = Toolkit.getDefaultToolkit().getImage(imageURL);
            f.setIconImage(icon);
        } else {
            System.err.println("Error: Image resource not found.");
        }

        try {
            // Set metal look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");


            // Set theme to ocean
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        } catch (Exception e) {
            // Handle exception
        }

        // Text component
        t = new JTextArea();
        t.setLineWrap(true);
        t.setWrapStyleWord(true);

        // Create a menubar
        JMenuBar mb = new JMenuBar();

        // Add spacing between menu items
        mb.add(Box.createHorizontalStrut(30)); // Add space to the left of the first menu item

        // Create a menu for File
        JMenu m1 = new JMenu("File");
         Font boldFont = new Font(m1.getFont().getFontName(), Font.BOLD, m1.getFont().getSize());
        m1.setFont(boldFont);


        // Create menu items
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi9 = new JMenuItem("Print");

        // Add action listener
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi9.addActionListener(this);

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);

        // Add space between menus
        mb.add(m1);
        mb.add(Box.createHorizontalStrut(30));

        // Create a menu for Edit
        JMenu m2 = new JMenu("Edit");
        Font boldFont1 = new Font(m2.getFont().getFontName(), Font.BOLD, m2.getFont().getSize());
        m2.setFont(boldFont1);

        // Create menu items
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");

        // Add action listener
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);

        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);

        // Add font style items
        JMenuItem miBold = new JMenuItem("Bold");
        JMenuItem miItalic = new JMenuItem("Italic");
        JMenuItem miUnderline = new JMenuItem("Underline");
        JMenuItem miFont = new JMenuItem("Font");

        miBold.addActionListener(this);
        miItalic.addActionListener(this);
        miUnderline.addActionListener(this);
        miFont.addActionListener(this);

        m2.add(miBold);
        m2.add(miItalic);
        m2.add(miUnderline);
        m2.add(miFont);

        mb.add(m2);
        mb.add(Box.createHorizontalStrut(30));

        // Create a menu for Theme
        JMenu m3 = new JMenu("Theme");
        Font boldFont2 = new Font(m3.getFont().getFontName(), Font.BOLD, m3.getFont().getSize());
        m3.setFont(boldFont2);

        // Create theme items
        JMenuItem mi7 = new JMenuItem("Light");
        JMenuItem mi8 = new JMenuItem("Dark");
        JMenuItem mi10 = new JMenuItem("Custom");

        // Add action listener
        mi7.addActionListener(this);
        mi8.addActionListener(this);
        mi10.addActionListener(this);

        m3.add(mi7);
        m3.add(mi8);
        m3.add(mi10);

        // Create a menu for Cursor
        JMenu mCursor = new JMenu("Cursor");
        

        // Create cursor type items
        JMenuItem defaultCursor = new JMenuItem("Default Cursor");
        JMenuItem handCursor = new JMenuItem("Hand Cursor");
        JMenuItem crosshairCursor = new JMenuItem("Crosshair Cursor");

        defaultCursor.addActionListener(this);
        handCursor.addActionListener(this);
        crosshairCursor.addActionListener(this);

        mCursor.add(defaultCursor);
        mCursor.add(handCursor);
        mCursor.add(crosshairCursor);

        // Create a submenu for Custom Cursors
        JMenu customCursorMenu = new JMenu("Custom Cursor");
        

        // Create custom cursor sub-items
        JMenuItem notepadCursor = new JMenuItem("Notepad Cursor");
        JMenuItem penCursor = new JMenuItem("Pen Cursor");
        JMenuItem middleFingerCursor = new JMenuItem("Middle Finger Cursor");
        JMenuItem notebookCursor = new JMenuItem("Notebook Cursor");
        JMenuItem handCursorCustom = new JMenuItem("Hand Cursor");
        JMenuItem arrowCursor = new JMenuItem("Arrow Cursor");
        JMenuItem swordCursor = new JMenuItem("Sword Cursor");
        JMenuItem swordCursor1 = new JMenuItem("Sword Cursor(Golden Edition)");
        JMenuItem textCursor = new JMenuItem("Text Cursor");
        JMenuItem angel = new JMenuItem("Angel");

        notepadCursor.addActionListener(this);
        penCursor.addActionListener(this);
        middleFingerCursor.addActionListener(this);
        notebookCursor.addActionListener(this);
        handCursorCustom.addActionListener(this);
        arrowCursor.addActionListener(this);
        swordCursor.addActionListener(this);
        swordCursor1.addActionListener(this);
        textCursor.addActionListener(this);
        angel.addActionListener(this);

        customCursorMenu.add(notepadCursor);
        customCursorMenu.add(penCursor);
        customCursorMenu.add(middleFingerCursor);
        customCursorMenu.add(notebookCursor);
        customCursorMenu.add(handCursorCustom);
        customCursorMenu.add(arrowCursor);
        customCursorMenu.add(swordCursor);
        customCursorMenu.add(swordCursor1);
        customCursorMenu.add(textCursor);
        customCursorMenu.add(angel);

        mCursor.add(customCursorMenu);

        // Add the cursor menu to the theme menu
        m3.add(mCursor);

        mb.add(m3);
        mb.add(Box.createHorizontalStrut(30));

        JMenuItem mc = new JMenuItem("close");
         Font boldFont3 = new Font(mc.getFont().getFontName(), Font.BOLD, mc.getFont().getSize());
        mc.setFont(boldFont3);
        
        

        mc.addActionListener(this);

        mb.add(mc);
        mb.add(Box.createHorizontalStrut(30)); // Add space to the right of the last menu item

        // Status bar
       statusBar = new JLabel("Words: 0 Lines: 0");
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBorder(BorderFactory.createEmptyBorder(5, 18,10 , 10)); // Add padding

        // Add status bar label to the left of the panel
        statusPanel.add(statusBar, BorderLayout.WEST);

        // Add key listener to update status bar
        t.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                updateStatusBar();
            }
        });

        f.setJMenuBar(mb);
        f.add(new JScrollPane(t), BorderLayout.CENTER);
        f.add(statusPanel, BorderLayout.SOUTH);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        // Key binding for Ctrl+S to save
        t.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "save");
        t.getActionMap().put("save", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        //KEYBINDING FOR CTLR+B
         t.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK), "bold");
        t.getActionMap().put("bold", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                toggleBold();
            }
        });

        // Right-click menu
        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(t, popupMenu);

        addMenuItem(popupMenu, "cut");
        addMenuItem(popupMenu, "copy");
        addMenuItem(popupMenu, "paste");
        popupMenu.addSeparator();
        addMenuItem(popupMenu, "Bold");
        addMenuItem(popupMenu, "Italic");
        addMenuItem(popupMenu, "Underline");
        addMenuItem(popupMenu, "Font");

        updateStatusBar();
    }

    // Utility method to add items to the popup menu
    private void addMenuItem(JPopupMenu menu, String text) {
        JMenuItem item = new JMenuItem(text);
        item.addActionListener(this);
        menu.add(item);
    }

    // If a button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        switch (s) {
            case "cut":
                t.cut();
                break;
            case "copy":
                t.copy();
                break;
            case "paste":
                t.paste();
                break;
            case "Save":
                saveFile();
                break;
            case "Print":
                try {
                    t.print();
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
                break;
            case "Open":
                openFile();
                break;
            case "New":
                t.setText("");
                break;
            case "close":
                f.setVisible(false);
                break;
            case "Light":
                setLightTheme();
                break;
            case "Dark":
                setDarkTheme();
                break;
            case "Custom":
                chooseCustomColor();
                break;
            case "Bold":
                toggleBold();
                break;
            case "Italic":
                toggleItalic();
                break;
            case "Underline":
                toggleUnderline();
                break;
            case "Font":
                chooseFont();
                break;
            case "Default Cursor":
                setCursorType(Cursor.DEFAULT_CURSOR);
                break;
            case "Hand Cursor":
                setCursorType(Cursor.HAND_CURSOR);
                break;
            case "Crosshair Cursor":
                setCursorType(Cursor.CROSSHAIR_CURSOR);
                break;
            case "Notepad Cursor":
                setCustomCursor("/notepad/cursor/notepad.png");
                break;
            case "Pen Cursor":
                setCustomCursor("/notepad/cursor/pen.png");
                break;
            case "Middle Finger Cursor":
                setCustomCursor("/notepad/cursor/middle_finger.png");
                break;
            case "Notebook Cursor":
                setCustomCursor("/notepad/cursor/notebook.png");
                break;
            case "Arrow Cursor":
                setCustomCursor("/notepad/cursor/arrow.png");
                break;
            case "Sword Cursor":
                setCustomCursor("/notepad/cursor/sword.png");
                break;
            case "Sword Cursor(Golden Edition)":
                setCustomCursor("/notepad/cursor/sword1.png");
                break;
           case "Angel":
                setCustomCursor("/notepad/cursor/angel.png");
                break;
            case "Text Cursor":
                setCustomCursor("/cursors/text.png");
                break;
            default:
                JOptionPane.showMessageDialog(f, "Unknown action: " + s);
        }
        updateStatusBar();
    }

    private void setCursorType(int cursorType) {
        Cursor cursor = Cursor.getPredefinedCursor(cursorType);
        t.setCursor(cursor);
    }

    private void setCustomCursor(String path) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        URL imageURL = Notepad.class.getResource(path);
        if (imageURL != null) {
            Image image = toolkit.getImage(imageURL);
            Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 0), "Custom Cursor");
            t.setCursor(cursor);
        } else {
            JOptionPane.showMessageDialog(f, "Cursor image not found: " + path);
        }
    }

    private void saveFile() {
        JFileChooser j = new JFileChooser("f:");
        int r = j.showSaveDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File fi = new File(j.getSelectedFile().getAbsolutePath());
            try {
                FileWriter wr = new FileWriter(fi, false);
                BufferedWriter w = new BufferedWriter(wr);
                w.write(t.getText());
                w.flush();
                w.close();
                JOptionPane.showMessageDialog(f, "File saved successfully!");
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(f, evt.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(f, "The user cancelled the operation");
        }
    }

    private void openFile() {
        JFileChooser j = new JFileChooser("f:");
        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File fi = new File(j.getSelectedFile().getAbsolutePath());
            try {
                String s1 = "", sl = "";
                FileReader fr = new FileReader(fi);
                BufferedReader br = new BufferedReader(fr);
                sl = br.readLine();
                while ((s1 = br.readLine()) != null) {
                    sl = sl + "\n" + s1;
                }
                t.setText(sl);
                br.close();
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(f, evt.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(f, "The user cancelled the operation");
        }
    }

    private void setLightTheme() {
        t.setBackground(Color.WHITE);
        t.setForeground(Color.BLACK);
    }

    private void setDarkTheme() {
        t.setBackground(Color.DARK_GRAY);
        t.setForeground(Color.WHITE);
    }

    private void chooseCustomColor() {
        Color backgroundColor = JColorChooser.showDialog(f, "Choose Background Color", t.getBackground());
        if (backgroundColor != null) {
            t.setBackground(backgroundColor);
        }

        Color textColor = JColorChooser.showDialog(f, "Choose Text Color", t.getForeground());
        if (textColor != null) {
            t.setForeground(textColor);
        }
    }

    private void toggleBold() {
        Font currentFont = t.getFont();
        if (currentFont.getStyle() == Font.BOLD) {
            t.setFont(currentFont.deriveFont(Font.PLAIN));
        } else {
            t.setFont(currentFont.deriveFont(Font.BOLD));
        }
    }

    private void toggleItalic() {
        Font currentFont = t.getFont();
        if (currentFont.getStyle() == Font.ITALIC) {
            t.setFont(currentFont.deriveFont(Font.PLAIN));
        } else {
            t.setFont(currentFont.deriveFont(Font.ITALIC));
        }
    }

    private void toggleUnderline() {
        Font font = t.getFont();
        Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) font.getAttributes();
        boolean isUnderline = TextAttribute.UNDERLINE_ON.equals(attributes.get(TextAttribute.UNDERLINE));
        attributes.put(TextAttribute.UNDERLINE, isUnderline ? null : TextAttribute.UNDERLINE_ON);
        t.setFont(font.deriveFont(attributes));
    }

    private void chooseFont() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts();
        String[] fontNames = new String[fonts.length];

        for (int i = 0; i < fonts.length; i++) {
            fontNames[i] = fonts[i].getFontName();
        }

        String selectedFont = (String) JOptionPane.showInputDialog(f, "Choose Font", "Font", JOptionPane.PLAIN_MESSAGE, null, fontNames, t.getFont().getFontName());

        if (selectedFont != null) {
            Font selected = new Font(selectedFont, t.getFont().getStyle(), t.getFont().getSize());
            t.setFont(selected);
        }
    }

    private void updateStatusBar() {
        String text = t.getText();
        int wordCount = text.split("\\s+").length;
        int lineCount = text.split("\n").length;
        statusBar.setText("Words: " + wordCount + " Lines: " + lineCount);
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    public static void main(String args[]) {
        new Notepad();
    }
}
