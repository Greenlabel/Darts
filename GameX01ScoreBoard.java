package mate.dart.gui;
 
 import java.awt.Color;
 import java.awt.Dimension;
 import java.awt.GridLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import javax.swing.Box;
 import javax.swing.JLabel;
 import javax.swing.JOptionPane;
 import javax.swing.JPanel;
 import javax.swing.JTextArea;
 import javax.swing.JTextField;
 import mate.dart.AbstractGame;
 import mate.dart.ThrowEvent;
 import mate.dart.utils.Utils;
 
    public class GameX01ScoreBoard extends AbstractGame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   int game = 301;
/*  25 */   private int players = 2;
/*  26 */   int round = 1;
/*  27 */   int currentPlayer = 0;
/*  28 */   int throwsNumber = 0;
/*     */ 
/*  30 */   String beforeRound = "";
/*     */ 
/*  32 */   JTextField[] playersCounters = null;
/*  33 */   JLabel[] playersThrows = null;
/*  34 */   JTextField roundField = new JTextField("1");
/*  35 */   JLabel leftDarts = new JLabel("Left Darts: 3");
/*  36 */   JTextArea info = new JTextArea(" ");
/*     */ 
/*     */   public GameX01ScoreBoard(int game) {
/*  39 */     this.game = game;
/*  40 */     initComponents();
/*     */   }
/*     */ 
/*     */   public GameX01ScoreBoard() {
/*  44 */     this(301);
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  48 */     return Integer.toString(this.game);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  53 */     this.playersCounters = new JTextField[this.players];
/*  54 */     this.playersThrows = new JLabel[this.players];
/*  55 */     for (int i = 0; i < this.players; i++) {
/*  56 */       this.playersCounters[i] = new JTextField(this.game);
/*  57 */       this.playersCounters[i].setFont(Utils.getBigFont());
/*  58 */       this.playersCounters[i].addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/*  60 */           GameX01ScoreBoard.this.info.setText(GameX01ScoreBoard.this.getInfoString());
/*     */         }
/*     */       });
/*  63 */       this.playersThrows[i] = new JLabel("");
/*  64 */       this.playersThrows[i].setFont(Utils.getSmallFont());
/*     */     }
/*     */ 
/*  67 */     GridLayout layout = new GridLayout(4, 1);
/*  68 */     setLayout(layout);
/*     */ 
/*  71 */     JLabel label = new JLabel("Exete epileksei na paikseis : " + this.game);
              label.setForeground(Color.BLUE);
/*  72 */     label.setFont(Utils.getSmallFont());
/*  73 */     add(label);
/*     */ 
/*  75 */     Box box = Box.createHorizontalBox();
/*  76 */     label = new JLabel("Round: ");
/*  77 */     label.setFont(Utils.getSmallFont());
/*  78 */     box.add(label);
/*  79 */     box.add(Box.createHorizontalStrut(10));
/*  80 */     this.roundField.setMaximumSize(new Dimension(50, 50));
/*  81 */     this.roundField.setFont(Utils.getSmallFont());
/*  82 */     this.roundField.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/*  84 */         GameX01ScoreBoard.this.round = Integer.parseInt(GameX01ScoreBoard.this.roundField.getText());
/*     */       }
/*     */     });
/*  87 */     box.add(this.roundField);
/*  88 */     add(box);
/*     */ 
/*  90 */     box = Box.createHorizontalBox();
/*  91 */     for (int i = 0; i < this.players; i++) {
/*  92 */       Box vBox = Box.createVerticalBox();
/*  93 */       vBox.add(this.playersCounters[i]);
/*  94 */       vBox.add(this.playersThrows[i]);
/*  95 */       box.add(vBox);
/*     */     }
/*  97 */     add(box);
/*     */ 
/*  99 */     box = Box.createVerticalBox();
/* 100 */     this.leftDarts.setFont(Utils.getSmallFont());
/* 101 */     this.info.setBackground(new JPanel().getBackground());
/* 102 */     this.info.setFont(Utils.getSmallFont());
/* 103 */     this.info.setEditable(false);
/* 104 */     JPanel p = new JPanel();
/* 105 */     p.add(this.leftDarts);
/* 106 */     box.add(p);
/* 107 */     box.add(this.info);
/* 108 */     add(box);
/* 109 */     this.leftDarts.setText("Left Darts: 3");
/* 110 */     colorCounters();
/*     */   }
/*     */ 
/*     */   public void newThrowEvent(ThrowEvent event) {
/* 114 */     this.throwsNumber += 1;
/* 115 */     this.leftDarts.setText("Left Darts: " + (3 - this.throwsNumber));
/* 116 */     if (this.throwsNumber == 1) {
/* 117 */       this.beforeRound = this.playersCounters[this.currentPlayer].getText();
/*     */     }
/* 119 */     if (this.throwsNumber == 1)
/* 120 */       this.playersThrows[this.currentPlayer].setText(Integer.toString(event.getPointsCount()));
/*     */     else {
/* 122 */       this.playersThrows[this.currentPlayer].setText(
/* 123 */         this.playersThrows[this.currentPlayer].getText() + "  " + 
/* 124 */         event.getPointsCount());
/*     */     }
/* 126 */     if (event.isAllDarts()) this.throwsNumber = 3;
/*     */ 
/* 128 */     int diff = Integer.parseInt(this.playersCounters[this.currentPlayer].getText()) - 
/* 129 */       event.getPointsCount();
/*     */ 
/* 131 */     if (diff > 1) {
/* 132 */       this.playersCounters[this.currentPlayer].setText(Integer.toString(diff));
/* 133 */       this.info.setText(getInfoString());
/* 134 */     } else if (diff == 0) {
/* 135 */       if (event.isDouble()) {
/* 136 */         JOptionPane.showMessageDialog(getRootPane(), "Ante geia Gataki . Se eskisa !");
/* 137 */         clear();
/* 138 */         return;
/*     */       }
/* 140 */       this.playersCounters[this.currentPlayer].setText(this.beforeRound);
/* 141 */       this.throwsNumber = 3;
/*     */     }
/* 143 */     else if (diff <= 1) {
/* 144 */       this.playersCounters[this.currentPlayer].setText(this.beforeRound);
/* 145 */       this.throwsNumber = 3;
/*     */     }
/*     */ 
/* 148 */     if (this.throwsNumber == 3) {
/* 149 */       if (this.currentPlayer == this.players - 1) incRound();
/* 150 */       changePlayer();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void clear() {
/* 155 */     this.throwsNumber = 0;
/* 156 */     this.currentPlayer = 0;
/* 157 */     this.round = 0;
/* 158 */     incRound();
/* 159 */     for (JTextField f : this.playersCounters) {
/* 160 */       f.setText(Integer.toString(this.game));
/*     */     }
/* 162 */     for (JLabel l : this.playersThrows) {
/* 163 */       l.setText(" ");
/*     */     }
/* 165 */     this.leftDarts.setText("Left Darts: 3");
/* 166 */     this.info.setText("");
/* 167 */     colorCounters();
/*     */   }
/*     */ 
/*     */   private void changePlayer() {
/* 171 */     this.currentPlayer = ((this.currentPlayer + 1) % this.players);
/* 172 */     this.throwsNumber = 0;
/* 173 */     this.leftDarts.setText("Left Darts: 3");
/* 174 */     this.info.setText(getInfoString());
/* 175 */     colorCounters();
/*     */   }
/*     */ 
/*     */   private String getInfoString() {
/* 179 */     String[] points = Utils.getCheckout(this.playersCounters[this.currentPlayer].getText());
/* 180 */     if (points == null) {
/* 181 */       return "";
/*     */     }
/* 183 */     StringBuilder builder = new StringBuilder();
/* 184 */     for (String s : points) {
/* 185 */       builder.append("\n").append(s);
/*     */     }
/* 187 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   public void setPlayers(int players) {
/* 191 */     removeAll();
/* 192 */     this.players = players;
/* 193 */     initComponents();
/* 194 */     this.leftDarts.setText("");
/* 195 */     clear();
/*     */   } 
/*     */ 
/*     */   private void incRound() {
/* 199 */     this.round += 1;
/* 200 */     this.roundField.setText(Integer.toString(this.round));
/*     */   }
/*     */ 
/*     */   private void colorCounters() {
/* 204 */     for (JTextField f : this.playersCounters)
/* 205 */       if (this.playersCounters[this.currentPlayer] == f)
/* 206 */         f.setBackground(Color.GREEN);
/*     */       else
/* 208 */         f.setBackground(Color.YELLOW);
/*     */   }
/*     */ }

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.gui.GameX01ScoreBoard
 * JD-Core Version:    0.6.2
 */