package uk.co.xander479.snookerscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
  var player1Score by remember { mutableIntStateOf(0) }
  var player2Score by remember { mutableIntStateOf(0) }

  var isPlayer1Turn by remember { mutableStateOf(true) }
  var isFoul by remember { mutableStateOf(false) }

  val onPointsButtonPress = { pointsValue: Int ->
    if(isPlayer1Turn) {
      if(isFoul) player2Score += pointsValue else player1Score += pointsValue
    }
    else {
      if(isFoul) player1Score += pointsValue else player2Score += pointsValue
    }
  }

  Column(
    modifier = Modifier
      .statusBarsPadding()
      .safeDrawingPadding(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    ScoreBug(
      player1Score,
      player2Score,
      isPlayer1Turn,
      onclick = { isPlayer1Turn = !isPlayer1Turn })
    Spacer(modifier = Modifier.padding(vertical = 15.dp))
    Button(onClick = { /*TODO*/ }) {
      Text(stringResource(R.string.foul))
    }
    PointsButton(1, onPointsButtonPress)
    PointsButtonRow(2, 3, onPointsButtonPress)
    PointsButtonRow(4, 5, onPointsButtonPress)
    PointsButtonRow(6, 7, onPointsButtonPress)
  }
}

@Composable
fun ScoreBug(
  player1Score: Int,
  player2Score: Int,
  isPlayer1Turn: Boolean,
  onclick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .background(Color.Blue),
    horizontalArrangement = Arrangement.SpaceAround,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Row {
      Text("Player 1")
      Text(player1Score.toString())
    }
    Button(onClick = onclick) {
      if(isPlayer1Turn) Text("P1") else Text("P2")
    }
    Row {
      Text(player2Score.toString())
      Text("Player 2")
    }
  }
}

@Composable
fun PointsButton(
  pointsValue: Int,
  onclick: (Int) -> Unit,
  modifier: Modifier = Modifier
) {
  Button(onClick = { onclick(pointsValue) }) {
    Text(pointsValue.toString())
  }
}

@Composable
fun PointsButtonRow(
  firstButton: Int,
  secondButton: Int,
  onclick: (Int) -> Unit,
  modifier: Modifier = Modifier
) {
  Row {
    PointsButton(firstButton, onclick)
    PointsButton(secondButton, onclick)
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  SnookerScoreboardTheme {
    SnookerScoreboardLayout()
  }
}