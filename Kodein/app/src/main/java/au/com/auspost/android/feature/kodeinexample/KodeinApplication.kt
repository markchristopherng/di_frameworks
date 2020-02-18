package au.com.auspost.android.feature.kodeinexample

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class KodeinApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(kodeinModule)
    }
}