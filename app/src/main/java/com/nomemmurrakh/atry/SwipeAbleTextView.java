package com.nomemmurrakh.atry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SwipeAbleTextView extends androidx.appcompat.widget.AppCompatTextView implements GestureDetector.OnGestureListener{

    private static final int SWIPE_THRESHOLD = 100;
    private static final int VELOCITY_THRESHOLD = 100;

    private GestureDetector gestureDetector = new GestureDetector(getContext(), this);
    private Callback mCallback;

    public SwipeAbleTextView(@NonNull Context context) {
        super(context);
    }

    public SwipeAbleTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeAbleTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface Callback{
        void onReceive(String text);
    }

    public void setCallback(Callback callback){
        this.mCallback = callback;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
        boolean flag = false;
        float diffX = moveEvent.getX() - downEvent.getX();
        float diffY = moveEvent.getY() - downEvent.getY();
        if (Math.abs(diffX) > Math.abs(diffY))
        {
            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    //Right
                    if (mCallback != null){
                        mCallback.onReceive(this.getText().toString());
                    }
                }
                else{
                    //Left

                }
                flag = true;
            }
        }
        else
        {
            if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    //Bottom

                }
                else{
                    //Top

                }
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
