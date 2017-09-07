package es.savemywallet.com.utils;

import java.util.HashMap;
import java.util.Map;

public class Item{
   private String itemName; // I assume all items will have a name.
   private Map<String , Object> attributeMap ; // this will be a dynamic map.

   public Map<String, Object> getAttributeMap(){//getter for attribute map
       if( null == attributeMap)
          return new HashMap<String, Object>(); 
       return attributeMap ;

   }
   // you can synchronize this if needed
   public void setAttribute(String name, Object value){ 
       attributeMap.put(name, value);
   }

   public Object getAttribute(String name){ 
       return attributeMap.get(name);
   }
}
