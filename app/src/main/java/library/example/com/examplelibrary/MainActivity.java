package library.example.com.examplelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import library.example.com.librarytutorial.MainActivityTest;
import library.example.com.librarytutorial.MyView;
import library.example.com.librarytutorial.MyViewInterFace;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView v = new MyView(this);
        setContentView(v);
        v.setCallBack(new MyViewInterFace() {
            @Override
            public void callBackClick(boolean isAction) {
                if(isAction){
                    finish();
                }else{
                    startActivity(new Intent(MainActivity.this, MainActivityTest.class));
                }
            }
        });

    }
}
