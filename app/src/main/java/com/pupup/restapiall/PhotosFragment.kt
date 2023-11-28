package com.pupup.restapiall

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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

class PhotosFragment : Fragment() {

    lateinit var photoAdapter: PhotoAdapter
    lateinit var photoItem : List<PhotosModel>
    lateinit var recyclerView: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_photos, container, false)
        recyclerView = view.findViewById(R.id.photoRecyclerView)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val photoInterfaceApi = retrofit.create(PhotoInterfaceApi::class.java)
        val myCall = photoInterfaceApi.getPhotoData()
        myCall.enqueue(object : Callback<List<PhotosModel>?> {
            override fun onResponse(
                call: Call<List<PhotosModel>?>,
                response: Response<List<PhotosModel>?>
            ) {
                val responseBody = response.body()!!
                photoAdapter = PhotoAdapter(requireContext(),responseBody)
                photoAdapter.notifyDataSetChanged()
                recyclerView.adapter=photoAdapter
            }

            override fun onFailure(call: Call<List<PhotosModel>?>, t: Throwable) {
                Log.e("ERROR",t.message.toString())
            }
        })
        return view
    }


}