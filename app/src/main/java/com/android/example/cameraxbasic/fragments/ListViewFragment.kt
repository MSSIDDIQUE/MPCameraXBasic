package com.android.example.cameraxbasic.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.example.cameraxbasic.R
import com.android.example.cameraxbasic.adapters.PicsListAdapter
import com.android.example.cameraxbasic.data.Pics
import com.android.example.cameraxbasic.viewmodels.PicsViewModel
import com.android.example.cameraxbasic.viewmodels.PicsViewModelFactory
import kotlinx.android.synthetic.main.fragment_list_view.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext
import org.kodein.di.android.x.kodein


class ListViewFragment : Fragment(),KodeinAware {

    override val kodeinContext = kcontext<Fragment>(this)
    override val kodein by kodein()

    private val viewModelFactory: PicsViewModelFactory by instance()

    private lateinit var viewModel: PicsViewModel

    private lateinit var adapter : PicsListAdapter

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_list_view_fragment_to_camera_fragment)
        }
        viewModel = ViewModelProvider(this,viewModelFactory).get(PicsViewModel::class.java)
        viewModel.getPics().observe(this@ListViewFragment, Observer {
            pics->
            progress_bar.visibility = View.GONE
            adapter = PicsListAdapter(pics as ArrayList<Pics>)
            linearLayoutManager = LinearLayoutManager(context)
            recycler_view.layoutManager = linearLayoutManager
            recycler_view.adapter = adapter
        })
    }
}
