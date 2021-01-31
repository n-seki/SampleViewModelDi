package nseki.com.app.sampleviewmodeldi

import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
