package com.eugenesumaryev.mygraphicsapp01;

/**
 * Created by eugenesumaryev on 12/27/17.
 */

public class BrushItem {

    Integer imageId;
    String someText;

    public BrushItem(Integer imageId, String someText){

        this.imageId=imageId;
        this.someText = someText;
    }

    public BrushItem(String someText){
        this.someText = someText;
    }

    public Integer getImageId(){
        return imageId;
    }

    public String getSomeText() {return someText;}
}
