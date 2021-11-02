package com.example.subject_test;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScheduleActivity extends AppCompatActivity {

    String[] week_1;
    String[] week_2;
    String[] week_3;
    String[] week_4;
    String[] week_5;

    int[] week_p;
    int[] week_wh;
    int[] time_p;
    int[] time_wh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity);

        String packName = ScheduleActivity.this.getPackageName(); // 패키지명

        for (int i =1; i<6; i++)
        {
            int id = getResources().getIdentifier("week_"+i,"id",packName);
            TextView textView = (TextView) findViewById(id);
            //textView.setTextSize(standardSize_X);
            //textView.setWidth(standardSize_X);
            //textView.setHeight(standardSize_Y);
        }
        for (int i =1; i<10; i++)
        {
            int id = getResources().getIdentifier("time_"+i,"id",packName);
            TextView textView = (TextView) findViewById(id);
            //textView.setWidth(standardSize_X);
            //textView.setHeight(standardSize_Y);
        }
    }

    //화면 비율 조정 부분 ==================================
    public Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return  size;
    }
    int standardSize_X, standardSize_Y;
    float density;

    public void getStandardSize() {
        Point ScreenSize = getScreenSize(this);
        density  = getResources().getDisplayMetrics().density;

        standardSize_X = (int) (ScreenSize.x)*100;
        standardSize_Y = (int) (ScreenSize.y)*100;
    }


    //뷰의 위치
    //ㅇ---
    //| 뷰 |     ㅇ가 위치좌표값
    // ----
    public int[] getLocation(View view)
    {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return location;
    }

    //뷰의 넓이 높이
    public int[] getWH(View view)
    {
        int width;
        int height;
        int[] WH = new int[2];
        width = view.getWidth();
        height = view.getHeight();
        WH[0] = width;
        WH[1] = height;
        return WH;
    }
    //시간 -> Length 전환 (1:30 즉 90분을 넣었을때 적절한 높이(*height*)로 환산해줌 ::15분 단위)
    //(기준 뷰,시간)
    public int timeToLength (View view, int time)
    {
        int per = time/15;
        int result;
        result = view.getHeight() / per;
        return result;
    }


    //시간표 추가하기 ::작성중::
    public void addSchedule(View week, View time, int length)
    {
        TextView newSchedule = new TextView(this);
    }
}


















