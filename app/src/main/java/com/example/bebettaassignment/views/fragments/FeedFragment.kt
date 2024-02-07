package com.example.bebettaassignment.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bebettaassignment.R
import com.example.bebettaassignment.adapters.GameListAdapter
import com.example.bebettaassignment.adapters.LiveMatchAdapter
import com.example.bebettaassignment.models.LiveMatchItemModel
import com.example.bebettaassignment.adapters.TickrAdapter
import com.example.bebettaassignment.databinding.FragmentFeedBinding
import com.example.bebettaassignment.models.GameModel
import com.example.bebettaassignment.models.TickrModel
import com.example.bebettaassignment.views.bottomsheets.CoinsIntroductionBottomSheet


class FeedFragment : Fragment(), GameListAdapter.OnItemClickListener {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bottomSheetFragment = CoinsIntroductionBottomSheet()
        bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater)

        setUpGameItemAdapter()
        setUpLiveMatchAdapter()
        setUpTickrAdapter()
        return binding.root
    }

    private fun setUpGameItemAdapter() {
        val gameList = listOf(
            GameModel(
                getString(R.string.football),
                R.drawable.soccer,
                R.color.white,
                R.color.black
            ),
            GameModel(
                getString(R.string.cricket),
                R.drawable.cricket,
                R.drawable.cricket_drawable,
                R.color.white
            ),
            GameModel(
                getString(R.string.adding_soon),
                R.drawable.adding_soon,
                R.drawable.adding_soon_gradient,
                R.color.white
            )
        )
        binding.rvGameList.apply {
            val gameListAdapter = GameListAdapter(this@FeedFragment)
            layoutManager =
                LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            setHasFixedSize(true)
            gameListAdapter.submitList(gameList)
            adapter = gameListAdapter
        }
    }


    private fun setUpLiveMatchAdapter() {
        val liveMatchList = listOf(
            LiveMatchItemModel(
                getString(R.string.espanyol),
                getString(R.string.atl_madrid),
                getString(R.string._2),
                getString(R.string._1),
                R.drawable.team_a,
                R.drawable.team_b,
                getString(R.string._72_min)
            ),
            LiveMatchItemModel(
                getString(R.string.leeds_utd),
                getString(R.string.liverpool),
                getString(R.string._1),
                getString(R.string._3),
                R.drawable.leeds_united,
                R.drawable.liverpool,
                getString(R.string._36_min)
            ),
            LiveMatchItemModel(
                getString(R.string.leeds_utd),
                getString(R.string.liverpool),
                getString(R.string._1),
                getString(R.string._3),
                R.drawable.leeds_united,
                R.drawable.liverpool,
                getString(R.string._36_min)
            ),
        )
        binding.rvLiveMach.apply {
            val liveMatchListAdapter = LiveMatchAdapter()
            layoutManager =
                LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            setHasFixedSize(true)
            liveMatchListAdapter.submitList(liveMatchList)
            adapter = liveMatchListAdapter
        }
    }


    private fun setUpTickrAdapter() {
        val tickrItemList = listOf(
            TickrModel(getString(R.string.usab), R.drawable.usab),
            TickrModel(getString(R.string.dal), R.drawable.dal),
            TickrModel(getString(R.string.ncaff), R.drawable.ncaff),
            TickrModel(getString(R.string.madrid), R.drawable.madrid),
            TickrModel(getString(R.string.phi), R.drawable.phi),
            TickrModel(getString(R.string.ncaff), R.drawable.ncaff),
            TickrModel(getString(R.string.ncaff), R.drawable.ncaff),
            TickrModel(getString(R.string.ncaff), R.drawable.ncaff),
            TickrModel(getString(R.string.ncaff), R.drawable.ncaff),
        )
        binding.rvTickr.apply {
            val tickrAdapter = TickrAdapter()
            layoutManager =
                LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            setHasFixedSize(true)
            tickrAdapter.submitList(tickrItemList)
            adapter = tickrAdapter
        }
    }

    override fun onItemClickCallback(title: String) {
        println("Tapped on game : $title")
    }
}