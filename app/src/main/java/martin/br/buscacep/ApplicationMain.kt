package martin.br.buscacep

import android.app.Application
import com.facebook.stetho.Stetho

class ApplicationMain : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

}