package com.wupengchoy.mystudy.designpattern.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式：享元工厂(生产角色)，抽象享元角色，具体享元角色，非享元角色
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        //以围棋为例，黑白棋子除颜色以外都具备相同的属性
        //此处非享元角色为颜色，剩余未享元角色
        PiecesFactory factory = new PiecesFactory();
        Pieces pieces = factory.get(new PiecesColor("white"));
        pieces.show();
        pieces = factory.get(new PiecesColor("black"));
        pieces.show();
        //是否不再创建，使用现有对象
        pieces = factory.get(new PiecesColor("white"));
        pieces.show();
        pieces = factory.get(new PiecesColor("black"));
        pieces.show();
    }
}

//非享元角色
class PiecesColor {
    private String color;

    public PiecesColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        return this.color.hashCode();
    }

    @Override
    public boolean equals(Object color) {
        return this.color.equals(((PiecesColor) color).getColor());
    }
}

//抽象享元角色
abstract class Pieces {
    protected String shareName = "share";
    protected PiecesColor color;

    public Pieces(PiecesColor color) {
        this.color = color;
    }

    public String getShareName() {
        return shareName;
    }

    public PiecesColor getColor() {
        return color;
    }

    public void show() {
        System.out.println(this + "--shareName:" + shareName + "--color:" + color.getColor());
    }
}

//具体享元角色
class WhitePieces extends Pieces {
    public WhitePieces(PiecesColor color) {
        super(color);
    }
}

//具体享元角色
class BlackPieces extends Pieces {
    public BlackPieces(PiecesColor color) {
        super(color);
    }
}

//享元工厂
class PiecesFactory {
    //可以用任何形式储存
    Map<PiecesColor, Pieces> pieces = new HashMap<>(2);

    public Pieces get(PiecesColor color) {
        if (!pieces.containsKey(color)) {
            System.out.println("creating...");
            pieces.put(color, color.getColor().equals("white") ? new WhitePieces(color) : new BlackPieces(color));
        }
        return pieces.get(color);
    }
}


