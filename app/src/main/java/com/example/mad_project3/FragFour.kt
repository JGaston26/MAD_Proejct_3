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

class FragFour : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_frag_four, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favWebsiteText : String = arguments?.getString("usrFavWeb3").toString()
        Log.i("Hello",favWebsiteText)

        val fragThreeButton: Button = view.findViewById(R.id.fragFourButton)
        fragThreeButton.setOnClickListener{
            val navController: NavController = view.findNavController()
            navController.navigate(R.id.action_fragFour_to_homeFragment)
        }

        view.findViewById<WebView?>(R.id.UserFav)
            ?.loadUrl(favWebsiteText)
    }
}