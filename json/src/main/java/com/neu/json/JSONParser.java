package com.neu.json;

import com.neu.json.parser.Parser;
import com.neu.json.tokenizer.ReaderChar;
import com.neu.json.tokenizer.TokenList;
import com.neu.json.tokenizer.Tokenizer;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Title JSONParser
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 15:44
 **/
public class JSONParser {
    private Tokenizer tokenizer = new Tokenizer();

    private Parser parser = new Parser();

    public Object fromJSON(String json) throws IOException {
        ReaderChar charReader = new ReaderChar(new StringReader(json));
        TokenList tokens = tokenizer.getTokenStream(charReader);
        return parser.parse(tokens);
    }
}
