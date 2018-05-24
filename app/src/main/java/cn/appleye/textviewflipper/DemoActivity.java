package cn.appleye.textviewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.appleye.textviewfliper.library.BaseFlipperAdapter;
import cn.appleye.textviewfliper.library.TextViewFlipper;

/**
 * @author Liu Liaopu
 * @date 2018/5/24
 * @description demo
 */
public class DemoActivity extends Activity{

    /**模拟数据*/
    private List<List<String>> mockDatas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        initMockData();

        setContentView(R.layout.activity_demo);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new ListAdapter());
    }

    /**
     * 生成模拟数据
     * */
    private void initMockData(){
        for(int i=0; i<100; i++){
            List<String> data = new ArrayList<>();
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");
            data.add(i + "家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
            data.add(i + "iPhone8最感人变化成真，必须买买买买!!!!");
            data.add(i + "简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
            data.add(i + "iPhone7价格曝光了！看完感觉我的腰子有点疼...");
            data.add(i + "主人内疚逃命时没带够，回废墟狂挖30小时！");

            mockDatas.add(data);
        }
    }

    /**
     * 实现适配器
     * */
    private class FlipperAdapter extends BaseFlipperAdapter{
        private List<String> mData;

        public void setData(List<String> data){
            mData = data;
        }

        @Override
        public int getCount() {
            return mData == null ? 0 : mData.size();
        }

        @Override
        public View getView(View convertView, int position) {
            if(convertView == null){
                convertView = View.inflate(DemoActivity.this, R.layout.layout_flipper_item, null);
            }

            TextView textView = (TextView) convertView;
            textView.setText(mData.get(position));

            return convertView;
        }
    }

    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mockDatas.size();
        }

        @Override
        public Object getItem(int i) {
            return mockDatas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.list_view_item, null);
            }

            TextViewFlipper textViewFlipper = (TextViewFlipper)convertView.findViewById(R.id.text_view_flipper);
            FlipperAdapter adapter = (FlipperAdapter)textViewFlipper.getAdapter();
            if(adapter == null){
                adapter = new FlipperAdapter();
            }
            adapter.setData(mockDatas.get(position));
            textViewFlipper.setFlipperAdapter(adapter);
            textViewFlipper.startFlipping();

            return convertView;
        }
    }
}
