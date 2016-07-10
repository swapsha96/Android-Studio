package in.swapsha96.glide;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img0 = (ImageView) findViewById(R.id.img0);
        ImageView img1 = (ImageView) findViewById(R.id.img1);
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        ImageView img3 = (ImageView) findViewById(R.id.img3);
        TextView textView = (TextView) findViewById(R.id.textView);

//        Glide.with(MainActivity.this).load("http://i.memeful.com/media/post/PdWDkVw_700wa_0.gif").asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.mipmap.ic_launcher).into(img0);
//        Glide.with(MainActivity.this).load("http://i.memeful.com/media/post/QRykOkw_700wa_0.gif").asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.mipmap.ic_launcher).into(img1);
//        Glide.with(MainActivity.this).load("http://i.memeful.com/media/post/BRkjB6M_700wa_0.gif").asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.mipmap.ic_launcher).into(img2);
//        Glide.with(MainActivity.this).load("http://i.memeful.com/media/post/lMzzGBM_700wa_0.gif").asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.mipmap.ic_launcher).into(img3);

        File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() + "/Wallpaper");
        wallpaperDirectory.mkdirs();
        textView.setText(Environment.getExternalStorageDirectory() + "/Wallpaper");

    }
}
