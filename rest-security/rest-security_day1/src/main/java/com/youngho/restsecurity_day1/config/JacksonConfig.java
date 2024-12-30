package com.youngho.restsecurity_day1.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class JacksonConfig {

    public static class FormatterSerializer extends StdSerializer<LocalDate> {

        private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        public FormatterSerializer() {
            super(LocalDate.class);
        }

        @Override
        public void serialize(LocalDate localDate, JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(localDate.format(formatter));
        }
    }
}
