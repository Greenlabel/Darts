

package mate.dart.gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mate.dart.AbstractGame;
import mate.dart.ThrowEvent;
import mate.dart.utils.Utils;

public class GameCricetScoreBoard extends AbstractGame
{
  private static final long serialVersionUID = 1L;
  int game = 301;
  int round = 1;
  int currentPlayer = 0;
  private int players = 2;
  int throwsNumber = 0;
  String beforeRound = "";
  PlayerCounter[] playersCounters = new PlayerCounter[this.players];
  JTextField roundField = new JTextField("1");
  JLabel leftDarts = new JLabel("Left Darts: 3");
  JTextArea info = new JTextArea("");

  public GameCricetScoreBoard(int paramInt)
  {
    initComponents();
  }

  public GameCricetScoreBoard()
  {
    this(301);
  }

  public String getName()
  {
    return "Cricet";
  }

  public void repaint()
  {
    super.repaint();
    if (this.playersCounters != null)
      colorCounters();
  }

  private void initComponents()
  {
    this.playersCounters = new PlayerCounter[this.players];
    for (int i = 0; i < this.players; i++)
      this.playersCounters[i] = new PlayerCounter();
    setLayout(new BorderLayout());
    Box localBox1 = Box.createVerticalBox();
    localBox1.add(Box.createVerticalStrut(20));
    JLabel localJLabel = new JLabel("You are playing the Cricet");
    localJLabel.setFont(Utils.getSmallFont());
    localBox1.add(localJLabel);
    localBox1.add(Box.createVerticalStrut(20));
    Box localBox2 = Box.createHorizontalBox();
    localJLabel = new JLabel("Round: ");
    localJLabel.setFont(Utils.getSmallFont());
    localBox2.add(localJLabel);
    localBox2.add(Box.createHorizontalStrut(10));
    this.roundField.setMaximumSize(new Dimension(25, 25));
    this.roundField.setFont(Utils.getSmallFont());
    this.roundField.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        GameCricetScoreBoard.this.round = Integer.parseInt(GameCricetScoreBoard.this.roundField.getText());
      }
    });
    localBox2.add(this.roundField);
    localBox1.add(localBox2);
    localBox2 = Box.createHorizontalBox();
    for (int j = 0; j < this.players; j++)
      localBox2.add(this.playersCounters[j]);
    localBox1.add(localBox2);
    localBox2 = Box.createVerticalBox();
    this.leftDarts.setFont(Utils.getSmallFont());
    this.info.setBackground(new JPanel().getBackground());
    this.info.setFont(Utils.getSmallFont());
    this.info.setEditable(false);
    localBox2.add(this.leftDarts);
    localBox2.add(this.info);
    localBox1.add(localBox2);
    add(localBox1);
    colorCounters();
  }

  public void newThrowEvent(ThrowEvent paramThrowEvent)
  {
    this.throwsNumber += 1;
    this.leftDarts.setText("Left Darts: " + (3 - this.throwsNumber));
    int i = paramThrowEvent.getNum();
    if (paramThrowEvent.isAllDarts())
    {
      this.throwsNumber = 3;
      i = 0;
    }
    if (i >= 15)
    {
      PlayerCounter localPlayerCounter1 = this.playersCounters[this.currentPlayer];
      int j = paramThrowEvent.getCount();
      int k = localPlayerCounter1.getNumCount(i);
      int m = 3 - k;
      if (m >= j)
      {
        localPlayerCounter1.addNumCount(i, j);
      }
      else
      {
        localPlayerCounter1.addNumCount(i, m);
        for (PlayerCounter localPlayerCounter2 : this.playersCounters)
          if ((localPlayerCounter2 != localPlayerCounter1) && (localPlayerCounter2.getNumCount(i) != 3))
            localPlayerCounter2.addPoints((j - m) * i);
      }
    }
    if (this.throwsNumber == 3)
    {
      if (this.currentPlayer == this.players - 1)
        incRound();
      changePlayer();
    }
  }

  public void clear()
  {
    this.throwsNumber = 0;
    this.currentPlayer = 0;
    this.round = 0;
    incRound();
    for (PlayerCounter localPlayerCounter : this.playersCounters)
      localPlayerCounter.clear();
    this.leftDarts.setText("Left Darts: 3");
    this.info.setText("");
    colorCounters();
  }

  private void changePlayer()
  {
    this.currentPlayer = ((this.currentPlayer + 1) % this.players);
    this.throwsNumber = 0;
    this.leftDarts.setText("Left Darts: 3");
    this.info.setText(getInfoString());
    colorCounters();
  }

  private String getInfoString()
  {
    return "";
  }

  private void incRound()
  {
    this.round += 1;
    this.roundField.setText(this.round + "");
  }

  public void setPlayers(int paramInt)
  {
    removeAll();
    this.players = paramInt;
    initComponents();
    this.leftDarts.setText("");
    clear();
  }

  private void colorCounters()
  {
    for (PlayerCounter localPlayerCounter : this.playersCounters)
      localPlayerCounter.lightLabels(this.playersCounters[this.currentPlayer] == localPlayerCounter);
  }

  private static class PlayerCounter extends JPanel
  {
    private static final long serialVersionUID = 1L;
    JTextField pointsField = new JTextField("0");
    JTextField playerName = new JTextField("name");
    JTextField[] labels = new JTextField[7];
        private int i;

    public PlayerCounter()
    {
      initComponents();
      setPreferredSize(new Dimension(200, 300));
    }

    private void initComponents()
    {
      setLayout(new GridLayout(9, 1));
      this.playerName.setFont(Utils.getSmallFont());
      add(this.playerName);
      this.pointsField.setFont(Utils.getNormalFont());
      add(this.pointsField);
      for (int i = 0; i < 6; i++)
      {
        JTextField localJTextField = new JTextField(20 - i + " ");
        localJTextField.setFont(Utils.getNormalFont());
        this.labels[i] = localJTextField;
        localJTextField.setOpaque(true);
        localJTextField.setBorder(BorderFactory.createEmptyBorder());
        localJTextField.setBackground(getBackground());
        add(localJTextField);
      }
      this.labels[6] = new JTextField("25 ");
      this.labels[6].setBackground(getBackground());
      this.labels[6].setBorder(BorderFactory.createEmptyBorder());
      this.labels[6].setOpaque(true);
      this.labels[6].setFont(Utils.getNormalFont());
      add(this.labels[6]);
    }

    public void lightLabels(boolean paramBoolean)
    {
      for (JTextField localJTextField : this.labels)
        if (paramBoolean)
          localJTextField.setBackground(Color.green);
        else
          localJTextField.setBackground(getBackground());
    }

    public int getNumCount(int paramInt)
    {
      int i = getIndex(paramInt);
      int j = this.labels[i].getText().lastIndexOf("x");
      if (j == -1)
        return 0;
      return j - 2;
    }

    public void addNumCount(int paramInt1, int paramInt2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < paramInt2; i++)
        localStringBuilder.append("x");
      i = getIndex(paramInt1);
      this.labels[i].setText(this.labels[i].getText() + localStringBuilder.toString());
    }

    public void addPoints(int paramInt)
    {
      this.pointsField.setText(Integer.parseInt(this.pointsField.getText()) + paramInt + "");
    }

    public void clear()
    {
      this.pointsField.setText("0");
      for (int i = 0; i < 6; i++)
        this.labels[i].setText(20 - i + " ");
      this.labels[6].setText("25 ");
      lightLabels(false);
    }

    private int getIndex(int paramInt)
    {
      if (paramInt == 25)
        return 6;
      return 20 - paramInt;
    }
  }
}

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.gui.GameCricetScoreBoard
 * JD-Core Version:    0.6.2
 */