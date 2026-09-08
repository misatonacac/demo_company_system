package com.example.todolist.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class OneZeroConverter implements AttributeConverter<Boolean, String> {
	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		return (attribute !=null && attribute) ? "1":"0";
	}
	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return "1".equals(dbData);
	}
}
