
package mate.dart;

/**
 *
 * @author Panatha
 */
/* 
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.CardLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.SwingUtilities;
/*     */ import mate.dart.gui.DartBoardPanel;
/*     */ import mate.dart.gui.GameCricetScoreBoard;
/*     */ import mate.dart.gui.GameKillerScoreBoard;
/*     */ import mate.dart.gui.GameX01ScoreBoard;
/*     */ import mate.dart.utils.Configuration;
/*     */  
/*     */ public class JDartScorer extends JFrame
/*     */   implements ActionListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private DartBoardPanel boardPanel;
/*     */   private JPanel gameCardPanel;
/*  31 */   private AbstractGame[] games = new AbstractGame[4];
/*     */   private DartBoardSubject subject;
/*     */   private int curentGame;
/*     */ 
/*     */   public JDartScorer()
/*     */   {
/*  38 */     initComponents();
/*  39 */     initMenuBar();
/*     */ 
/*  41 */     AbstractGame g = this.games[this.curentGame];
/*  42 */     this.subject = new DartBoardSubject();
/*  43 */     this.subject.addListener(g, g.getName());
/*  44 */     this.boardPanel.setBoardSubject(this.subject);
/*  45 */     pack();
/*     */   }
/*     */ 
/*     */   private void initComponents() {
/*  49 */     setLayout(new BorderLayout());
/*  50 */     this.boardPanel = new DartBoardPanel();
/*  51 */     add(this.boardPanel, "West");
/*     */ 
/*  53 */     this.gameCardPanel = new JPanel(new CardLayout());
/*     */ 
/*  55 */     Box box = Box.createHorizontalBox();
/*  56 */     box.add(Box.createHorizontalStrut(5));
/*  57 */     box.add(this.gameCardPanel);
/*  58 */     add(box, "Center");
/*     */ 
/*  60 */     initGames(2);
/*  61 */     for (AbstractGame game : this.games) {
/*  62 */       this.gameCardPanel.add(game.getName(), game);
/*     */     }
/*  64 */     ((CardLayout)this.gameCardPanel.getLayout()).show(this.gameCardPanel, 
/*  65 */       this.games[this.curentGame].getName());
/*     */   }
/*     */ 
/*     */   private void initGames(int players)
/*     */   {
/*  70 */     this.games[0] = new GameX01ScoreBoard(301);
/*  71 */     this.games[1] = new GameX01ScoreBoard(501);
/*  72 */     this.games[2] = new GameCricetScoreBoard();
/*  73 */     this.games[3] = new GameKillerScoreBoard();
/*     */ 
/*  75 */     for (AbstractGame game : this.games) {
/*  76 */       game.setPlayers(players);
/*     */     }
/*  78 */     this.curentGame = 0;
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/*  83 */     if ("Ar.Paiktwn".equals(e.getActionCommand())) {
/*  84 */       String response = JOptionPane.showInputDialog(getRootPane(), "Epelekse arithmo paiktwn");
/* 
/*     */    try {
/*  86 */         int p = Integer.parseInt(response);
/*  87 */         if ((p < 0) || (p > 10)) return;
/*  88 */         for (AbstractGame game : this.games)
/*  89 */           game.setPlayers(p);
/*     */       }
/*     */       catch (NumberFormatException nfe)
/*     */       {
/*  93 */         return;
/*     */       }
/*  95 */       pack();
/*  96 */       return;
/*     */     }
/*     */ 
/*  99 */     if ((Configuration.warnOnChangingGame()) && 
/* 100 */       (2 == JOptionPane.showConfirmDialog(
/* 101 */       getRootPane(), "To paixnidi tha xathei. ?", 
/* 102 */       "Eisai sigouros", 2)))
/*     */     {
/* 104 */       return;
/*     */     }
/*     */ 
/* 108 */     if ("New".equals(e.getActionCommand())) {
/* 109 */       this.games[this.curentGame].clear();
/* 110 */       return;
/*     */     }
/*     */ 
/* 113 */     String newGameName = e.getActionCommand();
/* 114 */     String currentGameName = this.games[this.curentGame].getName();
/*     */ 
/* 116 */     if (newGameName.equals(currentGameName)) return;
/*     */ 
/* 118 */     this.subject.removeListener(currentGameName);
/* 119 */     this.curentGame = getGameIndex(newGameName);
/* 120 */     this.games[this.curentGame].clear();
/* 121 */     this.subject.addListener(this.games[this.curentGame], newGameName);
/* 122 */     ((CardLayout)this.gameCardPanel.getLayout()).show(this.gameCardPanel, newGameName);
/*     */   }
/*     */ 
/*     */   private void initMenuBar()
/*     */   {
/* 130 */     JMenuBar menuBar = new JMenuBar();
/*     */ 
/* 132 */     JMenu menu = new JMenu("Game");
/* 133 */     menu.getAccessibleContext().setAccessibleDescription("Epelekse Paixnidi");
/* 134 */     menu.setMnemonic(71);
/* 135 */     menuBar.add(menu);
/*     */ 
/* 137 */     JMenuItem menuItem = new JMenuItem("New", 78);
/* 138 */     menuItem.addActionListener(this);
/* 139 */     menuItem.setAccelerator(KeyStroke.getKeyStroke(
/* 140 */       78, 2));
/* 141 */     menu.add(menuItem);
/* 142 */     menu.addSeparator();
/*     */ 
/* 144 */     for (AbstractGame game : this.games) {
/* 145 */       menuItem = new JMenuItem(game.getName());
/* 146 */       menuItem.setMnemonic(game.getName().getBytes()[0]);
/* 147 */       menuItem.addActionListener(this);
/* 148 */       menu.add(menuItem);
/*     */     }
/* 150 */     menu.addSeparator();
/* 151 */     menuItem = new JMenuItem("Ar.Paiktwn", 80);
/* 152 */     menuItem.addActionListener(this);
/* 153 */     menu.add(menuItem);
/*     */ 
/* 155 */     menu = new JMenu("Help");
/* 156 */     menu.getAccessibleContext().setAccessibleDescription("Help");
/* 157 */     menu.setMnemonic(72);
/* 158 */     menu.setEnabled(true);
/* 159 */     menuBar.add(menu);
/*     */ 
/* 161 */     menuItem = new JMenuItem("Odigies gia na paikseis", 80);
/* 162 */     menuItem.addActionListener(this);
/* 163 */     menu.add(menuItem);
/*     */ 
/* 165 */     menuItem = new JMenuItem("About", 65);
/* 166 */     menuItem.addActionListener(this);
/* 167 */     menu.add(menuItem);
/*     */ 
/* 169 */     setJMenuBar(menuBar);
/*     */   }
/*     */ 
/*     */   private int getGameIndex(String name) {
/* 173 */     for (int i = 0; i < this.games.length; i++) {
/* 174 */       if (this.games[i].getName().equals(name)) {
/* 175 */         return i;
/*     */       }
/*     */     }
/* 178 */     throw new IllegalArgumentException("De mporei na vrethei paixnidi me onoma: " + name + ".");
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 182 */     SwingUtilities.invokeLater(new Runnable() {
/*     */       public void run() {
/* 184 */         JDartScorer lvqViewer = new JDartScorer();
/* 185 */         lvqViewer.setTitle("TAMPLO SCORE GIA VELAKIA STOU GEORGIOU ");
/* 186 */         lvqViewer.setDefaultCloseOperation(3);
/* 187 */         lvqViewer.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.JDartScorer
 * JD-Core Version:    0.6.2
 */