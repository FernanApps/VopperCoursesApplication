package presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun IconButtonBack(modifier: Modifier = Modifier, containerColor: Color? = null, onBack: () -> Unit) {
    IconButton(
        onClick = {
            onBack()
        },
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = containerColor ?: IconButtonDefaults.iconButtonColors().containerColor
        ),
    ) {
        Icon(imageVector = Icons.Filled.ArrowBackIosNew, "ArrowBackIosNew")
    }
}