
package mate.dart.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mate.dart.AbstractGame;
import mate.dart.ThrowEvent;
import mate.dart.utils.Utils;

public class GameKillerScoreBoard extends AbstractGame
{
  private static final long serialVersionUID = 3926113017222630148L;
  final String name = "Killer";
  private static int currentNumber;
  static Vector<Integer> amountOfHited = new Vector();
  private int numberOfPlayers = 2;
  int currentPlayer = 0;
  int throwsNumber = 0;
  PlayerCounter[] players = new PlayerCounter[this.numberOfPlayers];
  int round = 1;
  JTextField textRound = new JTextField("1");
  JLabel leftDarts = new JLabel("Left datrs : 3");

  public GameKillerScoreBoard()
  {
    currentNumber = nextNumber();
    initComponents();
  }

  private void initComponents()
  {
    setLayout(new BorderLayout());
    this.players = new PlayerCounter[this.numberOfPlayers];
    for (int i = 0; i < this.numberOfPlayers; i++)
      this.players[i] = new PlayerCounter();
    Box localBox1 = Box.createVerticalBox();
    localBox1.add(Box.createVerticalStrut(20));
    JLabel localJLabel = new JLabel("You are playing the Killer");
    localJLabel.setFont(Utils.getSmallFont());
    localBox1.add(localJLabel);
    localBox1.add(Box.createVerticalStrut(20));
    localJLabel = new JLabel("Round: ");
    localJLabel.setFont(Utils.getSmallFont());
    this.textRound.setMaximumSize(new Dimension(30, 30));
    this.textRound.setFont(Utils.getSmallFont());
    this.textRound.setHorizontalAlignment(4);
    localJLabel.setLabelFor(this.textRound);
    Box localBox2 = Box.createHorizontalBox();
    localBox2.add(localJLabel);
    localBox2.add(this.textRound);
    localBox1.add(localBox2);
    localBox2 = Box.createHorizontalBox();
    for (int j = 0; j < this.numberOfPlayers; j++)
      localBox2.add(this.players[j]);
    localBox1.add(localBox2);
    localBox1.add(Box.createVerticalStrut(120));
    this.leftDarts.setFont(Utils.getSmallFont());
    localBox1.add(this.leftDarts);
    add(localBox1);
    colorCounters();
  }

  private boolean isAllClosed()
  {
    for (PlayerCounter localPlayerCounter : this.players)
      if (localPlayerCounter.getCount() != 3)
        return false;
    return true;
  }

  public void clear()
  {
    this.throwsNumber = 0;
    this.currentPlayer = 0;
    this.round = 0;
    amountOfHited.clear();
    currentNumber = nextNumber();
    incRound();
    for (PlayerCounter localPlayerCounter : this.players)
      localPlayerCounter.clear();
    this.leftDarts.setText("Left Darts: 3");
    colorCounters();
  }

  public String getName()
  {
    return "Killer";
  }

  public void setPlayers(int paramInt)
  {
    removeAll();
    this.numberOfPlayers = paramInt;
    initComponents();
  }

  public void newThrowEvent(ThrowEvent paramThrowEvent)
  {
    this.throwsNumber += 1;
    this.leftDarts.setText("Left darts :" + (3 - this.throwsNumber));
    PlayerCounter localPlayerCounter1 = this.players[this.currentPlayer];
    int i = paramThrowEvent.getNum();
    int j = paramThrowEvent.getCount();
    int k = localPlayerCounter1.getCount();
    int m = 3 - k;
    if (i == currentNumber)
    {
      if (m > j)
      {
        localPlayerCounter1.addCount(j);
      }
      else
      {
        localPlayerCounter1.addCount(m);
       
        if (isAllClosed())
        {
          currentNumber = nextNumber();
          if (currentNumber != 0)
            for (PlayerCounter localPlayerCounter2 : this.players)
              localPlayerCounter2.nextNumber(currentNumber);
        }
        else
        {
          for (PlayerCounter localPlayerCounter2 : this.players)
            if ((localPlayerCounter2 != localPlayerCounter1) && (localPlayerCounter2.getCount() != 3))
              localPlayerCounter2.addPoints((j - m) * currentNumber);
        }
      }
    }
    else
      localPlayerCounter1.addPoints(i * j);
    if (this.throwsNumber == 3)
    {
      if (this.currentPlayer == this.numberOfPlayers - 1)
        incRound();
      changePlayer();
    }
  }

  private void incRound()
  {
    this.round = Integer.parseInt(this.textRound.getText());
    this.round += 1;
    this.textRound.setText(this.round + "");
  }

  private void changePlayer()
  {
    this.currentPlayer = ((this.currentPlayer + 1) % this.numberOfPlayers);
    this.throwsNumber = 0;
    this.leftDarts.setText("Left Darts: 3");
    colorCounters();
  }

  private void colorCounters()
  {
    for (PlayerCounter localPlayerCounter : this.players)
      localPlayerCounter.lightLabels(this.players[this.currentPlayer] == localPlayerCounter);
  }

  private int nextNumber()
  {
    if (amountOfHited.size() < 7)
    {
      int i;
      while (amountOfHited.contains(Integer.valueOf(i = randomNumber())));
      amountOfHited.add(Integer.valueOf(i));
      return i;
    }
    return 0;
  }

  private int randomNumber()
  {
    Random localRandom = new Random();
    int i = localRandom.nextInt(21);
    if (i == 0)
      i = 25;
    return i;
  }

  private static class PlayerCounter extends JPanel
  {
    private static final long serialVersionUID = 1L;
    JTextField pointsField = new JTextField("0");
    JTextField playerName = new JTextField("name");
    JTextField[] labels = new JTextField[7];

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
      for (int i = 0; i < 7; i++)
        if (i == 0)
        {
          this.labels[i] = new JTextField(String.valueOf(numberToString(GameKillerScoreBoard.currentNumber)));
          this.labels[i].setBackground(getBackground());
          this.labels[i].setBorder(BorderFactory.createEmptyBorder());
          this.labels[i].setOpaque(true);
          this.labels[i].setFont(Utils.getNormalFont());
          add(this.labels[i]);
        }
        else
        {
          JTextField localJTextField = new JTextField("");
          localJTextField.setFont(Utils.getNormalFont());
          this.labels[i] = localJTextField;
          localJTextField.setOpaque(true);
          localJTextField.setBorder(BorderFactory.createEmptyBorder());
          localJTextField.setBackground(getBackground());
          add(localJTextField);
        }
    }

    private void nextNumber(int paramInt)
    {
      this.labels[(GameKillerScoreBoard.amountOfHited.size() - 1)].setText(numberToString(paramInt));
    }

    private String numberToString(int paramInt)
    {
      int i = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      if (i - 10 < 0)
        localStringBuilder.append(" ");
      return localStringBuilder.toString();
    }

    public void lightLabels(boolean paramBoolean)
    {
      for (JTextField localJTextField : this.labels)
        if (paramBoolean)
          localJTextField.setBackground(Color.green);
        else
          localJTextField.setBackground(getBackground());
    }

    public int getCount()
    {
      int i = this.labels[(GameKillerScoreBoard.amountOfHited.size() - 1)].getText().lastIndexOf("x");
      if (i == -1)
        return 0;
      return i - 1;
    }

    public void addCount(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = 0; i < paramInt; i++)
        localStringBuilder.append("x");
        int i = GameKillerScoreBoard.amountOfHited.size() - 1;
      this.labels[i].setText(this.labels[i].getText() + localStringBuilder.toString());
    }

    public void addPoints(int paramInt)
    {
      this.pointsField.setText(Integer.parseInt(this.pointsField.getText()) + paramInt + "");
    }

    public void clear()
    {
      this.pointsField.setText("0");
      for (int i = 0; i < 7; i++)
        if (i == 0)
          this.labels[i].setText(String.valueOf(numberToString(GameKillerScoreBoard.currentNumber)));
        else
          this.labels[i].setText("");
      lightLabels(false);
    }
  }
}

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.gui.GameKillerScoreBoard
 * JD-Core Version:    0.6.2
 */