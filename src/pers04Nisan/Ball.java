package pers04Nisan;

import java.awt.*;

public class Ball extends Canvas{
    int x,y,r;
    int vX,vY;
    int w,h;
    Ball(int w,int h,int r){
        this.x =w/2;
        this.y = h/2;
        this.w = w;
        this.h = h;
        this.r = r;
        while (true) {
            double rand = Math.random() * Math.PI * 2;
            System.out.println(rand);
            int v = (int) (Math.random() * 10);
            this.vX = (int) (v * Math.cos(rand));
            this.vY = (int) (v * Math.sin(rand));
            if ((vY > 1 || vY < -1) && (vX > 1 || vX < -1)) {
                break;
            }
        }
    }
    public void updateBallPosition(){
        int marginTop = getDistance(this.x,0);
        int marginBottom = getDistance(this.x,h);
        int marginLeft = getDistance(0,this.y);
        int marginRight = getDistance(w,this.y);
        System.out.println(marginBottom);
        if(marginTop <= r || marginBottom <=r){
            this.vY  *= -1;
        }
        if(marginLeft <= r || marginRight <= r){
            this.vX *= -1;
        }
        this.x += this.vX;
        this.y += this.vY;
    }
    public void drawBall(Graphics p){
        updateBallPosition();
        p.setColor(Color.red);
        p.fillOval(x-r,y-r,2*r,2*r);
        p.setColor(Color.blue);
        p.drawLine(x,y,x+(vX*5),y+(vY*5));
    }
    public int getDistance(int x,int y){
        return (int)(Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2)));
    }
}
