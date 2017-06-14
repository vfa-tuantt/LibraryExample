package library.example.com.librarytutorial;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tranthanhtuan on 2017/06/14.
 */

public class MyView extends LinearLayout {

    MyViewInterFace mCallBack;
    public MyView(Context context) {
        super(context);
        initialize(context);
    }

    public void setCallBack(MyViewInterFace cb) {
        mCallBack = cb;
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }
    private void initialize(final Context context){
        inflate(context, R.layout.my_view, this);
        TextView tv = (TextView) this.findViewById(R.id.tvClick);
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setMessage("Write your message here.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                if(mCallBack != null){
                                    mCallBack.callBackClick(true);
                                }
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                if(mCallBack != null){
                                    mCallBack.callBackClick(false);
                                }
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });
    }
}