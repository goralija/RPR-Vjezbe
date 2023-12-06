package ba.unsa.etf.rpr.tutorijal06;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculationSetup {
   public static String izracunaj(String izraz) {
      try {
          ScriptEngineManager manager = new ScriptEngineManager();
          ScriptEngine engine = manager.getEngineByName("JavaScript");
          Object result = engine.eval(izraz);
          return result.toString();
      } catch (ScriptException e) {
          e.printStackTrace();
          return "Greška";
      }
  }
}