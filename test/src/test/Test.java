package test;

import java.util.*;

/**
 * @author single
 * @date 2018/4/5.
 */
public class Test {
    public void test() {
        //url= "/api/list"   count = "5,10,20"    time="201809383"

        Map<String, String> term = new HashMap<>();
        term.put("url", "/api/list");
        term.put("count", "5,10,20");
        term.put("time", "201809383");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(term);

        Set<String> set = term.keySet();
        for(String str: set){
            term.get(str);
        }

        //foreach
        for(Map<String, String> ll: list){
            System.out.println(ll.get("url"));
        }

        //for
        for(int i = 0; i < list.size(); i ++){
            Map<String, String> map = list.get(i);
            System.out.println(map.get("url"));
        }
        System.out.println(term.get("url"));
    }
}
