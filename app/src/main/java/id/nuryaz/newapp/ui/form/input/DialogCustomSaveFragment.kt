package id.nuryaz.newapp.ui.form.input

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import id.nuryaz.newapp.R

class DialogCustomSaveFragment(val save:() -> Unit): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)


            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog_custom, null))
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}