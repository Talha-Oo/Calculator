package org.ioopm.calculator.ast;

public class Vars extends Command {
  private static final Vars theInstance = new Vars();
  private Vars() {}

  /**
   * Returns the singleton instance of Vars.
   * @return the single Vars instance
  */
  public static Vars instance() 
  {
    return theInstance;
  }
}
