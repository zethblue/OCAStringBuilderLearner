package viewing;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rahmen extends JFrame {

    private JLabel StringBuilderAusgabe;
    private JTextField StringBuilderEingabe;
    private JLabel BeschreibungStringBuilderEingabe;


    public Rahmen(Controller C1){

        StringBuilderEingabe = new JTextField("");
        BeschreibungStringBuilderEingabe = new JLabel("StringBuilder eingeben:");
        JLabel BeschreibungStringBuilderAusgabe = new JLabel("Aktueller Stringbuilder:");
        StringBuilderAusgabe = new JLabel("");
        JButton createStringBuilder = new JButton("new Stringbuilder()");
        JButton buttonCharAt = new JButton("charAt()");
        JButton buttonIndexOf = new JButton("indexOf()");
        JButton buttonLength = new JButton("length()");
        JButton buttonSubString = new JButton("substring()");
        JButton buttonAppend = new JButton("append()");
        JButton buttonInsert = new JButton("insert()");
        JButton buttonDelete = new JButton("delete()");
        JButton buttonDeleteCharAt = new JButton("deleteCharAT()");
        JButton buttonReverse = new JButton("reverse()");

        JPanel buttonRow = new JPanel();
        buttonRow.setLayout(new GridLayout(5,2));
        buttonRow.add(createStringBuilder); buttonRow.add(buttonCharAt); buttonRow.add(buttonIndexOf); buttonRow.add(buttonLength);
        buttonRow.add(buttonSubString); buttonRow.add(buttonAppend); buttonRow.add(buttonInsert); buttonRow.add(buttonDelete);
        buttonRow.add(buttonDeleteCharAt);buttonRow.add(buttonReverse);

        JPanel eingabePanel = new JPanel();
        eingabePanel.setLayout(new GridLayout(2,1));
        eingabePanel.add(BeschreibungStringBuilderEingabe); eingabePanel.add(StringBuilderEingabe);

        JPanel ausgabePanel = new JPanel();
        ausgabePanel.setLayout(new GridLayout(2,1));
        ausgabePanel.add(BeschreibungStringBuilderAusgabe); ausgabePanel.add(StringBuilderAusgabe);

        this.setLayout(new GridLayout(3,1));
        this.setTitle("Stringbuilder Exercise");
        this.add(eingabePanel); this.add(ausgabePanel); this.add(buttonRow);
        this.setSize(550,350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        createStringBuilder.addActionListener(e -> C1.createNewStringBuilder());
        buttonCharAt.addActionListener(e -> new EingabeRahmenCharAT(C1));
        buttonIndexOf.addActionListener(e -> new IndexOfRahmen(C1));
        buttonLength.addActionListener(e -> C1.useLength());
        buttonSubString.addActionListener(e -> new SubstringRahmen(C1));
        buttonAppend.addActionListener(e -> C1.useAppend());
        buttonInsert.addActionListener(e -> new InsertRahmen(C1));
        buttonReverse.addActionListener(e -> C1.useReverse());
        buttonDelete.addActionListener(e -> new DeleteRahmen(C1));
        buttonDeleteCharAt.addActionListener(e -> new DeleteCharAtRahmen(C1));




    }

    public void setStringBuilderAusgabe(String s) {
        StringBuilderAusgabe.setText(s);
    }
    public void setStringBuilderEingabe(String s) {
        StringBuilderEingabe.setText(s);
    }
    public String getStringBuilderEingabe() {
        return StringBuilderEingabe.getText();
    }
    public void setBeschreibungStringBuilderEingabe(String s) {
        BeschreibungStringBuilderEingabe.setText(s);
    }
}

class EingabeRahmenCharAT extends JFrame {

    public EingabeRahmenCharAT(Controller C1) {

        JLabel beschreibung1 = new JLabel("Bitte Zahl eingeben:");
        JTextField stringEingabe = new JTextField("");
        JButton ok = new JButton("ok");

        this.setLayout(new GridLayout(3, 1));
        this.add(beschreibung1);
        this.add(stringEingabe);
        this.add(ok);
        this.setSize(50, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ok.addActionListener(e -> {C1.useCharAt(stringEingabe.getText());dispose();});
    }
}
class IndexOfRahmen extends JFrame {

    public IndexOfRahmen(Controller C1) {

        JLabel beschreibung1 = new JLabel("Bitte einen String oder Char eingeben:");
        JTextField stringEingabe = new JTextField("");
        JLabel beschreibung2 = new JLabel("Zahl ist möglich");
        JTextField stringEingabe2 = new JTextField("");
        JButton ok = new JButton("ok");

        this.setLayout(new GridLayout(5, 1));
        this.add(beschreibung1);
        this.add(stringEingabe);
        this.add(beschreibung2);
        this.add(stringEingabe2);
        this.add(ok);
        this.setSize(50, 160);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ok.addActionListener(e -> {C1.useIndexOf(stringEingabe.getText(), stringEingabe2.getText());dispose();});
    }
}
class SubstringRahmen extends JFrame{

    public SubstringRahmen(Controller C1){

        JLabel beschreibung1 = new JLabel("Bitte Zahl1 eingeben:");
        JLabel beschreibung2 = new JLabel("Zahl2 möglich:");
        JTextField eingabe1 = new JTextField("");
        JTextField eingabe2 = new JTextField("");
        JButton ok = new JButton("ok");

        this.setLayout(new GridLayout(5,1));
        this.add(beschreibung1); this.add(eingabe1); this.add(beschreibung2); this.add(eingabe2);
        this.add(ok);
        this.setSize(60,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ok.addActionListener(e -> {
            C1.useSubstring(eingabe1.getText(),eingabe2.getText());
            dispose();
        });
    }

}
class InsertRahmen extends JFrame {

    public InsertRahmen(Controller C1) {

        JLabel beschreibung1 = new JLabel("Bitte Index eingeben:");
        JTextField stringEingabe = new JTextField("");
        JButton ok = new JButton("ok");

        this.setLayout(new GridLayout(3, 1));
        this.add(beschreibung1);
        this.add(stringEingabe);
        this.add(ok);
        this.setSize(50, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ok.addActionListener(e -> {C1.useInsert(stringEingabe.getText());dispose();});
    }
}
class DeleteRahmen extends JFrame{

    public DeleteRahmen(Controller C1){

        JLabel beschreibung1 = new JLabel("ab welchem Index?");
        JLabel beschreibung2 = new JLabel("bis wohin ?");
        JTextField eingabe1 = new JTextField("");
        JTextField eingabe2 = new JTextField("");
        JButton ok = new JButton("ok");

        this.setLayout(new GridLayout(5,1));
        this.add(beschreibung1); this.add(eingabe1); this.add(beschreibung2); this.add(eingabe2);
        this.add(ok);
        this.setSize(60,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ok.addActionListener(e -> {
            C1.useDelete(eingabe1.getText(),eingabe2.getText());
            dispose();
        });
    }

}
class DeleteCharAtRahmen extends JFrame{

    public DeleteCharAtRahmen(Controller C1){

        JLabel beschreibung1 = new JLabel("Index?");
        JTextField eingabe1 = new JTextField("");
        JButton ok = new JButton("ok");

        this.setLayout(new GridLayout(3,1));
        this.add(beschreibung1); this.add(eingabe1);
        this.add(ok);
        this.setSize(60,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ok.addActionListener(e -> {
            C1.useDeleteCharAt(eingabe1.getText());
            dispose();
        });
    }

}

