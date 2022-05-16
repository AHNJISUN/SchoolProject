package com.example.recyclerview_exam;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   RecyclerView recyclerView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
      //테스트 데이터
      String[] names = {"이명지", "김인보", "나잘란", "진달래", "황금복",
            "최전선", "마진가", "백김치", "오리온", "조이풀"};
      String[] phone_num = {"3000-1331", "2009-1432", "1223-5543", "1122-3433", "2400-3000",
            "2255-0091", "2910-4223", "1218-7658", "9030-7788", "1985-1000"};
      int[] picture = {1, 2, 1, 2, 2, 1, 2, 1, 2, 1};  //1 또는 2로 가정

      ArrayList<Phone> phone_data = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
         Phone phone = new Phone(names[i], phone_num[i], picture[i]);
         phone_data.add(phone);
      }
      recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
      recyclerView.setAdapter(new MyRecyclerViewAdapter(phone_data));
      recyclerView.addItemDecoration(new MyItemDecoration(phone_data));
      recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
         @Override
         public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child=recyclerView.findChildViewUnder(e.getX(), e.getY());
            int position = recyclerView.getChildAdapterPosition(child);
            //Toast.makeText(getApplicationContext(), phone_data.get(position).getName(), Toast.LENGTH_LONG).show();
            return false;
         }

         @Override
         public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

         }

         @Override
         public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

         }
      });
   }
}

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
   ArrayList<Phone> data;

   public MyRecyclerViewAdapter(ArrayList<Phone> data) {
      this.data = data;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.getNameView().setText(data.get(position).getName());
      holder.getPhone_numView().setText(data.get(position).getPhone_num());
      if (data.get(position).getPicture() == 1)
         holder.getPictureView().setImageResource(R.drawable.ic_person_1);
      else
         holder.getPictureView().setImageResource(R.drawable.ic_person_2);
   }

   @Override
   public int getItemCount() {
      return data.size();
   }

   public class ViewHolder extends RecyclerView.ViewHolder {
      private TextView nameView;
      private TextView phone_numView;
      private ImageView pictureView;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);
         this.nameView = (TextView) itemView.findViewById(R.id.nameView);
         this.phone_numView = (TextView) itemView.findViewById(R.id.phoneView);
         this.pictureView = (ImageView) itemView.findViewById(R.id.imageView);

         nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int position = getAdapterPosition();
               Toast.makeText(itemView.getContext(), data.get(position).getPhone_num(), Toast.LENGTH_LONG).show();
            }
         });
      }

      public TextView getNameView() {
         return nameView;
      }

      public TextView getPhone_numView() {
         return phone_numView;
      }

      public ImageView getPictureView() {
         return pictureView;
      }
   }
}

class MyItemDecoration extends RecyclerView.ItemDecoration {
   ArrayList<Phone> phone_data;

   public MyItemDecoration(ArrayList<Phone> phone_data) {
      this.phone_data = phone_data;
   }

   @Override
   public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
      super.onDrawOver(c, parent, state);
  /*   int width = parent.getWidth();
      int height = parent.getHeight();
      Drawable drawable = ResourcesCompat.getDrawable(parent.getResources(), R.drawable.icon_search, null);
      int drWidth = drawable.getIntrinsicWidth();
      int drHeight = drawable.getIntrinsicHeight();*/
      int x = 800; /*width/2 -drWidth/2;*/
      int y = 100; /*height/2-drHeight/2;*/
      c.drawBitmap(BitmapFactory.decodeResource(parent.getResources(), R.drawable.icon_search), x, y, null);
   }

   @Override
   public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
      super.getItemOffsets(outRect, view, parent, state);
      int position = parent.getChildAdapterPosition(view);
      if ((position + 1) % 2 == 0)
         outRect.set(30, 10, 30, 100);
      else
         outRect.set(30, 10, 30, 10);
      view.setBackgroundColor(parent.getResources().getColor(R.color.white));
   }
}
