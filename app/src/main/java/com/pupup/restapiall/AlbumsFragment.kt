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


class AlbumsFragment : Fragment() {

    lateinit var albumAdapter: AlbumAdapter
    lateinit var albumsItem : List<AlbumsModel>
    lateinit var recyclerView: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_albums, container, false)
        recyclerView = view.findViewById(R.id.albumsRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val albumInterfaceApi = retrofit.create(AlbumInterfaceApi::class.java)
        val myCall = albumInterfaceApi.getAlubmData()
        myCall.enqueue(object : Callback<List<AlbumsModel>?> {
            override fun onResponse(
                call: Call<List<AlbumsModel>?>,
                response: Response<List<AlbumsModel>?>
            ) {
               val responseBody = response.body()!!
                albumAdapter= AlbumAdapter(requireContext(),responseBody)
                albumAdapter.notifyDataSetChanged()
                recyclerView.adapter=albumAdapter
            }

            override fun onFailure(call: Call<List<AlbumsModel>?>, t: Throwable) {

            }
        })


        return view
    }

}