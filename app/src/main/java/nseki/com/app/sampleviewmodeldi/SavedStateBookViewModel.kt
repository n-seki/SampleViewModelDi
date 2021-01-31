package nseki.com.app.sampleviewmodeldi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SavedStateBookViewModel constructor(
    private val bookId: String,
    private val bookRepository: BookRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val data: LiveData<String> = MutableLiveData<String>().apply {
        value = "sample saved state data"
    }

    class Factory @Inject constructor(
        private val bookRepository: BookRepository,
    ) {
        fun create(bookId: String): (SavedStateHandle) -> SavedStateBookViewModel {
            return { savedStateHandle ->
                SavedStateBookViewModel(
                    bookId,
                    bookRepository,
                    savedStateHandle
                )
            }
        }
    }
}
