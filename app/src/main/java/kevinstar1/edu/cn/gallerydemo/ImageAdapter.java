package kevinstar1.edu.cn.gallerydemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/13.
 */
public class ImageAdapter extends BaseAdapter{
     private Context context;
    //图片的集合
     private List<Bitmap> mImgs=new ArrayList<Bitmap>();
     private static final int IMAGEHEIGHT=400;

    public ImageAdapter(Context context,ArrayList<Bitmap> mImgs){


        this.context=context;
        this.mImgs=mImgs;


    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imgView=new ImageView(context);
        imgView.setImageBitmap(mImgs.get(position % mImgs.size()));
        imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgView.setLayoutParams( new Gallery.LayoutParams(Gallery.LayoutParams.FILL_PARENT, IMAGEHEIGHT));

        //画廊四周需不需要背景或是边框等元素
        RelativeLayout borderImg=new RelativeLayout(context);
        borderImg.setPadding(0, 0, 0, 0);
        borderImg.addView(imgView);
        return borderImg;

    }
}
