package com.soupflies.keepr.ui.addNewPassword


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.soupflies.keepr.R
import com.soupflies.keepr_mpp.serialized.Account
import com.soupflies.keepr_mpp.ui.presenters.AddNewPasswordPresenter
import com.soupflies.keepr_mpp.ui.viewModels.AddNewPasswordViewModel
import com.soupflies.keepr_mpp.ui.views.AddNewPasswordView
import kotlinx.android.synthetic.main.fragment_signup.*

class AddNewPasswordFragment : Fragment(), AddNewPasswordView {
    private val viewModel = AddNewPasswordViewModel
    private val presenter = AddNewPasswordPresenter(this, viewModel)

    private var account: Account? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { return inflater.inflate(R.layout.fragment_add_new_password, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleCheck = arguments?.getString("title")
        val passwordCheck = arguments?.getString("password")
        if (titleCheck != null && passwordCheck != null) {
            account = Account (
                title = titleCheck,
                username = arguments?.getString("username"),
                email = arguments?.getString("email"),
                password = passwordCheck,
                website = arguments?.getString("website"),
                notes = arguments?.getString("notes")
            )
        }

        presenter.saveInitialAccount(account)
    }

    override fun onPause() {
        super.onPause()

        presenter.saveUpdatedAccount(account)

    }

    override fun navigateToPasswordVault() {
        findNavController().popBackStack()
    }

    override fun alertUser(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
