package com.karunadavanya.app.ui.guide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.karunadavanya.app.databinding.FragmentGuideBinding
import dagger.hilt.android.AndroidEntryPoint

import android.content.Intent
import android.net.Uri

@AndroidEntryPoint
class GuideFragment : Fragment() {

    private var _binding: FragmentGuideBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var adapter: GuideAdapter

    private val scenarios = listOf(
        GuideScenario(
            1,
            "Elephant enters your field",
            "1. Do not panic or throw stones.\n2. Do not use firecrackers, it may enrage the elephant.\n3. Turn on bright lights.\n4. Call the Forest Helpline immediately and keep a safe distance."
        ),
        GuideScenario(
            2,
            "Leopard near village",
            "1. Ensure all children are indoors before dusk.\n2. Lock up pets and livestock securely.\n3. Do not approach the leopard or corner it.\n4. Inform local authorities to set up camera traps."
        ),
        GuideScenario(
            3,
            "Tiger tracks sighted",
            "1. Avoid going alone into the forest fringes.\n2. Move in groups and make noise while walking.\n3. Do not try to track the tiger yourself.\n4. Report the pugmarks to the forest beat officer."
        ),
        GuideScenario(
            4,
            "Snake found in house",
            "1. Do not try to kill it. Most snakes are non-venomous.\n2. Keep an eye on it from a safe distance.\n3. Call a trained snake rescuer or the helpline.\n4. Keep doors open so it can exit on its own."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        adapter = GuideAdapter()
        binding.rvGuide.adapter = adapter
        adapter.submitList(scenarios)

        binding.btnHelpline.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:1926")
            }
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
