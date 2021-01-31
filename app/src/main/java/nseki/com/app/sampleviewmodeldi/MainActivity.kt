package nseki.com.app.sampleviewmodeldi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var bookViewModelFactory: BookViewModel.Factory
    private val bookViewModel by viewModels<BookViewModel>(
        factoryProducer = {
            viewModelFactory {
                bookViewModelFactory.create("12345")
            }
        }
    )

    @Inject
    lateinit var saveStateBookViewModelFactory: SavedStateBookViewModel.Factory
    private val savedStateBookViewModel by viewModels<SavedStateBookViewModel>(
        factoryProducer = {
            savedStateViewModelFactory(
                saveStateBookViewModelFactory.create("12345"),
                this
            )
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookViewModel.data.observe(this) {
            Log.d("MainActivity", it)
        }

        savedStateBookViewModel.data.observe(this) {
            Log.d("MainActivity", it)
        }
    }
}
