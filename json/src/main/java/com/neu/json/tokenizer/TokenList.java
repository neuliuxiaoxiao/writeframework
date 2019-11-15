package com.neu.json.tokenizer;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
/**
 * @Title TokenList
 * @Description 存储词法解析所得的token流
 * @Author liuxi58
 * @Date 2019/11/13 15:37
 **/


public class TokenList {
    private List<Token> tokens = new ArrayList<Token>();
    private int index = 0;

    public void add(Token token) {
        tokens.add(token);
    }

    public Token peek() {
        return index < tokens.size() ? tokens.get(index) : null;
    }

    public Token peekPrevious() {
        return index - 1 < 0 ? null : tokens.get(index - 2);
    }

    public Token next() {
        return tokens.get(index++);
    }

    public boolean hasMore() {
        return index < tokens.size();
    }

    @Override
    public String toString() {
        return "TokenList{" +
                "tokens=" + tokens +
                '}';
    }
}