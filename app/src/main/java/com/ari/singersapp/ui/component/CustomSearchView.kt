package com.ari.singersapp.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.ari.singersapp.R
import com.ari.singersapp.databinding.ViewCustomSearchBinding


class CustomSearchView : LinearLayout {
    constructor(ctx: Context) : super(ctx) {
        initialize()
    }

    constructor(ctx: Context, atts: AttributeSet?) : super(ctx, atts) {
        initialize()
    }

    private var listener: OnSearchListener? = null
    private lateinit var binding: ViewCustomSearchBinding

    interface OnSearchListener {
        //In this case we have two messages,
        //the first that is sent when the process is successful.
        fun onSearchResults(textData: String)

        //And The second message, when the process will fail.
        fun onDeleteText()

    }

    fun setOnSearchListener(listener: OnSearchListener?) {
        this.listener = listener
    }

    //This is the recommended option to initialize, it allows a better customization and optimization
    private fun initialize() {
        //First, we create the interface from layout
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.view_custom_search, this, false)
        binding = ViewCustomSearchBinding.inflate(layoutInflater, this, true)


        //Obtain the references to child views
        binding.apply {
            imageViewDeleteSearch.setOnClickListener {
                editTextSearch.text.clear()
                listener?.onDeleteText()
            }

            editTextSearch.doAfterTextChanged { text ->
                text?.let {
                    if (text.isNotEmpty()) {
                        imageViewDeleteSearch.visibility = VISIBLE
                        enableSearchButton(buttonSearch)
                    } else {
                        imageViewDeleteSearch.visibility = GONE
                        disableSearchButton(buttonSearch)
                        listener?.onDeleteText()
                    }
                }
            }

            buttonSearch.setOnClickListener { listener?.onSearchResults(editTextSearch.text.toString()) }
        }


    }

    private fun enableSearchButton(view: Button) {
        view.apply {
            isEnabled = true
            setTextColor(ContextCompat.getColor(view.context, R.color.white))
        }
    }

    private fun disableSearchButton(view: Button) {
        view.apply {
            isEnabled = false
            setTextColor(ContextCompat.getColor(view.context, R.color.darkGrey))
        }
    }

}