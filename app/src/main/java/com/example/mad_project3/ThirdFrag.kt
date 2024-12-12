package com.example.mad_project3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController

class ThirdFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favWebsiteText : String = arguments?.getString("usrFavWeb2").toString()
        Log.i("Hello",favWebsiteText)
        val passedData : Bundle = Bundle()
        passedData.putString("usrFavWeb3",favWebsiteText)

        val fragThreeButton: Button = view.findViewById(R.id.fragThreeButton)
        fragThreeButton.setOnClickListener{
            val navController: NavController = view.findNavController()
            navController.navigate(R.id.action_thirdFrag_to_fragFour,passedData)
        }

        view.findViewById<WebView?>(R.id.squirdle)
            ?.loadUrl("https://squirdle.fireblend.com/daily.html")
    }
}