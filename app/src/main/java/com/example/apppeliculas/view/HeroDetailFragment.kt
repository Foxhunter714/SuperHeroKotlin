package com.example.apppeliculas.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.apppeliculas.R
import com.example.apppeliculas.model.db.HeroEntity
import com.example.apppeliculas.model.db.HeroMini
import com.example.apppeliculas.view.HeroListFragment.Companion.newInstance
import com.example.apppeliculas.view.HeroStats.Companion.newInstance
import com.example.apppeliculas.viewmodel.HeroViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_hero_detail.*
import kotlinx.android.synthetic.main.fragment_hero_list.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HeroDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class HeroDetailFragment : Fragment() {
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
        savedInstanceStato: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("parametro1", param1!!)


        val heroViewModel: HeroViewModel by activityViewModels()
        heroViewModel.run {
            getDetails(param1!!).observe(viewLifecycleOwner, Observer{
                Log.d("Parametro Observado", "${it!!.toString()}")
                Picasso.get().load(it!!.images.md).into(imageView2)
                textViewTitle2.text = it!!.name
                combat.text = it!!.powerstats.combat.toString()
                durability.text = it!!.powerstats.durability.toString()
                intelligence.text = it!!.powerstats.intelligence.toString()
                power.text = it!!.powerstats.power.toString()
                speed.text = it!!.powerstats.speed.toString()
                strength.text = it!!.powerstats.strength.toString()})

                        }

        return inflater.inflate(R.layout.fragment_hero_detail, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HeroDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HeroDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Hero", "Aquí se abrio el heroe $param1")
        /*Picasso.get().load()*/
        button2.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container_fragment, HeroStats.newInstance("", ""), "detail").
            addToBackStack("detail").commit()
        }
    }

}

