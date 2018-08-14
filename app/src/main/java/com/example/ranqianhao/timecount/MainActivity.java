package com.example.ranqianhao.timecount;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Chronometer.OnChronometerTickListener, View.OnClickListener {
    private Chronometer chronometer;
    private Button start,cue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        chronometer = (Chronometer) findViewById(R.id.timeR);
        start = (Button) findViewById(R.id.action);
        cue = (Button) findViewById(R.id.cue);
        chronometer.setOnChronometerTickListener(this);
        start.setOnClickListener(this);
        cue.setOnClickListener(this);
    }


    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if(time.equals("00:00")){
            Toast.makeText(MainActivity.this,"时间到了~",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.action:
                chronometer.start();// 开始计时
                break;
            case R.id.cue:
                chronometer.stop();// 停止计时
                break;
        }
    }
}

//    //        获取计时器组件
//        ch=(Chronometer)findViewById(R.id.chronometer);
////        获取开始组件
//        start = (Button)findViewById(R.id.action);
//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ch.setBase(SystemClock.elapsedRealtime());
//                ch.start();
//            }
//        });
//
////        end=(Button)findViewById(R.id.cue);
////        end.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                ch.stop();
////            }
////        });
//
//    }
//
//
//}
