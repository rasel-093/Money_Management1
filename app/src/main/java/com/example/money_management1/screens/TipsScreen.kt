import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.money_management1.components.TopBar

@Composable
fun TipsScreen(paddingValues: PaddingValues) {
    Scaffold(
        topBar = { TopBar(title = "Tips")},
        modifier = Modifier.padding(paddingValues)
    ) {innerPadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TipsRow(text = "Tips row test")
            TipsRow(text = "Tips row test")
            TipsRow(text = "Tips row test")
            TipsRow(text = "Tips row test")
            TipsRow(text = "Tips row test")
        }
    }
}

@Composable
fun TipsRow(text: String) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth().padding(5.dp)
    ) {
        Text(text = text)
    }
}