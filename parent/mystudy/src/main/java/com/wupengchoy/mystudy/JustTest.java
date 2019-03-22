package com.wupengchoy.mystudy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JustTest {
    public static void main(String[] args)
    {
//        Map<String,String> map = new HashMap<>();
//        map.put("1",null);
//        map.put("2","2");
//        map.put("3",null);
//        map.put("4","4");
//
//       List<String> list = map.values().stream().filter(str->str!=null).collect(Collectors.toList());
//
//       list.forEach(str-> System.out.println(str));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月")));

    }
}
