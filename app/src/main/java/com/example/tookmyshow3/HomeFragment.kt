package com.example.tookmyshow3

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class HomeFragment : Fragment() {
    private lateinit var viewPager2: ViewPager2
    private val handler = Handler(Looper.getMainLooper())
    private var autoScrollRunnable: Runnable? = null


    private val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        viewPager2 = view.findViewById(R.id.viewPager2)


        val sliderAdapter = SliderAdapter(images)
        viewPager2.adapter = sliderAdapter


        setupAutoScroll()


        val topMovies = listOf(
            movie("Lucky Baskhar", R.drawable.movie1, "2h 30m ~ Crime, Drama, Thriller ~ UA ~ 31 Oct, 2024 \n" +"\n" +
                    "Gear up to witness the extra -ordinary tale of Lucky Bhaskar."),
            movie("Kanguva", R.drawable.movie2, "2h 34m ~ Action, Period, Thriller ~ UA ~ 14 Nov, 2024 \n" +"\n" +"Prepare to witness, epic emotions, raw rage, primal courage, ruthless revenge in its purest form."),
            movie("Amaran", R.drawable.movie3, "2h 49m ~ Action, Drama, Thriller ~ UA ~ 31 Oct, 2024 \n" +
                    "\n" + "Amaran is a true-life story of Major Mukund Varadarajan (Sivakarthikeyan), a commissioned officer in the Indian Army`s Rajput Regiment, who was posthumously awarded the Ashok Chakra for his valor during a counterterrorism operation while on deputation to the 44th Rashtriya Rifles battalion in Jammu and Kashmir.\n" +
                    "\n" +
                    "Besides being a tale of courage, it portrays the selfless love of his wife, Indhu Rebecaa Varghese (Sai Pallavi). The supporting cast includes Bhuvan Arora, Rahul Bose, and Rohman Shawl, all contributing to this real-life story that deserves to be told and shared in the annals of history. From the well-known house of Raaj Kamal Films International and Sony Pictures Films India, Director Rajkumar Periasamy has deftly woven the threads of this story with reality, allowing the audience to relate to the daily trials and tribulations our brave soldiers face, which many of us tend to take for granted.\n" +
                    "\n" +
                    "It`s time to stand and salute these brave warriors of our frontiers! The film is produced by Kamal Haasan, Sony Pictures International Productions, and R. Mahendran."),
            movie("Matka", R.drawable.movie4, "2h 39m ~ Action, Period, Thriller ~ UA ~ 14 Nov, 2024 \n" +"\n" +"Matka tells the story of Vasu, who rises from poverty to create a powerful gambling empire in India, ultimately leading the nation into a battle with the government. Based on real events, the tale explores themes of love, moral choices, and the consequences of ambition."),
            movie("Mechanic Rocky", R.drawable.movie5, "2h 30m ~ Action, Drama,Comedy ~ UA ~ 22 Nov, 2024 \n" +"\n" +"Get ready to book your ride with Rocky!"),
            movie("Gladiator 2", R.drawable.movie6, "2h 30m ~ Action, Drama,Adventure ~ UA ~ 15 Nov, 2024 \n" +"\n" +"From legendary director Ridley Scott, Gladiator II continues the epic saga of power, intrigue, and vengeance set in Ancient Rome. Years after witnessing the death of the revered hero Maximus at the hands of his uncle, Lucius (Paul Mescal) is forced to enter the Colosseum after his home is conquered by the tyrannical Emperors who now lead Rome with an iron fist. With rage in his heart and the future of the Empire at stake, Lucius must look to his past to find strength and honor to return the glory of Rome to its people."),
            movie("Venom 3", R.drawable.movie7, "1h 50m ~ Action, Adventure, Sci-Fi ~ UA ~ 24 Oct, 2024 \n" +"\n" +"Eddie and Venom are on the run. Hunted by both of their worlds and with the net closing in, the duo are forced into a devastating decision that will bring the curtains down on Venom and Eddie`s last dance."),
            movie("The Wild Robot", R.drawable.movie8, "1h 41m ~ Animation, Drama, Family ~ UA ~ 18 Oct, 2024 \n" +"\n" +"Shipwrecked on a deserted island, a robot named Roz must learn to adapt to its new surroundings. Building relationships with the native animals, Roz soon develops a parental bond with an orphaned gosling."),
            movie("Despicable Me 4", R.drawable.movie9, "1h 34m ~ Crime, Comedy, Animation ~ U ~ 5 Oct, 2024 \n" +"\n" +"Gru welcomes a new member to the family, Gru Jr., who's intent on tormenting his dad. However, their peaceful existence crashes when criminal mastermind Maxime Le Mal escapes from prison and vows revenge against Gru."),
            movie("Kung fu panda 4", R.drawable.movie10, "2h 30m ~ Action, Animation, Comedy ~ U ~ 15 Oct, 2024 \n" +"\n" +"Po faces his greatest challenge yet when he ventures to the big city and meets a new villain called the Chameleon.")
        )


        val upcomingMovies = listOf(
            movie("Pushpa: The Rule - Part 2", R.drawable.moviea, "Action, Thriller ~ UA ~ 5 Dec, 2024 \n" +"\n" +"The Rule begins on 5th December 2024."),
            movie("Game Changer", R.drawable.movieb, "Drama, Political ~ UA ~ 10 Jan, 2025 \n" +"\n" +"Get ready for RamCharan`s undeniable swag - he`s about to own the screen and slay it like never before!"),
            movie("Mufasa", R.drawable.moviec, "\"Mufasa: The Lion King\" enlists Rafiki to relay the legend of the unlikely rise of the beloved king of the Pride Lands, introducing an orphaned cub called Mufasa, a sympathetic lion named Taka-the heir to a royal bloodline-and their expansive journey alongside an extraordinary group of misfits."),
            movie("Sonic 3", R.drawable.movied, "Sonic, Tails, and Knuckles must face a mysterious new adversary, Shadow the Hedgehog, as Dr. Robotnik reemerges with a new plan."),
            movie("RobinHood", R.drawable.moviee, "Robinhood is a Telugu movie starring Nithiin in the lead."),
            movie("Den of Thieves 2", R.drawable.movief, "Butler returns as Big Nick (Butler), this time on the hunt in Europe for Donnie (Jackson Jr.) who is embroiled in the dangerous world of diamond thieves and the infamous Panther mafia as they plot a massive heist of the world's biggest diamond exchange."),
            movie("Hong Kong Warriors", R.drawable.movieg, "The notorious Kowloon Walled City serves as a fortified, lawless safe haven for gangs and refugees alike. But when a skilled underground fighter runs afoul of the most feared Triad boss in Hong Kong."),
            movie("OG", R.drawable.movieh, "About 10 years ago, a devasting storm hit Mumbai that cleansed the soil and trees and swept half the city. However, the blood bath he unleashed has not been wiped by any storm to date.\n" +
                    "\n" +
                    "Now, if that guy is coming back to Mumbai, even Satan should be scared! They call him OG!"),
            movie("Rajasaab", R.drawable.moviei, "Prabhas shines as `The Raja Saab` in a captivating romantic-horror entertainer, skillfully directed by Maruthi Dasari, set to mesmerize audiences in multiple languages."),
            movie("Kannappa", R.drawable.moviej, "The movie depicts the folk tale of Kannappa, an atheist hunter who became a devotee of Lord Shiva and plucked out his eyes in an act of devotion.")

        )


        val recyclerTopMovies = view.findViewById<RecyclerView>(R.id.recyclerViewTopMovies)
        val recyclerUpcomingMovies = view.findViewById<RecyclerView>(R.id.recyclerViewUpcoming)

        recyclerTopMovies.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recyclerTopMovies.adapter = MoviesAdapter(topMovies) { movie ->
            openMovieDetails(movie)
        }

        recyclerUpcomingMovies.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerUpcomingMovies.adapter = MoviesAdapter(upcomingMovies) { movie ->
            openMovieDetails(movie)
        }

        return view
    }

    private fun setupAutoScroll() {
        autoScrollRunnable = object : Runnable {
            override fun run() {
                val currentItem = viewPager2.currentItem
                val nextItem = if (currentItem == images.size - 1) 0 else currentItem + 1
                viewPager2.currentItem = nextItem


                handler.postDelayed(this, 5000)
            }
        }


        handler.postDelayed(autoScrollRunnable!!, 5000)


        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                if (state == RecyclerView.SCROLL_STATE_DRAGGING) {
                    handler.removeCallbacks(autoScrollRunnable!!) // Stop while dragging
                } else if (state == RecyclerView.SCROLL_STATE_IDLE) {
                    handler.postDelayed(autoScrollRunnable!!, 3000) // Resume after idle
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clean up handler callbacks
        handler.removeCallbacks(autoScrollRunnable!!)
    }

    private fun openMovieDetails(movie: movie) {
        val bundle = Bundle().apply {
            putString("title", movie.title)
            putInt("imageResId", movie.imageResId)
            putString("description", movie.description)
        }
        val detailsFragment = MovieDetailsFragment()
        detailsFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailsFragment)
            .addToBackStack(null)
            .commit()
    }
}
