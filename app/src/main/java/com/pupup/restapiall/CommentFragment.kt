package com.pupup.restapiall

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CommentFragment : Fragment() {

    lateinit var commentAdapter: CommentAdapter
    lateinit var commentItem : List<CommentsModel>
    lateinit var recyclerView: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_comment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val commentApi = retrofit.create(CommentInterface::class.java)
        val myCall = commentApi.getData()

        myCall.enqueue(object : Callback<List<CommentsModel>?> {
            override fun onResponse(
                call: Call<List<CommentsModel>?>,
                response: Response<List<CommentsModel>?>
            ) {
                val responeBody = response.body()!!
                commentAdapter = CommentAdapter(requireContext(),responeBody)
                commentAdapter.notifyDataSetChanged()
                recyclerView.adapter=commentAdapter
            }

            override fun onFailure(call: Call<List<CommentsModel>?>, t: Throwable) {

            }
        })


        return view
    }

}