package com.frontend;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class Student
{
   public static void main(String [] args)
   {
      Map<String, Account> map = AccountManagement.storageAccount;
      try
      {
         FileInputStream fis = new FileInputStream("hashmap.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         map = (HashMap) ois.readObject();
         ois.close();
         fis.close();
      }catch(IOException ioe)
      {
         ioe.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Class not found");
         c.printStackTrace();
         return;
      }
      System.out.println("Deserialized HashMap..");
      // Display content using Iterator
      Set set = map.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("key: "+ mentry.getKey() + " & Value: ");
         System.out.println(mentry.getValue());
      }
    }
}
