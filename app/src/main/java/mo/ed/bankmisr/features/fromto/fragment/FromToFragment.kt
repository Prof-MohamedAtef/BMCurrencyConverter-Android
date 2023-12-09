package mo.ed.bankmisr.features.fromto.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import mo.ed.bankmisr.baseui.views.fragments.BaseFragment
import mo.ed.bankmisr.features.fromto.screens.fromToScreen

class FromToFragment : BaseFragment() {
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