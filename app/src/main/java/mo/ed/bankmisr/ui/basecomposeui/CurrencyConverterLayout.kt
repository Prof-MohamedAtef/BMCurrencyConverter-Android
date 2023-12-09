package mo.ed.bankmisr.ui.basecomposeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyConverterLayout() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .width(60.dp)
            .height(30.dp)
            .background(color = Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Spacer(
            modifier = Modifier
                .width(40.dp)
                .height(2.dp)
                .background(color = Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyConverterPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        CurrencyConverterLayout()
    }
}