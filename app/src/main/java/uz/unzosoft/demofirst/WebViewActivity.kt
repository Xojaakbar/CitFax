package uz.unzosoft.demofirst

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import uz.unzosoft.demofirst.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        webView = binding.webView
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://google.com/")
        webView.settings.setAppCacheEnabled(true)
        webView.settings.javaScriptEnabled = true

    }
}