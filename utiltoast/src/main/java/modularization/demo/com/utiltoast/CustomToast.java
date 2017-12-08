package modularization.demo.com.utiltoast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * CustomToast
 */
public class CustomToast {
    public static final double LENGTH_SHORT = 2000;
    public static final double LENGTH_LONG = 3000;

    private static final int MESSAGE_TIMEOUT = 2;
    private WindowManager wdm;
    private double time;
    private View mView;
    private WindowManager.LayoutParams params;
    private WorkerHandler mHandler;
    private TextView mContent;
    private Context mContext;

    private CustomToast(Context context, String text, double time) {
        mContext = context;
        wdm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mHandler = new WorkerHandler();

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        //mView = toast.getView();

        mView = LayoutInflater.from(context).inflate(R.layout.view_custom_toast, null);
        mContent = (TextView) mView.findViewById(R.id.toast_content);
        mContent.setText(text);

        toast.setView(mView);

        params = new WindowManager.LayoutParams();
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.windowAnimations = R.style.custom_toast_anim_view;
        params.type = WindowManager.LayoutParams.TYPE_PHONE;
        params.setTitle("Toast");
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.y = 320;

        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;

        this.time = time;
    }

    public static CustomToast makeText(Context context, String text, double time) {
        return new CustomToast(context, text, time);
    }

    public static CustomToast makeText(Context context, CharSequence msg, double time) {
        return new CustomToast(context, String.valueOf(msg), time);
    }

    public static CustomToast makeText(Context context, int textRes, double time) {
        return makeText(context, context.getString(textRes), time);
    }

    public void show() {
        try {
            if (null != wdm && null != mView) {
                wdm.addView(mView, params);
                mHandler.sendEmptyMessageDelayed(MESSAGE_TIMEOUT, (long) (time));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showError(){
        try {
            if (mContent != null){
                mContent.setBackground(mContext.getResources().getDrawable(R.drawable.custom_error_bg));
            }
            if (null != wdm && null != mView) {
                wdm.addView(mView, params);
                mHandler.sendEmptyMessageDelayed(MESSAGE_TIMEOUT, (long) (time));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void showSuccess(){
        try {
            if (mContent != null){
                mContent.setBackground(mContext.getResources().getDrawable(R.drawable.custom_success_bg));
            }
            if (null != wdm && null != mView) {
                wdm.addView(mView, params);
                mHandler.sendEmptyMessageDelayed(MESSAGE_TIMEOUT, (long) (time));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void cancel() {
        try {
            if (null != wdm && null != mView) {
                if (mView.isAttachedToWindow()){
                    wdm.removeView(mView);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class WorkerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_TIMEOUT:
                    cancel();
                    break;
            }
        }
    }

}
