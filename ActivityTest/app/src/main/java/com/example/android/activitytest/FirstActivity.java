package com.example.android.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if(resultCode==RESULT_OK) {
                    String returnData=data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity",this.toString());
        setContentView(R.layout.first_layout);
        Button button1=findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(FirstActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
               // finish();
                //显示启动
                //Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);
                //隐式启动
               // Intent intent = new Intent("com.example.android.activitytest.ACTION_START");
               // intent.addCategory("com.example.android.activitytest.MY_CATEGORY");
               // Intent intent =new Intent(Intent.ACTION_VIEW);
              //  intent.setData(Uri.parse("http://www.baidu.com"));
                //startActivity(intent);
//                String data="Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
//                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1);
                //Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });

        if(savedInstanceState!=null) {
            String tempData=savedInstanceState.getString("data_key");
            Log.d("FirstActivity",tempData);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }

    //重写方法，第一个参数用于指定我们通过哪一个资源文件来创建菜单，第二个参数用于指定我们的菜单项添加到哪一个Menu对象当中
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData="Something you just typed";
        outState.putString("data_key",tempData);
        Log.d("FirstActivity","call onSaveInstanceState");
    }
}
