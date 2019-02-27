package org.iscas.elastic.admin;

import java.util.ArrayList;
import java.util.List;

public class RiverGenerator {

  public static String generate(RiverRule rule) {
    StringBuilder sb = new StringBuilder("[[rule]]\n");
    sb.append("schema = \"").append(rule.sourceTable.schema).append("\"\n");
    sb.append("table= \"").append(rule.sourceTable.table).append("\"\n");
    sb.append("index= \"").append(rule.targetIndex).append("\"\n");
    sb.append("type= \"").append(rule.targetType).append("\"\n");

    if(!rule.excludes.isEmpty()) {
      sb.append("\n").append("filter = [");
      List<String> cols = new ArrayList<>();
      for(RiverRule.IndexedField f : rule.fields) {
        if(rule.excludes.contains(f)) continue;
        cols.add("\""+f.column+"\"");
      }

      sb.append(String.join(",",cols));
      sb.append("]").append("\n");
    }

    return sb.toString();
  }

  public static void main(String[] args) throws ClassNotFoundException {
    System.out.println("Input : the full generated class name");
    if(args.length < 1) {
      System.exit(1);
    }
    
    for(int i=0;i<args.length;i++) {
	    String className = args[i];
	
	    Class<?> clazz = Class.forName(className);
	    String [] classPath = clazz.getName().split("\\.");
	    String ruleType = classPath[classPath.length-1];
	    ruleType = ruleType.toLowerCase();
	    RiverRule rule = RiverRule.extractRule(clazz, ruleType);
	
	    System.out.println(generate(rule));
    }
  }
}
