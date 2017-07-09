

package mate.dart;

/**
 *
 * @author Panatha
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DartBoardSubject
{
  List<ThrowEventListener> listenerList = new ArrayList();
  Map<String, Integer> nameToIndexMap = new HashMap();

  public void notifyListeners(ThrowEvent paramThrowEvent)
  {
    Iterator localIterator = this.listenerList.iterator();
    while (localIterator.hasNext())
    {
      ThrowEventListener localThrowEventListener = (ThrowEventListener)localIterator.next();
      localThrowEventListener.newThrowEvent(paramThrowEvent);
    }
  }

  public void addListener(ThrowEventListener paramThrowEventListener, String paramString)
  {
    this.nameToIndexMap.put(paramString, Integer.valueOf(this.listenerList.size()));
    this.listenerList.add(paramThrowEventListener);
  }

  public void removeListener(String paramString)
  {
    this.listenerList.remove(((Integer)this.nameToIndexMap.get(paramString)).intValue());
    this.nameToIndexMap.remove(paramString);
  }
}

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.DartBoardSubject
 * JD-Core Version:    0.6.2
 */