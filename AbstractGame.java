

package mate.dart;

/**
 *
 * @author Panatha
 */


import javax.swing.JPanel;

public abstract class AbstractGame extends JPanel
  implements ThrowEventListener
{
  public abstract void clear();

  @Override
  public abstract String getName();

  public abstract void setPlayers(int paramInt);
}

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.AbstractGame
 * JD-Core Version:    0.6.2
 */