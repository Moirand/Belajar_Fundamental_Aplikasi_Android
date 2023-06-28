package com.example.myflexiblefragment

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = "Home Fragment"

        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_category) {
            val mCategoryFragment = CategoryFragment()

            parentFragmentManager
                .beginTransaction()
                .apply {
                    replace(
                        R.id.frame_container,
                        mCategoryFragment,
                        CategoryFragment::class.java.simpleName
                    )
                    addToBackStack(null)
                    commit()
                }
        }
    }
}