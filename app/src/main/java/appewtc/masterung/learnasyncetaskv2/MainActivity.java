package appewtc.masterung.learnasyncetaskv2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private String urlJSONString = "http://swiftcodingthai.com/19Mar/php_get_food_master.php";
    private String tag = "4April";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            }

           //return null;
        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d(tag, "strJSON ==> " + s);

        }   // onPost

    }   // MyConnect Class

}   // Main Class
