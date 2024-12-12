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

class SecondFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second    , container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favWebsiteText : String = arguments?.getString("usrFavWeb").toString()
        val passedData : Bundle = Bundle()
        passedData.putString("usrFavWeb2",favWebsiteText)
        Log.i("Hello",favWebsiteText)
        val fragTwoButton: Button = view.findViewById(R.id.fragTwoButton)
        fragTwoButton.setOnClickListener{
            val navController: NavController = view.findNavController()
            navController.navigate(R.id.action_secondFrag_to_thirdFrag,passedData)
        }
        view.findViewById<WebView?>(R.id.ConnectionsGame)
            ?.loadUrl("https://www.connectionsunlimited.org/")
    }
}