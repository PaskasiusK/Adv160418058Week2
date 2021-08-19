package com.ubaya.adv160418058week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random


class GameFragment : Fragment() {

    var angka1 =0
    var angka2 =0
    var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    fun gantiSoal()
    {
        angka1 = Random.nextInt(0,100)
        angka2 = Random.nextInt(0,100)
        txtAngka1.text = angka1.toString()
        txtAngka2.text = angka2.toString()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gantiSoal()
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"

        }
        btnSubmit.setOnClickListener {
            if(txtAnswer.text.toString() == (angka1+angka2).toString())
            {
                gantiSoal()
                score++
                txtAnswer.setText("")
            }
            else
            {

                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }

        }
    }
}