package com.example.examnet.ui.userProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.examnet.R
import com.example.examnet.StaticClass
import kotlinx.android.synthetic.main.fragment_user_profile.*

class UserProfileFragment : Fragment() {

    private lateinit var userProfileViewModel: UserProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userProfileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_user_profile, container, false)
        val textView : TextView = root.findViewById(R.id.text_userProfile)
        userProfileViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*userUsername.text = StaticClass.username
        userEmail.text = StaticClass.email
        userScore.text = StaticClass.scor*/

        userUsername.text = "Gigi"
        userEmail.text = "agachi.eusebiu@yahoo.com"
        userScore.text = "20"

    }

}