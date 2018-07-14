package practicaltask.riseapps.com.practicaltask.ui.utils

import android.os.AsyncTask
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class InternetCheck(private val callback: (Boolean) -> Unit) : AsyncTask<Void, Void, Boolean>() {

    init {
        execute()
    }

    override fun doInBackground(vararg voids: Void): Boolean? {
        try {
            val sock = Socket()
            sock.connect(InetSocketAddress(CHECK_INTERNET_HOST_NAME, CHECK_INTERNET_PORT), CHECK_INTERNET_TIMEOUT)
            sock.close()
            return true
        } catch (e: IOException) {
            return false
        }

    }

    override fun onPostExecute(internet: Boolean?) {
        callback(internet ?: false)
    }

    companion object {

        private const val CHECK_INTERNET_HOST_NAME = "8.8.8.8"
        private const val CHECK_INTERNET_PORT = 53
        private const val CHECK_INTERNET_TIMEOUT = 1000
    }
}
