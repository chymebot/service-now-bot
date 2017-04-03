package com.chyme.servicenow.gen.servicenow.snobject;


import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class SNOBJECT
{
	public static String version = "";
	public static final String SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	public static final String DEVICE_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss.SSS";
	
	HashMap<String, Object> values = new HashMap<String, Object>();
	
	public abstract String getKey();
	public abstract String getObjectName();
	
	public Object getValue(String field)
	{
		return values.get(field);
	}
	
	public void setValue(String field, Object value)
	{
		if(value!=null)
			values.put(field, value);
		else
			values.remove(field);
	}
	
	public String getJson() {
		JsonObject jsonObject = new JsonObject();

		for (Entry<String, Object> entry : values.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof String && !((String) value).isEmpty())
				jsonObject.addProperty(entry.getKey(), (String) entry.getValue());
			else if (value instanceof Boolean)
				jsonObject.addProperty(entry.getKey(), (Boolean) entry.getValue());
			else if (value instanceof Number)
				jsonObject.addProperty(entry.getKey(), (Number) entry.getValue());
			else if (value instanceof Date)
				jsonObject.addProperty(entry.getKey(), ((Date) entry.getValue()).toString());
		}

		return new Gson().toJson(jsonObject);
	}
	
	public void load(String json) {
		try {
			values.clear();
			JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);

			for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
				if (entry.getValue() == null || entry.getValue() instanceof JsonNull)
					continue;

				Method method = null;
				try {
					method = this.getClass().getMethod("get" + entry.getKey().toUpperCase());

					if (method.getReturnType() == String.class) {
						if (entry.getValue().isJsonPrimitive() && entry.getValue().getAsString() != null
								&& !"".equals(entry.getValue().getAsString())) {

							values.put(entry.getKey().toString(), entry.getValue().getAsString());
						} else {
							values.put(entry.getKey().toString(),
									entry.getValue().getAsJsonObject().get("display_value").getAsString());
						}

					} else if (method.getReturnType() == Boolean.class) {
						if (entry.getValue().isJsonPrimitive()) {
							values.put(entry.getKey().toString(), entry.getValue().getAsBoolean());
						} else {
							values.put(entry.getKey().toString(),
									entry.getValue().getAsJsonObject().get("display_value").getAsBoolean());
						}

					} else if (method.getReturnType() == Date.class) {
						if (entry.getValue().isJsonPrimitive()) {
							values.put(entry.getKey().toString(), Date.valueOf(entry.getValue().getAsString()));
						} else {
							values.put(entry.getKey().toString(), Date
									.valueOf(entry.getValue().getAsJsonObject().get("display_value").getAsString()));
						}

					} else if (method.getReturnType() == Timestamp.class) {
						SimpleDateFormat sdf = new SimpleDateFormat(SERVER_DATE_FORMAT);
						java.util.Date date = sdf.parse(entry.getValue().getAsString());
						Timestamp timestamp = new Timestamp(date.getTime());
						values.put(entry.getKey().toString(), timestamp);
					} else if (method.getReturnType() == Integer.class) {
						if (entry.getValue().isJsonPrimitive()) {
							values.put(entry.getKey().toString(), entry.getValue().getAsInt());
						} else {

							try {
								values.put(entry.getKey().toString(),
										entry.getValue().getAsJsonObject().get("display_value").getAsInt());
							} catch (Exception e) {
								values.put(entry.getKey().toString(),
										entry.getValue().getAsJsonObject().get("value").getAsInt());
							}
						}

					} else if (method.getReturnType() == Long.class) {
						if (entry.getValue().isJsonPrimitive()) {
							values.put(entry.getKey().toString(), entry.getValue().getAsLong());
						} else {
							values.put(entry.getKey().toString(),
									entry.getValue().getAsJsonObject().get("display_value").getAsLong());
						}

					} else if (method.getReturnType() == Double.class) {
						if (entry.getValue().isJsonPrimitive()) {
							values.put(entry.getKey().toString(), entry.getValue().getAsDouble());
						} else {
							values.put(entry.getKey().toString(),
									entry.getValue().getAsJsonObject().get("display_value").getAsDouble());
						}

					} else if (method.getReturnType() == Float.class) {
						if (entry.getValue().isJsonPrimitive()) {
							values.put(entry.getKey().toString(), entry.getValue().getAsFloat());
						} else {
							values.put(entry.getKey().toString(),
									entry.getValue().getAsJsonObject().get("display_value").getAsFloat());
						}

					} else if (method.getReturnType() == BigDecimal.class) {
						if (entry.getValue().isJsonPrimitive()) {
							values.put(entry.getKey().toString(), entry.getValue().getAsBigDecimal());
						} else {
							values.put(entry.getKey().toString(),
									entry.getValue().getAsJsonObject().get("display_value").getAsBigDecimal());
						}

					} else {
						if (entry.getValue().isJsonPrimitive()) {
							values.put(entry.getKey().toString(), entry.getValue().getAsString());
						} else {
							values.put(entry.getKey().toString(),
									entry.getValue().getAsJsonObject().get("display_value").getAsString());
						}

					}
				} catch (Exception e) {
				}
			}
		} catch (Exception ex) {

		}
	}
}
