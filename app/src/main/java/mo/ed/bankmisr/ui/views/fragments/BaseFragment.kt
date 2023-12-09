package mo.ed.bankmisr.ui.views.fragments

import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import mo.ed.ristoranti.base.loader.LoadingDialog

abstract class BaseFragment : Fragment() {

    private var loading = LoadingDialog()

    fun showSnackBar(
        text: String,
        imageResourceId: Int? = null,
        length: Int = Snackbar.LENGTH_SHORT
    ) {
        try {
            if (imageResourceId != null) {
                val spannableStringBuilder = SpannableStringBuilder()
                spannableStringBuilder
                    .append("    $text")
                    .setSpan(ImageSpan(requireContext(), imageResourceId), 0, 1, 0)

                Snackbar.make(requireView(), spannableStringBuilder, length).show()
            } else {
                Snackbar.make(requireView(), text, length).show()
            }
        } catch (illegalStateException: IllegalStateException) {
            illegalStateException.message?.let { Log.e("Ex:", it) }
        }
    }

    fun showAnimatedLoading() {
        if (isAdded && activity != null) {
            this.childFragmentManager.executePendingTransactions()
            if (!loading.isAdded) {
                loading.show(this.childFragmentManager, "LOADING")
            }
        }
    }

    fun hideAnimatedLoading() {
        if (loading.isAdded) {
            loading.dismissAllowingStateLoss()
        }
    }
}