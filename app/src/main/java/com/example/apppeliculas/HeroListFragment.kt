package com.example.apppeliculas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.apppeliculas.model.db.HeroMini
import com.example.apppeliculas.viewmodel.HeroViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import com.example.apppeliculas.HeroListFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HeroListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private var heroList = ArrayList<HeroMini>()
private lateinit var adapter: HeroAdapter
private lateinit var heroViewModel : HeroViewModel
//Parte del callback el NotifyClick
class HeroListFragment : Fragment() /*, NotifyClick*/ {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HeroListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HeroListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Parte del callback
        //adapter = HeroAdapter(heroList,this)
        adapter = HeroAdapter(heroList)

        heroRecycler.adapter = adapter
        //TODO cambiar
        //heroViewModel = ViewModelProvider(this).get(HeroViewModel::class.java)
        val heroViewModel: HeroViewModel by activityViewModels()
        heroViewModel.listHero.observe(viewLifecycleOwner, Observer {
            adapter.updateItems(it)
        })
        adapter.heroSelected.observe(viewLifecycleOwner, Observer {
            Log.d("lifeCycleOwner", "heroe seleccionado $it")
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container_fragment, HeroDetailFragment.newInstance("", ""), "detail").
                    addToBackStack("detail").commit()
        })
    }
}
    //Parte del callback
    /*override fun notifyClick(heroMini: HeroMini) {
        Log.d("notify", "")
    }
}
    interface NotifyClick{
        fun notifyClick(heroMini: HeroMini)
    }*/
