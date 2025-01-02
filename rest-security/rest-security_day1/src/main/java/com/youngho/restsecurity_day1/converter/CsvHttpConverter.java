package com.youngho.restsecurity_day1.converter;

import com.youngho.restsecurity_day1.entity.member.Member;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class CsvHttpConverter extends AbstractHttpMessageConverter<List<Member>> {

    public CsvHttpConverter() {
        super(new MediaType("text", "csv", StandardCharsets.UTF_8));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    protected List<Member> readInternal(Class<? extends List<Member>> clazz,
        HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return List.of();
    }

    @Override
    protected void writeInternal(List<Member> member, HttpOutputMessage outputMessage)
        throws IOException, HttpMessageNotWritableException {
        OutputStreamWriter writer = new OutputStreamWriter(outputMessage.getBody(), StandardCharsets.UTF_8);

        writer.write("id, name, class, locale\n");
        for (Member mem : member) {
            String line = String.join(",",
                mem.getId(),
                mem.getName(),
                mem.getClazz(),
                String.valueOf(mem.getLocale()));
            writer.write(line + "\n");
        }
        writer.flush();
    }
}
