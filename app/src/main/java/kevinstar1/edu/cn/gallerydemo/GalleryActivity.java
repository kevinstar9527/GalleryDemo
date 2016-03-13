package kevinstar1.edu.cn.gallerydemo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private Gallery gallery;
    private ArrayList<Bitmap> mImgs;
    private static final int imgCount=3;
    private static ImageView[] imgDots;//三个小圆点的图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_xml);

        imgDots=new ImageView[]{(ImageView) findViewById(R.id.dot_1),(ImageView) findViewById(R.id.dot_2),(ImageView) findViewById(R.id.dot_3)};

        mImgs=new ArrayList<Bitmap>();
        Resources resources=getResources();

        Bitmap img[]={BitmapFactory.decodeResource(resources, R.drawable.bg_page_01),

                BitmapFactory.decodeResource(resources, R.drawable.bg_page_02),
                BitmapFactory.decodeResource(resources, R.drawable.bg_page_03),
                BitmapFactory.decodeResource(resources, R.drawable.bg_page_04),
                BitmapFactory.decodeResource(resources, R.drawable.bg_page_05)

        };

        for(int i=0;i<img.length;i++) {
            mImgs.add(img[i]);
        }
        gallery=(Gallery)findViewById(R.id.imgGallery);
        gallery.setAdapter(new ImageAdapter(this, mImgs) {
        });
        gallery.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }

    private static class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            int pos=position%imgCount;



            imgDots[pos].setImageResource(R.drawable.ic_dot_focused);
            if(pos>0){
                imgDots[pos-1].setImageResource(R.drawable.ic_dot_normal);
            }
            if(pos>(imgCount-1)){
                imgDots[pos+1].setImageResource(R.drawable.ic_dot_normal);
            }
            if(pos==0){
                imgDots[imgCount-1].setImageResource(R.drawable.ic_dot_normal);
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
