package id.nuryaz.newapp.ui.form.input

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import id.nuryaz.newapp.R

class DialogSaveFragment(val save:() -> Unit): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.dialog_save_data)
                .setPositiveButton(R.string.button_save) { dialog, id ->
                    save()
                }
                .setNegativeButton(R.string.button_cancel) { dialog, id ->
                    // User cancelled the dialog
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}