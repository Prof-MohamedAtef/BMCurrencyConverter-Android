package mo.ed.bankmisr.features.fromto.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import mo.ed.bankmisr.ui.views.fragments.BaseFragment
import mo.ed.bankmisr.features.fromto.screens.fromToScreen
import mo.ed.bankmisr.features.fromto.viewmodels.FromToViewModel

@AndroidEntryPoint
class FromToFragment : BaseFragment() {
    private val fromToViewModel: FromToViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fromToViewModel.getCurrencies()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                fromToScreen(fromToInterface = this@FromToFragment)
            }
        }
    }
}