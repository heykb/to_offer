package com.zhu;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        double[] startPoint = {0,1.5};
        double[] endPoint = {45,7.5};
        System.out.println("startPoint:("+startPoint[0]+", "+startPoint[1]+")");
        System.out.println("endPoint:("+endPoint[0]+", "+endPoint[1]+")");
        System.out.println("打印经历的格子与距离");
        List<String> list = new ArrayList<>();
        double width = 5;
        double height = 3;
        double totalHeight = endPoint[1]-startPoint[1];
        double totalWidth = endPoint[0]-startPoint[0];
        double height2wid = totalWidth/totalHeight;
        double wid2height = totalHeight/totalWidth;
        double 斜边  = Math.sqrt(totalHeight*totalHeight+totalWidth*totalWidth);
        double width2length = 斜边 / totalWidth;
        double heith2length = 斜边 / totalHeight;
        double cur_height = startPoint[1];
        int i=(int) startPoint[0]/5;
        int j=(int) startPoint[0]/3;
MAIN:   while(i<= (int)endPoint[0]/5  &&  j< (int)endPoint[0]/3){
            //System.out.println(cur_height);
            int throw_x_counts = (int)(cur_height * height2wid/width);
            double cur_width = (cur_height * height2wid)%width;

            for(int a=0;a<throw_x_counts;i++,a++){
                if(i>=9) break MAIN;
                list.add("("+i+","+j+"):"+5*width2length);
            }
            if(cur_width*width2length != 0){
                list.add("("+ (i) +","+ (j++) +"):"+cur_width*width2length);
            }
            int throw_y_counts = (int)((5-cur_width)*wid2height/height);
            cur_height = ((5-cur_width)*wid2height)%height;
            for(;j<throw_y_counts;j++){
                list.add("("+i+","+j+"):"+3*heith2length);
            }
            if(cur_height*heith2length != 0 ){
                list.add("("+ (i++) +","+ (j) +"):"+cur_height*heith2length);
            }
            cur_height = 3-cur_height;
        }
        for(String s: list){
            System.out.println(s);
        }
    }
}
