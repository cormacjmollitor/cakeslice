package com.example.chris.caketest;

import android.graphics.*;
import java.lang.*;
import android.os.Environment;
import java.lang.Object;
import java.io.*;
/**
 * Created by cormacmollitor on 2018-01-13.
 */

public class Circle{

    Circle(float radius, int slices){
        Bitmap bitmap = Bitmap.createBitmap((int)radius, (int)radius, Bitmap.Config.ARGB_8888);
        float middle_screen_x = 40;
        float middle_screen_y = 40;
        Paint color = new Paint();
        Canvas c = new Canvas(bitmap);

        c.drawCircle(middle_screen_x, middle_screen_y, radius, color);

        for(float i = 0; i < slices; i++){
            float angle = (float)((i/slices)*2.0*Math.PI);
            float x = (float)(radius*Math.cos(angle));
            float y = (float)(radius*Math.sin(angle));

            c.drawLine(middle_screen_x, middle_screen_y, x, y, color);
        }


            /*System.out.println("SHIT");
            System.out.println(Environment.getExternalStorageDirectory().getPath());
            File image = new File(Environment.getExternalStorageDirectory().getPath() + "/image.png");
            image.createNewFile();
            OutputStream stream = new FileOutputStream(image, false);
            File image = new File("/sdcard/dammit.png");
            image.createNewFile();
            OutputStream stream = new FileOutputStream(image, false);
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, stream);
            stream.close();*/

            
            File filepath = Environment.getExternalStorageDirectory();

            File dir = new File(filepath.getAbsolutePath() + "/save_img_example");
            dir.mkdirs();

            File file = new File(dir, "cake.png");
        try {
            OutputStream output = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
            output.flush();
            output.close();

        }catch(Exception exception){
            //Log.d("aaaa","bbbb");
            System.out.println("Anus");
            System.out.println(exception);
        }
    }


}

/*
public class CustomDrawableView {
    private ShapeDrawable circle;
    private ShapeDrawable lines;

    public CustomDrawableView(int numSlices) {
        //super(context);

        int x = 10;
        int y = 10;
        int width = 300;
        int height = 300;

        circle = new ShapeDrawable(new OvalShape());
        // If the color isn't set, the shape uses black as the default.
        circle.getPaint().setColor(0xff74AC23);
        // If the bounds aren't set, the shape can't be drawn.
        circle.setBounds(x, y, x + width, y + height);

        for(int i = 0; i < numSlices; i++){

        }
    }

    protected void onDraw(Canvas canvas) {
        circle.draw(canvas);
    }
}
*/