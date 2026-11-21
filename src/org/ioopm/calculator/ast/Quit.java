package org.ioopm.calculator.ast;

public class Quit extends Command
{
  private static final Quit theInstance = new Quit();
  private Quit() {}

  /**
   * Returns the singleton instance of Quit.
   * @return the single Quit instance
   */
  public static Quit instance() 
  {
    return theInstance;
  }  
}
