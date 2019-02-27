package org.iscas.elastic.river;

import org.iscas.web.entity.BaseEntity;
import org.iscas.web.utils.StringUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class RiverRule {

  public String targetIndex;

  public String targetType;

  public IndexedTable sourceTable;

  public Set<IndexedField> fields = new HashSet<>();

  public Set<IndexedField> excludes = new HashSet<>();

  public static final String Default_Schema = "tcmdata";

  public static class IndexedTable {
    public Class<?> clazz;

    public String table;

    public String schema = Default_Schema;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof IndexedTable)) return false;
      IndexedTable that = (IndexedTable) o;
      return table == null ? (that.table == null) : table.equals(that.table);
    }

    @Override
    public int hashCode() {
      return table == null ? 0 : table.hashCode();
    }
  }

  public static class IndexedField {

    public String field;

    public String column;

    public String type;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof IndexedField)) return false;
      IndexedField that = (IndexedField) o;
      if (field == null) return that.field == null;
      if (!field.equals(that.field)) return false;

      return type == null ? that.type == null : type.equals(that.type);
    }

    @Override
    public int hashCode() {
      if (field == null) return 0;
      int result = field.hashCode();
      return type == null ? result : result ^ type.hashCode();
    }
  }

  public void parse(Class<?> clazz,String type) {
    parseEntity(clazz,type);

    while (clazz != null) {
      for (Field field : clazz.getDeclaredFields()) {
        field.setAccessible(true);
        parseField(field);
      }
      clazz = clazz.getSuperclass();
    }
  }

  private void parseEntity(Class<?> clazz, String type) {
    String className = clazz.getSimpleName();
    javax.persistence.Table annotation = (javax.persistence.Table) clazz.getAnnotation(javax.persistence.Table.class);

    IndexedTable target = new IndexedTable();
    target.clazz = clazz;

    if (annotation == null || annotation.name().isEmpty()) {
      target.table = StringUtils.camelToUnderline(className);
    } else {
      target.table = annotation.name();
    }

    targetIndex = target.table;
    targetType = type;
    sourceTable = target;
  }

  private void parseField(Field field) {
    javax.persistence.Column columnAnnotation = (javax.persistence.Column) field.getAnnotation(javax.persistence.Column.class);
    IndexedField target = new IndexedField();
    if (columnAnnotation == null || columnAnnotation.name().isEmpty()) {
      target.column = StringUtils.camelToUnderline(field.getName());
    } else {
      target.column = columnAnnotation.name();
    }

    target.field = target.column;
    target.type = parseType(field.getType());
    if(target.type != null) fields.add(target); // TODO 处理复合类型以及一对多、多对一关系
  }

  private String parseType(Class<?> fieldClass) {
    String typeName = fieldClass.getSimpleName();
    switch (typeName) {
      case "int":
      case "Integer":
        return "integer";
      case "float":
      case "Float":
        return "float";
      case "double":
      case "Double":
        return "double";
      case "long":
      case "Long":
        return "long";
      case "byte":
      case "Byte":
        return "byte";
      case "short":
      case "Short":
        return "short";
      case "boolean":
      case "Boolean":
        return "boolean";
      case "String":
        return "text";
      case "Date":
        return "date";
      default:
        return null;
    }
  }

  public static RiverRule extractRule(Class<?> entity,String type) {
    RiverRule rule = new RiverRule();
    rule.parse(entity,type);
    return rule;
  }

  public static void main(String[] args) throws NoSuchFieldException {
    Class<?> clazz = BaseEntity.class.getDeclaredField("updateAt").getType();
    System.out.println(clazz.getSimpleName());
  }
}