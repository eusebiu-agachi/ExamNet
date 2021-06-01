package com.example.examnet.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examnet.R
import com.example.examnet.ui.domenii.Biologie.Biologie
import com.example.examnet.ui.domenii.Informatica.Informatica
import com.example.examnet.ui.domenii.ItemsAdapter
import com.example.examnet.ui.domenii.ItemsModel
import com.example.examnet.ui.domenii.Matematica.Matematica
import kotlinx.android.synthetic.main.fragment_quiz.*

class QuizFragment : Fragment(R.layout.fragment_quiz), ItemsAdapter.ClickListener {
    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quiz, container, false)
        val textView: TextView = root.findViewById(R.id.text_quiz)
        quizViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    private val imagesName = arrayOf(
        ItemsModel("Biologie"),
        ItemsModel("Matematică"),
        ItemsModel("Informatică")
    )

    private val itemsModelList = ArrayList<ItemsModel>()
    var itemsAdapter : ItemsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(items in imagesName) {
            itemsModelList.add(items)
        }

        itemsAdapter = ItemsAdapter(this)
        itemsAdapter!!.setData(itemsModelList)

        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemsAdapter

    }

    override fun ClickedItem(itemsModel: ItemsModel) {
        Log.e("TAG", itemsModel.name)

        when(itemsModel.name) {
            "Biologie"
            -> startActivity(Intent(this.context, Biologie::class.java))
            "Matematică"
            -> startActivity(Intent(this.context, Matematica::class.java))
            "Informatică"
            -> startActivity(Intent(this.context, Informatica::class.java))
        }
    }
}