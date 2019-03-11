package com.cc.generator.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author HeChunXiao
 * @date 2019-01-11 10:28
 * @desc
 */
public class ColumnTypeUtil {

    private static final Map<String, Integer> dataType = new HashMap<>();

    static {
        dataType.put("bit",-7);
        dataType.put("tinyint",-6);
        dataType.put("smallint",5);
        dataType.put("integer",4);
        dataType.put("int",4);
        dataType.put("bigint",-5);
        dataType.put("float",6);
        dataType.put("real",7);
        dataType.put("double",8);
        dataType.put("numeric",2);
        dataType.put("decimal",3);
        dataType.put("char",1);
        dataType.put("varchar",12);
        dataType.put("longvarchar",-1);
        dataType.put("date",91);
        dataType.put("time",92);
        dataType.put("datetime",91);
        dataType.put("timestamp", 93);
        dataType.put("binary",-2);
        dataType.put("varbinary",-3);
        dataType.put("longvarbinary",-4);
        dataType.put("null",0);
        dataType.put("other",1111);
        dataType.put("java_object",2000);
        dataType.put("distinct",2001);
        dataType.put("struct",2002);
        dataType.put("array",2003);
        dataType.put("blob",2004);
        dataType.put("longblob",2004);
        dataType.put("clob",2005);
        dataType.put("ref",2006);
        dataType.put("datalink",70);
        dataType.put("boolean",16);
        dataType.put("rowid",-8);
        dataType.put("nchar",-15);
        dataType.put("nvarchar",-9);
        dataType.put("longnvarchar",-16);
        dataType.put("nclob",2001);
        dataType.put("sqlxml",2009);
        dataType.put("ref_cursor",2012);
        dataType.put("time_with_timezone",2013);
        dataType.put("timestamp_with_timezone",2014);
    }

    private static Map<String, Integer> getDataType() {
        return dataType;
    }

    public static Integer getDataType(String dataType) throws Exception {
        Integer type = getDataType().get(dataType.toLowerCase());
        if (Objects.isNull(type)){
            //throw new SipingException("没有找到该类型：" + dataType);
            throw  new Exception("没有找到该类型：" + dataType);
        }
        return type;
    }
}
