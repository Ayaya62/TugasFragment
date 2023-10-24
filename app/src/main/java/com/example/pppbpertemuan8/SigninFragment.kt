package com.example.pppbpertemuan8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pppbpertemuan8.databinding.FragmentSigninBinding
import java.net.Authenticator

class SigninFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSigninBinding.inflate(inflater, container, false)
        val button: Button = binding.buttonSignIn

        with(binding) {
            val mainActivity = requireActivity() as MainActivity
            button.setOnClickListener {
                val username = editTextUsername.text.toString()
                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()
                val password = editTextPassword.text.toString()

                if (username.isEmpty() ||
                    email.isEmpty() ||
                    phone.isEmpty() ||
                    password.isEmpty()
                ) {
                    makeText(
                        requireContext(),
                        "Tolong isi data dengan tepat.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (
                    !checkboxTnc.isChecked
                ){
                    makeText(requireContext(),
                        "Cek box term and coditions.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val bundle = Bundle()
                    bundle.putString("username", username)
                    bundle.putString("password", password)

                    val adapter = mainActivity.viewPager2.adapter as FragmentStateAdapter
                    val loginFragment = adapter.createFragment(1) as LoginFragment
                    loginFragment.arguments = bundle
                    mainActivity.toLoginPage()

                    makeText(requireContext(),
                        "Registrasi Berhasil",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return binding.root
    }
}