package com.example.hyeokapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hyeokapplication.fragment.Fragment1;
import com.example.hyeokapplication.fragment.Fragment2;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  HashMap 사용법
         *  .put(Key,Value)
         *  .get(Key) ==> return Value
         */
        HashMap<String, String> student = new HashMap<String,String>();

        // put(key,String)
        student.put("First","hyeok");
        student.put("Second","beom");
        student.put("Third","seo");
        student.put("Forth","zzang");

        //key 값에 대응하는 String 값 return
        System.out.println(student.get("First"));
        System.out.println(student.get("Second"));
        System.out.println(student.get("Third"));
        System.out.println(student.get("Forths")); // null return ==> Forths Key 에 해당하는 String값이 없음

        // 해당 key의 값을 제거
        student.remove("First");
        // empty check, empty시 true, 아닐시 false return
        student.isEmpty();
        // 해당 value 또는 key를 포함하는지 확인 후 true/false 리턴
        student.containsValue("hyeok");
        student.containsKey("First");
        // hashmap 값 전부 제거
        student.clear();

        /**
         *  Fragment : 생성 시 Java class도 같이 생성, java파일에서 해당 xml 뷰들의 이벤트 처리 담당.
         *             activity의 framelayout에 필요로 하는 fragment를 replace(.xml), commit() ==> onCreateView()
         */
        Button btn1,btn2;
        btn1 = (Button)findViewById(R.id.btn_1);
        btn2 = (Button)findViewById(R.id.btn_2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.frame,fragment1);
                transaction.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.frame,fragment2);
                transaction.commit();
            }
        });

    }
}