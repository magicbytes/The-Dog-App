package com.magicbytes.thedogapp_cv.feat.dogs.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.magicbytes.test_utils.CoroutinesTestRule
import com.magicbytes.thedogapp_cv.feat.dogs.data.DogsRepository
import com.magicbytes.thedogapp_cv.utility.ServiceResponse
import com.magicbytes.thedogapp_cv.utils.UtilityMocks
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DogListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutineDispatcher = CoroutinesTestRule()

    private val dogsRepoMock: DogsRepository = mock()

    private lateinit var viewModel: DogListViewModel

    @Before
    fun setUp() {
        viewModel = DogListViewModel(dogsRepoMock, UtilityMocks.provideCoroutineDispatchers())
    }

    @Test
    fun `When error loading all breds, show error state`() = runBlocking {
        whenever(dogsRepoMock.loadAllBreeds()).thenReturn(ServiceResponse.Error())

        viewModel.loadAllBreeds()

        assertThat(viewModel.screenState.value!!).isInstanceOf(DogListViewModel.ScreenState.ErrorScreenState::class.java)
    }

    @Test
    fun `When success loading all breds, show success state`() = runBlocking {
        whenever(dogsRepoMock.loadAllBreeds()).thenReturn(ServiceResponse.Success(emptyList()))

        viewModel.loadAllBreeds()

        assertThat(viewModel.screenState.value!!).isInstanceOf(DogListViewModel.ScreenState.BredsAvailableScreenState::class.java)
    }
}
