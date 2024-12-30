package com.youngho.restsecurity_day1.util;

import java.util.Objects;
import org.springframework.data.domain.PageRequest;

public class PageableUtil {

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_SIZE = 3;
    private static final int MAX_SIZE = 10;

    public static PageRequest pageRequest(String pageParam, String sizeParam) {

        if (Objects.isNull(pageParam) || Objects.isNull(sizeParam) || pageParam.isEmpty() || sizeParam.isEmpty()) {
            return PageRequest.of(DEFAULT_PAGE, DEFAULT_SIZE);
        }

        int page;
        int size;

        page = (Integer.parseInt(pageParam) >= 0) ? Integer.parseInt(pageParam) : DEFAULT_PAGE;
        size = (Integer.parseInt(sizeParam) >= 0) ? Math.min(Integer.parseInt(sizeParam), MAX_SIZE) : DEFAULT_SIZE;

        return PageRequest.of(page, size);
    }
}
