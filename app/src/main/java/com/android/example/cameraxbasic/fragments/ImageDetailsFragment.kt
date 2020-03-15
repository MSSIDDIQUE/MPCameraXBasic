package com.android.example.cameraxbasic.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.android.example.cameraxbasic.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image_details.*


class ImageDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val safeArgs = ImageDetailsFragmentArgs.fromBundle(it)
            val pic = safeArgs.image
            progressBar.isVisible = true
            Picasso.get().load(pic.imageUrl).fit().centerCrop().into(imageView)
            progressBar.isVisible = false
        }
    }
}
