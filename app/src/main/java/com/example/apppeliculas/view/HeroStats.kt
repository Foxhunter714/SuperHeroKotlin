package com.example.apppeliculas.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.apppeliculas.R
import com.example.apppeliculas.viewmodel.HeroViewModel
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import kotlinx.android.synthetic.main.fragment_hero_stats.*
import java.lang.Math.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HeroStats.newInstance] factory method to
 * create an instance of this fragment.
 */
private lateinit var herViewModel: HeroViewModel
class HeroStats : Fragment() {
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
       return inflater.inflate(R.layout.fragment_hero_stats, container, false)
}
    private fun setData() {
        val heroViewModel: HeroViewModel by activityViewModels()
        heroViewModel.getDetails(param1!!).observe(viewLifecycleOwner, Observer {
                val comb = it!!.powerstats.combat
                val dur = it!!.powerstats.durability
                val intel = it!!.powerstats.intelligence
                val pow = it!!.powerstats.power
                val spe = it!!.powerstats.speed
                val str = it!!.powerstats.strength
                val entries1 = ArrayList<RadarEntry>()
                entries1.add(RadarEntry(comb.toFloat()))
                entries1.add(RadarEntry(dur.toFloat()))
                entries1.add(RadarEntry(intel.toFloat()))
                entries1.add(RadarEntry(pow.toFloat()))
                entries1.add(RadarEntry(spe.toFloat()))
                entries1.add(RadarEntry(str.toFloat()))
                val set1 = RadarDataSet(entries1, "Powestats ${it!!.name}")
                set1.color = Color.rgb(103, 110, 129)
                set1.fillColor = Color.rgb(103, 110, 129)
                set1.setDrawFilled(true)
                set1.fillAlpha = 180
                set1.lineWidth = 2f
                set1.isDrawHighlightCircleEnabled = true
                set1.setDrawHighlightIndicators(false)
                val sets = ArrayList<IRadarDataSet>()
                sets.add(set1)
                val data = RadarData(sets)
                data.setValueTextSize(8f)
                data.setDrawValues(false)
                data.setValueTextColor(Color.WHITE)
                chart1.data = data
                chart1.invalidate()

            })

        }

    


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HeroStats.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HeroStats().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()

    }


}