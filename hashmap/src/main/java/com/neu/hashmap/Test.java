package com.neu.hashmap;

/**
 * @Title Test
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 20:04
 **/
public class Test {

     public static void main(String[] args) {
         Map<String,String> map = new HashMap<String, String>();
         for (int i = 0; i < 500; i++) {
             map.put("key"+i,"value"+i);
         }
         for (int i = 0; i < 500; i++) {
             System.out.println(i+"==="+map.get("key"+i));
         }
      }
}
