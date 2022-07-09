package com.lestrades.adaptadores_sports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.lestrades.adaptadores_sports.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: SportListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        getAllSports()
    }

    private fun setupRecyclerView() {
        listAdapter = SportListAdapter(this)
        binding.recyclerView.apply {
            //Las vistas dentro del recycler van a tener el mismo tamaño siempre
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
        }
    }

    private fun sports(): MutableList<Sport> {
        val soccerSport = Sport(1, "Futbol", "https://images.pexels.com/photos/47730/the-ball-stadion-football-the-pitch-47730.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        val baseballSport = Sport(2,"Baseball", "https://images.pexels.com/photos/1308713/pexels-photo-1308713.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        val volleybalSport = Sport(3,"volleyball","https://images.pexels.com/photos/2444852/pexels-photo-2444852.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        val boxingSport = Sport(4,"Boxing","https://images.pexels.com/photos/7991661/pexels-photo-7991661.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        val tennisSport = Sport(5,"tennis", "https://images.pexels.com/photos/5730299/pexels-photo-5730299.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        val rugbySport = Sport(6, "rugby","https://images.pexels.com/photos/163398/football-american-football-canadian-university-canadian-football-163398.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        val hokeySport = Sport(7,"Hokey","https://images.pexels.com/photos/221190/pexels-photo-221190.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        val golfSport = Sport(8,"Golf","https://images.pexels.com/photos/7858232/pexels-photo-7858232.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        val chessSport = Sport(9,"Chess","https://images.pexels.com/photos/277124/pexels-photo-277124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        return mutableListOf(soccerSport,baseballSport,volleybalSport,boxingSport,tennisSport,rugbySport,hokeySport,golfSport,chessSport)

    }
    private fun getAllSports(){
        val sportData = sports()
        listAdapter.submitList(sportData)
    }

    override fun Onclick(sport: Sport) {
        Snackbar.make(binding.root,sport.name,Snackbar.LENGTH_SHORT).show()
    }
}