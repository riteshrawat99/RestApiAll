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


class UsersFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var userAdapter: UserAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_users, container, false)
        recyclerView = view.findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val userInterfaceApi = retrofit.create(UserInterfaceApi::class.java)
        val myCall = userInterfaceApi.getUserData()
        myCall.enqueue(object : Callback<List<UserModelItemItem>?>{
            override fun onResponse(
                call: Call<List<UserModelItemItem>?>,
                response: Response<List<UserModelItemItem>?>
            ) {
              userAdapter = UserAdapter(requireContext(),response.body()!!)
                userAdapter.notifyDataSetChanged()
                recyclerView.adapter=userAdapter
            }

            override fun onFailure(call: Call<List<UserModelItemItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        } )

        return view
    }

}