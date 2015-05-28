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

        mFinder = new Finder("out/production/CountryCatalog/ru/miet35/countries");

        String[] data = mFinder.makeCountryList();

        mList = new JList(data); //data has type Object[]
        mList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        mList.setLayoutOrientation(JList.VERTICAL);
        mList.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(mList);
        listScroller.setPreferredSize(new Dimension(200, 80));


        mList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting() || mList.getSelectedValue() == null)
                    return;
                mTextArea.setText(mFinder.getDescription(mList.getSelectedValue().toString()));
                //mTextArea.append("/n");
            }
        });

        mSearchField = new JTextField();
        mSearchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchCountries();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchCountries();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchCountries();
            }

            private void searchCountries() {
                String[] data = mFinder.makeCountryList(mSearchField.getText());

                // mTextArea.append("/n");
                mList.setListData(data);
            }
        });

        listPanel.add(BorderLayout.CENTER, listScroller);
        listPanel.add(BorderLayout.SOUTH, mSearchField);


        EmptyBorder border = new EmptyBorder(5,10,5,10);
        listPanel.setBorder(border);
        descriptionPanel.setBorder(border);


        //button.setBorder(border);
        //button1.setBorder(border);



        mTextArea = new JTextArea();
        mTextArea.setColumns(20);
        mTextArea.setLineWrap(true);
        mTextArea.setRows(5);
        mTextArea.setWrapStyleWord(true);

        JScrollPane descriptionScroller = new JScrollPane(mTextArea);
        descriptionScroller.setPreferredSize(new Dimension(550, 70));
        descriptionPanel.add(descriptionScroller);

        /*JPanel Panel = new JPanel();
        Panel.setPreferredSize(new Dimension(200, 50));
        button.add(Panel);
        button1.add(Panel);*/


        getContentPane().add(BorderLayout.WEST, listPanel);
        getContentPane().add(BorderLayout.EAST, descriptionPanel);
        getContentPane().add(BorderLayout.NORTH, Panel);
        //getContentPane().add(BorderLayout.PAGE_START, button1);

        setResizable(false);
        setSize(800, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow w = new MainWindow();
    }

}


