package appewtc.masterung.learnasyncetaskv2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private String urlJSONString = "http://swiftcodingthai.com/19Mar/php_get_food_master.php";
    private String tag = "4April";
    private String[] titleStrings, priceStrings, iconStrings;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        //Call Connected
        MyConnect myConnect = new MyConnect();
        myConnect.execute();


    }   // Main Method

    public class MyConnect extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSONString).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                return "Error ==> " + e.toString();
            }   // try

            //return null;
        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                Log.d("5April", "jsonArray.length = " + jsonArray.length());

                titleStrings = new String[jsonArray.length()];
                priceStrings = new String[jsonArray.length()];
                iconStrings = new String[jsonArray.length()];

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    titleStrings[i] = jsonObject.getString("Food");
                    priceStrings[i] = jsonObject.getString("Price");
                    iconStrings[i] = jsonObject.getString("Source");

                }   //for

                //Create ListView
                MyAdapter myAdapter = new MyAdapter(MainActivity.this, titleStrings, priceStrings, iconStrings);
                listView.setAdapter(myAdapter);

            } catch (Exception e) {
                Log.d(tag, "Error ==> " + e.toString());
            }   //try

        }   // onPost

    }   // MyConnect Class

}   // Main Class
