package com.magicbytes.thedogapp_cv.feat.dogs.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.magicbytes.thedogapp_cv.R
import com.magicbytes.thedogapp_cv.api.data.DogBreed
import com.magicbytes.thedogapp_cv.databinding.FragmentItemListBinding
import com.magicbytes.thedogapp_cv.feat.dogs.details.DogDetailFragment
import com.magicbytes.thedogapp_cv.feat.dogs.list.adapters.DogBreedsRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * A Fragment representing a list of Dogs. This fragment
 * has different presentations for handset and larger screen devices. On
 * handsets, the fragment presents a list of items, which when touched,
 * lead to a {@link ItemDetailFragment} representing
 * item details. On larger screens, the Navigation controller presents the list of items and
 * item details side-by-side using two vertical panes.
 */
@AndroidEntryPoint
class DogsListFragment : Fragment() {


    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    private val adapter: DogBreedsRecyclerViewAdapter by lazy { DogBreedsRecyclerViewAdapter() }

    private val viewModel: DogListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.screenState.observe(viewLifecycleOwner) {
            when (it) {
                is DogListViewModel.ScreenState.BreedsAvailableScreenState -> {
                    showBreedsAvailable(it.breeds)
                }
                DogListViewModel.ScreenState.ErrorScreenState -> {
                    showErrorState()
                }
                DogListViewModel.ScreenState.LoadingScreenState -> {
                    showLoading()
                }
            }
        }

        viewModel.loadAllBreeds()
    }

    private fun showLoading() {

    }

    private fun showErrorState() {

    }

    private fun showBreedsAvailable(breeds: List<DogBreed>) {
        adapter.listItems = breeds
    }

    private fun setupRecyclerView() {
        binding.itemList.adapter = adapter
        adapter.onBreedSelected = { breed ->
            // Leaving this not using view binding as it relies on if the view is visible the current
            // layout configuration (layout, layout-sw600dp)
            val itemDetailFragmentContainer: View? = view?.findViewById(R.id.item_detail_nav_container)

            val bundle = bundleOf(DogDetailFragment.ARG_BREED to breed)

            if (itemDetailFragmentContainer != null) {
                itemDetailFragmentContainer.findNavController().navigate(R.id.fragment_item_detail, bundle)
            } else {
                view?.findNavController()?.navigate(R.id.show_item_detail, bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
