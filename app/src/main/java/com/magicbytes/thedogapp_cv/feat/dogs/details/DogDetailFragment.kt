package com.magicbytes.thedogapp_cv.feat.dogs.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.magicbytes.thedogapp_cv.api.data.DogBreed
import com.magicbytes.thedogapp_cv.databinding.FragmentItemDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a single Dog detail screen.
 */
@AndroidEntryPoint
class DogDetailFragment : Fragment() {

    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!

    private val breed: DogBreed by lazy { requireArguments().getParcelable(ARG_BREED)!! }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarLayout?.title = breed.name
        binding.temperamentTextView?.text = breed.temperament
        binding.lifeSpanTextView?.text = breed.lifeSpan
        binding.breedForTextView?.text = breed.bredFor

        Picasso.get().load(breed.image.url).into(binding.breedImageView)
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_BREED = "breed_item"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
