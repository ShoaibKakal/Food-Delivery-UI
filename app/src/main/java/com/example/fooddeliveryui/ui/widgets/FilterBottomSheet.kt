import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddeliveryui.ui.screens.ItemFilter
import com.example.fooddeliveryui.ui.theme.FoodDeliveryUITheme
import com.example.fooddeliveryui.ui.theme.Green
import com.example.fooddeliveryui.ui.theme.PaleOrange100
import com.example.fooddeliveryui.ui.theme.PaleOrange40
import com.example.fooddeliveryui.ui.theme.PaleOrange60
import com.example.fooddeliveryui.ui.util.TextStyles


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun FilterBottomSheet(onBottomSheetClose: () -> Unit) {
    var sliderValues by remember {
        mutableStateOf(1f..20f) // pass the initial values
    }
    Column(
        modifier = Modifier.padding(32.dp)
    ) {
        Text(
            text = "Price",
            style = TextStyles.txtSansSerifRegular15DarkBlue()
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Box(modifier = Modifier.padding(horizontal = 10.dp)) {
            RangeSlider(
                value = sliderValues,
                onValueChange = { sliderValues_ ->
                    sliderValues = sliderValues_
                },
                steps = 20,
                valueRange = 1f..20f,
                onValueChangeFinished = {
                    // this is called when the user completed selecting the value
                },
                colors = SliderDefaults.colors(
                    thumbColor = PaleOrange100,
                    activeTickColor = PaleOrange100,
                    inactiveTickColor = PaleOrange60,
                    activeTrackColor = PaleOrange100,
                )
            )
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = "Type",
            style = TextStyles.txtSansSerifRegular15DarkBlue()
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ItemFilter(filter = "Restaurant") {
            }
            ItemFilter(filter = "Menu") {
            }
        }

        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = "Location",
            style = TextStyles.txtSansSerifRegular15DarkBlue()
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ItemFilter(filter = "1 Km") {
            }
            ItemFilter(filter = ">10 Km") {
            }
            ItemFilter(filter = "<>>10 Km") {
            }
        }

        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = "Category",
            style = TextStyles.txtSansSerifRegular15DarkBlue()
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))

        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Fixed(2), content = {
                items(
                    items = listOf(
                        "Cake",
                        "Soup",
                        "Main Course",
                        "Appetizer",
                        "Dessert",
                        "Dessert"
                    ), itemContent = {
                        ItemFilter(filter = it) {
                        }
                    })
            },
            state = rememberLazyStaggeredGridState(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalItemSpacing = 10.dp,
            modifier = Modifier.height(110.dp)
        )


        Spacer(modifier = Modifier.padding(top = 60.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(57.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Green.copy(alpha = 0.65f),
                            Green,
                        )
                    ), shape = RoundedCornerShape(15.dp)
                )
                .height(ButtonDefaults.MinHeight),
            onClick = {
                onBottomSheetClose()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        ) {
            Text("Search", style = TextStyles.txtSansSerifRegular14White())
        }
    }
}


@Preview
@Composable
fun FilterBottomSheetPreview() {
    FoodDeliveryUITheme {
        FilterBottomSheet({})
    }
}
