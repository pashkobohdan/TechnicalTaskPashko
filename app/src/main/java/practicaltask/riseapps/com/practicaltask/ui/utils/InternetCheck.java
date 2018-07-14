package practicaltask.riseapps.com.practicaltask.ui.utils;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import practicaltask.riseapps.com.practicaltask.ui.base.Callback;

public class InternetCheck extends AsyncTask<Void, Void, Boolean> {

    private static final String CHECK_INTERNET_HOST_NAME = "8.8.8.8";
    private static final int CHECK_INTERNET_PORT = 53;
    private static final int CHECK_INTERNET_TIMEOUT = 1000;

    private Callback<Boolean> callback;

    public InternetCheck(Callback<Boolean> callback) {
        this.callback = callback;
        execute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            Socket sock = new Socket();
            sock.connect(new InetSocketAddress(CHECK_INTERNET_HOST_NAME, CHECK_INTERNET_PORT), CHECK_INTERNET_TIMEOUT);
            sock.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean internet) {
        callback.call(internet);
    }
}
