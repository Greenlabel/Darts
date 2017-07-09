/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mate.dart.gui;

/**
 *
 * @author Panatha
 */

/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import mate.dart.DartBoardSubject;
/*     */ import mate.dart.ThrowEvent;
/*     */ import mate.dart.utils.Utils;
/*     */ 
/*     */ public class DartBoardPanel extends JPanel
/*     */   implements ActionListener, KeyListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  25 */   private JButton[] buttons = new JButton[63];
/*  26 */   private JTextField textField = new JTextField();
/*     */   private DartBoardSubject boardSubject;
/*  28 */   private JCheckBox allDartsCheckBox = new JCheckBox("all darts", true);
/*     */ 
/*     */   public DartBoardPanel(DartBoardSubject subject) {
/*  31 */     this();
/*  32 */     this.boardSubject = subject;
/*     */   }
/*     */ 
/*     */   public DartBoardPanel() {
/*  36 */     JPanel buttonsPannel = new JPanel(new GridLayout(21, 3));
/*     */ 
/*  38 */     JButton b = null;
/*     */ 
/*  40 */     b = createNewButton("25x1", 60);
/*  41 */     buttonsPannel.add(b);
/*  42 */     b = createNewButton("25x2", 61);
/*  43 */     buttonsPannel.add(b);
/*  44 */     b = createNewButton("OUT", 62);
/*  45 */     b.setBackground(Color.BLACK);
              b.setForeground(Color.GREEN);
/*  46 */     buttonsPannel.add(b);
/*     */ 
/*  48 */     for (int i = 19; i >= 0; i--) {
/*  49 */       for (int j = 1; j <= 3; j++) {
/*  50 */         b = createNewButton(i % 20 + 1 + "x" + j, i);
/*  51 */         this.buttons[i] = b;
/*  52 */         buttonsPannel.add(b);
/*     */       }
/*     */     }
/*     */ 
/*  56 */     setLayout(new BorderLayout());
/*  57 */     add(buttonsPannel, "Center");
/*     */ 
/*  59 */     Box box = Box.createHorizontalBox();
/*  60 */     box.add(this.allDartsCheckBox);
/*  61 */     box.add(this.textField);
/*  62 */     this.textField.setFont(Utils.getNormalFont());
/*  63 */     this.textField.addActionListener(this);
/*  64 */     this.textField.addKeyListener(this);
/*  65 */     add(box, "North");
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent e) {
/*  69 */     if ("OUT".equals(e.getActionCommand())) {
/*  70 */       ThrowEvent event = new ThrowEvent("0");
/*  71 */       this.boardSubject.notifyListeners(event);
/*  72 */     } else if ((e.getSource() instanceof JButton)) {
/*  73 */       String command = e.getActionCommand();
/*  74 */       ThrowEvent event = new ThrowEvent(command);
/*  75 */       this.boardSubject.notifyListeners(event);
/*  76 */     } else if ((e.getSource() instanceof JTextField)) {
/*  77 */       String text = this.textField.getText();
/*  78 */       if ("".equals(text)) {
/*  79 */         text = "0";
/*     */       }
/*  81 */       ThrowEvent event = new ThrowEvent(text, this.allDartsCheckBox.isSelected());
/*  82 */       this.boardSubject.notifyListeners(event);
/*  83 */       this.textField.setText("");
/*  84 */       this.allDartsCheckBox.setSelected(true);
/*     */     }
/*  86 */     this.textField.requestFocus();
/*     */   }
/*     */ 
/*     */   private JButton createNewButton(String name, int index) {
/*  90 */     JButton b = new JButton(name);
/*  91 */     b.addActionListener(this);
/*  92 */     this.buttons[index] = b;
/*  93 */     return b;
/*     */   }
/*     */ 
/*     */   public void setBoardSubject(DartBoardSubject boardSubject) {
/*  97 */     this.boardSubject = boardSubject;
/*     */   }
/*     */ 
/*     */   public void keyPressed(KeyEvent e) {
/* 101 */     String suffix = "x1";
/* 102 */     if (e.isAltDown())
/* 103 */       suffix = "x2";
/* 104 */     else if (e.isControlDown()) {
/* 105 */       suffix = "x3";
/*     */     }
/*     */ 
/* 108 */     String eventText = null;
/* 109 */     switch (e.getKeyCode()) { case 91:
/* 110 */       eventText = "25" + suffix; break;
/*     */     case 80:
/* 111 */       eventText = "20" + suffix; break;
/*     */     case 79:
/* 112 */       eventText = "19" + suffix; break;
/*     */     case 73:
/* 113 */       eventText = "18" + suffix; break;
/*     */     case 85:
/* 114 */       eventText = "17" + suffix; break;
/*     */     case 89:
/* 115 */       eventText = "16" + suffix; break;
/*     */     case 84:
/* 116 */       eventText = "15" + suffix; break;
/*     */     case 82:
/* 117 */       eventText = "14" + suffix; break;
/*     */     case 69:
/* 118 */       eventText = "13" + suffix; break;
/*     */     case 87:
/* 119 */       eventText = "12" + suffix; break;
/*     */     case 81:
/* 120 */       eventText = "11" + suffix; break;
/*     */     case 59:
/* 121 */       eventText = "10" + suffix; break;
/*     */     case 76:
/* 122 */       eventText = "9" + suffix; break;
/*     */     case 75:
/* 123 */       eventText = "8" + suffix; break;
/*     */     case 74:
/* 124 */       eventText = "7" + suffix; break;
/*     */     case 72:
/* 125 */       eventText = "6" + suffix; break;
/*     */     case 71:
/* 126 */       eventText = "5" + suffix; break;
/*     */     case 70:
/* 127 */       eventText = "4" + suffix; break;
/*     */     case 68:
/* 128 */       eventText = "3" + suffix; break;
/*     */     case 83:
/* 129 */       eventText = "2" + suffix; break;
/*     */     case 65:
/* 130 */       eventText = "1" + suffix; break;
/*     */     case 77:
/* 131 */       eventText = "0";
/*     */     case 60:
/*     */     case 61:
/*     */     case 62:
/*     */     case 63:
/*     */     case 64:
/*     */     case 66:
/*     */     case 67:
/*     */     case 78:
/*     */     case 86:
/*     */     case 88:
/* 134 */     case 90: } if ((eventText == null) || ("25x3".equals(eventText))) {
/* 135 */       return;
/*     */     }
/* 137 */     this.boardSubject.notifyListeners(new ThrowEvent(eventText));
/*     */   }
/*     */ 
/*     */   public void keyReleased(KeyEvent e) {
/*     */     try {
/* 142 */       Integer.parseInt(this.textField.getText());
/*     */     } catch (NumberFormatException nfe) {
/* 144 */       this.textField.setText("");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void keyTyped(KeyEvent e)
/*     */   {
/*     */   }
/*     */ }

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.gui.DartBoardPanel
 * JD-Core Version:    0.6.2
 */