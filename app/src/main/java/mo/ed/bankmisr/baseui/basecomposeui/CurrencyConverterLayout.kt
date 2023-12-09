package mo.ed.bankmisr.baseui.basecomposeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyConverterLayout(){
    Box(modifier = Modifier.padding(10.dp)){
        Spacer(modifier = Modifier.width(40.dp).height(2.dp).background(color = Color.Red))
    }
}