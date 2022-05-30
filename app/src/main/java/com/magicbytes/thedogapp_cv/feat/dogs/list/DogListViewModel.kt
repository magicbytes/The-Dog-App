package com.magicbytes.thedogapp_cv.feat.dogs.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magicbytes.thedogapp_cv.api.data.DogBreed
import com.magicbytes.thedogapp_cv.feat.dogs.data.DogsRepository
import com.magicbytes.thedogapp_cv.utility.AppCoroutineDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogListViewModel @Inject constructor(
    private val dogsRepository: DogsRepository,
    private val dispatchers: AppCoroutineDispatchers
) :
    ViewModel() {

    private var _screenState = MutableLiveData<ScreenState>()
    val screenState: LiveData<ScreenState> = _screenState

    fun loadAllBreeds() {
        viewModelScope.launch(dispatchers.network) {
            _screenState.postValue(ScreenState.LoadingScreenState)

            dogsRepository.loadAllBreeds()
                .onSuccess {
                    _screenState.postValue(ScreenState.BreedsAvailableScreenState(it))
                }
                .onFailure {
                    _screenState.postValue(ScreenState.ErrorScreenState)
                }
        }
    }

    fun filter(breedFilter: String) {
        val newBreeds = dogsRepository.searchBreed(breedFilter)
        _screenState.postValue(ScreenState.BreedsAvailableScreenState(newBreeds))
    }

    /**
     * Indicate one of the possible screen states
     */
    sealed class ScreenState {
        object LoadingScreenState : ScreenState()
        object ErrorScreenState : ScreenState()
        data class BreedsAvailableScreenState(val breeds: List<DogBreed>) : ScreenState()
    }
}
