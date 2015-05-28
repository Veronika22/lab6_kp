package com.company;

        import javax.swing.*;
        import javax.swing.border.EmptyBorder;
        import javax.swing.event.DocumentEvent;
        import javax.swing.event.DocumentListener;
        import javax.swing.event.ListSelectionEvent;
        import javax.swing.event.ListSelectionListener;
        import java.awt.*;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.io.UnsupportedEncodingException;

public class MainWindow extends JFrame {

    private JList mList;
    private JTextArea mTextArea;
    private JTextField mSearchField;
    private Finder mFinder;

    public MainWindow() {
        setTitle("Справочник по визовым странам");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BorderLayout());

        JButton button = new JButton("о нас");
        JButton button1 = new JButton("контакты");
        JButton button2 = new JButton("Консультация");
        JButton button3 = new JButton("Обратная связь");

        JPanel Panel = new JPanel();
        //Panel.setPreferredSize(new Dimension(200, 50));
        Panel.add(button);
        Panel.add(button1);
        Panel.add(button2);
        Panel.add(button3);


    }
}
