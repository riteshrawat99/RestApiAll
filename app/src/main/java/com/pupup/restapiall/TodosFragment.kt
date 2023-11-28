package com.pupup.restapiall

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodosFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var todosAdpater: TodosAdpater
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_todos, container, false)
        recyclerView = view.findViewById(R.id.todoRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val todosInterfaceApi = retrofit.create(TodosInterfaceApi::class.java)
        val myCall = todosInterfaceApi.getTotosData()
        myCall.enqueue(object : Callback<List<TodosModel>?> {
            override fun onResponse(
                call: Call<List<TodosModel>?>,
                response: Response<List<TodosModel>?>
            ) {
                val totosData = response.body() !!
                todosAdpater = TodosAdpater(requireContext(),totosData)
                todosAdpater.notifyDataSetChanged()
                recyclerView.adapter=todosAdpater
            }

            override fun onFailure(call: Call<List<TodosModel>?>, t: Throwable) {

            }
        })
        return view
    }


}