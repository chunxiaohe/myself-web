package com.sipingsoft.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 实体类中日期格式化工具类(通过在get方法上添加注解进行使用)
 * @author HeChunXiao
 * @since 2018-12-18 下午 2:51
 */
public class FormatDateUtil  extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        SimpleDateFormat sdf=
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr= null;
        try {
            dateStr = sdf.format(sdf.parse(value));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        gen.writeString(dateStr);
    }
}
