package com.neu.json.style;

import com.neu.json.exception.JsonTypeException;
import com.neu.json.util.FormatUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Title JsonArray
 * @Description 数组形式
 * @Author liuxi58
 * @Date 2019/11/13 15:39
 **/
public class JsonArray {
    private List list = new ArrayList();

    public void add(Object obj) {
        list.add(obj);
    }

    public Object get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public JsonObject getJsonObject(int index) {
        Object obj = list.get(index);
        if (!(obj instanceof JsonObject)) {
            throw new JsonTypeException("Type of value is not JsonObject");
        }

        return (JsonObject) obj;
    }

    public JsonArray getJsonArray(int index) {
        Object obj = list.get(index);
        if (!(obj instanceof JsonArray)) {
            throw new JsonTypeException("Type of value is not JsonArray");
        }

        return (JsonArray) obj;
    }

    @Override
    public String toString() {
        return FormatUtil.beautify(this);
    }

    public Iterator iterator() {
        return list.iterator();
    }
}
