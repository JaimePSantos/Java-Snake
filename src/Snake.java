import com.sun.source.tree.UsesTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Snake {
    private List<Pair<Integer,Integer>> body;
    private Pair<Integer,Integer> direction;

    public Snake(){
        this.body = new ArrayList();
        this.direction = new Pair();
    }
    public Snake(List<Pair<Integer,Integer>> newBody, Pair<Integer,Integer> newDirection ){
        this.body = newBody;
        this.direction = newDirection;
    }

    public boolean contains(int x, int y){
        for(Pair pair : this.body){
            if(pair.getX().equals(x) && pair.getY().equals(y)){
                return true;
            }
        }
        return false;

    }

    public void initSnake(int x ,int y){
        this.grow(x,y);
        this.grow(x+1,y);
    }

    public void grow(int x, int y){
        Pair pos = new Pair(x,y);
        this.body.add(pos);
    }

    public void removeLast(){
        this.body.remove(this.body.get(this.body.size()-1));
    }

    public void takeStep(Integer x, Integer y){
        Pair step = new Pair(x,y);
        this.removeLast();
        this.body.add(0,step);
    }

    public void setDirection(int x, int y){
        Pair newDirection = new Pair(x,y);
        this.direction = newDirection;
    }

    public Pair head(){
        return this.body.get(0);
    }

    public List<Pair<Integer,Integer>> getBody(){
        List<Pair<Integer,Integer>> noHead = this.body;
        noHead.remove(0);
        return noHead;
    }

    public void move(String input){
        if(input.equals("d")){
            this.direction.setY(1);
            this.direction.setX(0);
        }else if(input.equals("w")){
            this.direction.setY(0);
            this.direction.setX(-1);

        }else if(input.equals("aw")){
            this.direction.setY(-1);
            this.direction.setX(0);

        }else if(input.equals("s")){
            this.direction.setY(0);
            this.direction.setX(1);
        }
        int x = this.direction.getX();
        int y = this.direction.getY();
        int j = this.body.get(0).getX();
        int k = this.body.get(0).getY();
        this.takeStep(x+j,y+k);
    }
    public String toString(){
        String coords="";
        for(Pair pair : this.body){
            coords += "(" + pair.getX() + ","+pair.getY()+")\n";
        }
        return coords;
    }


}
