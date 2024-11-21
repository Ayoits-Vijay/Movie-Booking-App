package com.example.tookmyshow3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoviesFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)

        // RecyclerView for Movies
        val recyclerMovies = view.findViewById<RecyclerView>(R.id.recyclerMovies)

        // Sample Movies Data
        val topMovies = listOf(
            movie("Lucky Baskhar", R.drawable.movie1, "2h 30m ~ Crime, Drama, Thriller ~ UA ~ 31 Oct, 2024 \n" + "\n" +
                    "Gear up to witness the extra-ordinary tale of Lucky Bhaskar."),
            movie("Kanguva", R.drawable.movie2, "2h 34m ~ Action, Period, Thriller ~ UA ~ 14 Nov, 2024 \n" + "\n" +
                    "Prepare to witness, epic emotions, raw rage, primal courage, ruthless revenge in its purest form."),
            movie("Amaran", R.drawable.movie3, "2h 49m ~ Action, Drama, Thriller ~ UA ~ 31 Oct, 2024 \n" + "\n" +
                    "Amaran is a true-life story of Major Mukund Varadarajan..."),
            movie("Matka", R.drawable.movie4, "2h 39m ~ Action, Period, Thriller ~ UA ~ 14 Nov, 2024 \n" +"\n" +"Matka tells the story of Vasu, who rises from poverty to create a powerful gambling empire in India, ultimately leading the nation into a battle with the government. Based on real events, the tale explores themes of love, moral choices, and the consequences of ambition."),
            movie("Mechanic Rocky", R.drawable.movie5, "2h 30m ~ Action, Drama,Comedy ~ UA ~ 22 Nov, 2024 \n" +"\n" +"Get ready to book your ride with Rocky!"),
            movie("Gladiator 2", R.drawable.movie6, "2h 30m ~ Action, Drama,Adventure ~ UA ~ 15 Nov, 2024 \n" +"\n" +"From legendary director Ridley Scott, Gladiator II continues the epic saga of power, intrigue, and vengeance set in Ancient Rome. Years after witnessing the death of the revered hero Maximus at the hands of his uncle, Lucius (Paul Mescal) is forced to enter the Colosseum after his home is conquered by the tyrannical Emperors who now lead Rome with an iron fist. With rage in his heart and the future of the Empire at stake, Lucius must look to his past to find strength and honor to return the glory of Rome to its people."),
            movie("Venom 3", R.drawable.movie7, "1h 50m ~ Action, Adventure, Sci-Fi ~ UA ~ 24 Oct, 2024 \n" +"\n" +"Eddie and Venom are on the run. Hunted by both of their worlds and with the net closing in, the duo are forced into a devastating decision that will bring the curtains down on Venom and Eddie`s last dance."),
            movie("The Wild Robot", R.drawable.movie8, "1h 41m ~ Animation, Drama, Family ~ UA ~ 18 Oct, 2024 \n" +"\n" +"Shipwrecked on a deserted island, a robot named Roz must learn to adapt to its new surroundings. Building relationships with the native animals, Roz soon develops a parental bond with an orphaned gosling."),
            movie("Despicable Me 4", R.drawable.movie9, "1h 34m ~ Crime, Comedy, Animation ~ U ~ 5 Oct, 2024 \n" +"\n" +"Gru welcomes a new member to the family, Gru Jr., who's intent on tormenting his dad. However, their peaceful existence crashes when criminal mastermind Maxime Le Mal escapes from prison and vows revenge against Gru."),
            movie("Kung fu panda 4", R.drawable.movie10, "2h 30m ~ Action, Animation, Comedy ~ U ~ 15 Oct, 2024 \n" +"\n" +"Po faces his greatest challenge yet when he ventures to the big city and meets a new villain called the Chameleon.")
            // Add the rest of your movies here
        )

        // Set GridLayoutManager for 2 columns
        recyclerMovies.layoutManager = GridLayoutManager(context, 2)
        recyclerMovies.adapter = MoviesAdapter(topMovies) { selectedMovie ->
            openMovieDetails(selectedMovie)
        }

        return view
    }

    private fun openMovieDetails(movie: movie) {
        val bundle = Bundle().apply {
            putString("title", movie.title)
            putString("description", movie.description)
            putInt("imageResId", movie.imageResId)
        }

        val movieDetailsFragment = MovieDetailsFragment()
        movieDetailsFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, movieDetailsFragment)
            .addToBackStack(null)
            .commit()
    }
}
