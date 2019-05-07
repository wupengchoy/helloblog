package com.wupengchoy.mystudy.concurrent;

import java.util.Arrays;

/**
 * create by wupengchoy
 * 2019-04-24
 */
public class PhaserTest {
 public static void main(String[] args){
     int i=0;
     sou(i++);
     sou(i++);
 }
 static void sou(int i)
 {
     System.out.println(i);
 }
}