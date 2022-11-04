package com.tc.hutoolTest.convert;

import cn.hutool.core.convert.Converter;

public class CustomConverter implements Converter<String> {
    @Override
    public String convert(Object value, String defaultValue) throws IllegalArgumentException {
        return "custom:" + value.toString();
    }
}
