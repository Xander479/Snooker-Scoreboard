package uk.co.xander479.snookerscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.xander479.snookerscoreboard.ui.theme.SnookerScoreboardTheme

class MainActivity: ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setContent {
      SnookerScoreboardTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          SnookerScoreboardLayout()
        }
      }
    }
  }
}

@Composable
fun SnookerScoreboardLayout() {
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  SnookerScoreboardTheme {
    SnookerScoreboardLayout()
  }
}