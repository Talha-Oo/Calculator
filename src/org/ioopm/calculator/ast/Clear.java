package org.ioopm.calculator.ast;

public class Clear extends Command
{
  private static final Clear theInstance = new Clear();
  private Clear() {}

  /**
   * Returns the singleton instance of Clear.
   * @return the single Clear instance
  */
  public static Clear instance() 
  {
    return theInstance;
  }  
}