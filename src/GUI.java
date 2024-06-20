import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GUI {

    private int count = 0;
    private int runningCount = 0;
    private float trueCount = 0;
    private int decks = 1;
    private JTextField userInput;
    private JLabel decksLabel;
    private JLabel countLabel;
    private JLabel runningCountLabel;
    private JLabel trueCountLabel;
    private JFrame frame;
    private JPanel panel;

    public GUI () {

        frame = new JFrame();

        // set labels for all counts
        countLabel = new JLabel("Number of cards: " + count);
        runningCountLabel = new JLabel("Running count: " + runningCount);
        trueCountLabel = new JLabel("True count: " + runningCount);

        // get the number of decks
        decksLabel = new JLabel("Enter the number of decks in the shoe (default 1): ");
        decksLabel.setBounds(10, 10, 100, 100);
        userInput = new JTextField("", 30);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(lowCard);
        panel.add(highCard);
        panel.add(midCard);
        panel.add(resetCount);
        panel.add(countLabel);
        panel.add(runningCountLabel);
        panel.add(trueCountLabel);
        panel.add(decksLabel);
        panel.add(userInput);
        panel.add(numberOfDecks);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Card Counter");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args){
        new GUI();
    }

    JButton numberOfDecks = new JButton(new AbstractAction("Submit") {
        @Override
        public void actionPerformed(ActionEvent e) {
            decks = Integer.parseInt(userInput.getText());
        }
    });

    JButton lowCard = new JButton( new AbstractAction("low card") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            count++;
            runningCount++;
            trueCount = setTrueCount(count, runningCount, decks);
            countLabel.setText(String.valueOf("Number of cards: " + count));
            runningCountLabel.setText(String.valueOf("Running count: " + runningCount));
            trueCountLabel.setText(String.valueOf("True count: " + trueCount));
        }
    });

    JButton highCard = new JButton( new AbstractAction("high card") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            count++;
            runningCount--;
            trueCount = setTrueCount(count, runningCount, decks);
            countLabel.setText(String.valueOf("Number of cards: " + count));
            runningCountLabel.setText(String.valueOf("Running count: " + runningCount));
            trueCountLabel.setText(String.valueOf("True count: " + trueCount));
        }
    });

    JButton midCard = new JButton( new AbstractAction("mid card") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                count++;
                trueCount = setTrueCount(count, runningCount, decks);
                countLabel.setText(String.valueOf("Number of cards: " + count));
                runningCountLabel.setText(String.valueOf("Running count: " + runningCount));
                trueCountLabel.setText(String.valueOf("True count: " + trueCount));
            }
    });

    JButton resetCount = new JButton( new AbstractAction("reset count") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            count = 0;
            runningCount = 0;
            countLabel.setText(String.valueOf("Number of cards: " + count));
            runningCountLabel.setText(String.valueOf("Running count: " + runningCount));
            trueCountLabel.setText(String.valueOf("True count: " + trueCount));
        }
    });

    public static float setTrueCount(Integer count, Integer runningCount, Integer decks) {
        return (float) runningCount / (decks - (int)(Math.floor(count - 51)));
    }
}
