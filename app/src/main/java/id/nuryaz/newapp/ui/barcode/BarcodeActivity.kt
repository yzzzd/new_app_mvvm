package id.nuryaz.newapp.ui.barcode

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import id.nuryaz.newapp.R
import id.nuryaz.newapp.data.constant.Constants
import id.nuryaz.newapp.ui.base.BaseActivity

class BarcodeActivity : BaseActivity<BarcodeViewModel>() {

    private lateinit var codeScannerView: CodeScannerView

    private var codeScanner: CodeScanner? = null

    private val REQUIRED_PERMISSIONS_CAMERA = arrayOf(Manifest.permission.CAMERA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode)

        codeScannerView = findViewById(R.id.barcodeView)

        codeScanner = CodeScanner(this, codeScannerView)

        if (cameraGranted()) {
            startCamera()
        } else {
            requestPermission()
        }
    }

    override fun onResume() {
        super.onResume()
        if (cameraGranted()) {
            codeScanner?.startPreview()
        }
    }

    override fun onPause() {
        if (cameraGranted()) {
            codeScanner?.releaseResources()
        }
        super.onPause()
    }

    private fun startCamera() {
        codeScanner?.camera = CodeScanner.CAMERA_BACK
        codeScanner?.formats = CodeScanner.ALL_FORMATS
        codeScanner?.autoFocusMode = AutoFocusMode.SAFE
        codeScanner?.scanMode = ScanMode.SINGLE
        codeScanner?.isAutoFocusEnabled = true
        codeScanner?.isFlashEnabled = false

        codeScanner?.decodeCallback = DecodeCallback { result ->
            runOnUiThread { sendResult(result.text) }
        }

        codeScanner?.errorCallback = ErrorCallback { error ->
            Log.d("barcode", "Camera initialization error, please try again (${error.localizedMessage})")
        }
    }

    private fun sendResult(value: String) {
        Log.d("barcode", value)
        intent.putExtra(Constants.INTENT.KEY_DATA, value)
        setResult(300, intent)
        finish()
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS_CAMERA, 100)
    }

    private fun cameraGranted() = REQUIRED_PERMISSIONS_CAMERA.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 100) {
            if (cameraGranted()) {
                startCamera()
            } else {
                requestPermission()
            }
        }
    }
}