package nseki.com.app.sampleviewmodeldi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class BookViewModel @AssistedInject constructor(
    @Assisted private val bookId: String,
    private val bookRepository: BookRepository
) : ViewModel() {

    val data: LiveData<String> = MutableLiveData<String>().apply {
        value = "sample data"
    }

    @AssistedFactory
    interface Factory {
        fun create(bookId: String): BookViewModel
    }
}
