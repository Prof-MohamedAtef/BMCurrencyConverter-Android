package mo.ed.bankmisr.features.fromtofeature.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mo.ed.bankmisr.ui.basecomposeui.CurrencyConverterLayout
import mo.ed.bankmisr.ui.basecomposeui.DropDownMenuLayout
import mo.ed.bankmisr.features.fromtofeature.fragment.FromToFragment

@Composable
fun fromToScreen(
    fromToInterface: FromToFragment? = null,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color(0xFFFFFFFF))
            .padding(top = 100.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
//                .clickable {
//                    loginScreenInterface?.onBackPressed()
//                },
            ) {
                DropDownMenuLayout(
                    list = listOf(
                        "Americano",
                        "Cappuccino",
                        "Espresso",
                        "Latte",
                        "Mocha"
                    )
                )
                CurrencyConverterLayout()
                DropDownMenuLayout(
                    list = listOf(
                        "Americano",
                        "Cappuccino",
                        "Espresso",
                        "Latte",
                        "Mocha"
                    )
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLoginFunction() {
    Surface(modifier = Modifier.fillMaxSize()) {
        fromToScreen()
    }
}