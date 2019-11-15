package com.neu.json.tokenizer;

/**
 * @Title Token
 * @Description 存储对应类型的字面量
 * @Author liuxi58
 * @Date 2019/11/13 15:36
 **/

public class Token {
    private TokenType tokenType;
    private String value;

    public Token(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", value='" + value + '\'' +
                '}';
    }
}