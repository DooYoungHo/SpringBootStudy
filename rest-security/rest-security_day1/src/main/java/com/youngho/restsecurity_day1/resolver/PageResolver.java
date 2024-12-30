package com.youngho.restsecurity_day1.resolver;

import com.youngho.restsecurity_day1.request.PageRequester;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PageResolver implements HandlerMethodArgumentResolver {

    public PageResolver() {

    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Pageable.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String pageParam = webRequest.getParameter("page");
        String sizeParam = webRequest.getParameter("size");

        int page = (pageParam != null) ? Integer.parseInt(pageParam) : 0;
        int size = (sizeParam != null) ? Math.min(Integer.parseInt(sizeParam), PageRequester.MAX_SIZE) : 5;

        return new PageRequester(page, size);
    }
}
