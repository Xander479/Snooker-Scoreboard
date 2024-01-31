package uk.co.xander479.snookerscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
  Column(
    modifier = Modifier
      .statusBarsPadding()
      .safeDrawingPadding(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    ScoreBug()
    Spacer(modifier = Modifier.padding(vertical = 15.dp))
    Button(onClick = { /*TODO*/ }) {
      Text(stringResource(R.string.foul))
    }
    PointsButton(1)
    PointsButtonRow(2, 3)
    PointsButtonRow(4, 5)
    PointsButtonRow(6, 7)
  }
}

@Composable
fun ScoreBug(modifier: Modifier = Modifier) {}

@Composable
fun PointsButton(pointsValue: Int, modifier: Modifier = Modifier) {
  Button(onClick = { /*TODO*/ }) {
    Text(pointsValue.toString())
  }
}

@Composable
fun PointsButtonRow(firstButton: Int, secondButton: Int, modifier: Modifier = Modifier) {
  Row {
    PointsButton(firstButton)
    PointsButton(secondButton)
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  SnookerScoreboardTheme {
    SnookerScoreboardLayout()
  }
}